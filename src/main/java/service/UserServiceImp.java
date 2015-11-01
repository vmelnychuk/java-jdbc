package service;

import domain.User;
import dto.UserDTO;
import org.apache.log4j.Logger;
import repository.UserDAO;
import repository.exeption.UserException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImp implements UserService {
    private final Logger logger = Logger.getLogger(UserServiceImp.class);

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private User currentUser;
    private List<User> loggedUser = new ArrayList<User>();

    @Override
    public void registerUser(UserDTO userDto) {
        currentUser.setEmail(userDto.getEmail());
        currentUser.setPassword(userDto.getPassword());
        try {
            userDAO.create(currentUser);
        } catch (UserException ex) {
            logger.warn(ex.getMessage());
        }
    }

    @Override
    public int loginUser(UserDTO userDto) {
        currentUser.setEmail(userDto.getEmail());
        currentUser.setPassword(userDto.getPassword());
        try {
            currentUser = userDAO.get(currentUser);
            loggedUser.add(currentUser);
            return loggedUser.indexOf(currentUser);
        } catch (UserException ex) {
            logger.warn(ex.getMessage());
            return -1;
        }
    }

    @Override
    public void logoutUser(UserDTO userDto) {
        currentUser.setEmail(userDto.getEmail());
        currentUser.setPassword(userDto.getPassword());
        try {
            currentUser = userDAO.get(currentUser);
            loggedUser.remove(currentUser);
        } catch (UserException ex) {
            logger.warn(ex.getMessage());
        }
    }
}
