package junia.projet.core.dao;


import junia.projet.core.entity.DownloadLink;
import junia.projet.core.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DownloadLinkDAO extends JpaRepository<DownloadLink,Long> {

    List<DownloadLink> findAllByWallpaperIdAndFormatAccessProfileListContaining(Long id,Profile profile);

    DownloadLink findById (long id);
}
