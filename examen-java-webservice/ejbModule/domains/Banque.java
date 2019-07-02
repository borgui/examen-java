package domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "Banques" )
public class Banque {

    @Id
    @Column( name = "ID" )
    Integer id;

    @Column( name = "BALANCE" )
    Integer balance;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance( Integer balance ) {
        this.balance = balance;
    }

}