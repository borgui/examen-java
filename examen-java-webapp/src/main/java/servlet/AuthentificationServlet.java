package servlet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import webservice.Paiement;
import webservice.Utilisateur;
import webservice.WebServiceSessionBean;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/AuthentificationServlet")
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// === Profil ID === //
	private static final int CLIENT = 1;
	private static final int VENDEUR = 2;
	private static final int ADMINISTRATEUR = 3;
	// === JSP === //
	private static final String HOME_PAGE = "Home";
	private static final String CONNEXION_PAGE = "Connexion";
	private static final String CONNEXION_ACTION = "connexion";
	private static final String DECONNEXION_ACTION = "deconnexion";

	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private String action;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		initialize(request, response);

		try {
			// URL url = new
			// URL("http://DESKTOP-FDOSAPS:8080/exam-java-ws/WebServiceSessionBean?wsdl");
			URL url = new URL("http://localhost:8080/examen-java-webservice/WebServiceSessionBean?wsdl");
			QName qname = new QName("http://webservice/", "WebServiceSessionBeanService");
			Service service = Service.create(url, qname);
			WebServiceSessionBean webService = service.getPort(WebServiceSessionBean.class);

			switch (action) {
			case CONNEXION_ACTION:
				connectUser(webService, request);
				break;
			case DECONNEXION_ACTION:
				disconnectUser();
				break;
			default:
				break;
			}

		} catch (MalformedURLException e) {
			redirectionToView(HOME_PAGE);
		}

	}

	private void disconnectUser() {
		// TODO Auto-generated method stub
		
	}

	private void connectUser(WebServiceSessionBean webService, HttpServletRequest request) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Utilisateur utilisateur = webService.getConnexion(login,password);
			if (utilisateur != null) {
				httpSession(login, password);
				int idProfil = utilisateur.getIdProfil();

				switch (idProfil) {
				case CLIENT:
					session.setAttribute("session-role", "client");
					break;
				case VENDEUR:
					session.setAttribute("session-role", "vendeur");
					break;
				case ADMINISTRATEUR:
					session.setAttribute("session-role", "admin");
					break;
				default:
					break;
				}

				redirectionToView(HOME_PAGE);
			} else {
				setVariableToView("alert-danger", "Identifiants incorrect");
				redirectionToView(CONNEXION_PAGE);
			}
	}
	
	private void redirectionToView(String view) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(view + ".jsp");
		dispatcher.include(request, response);
	}
	
	protected void httpSession(String login, String password) {
		session.setAttribute("login", login);
		session.setAttribute("password", password);
	}

	private void setVariableToView(String variable, String message) {
		request.setAttribute(variable, message);
	}

	public void initialize(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.request = request;
		this.response = response;
		this.session = request.getSession();

		action = request.getParameter("action");

		response.setContentType("text/html");
	}
}
