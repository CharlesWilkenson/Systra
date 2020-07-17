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
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.event.map.StateChangeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.LatLngBounds;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polygon;

import com.projetsystra.metier.entities.*;
import com.projetsystra.metier.interfaces.ServiceILocal;
import loginbean.Connexion;

@ManagedBean(name="parcellesMap")
@RequestScoped
public class ParcellesMap {

	@EJB
	private ServiceILocal metier;
	
	private  Connexion connect=new Connexion();
	private MapModel advancedModel;

	boolean showCodeProd=false;
    public MapModel getAdvancedModel() {
		return advancedModel;
	}

	public void setAdvancedModel(MapModel advancedModel) {
		this.advancedModel = advancedModel;
	}




	boolean showCodeParcelle=false;
	private ParcelleEntity Parcelleselect;
	private MapModel simpleModel,parcselectModel;
	private MapModel polygonModel;
	private Marker markerinfo;
	private List<ParcelleEntity> parcelleLocation;
	private List<ParcelleEntity> currentlySelectedParcelle = new ArrayList<ParcelleEntity>();
	private List<ParcelleEntity> ParcPool;
	private String mapCenter;
	private int zoomMap=0;

	
	private String parcLocalite;
	
	private Double parcPointLatitudeLatrine;
	private Double parcPointLongitudeLatrine;

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
	 public List<Commune>listCommunes;

		
		public List<Commune> getListCommunes() {
			return listCommunes;
		}

		public void setListCommunes(List<Commune> listCommunes) {
			this.listCommunes = listCommunes;
		}
	
	
	public String getHideTabs() {
		return hideTabs;
	}
	public void setHideTabs(String hideTabs) {
		this.hideTabs = hideTabs;
	}
	
	public String getIdparcelle() {
		return idparcelle;
	}
	public void setIdparcelle(String idparcelle) {
		this.idparcelle = idparcelle;
	}

	public String getParcLocalite() {
		return parcLocalite;
	}
	public void setParcLocalite(String parcLocalite) {
		this.parcLocalite = parcLocalite;
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
	 
	
	 @PostConstruct
	    public void init() {
		 
		 try{
	    parcelleLocation=metier.GetAllParcelle();
		    simpleModel = new DefaultMapModel();
	        polygonModel = new DefaultMapModel();
	    
	        for (ParcelleEntity par: parcelleLocation) {
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
		 	 	           polygon.setData(par);
		 	 	           polygonModel.addOverlay(polygon);
		 	 	         
		 	 	 
		 		 	         mapCenter ="18.5391700,-72.3350000";
		 		 	         zoomMap=14;	
		        			
		        	//	}

	 	    	   
	 	    	
		 	          
                  }  
		 }catch(Exception e){
			 			 
		 }
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
	    
	    

	 
		private String genAuto(){
			Random rd=new Random();	
			String code=String.format("%s",rd.nextInt(9999999));
			return code;
		}
		
		
		   public void onStateChange(StateChangeEvent event) {
		        LatLngBounds bounds = event.getBounds();
		        int zoomLevel = event.getZoomLevel();
		          
		        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Zoom Level", String.valueOf(zoomLevel)));
		        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Center", event.getCenter().toString()));
		        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "NorthEast", bounds.getNorthEast().toString()));
		        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "SouthWest", bounds.getSouthWest().toString()));
		    }
		      
		    public void onPointSelect(PointSelectEvent event) {
		        LatLng latlng = event.getLatLng();
		          
		        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Point Selected", "Lat:" + latlng.getLat() + ", Lng:" + latlng.getLng()));
		    }
		      
		    public void addMessage(FacesMessage message) {
		        FacesContext.getCurrentInstance().addMessage(null, message);
		    }
		 
}
