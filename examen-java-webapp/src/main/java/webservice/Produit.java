
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
    "idCategorie",
    "idEntrepot",
    "description"
})
public class Produit {
	
    protected Integer id;
    protected String nom;
    protected Double prix;
    protected Integer stock;
    protected Integer idCategorie;
    protected Integer idEntrepot;
    protected String description;
    
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
	public Integer getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(Integer idCategorie) {
		this.idCategorie = idCategorie;
	}
	public Integer getIdEntrepot() {
		return idEntrepot;
	}
	public void setIdEntrepot(Integer idEntrepot) {
		this.idEntrepot = idEntrepot;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

	
   
}
