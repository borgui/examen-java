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

import domains.Panier;
import domains.PanierProduit;
import domains.Produit;
import domains.Utilisateur;

@Stateful
@LocalBean
@TransactionManagement( javax.ejb.TransactionManagementType.BEAN )
public class UtilisateurService {

    @PersistenceContext( unitName = "database" )
    private EntityManager  em;

    @Resource
    private SessionContext sessionContext;

    public Utilisateur findUserByLoginAndPassword( String login, String mdp )
            throws NotSupportedException, SystemException {
        Utilisateur utilisateur = null;
        UserTransaction userTxn = sessionContext.getUserTransaction();
        userTxn.begin();
        String queryString = "FROM Utilisateur where login = '" + login + "' and password = '" + mdp
                + "' and suspended = 0";
        Query query = this.em.createQuery( queryString );
        if ( query.getResultList().size() != 0 ) {
            utilisateur = (Utilisateur) query.getSingleResult();
        }
        try {
            userTxn.commit();
        } catch ( SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
                | HeuristicRollbackException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return utilisateur;
    }

    public List<Utilisateur> findUsersByProfil( Integer idProfil ) throws SystemException, NotSupportedException {
        UserTransaction userTxn = sessionContext.getUserTransaction();
        userTxn.begin();
        String queryString = "FROM Utilisateur where idProfil = " + idProfil;
        Query query = this.em.createQuery( queryString );
        List<Utilisateur> utilisateurs = (List<Utilisateur>) query.getResultList();

        try {
            userTxn.commit();
        } catch ( SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
                | HeuristicRollbackException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return utilisateurs;
    }

    public Utilisateur findById( Integer id ) throws SystemException, NotSupportedException {
        UserTransaction userTxn = sessionContext.getUserTransaction();
        userTxn.begin();
        Utilisateur utilisateur = this.em.find( Utilisateur.class, id );

        try {
            userTxn.commit();
        } catch ( SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
                | HeuristicRollbackException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return utilisateur;
    }

    public Utilisateur creerUtilisateur( Utilisateur utilisateur ) throws SystemException, NotSupportedException {
        UserTransaction userTxn = sessionContext.getUserTransaction();
        userTxn.begin();

        this.em.persist( utilisateur );
        this.em.flush();

        try {
            userTxn.commit();
        } catch ( SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
                | HeuristicRollbackException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return utilisateur;
    }

    public Utilisateur modifierUtilisateur( Utilisateur utilisateur ) throws SystemException, NotSupportedException {
        UserTransaction userTxn = sessionContext.getUserTransaction();
        userTxn.begin();

        this.em.merge( utilisateur );

        try {
            userTxn.commit();
        } catch ( SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
                | HeuristicRollbackException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return utilisateur;
    }

    public void supprimerUtilisateur( Integer id ) throws SystemException, NotSupportedException {
        UserTransaction userTxn = sessionContext.getUserTransaction();
        userTxn.begin();
        Utilisateur utilisateur = this.em.find( Utilisateur.class, id );
        if(utilisateur.getIdProfil() == 1) {
            String queryString = "FROM Panier where idUser = " + utilisateur.getId();
            Query query = this.em.createQuery( queryString );
            List<Panier> paniers = (List<Panier>) query.getResultList();
            paniers.forEach(panier -> {
                this.em.remove(panier);
            });
         } else {
             String queryString = "FROM Produit where idVendeur = " + utilisateur.getId();
             String paniersProduitString = "FROM PanierProduit where idProduit IN (select id FROM Produit WHERE idVendeur = " + utilisateur.getId() + ")";
             Query panierProduitQuery = this.em.createQuery( paniersProduitString );
             List<PanierProduit> paniersProduit = (List<PanierProduit>) panierProduitQuery.getResultList();
             paniersProduit.forEach(produit -> {
                 this.em.remove(produit);
             });
             Query query = this.em.createQuery( queryString );
             List<Produit> produits = (List<Produit>) query.getResultList();
             produits.forEach(produit -> {
                 this.em.remove(produit);
             });
         }
        this.em.remove( utilisateur );

        try {
            userTxn.commit();
        } catch ( SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
                | HeuristicRollbackException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public List<Utilisateur> getUtilisateurByEmailOrLogin(String email, String login) throws SystemException, NotSupportedException {
        UserTransaction userTxn = sessionContext.getUserTransaction();
        userTxn.begin();
        String queryString = "FROM Utilisateur where mail = '" + email + "' OR login = '" + login + "'";
        Query query = this.em.createQuery( queryString );
        List<Utilisateur> utilisateurs = (List<Utilisateur>) query.getResultList();

        try {
            userTxn.commit();
        } catch ( SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
                | HeuristicRollbackException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return utilisateurs;
    }

}