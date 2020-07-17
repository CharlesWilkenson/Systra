package managebean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.projetsystra.metier.entities.*;
import com.projetsystra.metier.interfaces.ServiceILocal;

import loginbean.Connexion;
@ViewScoped
@ManagedBean(name="lotsMB")
public class LotsMB {
	@EJB
	private ServiceILocal metier;
	private String Idfournisseur;

	private String titlepanel="Verification Fournisseur";
	private Boolean renderfourn=true;
	private Boolean renderlot=false;
	private Boolean renderachat=false;
	private Boolean buttonsave=false;
	private Boolean renderetailsachat=false;
	private boolean disablefield=true;
	private boolean disableButton=false;
	private Date Date_transport;
	private Date Date_livraison;
	private String transporteur;
	private String noplaque;
	private String lotEtat;
	private String idregion;
	private String Idlot;
	private String lotNo;
	private int Qttrecu,qtrecu,qttTotrecu;
	private int Qttapc,qttTotapc;
	private int sizemap;
	private String Noachat;
	public String cach;
	private int size=0;
	private List<LotsEntity>listerLotsByEtat;
	
	private List<LotsEntity>listlots;
	public List<LotsEntity> getListlots() {
		return listlots;
	}
	public void setListlots(List<LotsEntity> listlots) {
		this.listlots = listlots;
	}
	public List<LotsEntity> getListerLotsByEtat() {
		return listerLotsByEtat;
	}
	public void setListerLotsByEtat(List<LotsEntity> listerLotsByEtat) {
		this.listerLotsByEtat = listerLotsByEtat;
	}
	private  Connexion connect=new Connexion();

	public boolean isDisableButton() {
		return disableButton;
	}
	public void setDisableButton(boolean disableButton) {
		this.disableButton = disableButton;
	}
	private String nomCompletfourn;

	public String getNomCompletfourn() {
		return nomCompletfourn;
	}
	public void setNomCompletfourn(String nomCompletfourn) {
		this.nomCompletfourn = nomCompletfourn;
	}

	public boolean isDisablefield() {
		return disablefield;
	}
	public void setDisablefield(boolean disablefield) {
		this.disablefield = disablefield;
	}

	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<String>listach=new ArrayList<String>();
	private Map<String, Lots_detailsEntity> lotdetailsmap=new HashMap<String, Lots_detailsEntity>();
	
	private Map<String,AchatsEntity> codeAch=new HashMap<String, AchatsEntity>();


	public Map<String, AchatsEntity> getCodeAch() {
		return codeAch;
	}
	public void setCodeAch(Map<String, AchatsEntity> codeAch) {
		this.codeAch = codeAch;
	}
	Calendar c=Calendar.getInstance();
	private List<AchatsEntity> achlist;
	public Connexion getConnect() {
		return connect;
	}
	public void setConnect(Connexion connect) {
		this.connect = connect;
	}
	public String getIdfournisseur() {
		return Idfournisseur;
	}
	public void setIdfournisseur(String Idfournisseur) {
		this.Idfournisseur = Idfournisseur;
	}
	public Boolean getRenderfourn() {
		return renderfourn;
	}
	public void setRenderfourn(Boolean renderfourn) {
		this.renderfourn = renderfourn;
	}
	public Boolean getRenderlot() {
		return renderlot;
	}
	public void setRenderlot(Boolean renderlot) {
		this.renderlot = renderlot;
	}
	public Boolean getRenderachat() {
		return renderachat;
	}
	public void setRenderachat(Boolean renderachat) {
		this.renderachat = renderachat;
	}
	
	public String getTitlepanel() {
		return titlepanel;
	}
	public void setTitlepanel(String titlepanel) {
		this.titlepanel = titlepanel;
	}
	public Date getDate_transport() {
		return Date_transport;
	}
	public void setDate_transport(Date date_transport) {
		Date_transport = date_transport;
	}
	public Date getDate_livraison() {
		return Date_livraison;
	}
	public void setDate_livraison(Date date_livraison) {
		Date_livraison = date_livraison;
	}
	public String getTransporteur() {
		return transporteur;
	}
	public void setTransporteur(String transporteur) {
		this.transporteur = transporteur;
	}
	public String getNoplaque() {
		return noplaque;
	}
	public void setNoplaque(String noplaque) {
		this.noplaque = noplaque;
	}
	
