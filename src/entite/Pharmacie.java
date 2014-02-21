/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entite;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Pharmacie.findAll", query = "SELECT p FROM Pharmacie p"),
    @NamedQuery(name = "Pharmacie.findByIdPharmacie", query = "SELECT p FROM Pharmacie p WHERE p.idPharmacie = :idPharmacie"),
    @NamedQuery(name = "Pharmacie.findByNomPharmacie", query = "SELECT p FROM Pharmacie p WHERE p.nomPharmacie = :nomPharmacie"),
    @NamedQuery(name = "Pharmacie.findByAdressePh", query = "SELECT p FROM Pharmacie p WHERE p.adressePh = :adressePh"),
    @NamedQuery(name = "Pharmacie.findByDateCrea", query = "SELECT p FROM Pharmacie p WHERE p.dateCrea = :dateCrea"),
    @NamedQuery(name = "Pharmacie.findByTelephonePhar", query = "SELECT p FROM Pharmacie p WHERE p.telephonePhar = :telephonePhar"),
    @NamedQuery(name = "Pharmacie.findByRegion", query = "SELECT p FROM Pharmacie p WHERE p.region = :region"),
    @NamedQuery(name = "Pharmacie.findByFax", query = "SELECT p FROM Pharmacie p WHERE p.fax = :fax"),
    @NamedQuery(name = "Pharmacie.findByEmail", query = "SELECT p FROM Pharmacie p WHERE p.email = :email")})
public class Pharmacie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pharmacie", nullable = false)
    private Integer idPharmacie;
    @Basic(optional = false)
    @Column(name = "nom_pharmacie", nullable = false, length = 45)
    private String nomPharmacie;
    @Basic(optional = false)
    @Column(name = "adresse_ph", nullable = false, length = 45)
    private String adressePh;
    @Basic(optional = false)
    @Column(name = "date_crea", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCrea;
    @Basic(optional = false)
    @Column(name = "telephone_phar", nullable = false, length = 45)
    private String telephonePhar;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String region;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String fax;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPharmacie")
    private List<Services> servicesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pharmacie")
    private List<ClientNote> clientNoteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPharmacie")
    private List<Pharmacien> pharmacienList;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    @ManyToOne(optional = false)
    private Pharmacien idUser;

    public Pharmacie() {
    }

    public Pharmacie(Integer idPharmacie) {
        this.idPharmacie = idPharmacie;
    }

    public Pharmacie(Integer idPharmacie, String nomPharmacie, String adressePh, Date dateCrea, String telephonePhar, String region, String fax, String email) {
        this.idPharmacie = idPharmacie;
        this.nomPharmacie = nomPharmacie;
        this.adressePh = adressePh;
        this.dateCrea = dateCrea;
        this.telephonePhar = telephonePhar;
        this.region = region;
        this.fax = fax;
        this.email = email;
    }

    public Integer getIdPharmacie() {
        return idPharmacie;
    }

    public void setIdPharmacie(Integer idPharmacie) {
        this.idPharmacie = idPharmacie;
    }

    public String getNomPharmacie() {
        return nomPharmacie;
    }

    public void setNomPharmacie(String nomPharmacie) {
        this.nomPharmacie = nomPharmacie;
    }

    public String getAdressePh() {
        return adressePh;
    }

    public void setAdressePh(String adressePh) {
        this.adressePh = adressePh;
    }

    public Date getDateCrea() {
        return dateCrea;
    }

    public void setDateCrea(Date dateCrea) {
        this.dateCrea = dateCrea;
    }

    public String getTelephonePhar() {
        return telephonePhar;
    }

    public void setTelephonePhar(String telephonePhar) {
        this.telephonePhar = telephonePhar;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Services> getServicesList() {
        return servicesList;
    }

    public void setServicesList(List<Services> servicesList) {
        this.servicesList = servicesList;
    }

    @XmlTransient
    public List<ClientNote> getClientNoteList() {
        return clientNoteList;
    }

    public void setClientNoteList(List<ClientNote> clientNoteList) {
        this.clientNoteList = clientNoteList;
    }

    @XmlTransient
    public List<Pharmacien> getPharmacienList() {
        return pharmacienList;
    }

    public void setPharmacienList(List<Pharmacien> pharmacienList) {
        this.pharmacienList = pharmacienList;
    }

    public Pharmacien getIdUser() {
        return idUser;
    }

    public void setIdUser(Pharmacien idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPharmacie != null ? idPharmacie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pharmacie)) {
            return false;
        }
        Pharmacie other = (Pharmacie) object;
        if ((this.idPharmacie == null && other.idPharmacie != null) || (this.idPharmacie != null && !this.idPharmacie.equals(other.idPharmacie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Pharmacie[ idPharmacie=" + idPharmacie + " ]";
    }
    
}
