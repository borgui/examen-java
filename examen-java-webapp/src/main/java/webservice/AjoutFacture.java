
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ajoutFacture complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ajoutFacture"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idCommande" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ajoutFacture", propOrder = {
    "idCommande"
})
public class AjoutFacture {

    protected int idCommande;

    /**
     * Obtient la valeur de la propriété idCommande.
     * 
     */
    public int getIdCommande() {
        return idCommande;
    }

    /**
     * Définit la valeur de la propriété idCommande.
     * 
     */
    public void setIdCommande(int value) {
        this.idCommande = value;
    }

}
