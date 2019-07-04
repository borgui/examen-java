package domains;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "commandes" )
public class Commande {

    @Id
    @Column( name = "ID" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    Integer        id;

    @Column( name = "DATE" )
    Date           date;

    @ManyToOne
    @JoinColumn( name = "IDSTATUS" )
    CommandeStatus status;

    @ManyToOne
    @JoinColumn( name = "IDPANIER" )
    Panier         panier;

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

    public Panier getPanier() {
        return panier;
    }

    public void setPanier( Panier panier ) {
        this.panier = panier;
    }

    public CommandeStatus getStatus() {
        return status;
    }

    public void setStatus( CommandeStatus status ) {
        this.status = status;
    }

}