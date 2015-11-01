package service;

import dto.UserDTO;

public interface UserService {
    void registerUser(UserDTO userDto);
    int loginUser(UserDTO userDto);
    void logoutUser(UserDTO userDto);
}
