package domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "Paniers" )
public class Panier {

    @Id
    @Column( name = "ID" )
    Integer id;

    @Column( name = "QUANTITE" )
    Integer quantite;

    @Column( name = "idProduit" )
    Integer idProduit;

    @Column( name = "idUser" )
    Integer idUser;

    @Column( name = "idVendeur" )
    Integer idVendeur;

    @Column( name = "idFDP" )
    Integer idFDP;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite( Integer quantite ) {
        this.quantite = quantite;
    }

    public Integer getIdProduit() {
        return idUser;
    }

    public void setIdProduit( Integer idProduit ) {
        this.idProduit = idProduit;
    }

    public Integer getIdUsers() {
        return idUser;
    }

    public void setIdUser( Integer idUser ) {
        this.idUser = idUser;
    }

    public Integer getIdVendeur() {
        return idVendeur;
    }

    public void setIdVendeur( Integer idVendeur ) {
        this.idVendeur = idVendeur;
    }

    public Integer getIdFDP() {
        return idFDP;
    }

    public void setIdFDP( Integer idFDP ) {
        this.idFDP = idFDP;
    }
}