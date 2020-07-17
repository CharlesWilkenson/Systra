package managebean;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polygon;

import com.projetsystra.metier.entities.*;
import com.projetsystra.metier.interfaces.ServiceILocal;
import loginbean.Connexion;

@ManagedBean(name="uniqueParcelleMB")
@ViewScoped
public class UniqueParcelleMB {

	@EJB
	private ServiceILocal metier;	
	private  Connexion connect=new Connexion();
	private boolean collapsedpanel=true;
	private ParcelleEntity Parcelleselect;
	private MapModel simpleModel,parcselectModel;
	private MapModel polygonModel;
	private Marker markerinfo;
	public List<ParcelleEntity> parcelleLocation;
	private List<ParcelleEntity> currentlySelectedParcelle = new ArrayList<ParcelleEntity>();
	private List<ParcelleEntity> ParcPool;
	public String mapCenter;
	public int zoomMap=0;
	private String parcId;
	private String prodId;
	private String parcnomprod;
	private String parcCommune;
	private String parcDepartement;
	private String parcSectioncommunale;
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
	 private String prodnom;
	 private String prodprenom;
	 private String prodSexe;
	 private String prodTelephone;
	 public String idprod,prodnomcomplet,idparcelle;
	 public boolean disablefield=true;
	 //Variable  for map
	 private MapModel emptyModel;
	 private String title;
	 private double lat;
	 private double lng;
	 private String hideTabs="no";
		public String getParcDepartement() {
			return parcDepartement;
		}

		public void setParcDepartement(String parcDepartement) {
			this.parcDepartement = parcDepartement;
		}
	 public List<Commune>listCommunes;
		public List<Section_communal>listSections;

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

		public String  destroy(){
			connect.setCodePacelle("");
            return"layerparcelle?faces-redirect=true";
			
		}
		
		 public String uniqueParcelle(){
			 connect.setCodePacelle(null);
			 connect.setCodePacelle(getparam());
              return"UniqueParcelle?faces-redirect=true";	
			    }
		


	    
	    
	    public String map(){
	    	try{
		        simpleModel = new DefaultMapModel();
		        polygonModel = new DefaultMapModel();
		        System.out.println("Map is called getparam="+getparam());
		        if(getparam()==null){
		        	
		        	
		        }else{
		        	System.out.println("Map is called getparam="+getparam());
		        ParcelleEntity par=metier.FindOneParcelle(getparam());
			 	    	    	 
								  parcnomprod = par.getProducteur().getProducteurNomComplet();
			
					 	    	   LatLng coord1 = new LatLng(par.getParcellePointLatitude1(), par.getParcellePointLongitude1());
					 	    	   LatLng coord2 = new LatLng(par.getParcellePointLatitude2(), par.getParcellePointLongitude2());
					 	    	   LatLng coord3 = new LatLng(par.getParcellePointLatitude3(), par.getParcellePointLongitude3());
					 	    	   LatLng coord4 = new LatLng(par.getParcellePointLatitude4(), par.getParcellePointLongitude4());
					 	    	 				 	    	   
					 	    	   Marker mark = new Marker(coord1,par.getParcelleLocalite());
					 	    	   simpleModel.addOverlay(mark);
					 	           Polygon polygon = new Polygon();
					 	           polygon.getPaths().add(coord1);
					 	           polygon.getPaths().add(coord2);
					 	           polygon.getPaths().add(coord3);
					 	           polygon.getPaths().add(coord4);
					 	           
					 	           polygon.setStrokeColor("#B71C1C");
					 	           polygon.setFillColor("#B71C1C");
					 	           polygon.setStrokeOpacity(0.7);
					 	           polygon.setFillOpacity(0.7);
					 	           polygon.setZindex(20);
					 	           polygonModel.addOverlay(polygon);
					 	           mapCenter=par.getParcellePointLatitude1()+","+par.getParcellePointLongitude1();
					 	           zoomMap=18;
					 	           collapsedpanel=false;
					 	          					 	           
		                          }
		    }catch(Exception e){			 			 
			 }
	    	return"";
	    }
	    
	    
	    public void openLevel3() {
	        Map<String,Object> options = new HashMap<String, Object>();
	        options.put("modal", true);
	        PrimeFaces.current().dialog().openDynamic("level3", options, null);
	        showModal();
	        map();
	    }
	     
	    public void onReturnFromLevel3(SelectEvent event) {
	        //pass back to level 1
	        PrimeFaces.current().dialog().closeDynamic(event.getObject());
	    }
	    
		 public String showModal(){
			
			RequestContext context=RequestContext.getCurrentInstance();
			map();
			context.execute("PF('info').show();");
			 
			 return"";
		 }   
	    
		 public String showTrace(){
				
				RequestContext context=RequestContext.getCurrentInstance();
				//map();
				context.execute("PF('trace').show();");
				 
				 return"";
			 } 
	
		 public String showLots(){
				
				RequestContext context=RequestContext.getCurrentInstance();
				//map();
				context.execute("PF('lots').show();");
				 
				 return"";
			 } 
		 
	 	public Connexion getConnect() {
			return connect;
		}

		public void setConnect(Connexion connect) {
			this.connect = connect;
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
	    
	    
	 
	    public MapModel getParcSelectModel() {
	        return  parcselectModel;
	    }
	   
	    public String vider() {
	    	connect.setParcelleEtat("");
	    	connect.setCodeProd("");
	    	connect.setCodePacelle("");
	    	  parcId = "";
	    	  prodId = "";
	    	  prodnom="";
	    	  prodprenom="";
	    	  prodSexe="";
	    	  prodTelephone="";
	    	  prodnomcomplet="";
	    	  idparcelle="";
	    	  idprod="";
			  parcnomprod = "";
			  parcCommune = "";
			  parcSectioncommunale  = "";
			  parcLocalite  = "";
			  parcMarndr  = "";
			  parcRegimeFoncier  = "";
			  parcTypeCulture = "";
			  parcFertilisationChimique  = "";
			  parcFertilisationOrganique  = "";
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
			  System.out.println("Methode Uniqueparcelle appellee");
              return"";
		}
}
