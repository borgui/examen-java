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

import domains.Categorie;
import domains.Entrepot;
import domains.Panier;
import domains.PanierProduit;
import domains.Utilisateur;

@Stateful
@LocalBean
@TransactionManagement( javax.ejb.TransactionManagementType.BEAN )
public class PanierService {

    @PersistenceContext( unitName = "database" )
    private EntityManager  em;

    @Resource
    private SessionContext sessionContext;
    

    public Panier creePanier( Panier panier ) throws NotSupportedException, SystemException {

        UserTransaction userTxn = sessionContext.getUserTransaction();
        userTxn.begin();

        this.em.persist( panier );
        this.em.flush();

        try {
            userTxn.commit();
        } catch ( SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
                | HeuristicRollbackException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return panier;
    }

	public Panier getPanierById(Integer id) throws SystemException, NotSupportedException{
		UserTransaction userTxn = sessionContext.getUserTransaction();
		userTxn.begin();
		Panier panier = this.em.find(Panier.class, id);

		try {
			userTxn.commit();
		} catch (SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
				| HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return panier;
	}
	
	   public Panier getPanierByUserId(Integer id) throws NotSupportedException, SystemException {

	        UserTransaction userTxn = sessionContext.getUserTransaction();
	        userTxn.begin();

	        String queryString = "FROM Panier WHERE idUser = " + id;
	        Query query = this.em.createQuery( queryString );
	        Panier panier = (Panier) query.getSingleResult();

	        try {
	            userTxn.commit();
	        } catch ( SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
	                | HeuristicRollbackException e ) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return panier;
	    }
	   
	   public PanierProduit creerPanierProduit( PanierProduit panierProduit ) throws NotSupportedException, SystemException {

	        UserTransaction userTxn = sessionContext.getUserTransaction();
	        userTxn.begin();

	        this.em.persist( panierProduit );
	        this.em.flush();

	        try {
	            userTxn.commit();
	        } catch ( SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
	                | HeuristicRollbackException e ) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return panierProduit;
	    }
}
