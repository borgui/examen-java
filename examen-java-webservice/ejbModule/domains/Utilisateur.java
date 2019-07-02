package domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "Utilisateurs" )
public class Utilisateur {

    @Id
    @Column( name = "ID" )
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

    @Column( name = "idBanque" )
    Integer idBanque;

    @Column( name = "idContact" )
    Integer idContact;

    @Column( nullable = false, columnDefinition = "TINYINT(4)" )
    boolean suspended;

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse( String adresse ) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return cp;
    }

    public void setCodePostal( String cp ) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille( String ville ) {
        this.ville = ville;
    }

    public String getMail() {
        return mail;
    }

    public void setMail( String mail ) {
        this.mail = mail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin( String login ) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public Integer getIdProfil() {
        return idProfil;
    }

    public void setIdProfil( Integer idProfil ) {
        this.idProfil = idProfil;
    }

    public Integer getIdBanque() {
        return idBanque;
    }

    public void setIdBanque( Integer idBanque ) {
        this.idBanque = idBanque;
    }

    public Integer getIdContact() {
        return idContact;
    }

    public void setIdContact( Integer idContact ) {
        this.idContact = idContact;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended( boolean suspended ) {
        this.suspended = suspended;
    }

}