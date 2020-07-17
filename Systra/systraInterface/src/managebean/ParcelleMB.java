package managebean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polygon;

import com.projetsystra.metier.entities.*;
import com.projetsystra.metier.interfaces.*;
import loginbean.Connexion;

@ManagedBean(name="parcelleMB")
@ViewScoped
public class ParcelleMB {

	@EJB
	private ServiceILocal metier;
	
	private  Connexion connect=new Connexion();

	private boolean collapsedpanel=true;
	
	boolean showCodeProd=false;
    boolean showCodeParcelle=false;
   private boolean showAction1=false;
   private boolean showAction2=true;


	public boolean isShowAction1() {
	return showAction1;
}

public void setShowAction1(boolean showAction1) {
	this.showAction1 = showAction1;
}

public boolean isShowAction2() {
	return showAction2;
}

public void setShowAction2(boolean showAction2) {
	this.showAction2 = showAction2;
}

	private ParcelleEntity Parcelleselect;
	private MapModel simpleModel,parcselectModel;
	private MapModel polygonModel;
	private Marker markerinfo;
	private List<ParcelleEntity> parcelleLocation;
	private List<ParcelleEntity> currentlySelectedParcelle = new ArrayList<ParcelleEntity>();
	private List<ParcelleEntity> ParcPool;
	private String mapCenter;
	private int zoomMap=0;
	private String parcId;
	private String prodId;
	private String parcnomprod;
	private String parcCommune;
	
	
	private String parcidCommune;
	public String getParcidCommune() {
		return parcidCommune;
	}

	public void setParcidCommune(String parcidCommune) {
		this.parcidCommune = parcidCommune;
	}

	public String getParcidSectioncommunale() {
		return parcidSectioncommunale;
	}

	public void setParcidSectioncommunale(String parcidSectioncommunale) {
		this.parcidSectioncommunale = parcidSectioncommunale;
	}

	private String parcDepartement;
	private String parcidDepartement;
	public String getParcidDepartement() {
		return parcidDepartement;
	}

	public void setParcidDepartement(String parcidDepartement) {
		this.parcidDepartement = parcidDepartement;
	}

	private String parnomSectioncommunale;
	
	private String parcnomCommune;
	private String parcidSectioncommunale;
	
	private String parcSectioncommunale;
	 private String prodnom;
	 private String prodprenom;
	 public String getParnomSectioncommunale() {
		return parnomSectioncommunale;
	}

	public void setParnomSectioncommunale(String parnomSectioncommunale) {
		this.parnomSectioncommunale = parnomSectioncommunale;
	}

	public String getParcnomCommune() {
		return parcnomCommune;
	}

	public void setParcnomCommune(String parcnomCommune) {
		this.parcnomCommune = parcnomCommune;
	}

	private String prodSexe;
	 private String prodTelephone;
	 private String idprod;
	 private String prodnomcomplet;
	private String nomprod;
	private String sexe;
	private String tel;
	private String etat;
		 private String prodID;
		 private String prodNomComplet;
		 private String prodEtat;
	
	private String parcLocalite;
	private String parcMarndr;
	private String parcRegimeFoncier;
	private String parcTypeCulture;
	private String parcFertilisationChimique;
	private String parcFertilisationOrganique;
	private String parcPresenceElevage;
	private String parcTypeElevage;
	private String parcPresenceLatrine;
	private Double parcPointLatitudeLatrine;
	private Double parcPointLongitudeLatrine;
	private String parcTypeTraitrementPhytosanitaire;
	private String parcProblemeInondation;
	private String parcFrequenceInondation;
	private String parcPlanteHote;
	private int parcAgePlantation;
	private int parcNbreManguier;
	private int parcNbreManguierEnProduction;
	private int parcProductionAnnuelleMangue;
	private String parcParcIrrigue;
	private String parcTypeEau;
	private String parcCommercialisation;
	private double parcPointLatitude1;
	private double parcPointLongitude1;
	private double parcPointLatitude2;
	private double parcPointLongitude2;
	private double parcPointLatitude3;
	private double parcPointLongitude3;
	private double parcPointLatitude4;
	private double parcPointLongitude4;
	private double parcSuperficie;
	private String parcEtat;
	private int nbreparc=5237;
	//Variable pour producteur

	 private String idparcelle;
	 private boolean disablefield=true;
	 //Variable  for map
	 private MapModel emptyModel;
	 private String title;
	 private double lat;
	 private double lng;
	 private String hideTabs="no";
	 private String showdataTables="no";
	

	public String getShowdataTables() {
		return showdataTables;
	}

	public void setShowdataTables(String showdataTables) {
		this.showdataTables = showdataTables;
	}

	public List<Commune>listCommunes;
	 public List<Section_communal>listSections;
		public String getParcDepartement() {
			return parcDepartement;
		}

		public void setParcDepartement(String parcDepartement) {
			this.parcDepartement = parcDepartement;
		}
	
		
		public List<Commune> getListCommunes() {
			return listCommunes;
		}

