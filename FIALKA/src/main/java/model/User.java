package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String lastname;
    private String firstname;
    private String surname;
    private String password;
    private String username;
    private String phoneNumber;
    private String gender;
    private String address;
    private String email;
    private Byte photo;

    @OneToMany
    private List<Order> orders;
}