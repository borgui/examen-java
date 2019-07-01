package domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UTILISATEUR")
public class Utilisateur {
	
	@Id
	@Column(name="ID")
	Long id;
	
	@Column(name="NOM")
	String nom;
	
	@Column(name="PRENOM")
	String prenom;
	
	@Column(name="LOGIN")
	String login;
	
	@Column(name="PASSWORD")
	String password;
	
	@Column(name="ADRESSE")
	String adresse;

	@Column(name="idProfil")
	Long idProfil;
	
	@Column(name="suspended")
	boolean suspended;
	
	@Column(name="idPanier")
	Long idPanier;
	
	
	

}
