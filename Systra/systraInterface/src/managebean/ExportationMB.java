package managebean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.projetsystra.metier.entities.*;
import com.projetsystra.metier.interfaces.ServiceILocal;
import loginbean.Connexion;


@ViewScoped
@ManagedBean
public class ExportationMB {
	@EJB
	private ServiceILocal metier;
	private int size=0;
	Random rd=new Random();	
	Connexion c=new Connexion();
	public boolean disablefield=true;
	public boolean disablefieldII=true;	
	public List<ExportationEntity> listerExportation;
	public List<ExportationEntity> getListerExportation() {
		return listerExportation;
	}


	public void setListerExportation(List<ExportationEntity> listerExportation) {
		this.listerExportation = listerExportation;
	}

	private boolean disableBouton=false;
	private String	idLotExporter;
	private List<LotsEntity> lotlist;
	List<String>lotbands=new ArrayList<String>();
	private String codeExpo=codeExportation();;
	private List<LotsEntity>listLotsNonExpote;
	
	//Attribut for Lot
	private String	idExportation;
	private String idExportateur;
	private String idLot;
	private String numLot;
	public String getNumLot() {
		return numLot;
	}


	public void setNumLot(String numLot) {
		this.numLot = numLot;
	}

	private int qtt_aprescontrole;
	private double lotPrix;
	public int sizemap;
	private double prix;
	private Map<String,String>MapcodeExp=new HashMap<String, String>();
	
	//Attribut for Exporation
	private int	qtt_exporter;
	private double	prixtotal_export;
	private Date date_export;
	private String	client;


	private Map<String ,ExportationEntity> mapExpo=new HashMap<String,ExportationEntity>();
	private Map<String,LotsEntity> mapLot=new HashMap<String, LotsEntity>();
	private Map<String, LotExporter> map=new HashMap<String, LotExporter>();
	private String code=MapcodeExp.get(codeExpo);
	public boolean isDisableBouton() {
		return disableBouton;
	}


