package junia.projet.web.controller;

import com.sun.xml.bind.v2.TODO;
import junia.projet.core.entity.User;
import junia.projet.core.service.DownloadLinkService;
import junia.projet.core.service.ProfileService;
import junia.projet.core.service.UserService;
import junia.projet.core.service.WallpaperService;
import junia.projet.web.security.UserDetailsImpl;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WallpaperController {

    private WallpaperService wallpaperService;
    private DownloadLinkService downloadLinkService;
    private UserService userService;


    public WallpaperController(WallpaperService wallpaperService, DownloadLinkService downloadLinkService, UserService userService) {
        this.wallpaperService = wallpaperService;
        this.downloadLinkService = downloadLinkService;
        this.userService = userService;

    }

    // TODO
    //récupérer le profile de l'utilisateur
    @RequestMapping(value= "/wallpaper",method= RequestMethod.GET)
    private String getListOfWallpapers (ModelMap modelMap){
        UserDetailsImpl connectedUser = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user=userService.getUserByUsername(connectedUser.getUsername());
        modelMap.put("wallpapers",wallpaperService.getWallpaperByProfile(user.getProfile()));
        modelMap.put("otherWallpapers",wallpaperService.getWallpaperByProfileMissing(user.getProfile()));
        return "wallpaperList";
    }

    @RequestMapping(value = "/wallpaper/{id}/downloadLinks", method = RequestMethod.GET)
    private String getListOfLinks(@PathVariable("id") long id, ModelMap modelMap){
        UserDetailsImpl connectedUser = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        modelMap.put("downloadLinks",downloadLinkService.getDownloadLinkByWallpaperIdAndProfile(id,userService.getUserByUsername(connectedUser.getUsername()).getProfile()));
        return "downloadLinksList";
    }

}
