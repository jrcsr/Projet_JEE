package junia.projet.core.dao;


import junia.projet.core.entity.DownloadLink;
import junia.projet.core.entity.Profile;
import junia.projet.core.entity.Wallpaper;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WallpaperDAO extends CrudRepository<Wallpaper,Long> {

    List<Wallpaper> findAllByAccessProfileListContaining(Profile profile);

    Wallpaper findById (long id);




}