	public void setDisableBouton(boolean disableBouton) {
		this.disableBouton = disableBouton;
	}


	
	
	
public String getCodeExpo() {
	
		return codeExpo;
	
	
	
	
}

	
public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

private Map<String, LotsEntity> listCodelot=new HashMap<String, LotsEntity>();
	
public Map<String, LotsEntity> getListCodelot() {
	return listCodelot;
}
	
	
	
public void setListCodelot(Map<String, LotsEntity> listCodelot) {
	this.listCodelot = listCodelot;
}
	public Connexion getC() {
		return c;
	}
	public void setC(Connexion c) {
		this.c = c;
	}


	
	public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}

	
	public List<LotsEntity> getListLotsNonExpote() {
		return listLotsNonExpote;
	}
	public void setListLotsNonExpote(List<LotsEntity> listLotsNonExpote) {
		this.listLotsNonExpote = listLotsNonExpote;
	}
	public String getIdLotExporter() {
		return idLotExporter;
	}
	public void setIdLotExporter(String idLotExporter) {
		this.idLotExporter = idLotExporter;
	}


	public double getPrix() {
	return prix;
}
public void setPrix(double prix) {
	this.prix = prix;
}

	public int getQtt_aprescontrole() {
		return qtt_aprescontrole;
	}
	public void setQtt_aprescontrole(int qtt_aprescontrole) {
		this.qtt_aprescontrole = qtt_aprescontrole;
	}
	public double getLotPrix() {
		return lotPrix;
	}
	public void setLotPrix(double lotPrix) {
		this.lotPrix = lotPrix;
	}

	
	
	public String getIdExportation() {
		return idExportation;
	}
	public void setIdExportation(String idExportation) {
		this.idExportation = idExportation;
	}

	
	public int getQtt_exporter() {
		return qtt_exporter;
	}
	public Map<String, LotsEntity> getMapLot() {
		return mapLot;
	}
	public Map<String, ExportationEntity> getMapExpo() {
		return mapExpo;
	}
	public void setMapExpo(Map<String, ExportationEntity> mapExpo) {
		this.mapExpo = mapExpo;
	}
	public void setMapLot(Map<String, LotsEntity> mapLot) {
		this.mapLot = mapLot;
	}
	public void setQtt_exporter(int qtt_exporter) {
		this.qtt_exporter = qtt_exporter;
	}
	public double getPrixtotal_export() {
		return prixtotal_export;
	}
	public void setPrixtotal_export(double prix_export) {
		this.prixtotal_export = prix_export;
	}
	public Date getDate_export() {
		return date_export;
	}
	public void setDate_export(Date date_export) {
		this.date_export = date_export;
	}
	public String getclient() {
		return client;
	}
	public void setclient(String client) {
		this.client = client;
	}
	public String getIdExportateur() {
		return idExportateur;
	}
	public void setIdExportateur(String idExportateur) {
		this.idExportateur = idExportateur;
	}
	public String getIdLot() {
		return idLot;
	}
	public void setIdLot(String idLot) {
		this.idLot = idLot;
	}
	
	public Map<String, LotExporter> getMap() {
		return map;
	}
	public void setMap(Map<String, LotExporter> map) {
		this.map = map;
	}
	
	public boolean isDisablefield() {
		return disablefield;
	}
	public void setDisablefield(boolean disablefield) {
		this.disablefield = disablefield;
	}
	public boolean isDisablefieldII() {
		return disablefieldII;
	}
	public void setDisablefieldII(boolean disablefieldII) {
		this.disablefieldII = disablefieldII;
	}
	//All MEthod
	
	//Rechercher Lot livre
			public String rechercherLot()
			{
				try{
				if(idLot!=null){
					LotsEntity lot=metier.FindOneLots(idLot);	
					numLot=lot.getLotid();
    				setQtt_aprescontrole(lot.getLotqttTotapc());
    				disablefield=false;
				}
				else{
					
					
				}
		/*		
				
             if(lot==null){
            		FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Pas de Lot","");
        			FacesContext.getCurrentInstance().addMessage(null, msg);
                   }
             else{
            		
             }
				*/
				} catch (Exception e) {
	
			}
             return "";
			}
			//Get All code Lot
			 public List<String> getallcodelot() {
				
				lotlist=metier.GetAllLots();
				 for (LotsEntity lot: lotlist) {
					 lotbands.add(lot.getLotid());
				 }
				 return lotbands;
			}
			 
	        //Creation code d'Exportation

		public String codeExportation(){
			Random rd=new Random();	
				String codeexpo=String.format("EXP-%s",rd.nextInt(99999999));
				return codeexpo;
			}
			
	public void setCodeExpo(String codeExpo) {
				this.codeExpo = codeExpo;
			}

	public String editer(){
		LotExporter ex=map.get(getExpo());
        /*LotsEntity l=mapLot.get(getLot());*/
		idLot=ex.getIdLot().getLotid();
		numLot=ex.getIdLot().getLotid();
		prix=ex.getPrixLot_expo();
		qtt_aprescontrole=ex.getQtt_exp();
		idExportation=ex.getIdExportation().getIdExportation();
		codeExpo=ex.getIdExportation().getIdExportation();
		 size=listCodelot.size()-1;
		 
		 disablefield=false;
		return "";
	}

	//Ajouter un lot a exporter		
	public String ajouter(){		
		LotsEntity lo=metier.FindOneLots(idLot);
		if(lo==null){
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Pas de Lot","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		 else if(prix<1){
				FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Entrer le prix","");
				FacesContext.getCurrentInstance().addMessage(null, msg);	
			}
		else{
		
			    LotExporter le=new LotExporter(numLot+""+codeExpo,new LotsEntity(numLot),new ExportationEntity(codeExpo),prix,lo.getLotqttTotapc());
			  System.out.println("Code Expo"+codeExpo);
			    map.put(numLot, le);
			    sizemap=map.size();
			    mapLot.put(le.getId(), lo);
			    prixtotal_export=0.0;
			    qtt_aprescontrole=0;
			    qtt_exporter=0;
			    disablefield=true;
			    for(LotExporter lot:map.values()){
			    	qtt_exporter+=+lot.getQtt_exp();
			    	prixtotal_export+=+lot.getPrixLot_expo();			    	
			   	    }
				listCodelot.remove(idLot);
				idLot="";
				numLot="";
				prix=0.00; 
				disablefieldII=false;	
				if(listCodelot.size()==0){
					disableBouton=true;
					}else{
						
						disableBouton=false;
					}			
		}
	return"";
	}
	
	
	
	public List<Map.Entry<String, LotExporter>> listerExpo(){
		Collection<Map.Entry<String, LotExporter>> values=map.entrySet();
		return new ArrayList<Map.Entry<String,LotExporter>>(values);
	}
	
	public List<Map.Entry<String, LotsEntity>> listerLot(){
		Collection<Map.Entry<String, LotsEntity>> values=mapLot.entrySet();
		return new ArrayList<Map.Entry<String,LotsEntity>>(values);
	}
	

	
	public List<Map.Entry<String, LotsEntity>> listerIdLots(){
		
		List<LotsEntity> listlots=metier.GetAllLots();
		if(listlots.size()==0){
			 size=0;
			
		}
		Collection<Map.Entry<String, LotsEntity>> values=null;
		if(listlots.size()==0){
			disableBouton=true;
		return null;	
		}else{
			

	        if(size==0){
			
				 for (LotsEntity list: listlots) {
					 listCodelot.put(list.getLotid(),new LotsEntity(list.getLotid())); 
					 values = listCodelot.entrySet();
	                    }	
	        
				 size=listCodelot.size()+1;
				return new ArrayList<Map.Entry<String,  LotsEntity>>(values);
					
			}else{
				
				 values = listCodelot.entrySet();
				
				return new ArrayList<Map.Entry<String, LotsEntity>>(values);			
			}
			
		}
		
	}
	
	
	
	
	
	public Map<String, String> getMapcodeExp() {
		return MapcodeExp;
	}
	public void setMapcodeExp(Map<String, String> mapcodeExp) {
		MapcodeExp = mapcodeExp;
	}

	
	public List<LotExporter>listerLotExporterby(){
		return metier.GetAllLotExporterbyCodeExpo(getExpo());
	}
	
	public List<LotExporter>listerAllLotExporter(){
		return metier.GetAllLotExporter();
	}
	
	public List<LotsEntity> listerLots(){
		return metier.GetAllLots();
	}
	
	public String rechercherLotexporter(){
		ExportationEntity ex=metier.FindOneExportation(getExpo());
		idExportation=ex.getIdExportation();
		qtt_aprescontrole=ex.getqtt_exporter();
		prixtotal_export=ex.getPrixtotal_export();
		qtt_exporter=ex.getqtt_exporter();
		date_export =ex.getDate_export();
		client =ex.getClient();
		
		return idExportation;
	}

	
	
	 public String showLots(){
			
			RequestContext context=RequestContext.getCurrentInstance();
			rechercherLotexporter();
			context.execute("PF('lots').show();");
			 
			 return"";
		 }
	
	public String delete(){
		map.remove(getExpo());
		mapLot.remove(getLot());
		listCodelot.put(getExpo(),new LotsEntity(getExpo()));
		listerIdLots();
		sizemap=map.size();
		qtt_exporter=0;
		qtt_aprescontrole=0;
		prixtotal_export=0.00;
		prix=0.00;
		
		 for(LotExporter lo:map.values()){
		    	qtt_exporter+=+lo.getQtt_exp();
		    	prixtotal_export+=+lo.getPrixLot_expo();
		    	
		   	    }
		   idLot="";
		   if(sizemap==0)
			{
				disablefieldII=true;
			}else {
				disablefieldII=false;
			}
		   
		   if(listCodelot.size()==0){
				disableBouton=true;
				}else{
					
					disableBouton=false;
				}
		return"";
	}
	
	public String vider(){
		qtt_aprescontrole=0;
		lotPrix=0.0;
		idExportation="";
		qtt_exporter =0;
		prixtotal_export =0.00;
		date_export =null;
		client ="";
		idExportateur="";
		idLot="";
		map.clear();
		mapLot.clear();
		disablefieldII=true;
		size=0;
		idLot="";
		return "";
	}
	
	public String addExportation(){
		if(date_export==null){
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Entrer la date d'exportation","");
			FacesContext.getCurrentInstance().addMessage(null, msg);			
		}
		else if(client==null){
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Entrer le client","");
			FacesContext.getCurrentInstance().addMessage(null, msg);			
		}
		
		else{
		
		
		try{
		metier.AddExportation(new ExportationEntity(codeExpo, qtt_exporter,
		prixtotal_export, date_export, client), map);
		metier.addTrace(new TraceEntity(emailUser(), new Date(),"Enregistrer exportation -"+codeExpo));
		
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_INFO,"Exportation enregistré avec succès","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			vider();
	
			codeExpo=codeExportation();
			disablefieldII=true;
		}catch(Exception e){
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec d'enregistrement de l'exportation",e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		}
	return"";
	}
	
	private String emailUser(){
		String nomUtilisateur =
				FacesContext.getCurrentInstance()
				.getExternalContext().getRemoteUser();	
		return nomUtilisateur;
		}

	public List<ExportationEntity> listerExportation(){
		if(listerExportation==null){			
			listerExportation=metier.GetAllExportation();				
		}else{						
		}		
		return listerExportation;
	}
	
	
	
	public String getLot(){
		FacesContext fc=FacesContext.getCurrentInstance();
		Map<String, String> map=fc.getExternalContext().getRequestParameterMap();
		String codeach=map.get("codeLot");
		return codeach;
	}
	
	
	public List<LotsEntity>listLotNE(){
	
		return metier.GetAllLots();
		
	}
	
	public String getExpo(){
		FacesContext fc=FacesContext.getCurrentInstance();
		Map<String, String> map=fc.getExternalContext().getRequestParameterMap();
		String codeach=map.get("codeExpo");		
		return codeach;
	}	

	public String redirectTo(){
		
		return "exportation.xhtml?faces-redirect=true";	
			
		}
	
}
