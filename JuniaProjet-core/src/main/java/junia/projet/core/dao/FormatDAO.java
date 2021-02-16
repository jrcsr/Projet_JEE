package junia.projet.core.dao;

import junia.projet.core.entity.Format;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormatDAO extends JpaRepository<Format,Long> {

    Format findById (long id);



}
