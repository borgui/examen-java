package domains;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "Paniers" )
public class Panier {

    @Id
    @Column( name = "ID" )
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;

    @Column( name = "idUser" )
    Integer idUser;

    @Column( name = "idFDP" )
    Integer idFDP;
    
    @Column( nullable = false, columnDefinition = "INT(1)" )
    Boolean actif;
    
    
    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="idPanier", referencedColumnName="id")
    List<PanierProduit> panierProduits = new ArrayList();

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

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}
    
	
    
}