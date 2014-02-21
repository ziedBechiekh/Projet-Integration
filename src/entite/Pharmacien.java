/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entite;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zied
 */
@Entity
@Table(catalog = "tunipharma", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pharmacien.findAll", query = "SELECT p FROM Pharmacien p"),
    @NamedQuery(name = "Pharmacien.findByIdUser", query = "SELECT p FROM Pharmacien p WHERE p.idUser = :idUser"),
    @NamedQuery(name = "Pharmacien.findByDiplome", query = "SELECT p FROM Pharmacien p WHERE p.diplome = :diplome")})
public class Pharmacien implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user", nullable = false)
    private Integer idUser;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String diplome;
    @JoinColumn(name = "id_pharmacie", referencedColumnName = "id_pharmacie", nullable = false)
    @ManyToOne(optional = false)
    private Pharmacie idPharmacie;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Utilisateur utilisateur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private List<Pharmacie> pharmacieList;

    public Pharmacien() {
    }

    public Pharmacien(Integer idUser) {
        this.idUser = idUser;
    }

    public Pharmacien(Integer idUser, String diplome) {
        this.idUser = idUser;
        this.diplome = diplome;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public Pharmacie getIdPharmacie() {
        return idPharmacie;
    }

    public void setIdPharmacie(Pharmacie idPharmacie) {
        this.idPharmacie = idPharmacie;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @XmlTransient
    public List<Pharmacie> getPharmacieList() {
        return pharmacieList;
    }

    public void setPharmacieList(List<Pharmacie> pharmacieList) {
        this.pharmacieList = pharmacieList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pharmacien)) {
            return false;
        }
        Pharmacien other = (Pharmacien) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Pharmacien[ idUser=" + idUser + " ]";
    }
    
}
