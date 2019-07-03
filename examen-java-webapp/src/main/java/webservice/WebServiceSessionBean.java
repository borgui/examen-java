package webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.12 2018-07-04T14:36:31.195+02:00
 * Generated source version: 3.1.12
 * 
 */
@WebService( targetNamespace = "http://webservice/", name = "WebServiceSessionBean" )
public interface WebServiceSessionBean {

    @WebMethod( action = "connexion" )
    @RequestWrapper( localName = "connexion", targetNamespace = "http://webservice/", className = "webservice.Connexion" )
    @ResponseWrapper( localName = "connexionResponse", targetNamespace = "http://webservice/", className = "webservice.ConnexionResponse" )
    @WebResult( name = "return", targetNamespace = "" )
    public Utilisateur connexion(
            @WebParam( name = "login", targetNamespace = "" ) String login,
            @WebParam( name = "mdp", targetNamespace = "" ) String mdp );

    @WebMethod( action = "creerUtilisateur" )
    @RequestWrapper( localName = "creerUtilisateur", targetNamespace = "http://webservice/", className = "webservice.creerUtilisateur" )
    @ResponseWrapper( localName = "creerUtilisateurResponse", targetNamespace = "http://webservice/", className = "webservice.creerUtilisateur" )
    @WebResult( name = "return", targetNamespace = "" )
    public Utilisateur creerUtilisateur(
            @WebParam( name = "utilisateur", targetNamespace = "" ) Utilisateur utilisateur );

    @WebMethod( action = "modifierUtilisateur" )
    @RequestWrapper( localName = "modifierUtilisateur", targetNamespace = "http://webservice/", className = "webservice.modifierUtilisateur" )
    @ResponseWrapper( localName = "modifierUtilisateurResponse", targetNamespace = "http://webservice/", className = "webservice.modifierUtilisateur" )
    @WebResult( name = "return", targetNamespace = "" )
    public Utilisateur modifierUtilisateur(
            @WebParam( name = "utilisateur", targetNamespace = "" ) Utilisateur utilisateur );

    @WebMethod( action = "getByIdProfil" )
    @RequestWrapper( localName = "getByIdProfil", targetNamespace = "http://webservice/", className = "webservice.getByIdProfil" )
    @ResponseWrapper( localName = "getByIdProfilResponse", targetNamespace = "http://webservice/", className = "webservice.getByIdProfilResponse" )
    @WebResult( name = "return", targetNamespace = "" )
    public List<Utilisateur> getByIdProfil(
            @WebParam( name = "idProfil", targetNamespace = "" ) Integer idProfil );

    @WebMethod( action = "supprimerUtilisateur" )
    @RequestWrapper( localName = "supprimerUtilisateur", targetNamespace = "http://webservice/", className = "webservice.supprimerUtilisateur" )
    @ResponseWrapper( localName = "supprimerUtilisateurResponse", targetNamespace = "http://webservice/", className = "webservice.supprimerUtilisateurResponse" )
    @WebResult( name = "return", targetNamespace = "" )
    public void supprimerUtilisateur(
            @WebParam( name = "id", targetNamespace = "" ) Integer id );

    @WebMethod( action = "getByUtilisateurId" )
    @RequestWrapper( localName = "getByUtilisateurId", targetNamespace = "http://webservice/", className = "webservice.getByUtilisateurId" )
    @ResponseWrapper( localName = "getByUtilisateurIdResponse", targetNamespace = "http://webservice/", className = "webservice.getByUtilisateurIdResponse" )
    @WebResult( name = "return", targetNamespace = "" )
    public Utilisateur getByUtilisateurId(
            @WebParam( name = "id", targetNamespace = "" ) Integer id );

    /**
     * CATEGORIE
     */

    @WebMethod( action = "getCategories" )
    @RequestWrapper( localName = "getCategories", targetNamespace = "http://webservice/", className = "webservice.getCategories" )
    @ResponseWrapper( localName = "getCategoriesResponse", targetNamespace = "http://webservice/", className = "webservice.getCategoriesResponse" )
    @WebResult( name = "return", targetNamespace = "" )
    public List<Categorie> getCategories();

    @WebMethod( action = "supprimerCategorie" )
    @RequestWrapper( localName = "supprimerCategorie", targetNamespace = "http://webservice/", className = "webservice.supprimerCategorie" )
    @ResponseWrapper( localName = "supprimerCategorieResponse", targetNamespace = "http://webservice/", className = "webservice.supprimerCategorieResponse" )
    @WebResult( name = "return", targetNamespace = "" )
    public void supprimerCategorie(
            @WebParam( name = "id", targetNamespace = "" ) Integer id );

