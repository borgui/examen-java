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

@Stateless
@LocalBean
@WebService
public class WebServiceSessionBean {

	// === Authentification === //
	@WebMethod(action = "connexion")
	public boolean connexion(@WebParam(name = "login", mode = Mode.IN) String login,
			@WebParam(name = "mdp", mode = Mode.IN) String mdp) {
		boolean verificationIdentifiants = false;//= utilisateurSessionBean.verificationIdentifiants(login, mdp);
		return verificationIdentifiants;
	}
}
