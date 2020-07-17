package managebean;


import java.util.ArrayList;
import java.util.Date;
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

import org.primefaces.context.RequestContext;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polygon;

import com.projetsystra.metier.entities.*;
import com.projetsystra.metier.interfaces.ServiceILocal;
import loginbean.Connexion;

@ManagedBean(name="localiserMB")
@ViewScoped
public class localiserMB {

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
	
	 public boolean disablefield=true;
	 //Variable  for map
	 private MapModel emptyModel;
	 private String title;
	 private double lat;
	 private double lng;
	 private String hideTabs="no";
		
	
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
			connect.setCodeParcelleLocaliser(null);
            return"layerparcelle?faces-redirect=true";
			
		}
		
		public String redirectToListParcelle(){
			 connect.setCodePacelle(null);			 
					 return"listparcelle.xhtml?faces-redirect=true";
				 }

 public String redirectToLocaliser(){
	 connect.setCodePacelle(null);
	 connect.setCodeParcelleLocaliser(getparam());			 
			 return"localiser.xhtml?faces-redirect=true";
		 }
		 
		 
	    @PostConstruct
	    public void init() {
	        simpleModel = new DefaultMapModel();
	        polygonModel = new DefaultMapModel();
	        connect.setCodePacelle(null);
	        connect.setCodeAchat(null);
	        connect.setCodeProd(null);
	        connect.setShowCodeParcelle(null);
	        connect.setShowCodeProd(null);
		 	    	 /*parcelleLocation=metier.GetAllParcelle(connect.getCodeParcelleLocaliser());
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
				 	           polygonModel.addOverlay(polygon);
				 	           mapCenter=par.getParcellePointLatitude1()+","+par.getParcellePointLongitude1();
				 	           zoomMap=18;
				 	           collapsedpanel=false;
	                           }*/
		    
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
	    
              return"";
		}
}
