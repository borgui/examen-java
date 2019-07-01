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

import webservice.AccuseReception;
import webservice.Commande;
import webservice.Facture;
import webservice.Fournisseur;
import webservice.Livraison;
import webservice.Paiement;
import webservice.Utilisateur;
import webservice.WebServiceSessionBean;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// === Profil ID === //
	private static final int RESPONSABLE_ACHAT_PROFIL_ID = 1;
	private static final int RESPONSABLE_STOCK_PROFIL_ID = 2;
	private static final int COMPTABLE_PROFIL_ID = 3;
	// === JSP === //
	private static final String HOME_PAGE = "Home";
	private static final String CONNEXION_PAGE = "Connexion";
	private static final String LISTE_FACTURES_PAGE = "ListeFactures";
	private static final String DETAILS_FACTURE_PAGE = "Facture";
	private static final String LISTE_LIVRAISONS_PAGE = "ListeLivraisons";
	private static final String DETAILS_LIVRAISON_PAGE = "Livraison";
	private static final String LISTE_ACCUSES_RECEPTIONS_PAGE = "ListeAccusesReceptions";
	private static final String DETAILS_ACCUSE_RECEPTION_PAGE = "AccuseReception";
	private static final String LISTE_COMMANDES_PAGE = "ListeCommandes";
	private static final String COMMANDE_DETAIL_PAGE = "CommandeDetail";
	private static final String LISTE_PAIEMENTS_PAGE = "ListePaiements";
	// === Action === //
	private static final String CONNEXION_ACTION = "connexion";
	private static final String DECONNEXION_ACTION = "deconnexion";
	private static final String LISTE_COMMANDES_ACTION = "listeCommandes";
	private static final String COMMANDE_DETAIL_ACTION = "commandeDetail";
	private static final String EDIT_COMMANDE_ACTION = "editCommande";
	private static final String ADD_COMMANDE_ACTION = "addCommande";
	private static final String AJOUTER_COMMANDE = "ajouterCommande";
	private static final String LISTE_PAIEMENTS_ACTION = "listePaiements";
	private static final String AJOUT_PAIEMENT = "ajoutPaiement";
	private static final String LISTE_FACTURES_ACTION = "listeFactures";
	private static final String FACTURE_ACTION = "detailsFacture";
	private static final String AJOUT_FACTURE = "ajoutFacture";
	private static final String LISTE_LIVRAISONS_ACTION = "listeLivraisons";
	private static final String LIVRAISON_ACTION = "detailsLivraison";
	private static final String LISTE_ACCUSES_RECEPTIONS_ACTION = "listeAccusesReceptions";
	private static final String ACCUSE_RECEPTION_ACTION = "detailsAccuseReception";
	private static final String AJOUT_ACCUSE_RECEPTION_ACTION = "ajoutAccuseReception";

	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private String action;
	private String login;
	private String mdp;
	private String idFacture;
	private String idLivraison;
	private String idAccuseReception;
	private String idCommande;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		initialize(request, response);

		try {
			// URL url = new
			// URL("http://DESKTOP-FDOSAPS:8080/exam-java-ws/WebServiceSessionBean?wsdl");
			URL url = new URL("http://Junzi:8080/exam-java-ws/WebServiceSessionBean?wsdl");
			QName qname = new QName("http://webservice/", "WebServiceSessionBeanService");
			Service service = Service.create(url, qname);
			WebServiceSessionBean webService = service.getPort(WebServiceSessionBean.class);

			switch (action) {
			case CONNEXION_ACTION:
				connexionActionPerformed(webService);
				break;
			case DECONNEXION_ACTION:
				deconnexionActionPerformed();
				break;
			case LISTE_FACTURES_ACTION:
				listeFacturesActionPerformed(webService);
				break;
			case FACTURE_ACTION:
				factureActionPerformed(webService);
				break;
			case AJOUT_FACTURE:
				ajoutFactureActionPerformed(webService);
				break;
			case LISTE_LIVRAISONS_ACTION:
				listeLivraisonsActionPerformed(webService);
				break;
			case LIVRAISON_ACTION:
				livraisonActionPerformed(webService);
				break;
			case LISTE_ACCUSES_RECEPTIONS_ACTION:
				listeAccusesReceptionsActionPerformed(webService);
				break;
			case ACCUSE_RECEPTION_ACTION:
				accuseReceptionActionPerformed(webService);
				break;
			case AJOUT_ACCUSE_RECEPTION_ACTION:
				ajouterAccuseReceptionActionPerformed(webService);
				break;
			case LISTE_COMMANDES_ACTION:
				listeCommandesActionPerformed(webService);
				break;
			case COMMANDE_DETAIL_ACTION:
				commandeDetailActionPerformed(webService);
				break;
			case LISTE_PAIEMENTS_ACTION:
				listePaiementsActionPerformed(webService);
				break;
			case EDIT_COMMANDE_ACTION:
				editCommandeActionPerformed(webService);
				break;
			case ADD_COMMANDE_ACTION:
				addCommandeActionPerformed(webService);
				break;
			case AJOUTER_COMMANDE:
				ajouterCommandeActionPerformed(webService);
				break;
			case AJOUT_PAIEMENT:
				ajoutPaiementActionPerformed(webService);
				break;
			default:
				break;
			}

		} catch (MalformedURLException e) {
			redirectionToView(HOME_PAGE);
		}

	}

	/**
	 * Liste des factures
	 * 
	 * @param webService
	 * @throws IOException
	 * @throws ServletException
	 */
	private void listeFacturesActionPerformed(WebServiceSessionBean webService) throws ServletException, IOException {
		if(session.getAttribute("session-role") == "comptable") {
			List<Facture> listeFactures = webService.getFactures();
			this.request.setAttribute("listeFactures", listeFactures);
			redirectionToView(LISTE_FACTURES_PAGE);
		}  else {
			setVariableToView("alert-danger", "Vous n'avez pas les droits necessaires pour acceder à cette page");
			redirectionToView(HOME_PAGE);
		}
	}

	/**
	 * Détails d'une facture
	 * 
	 * @param webService
	 * @throws IOException
	 * @throws ServletException
	 */
	private void factureActionPerformed(WebServiceSessionBean webService) throws ServletException, IOException {
		if(session.getAttribute("session-role") == "comptable") {
			try {
				int idFactureNumber = Integer.valueOf(this.idFacture);
				Facture facture = webService.getFacture(idFactureNumber);
				this.request.setAttribute("detailsFacture", facture);
				redirectionToView(DETAILS_FACTURE_PAGE);
			} catch (NumberFormatException exception) {
				setVariableToView("alert-danger", "Facture introuvable");
				redirectionToView(HOME_PAGE);
			}
		}  else {
			setVariableToView("alert-danger", "Vous n'avez pas les droits necessaires pour acceder à cette page");
			redirectionToView(HOME_PAGE);
		}
	}

	/**
	 * Ajout d'une facture
	 * 
	 * @param webService
	 * @throws IOException
	 * @throws ServletException
	 */
	private void ajoutFactureActionPerformed(WebServiceSessionBean webService) throws ServletException, IOException {
		if (session.getAttribute("session-role") == "comptable") {
			try {
				int idCommande = Integer.valueOf(this.idCommande);
				AccuseReception accuseReception = webService.findAccuseReceptionByIdCommande(idCommande);
				Facture facture = webService.findFactureByIdCommande(idCommande);
				if (accuseReception != null && facture == null) {
					boolean isAdded = webService.ajoutFacture(idCommande);
					if (isAdded) {
						this.listeFacturesActionPerformed(webService);
					} else {
						setVariableToView("alert-danger", "L'ajout de la facture a echoue");
						redirectionToView(HOME_PAGE);
					}
				} else {
					setVariableToView("alert-danger",
							"L'ajout de la facture est impossible. Soit la commande n'a pas été réceptionné, soit il existe déjà une facture pour cette commande");
					redirectionToView(HOME_PAGE);
				}
			} catch (NumberFormatException exception) {
				setVariableToView("alert-danger", "Facture introuvable");
				redirectionToView(HOME_PAGE);
			}
		} else {
			setVariableToView("alert-danger", "Vous n'avez pas les droits necessaires pour acceder à cette page");
			redirectionToView(HOME_PAGE);
		}
	}

	/**
	 * Liste des livraisons
	 * 
	 * @param webService
	 * @throws IOException
	 * @throws ServletException
	 */
	private void listeLivraisonsActionPerformed(WebServiceSessionBean webService) throws ServletException, IOException {
		if(session.getAttribute("session-role") == "responsableStock") {
			List<Livraison> listeLivraisons = webService.getLivraisons();
			this.request.setAttribute("listeLivraisons", listeLivraisons);
			redirectionToView(LISTE_LIVRAISONS_PAGE);
		} else {
			setVariableToView("alert-danger", "Vous n'avez pas les droits necessaires pour acceder à cette page");
			redirectionToView(HOME_PAGE);
		}
	}

	/**
	 * Détails d'une livraison
	 * 
	 * @param webService
	 * @throws IOException
	 * @throws ServletException
	 */
	private void livraisonActionPerformed(WebServiceSessionBean webService) throws ServletException, IOException {
		if(session.getAttribute("session-role") == "responsableStock") {
			try {
				int idLivraisonNumber = Integer.valueOf(this.idLivraison);
				Livraison livraison = webService.getLivraison(idLivraisonNumber);
				this.request.setAttribute("detailsLivraison", livraison);
				redirectionToView(DETAILS_LIVRAISON_PAGE);
			} catch (NumberFormatException exception) {
				setVariableToView("alert-danger", "Livraison introuvable");
				redirectionToView(HOME_PAGE);
			}
		} else {
			setVariableToView("alert-danger", "Vous n'avez pas les droits necessaires pour acceder à cette page");
			redirectionToView(HOME_PAGE);
		}
	}

	/**
	 * Liste des accusés réceptions
	 * 
	 * @param webService
	 * @throws IOException
	 * @throws ServletException
	 */
	private void listeAccusesReceptionsActionPerformed(WebServiceSessionBean webService)
			throws ServletException, IOException {
		if(session.getAttribute("session-role") == "responsableStock") {
			List<AccuseReception> listeAccusesReceptions = webService.getAccusesReceptions();
			this.request.setAttribute("listeAccusesReceptions", listeAccusesReceptions);
			redirectionToView(LISTE_ACCUSES_RECEPTIONS_PAGE);
		} else {
			setVariableToView("alert-danger", "Vous n'avez pas les droits necessaires pour acceder à cette page");
			redirectionToView(HOME_PAGE);
		}
	}

	/**
	 * Détails d'un accusé réception
	 * 
	 * @param webService
	 * @throws IOException
	 * @throws ServletException
	 */
	private void accuseReceptionActionPerformed(WebServiceSessionBean webService) throws ServletException, IOException {
		if(session.getAttribute("session-role") == "responsableStock") {
			try {
				int idAccuseReceptionNumber = Integer.valueOf(this.idAccuseReception);
				AccuseReception accuseReception = webService.getAccuseReception(idAccuseReceptionNumber);
				this.request.setAttribute("detailsAccuseReception", accuseReception);
				redirectionToView(DETAILS_ACCUSE_RECEPTION_PAGE);
			} catch (NumberFormatException exception) {
				setVariableToView("alert-danger", "Accusé réception introuvable");
				redirectionToView(HOME_PAGE);
			}
		} else {
			setVariableToView("alert-danger", "Vous n'avez pas les droits necessaires pour acceder à cette page");
			redirectionToView(HOME_PAGE);
		}
	}

	/**
	 * Ajout d'un accusé réception
	 * 
	 * @param webService
	 * @throws IOException
	 * @throws ServletException
	 */
	private void ajouterAccuseReceptionActionPerformed(WebServiceSessionBean webService)
			throws ServletException, IOException {
		if (session.getAttribute("session-role") == "responsableStock") {
			try {
				int idCommandeNumber = Integer.valueOf(this.idCommande);
				boolean existeCommande = webService.existeCommandeById(idCommandeNumber);
				if (existeCommande) {
					boolean existeLivraison = webService.existeLivraisonByCommandId(idCommandeNumber);
					if (existeLivraison) {
						boolean existeAccuseReception = webService.existeAccuseReceptionByIdCommande(idCommandeNumber);
						if (!existeAccuseReception) {
							Livraison livraison = webService.findLivraisonByCommandId(idCommandeNumber);
							AccuseReception accuseReception = new AccuseReception();
							accuseReception.setIdCommande(idCommandeNumber);
							accuseReception.setIdLivraison(livraison.getId());
							boolean ajoutOk = webService.ajoutAccuseReception(accuseReception);

							if (ajoutOk) {
								setVariableToView("alert-success", "Accusé réception pris en compte");
								redirectionToView(HOME_PAGE);
							} else {
								setVariableToView("alert-danger",
										"Erreur lors de l'ajout de votre accusé de réception");
								redirectionToView(HOME_PAGE);
							}
						} else {
							setVariableToView("alert-danger", "Un accusé réception existe déjà pour cette commande");
							redirectionToView(HOME_PAGE);
						}

					} else {
						setVariableToView("alert-danger", "Aucune livraison n'existe pour cette commande");
						redirectionToView(HOME_PAGE);
					}
				} else {
					setVariableToView("alert-danger", "Cette commande n'existe pas");
					redirectionToView(HOME_PAGE);
				}
			} catch (NumberFormatException exception) {
				setVariableToView("alert-danger", "Commande introuvable");
				redirectionToView(HOME_PAGE);
			}
		} else {
			setVariableToView("alert-danger", "Vous n'avez pas les droits necessaires pour acceder à cette page");
			redirectionToView(HOME_PAGE);
		}
	}

	/**
	 * Liste des paiements
	 * 
	 * @param webService
	 * @throws ServletException
	 * @throws IOException
	 */
	private void listePaiementsActionPerformed(WebServiceSessionBean webService) throws ServletException, IOException {
		if (session.getAttribute("session-role") == "comptable") {
			List<Paiement> paiementsList = webService.findAllPaiement();
			request.setAttribute("listePaiements", paiementsList);
			redirectionToView(LISTE_PAIEMENTS_PAGE);
		} else {
			setVariableToView("alert-danger", "Vous n'avez pas les droits nécessaires pour accéder à cette page");
			redirectionToView(HOME_PAGE);
		}

	}

	/**
	 * Ajout d'un paiement
	 * 
	 * @param webService
	 * @throws IOException
	 * @throws ServletException
	 */
	private void ajoutPaiementActionPerformed(WebServiceSessionBean webService) throws ServletException, IOException {
		if (session.getAttribute("session-role") == "comptable") {
			try {
				int idFacture = Integer.valueOf(this.idFacture);
				Facture facture = webService.getFacture(idFacture);
				if (facture != null) {
					boolean isAdded = webService.ajoutPaiement(idFacture);
					if (isAdded) {
						this.listePaiementsActionPerformed(webService);
					} else {
						setVariableToView("alert-danger", "L'ajout du paiement a echoue");
						redirectionToView(HOME_PAGE);
					}
				} else {
					setVariableToView("alert-danger",
							"L'ajout du paiement est impossible. Vérifiez que la facture existe");
					redirectionToView(HOME_PAGE);
				}
			} catch (NumberFormatException exception) {
				setVariableToView("alert-danger", "Facture introuvable");
				redirectionToView(HOME_PAGE);
			}
		} else {
			setVariableToView("alert-danger", "Vous n'avez pas les droits necessaires pour acceder Ã Â cette page");
			redirectionToView(HOME_PAGE);
		}

	}

	/**
	 * Détail d'une commande
	 * 
	 * @param webService
	 * @throws IOException
	 * @throws ServletException
	 */
	private void commandeDetailActionPerformed(WebServiceSessionBean webService) throws ServletException, IOException {
		if (session.getAttribute("session-role") != null) {
			try {
				int idCommandeNumber = Integer.valueOf(idCommande);
				Commande commande = webService.findCommandeById(idCommandeNumber);
				String nomFournisseur = webService.findFournisseurById(commande.getIdFournisseur()).getNom();
				request.setAttribute("commande", commande);
				request.setAttribute("fournisseur", nomFournisseur);
				redirectionToView(COMMANDE_DETAIL_PAGE);
			} catch (NumberFormatException exception) {
				setVariableToView("alert-danger", "Commande introuvable");
				redirectionToView(HOME_PAGE);
			}
		} else {
			setVariableToView("alert-danger", "Vous n'avez pas les droits nécessaires pour accéder à cette page");
			redirectionToView(HOME_PAGE);
		}
	}

	/**
	 * Modification d'une commande
	 * 
	 * @param webService
	 * @throws IOException
	 * @throws ServletException
	 */
	private void editCommandeActionPerformed(WebServiceSessionBean webService) throws ServletException, IOException {
		// mettre un action or something pour différencier les deux actions dans la vue

	}

	/**
	 * Charge la liste des fournisseurs et affichage la page d'ajout d'une commande
	 * 
	 * @param webService
	 * @throws IOException
	 * @throws ServletException
	 */
	private void addCommandeActionPerformed(WebServiceSessionBean webService) throws ServletException, IOException {
		if (session.getAttribute("session-role") != null) {
			List<Fournisseur> listeFournisseurs = webService.getFournisseurs();
	
			request.setAttribute("listeFournisseurs", listeFournisseurs);
			redirectionToView(COMMANDE_DETAIL_PAGE); 
		}else {
			setVariableToView("alert-danger", "Vous n'avez pas les droits nécessaires pour accéder à cette page");
			redirectionToView(HOME_PAGE);
		}

	}

	/**
	 * Ajout d'une commande
	 * 
	 * @param webService
	 * @throws IOException
	 * @throws ServletException
	 */
	private void ajouterCommandeActionPerformed(WebServiceSessionBean webService) throws ServletException, IOException {
		if (session.getAttribute("session-role") == "responsableAchat") {
			// vérification du formulaire
			boolean isOkForm = true;
			String produit = request.getParameter("produit");
			String quantite = request.getParameter("quantite");
			String prix = request.getParameter("prix");
			String idFournisseur = request.getParameter("fournisseurSelect");
	
			try {
				if (produit == null || "".equals(produit)) {
					isOkForm = false;
				}
				if (quantite == null || "".equals(quantite)) {
					isOkForm = false;
				}
				if (prix == null || "".equals(prix)) {
					isOkForm = false;
				}
				if (idFournisseur == null || "".equals(idFournisseur)) {
					isOkForm = false;
				}
	
				if (isOkForm) {
					// Vérifier si le rôle est bien responsable des achats
					if (session.getAttribute("session-role") == "responsableAchat") {
						int idFournisseurNumber = Integer.valueOf(idFournisseur);
						int quantiteNumber = Integer.valueOf(quantite);
						float prixNumber = Integer.valueOf(prix);
						Utilisateur utilisateur = webService.findUtilisateurByLogin((String) session.getAttribute("login"));
						Commande commande = new Commande();
						commande.setProduit(produit);
						commande.setQuantite(quantiteNumber);
						commande.setPrix(prixNumber);
						commande.setIdFournisseur(idFournisseurNumber);
						commande.setIdUtilisateur(utilisateur.getId());
						// ajouter la commande
						webService.ajoutCommande(commande);
	
						setVariableToView("alert-success", "Commande prise en compte");
						redirectionToView(HOME_PAGE);
					} else {
						setVariableToView("alert-danger", "Rôle incorrecte");
						redirectionToView(HOME_PAGE);
					}
	
				} else {
					setVariableToView("alert-danger", "Données du formulaire incorrectes");
					redirectionToView(HOME_PAGE);
				}
			} catch (NumberFormatException exception) {
				setVariableToView("alert-danger", "Données du formulaire incorrectes");
				redirectionToView(HOME_PAGE);
			}
		}else {
			setVariableToView("alert-danger", "Vous n'avez pas les droits nécessaires pour accéder à cette page");
			redirectionToView(HOME_PAGE);
		}

	}

	/**
	 * Liste des commandes
	 * 
	 * @param webService
	 * @throws IOException
	 * @throws ServletException
	 */
	private void listeCommandesActionPerformed(WebServiceSessionBean webService) throws ServletException, IOException {
		List<Commande> commandesList = new ArrayList<Commande>();
		if(session.getAttribute("session-role") != null) {
			switch (session.getAttribute("session-role").toString()) {
			case "responsableAchat":
				commandesList = webService.findAllCommande();
				break;
			case "responsableStock":
				commandesList = webService.findAllcommandeForResponsableStock();
				break;
			case "comptable":
				commandesList = webService.findAllcommandeForComptable();
				break;

			}
			List<String> nomFournisseursList = new ArrayList<String>();
			for (Commande commande : commandesList) {
				nomFournisseursList.add(webService.findFournisseurById(commande.getIdFournisseur()).getNom());
			}
			request.setAttribute("commandesList", commandesList);
			request.setAttribute("fournisseursList", nomFournisseursList);
			redirectionToView(LISTE_COMMANDES_PAGE);
		}else {
			setVariableToView("alert-danger", "Vous n'avez pas les droits nécessaires pour accéder à cette page");
			redirectionToView(HOME_PAGE);
		}
	}

	/**
	 * Action pour l'événement de Connexion
	 * 
	 * @param webService
	 * @throws IOException
	 * @throws ServletException
	 */
	private void connexionActionPerformed(WebServiceSessionBean webService) throws ServletException, IOException {
		boolean isOkForm = true;

		if (this.login == null || "".equals(this.login)) {
			isOkForm = false;
		}

		if (this.mdp == null || "".equals(this.mdp)) {
			isOkForm = false;
		}

		if (isOkForm) {
			boolean verificationIdentifiants = webService.connexion(this.login, this.mdp);

			if (verificationIdentifiants) {
				httpSession(login, mdp);
				Utilisateur utilisateur = webService.findUtilisateurByLogin(login);
				int idProfil = utilisateur.getIdProfil();

				switch (idProfil) {
				case RESPONSABLE_ACHAT_PROFIL_ID:
					session.setAttribute("session-role", "responsableAchat");
					break;
				case RESPONSABLE_STOCK_PROFIL_ID:
					session.setAttribute("session-role", "responsableStock");
					break;
				case COMPTABLE_PROFIL_ID:
					session.setAttribute("session-role", "comptable");
					break;
				default:
					break;
				}

				redirectionToView(HOME_PAGE);
			} else {
				setVariableToView("alert-danger", "Identifiants incorrect");
				redirectionToView(CONNEXION_PAGE);
			}

		} else {
			setVariableToView("alert-danger", "Veuillez saisir tous les champs");
			redirectionToView(CONNEXION_PAGE);
		}

	}

	/**
	 * Supprime les attributs de la Session
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	private void deconnexionActionPerformed() throws ServletException, IOException {
		// delete params in http session
		session.invalidate();
		// redirection home
		redirectionToView(HOME_PAGE);
	}

	/**
	 * Initialize the values
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void initialize(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.request = request;
		this.response = response;
		this.session = request.getSession();

		action = request.getParameter("action");
		login = request.getParameter("login");
		mdp = request.getParameter("mdp");
		idFacture = request.getParameter("idFacture");
		idLivraison = request.getParameter("idLivraison");
		idAccuseReception = request.getParameter("idAccuseReception");
		idCommande = request.getParameter("idCommande");

		response.setContentType("text/html");
	}

	/**
	 * Set the httpSession
	 * 
	 * @param login
	 * @param password
	 */
	protected void httpSession(String login, String password) {
		session.setAttribute("login", login);
		session.setAttribute("password", password);
	}

	/**
	 * Feed request attribute
	 * 
	 * @param variable
	 * @param message
	 */
	private void setVariableToView(String variable, String message) {
		request.setAttribute(variable, message);
	}

	/**
	 * Redirection to a view
	 * 
	 * @param String
	 *            : the view name
	 * @throws ServletException
	 * @throws IOException
	 */
	private void redirectionToView(String view) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(view + ".jsp");
		dispatcher.include(request, response);
	}

	/**
	 * Redirection to a servlet
	 * 
	 * @param String
	 *            : the servlet name
	 * @throws ServletException
	 * @throws IOException
	 */
	private void redirectionToServlet(String sevlet) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(sevlet);
		dispatcher.include(request, response);
	}
}
