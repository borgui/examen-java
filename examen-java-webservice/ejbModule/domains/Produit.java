package domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "Produits" )
public class Produit {

    @Id
    @Column( name = "ID" )
    Integer id;

    @Column( name = "idCategorie" )
    Integer idCategorie;

    @Column( name = "idEntrepot" )
    Integer idEntrepot;

    @Column( name = "NOM" )
    String  nom;

    @Column( name = "PRIX" )
    Integer prix;

    @Column( name = "STOCK" )
    Integer stock;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie( Integer idCategorie ) {
        this.idCategorie = idCategorie;
    }

    public Integer getIdEntrepot() {
        return idEntrepot;
    }

    public void setIdEntrepot( Integer idEntrepot ) {
        this.idEntrepot = idEntrepot;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix( Integer prix ) {
        this.prix = prix;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock( Integer stock ) {
        this.stock = stock;
    }
}