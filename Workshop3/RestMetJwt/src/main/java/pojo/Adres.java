/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian
 */
@Entity
@Table(name = "adres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adres.findAll", query = "SELECT a FROM Adres a")
    , @NamedQuery(name = "Adres.findById", query = "SELECT a FROM Adres a WHERE a.id = :id")
    , @NamedQuery(name = "Adres.findByStraatnaam", query = "SELECT a FROM Adres a WHERE a.straatnaam = :straatnaam")
    , @NamedQuery(name = "Adres.findByHuisnummer", query = "SELECT a FROM Adres a WHERE a.huisnummer = :huisnummer")
    , @NamedQuery(name = "Adres.findByToevoeging", query = "SELECT a FROM Adres a WHERE a.toevoeging = :toevoeging")
    , @NamedQuery(name = "Adres.findByPostcode", query = "SELECT a FROM Adres a WHERE a.postcode = :postcode")
    , @NamedQuery(name = "Adres.findByWoonplaats", query = "SELECT a FROM Adres a WHERE a.woonplaats = :woonplaats")})
public class Adres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "straatnaam")
    private String straatnaam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "huisnummer")
    private int huisnummer;
    @Size(max = 5)
    @Column(name = "toevoeging")
    private String toevoeging;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "postcode")
    private String postcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "woonplaats")
    private String woonplaats;
    @JoinColumn(name = "adrestype_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Adrestype adrestypeId;
    @JoinColumn(name = "klant_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Klant klantId;

    public Adres() {
    }

    public Adres(Integer id) {
        this.id = id;
    }

    public Adres(Integer id, String straatnaam, int huisnummer, String postcode, String woonplaats) {
        this.id = id;
        this.straatnaam = straatnaam;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.woonplaats = woonplaats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getToevoeging() {
        return toevoeging;
    }

    public void setToevoeging(String toevoeging) {
        this.toevoeging = toevoeging;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public Adrestype getAdrestypeId() {
        return adrestypeId;
    }

    public void setAdrestypeId(Adrestype adrestypeId) {
        this.adrestypeId = adrestypeId;
    }

    public Klant getKlantId() {
        return klantId;
    }

    public void setKlantId(Klant klantId) {
        this.klantId = klantId;
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
        if (!(object instanceof Adres)) {
            return false;
        }
        Adres other = (Adres) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Adres[ id=" + id + " ]";
    }
    
}
