package com.example.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private @NotBlank String categoryName;

    private @NotBlank String description;

    private @NotBlank String imageUrl;

    // add imageURL here

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    Set<Product> products;
}
