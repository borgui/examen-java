package servlet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import webservice.WebServiceSessionBean;

public class AbstractServlet extends HttpServlet {

	protected static final long serialVersionUID = 1L;
	// === Profil ID === //
	protected static final int CLIENT = 1;
	protected static final int VENDEUR = 2;
	protected static final int ADMINISTRATEUR = 3;
	// === JSP === //
	protected static final String HOME_PAGE = "Home";
	protected static final String CONNEXION_PAGE = "Connexion";
	protected static final String CONNEXION_ACTION = "connexion";
	protected static final String DECONNEXION_ACTION = "deconnexion";
	
	protected static final String INSCRIPTION_ACTION = "inscription";

	
	protected static final String PRODUIT_CATEGORIE_PAGE = "ProduitCategorie";
	
	protected static final String PANIER_PAGE = "Panier";
	
	protected static final String PANIER = "getPanier";




	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	protected String action;
	
	protected void initialize(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.request = request;
		this.response = response;
		this.session = request.getSession();

		action = request.getParameter("action");

		response.setContentType("text/html");
	}
	
	protected WebServiceSessionBean getWebService() throws MalformedURLException{
		// URL url = new
		// URL("http://DESKTOP-FDOSAPS:8080/exam-java-ws/WebServiceSessionBean?wsdl");
		URL url = new URL("http://localhost:8080/examen-java-webservice/WebServiceSessionBean?wsdl");
		QName qname = new QName("http://webservice/", "WebServiceSessionBeanService");
		Service service = Service.create(url, qname);
		return service.getPort(WebServiceSessionBean.class);
	}
	
	
	protected void redirectionToView(String view) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(view + ".jsp");
		dispatcher.include(request, response);
	}
	
	protected void httpSession(String login, String password, Integer id) {
		session.setAttribute("login", login);
		session.setAttribute("password", password);
		session.setAttribute("id", id);
	}

	protected void setVariableToView(String variable, String message) {
		request.setAttribute(variable, message);
	}
}