		public void setListCommunes(List<Commune> listCommunes) {
			this.listCommunes = listCommunes;
		}
	
		public List<Section_communal> getListSections() {
			return listSections;
		}

		public void setListSections(List<Section_communal> listSections) {
			this.listSections = listSections;
		}

	//Getters and Setters
	public String getProdnomcomplet() {
		return prodnomcomplet;
	}
	public void setProdnomcomplet(String prodnomcomplet) {
		this.prodnomcomplet = prodnomcomplet;
	}
	public String getNomprod() {
		return nomprod;
	}

	public void setNomprod(String nomprod) {
		this.nomprod = nomprod;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getProdID() {
		return prodID;
	}

	public void setProdID(String prodID) {
		this.prodID = prodID;
	}

	public String getProdNomComplet() {
		return prodNomComplet;
	}

	public void setProdNomComplet(String prodNomComplet) {
		this.prodNomComplet = prodNomComplet;
	}

	public String getProdEtat() {
		return prodEtat;
	}

	public void setProdEtat(String prodEtat) {
		this.prodEtat = prodEtat;
	}
	
	public String getIdprod() {
		return idprod;
	}
	public String getHideTabs() {
		return hideTabs;
	}
	public void setHideTabs(String hideTabs) {
		this.hideTabs = hideTabs;
	}
	public void setIdprod(String idprod) {
		this.idprod = idprod;
	}
	public String getIdparcelle() {
		return idparcelle;
	}
	public void setIdparcelle(String idparcelle) {
		this.idparcelle = idparcelle;
	}
	public String getParcId() {
		return parcId;
	}
	public String getProdnom() {
		return prodnom;
	}
	public void setProdnom(String prodnom) {
		this.prodnom = prodnom;
	}
	public String getProdprenom() {
		return prodprenom;
	}
	public void setProdprenom(String prodprenom) {
		this.prodprenom = prodprenom;
	}
	public String getProdSexe() {
		return prodSexe;
	}
	public void setProdSexe(String prodSexe) {
		this.prodSexe = prodSexe;
	}
	public String getProdTelephone() {
		return prodTelephone;
	}
	public void setProdTelephone(String prodTelephone) {
		this.prodTelephone = prodTelephone;
	}
	public void setParcId(String parcId) {
		this.parcId = parcId;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getParcnomprod() {
		return parcnomprod;
	}
	
	public void setParcnomprod(String parcnomprod) {
		this.parcnomprod = parcnomprod;
	}
	public String getParcCommune() {
		return parcCommune;
	}
	public void setParcCommune(String parcCommune) {
		this.parcCommune = parcCommune;
	}
	public String getParcSectioncommunale() {
		return parcSectioncommunale;
	}
	public void setParcSectioncommunale(String parcSectioncommunale) {
		this.parcSectioncommunale = parcSectioncommunale;
	}
	public String getParcLocalite() {
		return parcLocalite;
	}
	public void setParcLocalite(String parcLocalite) {
		this.parcLocalite = parcLocalite;
	}
	public String getParcMarndr() {
		return parcMarndr;
	}
	public void setParcMarndr(String parcMarndr) {
		this.parcMarndr = parcMarndr;
	}
	public String getParcRegimeFoncier() {
		return parcRegimeFoncier;
	}
	public void setParcRegimeFoncier(String parcRegimeFoncier) {
		this.parcRegimeFoncier = parcRegimeFoncier;
	}
	public String getParcTypeCulture() {
		return parcTypeCulture;
	}
	public void setParcTypeCulture(String parcTypeCulture) {
		this.parcTypeCulture = parcTypeCulture;
	}
	public String getParcFertilisationChimique() {
		return parcFertilisationChimique;
	}
	public void setParcFertilisationChimique(String parcFertilisationChimique) {
		this.parcFertilisationChimique = parcFertilisationChimique;
	}
	public String getParcFertilisationOrganique() {
		return parcFertilisationOrganique;
	}
	public void setParcFertilisationOrganique(String parcFertilisationOrganique) {
		this.parcFertilisationOrganique = parcFertilisationOrganique;
	}
	public String getParcPresenceElevage() {
		return parcPresenceElevage;
	}
	public void setParcPresenceElevage(String parcPresenceElevage) {
		this.parcPresenceElevage = parcPresenceElevage;
	}
	public String getParcTypeElevage() {
		return parcTypeElevage;
	}
	public void setParcTypeElevage(String parcTypeElevage) {
		this.parcTypeElevage = parcTypeElevage;
	}
	public String getParcPresenceLatrine() {
		return parcPresenceLatrine;
	}
	public void setParcPresenceLatrine(String parcPresenceLatrine) {
		this.parcPresenceLatrine = parcPresenceLatrine;
	}
	public Double getParcPointLatitudeLatrine() {
		return parcPointLatitudeLatrine;
	}
	public void setParcPointLatitudeLatrine(Double parcPointLatitudeLatrine) {
		this.parcPointLatitudeLatrine = parcPointLatitudeLatrine;
	}
	public Double getParcPointLongitudeLatrine() {
		return parcPointLongitudeLatrine;
	}
	public void setParcPointLongitudeLatrine(Double parcPointLongitudeLatrine) {
		this.parcPointLongitudeLatrine = parcPointLongitudeLatrine;
	}
	public String getParcTypeTraitrementPhytosanitaire() {
		return parcTypeTraitrementPhytosanitaire;
	}
	public void setParcTypeTraitrementPhytosanitaire(String parcTypeTraitrementPhytosanitaire) {
		this.parcTypeTraitrementPhytosanitaire = parcTypeTraitrementPhytosanitaire;
	}
	public String getParcProblemeInondation() {
		return parcProblemeInondation;
	}
	public void setParcProblemeInondation(String parcProblemeInondation) {
		this.parcProblemeInondation = parcProblemeInondation;
	}
	public String getParcFrequenceInondation() {
		return parcFrequenceInondation;
	}
	public void setParcFrequenceInondation(String parcFrequenceInondation) {
		this.parcFrequenceInondation = parcFrequenceInondation;
	}
	public String getParcPlanteHote() {
		return parcPlanteHote;
	}
	public void setParcPlanteHote(String parcPlanteHote) {
		this.parcPlanteHote = parcPlanteHote;
	}
	public int getParcAgePlantation() {
		return parcAgePlantation;
	}
	public void setParcAgePlantation(int parcAgePlantation) {
		this.parcAgePlantation = parcAgePlantation;
	}
	public int getParcNbreManguier() {
		return parcNbreManguier;
	}
	public void setParcNbreManguier(int parcNbreManguier) {
		this.parcNbreManguier = parcNbreManguier;
	}
	public int getParcNbreManguierEnProduction() {
		return parcNbreManguierEnProduction;
	}
	public void setParcNbreManguierEnProduction(int parcNbreManguierEnProduction) {
		this.parcNbreManguierEnProduction = parcNbreManguierEnProduction;
	}
	public int getParcProductionAnnuelleMangue() {
		return parcProductionAnnuelleMangue;
	}
	public void setParcProductionAnnuelleMangue(int parcProductionAnnuelleMangue) {
		this.parcProductionAnnuelleMangue = parcProductionAnnuelleMangue;
	}
	public String getParcParcIrrigue() {
		return parcParcIrrigue;
	}
	public void setParcParcIrrigue(String parcParcIrrigue) {
		this.parcParcIrrigue = parcParcIrrigue;
	}
	public String getParcTypeEau() {
		return parcTypeEau;
	}
	public void setParcTypeEau(String parcTypeEau) {
		this.parcTypeEau = parcTypeEau;
	}
	public String getParcCommercialisation() {
		return parcCommercialisation;
	}
	public void setParcCommercialisation(String parcCommercialisation) {
		this.parcCommercialisation = parcCommercialisation;
	}
	public double getParcPointLatitude1() {
		return parcPointLatitude1;
	}
	public void setParcPointLatitude1(double parcPointLatitude1) {
		this.parcPointLatitude1 = parcPointLatitude1;
	}
	public double getParcPointLongitude1() {
		return parcPointLongitude1;
	}
	public void setParcPointLongitude1(double parcPointLongitude1) {
		this.parcPointLongitude1 = parcPointLongitude1;
	}
	public double getParcPointLatitude2() {
		return parcPointLatitude2;
	}
	public void setParcPointLatitude2(double parcPointLatitude2) {
		this.parcPointLatitude2 = parcPointLatitude2;
	}
	public double getParcPointLongitude2() {
		return parcPointLongitude2;
	}
	public void setParcPointLongitude2(double parcPointLongitude2) {
		this.parcPointLongitude2 = parcPointLongitude2;
	}
	public double getParcPointLatitude3() {
		return parcPointLatitude3;
	}
	public void setParcPointLatitude3(double parcPointLatitude3) {
		this.parcPointLatitude3 = parcPointLatitude3;
	}
	public double getParcPointLongitude3() {
		return parcPointLongitude3;
	}
	public void setParcPointLongitude3(double parcPointLongitude3) {
		this.parcPointLongitude3 = parcPointLongitude3;
	}
	public double getParcPointLatitude4() {
		return parcPointLatitude4;
	}
	public void setParcPointLatitude4(double parcPointLatitude4) {
		this.parcPointLatitude4 = parcPointLatitude4;
	}
	public double getParcPointLongitude4() {
		return parcPointLongitude4;
	}
	public void setParcPointLongitude4(double parcPointLongitude4) {
		this.parcPointLongitude4 = parcPointLongitude4;
	}
	public double getParcSuperficie() {
		return parcSuperficie;
	}
	public void setParcSuperficie(double parcSuperficie) {
		this.parcSuperficie = parcSuperficie;
	}
	public String getParcEtat() {
		return parcEtat;
	}
	public void setParcEtat(String parcEtat) {
		this.parcEtat = parcEtat;
	}
	
	public int getZoomMap() {
		return zoomMap;
	}
	public void setZoomMap(int zoomMap) {
		this.zoomMap = zoomMap;
	}
	public String getMapCenter() {
		return mapCenter;
	}
	public void setMapCenter(String mapCenter) {
		this.mapCenter = mapCenter;
	}
	
	
	public Marker getMarkerinfo() {
		return markerinfo;
	}
	public void setMarkerinfo(Marker markerinfo) {
		this.markerinfo = markerinfo;
	}
	
	
	public boolean isCollapsedpanel() {
		return collapsedpanel;
	}
	public void setCollapsedpanel(boolean collapsedpanel) {
		this.collapsedpanel = collapsedpanel;
	}
	
	
	public boolean isDisablefield() {
		return disablefield;
	}
	public void setDisablefield(boolean disablefield) {
		this.disablefield = disablefield;
	}
	
	public MapModel getEmptyModel() {
		return emptyModel;
	}
	public void setEmptyModel(MapModel emptyModel) {
		this.emptyModel = emptyModel;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	/* Liste des methodes */
	public List<ParcelleEntity> getlistparcelles()
	{
	 return	metier.GetAllParcelle();
	}
	
	
	
	
	public ParcelleEntity getSelectedParcelle() {
		return Parcelleselect;
		
	}
	
	

	public Connexion getConnect() {
		return connect;
	}

	public void setConnect(Connexion connect) {
		this.connect = connect;
	}

	
	 public void setParcelleselect(ParcelleEntity parcelleselect) {
		Parcelleselect = parcelleselect;
	}
	 public List<ParcelleEntity> getCurrentlySelectedParcelle() {
	        return currentlySelectedParcelle;
	    }
	 
	 public List<ParcelleEntity> getParcPool() {
	        return ParcPool;
	    }
	 
	 //Get Value for map
	 public void addMarker() {
	        Marker marker = new Marker(new LatLng(lat, lng), title);
	        emptyModel.addOverlay(marker);
	          
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + lat + ", Lng:" + lng));
	    }
	 

	 
	 public List<ParcelleEntity> getSuppressparcelle()
	 {
		return metier.GetAllParcelleSuppress();
	 }
		public void showMap() {
				 RequestContext context = RequestContext.getCurrentInstance();
				 context.execute("PF('dlgmap').show();");
				 vider();
			}
		
		public String searchparcelle()
		 {		hideTabs="yes";
			  ParcelleEntity par=metier.FindOneParcelle(getparam());		
			  idprod=par.getProducteur().getProducteurId();
			  prodId=par.getProducteur().getProducteurId();
              prodSexe=par.getProducteur().getProducteurSexe();
			  prodTelephone=par.getProducteur().getProducteurTelephone();
			  parcnomprod = par.getProducteur().getProducteurNomComplet();
			  
			  System.out.println("Nom"+parcnomprod);
			  parcId=par.getParcelleId();
			  parcEtat=par.getParcelleEtat();
			 
			  parcidCommune= par.getParcelleCommune();
			  parcidSectioncommunale=par.getParcelleSectioncommunale();
			
			  parcCommune = par.getParcelleCommune();
			  parcSectioncommunale=par.getParcelleSectioncommunale();
			  parcLocalite =par.getParcelleLocalite();
			  
			  
			  parcMarndr  = par.getParcelleMarndr();
			  parcRegimeFoncier = par.getParcelleRegimeFoncier();
			  parcTypeCulture = par.getParcelleTypeCulture();
			  parcFertilisationChimique  = par.getParcelleFertilisationChimique();
			  parcFertilisationOrganique  = par.getParcelleFertilisationOrganique();
			  parcPresenceElevage  = par.getParcellePresenceElevage();
			  parcTypeElevage  = par.getParcelleTypeElevage();
			  parcPresenceLatrine  = par.getParcellePresenceLatrine();
			  parcPointLatitudeLatrine  = par.getParcellePointLatitudeLatrine();
			  parcPointLongitudeLatrine  = par.getParcellePointLongitudeLatrine();
			  parcTypeTraitrementPhytosanitaire  = par.getParcelleTypeTraitrementPhytosanitaire();
			  parcPlanteHote  = par.getParcellePlanteHote();
			  parcAgePlantation  = par.getParcelleAgePlantation();
			  parcNbreManguier  = par.getParcelleNbreManguier();
			  parcNbreManguierEnProduction  = par.getParcelleNbreManguierEnProduction();
			  parcProductionAnnuelleMangue  = par.getParcelleProductionAnnuelleMangue();
			  parcParcIrrigue  = par.getParcelleParcIrrigue();
			  parcTypeEau  = par.getParcelleTypeEau();
			  parcCommercialisation  = par.getParcelleCommercialisation();
			  parcPointLatitude1  = par.getParcellePointLatitude1();
			  parcPointLongitude1  = par.getParcellePointLongitude1();
			  parcPointLatitude2 = par.getParcellePointLatitude2();
			  parcPointLongitude2= par.getParcellePointLongitude2();
			  parcPointLatitude3= par.getParcellePointLatitude3();
			  parcPointLongitude3= par.getParcellePointLongitude3();
			  parcPointLatitude4= par.getParcellePointLatitude4();
			  parcPointLongitude4 = par.getParcellePointLongitude4();
			  parcSuperficie = par.getParcelleSuperficie();
			  parcProblemeInondation=par.getParcelleProblemeInondation();
			parcFrequenceInondation=par.getParcelleFrequenceInondation();
			 return "";
			 
		 }


	 	public void onSelectparcelle(OverlaySelectEvent event) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Polygon Selected", null));
	    }
	    public MapModel getSimpleModel() {
	        return simpleModel;
	    }
	    public MapModel getPolygonModel() {
	        return polygonModel;
	    }
	    
