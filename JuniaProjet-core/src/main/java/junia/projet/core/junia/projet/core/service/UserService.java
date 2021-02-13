package junia.projet.core.junia.projet.core.service;

import junia.projet.core.dao.UserDAO;
import junia.projet.core.entity.User;

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

    public void deleteAll(){
        userDAO.deleteAll();
    }
}
