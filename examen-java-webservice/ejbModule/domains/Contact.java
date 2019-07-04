package domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "contacts" )
public class Contact {

    @Id
    @Column( name = "ID" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    Integer id;

    @Column( name = "DESCRIPTION" )
    String  description;

    @Column( name = "idSujet" )
    Integer idSujet;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public Integer getIdSujet() {
        return idSujet;
    }

    public void setIdSujet( Integer idSujet ) {
        this.idSujet = idSujet;
    }
}