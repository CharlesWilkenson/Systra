package managebean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.projetsystra.metier.entities.*;
import com.projetsystra.metier.interfaces.*;

import loginbean.Connexion;


@ManagedBean(name="fournisseurMB")
@ViewScoped
public class FournisseurMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EJB
	private ServiceILocal metier; 
private boolean verification=true;
private boolean showfourn;
	
	public boolean isVerification() {
	return verification;
}
public void setVerification(boolean verification) {
	this.verification = verification;
}
public boolean isShowfourn() {
	return showfourn;
}
public void setShowfourn(boolean showfourn) {
	this.showfourn = showfourn;
}


	private  Connexion connect=new Connexion();
	private String fournID;
	private String fournNom;
	private String fournPrenom;
	private String fournAdresse;
	private String fournCin_nif;
	private String fournTelephone;
	private String fournEmail;
	private String fournUsine;
	private String fournEtat;
	private String achatId;
	private int achatQtTotal;
	private double achatPrixTotal;
	private Date achatDate;
	private String achatEtat;
	private String idfournisseur;
    private String idProd,nomprod;
    private String idparcelle;
    private String idregion;
    private List<FournisseurEntity> lstfourn;
    public List<FournisseurEntity> getLstfourn() {
		return lstfourn;
	}
	public void setLstfourn(List<FournisseurEntity> lstfourn) {
		this.lstfourn = lstfourn;
	}
	public Connexion getConnect() {
		return connect;
	}
	public void setConnect(Connexion connect) {
		this.connect = connect;
	}
	public String getFournID() {
		return fournID;
	}
	public void setFournID(String fournID) {
		this.fournID = fournID;
	}
	public String getFournCin_nif() {
		return fournCin_nif;
	}
	public void setFournCin_nif(String fournCin_nif) {
		this.fournCin_nif = fournCin_nif;
	}
	public String getAchatId() {
		return achatId;
	}
	public void setAchatId(String achatId) {
		this.achatId = achatId;
	}
	public int getAchatQtTotal() {
		return achatQtTotal;
	}
	public void setAchatQtTotal(int achatQtTotal) {
		this.achatQtTotal = achatQtTotal;
	}
	public double getAchatPrixTotal() {
		return achatPrixTotal;
	}
	public void setAchatPrixTotal(double achatPrixTotal) {
		this.achatPrixTotal = achatPrixTotal;
	}
	public Date getAchatDate() {
		return achatDate;
	}
	public void setAchatDate(Date achatDate) {
		this.achatDate = achatDate;
	}
	public String getAchatEtat() {
		return achatEtat;
	}
	public void setAchatEtat(String achatEtat) {
		this.achatEtat = achatEtat;
	}
	public String getIdfournisseur() {
		return idfournisseur;
	}
	public void setIdfournisseur(String idfournisseur) {
		this.idfournisseur = idfournisseur;
	}
	public String getIdProd() {
		return idProd;
	}
	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}
	public String getNomprod() {
		return nomprod;
	}
	public void setNomprod(String nomprod) {
		this.nomprod = nomprod;
	}
	public String getIdparcelle() {
		return idparcelle;
	}
	public void setIdparcelle(String idparcelle) {
		this.idparcelle = idparcelle;
	}
	public String getIdregion() {
		return idregion;
	}
	public void setIdregion(String idregion) {
		this.idregion = idregion;
	}

	
	public String getfournID() {
		return fournID;
	}
	public void setfournID(String fournId) {
		this.fournID = fournId;
	}
	public String getFournNom() {
		return fournNom;
	}
	public void setFournNom(String fournNom) {
		this.fournNom = fournNom;
	}
	public String getFournPrenom() {
		return fournPrenom;
	}
	public void setFournPrenom(String fournPrenom) {
		this.fournPrenom = fournPrenom;
	}
	public String getFournAdresse() {
		return fournAdresse;
	}
	public void setFournAdresse(String fournAdresse) {
		this.fournAdresse = fournAdresse;
	}
	public String getfournCin_nif() {
		return fournCin_nif;
	}
	public void setfournCin_nif(String fournCinif) {
		this.fournCin_nif = fournCinif;
	}
	public String getFournTelephone() {
		return fournTelephone;
	}
	public void setFournTelephone(String fournTelephone) {
		this.fournTelephone = fournTelephone;
	}
	public String getFournEmail() {
		return fournEmail;
	}
	public void setFournEmail(String fournEmail) {
		this.fournEmail = fournEmail;
	}
	public String getFournUsine() {
		return fournUsine;
	}
	public void setFournUsine(String fournUsine) {
		this.fournUsine = fournUsine;
	}
	public String getFournEtat() {
		return fournEtat;
	}
	public void setFournEtat(String fournEtat) {
		this.fournEtat = fournEtat;
	}
	public String Addfourn()

	{
		if(fournID==null|| fournNom==null|| fournPrenom==null||
				fournCin_nif==null|| fournAdresse==null|| 
				fournTelephone==null|| fournEmail==null|| fournUsine==null){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Il faut remplir tous les champs",""));
			
		}

else if(metier.FindOneFournisseur(fournID)!=null)
		{
			 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ce fournisseur existe deja",""));			
			 					
		}	
				
else{
	
	try{
		metier.AddFournisseur(new FournisseurEntity(fournID, fournNom, fournPrenom, fournCin_nif,fournTelephone, fournAdresse,  fournEmail, fournUsine, "Actif"));
		metier.addTrace(new TraceEntity(emailUser(), new Date(), "Nouveau Fournisseur -"+fournID));
		
		clearFourn();
		setfournID(null);
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Fournisseur enregistre avec succes",""));
			}catch(Exception e){
				 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec d'enregistrement du fournisseur",""));			
			}
	
}
		return "success";
		}




