package junia.projet.core.dao;

import junia.projet.core.entity.Access;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccessDAO extends CrudRepository<Access,Long> {

    Access findById (long id);

}
