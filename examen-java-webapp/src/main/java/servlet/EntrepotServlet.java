package servlet;

import javax.servlet.annotation.WebServlet;

@WebServlet( "/EntrepotServlet" )
public class EntrepotServlet extends AbstractServlet {

    private static final String LISTE_ENTREPOT        = "getListeEntrepot";

    private static final String AJOUT_ENTREPOT_ACTION = "ajoutEntrepot";

    private static final String DETAIL_ENTREPOT       = "getEntrepotDetail";

    private static final String MODIF_ENTREPOT        = "modifierEntrepot";

    private static final String SUPPRIMER_ENTREPOT    = "supprimerEntrepot";
    /*
     * protected void doGet( HttpServletRequest request, HttpServletResponse
     * response ) throws ServletException, IOException { initialize( request,
     * response );
     * 
     * try { WebServiceSessionBean webService = getWebService();
     * 
     * switch ( action ) { case LISTE_ENTREPOT: getListeEntrepot( webService,
     * request ); break; case AJOUT_ENTREPOT_ACTION: ajoutEntrepot( webService,
     * request ); break; case DETAIL_ENTREPOT: getDetailEntrepot( webService,
     * request ); break; case MODIF_ENTREPOT: modifierEntrepot( webService,
     * request ); break; case SUPPRIMER_ENTREPOT: supprimetEntrepot( webService,
     * request ); default: break; }
     * 
     * } catch ( MalformedURLException e ) { redirectionToView( HOME_PAGE ); }
     * 
     * }
     * 
     * private void getListeEntrepot( WebServiceSessionBean webservice,
     * HttpServletRequest request ) throws ServletException, IOException {
     * List<Entrepot> entrepots = webservice.getByIdProfil( 2 );
     * this.request.setAttribute( "listeEntrepots", entrepots );
     * redirectionToView( LISTE_ENTREPOT ); }
     * 
     * private void modifierCompteVendeur( WebServiceSessionBean webservice,
     * HttpServletRequest request ) throws ServletException, IOException {
     * Utilisateur utilisateur = new Utilisateur(); utilisateur.setId(
     * Integer.parseInt( request.getParameter( "id" ) ) );
     * utilisateur.setPrenom( request.getParameter( "prenom" ) );
     * utilisateur.setNom( request.getParameter( "nom" ) );
     * utilisateur.setIdProfil( 2 ); utilisateur.setMail( request.getParameter(
     * "email" ) ); utilisateur.setPassword( request.getParameter( "password" )
     * ); utilisateur.setLogin( request.getParameter( "login" ) );
     * 
     * Utilisateur compteVendeur = webservice.modifierUtilisateur( utilisateur
     * ); this.request.setAttribute( "compteVendeur", compteVendeur );
     * this.getListeCompteVendeur( webservice, request ); }
     * 
     * private void getDetailCompteVendeur( WebServiceSessionBean webservice,
     * HttpServletRequest request ) throws ServletException, IOException {
     * Utilisateur compteVendeur = webservice.getByUtilisateurId(
     * Integer.parseInt( request.getParameter( "id" ) ) );
     * this.request.setAttribute( "compteVendeur", compteVendeur );
     * redirectionToView( DETAIL_COMPTE_VENDEUR_PAGE ); }
     * 
     * private void supprimerUtilisateur( WebServiceSessionBean webservice,
     * HttpServletRequest request ) throws ServletException, IOException {
     * webservice.supprimerUtilisateur( Integer.parseInt( request.getParameter(
     * "id" ) ) ); this.getListeCompteVendeur( webservice, request ); }
     * 
     * private void ajoutCompteVendeur( WebServiceSessionBean webservice,
     * HttpServletRequest request ) throws ServletException, IOException {
     * 
     * Utilisateur utilisateur = new Utilisateur(); utilisateur.setPrenom(
     * request.getParameter( "prenom" ) ); utilisateur.setNom(
     * request.getParameter( "nom" ) ); utilisateur.setIdProfil( 2 );
     * utilisateur.setMail( request.getParameter( "email" ) );
     * utilisateur.setPassword( request.getParameter( "password" ) );
     * utilisateur.setLogin( request.getParameter( "login" ) );
     * 
     * Utilisateur compteVendeur = webservice.creerUtilisateur( utilisateur );
     * this.getListeCompteVendeur( webservice, request ); }
     */
}