public String updateFourn(){
	if(fournID==null|| fournNom==null|| fournPrenom==null||
			fournCin_nif==null|| fournAdresse==null|| 
			fournTelephone==null|| fournEmail==null|| fournUsine==null){
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Il faut remplir tous les champs",""));
		
	}	
		else{

		
	    try{
	    	metier.UpdateFournisseur(new FournisseurEntity(fournID, fournNom, fournPrenom, 
	    	fournCin_nif,fournTelephone, fournAdresse,  fournEmail, fournUsine,fournEtat));
	    		metier.addTrace(new TraceEntity(emailUser(), new Date(), "Modifier Fournisseur -"+fournID));
	   
	    		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Fournisseur modifie avec succes",""));
	    		}catch(Exception e){
	    			 
	    			 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"PEchec de modification du fournisseur",""));			
	    		}	
	}
	return"";
}

public List<FournisseurEntity> getlistfournisseurPassif()
{
	return metier.getFournisseurByetat("Passif");
}
	
	public List<FournisseurEntity> getlistfournisseurs()
	{
		return metier.getFournisseurByetat("Actif");
	}
	public String Editfourn()
	{
		FournisseurEntity four = metier.FindOneFournisseur(fournID);
		
		 if(four==null){
				verification=true;
				showfourn=false;
				 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Fournisseur inconu",""));			
					
			 }else{
				 fournID =four.getFournisseurId();
				 fournNom =four.getFournisseurNom();
				 fournPrenom =four.getFournisseurPrenom();
				 fournAdresse=four.getFournisseurAdresse();
				 fournCin_nif=four.getFournisseurCin_nif();
				 fournTelephone=four.getFournisseurTelephone();
				 fournEmail=four.getFournisseurEmail();
				 fournUsine=four.getFournisseurUsine();
				 fournEtat=four.getFournisseurEtat(); 
				 verification=false;
					showfourn=true;
			 }
				
	
		 
		return "fourn";
	}


	public String getparam()
	 {
	FacesContext fc= FacesContext.getCurrentInstance();
	Map<String, String> param= fc.getExternalContext().getRequestParameterMap();
	String idfourn = param.get("idfournisseur");
		return idfourn; 
	 }
	public void clearFourn()
	 {
		 setFournAdresse(null);
		 setFournEmail(null);
		 setFournEtat(null);
		 setFournNom(null);
		 setFournPrenom(null);
		 setfournCin_nif(null);		 
		 setFournUsine(null);
		 setFournTelephone(null);
		 connect.setCodeFournisseur(null);
		 connect.setFournNom(null);
		 connect.setFournPrenom(null);
		 connect.setFounAdresse(null);
		 connect.setFournNif(null);
		 connect.setFournTel(null);
		 connect.setFournEmail(null);
		 connect.setFournUsine(null);
		 connect.setFournEtat(null);
		 
			connect.setParcelleEtat(null);
	    	connect.setCodeProd(null);
	    	connect.setCodePacelle(null);	
	    	connect.setProdNom(null);
	    	connect.setProdSexe(null);
	    	connect.setProdTel(null);
	    	connect.setProdEtat(null);
	 }
	
	
	public String desActiverfourn()
	{
		FournisseurEntity f=new FournisseurEntity();
		FournisseurEntity four = metier.FindOneFournisseur(fournID);
	
		 f.setFournisseurId(four.getFournisseurId());
		 f.setFournisseurNom(four.getFournisseurNom());
		 f.setFournisseurPrenom(four.getFournisseurPrenom());
		 f.setFournisseurAdresse(four.getFournisseurAdresse());
		 f.setFournisseurCin_nif(four.getFournisseurCin_nif());
		 f.setFournisseurTelephone(four.getFournisseurTelephone());
		 f.setFournisseurEmail(four.getFournisseurEmail());
		 f.setFournisseurUsine(four.getFournisseurUsine());
		 f.setFournisseurEtat("Passif");
		
		 try{
			 metier.UpdateFournisseur(f);
			  FournisseurEntity etat = metier.FindOneFournisseur(fournID);
			 fournEtat=etat.getFournisseurEtat();
			 metier.addTrace(new TraceEntity(emailUser(), new Date(), "Desactiver Fournisseur -"+fournID));
				
			 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Fournisseur desactive avec succes",""));
			 }catch(Exception e){
				 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec de desactivation du Fournisseur",""));			
					
			 }
		return "fourn";
	}
	
	public String desActiverfou()
	{
		FournisseurEntity f=new FournisseurEntity();
		FournisseurEntity four = metier.FindOneFournisseur(connect.getCodeFournisseur());
      
		 f.setFournisseurId(four.getFournisseurId());
		 f.setFournisseurNom(four.getFournisseurNom());
		 f.setFournisseurPrenom(four.getFournisseurPrenom());
		 f.setFournisseurAdresse(four.getFournisseurAdresse());
		 f.setFournisseurCin_nif(four.getFournisseurCin_nif());
		 f.setFournisseurTelephone(four.getFournisseurTelephone());
		 f.setFournisseurEmail(four.getFournisseurEmail());
		 f.setFournisseurUsine(four.getFournisseurUsine());
		 f.setFournisseurEtat("Passif");
		 		 
		 try{
			 metier.UpdateFournisseur(f);
			 FournisseurEntity etat = metier.FindOneFournisseur(connect.getCodeFournisseur());
			 connect.setFournEtat(etat.getFournisseurEtat());
			 metier.addTrace(new TraceEntity(emailUser(), new Date(), "Desactiver Fournisseur -"+fournID));
				
			 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Fournisseur desactive avec succes",""));
			 }catch(Exception e){
				 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec de desactivation du Fournisseur",""));			
					
			 }
		return "fourn";
	}
	
	
	public String Activerfourn()
	{FournisseurEntity f=new FournisseurEntity();
		FournisseurEntity four = metier.FindOneFournisseur(fournID);
		 f.setFournisseurId(four.getFournisseurId());
		 f.setFournisseurNom(four.getFournisseurNom());
		 f.setFournisseurPrenom(four.getFournisseurPrenom());
		 f.setFournisseurAdresse(four.getFournisseurAdresse());
		 f.setFournisseurCin_nif(four.getFournisseurCin_nif());
		 f.setFournisseurTelephone(four.getFournisseurTelephone());
		 f.setFournisseurEmail(four.getFournisseurEmail());
		 f.setFournisseurUsine(four.getFournisseurUsine());
		 f.setFournisseurEtat("Actif");
		 
		 
		 try{
	
		 metier.UpdateFournisseur(f);
		 metier.addTrace(new TraceEntity(emailUser(), new Date(), "Activer fournisseur-"+fournID));
		 FournisseurEntity etat = metier.FindOneFournisseur(fournID);
		 fournEtat=etat.getFournisseurEtat();
		 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Fournisseur reactive avec succes",""));
		 }catch(Exception e){
			 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec de reactivation du Fournisseur",""));			
				
		 }
		return "fourn";
	}
	
	public String Activerfou()
	{FournisseurEntity f=new FournisseurEntity();
		FournisseurEntity four = metier.FindOneFournisseur(connect.getCodeFournisseur());
		 f.setFournisseurId(four.getFournisseurId());
		 f.setFournisseurNom(four.getFournisseurNom());
		 f.setFournisseurPrenom(four.getFournisseurPrenom());
		 f.setFournisseurAdresse(four.getFournisseurAdresse());
		 f.setFournisseurCin_nif(four.getFournisseurCin_nif());
		 f.setFournisseurTelephone(four.getFournisseurTelephone());
		 f.setFournisseurEmail(four.getFournisseurEmail());
		 f.setFournisseurUsine(four.getFournisseurUsine());
		 f.setFournisseurEtat("Actif");
		 
		 
		 try{
	
		 metier.UpdateFournisseur(f);
		 metier.addTrace(new TraceEntity(emailUser(), new Date(), "Activer fournisseur-"+fournID));
		 FournisseurEntity etat = metier.FindOneFournisseur(connect.getCodeFournisseur());
		 connect.setFournEtat(etat.getFournisseurEtat());
		 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Fournisseur reactive avec succes",""));
		 }catch(Exception e){
			 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec de reactivation du Fournisseur",""));			
				
		 }
		return "fourn";
	}
	
	
	
	public List<AchatsEntity> getachatById()
	 {
		return metier.GetAllachats(getparam());
	 }
		


	
	public String getProd()
	 {
	FacesContext fc= FacesContext.getCurrentInstance();
	Map<String, String> param= fc.getExternalContext().getRequestParameterMap();
	String codeProd= param.get("codeProd");
		return codeProd; 
	 }
	
	
		 public List<RegionEntity> getallregion() {	
			 return metier.GetAllRegion();
		
		 }
