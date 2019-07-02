package domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "FDP" )
public class FDP {

    @Id
    @Column( name = "ID" )
    Integer id;

    @Column( name = "PRIX" )
    Integer prix;

    @Column( name = "idPanier" )
    Integer idPanier;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix( Integer prix ) {
        this.prix = prix;
    }

    public Integer getIdPanier() {
        return idPanier;
    }

    public void setIdPanier( Integer idPanier ) {
        this.idPanier = idPanier;
    }
}