package contract.mapper;

import contract.UserDTO;
import model.User;

public class UserMapper {
    public static User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        return User.builder()
                .id(userDTO.getId())
                .lastname(userDTO.getLastname())
                .firstname(userDTO.getFirstname())
                .surname(userDTO.getSurname())
                .username(userDTO.getUsername())
                .phoneNumber(userDTO.getPhoneNumber())
                .gender(userDTO.getGender())
                .address(userDTO.getAddress())
                .email(userDTO.getEmail())
                .photo(userDTO.getPhoto())
                .build();
    }

    public static UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }

        return UserDTO.builder()
                .id(user.getId())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .surname(user.getSurname())
                .username(user.getUsername())
                .phoneNumber(user.getPhoneNumber())
                .gender(user.getGender())
                .address(user.getAddress())
                .email(user.getEmail())
                .photo(user.getPhoto())
                .build();
    }
}