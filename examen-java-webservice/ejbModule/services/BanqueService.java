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

import domains.Banque;
import domains.Categorie;
import domains.Commande;
import domains.Entrepot;
import domains.Panier;
import domains.Produit;

@Stateful
@LocalBean
@TransactionManagement( javax.ejb.TransactionManagementType.BEAN )
public class BanqueService {

    @PersistenceContext( unitName = "database" )
    private EntityManager  em;

    @Resource
    private SessionContext sessionContext;


	 public Banque modifierBanque( Banque banque ) throws NotSupportedException, SystemException {

	        UserTransaction userTxn = sessionContext.getUserTransaction();
	        userTxn.begin();

	        this.em.merge( banque );
	        this.em.flush();

	        try {
	            userTxn.commit();
	        } catch ( SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
	                | HeuristicRollbackException e ) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return banque;
	    }
}