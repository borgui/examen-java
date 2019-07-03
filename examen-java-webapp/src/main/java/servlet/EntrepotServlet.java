package servlet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.Entrepot;
import webservice.WebServiceSessionBean;

@WebServlet("/EntrepotServlet")
public class EntrepotServlet extends AbstractServlet {

	private static final String LISTE_ENTREPOT = "getListeEntrepot";
	private static final String LISTE_ENTREPOT_PAGE = "ListeEntrepot";


	private static final String AJOUT_ENTREPOT_ACTION = "ajoutEntrepot";

	private static final String DETAIL_ENTREPOT = "getEntrepotDetail";
	private static final String DETAIL_ENTREPOT_PAGE = "EntrepotDetail";


	private static final String MODIF_ENTREPOT = "modifierEntrepot";

	private static final String SUPPRIMER_ENTREPOT = "supprimerEntrepot";
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		initialize(request, response);

		try {
			WebServiceSessionBean webService = getWebService();

			switch (action) {
			case LISTE_ENTREPOT:
				getListeEntrepot(webService, request);
				break;
			case AJOUT_ENTREPOT_ACTION:
				ajoutEntrepot(webService, request);
				break;
			case DETAIL_ENTREPOT:
				getDetailEntrepot(webService, request);
				break;
			case MODIF_ENTREPOT:
				modifierEntrepot(webService, request);
				break;
			case SUPPRIMER_ENTREPOT:
				supprimerEntrepot(webService, request);
			default:
				break;
			}

		} catch (MalformedURLException e) {
			redirectionToView(HOME_PAGE);
		}

	}

	private void getListeEntrepot(WebServiceSessionBean webservice, HttpServletRequest request)
			throws ServletException, IOException {
		List<Entrepot> entrepots = webservice.getEntrepots();
		this.request.setAttribute("listeEntrepot", entrepots);
		redirectionToView(LISTE_ENTREPOT_PAGE);
	}

	private void modifierEntrepot(WebServiceSessionBean webservice, HttpServletRequest request)
			throws ServletException, IOException {
		Entrepot entrepot = new Entrepot();
		entrepot.setId(Integer.parseInt(request.getParameter("id")));
		entrepot.setPays(request.getParameter("pays"));
		entrepot.setNom(request.getParameter("nom"));


		entrepot = webservice.modifierEntrepot(entrepot);
		this.request.setAttribute("entrepot", entrepot);
		
		this.getListeEntrepot(webservice, request);
	}

	private void getDetailEntrepot(WebServiceSessionBean webservice, HttpServletRequest request)
			throws ServletException, IOException {
		Entrepot entrepot = webservice.getEntrepotById(Integer.parseInt(request.getParameter("id")));
		this.request.setAttribute("entrepot", entrepot);
		redirectionToView(DETAIL_ENTREPOT_PAGE);
	}

	private void supprimerEntrepot(WebServiceSessionBean webservice, HttpServletRequest request)
			throws ServletException, IOException {
		webservice.supprimerEntrepot(Integer.parseInt(request.getParameter("id")));
        setVariableToView( "alert-success", "Entrepot supprimé" );

		this.getListeEntrepot(webservice, request);
	}

	private void ajoutEntrepot(WebServiceSessionBean webservice, HttpServletRequest request)
			throws ServletException, IOException {

		Entrepot entrepot = new Entrepot();
		entrepot.setNom(request.getParameter("nom"));
		entrepot.setPays(request.getParameter("pays"));

		entrepot = webservice.creerEntrepot(entrepot);
        setVariableToView( "alert-success", "Entrepot " + entrepot.getNom() + " ajouté" );

		this.getListeEntrepot(webservice, request);
	}

}
