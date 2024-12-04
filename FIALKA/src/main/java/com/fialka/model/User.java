package com.fialka.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "\"user\"")
public class User {
    @Id
    private UUID id;
    private String lastname;
    private String firstname;
    private String surname;
    private String password;
    private String username;
    private LocalDate birthdate;
    private String phoneNumber;
    private String gender;
    private String address;
    private String email;
    private Byte photo;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<Ordering> orders;
}