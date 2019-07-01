
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ajoutAccuseReception complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ajoutAccuseReception"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accuseReception" type="{http://webservice/}accuseReception" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ajoutAccuseReception", propOrder = {
    "accuseReception"
})
public class AjoutAccuseReception {

    protected AccuseReception accuseReception;

    /**
     * Obtient la valeur de la propriété accuseReception.
     * 
     * @return
     *     possible object is
     *     {@link AccuseReception }
     *     
     */
    public AccuseReception getAccuseReception() {
        return accuseReception;
    }

    /**
     * Définit la valeur de la propriété accuseReception.
     * 
     * @param value
     *     allowed object is
     *     {@link AccuseReception }
     *     
     */
    public void setAccuseReception(AccuseReception value) {
        this.accuseReception = value;
    }

}
