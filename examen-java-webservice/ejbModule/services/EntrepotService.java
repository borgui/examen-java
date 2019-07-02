package services;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import domains.Entrepot;

@Stateful
@LocalBean
@TransactionManagement( javax.ejb.TransactionManagementType.BEAN )
public class EntrepotService {

    @PersistenceContext( unitName = "database" )
    private EntityManager  em;

    @Resource
    private SessionContext sessionContext;

    public Entrepot creeEntrepot( Entrepot entrepot ) throws NotSupportedException, SystemException {

        UserTransaction userTxn = sessionContext.getUserTransaction();
        userTxn.begin();

        this.em.persist( entrepot );

        try {
            userTxn.commit();
        } catch ( SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
                | HeuristicRollbackException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return entrepot;
    }

    public Entrepot modifierEntrepot( Entrepot entrepot ) throws SystemException, NotSupportedException {
        UserTransaction userTxn = sessionContext.getUserTransaction();
        userTxn.begin();

        this.em.merge( entrepot );

        try {
            userTxn.commit();
        } catch ( SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
                | HeuristicRollbackException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return entrepot;
    }

    public void supprimerEntrepot( Integer id ) throws SystemException, NotSupportedException {
        UserTransaction userTxn = sessionContext.getUserTransaction();
        userTxn.begin();
        Entrepot entrepot = this.em.find( Entrepot.class, id );
        this.em.remove( entrepot );

        try {
            userTxn.commit();
        } catch ( SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
                | HeuristicRollbackException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}