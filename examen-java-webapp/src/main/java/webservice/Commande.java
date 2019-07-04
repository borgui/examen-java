
package webservice;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour categorie produit complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Commande", propOrder = {
    "id",
    "date",
    "status",
    "panier"
})
public class Commande {
	
    protected Integer id;
    protected Date date;
    protected CommandeStatus status;
    protected Panier panier;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public CommandeStatus getStatus() {
		return status;
	}
	public void setStatus(CommandeStatus status) {
		this.status = status;
	}
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	}
    
    


   
}
