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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian
 */
@Entity
@Table(name = "bestel_regel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BestelRegel.findAll", query = "SELECT b FROM BestelRegel b")
    , @NamedQuery(name = "BestelRegel.findById", query = "SELECT b FROM BestelRegel b WHERE b.id = :id")
    , @NamedQuery(name = "BestelRegel.findByAantal", query = "SELECT b FROM BestelRegel b WHERE b.aantal = :aantal")})
public class BestelRegel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "aantal")
    private Integer aantal;
    @JoinColumn(name = "artikel_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Artikel artikelId;
    @JoinColumn(name = "bestelling_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bestelling bestellingId;

    public BestelRegel() {
    }

    public BestelRegel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAantal() {
        return aantal;
    }

    public void setAantal(Integer aantal) {
        this.aantal = aantal;
    }

    public Artikel getArtikelId() {
        return artikelId;
    }

    public void setArtikelId(Artikel artikelId) {
        this.artikelId = artikelId;
    }

    public Bestelling getBestellingId() {
        return bestellingId;
    }

    public void setBestellingId(Bestelling bestellingId) {
        this.bestellingId = bestellingId;
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
        if (!(object instanceof BestelRegel)) {
            return false;
        }
        BestelRegel other = (BestelRegel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.BestelRegel[ id=" + id + " ]";
    }
    
}