	    public String getparam()
		 {
		FacesContext fc= FacesContext.getCurrentInstance();
		Map<String, String> param= fc.getExternalContext().getRequestParameterMap();
		String idparc = param.get("idparcelle");
	
			return idparc; 
		 }
	    
	    
	 
	    
	    public String getprod()
		 {
		FacesContext fc= FacesContext.getCurrentInstance();
		Map<String, String> param= fc.getExternalContext().getRequestParameterMap();
		String idprod = param.get("idprod");
		//connect.setCodeProd(idprod);
			return idprod; 
		 }
	    
	 
	    public List<Departement> getlistdepartement() {
	    	
			return	metier.GetAllDepartement();
			
			}

	    
			public List<Commune> listCommunebydept()
			{
				
			return metier.GetCommunebyDept(parcDepartement);
			}
				
		public List<Section_communal> searchSectionbycom() 
			{	

				return metier.GetSectionbyCom(parcCommune);
			}			
		
		
		
		public List<Commune> listCommunebydept2()
		{
			
		return metier.GetCommunebyDept(parcidDepartement);
		}
			
	public List<Section_communal> searchSectionbycom2() 
		{	

			return metier.GetSectionbyCom(parcidCommune);
		}
		
		
	    public MapModel getParcSelectModel() {
	        return  parcselectModel;
	    }
	   
