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
import webservice.Entrepot;
import webservice.Produit;
import webservice.WebServiceSessionBean;

@WebServlet("/ProduitServlet")
public class ProduitServlet extends AbstractServlet {
	
	private static final String PRODUIT_ACTION = "getProduitVendeur";
	private static final String PRODUIT_PAGE = "ListeProduit";
	
	private static final String PRODUIT_CATEGORIE = "getProduitCategorie";

	
	private static final String AJOUT_PRODUIT_ACTION = "ajouterProduit";

	private static final String DETAIL_PRODUIT_ACTION = "getProduitDetail";
	
	private static final String DETAIL_PRODUIT_PAGE = "ProduitDetail";
	
	private static final String MODIF_PRODUIT_ACTION = "modifierProduit";

	private static final String SUPPRIMER_PRODUIT_ACTION = "supprimerProduit";


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		initialize(request, response);
		

		try {
			WebServiceSessionBean webService = getWebService();

			switch (action) {
			case PRODUIT_CATEGORIE:
				getCategorieProduit(webService, request);
			case PRODUIT_ACTION:
				getListeProduit(webService, request);
				break;
			case AJOUT_PRODUIT_ACTION:
				ajoutProduit(webService, request);
				break;
			case DETAIL_PRODUIT_ACTION:
				getDetailProduit(webService, request);
				break;
			case MODIF_PRODUIT_ACTION:
				modifierProduit(webService, request);
				break;
			case SUPPRIMER_PRODUIT_ACTION:
				supprimerProduit(webService, request);
				break;
			default:
				break;
			}

		} catch (MalformedURLException e) {
			redirectionToView(HOME_PAGE);
		}

	}
	private void getCategorieProduit(WebServiceSessionBean webservice, HttpServletRequest request) throws ServletException, IOException{
		List<Produit> produits = webservice.getProduitByCategorie(Integer.parseInt(request.getParameter("categorieId")));
		this.request.setAttribute("listeProduit", produits);
		redirectionToView(PRODUIT_CATEGORIE_PAGE);
	}
	
	private void getListeProduit(WebServiceSessionBean webservice, HttpServletRequest request) throws ServletException, IOException{
		List<Produit> produits = webservice.getProduitsByUserId((Integer) this.session.getAttribute("id"));
		//Additional entities
		List<Entrepot> entrepots = webservice.getEntrepots();
		List<Categorie> categories = webservice.getCategories();

		this.request.setAttribute("listeProduit", produits);
		this.request.setAttribute("listeEntrepot", entrepots);
		this.request.setAttribute("listeCategorie", categories);
		redirectionToView(PRODUIT_PAGE);
	}
	
	private void modifierProduit(WebServiceSessionBean webservice, HttpServletRequest request) throws ServletException, IOException{
		Produit produit = new Produit();
		produit.setId(Integer.parseInt(request.getParameter("id")));
		produit.setStock(Integer.parseInt(request.getParameter("stock")));
		produit.setNom(request.getParameter("nom"));
		produit.setDescription(request.getParameter("description"));
		produit.setPrix(Double.parseDouble(request.getParameter("prix")));
		produit.setIdVendeur((Integer) this.session.getAttribute("id"));
		
		Entrepot entrepot = new Entrepot();
		entrepot.setId(Integer.parseInt(request.getParameter("idEntrepot")));
		produit.setEntrepot(entrepot);

		Categorie categorie = new Categorie();
		categorie.setId(Integer.parseInt(request.getParameter("idCategorie")));
		produit.setCategorie(categorie);
		
		produit = webservice.modifierProduit(produit);
		this.request.setAttribute("produit", produit);

		this.getListeProduit(webservice, request);
	}
	
	private void getDetailProduit(WebServiceSessionBean webservice, HttpServletRequest request) throws ServletException, IOException{
			Produit produit = webservice.getProduitById(Integer.parseInt(request.getParameter("id")));
			
			//Additional entities
			List<Entrepot> entrepots = webservice.getEntrepots();
			List<Categorie> categories = webservice.getCategories();

			this.request.setAttribute("produit", produit);
			this.request.setAttribute("listeEntrepot", entrepots);
			this.request.setAttribute("listeCategorie", categories);
			redirectionToView(DETAIL_PRODUIT_PAGE);
	}
	
	private void supprimerProduit(WebServiceSessionBean webservice, HttpServletRequest request) throws ServletException, IOException{
		webservice.supprimerProduit(Integer.parseInt(request.getParameter("id")));
        setVariableToView( "alert-success", "Produit supprimé" );

		this.getListeProduit(webservice, request);
	}
	
	
	private void ajoutProduit(WebServiceSessionBean webservice, HttpServletRequest request) throws ServletException, IOException{
		
		Produit produit = new Produit();
		produit.setStock(Integer.parseInt(request.getParameter("stock")));
		produit.setNom(request.getParameter("nom"));
		produit.setDescription(request.getParameter("description"));
		produit.setPrix(Double.parseDouble(request.getParameter("prix")));
		produit.setIdVendeur((Integer) this.session.getAttribute("id"));
		
		Entrepot entrepot = new Entrepot();
		entrepot.setId(Integer.parseInt(request.getParameter("idEntrepot")));
		produit.setEntrepot(entrepot);

		Categorie categorie = new Categorie();
		categorie.setId(Integer.parseInt(request.getParameter("idCategorie")));
		produit.setCategorie(categorie);

		produit = webservice.creerProduit(produit);
        setVariableToView( "alert-success", "Produit " + produit.getNom() + " ajouté" );
		this.getListeProduit(webservice, request);
	}

}
