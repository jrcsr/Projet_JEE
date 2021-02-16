package junia.projet.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties(value={"downloadLinkList"})
public class Format {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String formatName;

    @ManyToOne
    private Access access;

    @OneToMany (cascade={CascadeType.ALL}, mappedBy="format")
    private List<DownloadLink> downloadLinkList;

    public Format(String formatName, Access access) {
        this.formatName = formatName;
        this.access = access;
    }

    public Format() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }
}
