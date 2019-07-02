package webservice;

import java.util.List;

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
    

    @WebMethod(action = "creerUtilisateur")
    @RequestWrapper(localName = "creerUtilisateur", targetNamespace = "http://webservice/", className = "webservice.creerUtilisateur")
    @ResponseWrapper(localName = "creerUtilisateurResponse", targetNamespace = "http://webservice/", className = "webservice.creerUtilisateur")
    @WebResult(name = "return", targetNamespace = "")
    public Utilisateur creerUtilisateur(
        @WebParam(name = "utilisateur", targetNamespace = "")
        Utilisateur utilisateur
    );
    
    @WebMethod(action = "modifierUtilisateur")
    @RequestWrapper(localName = "modifierUtilisateur", targetNamespace = "http://webservice/", className = "webservice.modifierUtilisateur")
    @ResponseWrapper(localName = "modifierUtilisateurResponse", targetNamespace = "http://webservice/", className = "webservice.modifierUtilisateur")
    @WebResult(name = "return", targetNamespace = "")
    public Utilisateur modifierUtilisateur(
        @WebParam(name = "utilisateur", targetNamespace = "")
        Utilisateur utilisateur
    );
    
    @WebMethod(action = "getByIdProfil")
    @RequestWrapper(localName = "getByIdProfil", targetNamespace = "http://webservice/", className = "webservice.getByIdProfil")
    @ResponseWrapper(localName = "getByIdProfilResponse", targetNamespace = "http://webservice/", className = "webservice.getByIdProfilResponse")
    @WebResult(name = "return", targetNamespace = "")
    public List<Utilisateur> getByIdProfil(
        @WebParam(name = "idProfil", targetNamespace = "")
        Integer idProfil
    );
    
    @WebMethod(action = "supprimerUtilisateur")
    @RequestWrapper(localName = "supprimerUtilisateur", targetNamespace = "http://webservice/", className = "webservice.supprimerUtilisateur")
    @ResponseWrapper(localName = "supprimerUtilisateurResponse", targetNamespace = "http://webservice/", className = "webservice.supprimerUtilisateurResponse")
    @WebResult(name = "return", targetNamespace = "")
    public void supprimerUtilisateur(
        @WebParam(name = "id", targetNamespace = "")
        Integer id
    );
    
    
    @WebMethod(action = "getByUtilisateurId")
    @RequestWrapper(localName = "getByUtilisateurId", targetNamespace = "http://webservice/", className = "webservice.getByUtilisateurId")
    @ResponseWrapper(localName = "getByUtilisateurIdResponse", targetNamespace = "http://webservice/", className = "webservice.getByUtilisateurIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public Utilisateur getByUtilisateurId(
        @WebParam(name = "id", targetNamespace = "")
        Integer id
    );
    

    /**
     * CATEGORIE
     */
    
    @WebMethod(action = "getCategories")
    @RequestWrapper(localName = "getCategories", targetNamespace = "http://webservice/", className = "webservice.getCategories")
    @ResponseWrapper(localName = "getCategoriesResponse", targetNamespace = "http://webservice/", className = "webservice.getCategoriesResponse")
    @WebResult(name = "return", targetNamespace = "")
    public List<Categorie> getCategories(
            @WebParam(name = "test", targetNamespace = "")
            boolean test);
    
    @WebMethod(action = "supprimerCategorie")
    @RequestWrapper(localName = "supprimerCategorie", targetNamespace = "http://webservice/", className = "webservice.supprimerCategorie")
    @ResponseWrapper(localName = "supprimerCategorieResponse", targetNamespace = "http://webservice/", className = "webservice.supprimerCategorieResponse")
    @WebResult(name = "return", targetNamespace = "")
    public void supprimerCategorie(
        @WebParam(name = "id", targetNamespace = "")
        Integer id
    );
    
    @WebMethod(action = "modifierCategorie")
    @RequestWrapper(localName = "modifierCategorie", targetNamespace = "http://webservice/", className = "webservice.modifierCategorie")
    @ResponseWrapper(localName = "modifierCategorieResponse", targetNamespace = "http://webservice/", className = "webservice.modifierCategorie")
    @WebResult(name = "return", targetNamespace = "")
    public Categorie modifierCategorie(
        @WebParam(name = "categorie", targetNamespace = "")
        Categorie categorie
    );
    
    @WebMethod(action = "creerCategorie")
    @RequestWrapper(localName = "creerCategorie", targetNamespace = "http://webservice/", className = "webservice.creerCategorie")
    @ResponseWrapper(localName = "creerCategorieResponse", targetNamespace = "http://webservice/", className = "webservice.creerCategorie")
    @WebResult(name = "return", targetNamespace = "")
    public Categorie creerCategorie(
        @WebParam(name = "categorie", targetNamespace = "")
        Categorie categorie
    );
    
    @WebMethod(action = "getCategorieById")
    @RequestWrapper(localName = "getCategorieById", targetNamespace = "http://webservice/", className = "webservice.getCategorieById")
    @ResponseWrapper(localName = "getCategorieByIdResponse", targetNamespace = "http://webservice/", className = "webservice.getCategorieByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public Categorie getCategorieById(
        @WebParam(name = "id", targetNamespace = "")
        Integer id
    );
    
    
}
