
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getLivraison complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getLivraison"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idLivraison" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLivraison", propOrder = {
    "idLivraison"
})
public class GetLivraison {

    protected int idLivraison;

    /**
     * Obtient la valeur de la propriété idLivraison.
     * 
     */
    public int getIdLivraison() {
        return idLivraison;
    }

    /**
     * Définit la valeur de la propriété idLivraison.
     * 
     */
    public void setIdLivraison(int value) {
        this.idLivraison = value;
    }

}
