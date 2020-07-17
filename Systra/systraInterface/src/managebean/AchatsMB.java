package managebean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import com.projetsystra.metier.entities.*;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import com.projetsystra.metier.interfaces.ServiceILocal;
import loginbean.Connexion;

@ManagedBean(name="achatsMB")
@ViewScoped

public class AchatsMB {
	@EJB
	private ServiceILocal metier;
	
	private  Connexion connect=new Connexion();	
	private String achatId;
	private int achatQtTotal;
	private double achatPrixTotal;
	private Date achatDate;
	private String achatEtat;
	private String idfournisseur;
    private String idProd,nomprod;
    private String idparcelle;
    private String idregion;
    List<ParcelleEntity> listparbypro;
  private List<AchatsEntity>listachats;
public List<AchatsEntity> getListachats() {
	return listachats;
}
public void setListachats(List<AchatsEntity> listachats) {
	this.listachats = listachats;
}
private List<AchatsEntity>listachbyfourn;
private List<AchatsEntity>listachbyEtat;
private boolean disable=true;
private boolean hideTab=false;
private boolean hideButton=true;
public boolean isDisable() {
	return disable;
}
public void setDisable(boolean disable) {
	this.disable = disable;
}
private Map<String,AchatsEntity> achats=new HashMap<String, AchatsEntity>();

private List<RegionEntity>allRegions;

    public List<RegionEntity> getAllRegions() {
	return allRegions;
}
public void setAllRegions(List<RegionEntity> allRegions) {
	this.allRegions = allRegions;
}
	public List<AchatsEntity> getListachbyEtat() {
	return listachbyEtat;
}
public void setListachbyEtat(List<AchatsEntity> listachbyEtat) {
	this.listachbyEtat = listachbyEtat;
}
	public List<AchatsEntity> getListachbyfourn() {
	return listachbyfourn;
}
public void setListachbyfourn(List<AchatsEntity> listachbyfourn) {
	this.listachbyfourn = listachbyfourn;
}
	private String titlepanel="Verification Fournisseur";
	public Map<String, AchatsEntity> getAchats() {
		return achats;
	}
	public void setAchats(Map<String, AchatsEntity> achats) {
		this.achats = achats;
	}


	public boolean isHideButton() {
		return hideButton;
	}
	public void setHideButton(boolean hideButton) {
		this.hideButton = hideButton;
	}

