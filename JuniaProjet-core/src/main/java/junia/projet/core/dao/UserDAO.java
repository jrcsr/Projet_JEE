package junia.projet.core.dao;

import junia.projet.core.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User,Long> {

    User findById (long id);
}
