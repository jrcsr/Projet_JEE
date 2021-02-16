package junia.projet.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(value={"wallpaper"})
public class DownloadLink {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String link;

    @ManyToOne
    private Format format;

    @ManyToOne
    private Wallpaper wallpaper;

    public DownloadLink() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public Wallpaper getWallpaper() {
        return wallpaper;
    }

    public void setWallpaper(Wallpaper wallpaper) {
        this.wallpaper = wallpaper;
    }
}
