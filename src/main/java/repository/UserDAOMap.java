package repository;

import domain.User;
import org.springframework.stereotype.Repository;
import repository.exeption.UserException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository("userDao")
public class UserDAOMap implements UserDAO {
    Map<String, User> users = new HashMap<String, User>();

    @Override
    public void create(User user) {
        User stored = users.get(user.getEmail());
        if (stored == null) {
            users.put(user.getEmail(), user);
        } else {
            throw new UserException("user with " + user.getEmail() + " is exists");
        }
    }

    @Override
    public Collection<User> getAll() {
        return users.values();
    }

    @Override
    public User get(User user) {
        User stored = users.get(user.getEmail());
        if (stored == null) {
            throw new UserException("user with " + user.getEmail() + " doesn't exits");
        }
        if (!stored.getPassword().equals(user.getPassword())) {
            throw new UserException("user with " + user.getEmail() + " has different password");
        }
        return stored;
    }

    @Override
    public void update(User user) {
    }

    @Override
    public void delete(User user) {

    }
}
