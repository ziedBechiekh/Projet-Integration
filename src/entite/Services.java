/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entite;

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
 * @author Zied
 */
@Entity
@Table(catalog = "tunipharma", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Services.findAll", query = "SELECT s FROM Services s"),
    @NamedQuery(name = "Services.findByCodeService", query = "SELECT s FROM Services s WHERE s.codeService = :codeService"),
    @NamedQuery(name = "Services.findByNomService", query = "SELECT s FROM Services s WHERE s.nomService = :nomService"),
    @NamedQuery(name = "Services.findByTypeService", query = "SELECT s FROM Services s WHERE s.typeService = :typeService"),
    @NamedQuery(name = "Services.findByPrixService", query = "SELECT s FROM Services s WHERE s.prixService = :prixService")})
public class Services implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code_service", nullable = false)
    private Integer codeService;
    @Basic(optional = false)
    @Column(name = "nom_service", nullable = false, length = 45)
    private String nomService;
    @Basic(optional = false)
    @Column(name = "type_service", nullable = false, length = 45)
    private String typeService;
    @Basic(optional = false)
    @Column(name = "prix_service", nullable = false)
    private float prixService;
    @JoinColumn(name = "id_pharmacie", referencedColumnName = "id_pharmacie", nullable = false)
    @ManyToOne(optional = false)
    private Pharmacie idPharmacie;

    public Services() {
    }

    public Services(Integer codeService) {
        this.codeService = codeService;
    }

    public Services(Integer codeService, String nomService, String typeService, float prixService) {
        this.codeService = codeService;
        this.nomService = nomService;
        this.typeService = typeService;
        this.prixService = prixService;
    }

    public Integer getCodeService() {
        return codeService;
    }

    public void setCodeService(Integer codeService) {
        this.codeService = codeService;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    public float getPrixService() {
        return prixService;
    }

    public void setPrixService(float prixService) {
        this.prixService = prixService;
    }

    public Pharmacie getIdPharmacie() {
        return idPharmacie;
    }

    public void setIdPharmacie(Pharmacie idPharmacie) {
        this.idPharmacie = idPharmacie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeService != null ? codeService.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Services)) {
            return false;
        }
        Services other = (Services) object;
        if ((this.codeService == null && other.codeService != null) || (this.codeService != null && !this.codeService.equals(other.codeService))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Services[ codeService=" + codeService + " ]";
    }
    
}
