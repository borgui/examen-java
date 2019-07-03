package servlet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.Utilisateur;
import webservice.WebServiceSessionBean;

@WebServlet( "/AdminServlet" )
public class AdminServlet extends AbstractServlet {

    private static final String LISTE_COMPTE_VENDEUR_ACTION     = "getListeCompteVendeur";

    private static final String LISTE_COMPTE_VENDEUR_PAGE       = "ListeCompteVendeur";

    private static final String AJOUT_COMPTE_VENDEUR_ACTION     = "ajoutVendeur";

    private static final String DETAIL_COMPTE_VENDEUR_ACTION    = "getVendeurDetail";

    private static final String DETAIL_COMPTE_VENDEUR_PAGE      = "CompteVendeurDetail";

    private static final String MODIF_COMPTE_VENDEUR_ACTION     = "modifierVendeur";

    private static final String SUPPRIMER_COMPTE_VENDEUR_ACTION = "supprimerVendeur";

    private static final String SUSPENDRE_DEBLOQ_USER           = "suspendreDebloqUser";

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        initialize( request, response );

        try {
            WebServiceSessionBean webService = getWebService();

            switch ( action ) {
            case LISTE_COMPTE_VENDEUR_ACTION:
                getListeCompteVendeur( webService, request );
                break;
            case AJOUT_COMPTE_VENDEUR_ACTION:
                ajoutCompteVendeur( webService, request );
                break;
            case DETAIL_COMPTE_VENDEUR_ACTION:
                getDetailCompteVendeur( webService, request );
                break;
            case MODIF_COMPTE_VENDEUR_ACTION:
                modifierCompteVendeur( webService, request );
                break;
            case SUPPRIMER_COMPTE_VENDEUR_ACTION:
                supprimerUtilisateur( webService, request );
                break;
            case SUSPENDRE_DEBLOQ_USER:
                suspendreDebloqUser( webService, request );
                break;
            default:
                break;
            }

        } catch ( MalformedURLException e ) {
            redirectionToView( HOME_PAGE );
        }

    }

    private void getListeCompteVendeur( WebServiceSessionBean webservice, HttpServletRequest request )
            throws ServletException, IOException {
        List<Utilisateur> compteVendeur = webservice.getByIdProfil( 2 );
        this.request.setAttribute( "listeCompteVendeur", compteVendeur );
        redirectionToView( LISTE_COMPTE_VENDEUR_PAGE );
    }

    private void modifierCompteVendeur( WebServiceSessionBean webservice, HttpServletRequest request )
            throws ServletException, IOException {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId( Integer.parseInt( request.getParameter( "id" ) ) );
        utilisateur.setPrenom( request.getParameter( "prenom" ) );
        utilisateur.setNom( request.getParameter( "nom" ) );
        utilisateur.setIdProfil( 2 );
        utilisateur.setMail( request.getParameter( "email" ) );
        utilisateur.setPassword( request.getParameter( "password" ) );
        utilisateur.setLogin( request.getParameter( "login" ) );

        Utilisateur compteVendeur = webservice.modifierUtilisateur( utilisateur );
        this.request.setAttribute( "compteVendeur", compteVendeur );
        
        this.getListeCompteVendeur( webservice, request );
    }

    private void getDetailCompteVendeur( WebServiceSessionBean webservice, HttpServletRequest request )
            throws ServletException, IOException {
        Utilisateur compteVendeur = webservice.getByUtilisateurId( Integer.parseInt( request.getParameter( "id" ) ) );
        this.request.setAttribute( "compteVendeur", compteVendeur );
        redirectionToView( DETAIL_COMPTE_VENDEUR_PAGE );
    }

    private void supprimerUtilisateur( WebServiceSessionBean webservice, HttpServletRequest request )
            throws ServletException, IOException {
        webservice.supprimerUtilisateur( Integer.parseInt( request.getParameter( "id" ) ) );
        setVariableToView( "alert-success", "Vendeur supprimé" );
        this.getListeCompteVendeur( webservice, request );
    }

    private void suspendreDebloqUser( WebServiceSessionBean webservice, HttpServletRequest request )
            throws ServletException, IOException {

        Utilisateur utilisateur = webservice.getByUtilisateurId( Integer.parseInt( request.getParameter( "id" ) ) );

        if ( utilisateur.isSuspended() == false ) {
            utilisateur.setSuspended( true );
        } else {
            utilisateur.setSuspended( false );
        }
        webservice.modifierUtilisateur( utilisateur );
        this.getListeCompteVendeur( webservice, request );
    }

    private void ajoutCompteVendeur( WebServiceSessionBean webservice, HttpServletRequest request )
            throws ServletException, IOException {

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPrenom( request.getParameter( "prenom" ) );
        utilisateur.setNom( request.getParameter( "nom" ) );
        utilisateur.setIdProfil( 2 );
        utilisateur.setMail( request.getParameter( "email" ) );
        utilisateur.setPassword( request.getParameter( "password" ) );
        utilisateur.setLogin( request.getParameter( "login" ) );

        Utilisateur compteVendeur = webservice.creerUtilisateur( utilisateur );
        setVariableToView( "alert-success", "Vendeur " + compteVendeur.getNom() + " ajouté" );

        this.getListeCompteVendeur( webservice, request );
    }
}
