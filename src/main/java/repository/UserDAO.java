package repository;

import domain.User;

import java.util.Collection;

public interface UserDAO {
    void create(User user);
    Collection<User> getAll();
    User get(User user);
    void update(User user);
    void delete(User user);
}
