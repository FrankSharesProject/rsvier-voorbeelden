/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ian
 */
@Entity
@Table(name = "klant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klant.findAll", query = "SELECT k FROM Klant k")
    , @NamedQuery(name = "Klant.findById", query = "SELECT k FROM Klant k WHERE k.id = :id")
    , @NamedQuery(name = "Klant.findByVoornaam", query = "SELECT k FROM Klant k WHERE k.voornaam = :voornaam")
    , @NamedQuery(name = "Klant.findByTussenvoegsel", query = "SELECT k FROM Klant k WHERE k.tussenvoegsel = :tussenvoegsel")
    , @NamedQuery(name = "Klant.findByAchternaam", query = "SELECT k FROM Klant k WHERE k.achternaam = :achternaam")})
public class Klant implements Serializable {

    private static final long serialVersionUID = 1L;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klantId")
    private List<Bestelling> bestellingList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "klantId")
    private Adres adres;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "klantId")
    private Account account;

    public Klant() {
    }

    public Klant(Integer id) {
        this.id = id;
    }

    public Klant(Integer id, String voornaam, String achternaam) {
        this.id = id;
        this.voornaam = voornaam;
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

    @XmlTransient
    public List<Bestelling> getBestellingList() {
        return bestellingList;
    }

    public void setBestellingList(List<Bestelling> bestellingList) {
        this.bestellingList = bestellingList;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
        return "pojo.Klant[ id=" + id + " ]";
    }
    
}
