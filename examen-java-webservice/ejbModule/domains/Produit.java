package domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "Produits" )
public class Produit {

    @Id
    @Column( name = "ID" )
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;

    @Column( name = "idCategorie" )
    Integer idCategorie;

    @Column( name = "description" )
    String  description;

    @Column( name = "idEntrepot" )
    Integer idEntrepot;

    @Column( name = "idVendeur" )
    Integer idVendeur;

    @Column( name = "NOM" )
    String  nom;

    @Column( name = "PRIX" )
    Double  prix;

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

    public Integer getIdVendeur() {
        return idVendeur;
    }

    public void setIdVendeur( Integer idVendeur ) {
        this.idVendeur = idVendeur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix( Double prix ) {
        this.prix = prix;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock( Integer stock ) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

}