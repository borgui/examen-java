package domains;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "Profils" )
public class Commande {

    @Id
    @Column( name = "ID" )
    Integer id;

    @Column( name = "DATE" )
    Date    date;

    @Column( name = "IDPANIER" )
    Integer idPanier;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate( Date date ) {
        this.date = date;
    }

    public Integer getIdPanier() {
        return idPanier;
    }

    public void setIdPanier( Integer idPanier ) {
        this.idPanier = idPanier;
    }
}