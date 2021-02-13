package junia.projet.core.dao;

import junia.projet.core.entity.Format;
import org.springframework.data.repository.CrudRepository;

public interface FormatDAO extends CrudRepository<Format,Long> {

    Format findById (long id);



}
