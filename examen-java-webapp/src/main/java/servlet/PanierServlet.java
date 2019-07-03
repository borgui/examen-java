package servlet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.resteasy.spi.HttpRequest;

import webservice.Categorie;
import webservice.Panier;
import webservice.PanierProduit;
import webservice.Produit;
import webservice.WebServiceSessionBean;

@WebServlet("/PanierServlet")
public class PanierServlet extends AbstractServlet {
	
	private static final String PANIER = "getPanier";

	
	private static final String PANIER_PAGE = "Panier";
	
	private static final String AJOUT_PRODUIT = "ajouterProduit";



	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		initialize(request, response);
		

		try {
			WebServiceSessionBean webService = getWebService();

			switch (action) {
			case PANIER:
				getPanier(webService, request);
				break;
			case AJOUT_PRODUIT:
				ajouterProduit(webService, request);
				break;
			default:
				break;
			}

		} catch (MalformedURLException e) {
			redirectionToView(HOME_PAGE);
		}

	}
	

	
	
	private Panier creerPanier(WebServiceSessionBean webservice, HttpServletRequest request) throws ServletException, IOException{
		Panier panier = new Panier();
		panier.setIdUser((Integer) session.getAttribute("id"));
		panier = webservice.creerPanier(panier);
		
		return panier;
	}
	
	private void getPanier(WebServiceSessionBean webservice, HttpServletRequest request) throws ServletException, IOException{
		Integer userId = (Integer) session.getAttribute("id");
		Panier panier = null;
		try {
			panier = webservice.getPanierByUserId(userId);
		} catch(Exception e){
			System.out.print(e.getMessage());
		}
		
		if(panier == null) {
			panier = this.creerPanier(webservice, request);
			panier.setIdUser((Integer) session.getAttribute("id"));
		}		
		
		request.setAttribute("panier", panier);
		redirectionToView(PANIER_PAGE);
	}
	
	private void ajouterProduit(WebServiceSessionBean webservice, HttpServletRequest request) throws ServletException, IOException{
		
		Panier panier = webservice.getPanierByUserId((Integer) session.getAttribute("id"));
		if(panier == null) {
			panier = this.creerPanier(webservice, request);
		}
		
		PanierProduit panierProduit = new PanierProduit();
		panierProduit.setIdPanier(panier.getId());
		Produit produit = new Produit();
		produit.setId(Integer.parseInt(request.getParameter("idProduit")));
		panierProduit.setQuantite(Integer.parseInt(request.getParameter("quantite")));
		panierProduit.setProduit(produit);
		webservice.creerPanierProduit(panierProduit);
		redirectionToView(PRODUIT_CATEGORIE_PAGE);
	}

}
