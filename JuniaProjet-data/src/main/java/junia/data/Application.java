package junia.data;

import junia.projet.core.entity.*;
import junia.projet.core.service.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.*;

public class Application {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("junia.projet.core.config");
        final AccessService accessService=context.getBean(AccessService.class);
        final DownloadLinkService downloadLinkService=context.getBean(DownloadLinkService.class);
        final FormatService formatService=context.getBean(FormatService.class);
        final ProfileService profileService=context.getBean(ProfileService.class);
        final UserService userService=context.getBean(UserService.class);
        final WallpaperService wallpaperService=context.getBean(WallpaperService.class);
        cleanDB(accessService,downloadLinkService,formatService,profileService,userService,wallpaperService);
        final Map<String, Profile> profileMap= registerProfiles(profileService);
        final Map<String, User> userMap=registerUser(userService,profileMap);
        final Map<String, Access> accessMap=registerAccess(accessService,profileMap);
        final Map<String, Format> formatMap=registerFormat(formatService,accessMap);
        final Map<String, Wallpaper> wallpaperMap=registerWallpaper(wallpaperService,accessMap);
        final Map<String, DownloadLink> downloadLinkMap=registerDownloadLink(downloadLinkService,formatMap,wallpaperMap);
    }

    private static void cleanDB(final AccessService accessService, final DownloadLinkService downloadLinkService, final FormatService formatService, final ProfileService profileService,UserService userService,WallpaperService wallpaperService) {
        wallpaperService.deleteAll();
        downloadLinkService.deleteAll();
        formatService.deleteAll();
        accessService.deleteAll();
        userService.deleteAll();
        profileService.deleteAll();
    }


    private static Map<String, Profile> registerProfiles(final ProfileService profileService) {
        Map<String, Profile> profileList = new HashMap<>();
        profileList.put("free", createProfile("Free", profileService));
        profileList.put("basic", createProfile("Basic", profileService));
        profileList.put("premium", createProfile("Premium", profileService));
        return profileList;
    }


    private static Profile createProfile(String profileName, final ProfileService profileService) {
        System.out.println("Registring " + profileName);
        Profile profile = new Profile();
        profile.setProfileName(profileName);
        profileService.save(profile);
        return profile;
    }

    private static Map<String, Access> registerAccess(final AccessService accessService,final Map<String, Profile> profilesList){
        Map<String, Access> accessList = new HashMap<>();
        accessList.put("freeAccess",createAccess("FreeAccess",Arrays.asList(profilesList.get("free"),profilesList.get("basic"),profilesList.get("premium")),accessService));
        accessList.put("basicAccess",createAccess("BasicAccess",Arrays.asList(profilesList.get("basic"),profilesList.get("premium")),accessService));
        accessList.put("premiumAccess",createAccess("PremiumAccess",Arrays.asList(profilesList.get("premium")),accessService));
        return accessList;

    }

    private static Access createAccess(String accessName, final List<Profile> profileList, final AccessService accessService) {
        System.out.println("Registring " + accessName);
        Access access = new Access();
        access.setAccessName(accessName);
        access.setProfileList(profileList);
        accessService.save(access);
        return access;
    }

    private static Map<String, Format> registerFormat(final FormatService formatService,final Map<String, Access> accessList) {
        Map<String, Format> formatList = new HashMap<>();
        formatList.put("1920x1200",createFormat("1920x1200",accessList.get("freeAccess"),formatService));
        formatList.put("1680x1050",createFormat("1680x1050",accessList.get("basicAccess"),formatService));
        formatList.put("1440x900",createFormat("1440x900",accessList.get("basicAccess"),formatService));
        formatList.put("1280x800",createFormat("1280x800",accessList.get("basicAccess"),formatService));
        return formatList;
    }


    private static Format createFormat(String formatName, final Access access, final FormatService formatService) {
        System.out.println("Registring " + formatName);
        Format format = new Format();
        format.setFormatName(formatName);
        format.setAccess(access);
        formatService.save(format);
        return format;
    }

    private static Map<String, User> registerUser(final UserService userService,final Map<String, Profile> profileList) {
        Map<String, User> userList = new HashMap<>();
        userList.put("henriPotier",createUser("HenriPotier","1234",profileList.get("free"),userService));
        userList.put("lucasCielmarcheur",createUser("LucasCielmarcheur","1234",profileList.get("basic"),userService));
        userList.put("indianaJean",createUser("IndianaJean","1234",profileList.get("premium"),userService));
        return userList;
    }

    private static User createUser(String userName, String password, final Profile profile, final UserService userService) {
        System.out.println("Registring " + userName);
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        user.setProfile(profile);
        userService.save(user);
        return user;
    }

    private static Map<String, DownloadLink> registerDownloadLink(final DownloadLinkService downloadLinkService,final Map<String, Format> formatList,final Map<String, Wallpaper> wallpaperList) {
        Map<String, DownloadLink> downloadLinkList = new HashMap<>();
        downloadLinkList.put("wallpaper1Link1",createDownloadLink("Wallpaper1Link1",formatList.get("1920x1200"),downloadLinkService,wallpaperList.get("wallpaper1")));
        downloadLinkList.put("wallpaper2Link1",createDownloadLink("Wallpaper2Link1",formatList.get("1920x1200"),downloadLinkService,wallpaperList.get("wallpaper2")));
        downloadLinkList.put("wallpaper3Link1",createDownloadLink("Wallpaper3Link1",formatList.get("1920x1200"),downloadLinkService,wallpaperList.get("wallpaper3")));
        downloadLinkList.put("wallpaper1Link2",createDownloadLink("Wallpaper1Link2",formatList.get("1680x1050"),downloadLinkService,wallpaperList.get("wallpaper1")));
        downloadLinkList.put("wallpaper2Link2",createDownloadLink("Wallpaper2Link2",formatList.get("1680x1050"),downloadLinkService,wallpaperList.get("wallpaper2")));
        downloadLinkList.put("wallpaper3Link2",createDownloadLink("Wallpaper3Link2",formatList.get("1680x1050"),downloadLinkService,wallpaperList.get("wallpaper3")));
        downloadLinkList.put("wallpaper1Link3",createDownloadLink("Wallpaper1Link3",formatList.get("1440x900"),downloadLinkService,wallpaperList.get("wallpaper1")));
        downloadLinkList.put("wallpaper2Link3",createDownloadLink("Wallpaper2Link3",formatList.get("1280x800"),downloadLinkService,wallpaperList.get("wallpaper2")));
        return downloadLinkList;
    }

    private static DownloadLink createDownloadLink(String link, final Format format, final DownloadLinkService downloadLinkService, final Wallpaper wallpaper) {
        System.out.println("Registring " + link);
        DownloadLink downloadLink = new DownloadLink();
        downloadLink.setLink(link);
        downloadLink.setFormat(format);
        downloadLink.setWallpaper(wallpaper);
        downloadLinkService.save(downloadLink);
        return downloadLink;
    }

    private static Map<String, Wallpaper> registerWallpaper(final WallpaperService wallpaperService,final Map<String, Access> accessList) {
        Map<String, Wallpaper> wallpaperList = new HashMap<>();
        wallpaperList.put("wallpaper1",createWallpaper("wallpaper1", LocalDate.of(2020, 3, 2), "https://f.hellowork.com/blogdumoderateur/2013/10/google-logo.png",accessList.get("freeAccess"),wallpaperService));
        wallpaperList.put("wallpaper2",createWallpaper("wallpaper2",LocalDate.of(2020, 12, 15), "https://cdn.futura-sciences.com/buildsv6/images/wide1920/6/0/d/60d866d94f_50166286_vache-min.jpg",accessList.get("basicAccess"),wallpaperService));
        wallpaperList.put("wallpaper3",createWallpaper("wallpaper3",LocalDate.of(2021, 1, 24), "https://img.20mn.fr/rFDnIOl-Q0KM5BXP3JzRKQ/830x532_les-lapins-cretins-invasion-serie-animation-diffusee-france-3.jpg",accessList.get("premiumAccess"),wallpaperService));
        return wallpaperList;
    }

    private static Wallpaper createWallpaper(String name, LocalDate date, String preview, final Access access, final WallpaperService wallpaperService) {
        System.out.println("Registring " + name);
        Wallpaper wallpaper = new Wallpaper();
        wallpaper.setWallpaperName(name);
        wallpaper.setAccess(access);
        wallpaper.setDate(date);
        wallpaper.setPreview(preview);
        wallpaperService.save(wallpaper);
        return wallpaper;
    }









}