public List<AchatsEntity> lister(){
	
	return metier.GetAllachatsbyfourn("");
}
	

	

public String redirectTo2(){

	
	FournisseurEntity four = metier.FindOneFournisseur(getparam());
	 connect.setCodeFournisseur(four.getFournisseurId());
	 connect.setFournNom(four.getFournisseurNom());
	 connect.setFournPrenom(four.getFournisseurPrenom());
	 connect.setFounAdresse(four.getFournisseurAdresse());
	 connect.setFournNif(four.getFournisseurCin_nif());
	 connect.setFournTel(four.getFournisseurTelephone());
	 connect.setFournEmail(four.getFournisseurEmail());
	 connect.setFournUsine(four.getFournisseurUsine());
	 connect.setFournEtat(four.getFournisseurEtat()); 
	return"rechercherfournisseurs.xhtml?faces-redirect=true";
}


private String emailUser(){
	String nomUtilisateur =
			FacesContext.getCurrentInstance()
			.getExternalContext().getRemoteUser();	
	return nomUtilisateur;
	}



public String retour(){
	clearFourn();
	verification=true;
	showfourn=false;
	return"";
}


public String update(){
	if(connect.getCodeFournisseur()==null|| connect.getFournNom()==null|| connect.getFournPrenom()==null||
			connect.getFournNif()==null|| connect.getFounAdresse()==null|| 
					connect.getFournTel()==null|| connect.getFournEmail()==null||connect.getFournEtat()==null){
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Il faut remplir tous les champs",""));
		
	}else{

  try{
	    	metier.UpdateFournisseur(new FournisseurEntity(connect.getCodeFournisseur(), connect.getFournNom(), connect.getFournPrenom(), 
	    	connect.getFournNif(),connect.getFournTel(),connect.getFounAdresse(),connect.getFournEmail(), connect.getFournUsine(),connect.getFournEtat()));
	    		metier.addTrace(new TraceEntity(emailUser(), new Date(), "Modifier Fournisseur -"+connect.getCodeFournisseur()));
	    		
	 
	    		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Fournisseur modifie avec succes",""));
	    		}catch(Exception e){
	    			 
	    			 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"PEchec de modification du fournisseur",""));			
	    		}	
	}
	return"";
}

}



