
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PanierProduit", propOrder = {
    "id",
    "idPanier",
    "idProduit",
    "quantite"
})
public class PanierProduit {
	
    protected Integer id;
    protected Integer idPanier;
    protected Produit produit;
    protected Integer quantite;

    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdPanier() {
		return idPanier;
	}
	public void setIdPanier(Integer idPanier) {
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
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	
}
