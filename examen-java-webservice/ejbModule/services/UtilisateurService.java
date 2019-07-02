package services;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import domains.Utilisateur;

@Stateful
@LocalBean
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class UtilisateurService {
	
    @PersistenceContext(unitName = "database")
    private EntityManager em;
    
    @Resource
    private SessionContext sessionContext;
    
	public Utilisateur findUserByLoginAndPassword(String login, String mdp) throws NotSupportedException, SystemException {
		Utilisateur utilisateur = null;
		UserTransaction userTxn = sessionContext.getUserTransaction();
		userTxn.begin();
		String queryString = "FROM Utilisateur where login = '" + login + "' and password = '" + mdp + "'";
		Query query = this.em.createQuery(queryString);
		if(query.getResultList().size() != 0) {
			utilisateur = (Utilisateur) query.getSingleResult();
		}
		try {
			userTxn.commit();
		} catch (SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
				| HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return utilisateur;
	}
	
	public List<Utilisateur> findUsersByProfil(Integer idProfil) throws SystemException, NotSupportedException{
		UserTransaction userTxn = sessionContext.getUserTransaction();
		userTxn.begin();
		String queryString = "FROM Utilisateur where idProfil = " + idProfil ;
		Query query = this.em.createQuery(queryString);
		List<Utilisateur> utilisateurs = (List<Utilisateur>) query.getResultList();

		try {
			userTxn.commit();
		} catch (SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
				| HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return utilisateurs;
	}

}