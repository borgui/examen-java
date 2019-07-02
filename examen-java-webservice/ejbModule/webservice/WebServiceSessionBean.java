package webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebService;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;

import domains.Categorie;
import domains.Entrepot;
import domains.Utilisateur;
import services.EntrepotService;
import services.ProduitService;
import services.UtilisateurService;

@Stateless
@LocalBean
@WebService
public class WebServiceSessionBean {

    @EJB
    UtilisateurService utilisateurService;
    ProduitService     produitService;
    EntrepotService    entrepotService;

    @WebMethod( action = "connexion" )
    public Utilisateur connexion( @WebParam( name = "login", mode = Mode.IN ) String login,
            @WebParam( name = "mdp", mode = Mode.IN ) String mdp ) throws NotSupportedException, SystemException {
        return utilisateurService.findUserByLoginAndPassword( login, mdp );
    }

    @WebMethod( action = "getByIdProfil" )
    public List<Utilisateur> getByIdProfil( @WebParam( name = "idProfil", mode = Mode.IN ) Integer idProfil )
            throws NotSupportedException, SystemException {
        return utilisateurService.findUsersByProfil( idProfil );
    }

    @WebMethod( action = "creerUtilisateur" )
    public Utilisateur creerUtilisateur( @WebParam( name = "utilisateur", mode = Mode.IN ) Utilisateur utilisateur )
            throws NotSupportedException, SystemException {
        return utilisateurService.creerUtilisateur( utilisateur );
    }

    @WebMethod( action = "modifierUtilisateur" )
    public Utilisateur modifierUtilisateur( @WebParam( name = "utilisateur", mode = Mode.IN ) Utilisateur utilisateur )
            throws NotSupportedException, SystemException {
        return utilisateurService.modifierUtilisateur( utilisateur );
    }

    @WebMethod( action = "getByUtilisateurId" )
    public Utilisateur getByUtilisateurId( @WebParam( name = "id", mode = Mode.IN ) Integer id )
            throws NotSupportedException, SystemException {
        return utilisateurService.findById( id );
    }

    @WebMethod( action = "supprimerUtilisateur" )
    public void supprimerUtilisateur( @WebParam( name = "id", mode = Mode.IN ) Integer id )
            throws NotSupportedException, SystemException {
        utilisateurService.supprimerUtilisateur( id );
    }

    @WebMethod( action = "creerCategorie" )
    public Categorie creerCategorie( @WebParam( name = "categorie", mode = Mode.IN ) Categorie categorie )
            throws NotSupportedException, SystemException {
        return produitService.creerCategorie( categorie );
    }
    
    @WebMethod( action = "getCategories" )
    public List<Categorie> getCategories( @WebParam( name = "test", mode = Mode.IN ) boolean test)
            throws NotSupportedException, SystemException {
        return produitService.findAllCategories();
    }

    @WebMethod( action = "modifierCategorie" )
    public Categorie modifierCategorie( @WebParam( name = "categorie", mode = Mode.IN ) Categorie categorie )
            throws NotSupportedException, SystemException {
        return produitService.modifierCategorie( categorie );
    }

    @WebMethod( action = "supprimerCategorie" )
    public void supprimerCategorie( @WebParam( name = "id", mode = Mode.IN ) Integer id )
            throws NotSupportedException, SystemException {
        produitService.supprimerCategorie( id );
    }

    @WebMethod( action = "creerEntrepot" )
    public Entrepot creerEntrepot( @WebParam( name = "entrepot", mode = Mode.IN ) Entrepot entrepot )
            throws NotSupportedException, SystemException {
        return entrepotService.creeEntrepot( entrepot );
    }

    @WebMethod( action = "modifierEntrepot" )
    public Entrepot modifierEntrepot( @WebParam( name = "entrepot", mode = Mode.IN ) Entrepot entrepot )
            throws NotSupportedException, SystemException {
        return entrepotService.modifierEntrepot( entrepot );
    }

    @WebMethod( action = "supprimerEntrepot" )
    public void supprimerEntrepot( @WebParam( name = "id", mode = Mode.IN ) Integer id )
            throws NotSupportedException, SystemException {
        entrepotService.supprimerEntrepot( id );
    }
}
