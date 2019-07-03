
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Produit", propOrder = {
    "id",
    "nom",
    "prix",
    "stock",
    "categorie",
    "entrepot",
    "description",
    "idVendeur"
})
public class Produit {
	
    protected Integer id;
    protected String nom;
    protected Double prix;
    protected Integer stock;
    protected Categorie categorie;
    protected Entrepot entrepot;
    protected String description;
    protected Integer idVendeur;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Entrepot getEntrepot() {
		return entrepot;
	}
	public void setEntrepot(Entrepot entrepot) {
		this.entrepot = entrepot;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getIdVendeur() {
		return idVendeur;
	}
	public void setIdVendeur(Integer idVendeur) {
		this.idVendeur = idVendeur;
	}
	

	
   
}
