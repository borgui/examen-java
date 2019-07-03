package domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "panierproduit" )
public class PanierProduit {

    @Id
    @Column( name = "ID" )
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;

    @Column( name = "idPanier" )
    Integer idPanier;

    @ManyToOne
    @JoinColumn( name = "idProduit" ) 
    Produit produit;

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


    public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite( Integer quantite ) {
        this.quantite = quantite;
    }
}