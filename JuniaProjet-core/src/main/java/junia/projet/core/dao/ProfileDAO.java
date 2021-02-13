package junia.projet.core.dao;

import junia.projet.core.entity.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileDAO extends CrudRepository<Profile,Long> {

    Profile findById (long id);
}