	    public void viderCode(){
	    	parcId=null;
	    	prodID=null;	
	    	vider();
	    }
	    
	    public void vider() {
	    	hideTabs="no";
	    	
	    	showdataTables="no";
	    	connect.setParcelleEtat(null);
	    	connect.setCodePacelle(null);	
	    	connect.setShowCodeProdModal("no");
	    	connect.setShowCodeParcelleModal("no");
	    	
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
	    	
	    	  prodnom="";
	    	  prodprenom="";
	    	  prodSexe="";
	    	  prodTelephone="";
	    	  prodnomcomplet="";
	    	  idparcelle="";
	    	  idprod="";
			  parcnomprod="";
			  parcCommune= "";
			  nomprod="";
			  prodprenom="";
			  parcDepartement=null;
			  parcSectioncommunale  = "";
			  parcLocalite= "";
			  parcMarndr= "";
			  parcRegimeFoncier  = "";
			  parcTypeCulture = "";
			  parcFertilisationChimique= "";
			  parcFertilisationOrganique= "";
			  parcPresenceElevage  = "";
			  parcTypeElevage  = "";
			  parcPresenceLatrine  = "";
			  parcPointLatitudeLatrine  = 0.0;
			  parcPointLongitudeLatrine  = 0.0;
			  parcTypeTraitrementPhytosanitaire  = "";
			  parcPlanteHote  = "";
			  setParcAgePlantation(0);
			  setParcNbreManguier(0);
			  setParcNbreManguierEnProduction (0);
			  setParcProductionAnnuelleMangue (0);
			  parcParcIrrigue  = "";
			  parcTypeEau  = "";
			  parcCommercialisation  = "";
			  parcPointLatitude1  =0.0;
			  parcPointLongitude1  = 0.0;
			  parcPointLatitude2 = 0.0;
			  parcPointLongitude2= 0.0;
			  parcPointLatitude3= 0.0;
			  parcPointLongitude3= 0.0;
			  parcPointLatitude4= 0.0;
			  parcPointLongitude4 = 0.0;
			  parcSuperficie = 0.0;
			  parcEtat = "";
			  System.out.println("Methode parcelleMB call");

		}
		private String genAuto(){
			Random rd=new Random();	
			String code=String.format("%s",rd.nextInt(9999999));
			return code;
		}
		
