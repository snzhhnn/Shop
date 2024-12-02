package com.fialka.contract;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserDTO {
    private UUID id;
    private String lastname;
    private String firstname;
    private String surname;
    private String username;
    private String phoneNumber;
    private String gender;
    private String address;
    private String email;
    private Byte photo;
}