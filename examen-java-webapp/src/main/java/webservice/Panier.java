
package webservice;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Panier", propOrder = {
    "id",
    "idUser",
    "panierProduits",
})
public class Panier {
	
    protected Integer id;
    protected Integer idUser;
    protected List<PanierProduit> panierProduits;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public List<PanierProduit> getPanierProduits() {
		return panierProduits;
	}
	public void setPanierProduits(List<PanierProduit> panierProduits) {
		this.panierProduits = panierProduits;
	}
	
	
	

	
   
}
