package junia.projet.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties(value={"wallpaperList","formatList"})
public class Access {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String accessName;

    @ManyToMany
    private List<Profile> profileList;

    @OneToMany (cascade={CascadeType.ALL}, mappedBy="access")
    private List<Wallpaper> wallpaperList;

    @OneToMany (cascade={CascadeType.ALL}, mappedBy="access")
    private List<Format> formatList;

    public Access(String accessName, List<Profile> profileList) {
        this.accessName = accessName;
        this.profileList = profileList;
    }

    public Access() {

    }

    public String getAccessName() {
        return accessName;
    }

    public void setAccessName(String accessName) {
        this.accessName = accessName;
    }

    public List<Profile> getProfileList() {
        return profileList;
    }

    public void setProfileList(List<Profile> profileList) {
        this.profileList = profileList;
    }
}
