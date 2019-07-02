package domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UTILISATEURS")
public class Utilisateur {
	
	@Id
	@Column(name="ID")
	Integer id;
	
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
	Integer idProfil;
	
	@Column(nullable = false, columnDefinition = "TINYINT(4)")
	boolean suspended;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Integer getIdProfil() {
		return idProfil;
	}

	public void setIdProfil(Integer idProfil) {
		this.idProfil = idProfil;
	}

	public boolean isSuspended() {
		return suspended;
	}

	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}

	
	
	

}
