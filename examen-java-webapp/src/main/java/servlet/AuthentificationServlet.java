package servlet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.Banque;
import webservice.Utilisateur;
import webservice.WebServiceSessionBean;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet( "/AuthentificationServlet" )
public class AuthentificationServlet extends AbstractServlet {
    private static final long   serialVersionUID  = 1L;

    private static final String MODIFIER_ACTION   = "modifierCompte";
    private static final String MONCOMPTE_ACTION  = "monCompte";
    private static final String MODIFICATION_PAGE = "MonCompte";
    private static final String INSCRIPTION_PAGE  = "Inscription";

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        initialize( request, response );

        try {
            WebServiceSessionBean webService = getWebService();

            switch ( action ) {
            case DECONNEXION_ACTION:
                disconnectUser();
                break;
            case MONCOMPTE_ACTION:
                getDetailCompte( webService, request );
                break;
            default:
                break;
            }

        } catch ( MalformedURLException e ) {
            redirectionToView( HOME_PAGE );
        }

    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        initialize( request, response );

        try {
            WebServiceSessionBean webService = getWebService();

            switch ( action ) {
            case INSCRIPTION_ACTION:
                createUser( webService, request );
                break;
            case CONNEXION_ACTION:
                connectUser( webService, request );
                break;
            case MODIFIER_ACTION:
                modifierUser( webService, request );
                break;
            default:
                break;
            }

        } catch ( Exception e ) {
            redirectionToView( HOME_PAGE );
        }

    }

    private void disconnectUser() throws ServletException, IOException {
        // delete params in http session
        session.invalidate();
        // redirection home
        redirectionToView( HOME_PAGE );
    }

    private void getDetailCompte( WebServiceSessionBean webService, HttpServletRequest request )
            throws ServletException, IOException {
        Utilisateur utilisateur = webService.getByUtilisateurId( (Integer) session.getAttribute( "id" ) );
        request.setAttribute( "utilisateur", utilisateur );
        redirectionToView( MODIFICATION_PAGE );
    }
    
    private void modifierUser( WebServiceSessionBean webService, HttpServletRequest request ) throws ServletException, Exception {
       	Utilisateur utilisateur = new Utilisateur();
    	utilisateur.setIdProfil(CLIENT);
    	utilisateur.setId((Integer) session.getAttribute("id"));
    	utilisateur.setNom(request.getParameter( "nom" ));
    	utilisateur.setPrenom(request.getParameter( "login"));
        utilisateur.setPassword(request.getParameter( "password"));
        utilisateur.setMail(request.getParameter("email"));
        utilisateur.setLogin(request.getParameter( "login"));
        utilisateur.setSuspended(false);
        
        String errorMsg = validateUser(utilisateur, webService);
        if(errorMsg != null) {
            setVariableToView( "alert-danger", errorMsg);
        } else {
            utilisateur = webService.modifierUtilisateur( utilisateur );
            setVariableToView( "alert-success", "Votre compte a bien été modifié" );
        }
        getDetailCompte( webService, request );
    }

    private void connectUser( WebServiceSessionBean webService, HttpServletRequest request )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String login = request.getParameter( "login" );
        String password = request.getParameter( "password" );
        Utilisateur utilisateur = webService.connexion( login, password );
        if ( utilisateur != null ) {
            httpSession( login, password, utilisateur.getId() );
            int idProfil = utilisateur.getIdProfil();

            switch ( idProfil ) {
            case CLIENT:
                session.setAttribute( "session-role", "client" );
                break;
            case VENDEUR:
                session.setAttribute( "session-role", "vendeur" );
                break;
            case ADMINISTRATEUR:
                session.setAttribute( "session-role", "admin" );
                break;
            default:
                break;
            }

            redirectionToView( HOME_PAGE );
        } else {
            ResourceBundle messages = ResourceBundle.getBundle( "messages" );
            setVariableToView( "alert-danger", messages.getString( "error.login" ) );
            redirectionToView( CONNEXION_PAGE );
        }
    }
    
    
    private String validateUser(Utilisateur utilisateur, WebServiceSessionBean webService) {
    	 if(!utilisateur.getPassword().equals(request.getParameter("confirmationPassword"))) {
             return "Les mots de passe entrés sont différents";
    	 }
         
         List<Utilisateur> utilisateursExistant = webService.getUtilisateurByEmailOrLogin(utilisateur.getMail(), utilisateur.getLogin());
         if(utilisateursExistant != null && utilisateursExistant.size() > 0) {
             return "Le login ou l'email utilisateur existe déjà";
         }
         return null;
    }
    
    private void createUser( WebServiceSessionBean webService, HttpServletRequest request )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
    	Utilisateur utilisateur = new Utilisateur();
    	utilisateur.setIdProfil(CLIENT);
    	utilisateur.setNom(request.getParameter( "nom" ));
    	utilisateur.setPrenom(request.getParameter( "login"));
        utilisateur.setPassword(request.getParameter( "password"));
        utilisateur.setMail(request.getParameter("email"));
        utilisateur.setLogin(request.getParameter( "login"));
        utilisateur.setSuspended(false);
        
        Banque banque = new Banque();
        banque.setBalance(0D);
        utilisateur.setBanque(banque);
        String errorMsg = validateUser(utilisateur, webService);
        if(errorMsg != null) {
            setVariableToView( "alert-danger", errorMsg);
            redirectionToView( INSCRIPTION_PAGE );
            return;
        }
        utilisateur = webService.inscription(utilisateur);
        if ( utilisateur != null ) {
            httpSession( utilisateur.getLogin(), utilisateur.getPassword(), utilisateur.getId() );
            int idProfil = utilisateur.getIdProfil();

            switch ( idProfil ) {
            case CLIENT:
                session.setAttribute( "session-role", "client" );
                break;
            case VENDEUR:
                session.setAttribute( "session-role", "vendeur" );
                break;
            case ADMINISTRATEUR:
                session.setAttribute( "session-role", "admin" );
                break;
            default:
                break;
            }

            redirectionToView( HOME_PAGE );
    }
    }

}
