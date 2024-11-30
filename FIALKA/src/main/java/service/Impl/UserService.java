package service.Impl;

import contract.UserDTO;
import contract.mapper.UserMapper;
import lombok.AllArgsConstructor;
import model.User;
import repository.IUserRepository;
import service.IUserService;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class UserService implements IUserService {

    private IUserRepository repository;

    @Override
    public UserDTO getByID(UserDTO userDTO) {
        return UserMapper.toDTO(repository.getByID(UserMapper.toEntity(userDTO)));
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        return UserMapper.toDTO(repository.save(UserMapper.toEntity(userDTO)));
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return UserMapper.toDTO(repository.update(UserMapper.toEntity(userDTO)));
    }

    @Override
    public UserDTO delete(UserDTO userDTO) {
        return UserMapper.toDTO(repository.delete(UserMapper.toEntity(userDTO)));
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = repository.findAll();
        return users.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> filter() {
        return null;
    }
}
