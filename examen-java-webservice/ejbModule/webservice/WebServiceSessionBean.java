package webservice;

import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;

import javax.jws.WebService;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;

import domains.Utilisateur;
import services.UtilisateurService;

@Stateless
@LocalBean
@WebService
public class WebServiceSessionBean {

	@EJB
	UtilisateurService utilisateurService;
	
	// === Authentification === //
	@WebMethod(action = "connexion")
	public Utilisateur connexion(@WebParam(name = "login", mode = Mode.IN) String login,
			@WebParam(name = "mdp", mode = Mode.IN) String mdp) throws NotSupportedException, SystemException {
		return utilisateurService.findUserByLoginAndPassword(login, mdp);
	}
}
