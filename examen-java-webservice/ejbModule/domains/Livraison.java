package domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "Livraisons" )
public class Livraison {

    @Id
    @Column( name = "ID" )
    Integer id;

    @Column( name = "idCommande" )
    Integer idCommande;

    @Column( name = "idEtatLivraison" )
    Integer idEtatLivraison;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande( Integer idCommande ) {
        this.idCommande = idCommande;
    }

    public Integer getIdEtatLivraison() {
        return idEtatLivraison;
    }

    public void setIdEtatLivraison( Integer idEtatLivraison ) {
        this.idEtatLivraison = idEtatLivraison;
    }
}