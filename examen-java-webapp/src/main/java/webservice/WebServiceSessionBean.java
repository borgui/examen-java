package webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.12
 * 2018-07-04T14:36:31.195+02:00
 * Generated source version: 3.1.12
 * 
 */
@WebService(targetNamespace = "http://webservice/", name = "WebServiceSessionBean")
public interface WebServiceSessionBean {

    @WebMethod(action = "connexion")
    @RequestWrapper(localName = "connexion", targetNamespace = "http://webservice/", className = "webservice.Connexion")
    @ResponseWrapper(localName = "connexionResponse", targetNamespace = "http://webservice/", className = "webservice.ConnexionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public Utilisateur connexion(
        @WebParam(name = "login", targetNamespace = "")
        String login,
        @WebParam(name = "mdp", targetNamespace = "")
        String mdp
    );
}
