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
import domains.Commande;
import domains.Entrepot;
import domains.Panier;
import domains.PanierProduit;
import domains.Produit;
import domains.Utilisateur;
import services.CommandeService;
import services.EntrepotService;
import services.PanierService;
import services.ProduitService;
import services.UtilisateurService;

@Stateless
@LocalBean
@WebService
public class WebServiceSessionBean {

    @EJB
    UtilisateurService utilisateurService;
    
    @EJB
    ProduitService     produitService;
    
    @EJB
    EntrepotService    entrepotService;
    
    @EJB
    PanierService    panierService;

    @EJB
    CommandeService commandeService;

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

    @WebMethod( action = "suspendreDebloqUser" )
    public Utilisateur suspendreDebloqUser(
            @WebParam( name = "utilisateur", mode = Mode.IN ) Utilisateur utilisateur )
            throws NotSupportedException, SystemException {
        return utilisateurService.modifierUtilisateur( utilisateur );
    }

    @WebMethod( action = "creerCategorie" )
    public Categorie creerCategorie( @WebParam( name = "categorie", mode = Mode.IN ) Categorie categorie )
            throws NotSupportedException, SystemException {
        return produitService.creerCategorie( categorie );
    }

    @WebMethod( action = "getCategories" )
    public List<Categorie> getCategories()
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

    @WebMethod( action = "getEntrepots" )
    public List<Entrepot> getEntrepots()
            throws NotSupportedException, SystemException {
        return entrepotService.findAllEntrepots();
    }

    @WebMethod( action = "getEntrepotById" )
    public Entrepot getEntrepotById( @WebParam( name = "id", mode = Mode.IN ) Integer id )
            throws NotSupportedException, SystemException {
        return entrepotService.findById( id );
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

    @WebMethod( action = "getProduitByCategorie" )
    public List<Produit> getProduitByCategorie( @WebParam( name = "categorieId", mode = Mode.IN ) Integer id )
            throws NotSupportedException, SystemException {
        return produitService.findByCategorieId( id );
    }
    
    @WebMethod( action = "creerPanier" )
    public Panier creerPanier( @WebParam( name = "panier", mode = Mode.IN ) Panier panier )
            throws NotSupportedException, SystemException {
        return panierService.creePanier(panier);
    }
    
    @WebMethod( action = "getPanierById" )
    public Panier getPanierById( @WebParam( name = "panierId", mode = Mode.IN ) Integer id )
            throws NotSupportedException, SystemException {
        return panierService.getPanierById( id );
    }
    
    
    @WebMethod( action = "getPanierByUserId" )
    public Panier getPanierByUserId( @WebParam( name = "userId", mode = Mode.IN ) Integer userId )
            throws NotSupportedException, SystemException {
        return panierService.getPanierByUserId( userId );
    }
    
    
    @WebMethod( action = "creerPanierProduit" )
    public PanierProduit creerPanierProduit( @WebParam( name = "panier", mode = Mode.IN ) PanierProduit panierProduit )
            throws NotSupportedException, SystemException {
        return panierService.creerPanierProduit(panierProduit);
    }
    
    @WebMethod(action = "supprimerPanierProduit")
    public void supprimerPanierProduit( @WebParam( name = "panier", mode = Mode.IN ) Integer idPanierProduit )
            throws NotSupportedException, SystemException {
        panierService.supprimerPanierProduit(idPanierProduit);
    }
    
    @WebMethod( action = "creerProduit" )
    public Produit creerProduit( @WebParam( name = "produit", mode = Mode.IN ) Produit produit )
            throws NotSupportedException, SystemException {
        return produitService.creerProduit(produit);
    }
    
    @WebMethod(action = "supprimerProduit")
    public void supprimerProduit( @WebParam( name = "idProduit", mode = Mode.IN ) Integer idProduit )
            throws NotSupportedException, SystemException {
    	produitService.supprimerProduit(idProduit);
    }
    
    @WebMethod(action = "modifierProduit")
    public void modifierProduit( @WebParam( name = "idProduit", mode = Mode.IN ) Produit produit )
            throws NotSupportedException, SystemException {
    	produitService.modifierProduit(produit);
    }
    
    @WebMethod( action = "getProduitsByUserId" )
    public List<Produit> getProduitsByUserId( @WebParam( name = "userId", mode = Mode.IN ) Integer userId )
            throws NotSupportedException, SystemException {
        return produitService.getProduitByUserId( userId );
    }
    
    @WebMethod( action = "getProduitById" )
    public Produit getProduitById( @WebParam( name = "idProduit", mode = Mode.IN ) Integer idProduit )
            throws NotSupportedException, SystemException {
        return produitService.getProduitById( idProduit );
    }
    
    @WebMethod( action = "getCommandeByClient" )
    public List<Commande> getCommandeByClient( @WebParam( name = "userId", mode = Mode.IN ) Integer userId )
            throws NotSupportedException, SystemException {
        return commandeService.getByClient( userId );
    }
    
    @WebMethod( action = "ajouterCommande" )
    public Commande ajouterCommande( @WebParam( name = "commande", mode = Mode.IN ) Commande commande )
            throws NotSupportedException, SystemException {
        return commandeService.creerCommande( commande );
    }
    
    @WebMethod( action = "inscription" )
    public Utilisateur inscription( @WebParam( name = "utilisateur", mode = Mode.IN ) Utilisateur utilisateur )
            throws NotSupportedException, SystemException {
        return utilisateurService.creerUtilisateur( utilisateur);
    }
    
}
