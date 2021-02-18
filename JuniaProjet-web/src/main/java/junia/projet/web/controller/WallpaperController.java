package junia.projet.web.controller;

import com.sun.xml.bind.v2.TODO;
import junia.projet.core.service.DownloadLinkService;
import junia.projet.core.service.ProfileService;
import junia.projet.core.service.WallpaperService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WallpaperController {

    private WallpaperService wallpaperService;
    private DownloadLinkService downloadLinkService;
    private ProfileService profileService;

    public WallpaperController(WallpaperService wallpaperService, DownloadLinkService downloadLinkService, ProfileService profileService) {
        this.wallpaperService = wallpaperService;
        this.downloadLinkService = downloadLinkService;
        this.profileService = profileService;
    }

    // TODO
    //récupérer le profile de l'utilisateur
    @RequestMapping(value= "/wallpaper",method= RequestMethod.GET)
    private String getListOfWallpapers (ModelMap modelMap){
        modelMap.put("wallpapers",wallpaperService.getWallpaperByProfile(profileService.getById(309)));
        modelMap.put("otherWallpapers",wallpaperService.getWallpaperByProfileMissing(profileService.getById(309)));
        return "wallpaperList";
    }

    @RequestMapping(value = "/wallpaper/{id}/downloadLinks", method = RequestMethod.GET)
    private String deleteCompany(@PathVariable("id") long id, ModelMap modelMap){
        modelMap.put("downloadLinks",downloadLinkService.getDownloadLinkByWallpaperIdAndProfile(id,profileService.getById(309)));
        return "downloadLinksList";
    }

}
