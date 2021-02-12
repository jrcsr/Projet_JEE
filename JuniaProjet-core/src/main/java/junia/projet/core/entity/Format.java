package junia.projet.core.entity;

import javax.persistence.*;

@Entity
public class Format {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String formatName;

    @ManyToOne
    private Access access;



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
