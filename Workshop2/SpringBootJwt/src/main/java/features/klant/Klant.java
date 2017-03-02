package features.klant;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="klant")
public class Klant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "voornaam")
    private String voornaam;
    @Size(max = 15)
    @Column(name = "tussenvoegsel")
    private String tussenvoegsel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "achternaam")
    private String achternaam;
	
    public Klant(){
            this(null, null, null);
    }

    public Klant(String voornaam, String achternaam) {
            this(voornaam, null, achternaam);
    }

    public Klant(String voornaam, String tussenvoegsel, String achternaam) {
            this.voornaam = voornaam;
            this.tussenvoegsel = tussenvoegsel;
            this.achternaam = achternaam;
    }

    public Integer getId() {
            return id;
    }

    public void setId(Integer id) {
            this.id = id;
    }

    public String getVoornaam() {
            return voornaam;
    }

    public void setVoornaam(String voornaam) {
            this.voornaam = voornaam;
    }

    public String getTussenvoegsel() {
            return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
            this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
            return achternaam;
    }

    public void setAchternaam(String achternaam) {
            this.achternaam = achternaam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klant)) {
            return false;
        }
        Klant other = (Klant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "klant.Klant[ id=" + id + " ]";
    }
	

}
