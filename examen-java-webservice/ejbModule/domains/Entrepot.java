package domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "Entrepots" )
public class Entrepot {

    @Id
    @Column( name = "ID" )
    Integer id;

    @Column( name = "NOM" )
    Integer nom;

    @Column( name = "PAYS" )
    String  pays;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public Integer getNom() {
        return nom;
    }

    public void setNom( Integer nom ) {
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays( String pays ) {
        this.pays = pays;
    }
}