package junia.projet.core.service;

import junia.projet.core.dao.UserDAO;
import junia.projet.core.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void save(User user){
        userDAO.save(user);
    }

    public User getById(long id){
        return userDAO.findById(id);
    }

    public Boolean userExist(String name){
        return userDAO.existsUserByUsername(name);
    }

    public User getUserByUsername(String name){
        return userDAO.findByUsername(name);
    }

    public void deleteAll(){
        userDAO.deleteAll();
    }
}
