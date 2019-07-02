package domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "Entrepots" )
public class Entrepot {

    @Id
    @Column( name = "ID" )
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;

    @Column( name = "NOM" )
    String  nom;

    @Column( name = "PAYS" )
    String  pays;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays( String pays ) {
        this.pays = pays;
    }
}