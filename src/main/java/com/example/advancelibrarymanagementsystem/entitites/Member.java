package com.example.advancelibrarymanagementsystem.entitites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(indexes = {
        @Index(name = "idx_member_email",columnList = "email"),
        @Index(name = "idx_member_phoneNumber",columnList = "phoneNumber")
})
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(unique = true,nullable = false)
    private String phoneNumber;

    private LocalDate membershipStartDate;
}
