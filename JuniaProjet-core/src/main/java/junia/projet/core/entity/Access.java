package junia.projet.core.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Access {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String accessName;

    @ManyToMany(cascade={CascadeType.ALL}, mappedBy="access")
    private List<Profile> profileList;


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
