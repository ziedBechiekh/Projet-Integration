/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entite;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "client_note", catalog = "tunipharma", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientNote.findAll", query = "SELECT c FROM ClientNote c"),
    @NamedQuery(name = "ClientNote.findByIdUser", query = "SELECT c FROM ClientNote c WHERE c.clientNotePK.idUser = :idUser"),
    @NamedQuery(name = "ClientNote.findByIdPharmacie", query = "SELECT c FROM ClientNote c WHERE c.clientNotePK.idPharmacie = :idPharmacie"),
    @NamedQuery(name = "ClientNote.findByNote", query = "SELECT c FROM ClientNote c WHERE c.note = :note")})
public class ClientNote implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClientNotePK clientNotePK;
    @Basic(optional = false)
    @Column(nullable = false)
    private int note;
    @JoinColumn(name = "id_pharmacie", referencedColumnName = "id_pharmacie", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pharmacie pharmacie;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Client client;

    public ClientNote() {
    }

    public ClientNote(ClientNotePK clientNotePK) {
        this.clientNotePK = clientNotePK;
    }

    public ClientNote(ClientNotePK clientNotePK, int note) {
        this.clientNotePK = clientNotePK;
        this.note = note;
    }

    public ClientNote(int idUser, int idPharmacie) {
        this.clientNotePK = new ClientNotePK(idUser, idPharmacie);
    }

    public ClientNotePK getClientNotePK() {
        return clientNotePK;
    }

    public void setClientNotePK(ClientNotePK clientNotePK) {
        this.clientNotePK = clientNotePK;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public Pharmacie getPharmacie() {
        return pharmacie;
    }

    public void setPharmacie(Pharmacie pharmacie) {
        this.pharmacie = pharmacie;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientNotePK != null ? clientNotePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientNote)) {
            return false;
        }
        ClientNote other = (ClientNote) object;
        if ((this.clientNotePK == null && other.clientNotePK != null) || (this.clientNotePK != null && !this.clientNotePK.equals(other.clientNotePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.ClientNote[ clientNotePK=" + clientNotePK + " ]";
    }
    
}
