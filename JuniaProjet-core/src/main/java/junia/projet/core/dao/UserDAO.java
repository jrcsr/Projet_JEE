package junia.projet.core.dao;

import junia.projet.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User,Long> {

    User findById (long id);

    User findByUsername(@Param("username") String username);

    Boolean existsUserByUsername(@Param("username") String username);
}
