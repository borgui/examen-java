package domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "Profils" )
public class Avis {

    @Id
    @Column( name = "ID" )
    Integer id;

    @Column( name = "NOTE" )
    Integer note;

    @Column( name = "DESCRIPTION" )
    String  description;

    @Column( name = "idUsers" )
    Integer idUser;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote( Integer note ) {
        this.note = note;
    }

    public Integer getIdUsers() {
        return idUser;
    }

    public void setIdUser( Integer idUser ) {
        this.idUser = idUser;
    }
}