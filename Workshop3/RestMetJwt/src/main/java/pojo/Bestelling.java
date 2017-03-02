/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ian
 */
@Entity
@Table(name = "bestelling")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bestelling.findAll", query = "SELECT b FROM Bestelling b")
    , @NamedQuery(name = "Bestelling.findById", query = "SELECT b FROM Bestelling b WHERE b.id = :id")
    , @NamedQuery(name = "Bestelling.findByTotaalprijs", query = "SELECT b FROM Bestelling b WHERE b.totaalprijs = :totaalprijs")})
public class Bestelling implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "totaalprijs")
    private BigDecimal totaalprijs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bestellingId")
    private List<BestelRegel> bestelRegelList;
    @JoinColumn(name = "klant_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Klant klantId;

    public Bestelling() {
    }

    public Bestelling(Integer id) {
        this.id = id;
    }

    public Bestelling(Integer id, BigDecimal totaalprijs) {
        this.id = id;
        this.totaalprijs = totaalprijs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTotaalprijs() {
        return totaalprijs;
    }

    public void setTotaalprijs(BigDecimal totaalprijs) {
        this.totaalprijs = totaalprijs;
    }

    @XmlTransient
    public List<BestelRegel> getBestelRegelList() {
        return bestelRegelList;
    }

    public void setBestelRegelList(List<BestelRegel> bestelRegelList) {
        this.bestelRegelList = bestelRegelList;
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
        if (!(object instanceof Bestelling)) {
            return false;
        }
        Bestelling other = (Bestelling) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Bestelling[ id=" + id + " ]";
    }
    
}