		 public String updateParcelle()
		 {
			 if(parcLocalite==null||parcCommune==null||parcSectioncommunale==null){
					
					FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Il faut remplir tous les champs",""));
					return"";
				}
			 
			 
		           else{
				      try{
				    		 Commune c=metier.getCommune(parcCommune) ;
								parcnomCommune=c.getNomCommune();
								
								Section_communal sec=metier.getSection( parcSectioncommunale);
								parnomSectioncommunale=sec.getNomSectionCommunal();
								
				    	  
	                 metier.UpdateParcelle(new ParcelleEntity(parcId, new ProducteurEntity(idprod),
			         parcnomCommune,
			        parnomSectioncommunale ,
					 parcLocalite, parcMarndr, parcRegimeFoncier, parcTypeCulture, parcFertilisationChimique, 
					 parcFertilisationOrganique, parcPresenceElevage, parcTypeElevage, parcPresenceLatrine,
					 parcPointLatitudeLatrine, parcPointLongitudeLatrine, parcTypeTraitrementPhytosanitaire,
					 parcProblemeInondation, parcFrequenceInondation, parcPlanteHote, parcAgePlantation,
					 parcNbreManguier, parcNbreManguierEnProduction, parcProductionAnnuelleMangue, parcParcIrrigue, 
					 parcTypeEau, parcCommercialisation, parcPointLatitude1, parcPointLongitude1, parcPointLatitude2, 
					 parcPointLongitude2, parcPointLatitude3, parcPointLongitude3, parcPointLatitude4, 
					 parcPointLongitude4, parcSuperficie,parcEtat));
	                 metier.addTrace(new TraceEntity(emailUser(), new Date(), "Modifier Parcelle -"+parcId));
	 				
			    FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_INFO,"Parcelle modifiee avec succes","");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			 vider();
			
			 
			 nbreparc=nbreparc+1;
				}catch(Exception e){
					
					FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec de modification de la parcelle","");
					FacesContext.getCurrentInstance().addMessage(null, msg);	
				}
				}
			 return "Parcelle saved";
	 
		 }
		 
		 private String emailUser(){
				String nomUtilisateur =
						FacesContext.getCurrentInstance()
						.getExternalContext().getRemoteUser();	
				return nomUtilisateur;
				} 
		
	public String redirectTo(){	
		return"prodparc.xhtml?faces-redirect=true";
	}	
	public String rechProd(){	
		ProducteurEntity pro=metier.FindOneProducteur(getprod());
		prodnomcomplet=pro.getProducteurNomComplet();
	
    prodId=getprod();
	return "";	
	}
	
	public String rechProductor(){	
		ProducteurEntity pro=metier.FindOneProducteur(connect.getCodeProd());
		prodId=pro.getProducteurId();
		prodnomcomplet=pro.getProducteurNomComplet();
		prodTelephone=pro.getProducteurTelephone();
	    return "parcelleforprod.xhtml?faces-redirect=true";	
	}
	
	public String searchProd()
	{
		ProducteurEntity pro=metier.FindOneProducteur(prodId);
		if(pro==null)
		{
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Producteur inconnu",""));
			
			
		}
		else if(pro.getProducteurEtat().equals("Passif")){
			System.out.print("Producteur inactif"); 
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ce Producteur n'est plus actif dans le syteme",""));
			
		}
		else{
			hideTabs="yes";
			prodnomcomplet=pro.getProducteurNomComplet();
			prodId=pro.getProducteurId();
			prodSexe=pro.getProducteurSexe();
			prodTelephone=pro.getProducteurTelephone();
		}
		
		return"success";
	}
	 
	//ftp=20 pour les donnees et 21 pour les commandes,telnet=23,smtp=,pop3=110
	//500
	
	public String searchProductor()
	{
		    ProducteurEntity pro=metier.FindOneProducteur(prodId);
			hideTabs="yes";
			prodnomcomplet=pro.getProducteurNomComplet();
			prodId=pro.getProducteurId();
			prodTelephone=pro.getProducteurTelephone();
	return"success";
	}	
	
	 
	//Methode permettant d'enregistrer un producteur dans la forme
	public String addprod()
	 {
		
		 if(prodprenom==null|| nomprod==null||
		    prodTelephone==null || parcCommune==null 
		 ||parcLocalite==null || parcSectioncommunale==null)
		{
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Il faut remplir tous les champs",""));
			
		}
		else{
        try{
		 Character n=nomprod.toUpperCase().charAt(0);
		 Character p=prodprenom.toUpperCase().charAt(0);
		 Character co1=parcCommune.toUpperCase().charAt(0);
		 Character co2=parcCommune.toUpperCase().charAt(1);
		 Character l1=parcLocalite.toUpperCase().charAt(0);
		 Character l2=parcLocalite.toUpperCase().charAt(1);
		 prodNomComplet=""+nomprod+" "+prodprenom;
		 idprod="PROD-"+co1+""+co2+""+""+l1+""+""+l2+""+n+""+p+""+genAuto();
		 idparcelle="PARC"+co1+""+co2+""+""+l1+""+""+l2+""+n+""+p+""+genAuto();
		 prodId=idprod;
		 parcId=idparcelle; 

		ProducteurEntity pro=new ProducteurEntity(prodId, prodNomComplet, prodSexe, prodTelephone,"Actif");
		Commune c=metier.getCommune(parcCommune) ;
		parcnomCommune=c.getNomCommune();
		
		Section_communal sec=metier.getSection( parcSectioncommunale);
		parnomSectioncommunale=sec.getNomSectionCommunal();
		
	 ParcelleEntity par=new ParcelleEntity(parcId, pro,parcnomCommune ,
			 parnomSectioncommunale ,
			 parcLocalite, parcMarndr, parcRegimeFoncier, parcTypeCulture, parcFertilisationChimique, 
			 parcFertilisationOrganique, parcPresenceElevage, parcTypeElevage, parcPresenceLatrine,
			 parcPointLatitudeLatrine, parcPointLongitudeLatrine, parcTypeTraitrementPhytosanitaire,
			 parcProblemeInondation, parcFrequenceInondation, parcPlanteHote, parcAgePlantation,
			 parcNbreManguier, parcNbreManguierEnProduction, parcProductionAnnuelleMangue, parcParcIrrigue, 
			 parcTypeEau, parcCommercialisation,
			 parcPointLongitude1,parcPointLongitude2,parcPointLongitude3,parcPointLongitude4,
			 parcPointLatitude1, parcPointLatitude2,parcPointLatitude3,parcPointLatitude4, 
			 parcSuperficie,"Actif");
		 
             metier.AddProducteur(pro, par);
             metier.addTrace(new TraceEntity(emailUser(), new Date(), "Nouveau producteur -"+parcId));
	         
			 showCodeProd=true;
             showCodeParcelle=true;
				
			 FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_INFO,"Producteur enregistre avec succes. Code producteur:",prodId);
     FacesContext.getCurrentInstance().addMessage(null, msg);
     vider();
	 }catch(Exception e){
		 FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec d'enregistrement du nouveau producteur","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
 }
		}		 return "success";
		 
	 }
	
	
	
	 public boolean isShowCodeProd() {
		return showCodeProd;
	}

	public void setShowCodeProd(boolean showCodeProd) {
		this.showCodeProd = showCodeProd;
	}

	public boolean isShowCodeParcelle() {
		return showCodeParcelle;
	}

	public void setShowCodeParcelle(boolean showCodeParcelle) {
		this.showCodeParcelle = showCodeParcelle;
	}

	//add parcelle pour un producteur deja existe
	 public String ajouterparcelle(){
		 ProducteurEntity pro=metier.FindOneProducteur(prodId);
		if(pro.getProducteurNomComplet()==null||prodId==null ||parcLocalite==null||parcCommune==null||parcSectioncommunale==null){
				
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Il faut remplir tous les champs",""));
				
			}
		 else{
	 try{
					 Character n=pro.getProducteurNomComplet().toUpperCase().charAt(0);
					 Character p=pro.getProducteurNomComplet().toUpperCase().charAt(0);
					 Character co1=parcCommune.toUpperCase().charAt(0);
					 Character co2=parcCommune.toUpperCase().charAt(1);
					 Character l1=parcLocalite.toUpperCase().charAt(0);
					 Character l2=parcLocalite.toUpperCase().charAt(1);
					 idparcelle="PARC"+co1+""+co2+""+""+l1+""+""+l2+""+n+""+p+""+genAuto();
					 parcId=idparcelle;
					 
					 Commune c=metier.getCommune(parcCommune) ;
						parcnomCommune=c.getNomCommune();
						
						Section_communal sec=metier.getSection( parcSectioncommunale);
						parnomSectioncommunale=sec.getNomSectionCommunal();
						
						
	             metier.AddParcelle(new ParcelleEntity(parcId, new ProducteurEntity(pro.getProducteurId()),parcnomCommune ,
	            		 parnomSectioncommunale ,
				 parcLocalite, parcMarndr, parcRegimeFoncier, parcTypeCulture, parcFertilisationChimique, 
				 parcFertilisationOrganique, parcPresenceElevage, parcTypeElevage, parcPresenceLatrine,
				 parcPointLatitudeLatrine, parcPointLongitudeLatrine, parcTypeTraitrementPhytosanitaire,
				 parcProblemeInondation, parcFrequenceInondation, parcPlanteHote, parcAgePlantation,
				 parcNbreManguier, parcNbreManguierEnProduction, parcProductionAnnuelleMangue, parcParcIrrigue, 
				 parcTypeEau, parcCommercialisation, parcPointLatitude1, parcPointLongitude1, parcPointLatitude2, 
				 parcPointLongitude2, parcPointLatitude3, parcPointLongitude3, parcPointLatitude4, 
				 parcPointLongitude4, parcSuperficie, "Actif"));
	             metier.addTrace(new TraceEntity(emailUser(), new Date(), "Nouvelle Parcelle -"+parcId));
	 			
		    FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_INFO,"Nouvelle Parcelle ajoutee avec succes. Code parcelle:",parcId);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		 
		 vider();
		hideTabs="no";
		prodId="";
		 nbreparc=nbreparc+1;
			}catch(Exception e){
				
				FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec d'ajout de nouvelle parcelle","");
				FacesContext.getCurrentInstance().addMessage(null, msg);	
			}
		 }
		 return "success";
	 }
	 
	 
	 public String ajouterparcelle2(){
		 ProducteurEntity pro=null;
		 
		 if(parcLocalite==null||parcCommune==null||parcSectioncommunale==null){
				
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Il faut remplir tous les champs",""));
				
			}
		 else
			try{	
				pro=metier.FindOneProducteur(connect.getCodeProd());
				 Character n=pro.getProducteurNomComplet().toUpperCase().charAt(0);
				 Character p=pro.getProducteurNomComplet().toUpperCase().charAt(0);
				 Character co1=parcCommune.toUpperCase().charAt(0);
				 Character co2=parcCommune.toUpperCase().charAt(1);
				 Character l1=parcLocalite.toUpperCase().charAt(0);
				 Character l2=parcLocalite.toUpperCase().charAt(1);
				 idparcelle="PARC"+co1+""+co2+""+""+l1+""+""+l2+""+n+""+p+""+genAuto();
				 parcId=idparcelle;
				
	}catch(Exception e){
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Il faut remplir tous les champs",""));
			
			}
		
				 
				 
				 try{
					 Commune c=metier.getCommune(parcCommune) ;
						parcnomCommune=c.getNomCommune();
						
						Section_communal sec=metier.getSection( parcSectioncommunale);
						parnomSectioncommunale=sec.getNomSectionCommunal();
						 
				 
	             metier.AddParcelle(new ParcelleEntity(parcId, new ProducteurEntity(pro.getProducteurId()),  parcnomCommune ,
	 			       parnomSectioncommunale ,
				 parcLocalite, parcMarndr, parcRegimeFoncier, parcTypeCulture, parcFertilisationChimique, 
				 parcFertilisationOrganique, parcPresenceElevage, parcTypeElevage, parcPresenceLatrine,
				 parcPointLatitudeLatrine, parcPointLongitudeLatrine, parcTypeTraitrementPhytosanitaire,
				 parcProblemeInondation, parcFrequenceInondation, parcPlanteHote, parcAgePlantation,
				 parcNbreManguier, parcNbreManguierEnProduction, parcProductionAnnuelleMangue, parcParcIrrigue, 
				 parcTypeEau, parcCommercialisation, parcPointLatitude1, parcPointLongitude1, parcPointLatitude2, 
				 parcPointLongitude2, parcPointLatitude3, parcPointLongitude3, parcPointLatitude4, 
				 parcPointLongitude4, parcSuperficie, "Actif"));
	             metier.addTrace(new TraceEntity(emailUser(), new Date(), "Nouvelle Parcelle -"+parcId));
	 			
		    FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_INFO,"Nouvelle Parcelle ajoutee avec succes. Code parcelle:",parcId);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		 
		 vider();
		hideTabs="no";
		
		 nbreparc=nbreparc+1;
			}catch(Exception e){
				
				FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec d'ajout de nouvelle parcelle","");
				FacesContext.getCurrentInstance().addMessage(null, msg);	
			}
		
		 
		 return "success";
	 }
	 
		public String Editprod()
		 {
			System.out.println("Methode EditProd appellee");
			ProducteurEntity prod=metier.FindOneProducteur(getcodeProd());
			 prodId = prod.getProducteurId();
			 prodNomComplet= prod.getProducteurNomComplet();
			 prodSexe = prod.getProducteurSexe();
			 prodTelephone = prod.getProducteurTelephone();
	         return "";
			 
		 }
		
		
		public List<ParcelleEntity> listParcelleActif(){
			
			if(ParcPool==null){
				ParcPool= metier.getparcellesByetat("Actif");
				
			}else{
				
				
			}
			
		return ParcPool;
		}
		
