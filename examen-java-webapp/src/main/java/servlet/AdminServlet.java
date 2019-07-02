package servlet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.resteasy.spi.HttpRequest;

import webservice.Utilisateur;
import webservice.WebServiceSessionBean;

@WebServlet("/AdminServlet")
public class AdminServlet extends AbstractServlet {
	
	private static final String LISTE_COMPTE_VENDEUR_ACTION = "getListeCompteVendeur";
	
	private static final String LISTE_COMPTE_VENDEUR_PAGE = "ListeCompteVendeur";


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		initialize(request, response);
		

		try {
			WebServiceSessionBean webService = getWebService();

			switch (action) {
			case LISTE_COMPTE_VENDEUR_ACTION:
				getListeCompteVendeur(webService, request);
				break;
			default:
				break;
			}

		} catch (MalformedURLException e) {
			redirectionToView(HOME_PAGE);
		}

	}
	
	private void getListeCompteVendeur(WebServiceSessionBean webservice, HttpServletRequest request) throws ServletException, IOException{
		List<Utilisateur> compteVendeur = webservice.getByIdProfil(2);
		this.request.setAttribute("listeCompteVendeur", compteVendeur);
		redirectionToView(LISTE_COMPTE_VENDEUR_PAGE);
	}
}
