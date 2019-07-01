package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domains.Utilisateur;

@Stateful
@LocalBean
public class UtilisateurService {
	
    @PersistenceContext(unitName = "unit")
    private EntityManager em;
    
	public Utilisateur findUserByLoginAndPassword(String login, String mdp) {
		Utilisateur utilisateur = null;
		this.em.getTransaction().begin();
		String queryString = "FROM Utilisateur where login = '" + login + "' and password = '" + mdp + "'";
		Query query = this.em.createQuery(queryString);
		if(query.getResultList().size() != 0) {
			utilisateur = (Utilisateur) query.getSingleResult();
		}
		return utilisateur;
	}

}