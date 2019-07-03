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
import webservice.Produit;
import webservice.WebServiceSessionBean;

@WebServlet("/ProduitServlet")
public class ProduitServlet extends AbstractServlet {
	
	private static final String PRODUIT_CATEGORIE = "getProduitCategorie";

	
	private static final String PRODUIT_CATEGORIE_PAGE = "ProduitCategorie";
	
	private static final String AJOUT_CATEGORIE_ACTION = "ajouterCategorie";

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
			case PRODUIT_CATEGORIE:
				getListeCategorie(webService, request);
				break;
			default:
				break;
			}

		} catch (MalformedURLException e) {
			redirectionToView(HOME_PAGE);
		}

	}
	
	private void getListeCategorie(WebServiceSessionBean webservice, HttpServletRequest request) throws ServletException, IOException{
		List<Produit> produits = webservice.getProduitByCategorie(Integer.parseInt(request.getParameter("categorieId")));
		this.request.setAttribute("listeProduit", produits);
		redirectionToView(PRODUIT_CATEGORIE_PAGE);
	}
	
	private void modifierCategorie(WebServiceSessionBean webservice, HttpServletRequest request) throws ServletException, IOException{
		Categorie categorie = new Categorie();
		categorie.setId(Integer.parseInt(request.getParameter("id")));
		categorie.setLibelle(request.getParameter("libelle"));
		
		Categorie Categorie = webservice.modifierCategorie(categorie);
		this.request.setAttribute("Categorie", Categorie);
		this.getListeCategorie(webservice, request);
	}
	
	private void getDetailCategorie(WebServiceSessionBean webservice, HttpServletRequest request) throws ServletException, IOException{
			Categorie Categorie = webservice.getCategorieById(Integer.parseInt(request.getParameter("id")));
			this.request.setAttribute("Categorie", Categorie);
			redirectionToView(DETAIL_CATEGORIE_PAGE);
	}
	
	private void supprimercategorie(WebServiceSessionBean webservice, HttpServletRequest request) throws ServletException, IOException{
		webservice.supprimerCategorie(Integer.parseInt(request.getParameter("id")));
		this.getListeCategorie(webservice, request);
	}
	
	
	private void ajoutCategorie(WebServiceSessionBean webservice, HttpServletRequest request) throws ServletException, IOException{
		
		Categorie categorie = new Categorie();
		categorie.setLibelle(request.getParameter("libelle"));

		categorie = webservice.creerCategorie(categorie);
		this.getListeCategorie(webservice, request);
	}

}
