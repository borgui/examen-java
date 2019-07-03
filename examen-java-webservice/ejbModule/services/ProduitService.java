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
import domains.Produit;

@Stateful
@LocalBean
@TransactionManagement( javax.ejb.TransactionManagementType.BEAN )
public class ProduitService {

    @PersistenceContext( unitName = "database" )
    private EntityManager  em;

    @Resource
    private SessionContext sessionContext;

    public List<Categorie> findAllCategories() throws NotSupportedException, SystemException {

        UserTransaction userTxn = sessionContext.getUserTransaction();
        userTxn.begin();

        String queryString = "FROM Categorie";
        Query query = this.em.createQuery( queryString );
        List<Categorie> categories = (List<Categorie>) query.getResultList();

        try {
            userTxn.commit();
        } catch ( SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
                | HeuristicRollbackException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return categories;
    }

    public Categorie creerCategorie( Categorie categorie ) throws NotSupportedException, SystemException {

        UserTransaction userTxn = sessionContext.getUserTransaction();
        userTxn.begin();

        this.em.persist( categorie );

        try {
            userTxn.commit();
        } catch ( SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
                | HeuristicRollbackException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return categorie;
    }
    

    public Categorie modifierCategorie( Categorie categorie ) throws SystemException, NotSupportedException {
        UserTransaction userTxn = sessionContext.getUserTransaction();
        userTxn.begin();

        this.em.merge( categorie );

        try {
            userTxn.commit();
        } catch ( SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
                | HeuristicRollbackException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return categorie;
    }

    public void supprimerCategorie( Integer id ) throws SystemException, NotSupportedException {
        UserTransaction userTxn = sessionContext.getUserTransaction();
        userTxn.begin();
        Categorie categorie = this.em.find( Categorie.class, id );
        this.em.remove( categorie );

        try {
            userTxn.commit();
        } catch ( SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
                | HeuristicRollbackException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
	public List<Produit> findByCategorieId(Integer categorieId) throws SystemException, NotSupportedException{
		UserTransaction userTxn = sessionContext.getUserTransaction();
		userTxn.begin();
        String queryString = "FROM Produit WHERE idCategorie = " + categorieId;

        Query query = this.em.createQuery(queryString);
		List<Produit> produits = query.getResultList();

		try {
			userTxn.commit();
		} catch (SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
				| HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produits;
	}

}