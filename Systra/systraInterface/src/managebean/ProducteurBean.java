/**
 * 
 */
package managebean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.component.dialog.Dialog;
import org.primefaces.context.RequestContext;

import com.projetsystra.metier.entities.*;
import com.projetsystra.metier.interfaces.*;

import loginbean.Connexion;

@ManagedBean(name="producteurMB")
@ViewScoped
public class ProducteurBean{
	@EJB

	private ServiceILocal metier;
	public boolean isVerification() {
		return verification;
	}

	public void setVerification(boolean verification) {
		this.verification = verification;
	}

	public boolean isShowprod() {
		return showprod;
	}

	public void setShowprod(boolean showprod) {
		this.showprod = showprod;
	}
	private	boolean verification=true;
	private	boolean showprod;
	
	private  Connexion connect=new Connexion();
	private ProducteurEntity selectedProd;
	private String nomprod;
	private String sexe;
	private String tel;
	private String etat;
	private String prodprenom;
	private String idprod;
	private String prodNomComplet;
	private String prodSexe;
	private String prodTelephone;
	private String prodEtat;
	private boolean showbutton=true;
	private String parcId;
	private String prodId;
	private String parcnomprod;	
	private List<String> codeProd;
	List<ProducteurEntity> listprod;
	 public List<ProducteurEntity> getListprod() {
		return listprod;
	}

	public void setListprod(List<ProducteurEntity> listprod) {
		this.listprod = listprod;
	}

	public List<String> getCodeProd() {
		return codeProd;
	}

	public void setCodeProd(List<String> codeProd) {
		this.codeProd = codeProd;
	}
	private String prodnom;
	 private String prodnomcomplet;

