package servlet;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.Utilisateur;
import webservice.WebServiceSessionBean;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet( "/AuthentificationServlet" )
public class AuthentificationServlet extends AbstractServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        initialize( request, response );

        try {
            WebServiceSessionBean webService = getWebService();

            switch ( action ) {
            case DECONNEXION_ACTION:
                disconnectUser();
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
            	createUser(webService, request);
            case CONNEXION_ACTION:
                connectUser( webService, request );
                break;
            default:
                break;
            }

        } catch ( MalformedURLException e ) {
            redirectionToView( HOME_PAGE );
        }

    }


    private void disconnectUser() throws ServletException, IOException {
        // delete params in http session
        session.invalidate();
        // redirection home
        redirectionToView( HOME_PAGE );
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
            setVariableToView( "alert-danger", "Identifiants incorrect ou compte bloqué" );
            redirectionToView( CONNEXION_PAGE );
        }
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
        } else {
            setVariableToView( "alert-danger", "Identifiants incorrect ou compte bloqué" );
            redirectionToView( CONNEXION_PAGE );
        }
    }


}
