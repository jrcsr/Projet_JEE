package junia.projet.core.dao;


import junia.projet.core.entity.DownloadLink;
import junia.projet.core.entity.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DownloadLinkDAO extends CrudRepository<DownloadLink,Long> {

    DownloadLink findByFormatAccessProfileListContainingAndIdEquals(Profile profile,long id);

    DownloadLink findById (long id);
}
