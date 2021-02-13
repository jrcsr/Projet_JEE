package junia.projet.core.junia.projet.core.service;

import junia.projet.core.dao.WallpaperDAO;
import junia.projet.core.entity.Profile;
import junia.projet.core.entity.Wallpaper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WallpaperService {
    private WallpaperDAO wallpaperDAO;

    public WallpaperService(WallpaperDAO wallpaperDAO) {
        this.wallpaperDAO = wallpaperDAO;
    }

    public List<Wallpaper> getWallpaperByProfile(Profile profile){
        return wallpaperDAO.findAllByAccessProfileListContaining(profile);
    }

    public void save(Wallpaper wallpaper){
        wallpaperDAO.save(wallpaper);
    }

    public Wallpaper getById(long id){
        return wallpaperDAO.findById(id);
    }

    public void deleteAll(){
        wallpaperDAO.deleteAll();
    }
}
