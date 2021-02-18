package junia.projet.core.dao;


import junia.projet.core.entity.DownloadLink;
import junia.projet.core.entity.Profile;
import junia.projet.core.entity.Wallpaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WallpaperDAO extends JpaRepository<Wallpaper,Long> {

    List<Wallpaper> findAllByAccessProfileListContaining(Profile profile);
    List<Wallpaper> findAllByAccessProfileListIsNotContaining(Profile profile);

    Wallpaper findById (long id);




}
