
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getAccuseReception complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getAccuseReception"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idAccuseReception" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAccuseReception", propOrder = {
    "idAccuseReception"
})
public class GetAccuseReception {

    protected int idAccuseReception;

    /**
     * Obtient la valeur de la propriété idAccuseReception.
     * 
     */
    public int getIdAccuseReception() {
        return idAccuseReception;
    }

    /**
     * Définit la valeur de la propriété idAccuseReception.
     * 
     */
    public void setIdAccuseReception(int value) {
        this.idAccuseReception = value;
    }

}
