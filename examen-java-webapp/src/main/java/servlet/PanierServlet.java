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

@WebServlet("/ProduitServlet")
public class PanierServlet extends AbstractServlet {
	
	private static final String PANIER = "getPanier";

	
	private static final String PANIER_PAGE = "Panier";
	
	private static final String AJOUT_PRODUIT = "ajouterProduit";

	private static final String DETAIL_CATEGORIE_ACTION = "getCategorieDetail";
	
	private static final String DETAIL_CATEGORIE_PAGE = "CategorieDetail";
	
	private static final String MODIF_CATEGORIE_ACTION = "modifierCategorie";

	private static final String SUPPRIMER_CATEGORIE_ACTION = "supprimerCategorie";


	
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
		panier.setIdUser(Integer.parseInt((String) session.getAttribute("id")));
		panier = webservice.creerPanier(panier);
		
		return panier;
	}
	
	private void getPanier(WebServiceSessionBean webservice, HttpServletRequest request) throws ServletException, IOException{
		Panier panier = webservice.getPanierByUserId(Integer.parseInt((String) session.getAttribute("id")));
		if(panier == null) {
			panier = this.creerPanier(webservice, request);
			panier.setIdUser(Integer.parseInt((String) session.getAttribute("id")));
		}		
		
		request.setAttribute("panier", panier);
		redirectionToView(PANIER_PAGE);
	}
	
	private void ajouterProduit(WebServiceSessionBean webservice, HttpServletRequest request) throws ServletException, IOException{
		
		Panier panier = webservice.getPanierByUserId(Integer.parseInt((String) session.getAttribute("id")));
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
	}

}
