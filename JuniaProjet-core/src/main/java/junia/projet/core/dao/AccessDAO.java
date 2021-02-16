package junia.projet.core.dao;

import junia.projet.core.entity.Access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccessDAO extends JpaRepository<Access,Long> {

    Access findById (long id);

    @Override
    void deleteAll();
}
