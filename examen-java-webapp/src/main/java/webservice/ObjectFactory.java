
package webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AjoutAccuseReception_QNAME = new QName("http://webservice/", "ajoutAccuseReception");
    private final static QName _AjoutAccuseReceptionResponse_QNAME = new QName("http://webservice/", "ajoutAccuseReceptionResponse");
    private final static QName _AjoutCommande_QNAME = new QName("http://webservice/", "ajoutCommande");
    private final static QName _AjoutCommandeResponse_QNAME = new QName("http://webservice/", "ajoutCommandeResponse");
    private final static QName _AjoutFacture_QNAME = new QName("http://webservice/", "ajoutFacture");
    private final static QName _AjoutFactureResponse_QNAME = new QName("http://webservice/", "ajoutFactureResponse");
    private final static QName _AjoutPaiement_QNAME = new QName("http://webservice/", "ajoutPaiement");
    private final static QName _AjoutPaiementResponse_QNAME = new QName("http://webservice/", "ajoutPaiementResponse");
    private final static QName _Connexion_QNAME = new QName("http://webservice/", "connexion");
    private final static QName _ConnexionResponse_QNAME = new QName("http://webservice/", "connexionResponse");
    private final static QName _ExisteAccuseReceptionByIdCommande_QNAME = new QName("http://webservice/", "existeAccuseReceptionByIdCommande");
    private final static QName _ExisteAccuseReceptionByIdCommandeResponse_QNAME = new QName("http://webservice/", "existeAccuseReceptionByIdCommandeResponse");
    private final static QName _ExisteCommandeById_QNAME = new QName("http://webservice/", "existeCommandeById");
    private final static QName _ExisteCommandeByIdResponse_QNAME = new QName("http://webservice/", "existeCommandeByIdResponse");
    private final static QName _ExisteLivraisonByCommandId_QNAME = new QName("http://webservice/", "existeLivraisonByCommandId");
    private final static QName _ExisteLivraisonByCommandIdResponse_QNAME = new QName("http://webservice/", "existeLivraisonByCommandIdResponse");
    private final static QName _FindAccuseReceptionByIdCommande_QNAME = new QName("http://webservice/", "findAccuseReceptionByIdCommande");
    private final static QName _FindAccuseReceptionByIdCommandeResponse_QNAME = new QName("http://webservice/", "findAccuseReceptionByIdCommandeResponse");
    private final static QName _FindAllCommande_QNAME = new QName("http://webservice/", "findAllCommande");
    private final static QName _FindAllCommandeResponse_QNAME = new QName("http://webservice/", "findAllCommandeResponse");
    private final static QName _FindAllPaiement_QNAME = new QName("http://webservice/", "findAllPaiement");
    private final static QName _FindAllPaiementResponse_QNAME = new QName("http://webservice/", "findAllPaiementResponse");
    private final static QName _FindAllcommandeForComptable_QNAME = new QName("http://webservice/", "findAllcommandeForComptable");
    private final static QName _FindAllcommandeForComptableResponse_QNAME = new QName("http://webservice/", "findAllcommandeForComptableResponse");
    private final static QName _FindAllcommandeForResponsableStock_QNAME = new QName("http://webservice/", "findAllcommandeForResponsableStock");
    private final static QName _FindAllcommandeForResponsableStockResponse_QNAME = new QName("http://webservice/", "findAllcommandeForResponsableStockResponse");
    private final static QName _FindCommandeById_QNAME = new QName("http://webservice/", "findCommandeById");
    private final static QName _FindCommandeByIdResponse_QNAME = new QName("http://webservice/", "findCommandeByIdResponse");
    private final static QName _FindFactureByIdCommande_QNAME = new QName("http://webservice/", "findFactureByIdCommande");
    private final static QName _FindFactureByIdCommandeResponse_QNAME = new QName("http://webservice/", "findFactureByIdCommandeResponse");
    private final static QName _FindFournisseurById_QNAME = new QName("http://webservice/", "findFournisseurById");
    private final static QName _FindFournisseurByIdResponse_QNAME = new QName("http://webservice/", "findFournisseurByIdResponse");
    private final static QName _FindLivraisonByCommandId_QNAME = new QName("http://webservice/", "findLivraisonByCommandId");
    private final static QName _FindLivraisonByCommandIdResponse_QNAME = new QName("http://webservice/", "findLivraisonByCommandIdResponse");
    private final static QName _FindUtilisateurByLogin_QNAME = new QName("http://webservice/", "findUtilisateurByLogin");
    private final static QName _FindUtilisateurByLoginResponse_QNAME = new QName("http://webservice/", "findUtilisateurByLoginResponse");
    private final static QName _GetAccuseReception_QNAME = new QName("http://webservice/", "getAccuseReception");
    private final static QName _GetAccuseReceptionResponse_QNAME = new QName("http://webservice/", "getAccuseReceptionResponse");
    private final static QName _GetAccusesReceptions_QNAME = new QName("http://webservice/", "getAccusesReceptions");
    private final static QName _GetAccusesReceptionsResponse_QNAME = new QName("http://webservice/", "getAccusesReceptionsResponse");
    private final static QName _GetFacture_QNAME = new QName("http://webservice/", "getFacture");
    private final static QName _GetFactureResponse_QNAME = new QName("http://webservice/", "getFactureResponse");
    private final static QName _GetFactures_QNAME = new QName("http://webservice/", "getFactures");
    private final static QName _GetFacturesResponse_QNAME = new QName("http://webservice/", "getFacturesResponse");
    private final static QName _GetFournisseurs_QNAME = new QName("http://webservice/", "getFournisseurs");
    private final static QName _GetFournisseursResponse_QNAME = new QName("http://webservice/", "getFournisseursResponse");
    private final static QName _GetLivraison_QNAME = new QName("http://webservice/", "getLivraison");
    private final static QName _GetLivraisonResponse_QNAME = new QName("http://webservice/", "getLivraisonResponse");
    private final static QName _GetLivraisons_QNAME = new QName("http://webservice/", "getLivraisons");
    private final static QName _GetLivraisonsResponse_QNAME = new QName("http://webservice/", "getLivraisonsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AjoutAccuseReception }
     * 
     */
    public AjoutAccuseReception createAjoutAccuseReception() {
        return new AjoutAccuseReception();
    }

    /**
     * Create an instance of {@link AjoutAccuseReceptionResponse }
     * 
     */
    public AjoutAccuseReceptionResponse createAjoutAccuseReceptionResponse() {
        return new AjoutAccuseReceptionResponse();
    }

    /**
     * Create an instance of {@link AjoutCommande }
     * 
     */
    public AjoutCommande createAjoutCommande() {
        return new AjoutCommande();
    }

    /**
     * Create an instance of {@link AjoutCommandeResponse }
     * 
     */
    public AjoutCommandeResponse createAjoutCommandeResponse() {
        return new AjoutCommandeResponse();
    }

    /**
     * Create an instance of {@link AjoutFacture }
     * 
     */
    public AjoutFacture createAjoutFacture() {
        return new AjoutFacture();
    }

    /**
     * Create an instance of {@link AjoutFactureResponse }
     * 
     */
    public AjoutFactureResponse createAjoutFactureResponse() {
        return new AjoutFactureResponse();
    }

    /**
     * Create an instance of {@link AjoutPaiement }
     * 
     */
    public AjoutPaiement createAjoutPaiement() {
        return new AjoutPaiement();
    }

    /**
     * Create an instance of {@link AjoutPaiementResponse }
     * 
     */
    public AjoutPaiementResponse createAjoutPaiementResponse() {
        return new AjoutPaiementResponse();
    }

    /**
     * Create an instance of {@link Connexion }
     * 
     */
    public Connexion createConnexion() {
        return new Connexion();
    }

    /**
     * Create an instance of {@link ConnexionResponse }
     * 
     */
    public ConnexionResponse createConnexionResponse() {
        return new ConnexionResponse();
    }

    /**
     * Create an instance of {@link ExisteAccuseReceptionByIdCommande }
     * 
     */
    public ExisteAccuseReceptionByIdCommande createExisteAccuseReceptionByIdCommande() {
        return new ExisteAccuseReceptionByIdCommande();
    }

    /**
     * Create an instance of {@link ExisteAccuseReceptionByIdCommandeResponse }
     * 
     */
    public ExisteAccuseReceptionByIdCommandeResponse createExisteAccuseReceptionByIdCommandeResponse() {
        return new ExisteAccuseReceptionByIdCommandeResponse();
    }

    /**
     * Create an instance of {@link ExisteCommandeById }
     * 
     */
    public ExisteCommandeById createExisteCommandeById() {
        return new ExisteCommandeById();
    }

    /**
     * Create an instance of {@link ExisteCommandeByIdResponse }
     * 
     */
    public ExisteCommandeByIdResponse createExisteCommandeByIdResponse() {
        return new ExisteCommandeByIdResponse();
    }

    /**
     * Create an instance of {@link ExisteLivraisonByCommandId }
     * 
     */
    public ExisteLivraisonByCommandId createExisteLivraisonByCommandId() {
        return new ExisteLivraisonByCommandId();
    }

    /**
     * Create an instance of {@link ExisteLivraisonByCommandIdResponse }
     * 
     */
    public ExisteLivraisonByCommandIdResponse createExisteLivraisonByCommandIdResponse() {
        return new ExisteLivraisonByCommandIdResponse();
    }

    /**
     * Create an instance of {@link FindAccuseReceptionByIdCommande }
     * 
     */
    public FindAccuseReceptionByIdCommande createFindAccuseReceptionByIdCommande() {
        return new FindAccuseReceptionByIdCommande();
    }

    /**
     * Create an instance of {@link FindAccuseReceptionByIdCommandeResponse }
     * 
     */
    public FindAccuseReceptionByIdCommandeResponse createFindAccuseReceptionByIdCommandeResponse() {
        return new FindAccuseReceptionByIdCommandeResponse();
    }

    /**
     * Create an instance of {@link FindAllCommande }
     * 
     */
    public FindAllCommande createFindAllCommande() {
        return new FindAllCommande();
    }

    /**
     * Create an instance of {@link FindAllCommandeResponse }
     * 
     */
    public FindAllCommandeResponse createFindAllCommandeResponse() {
        return new FindAllCommandeResponse();
    }

    /**
     * Create an instance of {@link FindAllPaiement }
     * 
     */
    public FindAllPaiement createFindAllPaiement() {
        return new FindAllPaiement();
    }

    /**
     * Create an instance of {@link FindAllPaiementResponse }
     * 
     */
    public FindAllPaiementResponse createFindAllPaiementResponse() {
        return new FindAllPaiementResponse();
    }

    /**
     * Create an instance of {@link FindAllcommandeForComptable }
     * 
     */
    public FindAllcommandeForComptable createFindAllcommandeForComptable() {
        return new FindAllcommandeForComptable();
    }

    /**
     * Create an instance of {@link FindAllcommandeForComptableResponse }
     * 
     */
    public FindAllcommandeForComptableResponse createFindAllcommandeForComptableResponse() {
        return new FindAllcommandeForComptableResponse();
    }

    /**
     * Create an instance of {@link FindAllcommandeForResponsableStock }
     * 
     */
    public FindAllcommandeForResponsableStock createFindAllcommandeForResponsableStock() {
        return new FindAllcommandeForResponsableStock();
    }

    /**
     * Create an instance of {@link FindAllcommandeForResponsableStockResponse }
     * 
     */
    public FindAllcommandeForResponsableStockResponse createFindAllcommandeForResponsableStockResponse() {
        return new FindAllcommandeForResponsableStockResponse();
    }

    /**
     * Create an instance of {@link FindCommandeById }
     * 
     */
    public FindCommandeById createFindCommandeById() {
        return new FindCommandeById();
    }

    /**
     * Create an instance of {@link FindCommandeByIdResponse }
     * 
     */
    public FindCommandeByIdResponse createFindCommandeByIdResponse() {
        return new FindCommandeByIdResponse();
    }

    /**
     * Create an instance of {@link FindFactureByIdCommande }
     * 
     */
    public FindFactureByIdCommande createFindFactureByIdCommande() {
        return new FindFactureByIdCommande();
    }

    /**
     * Create an instance of {@link FindFactureByIdCommandeResponse }
     * 
     */
    public FindFactureByIdCommandeResponse createFindFactureByIdCommandeResponse() {
        return new FindFactureByIdCommandeResponse();
    }

    /**
     * Create an instance of {@link FindFournisseurById }
     * 
     */
    public FindFournisseurById createFindFournisseurById() {
        return new FindFournisseurById();
    }

    /**
     * Create an instance of {@link FindFournisseurByIdResponse }
     * 
     */
    public FindFournisseurByIdResponse createFindFournisseurByIdResponse() {
        return new FindFournisseurByIdResponse();
    }

    /**
     * Create an instance of {@link FindLivraisonByCommandId }
     * 
     */
    public FindLivraisonByCommandId createFindLivraisonByCommandId() {
        return new FindLivraisonByCommandId();
    }

    /**
     * Create an instance of {@link FindLivraisonByCommandIdResponse }
     * 
     */
    public FindLivraisonByCommandIdResponse createFindLivraisonByCommandIdResponse() {
        return new FindLivraisonByCommandIdResponse();
    }

    /**
     * Create an instance of {@link FindUtilisateurByLogin }
     * 
     */
    public FindUtilisateurByLogin createFindUtilisateurByLogin() {
        return new FindUtilisateurByLogin();
    }

    /**
     * Create an instance of {@link FindUtilisateurByLoginResponse }
     * 
     */
    public FindUtilisateurByLoginResponse createFindUtilisateurByLoginResponse() {
        return new FindUtilisateurByLoginResponse();
    }

    /**
     * Create an instance of {@link GetAccuseReception }
     * 
     */
    public GetAccuseReception createGetAccuseReception() {
        return new GetAccuseReception();
    }

    /**
     * Create an instance of {@link GetAccuseReceptionResponse }
     * 
     */
    public GetAccuseReceptionResponse createGetAccuseReceptionResponse() {
        return new GetAccuseReceptionResponse();
    }

    /**
     * Create an instance of {@link GetAccusesReceptions }
     * 
     */
    public GetAccusesReceptions createGetAccusesReceptions() {
        return new GetAccusesReceptions();
    }

    /**
     * Create an instance of {@link GetAccusesReceptionsResponse }
     * 
     */
    public GetAccusesReceptionsResponse createGetAccusesReceptionsResponse() {
        return new GetAccusesReceptionsResponse();
    }

    /**
     * Create an instance of {@link GetFacture }
     * 
     */
    public GetFacture createGetFacture() {
        return new GetFacture();
    }

    /**
     * Create an instance of {@link GetFactureResponse }
     * 
     */
    public GetFactureResponse createGetFactureResponse() {
        return new GetFactureResponse();
    }

    /**
     * Create an instance of {@link GetFactures }
     * 
     */
    public GetFactures createGetFactures() {
        return new GetFactures();
    }

    /**
     * Create an instance of {@link GetFacturesResponse }
     * 
     */
    public GetFacturesResponse createGetFacturesResponse() {
        return new GetFacturesResponse();
    }

    /**
     * Create an instance of {@link GetFournisseurs }
     * 
     */
    public GetFournisseurs createGetFournisseurs() {
        return new GetFournisseurs();
    }

    /**
     * Create an instance of {@link GetFournisseursResponse }
     * 
     */
    public GetFournisseursResponse createGetFournisseursResponse() {
        return new GetFournisseursResponse();
    }

    /**
     * Create an instance of {@link GetLivraison }
     * 
     */
    public GetLivraison createGetLivraison() {
        return new GetLivraison();
    }

    /**
     * Create an instance of {@link GetLivraisonResponse }
     * 
     */
    public GetLivraisonResponse createGetLivraisonResponse() {
        return new GetLivraisonResponse();
    }

    /**
     * Create an instance of {@link GetLivraisons }
     * 
     */
    public GetLivraisons createGetLivraisons() {
        return new GetLivraisons();
    }

    /**
     * Create an instance of {@link GetLivraisonsResponse }
     * 
     */
    public GetLivraisonsResponse createGetLivraisonsResponse() {
        return new GetLivraisonsResponse();
    }

    /**
     * Create an instance of {@link AccuseReception }
     * 
     */
    public AccuseReception createAccuseReception() {
        return new AccuseReception();
    }

    /**
     * Create an instance of {@link Commande }
     * 
     */
    public Commande createCommande() {
        return new Commande();
    }

    /**
     * Create an instance of {@link Fournisseur }
     * 
     */
    public Fournisseur createFournisseur() {
        return new Fournisseur();
    }

    /**
     * Create an instance of {@link Facture }
     * 
     */
    public Facture createFacture() {
        return new Facture();
    }

    /**
     * Create an instance of {@link Paiement }
     * 
     */
    public Paiement createPaiement() {
        return new Paiement();
    }

    /**
     * Create an instance of {@link Livraison }
     * 
     */
    public Livraison createLivraison() {
        return new Livraison();
    }

    /**
     * Create an instance of {@link Utilisateur }
     * 
     */
    public Utilisateur createUtilisateur() {
        return new Utilisateur();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjoutAccuseReception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "ajoutAccuseReception")
    public JAXBElement<AjoutAccuseReception> createAjoutAccuseReception(AjoutAccuseReception value) {
        return new JAXBElement<AjoutAccuseReception>(_AjoutAccuseReception_QNAME, AjoutAccuseReception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjoutAccuseReceptionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "ajoutAccuseReceptionResponse")
    public JAXBElement<AjoutAccuseReceptionResponse> createAjoutAccuseReceptionResponse(AjoutAccuseReceptionResponse value) {
        return new JAXBElement<AjoutAccuseReceptionResponse>(_AjoutAccuseReceptionResponse_QNAME, AjoutAccuseReceptionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjoutCommande }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "ajoutCommande")
    public JAXBElement<AjoutCommande> createAjoutCommande(AjoutCommande value) {
        return new JAXBElement<AjoutCommande>(_AjoutCommande_QNAME, AjoutCommande.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjoutCommandeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "ajoutCommandeResponse")
    public JAXBElement<AjoutCommandeResponse> createAjoutCommandeResponse(AjoutCommandeResponse value) {
        return new JAXBElement<AjoutCommandeResponse>(_AjoutCommandeResponse_QNAME, AjoutCommandeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjoutFacture }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "ajoutFacture")
    public JAXBElement<AjoutFacture> createAjoutFacture(AjoutFacture value) {
        return new JAXBElement<AjoutFacture>(_AjoutFacture_QNAME, AjoutFacture.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjoutFactureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "ajoutFactureResponse")
    public JAXBElement<AjoutFactureResponse> createAjoutFactureResponse(AjoutFactureResponse value) {
        return new JAXBElement<AjoutFactureResponse>(_AjoutFactureResponse_QNAME, AjoutFactureResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjoutPaiement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "ajoutPaiement")
    public JAXBElement<AjoutPaiement> createAjoutPaiement(AjoutPaiement value) {
        return new JAXBElement<AjoutPaiement>(_AjoutPaiement_QNAME, AjoutPaiement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjoutPaiementResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "ajoutPaiementResponse")
    public JAXBElement<AjoutPaiementResponse> createAjoutPaiementResponse(AjoutPaiementResponse value) {
        return new JAXBElement<AjoutPaiementResponse>(_AjoutPaiementResponse_QNAME, AjoutPaiementResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Connexion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "connexion")
    public JAXBElement<Connexion> createConnexion(Connexion value) {
        return new JAXBElement<Connexion>(_Connexion_QNAME, Connexion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConnexionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "connexionResponse")
    public JAXBElement<ConnexionResponse> createConnexionResponse(ConnexionResponse value) {
        return new JAXBElement<ConnexionResponse>(_ConnexionResponse_QNAME, ConnexionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExisteAccuseReceptionByIdCommande }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "existeAccuseReceptionByIdCommande")
    public JAXBElement<ExisteAccuseReceptionByIdCommande> createExisteAccuseReceptionByIdCommande(ExisteAccuseReceptionByIdCommande value) {
        return new JAXBElement<ExisteAccuseReceptionByIdCommande>(_ExisteAccuseReceptionByIdCommande_QNAME, ExisteAccuseReceptionByIdCommande.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExisteAccuseReceptionByIdCommandeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "existeAccuseReceptionByIdCommandeResponse")
    public JAXBElement<ExisteAccuseReceptionByIdCommandeResponse> createExisteAccuseReceptionByIdCommandeResponse(ExisteAccuseReceptionByIdCommandeResponse value) {
        return new JAXBElement<ExisteAccuseReceptionByIdCommandeResponse>(_ExisteAccuseReceptionByIdCommandeResponse_QNAME, ExisteAccuseReceptionByIdCommandeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExisteCommandeById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "existeCommandeById")
    public JAXBElement<ExisteCommandeById> createExisteCommandeById(ExisteCommandeById value) {
        return new JAXBElement<ExisteCommandeById>(_ExisteCommandeById_QNAME, ExisteCommandeById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExisteCommandeByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "existeCommandeByIdResponse")
    public JAXBElement<ExisteCommandeByIdResponse> createExisteCommandeByIdResponse(ExisteCommandeByIdResponse value) {
        return new JAXBElement<ExisteCommandeByIdResponse>(_ExisteCommandeByIdResponse_QNAME, ExisteCommandeByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExisteLivraisonByCommandId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "existeLivraisonByCommandId")
    public JAXBElement<ExisteLivraisonByCommandId> createExisteLivraisonByCommandId(ExisteLivraisonByCommandId value) {
        return new JAXBElement<ExisteLivraisonByCommandId>(_ExisteLivraisonByCommandId_QNAME, ExisteLivraisonByCommandId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExisteLivraisonByCommandIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "existeLivraisonByCommandIdResponse")
    public JAXBElement<ExisteLivraisonByCommandIdResponse> createExisteLivraisonByCommandIdResponse(ExisteLivraisonByCommandIdResponse value) {
        return new JAXBElement<ExisteLivraisonByCommandIdResponse>(_ExisteLivraisonByCommandIdResponse_QNAME, ExisteLivraisonByCommandIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAccuseReceptionByIdCommande }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findAccuseReceptionByIdCommande")
    public JAXBElement<FindAccuseReceptionByIdCommande> createFindAccuseReceptionByIdCommande(FindAccuseReceptionByIdCommande value) {
        return new JAXBElement<FindAccuseReceptionByIdCommande>(_FindAccuseReceptionByIdCommande_QNAME, FindAccuseReceptionByIdCommande.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAccuseReceptionByIdCommandeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findAccuseReceptionByIdCommandeResponse")
    public JAXBElement<FindAccuseReceptionByIdCommandeResponse> createFindAccuseReceptionByIdCommandeResponse(FindAccuseReceptionByIdCommandeResponse value) {
        return new JAXBElement<FindAccuseReceptionByIdCommandeResponse>(_FindAccuseReceptionByIdCommandeResponse_QNAME, FindAccuseReceptionByIdCommandeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllCommande }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findAllCommande")
    public JAXBElement<FindAllCommande> createFindAllCommande(FindAllCommande value) {
        return new JAXBElement<FindAllCommande>(_FindAllCommande_QNAME, FindAllCommande.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllCommandeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findAllCommandeResponse")
    public JAXBElement<FindAllCommandeResponse> createFindAllCommandeResponse(FindAllCommandeResponse value) {
        return new JAXBElement<FindAllCommandeResponse>(_FindAllCommandeResponse_QNAME, FindAllCommandeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllPaiement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findAllPaiement")
    public JAXBElement<FindAllPaiement> createFindAllPaiement(FindAllPaiement value) {
        return new JAXBElement<FindAllPaiement>(_FindAllPaiement_QNAME, FindAllPaiement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllPaiementResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findAllPaiementResponse")
    public JAXBElement<FindAllPaiementResponse> createFindAllPaiementResponse(FindAllPaiementResponse value) {
        return new JAXBElement<FindAllPaiementResponse>(_FindAllPaiementResponse_QNAME, FindAllPaiementResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllcommandeForComptable }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findAllcommandeForComptable")
    public JAXBElement<FindAllcommandeForComptable> createFindAllcommandeForComptable(FindAllcommandeForComptable value) {
        return new JAXBElement<FindAllcommandeForComptable>(_FindAllcommandeForComptable_QNAME, FindAllcommandeForComptable.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllcommandeForComptableResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findAllcommandeForComptableResponse")
    public JAXBElement<FindAllcommandeForComptableResponse> createFindAllcommandeForComptableResponse(FindAllcommandeForComptableResponse value) {
        return new JAXBElement<FindAllcommandeForComptableResponse>(_FindAllcommandeForComptableResponse_QNAME, FindAllcommandeForComptableResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllcommandeForResponsableStock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findAllcommandeForResponsableStock")
    public JAXBElement<FindAllcommandeForResponsableStock> createFindAllcommandeForResponsableStock(FindAllcommandeForResponsableStock value) {
        return new JAXBElement<FindAllcommandeForResponsableStock>(_FindAllcommandeForResponsableStock_QNAME, FindAllcommandeForResponsableStock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllcommandeForResponsableStockResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findAllcommandeForResponsableStockResponse")
    public JAXBElement<FindAllcommandeForResponsableStockResponse> createFindAllcommandeForResponsableStockResponse(FindAllcommandeForResponsableStockResponse value) {
        return new JAXBElement<FindAllcommandeForResponsableStockResponse>(_FindAllcommandeForResponsableStockResponse_QNAME, FindAllcommandeForResponsableStockResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCommandeById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findCommandeById")
    public JAXBElement<FindCommandeById> createFindCommandeById(FindCommandeById value) {
        return new JAXBElement<FindCommandeById>(_FindCommandeById_QNAME, FindCommandeById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCommandeByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findCommandeByIdResponse")
    public JAXBElement<FindCommandeByIdResponse> createFindCommandeByIdResponse(FindCommandeByIdResponse value) {
        return new JAXBElement<FindCommandeByIdResponse>(_FindCommandeByIdResponse_QNAME, FindCommandeByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFactureByIdCommande }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findFactureByIdCommande")
    public JAXBElement<FindFactureByIdCommande> createFindFactureByIdCommande(FindFactureByIdCommande value) {
        return new JAXBElement<FindFactureByIdCommande>(_FindFactureByIdCommande_QNAME, FindFactureByIdCommande.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFactureByIdCommandeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findFactureByIdCommandeResponse")
    public JAXBElement<FindFactureByIdCommandeResponse> createFindFactureByIdCommandeResponse(FindFactureByIdCommandeResponse value) {
        return new JAXBElement<FindFactureByIdCommandeResponse>(_FindFactureByIdCommandeResponse_QNAME, FindFactureByIdCommandeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFournisseurById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findFournisseurById")
    public JAXBElement<FindFournisseurById> createFindFournisseurById(FindFournisseurById value) {
        return new JAXBElement<FindFournisseurById>(_FindFournisseurById_QNAME, FindFournisseurById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFournisseurByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findFournisseurByIdResponse")
    public JAXBElement<FindFournisseurByIdResponse> createFindFournisseurByIdResponse(FindFournisseurByIdResponse value) {
        return new JAXBElement<FindFournisseurByIdResponse>(_FindFournisseurByIdResponse_QNAME, FindFournisseurByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindLivraisonByCommandId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findLivraisonByCommandId")
    public JAXBElement<FindLivraisonByCommandId> createFindLivraisonByCommandId(FindLivraisonByCommandId value) {
        return new JAXBElement<FindLivraisonByCommandId>(_FindLivraisonByCommandId_QNAME, FindLivraisonByCommandId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindLivraisonByCommandIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findLivraisonByCommandIdResponse")
    public JAXBElement<FindLivraisonByCommandIdResponse> createFindLivraisonByCommandIdResponse(FindLivraisonByCommandIdResponse value) {
        return new JAXBElement<FindLivraisonByCommandIdResponse>(_FindLivraisonByCommandIdResponse_QNAME, FindLivraisonByCommandIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUtilisateurByLogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findUtilisateurByLogin")
    public JAXBElement<FindUtilisateurByLogin> createFindUtilisateurByLogin(FindUtilisateurByLogin value) {
        return new JAXBElement<FindUtilisateurByLogin>(_FindUtilisateurByLogin_QNAME, FindUtilisateurByLogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUtilisateurByLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findUtilisateurByLoginResponse")
    public JAXBElement<FindUtilisateurByLoginResponse> createFindUtilisateurByLoginResponse(FindUtilisateurByLoginResponse value) {
        return new JAXBElement<FindUtilisateurByLoginResponse>(_FindUtilisateurByLoginResponse_QNAME, FindUtilisateurByLoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccuseReception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getAccuseReception")
    public JAXBElement<GetAccuseReception> createGetAccuseReception(GetAccuseReception value) {
        return new JAXBElement<GetAccuseReception>(_GetAccuseReception_QNAME, GetAccuseReception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccuseReceptionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getAccuseReceptionResponse")
    public JAXBElement<GetAccuseReceptionResponse> createGetAccuseReceptionResponse(GetAccuseReceptionResponse value) {
        return new JAXBElement<GetAccuseReceptionResponse>(_GetAccuseReceptionResponse_QNAME, GetAccuseReceptionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccusesReceptions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getAccusesReceptions")
    public JAXBElement<GetAccusesReceptions> createGetAccusesReceptions(GetAccusesReceptions value) {
        return new JAXBElement<GetAccusesReceptions>(_GetAccusesReceptions_QNAME, GetAccusesReceptions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccusesReceptionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getAccusesReceptionsResponse")
    public JAXBElement<GetAccusesReceptionsResponse> createGetAccusesReceptionsResponse(GetAccusesReceptionsResponse value) {
        return new JAXBElement<GetAccusesReceptionsResponse>(_GetAccusesReceptionsResponse_QNAME, GetAccusesReceptionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFacture }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getFacture")
    public JAXBElement<GetFacture> createGetFacture(GetFacture value) {
        return new JAXBElement<GetFacture>(_GetFacture_QNAME, GetFacture.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFactureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getFactureResponse")
    public JAXBElement<GetFactureResponse> createGetFactureResponse(GetFactureResponse value) {
        return new JAXBElement<GetFactureResponse>(_GetFactureResponse_QNAME, GetFactureResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFactures }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getFactures")
    public JAXBElement<GetFactures> createGetFactures(GetFactures value) {
        return new JAXBElement<GetFactures>(_GetFactures_QNAME, GetFactures.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFacturesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getFacturesResponse")
    public JAXBElement<GetFacturesResponse> createGetFacturesResponse(GetFacturesResponse value) {
        return new JAXBElement<GetFacturesResponse>(_GetFacturesResponse_QNAME, GetFacturesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFournisseurs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getFournisseurs")
    public JAXBElement<GetFournisseurs> createGetFournisseurs(GetFournisseurs value) {
        return new JAXBElement<GetFournisseurs>(_GetFournisseurs_QNAME, GetFournisseurs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFournisseursResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getFournisseursResponse")
    public JAXBElement<GetFournisseursResponse> createGetFournisseursResponse(GetFournisseursResponse value) {
        return new JAXBElement<GetFournisseursResponse>(_GetFournisseursResponse_QNAME, GetFournisseursResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLivraison }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getLivraison")
    public JAXBElement<GetLivraison> createGetLivraison(GetLivraison value) {
        return new JAXBElement<GetLivraison>(_GetLivraison_QNAME, GetLivraison.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLivraisonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getLivraisonResponse")
    public JAXBElement<GetLivraisonResponse> createGetLivraisonResponse(GetLivraisonResponse value) {
        return new JAXBElement<GetLivraisonResponse>(_GetLivraisonResponse_QNAME, GetLivraisonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLivraisons }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getLivraisons")
    public JAXBElement<GetLivraisons> createGetLivraisons(GetLivraisons value) {
        return new JAXBElement<GetLivraisons>(_GetLivraisons_QNAME, GetLivraisons.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLivraisonsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getLivraisonsResponse")
    public JAXBElement<GetLivraisonsResponse> createGetLivraisonsResponse(GetLivraisonsResponse value) {
        return new JAXBElement<GetLivraisonsResponse>(_GetLivraisonsResponse_QNAME, GetLivraisonsResponse.class, null, value);
    }

}