	 public List<Commune>listCommunes;
	 public List<Section_communal>listSections;
	 private String idparcelle;	
	private List<ParcelleEntity>listParcelleByProd;

	
	public String getParcId() {
		return parcId;
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



	public String getProdnom() {
		return prodnom;
	}

	public void setProdnom(String prodnom) {
		this.prodnom = prodnom;
	}

	public String getProdnomcomplet() {
		return prodnomcomplet;
	}

	public void setProdnomcomplet(String prodnomcomplet) {
		this.prodnomcomplet = prodnomcomplet;
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

	public String getIdparcelle() {
		return idparcelle;
	}

	public void setIdparcelle(String idparcelle) {
		this.idparcelle = idparcelle;
	}

			public List<ParcelleEntity> getListParcelleByProd() {
			return listParcelleByProd;
		}

		public void setListParcelleByProd(List<ParcelleEntity> listParcelleByProd) {
			this.listParcelleByProd = listParcelleByProd;
		}
		
	
			
	public String getProdprenom() {
		return prodprenom;
	}

	public void setProdprenom(String prodprenom) {
		this.prodprenom = prodprenom;
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

	 

	

		public String getNomprod() {
			return nomprod;
		}

		public void setNomprod(String nomprod) {
			this.nomprod = nomprod;
		}

		public String getEtat() {
			return etat;
		}

		public void setEtat(String etat) {
			this.etat = etat;
		}

		public String getIdprod() {
			return idprod;
		}

		public void setIdprod(String idprod) {
			this.idprod = idprod;
		}


		public List<ParcelleEntity> getListparcelle() {
			return listparcelle;
		}

		public void setListparcelle(List<ParcelleEntity> listparcelle) {
			this.listparcelle = listparcelle;
		}
	List<ParcelleEntity>listparcelle=new ArrayList<ParcelleEntity>();


	public String getProdNomComplet() {
		return prodNomComplet;
	}

	public void setProdNomComplet(String prodNomComplet) {
		this.prodNomComplet = prodNomComplet;
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

	public String getProdEtat() {
		return prodEtat;
	}

	public void setProdEtat(String prodEtat) {
		this.prodEtat = prodEtat;
	}
	public ProducteurEntity getSelectedProd() {
        return selectedProd;
    }
 
    public void setSelectedProd(ProducteurEntity selectedProd) {
        this.selectedProd = selectedProd;
    }
    
    
    public Connexion getConnect() {
		return connect;
	}

	public void setConnect(Connexion connect) {
		this.connect = connect;
	}


	public List<ParcelleEntity> listparcbypro() {
		if(getcodeProd()==null){
			return null;
		}
		else if(idprod!=null){
			return metier.GetAllParcellebyprod(idprod);	
			
		}
		else
		
		 return metier.GetAllParcellebyprod(getcodeProd());
	}
	
	
	public List<ParcelleEntity> listparcbyprod() {
		if(idprod==null){
			return null;
		}else
		
		 return metier.GetAllParcellebyprod(idprod);
	}
	
	public List<ParcelleEntity> listparcbyprod2() {
		if(connect.getCodeProd()==null){
			return null;
		}else
		
		 return metier.GetAllParcellebyprod(connect.getCodeProd());
	}
	

	public String Modifierprod()
	 {		
		 if(idprod==null|| prodNomComplet==null|| prodSexe==null|| prodTelephone==null)
		{
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Il faut remplir tous les champs",""));         
		}
		 else{
		try{
		
		 metier.UpdateProducteur(new ProducteurEntity(idprod, prodNomComplet, prodSexe, prodTelephone,etat));
		 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Producteur modifie avec succes",""));
		 metier.addTrace(new TraceEntity(emailUser(), new Date(), "Update Producteur-"+idprod));
			
		}catch(Exception e){				
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec de modification du producteur",""));
			}
		 }	
		return "success";
                 }
	
	
	
	
	
	private String emailUser(){
		String nomUtilisateur =
				FacesContext.getCurrentInstance()
				.getExternalContext().getRemoteUser();	
		return nomUtilisateur;
		}
	

	
	//mobile tracker free
	public String reactiver()
	{
		try{
		metier.activerDesactiver(new ProducteurEntity(idprod));
	   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Producteur reactive avec succes",""));
	   ProducteurEntity p=metier.FindOneProducteur(idprod)	;
	   etat=p.getProducteurEtat();	 
	   metier.addTrace(new TraceEntity(emailUser(), new Date(), "Reactive Producteur -"+idprod));
		
		}catch(Exception e){
			 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec de reactivation du producteur",""));
					
		}
		
		 return "";	
	}
	
	
	public String desactiver()
	{
		try{
			metier.activerDesactiver(new ProducteurEntity(idprod));
		   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Producteur desactive avec succes",""));
			ProducteurEntity p=metier.FindOneProducteur(idprod)	;
			etat=p.getProducteurEtat();
			 metier.addTrace(new TraceEntity(emailUser(), new Date(), "desactiver Producteur -"+idprod));
				
		  }catch(Exception e){
				 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec de desactivation du producteur",""));
						
			}
			 return "";	
	}
	
	
	
	public String reactiverprod()
	{
		try{
		metier.activerDesactiver(new ProducteurEntity(connect.getCodeProd()));
	   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Producteur reactive avec succes",""));
	   ProducteurEntity p=metier.FindOneProducteur(connect.getCodeProd())	;
	  connect.setProdEtat(p.getProducteurEtat());
	  metier.addTrace(new TraceEntity(emailUser(), new Date(), "Reactive Producteur -"+idprod));
		
	  }catch(Exception e){
			 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec de reactivation du producteur",""));
					
		}
		
		 return "";	
	}


	public String desactiverprod()
	{
		try{
			metier.activerDesactiver(new ProducteurEntity(connect.getCodeProd()));
		   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Producteur desactive avec succes",""));
		   ProducteurEntity p=metier.FindOneProducteur(connect.getCodeProd())	;
			  connect.setProdEtat(p.getProducteurEtat());
			  metier.addTrace(new TraceEntity(emailUser(), new Date(), "desactiver Producteur -"+idprod));
				
		  }catch(Exception e){
				 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec de desactivation du producteur",""));
						
			}
			 return "";	
	}
				
	

	public List<ProducteurEntity>listerAll()
	 {
		if(listprod==null){
			listprod=metier.getProducteurByetat("Actif");
			
		}else{
						
		}		
		return listprod;
	 }

	
	 public List<ProducteurEntity> getAllProducteurPassif()
	 {
			if(listprod==null){
				listprod=metier.getProducteurByetat("Passif");
				
			}else{
								
			}			
			return listprod;
	 }
	
	 
	 
	 
	 public List<ParcelleEntity> listParcelleByP(){
		 listParcelleByProd=metier.GetAllParcellebyprod(getcodeProd());
		 return listParcelleByProd;
	 }
	 
	 
	 
	 public void clearField()
	 {	
      idprod="";
      vider();
 }
	
	 
	 public String showModalEditProd(){
		 RequestContext context=RequestContext.getCurrentInstance();
		 context.execute("PF('modaleditprod').show();");
		 return"";
	 }
	
	 public String showModalParcelleByPro(){
			 ProducteurEntity prod=metier.FindOneProducteur(getcodeProd());
			 prodNomComplet= prod.getProducteurNomComplet();		 
		
		 return"";
	 } 
	 
	 
/*	 public List<ProducteurEntity> onlistProd(){
		
		 if(idprod==null){
			 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Entrer le code du producteur",""));			
			 return null;
		 }else if(metier.FindOneProducteur(idprod)==null){
			 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Code producteur invalide",""));			
			 return null;
		 }else{
			 return metier.oneProducteur(idprod);
		 }
		 
	 }
	 
	 
	 public List<ProducteurEntity> onlistProd2(){
			 return metier.oneProducteur(connect.getCodeProd());
	                           	 }
	 
	 
	 public List<ProducteurEntity> onlistProdeGetParam(){
	
			 return metier.oneProducteur(getcodeProd());
                                   }
	 
*/	 
	 public String getcodeProd()
	 {
	FacesContext fc= FacesContext.getCurrentInstance();
	Map<String, String> param= fc.getExternalContext().getRequestParameterMap();
	String codeProd = param.get("idproducteur");
	idprod=codeProd;
		return codeProd; 
	 }
	
	 
	 
	 
	public String Editprod()
	 {
		System.out.println("Methode EditProd appellee");
		ProducteurEntity prod=metier.FindOneProducteur(idprod);
		if(prod==null){
			 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Code producteur invalide",""));			
		
			
		}
		else{
		 idprod = prod.getProducteurId();
		 prodNomComplet= prod.getProducteurNomComplet();
		 prodSexe = prod.getProducteurSexe();
		 prodTelephone = prod.getProducteurTelephone();
		 etat=prod.getProducteurEtat();
		 showprod=true;
		 verification=false;
		}
         return "";
		 
	 }
	 
	
		
		public String editer()
		 {
			
			ProducteurEntity prod=metier.FindOneProducteur(getcodeProd());	
			connect.setCodeProd(prod.getProducteurId());
			connect.setProdNom(prod.getProducteurNomComplet());	
			connect.setProdSexe(prod.getProducteurSexe());
			connect.setProdTel(prod.getProducteurTelephone());
			connect.setProdEtat(prod.getProducteurEtat());
	        return "searchproducteur.xhtml?faces-redirect=true"; 
		 }
		
		
		
	   public void vider() {
	    	
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
	    	  parcId=null;
	    	  prodnomcomplet="";
	    	  idparcelle="";
	    	  idprod="";
			  parcnomprod = "";
		}

/*	 public String refresh(){
		 onlistProd();
		 return"";
	 }*/
	 
	 
	 public List<String>autoComplProd(){
		List<ProducteurEntity>lst=metier.autoComplProducteur(prodNomComplet); 
		 for(ProducteurEntity l:lst){
		codeProd.add(l.getProducteurId());
		System.out.println("Code:"+codeProd);	 
			 
		 }
		 return codeProd;
	 }
	 
	 public String Modifier()
	 {
		
		 if(connect.getCodeProd()==null|| connect.getProdNom()==null|| connect.getProdSexe()==null|| connect.getProdTel()==null)
		{
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Il faut remplir tous les champs",""));
		         
		}
		 else{
		try{
					
		 metier.UpdateProducteur(new ProducteurEntity(connect.getCodeProd(), connect.getProdNom(), connect.getProdSexe(), connect.getProdTel(),connect.getProdEtat()));
		 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Producteur modifie avec succes",""));
		 metier.addTrace(new TraceEntity(emailUser(), new Date(), "Update Producteur-"+idprod));
			
		}catch(Exception e){
				
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec de modification du producteur",""));
			}
		 }	
		return "";
	
	 }
	 
	 
	 public String addparcelle(){
			ProducteurEntity prod=metier.FindOneProducteur(connect.getCodeProd());
			if(prod==null){
				
			}else{
			connect.setCodeProd(prod.getProducteurId());
			connect.setProdNom(prod.getProducteurNomComplet());
			connect.setProdSexe(prod.getProducteurSexe());
			connect.setProdEtat(prod.getProducteurEtat());
			connect.setProdTel(prod.getProducteurTelephone());
			}
		 
		 return"addparcelle.xhtml?faces-redirect=true";
	 }
	 
	 public String addparc(){
			ProducteurEntity prod=metier.FindOneProducteur(idprod);
			if(prod==null){
				
			}else{
			connect.setCodeProd(prod.getProducteurId());
			connect.setProdNom(prod.getProducteurNomComplet());
			connect.setProdSexe(prod.getProducteurSexe());
			connect.setProdEtat(prod.getProducteurEtat());
			connect.setProdTel(prod.getProducteurTelephone());
			}
		 
		 return"addparcelle.xhtml?faces-redirect=true";
	 }
	 
	 
	 public String addparc2(){
			ProducteurEntity prod=metier.FindOneProducteur(getcodeProd());
			if(prod==null){
				
			}else{
			connect.setCodeProd(prod.getProducteurId());
			connect.setProdNom(prod.getProducteurNomComplet());
			connect.setProdSexe(prod.getProducteurSexe());
			connect.setProdEtat(prod.getProducteurEtat());
			connect.setProdTel(prod.getProducteurTelephone());
			}
		 
		 return"addparcelle.xhtml?faces-redirect=true";
	 }
	 public String retour(){
		 showprod=false;
		 verification=true;
		 vider();
		return""; 
	 }
}
