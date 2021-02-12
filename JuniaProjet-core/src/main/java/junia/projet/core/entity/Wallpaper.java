package junia.projet.core.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Wallpaper {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String wallpaperName;

    private Date date;

    private String preview;

    @ManyToOne
    private Access access;

    @OneToMany(cascade={CascadeType.ALL}, mappedBy="access")
    private List<DownloadLink> downloadLinkList;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWallpaperName() {
        return wallpaperName;
    }

    public void setWallpaperName(String wallpaperName) {
        this.wallpaperName = wallpaperName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public List<DownloadLink> getDownloadLinkList() {
        return downloadLinkList;
    }

    public void setDownloadLinkList(List<DownloadLink> downloadLinkList) {
        this.downloadLinkList = downloadLinkList;
    }
}