public List<ParcelleEntity> listparcellesPassif(){
			
	if(ParcPool==null){
		ParcPool= metier.getparcellesByetat("Passif");
		
	}else{
		
		
	}
	
return ParcPool;
		}
		
		
		
		 public List<ParcelleEntity> onlistProd(){
				
			 if(idprod==null){
				 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Entrer le code du producteur",""));			
				 return null;
			 }else if(metier.FindOneProducteur(idprod)==null){
				 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Code producteur invalide",""));			
				 return null;
			 }else{
				 showdataTables="yes";
				 return metier.GetAllParcellebyprod(idprod);
			 }
			 
		 }
		
		 public String redirectToLocaliser(){
			 
			 
			 return"localiser.xhtml?faces-redirect=true";
		 }
		 
		 
		 public String refresh(){
			 showdataTables="yes";
			 return"";
		 }
		 
		 public String getcodeProd()
		 {
		FacesContext fc= FacesContext.getCurrentInstance();
		Map<String, String> param= fc.getExternalContext().getRequestParameterMap();
		String codeProd = param.get("idproducteur");
			return codeProd; 
		 }
		 
		 public String showModal(){
			 searchparcelle();
			RequestContext context=RequestContext.getCurrentInstance();
			context.execute("PF('info').show();");			 
			 return"";
		 }
		 
		public String showAction(){
			showAction1=true;
			showAction2=false;
			System.out.println("Action1"+showAction1);
			System.out.println("Action2"+showAction2);
			
			return"";
		} 
}
