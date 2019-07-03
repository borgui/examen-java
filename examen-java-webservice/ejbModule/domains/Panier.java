package domains;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "Paniers" )
public class Panier {

    @Id
    @Column( name = "ID" )
    Integer id;

    @Column( name = "idUser" )
    Integer idUser;

    @Column( name = "idFDP" )
    Integer idFDP;
    
    @OneToMany
    @JoinColumn(name="idPanier", referencedColumnName="id")
    List<PanierProduit> panierProduits;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public Integer getIdProduit() {
        return idUser;
    }
    
    public Integer getIdUsers() {
        return idUser;
    }

    public void setIdUser( Integer idUser ) {
        this.idUser = idUser;
    }

    public Integer getIdFDP() {
        return idFDP;
    }

    public void setIdFDP( Integer idFDP ) {
        this.idFDP = idFDP;
    }

	public List<PanierProduit> getPanierProduits() {
		return panierProduits;
	}

	public void setPanierProduits(List<PanierProduit> panierProduits) {
		this.panierProduits = panierProduits;
	}

	public Integer getIdUser() {
		return idUser;
	}
    
    
}