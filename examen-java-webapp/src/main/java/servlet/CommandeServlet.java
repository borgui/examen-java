package servlet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.resteasy.spi.HttpRequest;

import webservice.Categorie;
import webservice.Commande;
import webservice.CommandeStatus;
import webservice.Panier;
import webservice.WebServiceSessionBean;

@WebServlet("/CommandeServlet")
public class CommandeServlet extends AbstractServlet {
	
	private static final String LISTE_COMMANDE_CLIENT_ACTION = "getListeCommandeClient";
	private static final String AJOUT_COMMANDE_ACTION = "ajouterCommande";
	private static final String LISTE_COMMANDE_PAGE = "ListeCommande";

	


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		initialize(request, response);
		

		try {
			WebServiceSessionBean webService = getWebService();

			switch (action) {
			case LISTE_COMMANDE_CLIENT_ACTION:
				getListeCommandeClient(webService, request);
				break;
			case AJOUT_COMMANDE_ACTION:
				ajoutCommande(webService, request);
				break;
			default:
				break;
			}

		} catch (MalformedURLException e) {
			redirectionToView(HOME_PAGE);
		}

	}
	
	private void getListeCommandeClient(WebServiceSessionBean webservice, HttpServletRequest request) throws ServletException, IOException{
		List<Commande> commandes = webservice.getCommandeByClient((Integer) session.getAttribute("id"));
		this.request.setAttribute("listeCommande", commandes);
		redirectionToView(LISTE_COMMANDE_PAGE);
	}
	
	
	
	private void ajoutCommande(WebServiceSessionBean webservice, HttpServletRequest request) throws ServletException, IOException{
		
		Commande commande = new Commande();
		commande.setDate(new Date());
		
		Panier panier = new Panier();
		panier.setId(Integer.parseInt(request.getParameter("idPanier")));
		
		CommandeStatus status = new CommandeStatus();
		status.setId(1);
		commande.setStatus(status);
		commande.setPanier(panier);
		commande = webservice.ajouterCommande(commande);
		this.getListeCommandeClient(webservice, request);
	}

}