	public boolean isHideTab() {
		return hideTab;
	}
	public void setHideTab(boolean hideTab) {
		this.hideTab = hideTab;
	}
	public ServiceILocal getMetier() {
		return metier;
	}
	public void setMetier(ServiceILocal metier) {
		this.metier = metier;
	}
	public Connexion getConnect() {
		return connect;
	}
	public void setConnect(Connexion connect) {
		this.connect = connect;
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
    
	public List<ParcelleEntity> getListparbypro() {
		return listparbypro;
	}
	public void setListparbypro(List<ParcelleEntity> listparbypro) {
		this.listparbypro = listparbypro;
	}
		//All of Method
		 public List<RegionEntity> getallregion() {	
			if(allRegions==null){
				
				allRegions=metier.GetAllRegion();
			}else{}
			
			 return metier.GetAllRegion();
		
		 }
		 
		
			
		
		public String getTitlepanel() {
				return titlepanel;
			}
			public void setTitlepanel(String titlepanel) {
				this.titlepanel = titlepanel;
			}
	
		//Rechercher producteur et son parcelle
		public String rechercherprods()
		{
			ProducteurEntity pro = metier.FindOneProducteur(idProd);
			
			if(idProd==null)
			{
				FacesMessage msg =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Entrer le code du producteur" ,"");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				hideButton=true;
				hideTab=false;
			}
			else if(pro==null)
			{
				FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Producteur inconnu","");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				hideButton=true;
				hideTab=false;
			}
			else if(pro.getProducteurEtat().equals("Passif")){
				FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ce Producteur n'est plus actif dans le syteme","");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				hideButton=true;
				hideTab=false;
			}
			else
			{
				idProd=pro.getProducteurId();
				hideButton=false;
				hideTab=true;
				listparbypro=metier.GetAllParcellebyprod(idProd);
				setNomprod(pro.getProducteurNomComplet()); 	
				Random rd=new Random();	
				achatId=String.format("ACH-%s",rd.nextInt(99999));
			
			}
			return "";
		}

		public void verification() {
		FacesContext fc=  FacesContext.getCurrentInstance();
		if(achatQtTotal<=0)	
		{
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Quantite invalide","");
			fc.addMessage(null, msg);
		}
		else if(achatPrixTotal<=0)	
		{
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Prix invalide","");
			fc.addMessage(null, msg);
		}
		else if(achatDate==null)	
		{
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Date invalide","");
			fc.addMessage(null, msg);
		}
		else
		{
			Enregistrerachat(); // M'jus rele fonction enregistrer a la nan controleur a
		}
			
		}
	public String Enregistrerachat() {
		
		FacesContext fc=  FacesContext.getCurrentInstance();
		if(idfournisseur==null)	
		{
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Saisissez le code du fournisseur","");
			fc.addMessage(null, msg);
		}
		if(achatQtTotal<=0)	
		{
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Quanite invalide","");
			fc.addMessage(null, msg);
		}
		else if(achatPrixTotal<=0)	
		{
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Prix invalide","");
			fc.addMessage(null, msg);
		}
		else if(achatDate==null)	
		{
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Date invalide","");
			fc.addMessage(null, msg);
		}
		else if(metier.FindOneFournisseur(idfournisseur)==null)
		{
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Fournisseur inconnu","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}	
		else if(metier.FindOneFournisseur(idfournisseur).getFournisseurEtat().equals("Passif")){
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ce Fournisseur n'est plus actif dans le systeme","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
			
		
		}else {
		try{
			AchatsEntity achs = new AchatsEntity(achatId, achatQtTotal, achatPrixTotal, achatDate, "non livré", new FournisseurEntity(idfournisseur), new RegionEntity(idregion), new ProducteurEntity(idProd), new ParcelleEntity(idparcelle));
			metier.Addachats(achs);
			metier.addTrace(new TraceEntity(emailUser(), new Date(), "Nouvel Achat-"+achatId));
			
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_INFO,"Achat enregistre avec succes","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
					Clear();		
					hideButton=true;
					hideTab=false;
					idProd="";
					achatId="";
					nomprod=null;
				}catch(Exception e){
					FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec d'enregistrement de l'achat","");
					FacesContext.getCurrentInstance().addMessage(null, msg);
					
					
				}
	}
		return "";
		}


	
	
	public List<AchatsEntity> getallachats()
	 {
		listachats=metier.GetAllachats();
		return listachats;
	 }
	
	public List<AchatsEntity> getachatById()
	 {
		return metier.GetAllachats(getparam());
	 }
		
	
	public String getparam()
	 {
	FacesContext fc= FacesContext.getCurrentInstance();
	Map<String, String> param= fc.getExternalContext().getRequestParameterMap();
	String codeAchat= param.get("codeAchat");
		return codeAchat; 
	 }
	
	public String getProd()
	 {
	FacesContext fc= FacesContext.getCurrentInstance();
	Map<String, String> param= fc.getExternalContext().getRequestParameterMap();
	String codeProd= param.get("codeProd");
		return codeProd; 
	 }
	
	public String editAchat(){
		AchatsEntity ach=metier.FindOneachats(getparam());
		achatQtTotal=ach.getAchatQtTotal();
		achatId=ach.getAchatId();
		achatPrixTotal=ach.getAchatPrix();
		achatDate=ach.getAchatDate();
		achatEtat=ach.getAchatEtat();
		idfournisseur=ach.getFournisseur().getFournisseurId();			
		idregion=ach.getRegion().getRegionId();
		idProd=ach.getProducteur().getProducteurId();
		nomprod=ach.getProducteur().getProducteurNomComplet();
		achatId=ach.getAchatId();
		return"success";
	}
	
	public List<ParcelleEntity> listParcelleProd(){
		
	return	listparbypro=metier.GetAllParcelle();
	}
		
			
	
		public String retour(){
			Clear();
            hideButton=true;
			hideTab=false;
			achatId="";
			idProd="";
			return"";
		}
		
		public String updateAchat() {
			FacesContext fc=  FacesContext.getCurrentInstance();
			if(achatQtTotal<=0)	
			{
				FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Quantite invalide","");
				fc.addMessage(null, msg);
			}
			else if(achatPrixTotal<=0)	
			{
				FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Prix invalide","");
				fc.addMessage(null, msg);
			}
			else if(achatDate==null)	
			{
				FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Date invalide","");
				fc.addMessage(null, msg);
			}
				
			else {
			try{
				AchatsEntity achs = new AchatsEntity(achatId, achatQtTotal, achatPrixTotal, achatDate, achatEtat, new FournisseurEntity(idfournisseur), new RegionEntity(idregion), new ProducteurEntity(idProd), new ParcelleEntity(idparcelle));
				metier.Updateachats(achs);
				metier.addTrace(new TraceEntity(emailUser(), new Date(), "Update Achat-"+achatId));
				
				FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_INFO,"Achat modifie avec succes","");
				FacesContext.getCurrentInstance().addMessage(null, msg);
					    Clear();
						
					}catch(Exception e){
						FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec de modification de l'achat","");
						FacesContext.getCurrentInstance().addMessage(null, msg);
		}}
			return "";
			}
		
		
	//Verification fournisseur
		public String verifierfourn() {
			FournisseurEntity fou = metier.FindOneFournisseur(idfournisseur);
			
			if(idfournisseur==null)
			{
				FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Entrez votre code Fournisseur","");
				FacesContext.getCurrentInstance().addMessage(null, msg);
		
			}
			
			else if(fou==null)
			{
				FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Fournisseur inconnu","");
				FacesContext.getCurrentInstance().addMessage(null, msg);
		
			}	
			else if(fou.getFournisseurEtat().equals("Passif")){
				FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Vous n'etes plus actif dans le systeme","");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			
				
			}
			
			else {
				idfournisseur=fou.getFournisseurId();
			
				titlepanel="Liste d'achat du fournisseur :"+idfournisseur;
				listachbyfourn=metier.GetAllachatsbyfourn(idfournisseur);
			}
			return "";
			}
			

private String emailUser(){
	String nomUtilisateur =
			FacesContext.getCurrentInstance()
			.getExternalContext().getRemoteUser();	
	return nomUtilisateur;
	}



public String redirectTo(){
	
return "newachat.xhtml?faces-redirect=true";	
	
}
public List<AchatsEntity>getAchatByEtat(){
	if(listachbyEtat==null){
		
		listachbyEtat=metier.getAllachatsByEtat("livré");
		
	}else{}
	return listachbyEtat;
}



//Lister les lignes d'achat
public  List<Map.Entry<String, AchatsEntity>> listerAchat(){
	Collection<Map.Entry<String, AchatsEntity>> values = achats.entrySet();
    //Creating an ArrayList of values
	return new ArrayList<Map.Entry<String,AchatsEntity>>(values);
}

//Modifier une ligne d'achat
public String editerligne(){
	AchatsEntity ach=achats.get(getparam());
	achatQtTotal=ach.getAchatQtTotal();
	achatId=ach.getAchatId();
	achatPrixTotal=ach.getAchatPrix();
	achatDate=ach.getAchatDate();
	achatEtat=ach.getAchatEtat();
	idfournisseur=ach.getFournisseur().getFournisseurId();			
	idregion=ach.getRegion().getRegionId();
	idProd=ach.getProducteur().getProducteurId();
	ProducteurEntity pro=metier.FindOneProducteur(ach.getProducteur().getProducteurId());
	achatId=ach.getAchatId();
	idparcelle=ach.getParcelle().getParcelleId();
	setNomprod(pro.getProducteurNomComplet()); 	
	hideButton=false;
	return"success";
}

//Supprimer une ligne d'achat
public  String deleteligne(){
	achats.remove(getparam());
if(achats.size()==0){
	disable=true;
	
}else{disable=false;}
setNomprod(null); 
	return "Deleted";
}

//Ajouter  une ligne d'achat
	public String AjouterAchats () {
		
		if(achatQtTotal==0||achatPrixTotal==0.0||
		achatDate==null||idfournisseur==null||
		idregion==null||idProd==null){
			
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Il faut remplir tous les champs","");
			FacesContext.getCurrentInstance().addMessage(null, msg);	
				
		}else if(achatQtTotal==0){
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"La quantite apres controle est invalide","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
		}else if(achatPrixTotal==0.0){
			
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le prix est invalide","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}else{
			if(achatId==null){
				Random rd=new Random();	
				achatId=String.format("ACH-%s",rd.nextInt(99999));
			}
		 achats.put(achatId,new AchatsEntity(achatId, achatQtTotal, achatPrixTotal,
				achatDate, "non livré", new FournisseurEntity(idfournisseur), 
				new RegionEntity(idregion), new ProducteurEntity(idProd), 
				new ParcelleEntity(idparcelle)));
		    Clear();
		    idProd=null;
			hideButton=true;
		    disable=false;
		}
		
	
		return "";
	}
	public String Clear(){
		System.out.println("Methode Clear Achat appellee (achatsMB)");
		achatQtTotal=0;
		achatPrixTotal=0.00;
		achatPrixTotal=0.0;
		achatDate=null;
		achatEtat="";
		idfournisseur="";			
		idregion="";	  
		idparcelle="";
		nomprod=null;
		/*idProd="";*/
		return"";
	}

public String annuler(){
	Clear();
	achats.clear();

	return"";
}

public String addAchats(){
	try{
		
		System.out.print("Methode Save called");
	/*	metier.AddAchats(achats);
		for(AchatsEntity ach:achats.values()){
			
			metier.addTrace(new TraceEntity(emailUser(), new Date(), "Nouvel Achat-"+ach.getAchatId()));
		}*/
        FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_INFO,"Nouveaux achats enregistrés avec succès","");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		annuler();
		idProd=null;
		hideButton=true;
        disable=true;
			}catch(Exception e){
				FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec d'enregistrement de nouveaux achats","");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
	
	return"";
}



}