    @WebMethod( action = "modifierCategorie" )
    @RequestWrapper( localName = "modifierCategorie", targetNamespace = "http://webservice/", className = "webservice.modifierCategorie" )
    @ResponseWrapper( localName = "modifierCategorieResponse", targetNamespace = "http://webservice/", className = "webservice.modifierCategorie" )
    @WebResult( name = "return", targetNamespace = "" )
    public Categorie modifierCategorie(
            @WebParam( name = "categorie", targetNamespace = "" ) Categorie categorie );

    @WebMethod( action = "creerCategorie" )
    @RequestWrapper( localName = "creerCategorie", targetNamespace = "http://webservice/", className = "webservice.creerCategorie" )
    @ResponseWrapper( localName = "creerCategorieResponse", targetNamespace = "http://webservice/", className = "webservice.creerCategorie" )
    @WebResult( name = "return", targetNamespace = "" )
    public Categorie creerCategorie(
            @WebParam( name = "categorie", targetNamespace = "" ) Categorie categorie );

    @WebMethod( action = "getCategorieById" )
    @RequestWrapper( localName = "getCategorieById", targetNamespace = "http://webservice/", className = "webservice.getCategorieById" )
    @ResponseWrapper( localName = "getCategorieByIdResponse", targetNamespace = "http://webservice/", className = "webservice.getCategorieByIdResponse" )
    @WebResult( name = "return", targetNamespace = "" )
    public Categorie getCategorieById(
            @WebParam( name = "id", targetNamespace = "" ) Integer id );

    /**
     * ENTREPOT
     */

    @WebMethod( action = "getEntrepots" )
    @RequestWrapper( localName = "getEntrepots", targetNamespace = "http://webservice/", className = "webservice.getEntrepots" )
    @ResponseWrapper( localName = "getEntrepotsResponse", targetNamespace = "http://webservice/", className = "webservice.getEntrepotsResponse" )
    @WebResult( name = "return", targetNamespace = "" )
    public List<Entrepot> getEntrepots();

    @WebMethod( action = "supprimerEntrepot" )
    @RequestWrapper( localName = "supprimerEntrepot", targetNamespace = "http://webservice/", className = "webservice.supprimerEntrepot" )
    @ResponseWrapper( localName = "supprimerEntrepotResponse", targetNamespace = "http://webservice/", className = "webservice.supprimerEntrepotResponse" )
    @WebResult( name = "return", targetNamespace = "" )
    public void supprimerEntrepot(
            @WebParam( name = "id", targetNamespace = "" ) Integer id );

    @WebMethod( action = "modifierEntrepot" )
    @RequestWrapper( localName = "modifierEntrepot", targetNamespace = "http://webservice/", className = "webservice.modifierEntrepot" )
    @ResponseWrapper( localName = "modifierEntrepotResponse", targetNamespace = "http://webservice/", className = "webservice.modifierEntrepot" )
    @WebResult( name = "return", targetNamespace = "" )
    public Entrepot modifierEntrepot(
            @WebParam( name = "Entrepot", targetNamespace = "" ) Entrepot entrepot );

    @WebMethod( action = "creerEntrepot" )
    @RequestWrapper( localName = "creerEntrepot", targetNamespace = "http://webservice/", className = "webservice.creerEntrepot" )
    @ResponseWrapper( localName = "creerEntrepotResponse", targetNamespace = "http://webservice/", className = "webservice.creerEntrepot" )
    @WebResult( name = "return", targetNamespace = "" )
    public Entrepot creerEntrepot(
            @WebParam( name = "Entrepot", targetNamespace = "" ) Entrepot entrepot );

    @WebMethod( action = "getEntrepotById" )
    @RequestWrapper( localName = "getEntrepotById", targetNamespace = "http://webservice/", className = "webservice.getEntrepotById" )
    @ResponseWrapper( localName = "getEntrepotByIdResponse", targetNamespace = "http://webservice/", className = "webservice.getEntrepotByIdResponse" )
    @WebResult( name = "return", targetNamespace = "" )
    public Entrepot getEntrepotById(
            @WebParam( name = "id", targetNamespace = "" ) Integer id );

    @WebMethod( action = "getProduitByCategorieId" )
    @RequestWrapper( localName = "getProduitByCategorieId", targetNamespace = "http://webservice/", className = "webservice.getProduitByCategorieId" )
    @ResponseWrapper( localName = "getProduitByCategorieIdResponse", targetNamespace = "http://webservice/", className = "webservice.getProduitByCategorieIdResponse" )
    @WebResult( name = "return", targetNamespace = "" )
    public List<Produit> getProduitByCategorie(
            @WebParam( name = "categorieId", targetNamespace = "" ) Integer categorieId );

}