	public String getLotEtat() {
		return lotEtat;
	}
	public void setLotEtat(String lotEtat) {
		this.lotEtat = lotEtat;
	}

	public String getIdregion() {
		return idregion;
	}
	public void setIdregion(String idregion) {
		this.idregion = idregion;
	}
	public String getIdlot() {
		return Idlot;
	}
	public void setIdlot(String idlot) {
		Idlot = idlot;
	}
	public String getLotNo() {
		return lotNo;
	}
	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}
	public int getQttrecu() {
		return Qttrecu;
	}
	public void setQttrecu(int qttrecu) {
		Qttrecu = qttrecu;
	}
	public int getQttapc() {
		return Qttapc;
	}
	public void setQttapc(int qttapc) {
		Qttapc = qttapc;
	}
	public String getNoachat() {
		return Noachat;
	}
	public void setNoachat(String noachat) {
		Noachat = noachat;
	}
	
	public Boolean getRenderetailsachat() {
		return renderetailsachat;
	}
	public void setRenderetailsachat(Boolean renderetailsachat) {
		this.renderetailsachat = renderetailsachat;
	}
	
	public Map<String, Lots_detailsEntity> getLotdetailsmap() {
		return lotdetailsmap;
	}
	public void setLotdetailsmap(Map<String, Lots_detailsEntity> lotdetailsmap) {
		this.lotdetailsmap = lotdetailsmap;
	}
	public int getQttTotrecu() {
		return qttTotrecu;
	}
	public void setQttTotrecu(int qttTotrecu) {
		this.qttTotrecu = qttTotrecu;
	}
	public int getQttTotapc() {
		return qttTotapc;
	}
	public void setQttTotapc(int qttTotapc) {
		this.qttTotapc = qttTotapc;
	}
	public int getSizemap() {
		return sizemap;
	}
	public void setSizemap(int sizemap) {
		this.sizemap = sizemap;
	}
	
	public Boolean getButtonsave() {
		return buttonsave;
	}
	public void setButtonsave(Boolean buttonsave) {
		this.buttonsave = buttonsave;
	}
	
	
	public List<String> getListach() {
		return listach;
	}
	public void setListach(List<String> listach) {
		this.listach = listach;
	}
	//All Method
	public List<RegionEntity> listreg() {
		return metier.GetAllRegion();
	}
	public String verifierfourn() {
		FournisseurEntity fou = metier.FindOneFournisseur(Idfournisseur);
		if(fou==null)
		{
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Fournisseur inconnu","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			Clearall();
		}	
		else if(fou.getFournisseurEtat().equals("Passif")){
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ce Fournisseur n'est plus actif dans le systeme","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			Clearall();
			
		}
		else if(metier.achatsNonLivreFourn(Idfournisseur).size()==0){
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ce Fournisseur n'a pas effectue d'achat","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			Clearall();
			
		}
		else {
			renderachat=false;
			renderfourn=false;
			renderlot=true;
			titlepanel="Information du lot";
			Idfournisseur=fou.getFournisseurId();
			nomCompletfourn=fou.getFournisseurNom()+""+fou.getFournisseurPrenom();
			
		}
		return "";
		}
	  
	public String verificationlots() {
	FacesContext fc=  FacesContext.getCurrentInstance();
	if(transporteur=="")	
	{
		FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Saisissez le transporteur","");
		fc.addMessage(null, msg);
	}
	else if(Date_livraison==null)	
	{
		FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Date livraison invalide","");
		fc.addMessage(null, msg);
	}
	else if(Date_transport==null)	
	{
		FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Date transport invalide","");
		fc.addMessage(null, msg);
	}
	else
	{
		try{
		int numlot=0;
		c.setTime(Date_livraison);
		int jour=c.get(c.DAY_OF_YEAR);
		int annee=c.get(c.YEAR);
		renderachat=true;
		renderfourn=false;
		renderlot=false;
		titlepanel="Enregistrer les achats";
		Idlot=idregion+"-"+Idfournisseur+"-"+""+jour+"-"+annee;
		List<LotsEntity> listlot=metier.GetAllLots();
		numlot=listlot.size()+1;
		lotNo="L-0"+numlot;
		}catch(Exception e){
		System.out.println(e.getMessage());	
			
		}
	}
	return "";
	}


	public String rechercherAchat() {	
			AchatsEntity ach=metier.FindOneachats(Noachat);
			if(ach==null)
			{
				FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Pas d'achat","");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				renderetailsachat=false;
				Qttrecu=0;
				Qttapc=0;
			}
			else if(ach.getAchatEtat().equals("livré"))
			{
				FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Achat déja livré","");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				renderetailsachat=false;
				Qttrecu=0;
				Qttapc=0;
			}
			else{
				Qttrecu=ach.getAchatQtTotal();
				qtrecu=ach.getAchatQtTotal();
				renderetailsachat=true;
				cach=ach.getAchatId();
			}
			return "";
	}
	

	
	//Ajouter  une ligne d'achat
	public String AjouterAchats () {
		qttTotapc=0;
		qttTotrecu=0;
		String iddetailslot=cach+"-"+Idlot;
		if(Qttapc==0){
			
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"La quantite apres controle est invalide","");
			FacesContext.getCurrentInstance().addMessage(null, msg);	
				
		}
		
		else if(Qttrecu<Qttapc){
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"La quantite apres controle ne peut pas superieure a la quantite recue","");
			FacesContext.getCurrentInstance().addMessage(null, msg);	
			
		}else{
		
			Lots_detailsEntity	lotd=new Lots_detailsEntity(iddetailslot,qtrecu, Qttapc, new LotsEntity(Idlot), new AchatsEntity(cach));
			lotdetailsmap.put(cach, lotd);
			sizemap=lotdetailsmap.size();
			for(Lots_detailsEntity ld:lotdetailsmap.values()){
				qttTotapc+=+ ld.getLotqttapc();
				qttTotrecu+=+ ld.getLotqttrecu();
								
			}
			codeAch.remove(cach);	
			renderetailsachat=false;
			disablefield=false;
			Noachat="";
			Qttapc=0;
			Qttrecu=0;
			
			if(codeAch.size()==0){
				
				disableButton=true;
			}else{
				
				disableButton=false;
			}
			
		}
		return "";
	}
	//Lister les lignes d'achat
	public  List<Map.Entry<String, Lots_detailsEntity>> lister(){
		Collection<Map.Entry<String, Lots_detailsEntity>> values = lotdetailsmap.entrySet();
        //Creating an ArrayList of values
		return new ArrayList<Map.Entry<String, Lots_detailsEntity>>(values);
	}
	
	
	//Lister lescodes achat
	public  List<Map.Entry<String, AchatsEntity>> listerCodeAchat(){

		Collection<Map.Entry<String, AchatsEntity>> values = null ;

		if(Idfournisseur==null){
			
			renderachat=false;
			renderfourn=false;
			renderlot=true;
			titlepanel="Information du lot";
			return null;
		}
		else if(Idfournisseur!=null && size==0){

				achlist=metier.achatsNonLivreFourn(Idfournisseur);
				 for (AchatsEntity ach: achlist) {
					 listach.add(ach.getAchatId());
					 codeAch.put(ach.getAchatId(),new AchatsEntity( ach.getAchatId())); 
					 values = codeAch.entrySet();
	                    }	
	        
				 size=codeAch.size()+1;
					return new ArrayList<Map.Entry<String, AchatsEntity>>(values);
					
			}else{
				
				 values = codeAch.entrySet();
				
				return new ArrayList<Map.Entry<String, AchatsEntity>>(values);
				
			}	
		
	}
	
	//Modifier une ligne d'achat
		public String editerligen(){
			Lots_detailsEntity lotd=lotdetailsmap.get(getParam());
			   cach=lotd.getAchats().getAchatId();
			   Noachat=lotd.getAchats().getAchatId();
			   Qttapc=lotd.getLotqttapc();
			   Qttrecu=lotd.getLotqttrecu();
			   qtrecu=lotd.getLotqttrecu();
			   size=codeAch.size()-1;
			renderetailsachat=true;
			return"success";
		}
		
		//Supprimer une ligne d'achat
		public  String deleteligne(){
			qttTotapc=0;
			qttTotrecu=0;
			qtrecu=0;
			Qttapc=0;
			lotdetailsmap.remove(getParam());
			codeAch.put(getParam(),new AchatsEntity(getParam()));
			
			sizemap=lotdetailsmap.size();
			for(Lots_detailsEntity ld:lotdetailsmap.values()){
				qttTotapc+=+ ld.getLotqttapc();
				qttTotrecu+=+ ld.getLotqttrecu();
			
			}
			if(sizemap==0)
			{
				disablefield=true;
				buttonsave=false;
			}else {
				buttonsave=true;
				disablefield=false;
			}
			
           if(codeAch.size()==0){
				
				disableButton=true;
			}else{
				
				disableButton=false;
			}
		
			return "Deleted";
		}
		//Enregistrer le lot
	public String enregistrerlot(){
	
		try{
			
			metier.AddLots(lotdetailsmap, new LotsEntity(Idlot, lotNo, qttTotrecu, qttTotapc, 
					Date_transport, Date_livraison, transporteur, noplaque, "non exporté", 
					new RegionEntity(idregion), new FournisseurEntity(Idfournisseur)));	
			metier.addTrace(new TraceEntity(emailUser(), new Date(), "Nouveau Lot-"+Idlot));
			
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_INFO,"Lot enregistré avec succès","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			Clearall();	
		
			disablefield=true;
				}
		catch(Exception e){
					FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec d'enregistrement du lot" +e.getMessage(),"");
				   FacesContext.getCurrentInstance().addMessage(null, msg);
			
		}
		return "Lot saved";
	}
	
	
	private String emailUser(){
		String nomUtilisateur =
				FacesContext.getCurrentInstance()
				.getExternalContext().getRemoteUser();	
		return nomUtilisateur;
		}
	//GetParam
			public String getParam(){
				FacesContext fc=FacesContext.getCurrentInstance();
				Map<String, String> map=fc.getExternalContext().getRequestParameterMap();
				String cle=map.get("cle");
				return cle;
			}
			public String getParamlot(){
				FacesContext fc=FacesContext.getCurrentInstance();
				Map<String, String> map=fc.getExternalContext().getRequestParameterMap();
				String cle=map.get("idlot");
				return cle;
			}
			
		
			public List<LotsEntity> getlistallLots() {
				listlots=metier.GetAllLots();
				return listlots;
				
			}
			public List<Lots_detailsEntity> lotdetailsbyid() {
				List<Lots_detailsEntity> lis= metier.GetAllalldetailsbyId(getParamlot());
				for(Lots_detailsEntity l:lis){
					
		             Idlot=l.getLot().getLotid();
					 noplaque=l.getLot().getLotnoplaque();
				 	 Qttrecu=l.getLot().getLotqttTotrecu();
				 	 Qttapc=l.getLot().getLotqttTotapc();
					 Date_transport=l.getLot().getLotdate_transport();
					 Date_livraison=l.getLot().getLotdate_livraison();
					 transporteur=l.getLot().getLottransporteur();
					 idregion=l.getLot().getRegion().getRegionId();
					 Idfournisseur=l.getLot().getFournisseur().getFournisseurId();	
			}
			
				return lis;
			}
			
			public List<Lots_detailsEntity> tracabilite() {
				List<Lots_detailsEntity> lis=null;
				
				if(getParamlot()==null){
					
					
				}else{
				lis= metier.GetAllalldetailsbyId(getParamlot());
				
			for(Lots_detailsEntity l:lis){
					
			             Idlot=l.getLot().getLotid();
						 noplaque=l.getLot().getLotnoplaque();
					 	 Qttrecu=l.getLot().getLotqttTotrecu();
					 	 Qttapc=l.getLot().getLotqttTotapc();
						 Date_transport=l.getLot().getLotdate_transport();
						 Date_livraison=l.getLot().getLotdate_livraison();
						 transporteur=l.getLot().getLottransporteur();
						 idregion=l.getLot().getRegion().getRegionId();
						 Idfournisseur=l.getLot().getFournisseur().getFournisseurId();
						 //nomCompletfourn=l.getLot().getFournisseur().getFournisseurNom()+""+l.getLot().getFournisseur().getFournisseurPrenom();
				}
				}
				return lis;
			}
			
			
			 public String showTrace(){
					
					RequestContext context=RequestContext.getCurrentInstance();
					tracabilite();
					context.execute("PF('trace').show();");
					 
					 return"";
				 }
			
			public String getinfoLot(){
				
				System.out.println("Methode Appellee");
				LotsEntity lot=metier.FindOneLots(getParamlot());
                 Idlot=lot.getLotid();
				 noplaque=lot.getLotnoplaque();
			 	 Qttrecu=lot.getLotqttTotrecu();
			 	 Qttapc=lot.getLotqttTotapc();
				 Date_transport=lot.getLotdate_transport();
				 Date_livraison=lot.getLotdate_livraison();
				 transporteur=lot.getLottransporteur();
				 idregion=lot.getRegion().getRegionId();
				 Idfournisseur=lot.getFournisseur().getFournisseurId();				
				return Idlot;
			}
			
			
			
			
			public void Clearall(){
				 Idlot ="";			 	 
			 	 Qttrecu=0;
			 	 qtrecu=0;
			 	 Qttapc=0;
		         Idfournisseur="";
				 lotEtat="";
				 idregion="";
				 Noachat="";
				 
				 Date_transport=null;
					Date_livraison=null;
					transporteur=null;
					noplaque=null;
				 
				 renderfourn=true;
				 renderlot=false;
				 renderachat=false;
				 renderetailsachat=false;

				 lotdetailsmap.clear();
				 codeAch.clear();
				 cach="";
				size=0;
				qttTotapc=0;
				qttTotrecu=0;
			}
			
			public String renderfourn(){
				ClearInfotLot();
				renderfourn=true;
				return"";
			}
			
			
	public void ClearInfotLot() {
		 buttonsave=false;
		 Date_transport=null;
		 Date_livraison=null;
		 transporteur="";
		 noplaque="";
		 Idfournisseur="";
	}
	
	
	
	public void ClearInfoAchat() {
		// buttonsave=false;
	 	 Qttrecu=0;
	 	 qtrecu=0;
	 	 Qttapc=0;
	 	 qttTotapc=0;
		 qttTotrecu=0;	
		 lotEtat="";		
		 Noachat="";
		 lotdetailsmap.clear();
		 codeAch.clear();
		 cach="";
		 size=0;
		 disablefield=true;
		 disableButton=false;
	}
	public void backToInfoAchat(){
		 Idlot ="";			 	 
		 lotEtat="";
		 idregion="";		
		 renderfourn=false;
		 renderlot=true;
		 renderachat=false;
		 renderetailsachat=false;
		 lotdetailsmap.clear();
		 codeAch.clear();
		 		 
		 ClearInfoAchat();
	}
	
	public void backToInfoLot(){
		 Idlot ="";
	 	 noplaque="";
	 	 Qttrecu=0;
	 	 qtrecu=0;
	 	 Qttapc=0;
		 lotEtat="";
		 idregion="";
		 Noachat="";
		 Date_transport=null;
			Date_livraison=null;
			transporteur=null;
			noplaque=null;
		 renderfourn=true;
		 renderlot=false;
		 renderachat=false;
		 renderetailsachat=false;
		 lotdetailsmap.clear();
		 codeAch.clear();
		 cach="";
		size=0;
		qttTotapc=0;
		qttTotrecu=0;		
		ClearInfotLot();
	}
	
	public String redirectTo(){
		
		return "lots.xhtml?faces-redirect=true";	
			
		}
	
	
	
	public List<LotsEntity> getLotsByEtat(){
	if(listerLotsByEtat==null){
		
		listerLotsByEtat=metier.getAllLotByEtat("exporté");
	}	else{
		
		
	}
	return listerLotsByEtat;	
	}
}
