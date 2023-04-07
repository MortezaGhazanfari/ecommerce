package com.example.ecommerce.entity;

import com.example.ecommerce.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user",
            fetch = FetchType.LAZY)
    private List<Order> orders;
}
