/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entite;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Zied
 */
@Embeddable
public class ClientNotePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_user", nullable = false)
    private int idUser;
    @Basic(optional = false)
    @Column(name = "id_pharmacie", nullable = false)
    private int idPharmacie;

    public ClientNotePK() {
    }

    public ClientNotePK(int idUser, int idPharmacie) {
        this.idUser = idUser;
        this.idPharmacie = idPharmacie;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdPharmacie() {
        return idPharmacie;
    }

    public void setIdPharmacie(int idPharmacie) {
        this.idPharmacie = idPharmacie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUser;
        hash += (int) idPharmacie;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientNotePK)) {
            return false;
        }
        ClientNotePK other = (ClientNotePK) object;
        if (this.idUser != other.idUser) {
            return false;
        }
        if (this.idPharmacie != other.idPharmacie) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.ClientNotePK[ idUser=" + idUser + ", idPharmacie=" + idPharmacie + " ]";
    }
    
}
