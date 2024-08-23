package com.example.advancelibrarymanagementsystem.entitites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
        @Index(name = "idx_libraryStaff_email",columnList = "email"),
        @Index(name = "idx_libraryStaff_role",columnList = "role")

})
public class LibraryStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String phoneNumber;
}
