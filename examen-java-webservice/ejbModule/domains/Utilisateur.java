package domains;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "utilisateurs" )
public class Utilisateur {

    @Id
    @Column( name = "ID" )
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    Integer id;

    @Column( name = "NOM" )
    String  nom;

    @Column( name = "PRENOM" )
    String  prenom;

    @Column( name = "ADRESSE" )
    String  adresse;

    @Column( name = "CODEPOSTAL" )
    String  cp;

    @Column( name = "VILLE" )
    String  ville;

    @Column( name = "MAIL" )
    String  mail;

    @Column( name = "LOGIN" )
    String  login;

    @Column( name = "PASS" )
    String  password;

    @Column( name = "idProfil" )
    Integer idProfil;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn( name = "idBanque" )
    Banque banque;

    @Column( name = "idContact" )
    Integer idContact;

    @Column( nullable = false, columnDefinition = "TINYINT(4)" )
    Boolean suspended;

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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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

	public Integer getIdProfil() {
		return idProfil;
	}

	public void setIdProfil(Integer idProfil) {
		this.idProfil = idProfil;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public Integer getIdContact() {
		return idContact;
	}

	public void setIdContact(Integer idContact) {
		this.idContact = idContact;
	}

	public Boolean getSuspended() {
		return suspended;
	}

	public void setSuspended(Boolean suspended) {
		this.suspended = suspended;
	}

    
    

}