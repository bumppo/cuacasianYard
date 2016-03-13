package service;

import javassist.NotFoundException;
import model.User;
import org.springframework.transaction.annotation.Transactional;
import to.TOUser;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by VMoskalik on 03.03.2016.
 */
public interface UserService {

    User save(User user);

    void update (User user);

    TOUser get(int id);

    void delete(int id);

    List<User> getAll();
}
