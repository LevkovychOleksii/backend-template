package com.example.demo.entity;
import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "userok")
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Userok {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}
