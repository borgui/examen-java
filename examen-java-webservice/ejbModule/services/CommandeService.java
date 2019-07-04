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
import domains.Commande;
import domains.Entrepot;
import domains.Panier;
import domains.Produit;

@Stateful
@LocalBean
@TransactionManagement( javax.ejb.TransactionManagementType.BEAN )
public class CommandeService {

    @PersistenceContext( unitName = "database" )
    private EntityManager  em;

    @Resource
    private SessionContext sessionContext;

    public List<Commande> getByClient(Integer idClient) throws NotSupportedException, SystemException {

        UserTransaction userTxn = sessionContext.getUserTransaction();
        userTxn.begin();

        String queryString = "FROM Commande Where idPanier IN (SELECT id FROM Panier where idUser = " + idClient + ")";
        Query query = this.em.createQuery( queryString );
        List<Commande> commandes = (List<Commande>) query.getResultList();

        try {
            userTxn.commit();
        } catch ( SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
                | HeuristicRollbackException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return commandes;
    }

	 public Commande creerCommande( Commande commande ) throws NotSupportedException, SystemException {

	        UserTransaction userTxn = sessionContext.getUserTransaction();
	        userTxn.begin();

	        this.em.persist( commande );
			Panier panier = this.em.find(Panier.class, commande.getPanier().getId());
	        panier.setActif(false);
	        this.em.persist(panier);

	        try {
	            userTxn.commit();
	        } catch ( SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
	                | HeuristicRollbackException e ) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return commande;
	    }
}