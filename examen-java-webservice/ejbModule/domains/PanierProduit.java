package domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "PanierProduit" )
public class PanierProduit {

    @Id
    @Column( name = "ID" )
    Integer id;

    @Column( name = "idPanier" )
    Integer idPanier;

    @Column( name = "idProduit" )
    Integer idProduit;

    @Column( name = "QUANTITE" )
    Integer quantite;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public Integer getIdPanier() {
        return idPanier;
    }

    public void setIdPanier( Integer idPanier ) {
        this.idPanier = idPanier;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit( Integer idProduit ) {
        this.idProduit = idProduit;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite( Integer quantite ) {
        this.quantite = quantite;
    }
}