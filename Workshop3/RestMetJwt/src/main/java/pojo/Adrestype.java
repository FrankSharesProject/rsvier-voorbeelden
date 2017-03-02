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
@Table(name = "adrestype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adrestype.findAll", query = "SELECT a FROM Adrestype a")
    , @NamedQuery(name = "Adrestype.findById", query = "SELECT a FROM Adrestype a WHERE a.id = :id")
    , @NamedQuery(name = "Adrestype.findByType", query = "SELECT a FROM Adrestype a WHERE a.type = :type")})
public class Adrestype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "type")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adrestypeId")
    private List<Adres> adresList;

    public Adrestype() {
    }

    public Adrestype(Integer id) {
        this.id = id;
    }

    public Adrestype(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public List<Adres> getAdresList() {
        return adresList;
    }

    public void setAdresList(List<Adres> adresList) {
        this.adresList = adresList;
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
        if (!(object instanceof Adrestype)) {
            return false;
        }
        Adrestype other = (Adrestype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Adrestype[ id=" + id + " ]";
    }
    
}
