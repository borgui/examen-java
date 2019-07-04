package domains;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "factures" )
public class Facture {

    @Id
    @Column( name = "ID" )
    Integer id;

    @Column( name = "DATE" )
    Date    date;

    @Column( name = "idCommande" )
    Integer idCommande;

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

    public Date getDate() {
        return date;
    }

    public void setDate( Date date ) {
        this.date = date;
    }
}