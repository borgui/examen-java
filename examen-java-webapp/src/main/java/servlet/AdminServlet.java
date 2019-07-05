package servlet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.Banque;
import webservice.Utilisateur;
import webservice.WebServiceSessionBean;

@WebServlet( "/AdminServlet" )
public class AdminServlet extends AbstractServlet {

    private static final String LISTE_COMPTE_VENDEUR_ACTION     = "getListeCompteVendeur";
    private static final String LISTE_COMPTE_CLIENT_ACTION     = "getListeCompteClient";

    

    private static final String LISTE_COMPTE_UTILISATEUR_PAGE       = "ListeCompteUtilisateur";

    private static final String AJOUT_COMPTE_UTILISATEUR_ACTION     = "ajouterUtilisateur";

    private static final String DETAIL_COMPTE_UTILISATEUR_ACTION    = "getUtilisateurDetail";

    private static final String DETAIL_COMPTE_UTILISATEUR_PAGE      = "CompteUtilisateurDetail";

    private static final String MODIF_COMPTE_UTILISATEUR_ACTION     = "modifierUtilisateur";

    private static final String SUPPRIMER_COMPTE_UTILISATEUR_ACTION = "supprimerUtilisateur";

    private static final String SUSPENDRE_DEBLOQ_USER           = "suspendreDebloqUser";

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        initialize( request, response );

        try {
            WebServiceSessionBean webService = getWebService();

            switch ( action ) {
            case LISTE_COMPTE_VENDEUR_ACTION:
                getListeCompteUtilisateur( webService, request, VENDEUR);
                break;
            case LISTE_COMPTE_CLIENT_ACTION:
                getListeCompteUtilisateur( webService, request, CLIENT );
                break;
            case AJOUT_COMPTE_UTILISATEUR_ACTION:
                ajoutCompteUtilisateur( webService, request );
                break;
            case DETAIL_COMPTE_UTILISATEUR_ACTION:
                getDetailCompteUtilisateur( webService, request );
                break;
            case MODIF_COMPTE_UTILISATEUR_ACTION:
            	modifierCompteUtilisateur( webService, request );
                break;
            case SUPPRIMER_COMPTE_UTILISATEUR_ACTION:
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

    private void getListeCompteUtilisateur( WebServiceSessionBean webservice, HttpServletRequest request , Integer idProfil)
            throws ServletException, IOException {
        List<Utilisateur> compteUtilisateur = webservice.getByIdProfil(idProfil);
        this.request.setAttribute( "listeCompteUtilisateur", compteUtilisateur );
        this.request.setAttribute("idProfil", idProfil);
        redirectionToView( LISTE_COMPTE_UTILISATEUR_PAGE );
    }

    private void modifierCompteUtilisateur( WebServiceSessionBean webservice, HttpServletRequest request )
            throws ServletException, IOException {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId( Integer.parseInt( request.getParameter( "id" ) ) );
        utilisateur.setPrenom( request.getParameter( "prenom" ) );
        utilisateur.setNom( request.getParameter( "nom" ) );
        utilisateur.setIdProfil(Integer.parseInt(request.getParameter("idProfil")));
        utilisateur.setMail( request.getParameter( "email" ) );
        utilisateur.setPassword( request.getParameter( "password" ) );
        utilisateur.setLogin( request.getParameter( "login" ) );

        utilisateur = webservice.modifierUtilisateur( utilisateur );
        this.request.setAttribute( "utilisateur", utilisateur );
        setVariableToView( "alert-success", "Compte modifié" );
        this.getListeCompteUtilisateur( webservice, request, utilisateur.getIdProfil());
    }

    private void getDetailCompteUtilisateur( WebServiceSessionBean webservice, HttpServletRequest request )
            throws ServletException, IOException {
        Utilisateur compteUtilisateur = webservice.getByUtilisateurId( Integer.parseInt( request.getParameter( "id" ) ) );
        this.request.setAttribute( "compteUtilisateur", compteUtilisateur );
        redirectionToView( DETAIL_COMPTE_UTILISATEUR_PAGE );
    }

    private void supprimerUtilisateur( WebServiceSessionBean webservice, HttpServletRequest request )
            throws ServletException, IOException {
        webservice.supprimerUtilisateur( Integer.parseInt( request.getParameter( "id" ) ) );
        int idProfil = Integer.parseInt( request.getParameter( "idProfil" ));
        setVariableToView( "alert-success", "Compte supprimé" );
        this.getListeCompteUtilisateur( webservice, request, idProfil);
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
        this.getListeCompteUtilisateur( webservice, request, utilisateur.getIdProfil());
    }

    private void ajoutCompteUtilisateur( WebServiceSessionBean webservice, HttpServletRequest request )
            throws ServletException, IOException {

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPrenom( request.getParameter( "prenom" ) );
        utilisateur.setNom( request.getParameter( "nom" ) );
        utilisateur.setIdProfil(Integer.parseInt(request.getParameter("idProfil")));
        utilisateur.setMail( request.getParameter( "email" ) );
        utilisateur.setPassword( request.getParameter( "password" ) );
        utilisateur.setLogin( request.getParameter( "login" ) );
        
        Banque banque = new Banque();
        banque.setBalance(0D);
        utilisateur.setBanque(banque);

        Utilisateur compteVendeur = webservice.creerUtilisateur( utilisateur );
        setVariableToView( "alert-success", "Vendeur " + compteVendeur.getNom() + " ajouté" );

        this.getListeCompteUtilisateur( webservice, request, utilisateur.getIdProfil());
    }
}
