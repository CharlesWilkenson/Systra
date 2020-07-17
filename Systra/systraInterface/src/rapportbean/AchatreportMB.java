package rapportbean;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.projetsystra.metier.entities.*;
import com.projetsystra.metier.interfaces.*;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@ViewScoped
@ManagedBean(name="achatreportMB")
public class AchatreportMB {
	 @Resource(mappedName="java:jboss/systraDS")
		private DataSource dataSource;
	 @EJB
		private ServiceILocal metier;
private String codeachat;
private String codefourn;
private String codeprod;

	 private Date datedebut,datefin;
	 public java.sql.Date sqldatedebut, sqldateFin;
	 private int Itemenu;
	
	
	
	public int getItemenu() {
		return Itemenu;
	}

	public void setItemenu(int itemenu) {
		Itemenu = itemenu;
	}

	

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	
	
	public void Touslesachats()
	{
	  //  SimpleDateFormat d = new SimpleDateFormat ("yyyy-MM-dd" );
	  //  java.util.Date currentTime_1 = new java.util.Date();
	 
	     try {
System.out.println("Rapport de tous les achats");
	     File file=new File("D://rapport//reportachatdetails.jrxml");  
	    //	File file=new File("//mnt//rapport//reportachats.jrxml");  
	
	    	 String path  = file.getCanonicalPath();
     System.out.println(path);
	    	 	Connection conn = dataSource.getConnection();
	            JasperDesign jasperD = JRXmlLoader.load(file);
	            String req ="select * from tb_achats WHERE Achat_etat='livré'" ;
	   
	         
	          Map params= new HashMap();
	          System.out.println("Nombre d'achats"+req.length());
	    
	            JRDesignQuery newquery = new JRDesignQuery();
	             newquery.setText(req);
	             jasperD.setQuery(newquery);
	             JasperReport jasp = JasperCompileManager.compileReport(jasperD);
	             JasperPrint jasprint = JasperFillManager.fillReport(jasp,params,conn);
	             //JasperViewer.viewReport(jasprint,true);
	             HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
	             httpServletResponse.addHeader("Content-type", "application/pdf");
	            // httpServletResponse.addHeader("Content-disposition", "attachment; filename=Tous les Achats.pdf");
	              ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
	              JasperExportManager.exportReportToPdfStream(jasprint, servletOutputStream);
	              
	              FacesContext.getCurrentInstance().responseComplete();
	        } catch (Exception e) { 
	            System.out.println("Erreur "+e.getMessage());
	        }
	    
	}
	public java.sql.Date getSqldatedebut() {
		return sqldatedebut;
	}

	public void setSqldatedebut(java.sql.Date sqldatedebut) {
		this.sqldatedebut = sqldatedebut;
	}

	public java.sql.Date getSqldateFin() {
		return sqldateFin;
	}

	public void setSqldateFin(java.sql.Date sqldateFin) {
		this.sqldateFin = sqldateFin;
	}

	public void AchatparCodeAchat()
	{
		if(codeachat==null){
			
			
		}else{
		
		
	AchatsEntity ach=metier.FindOneachats(codeachat);
	if(ach==null){
		FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Code Achat introuvable","");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	else{
	     try {
	    	 File file=new File("D://rapport//reportachats.jrxml");  
	    	 System.out.println("Rapport de tous les achats par code");
	    	// File file=new File("//mnt//rapport//reportachats.jrxml");  
	    	 String path  = file.getAbsolutePath();
	    	 System.out.println(path);
	    	 
	    	 	Connection conn = dataSource.getConnection();
	    	 	 JasperDesign jasperD = JRXmlLoader.load(file);
		           String req ="select * from tb_achat_details inner join  tb_producteur on (tb_achat_details.producteurid=producteur_id)"
	            		+ " join tb_achats on (tb_achat_details.achatcode=achat_code) where Achat_id='"+codeachat+"' " ;
	          Map params= new HashMap();
	    
	            JRDesignQuery newquery = new JRDesignQuery();
	             newquery.setText(req);
	             jasperD.setQuery(newquery);
	             JasperReport jasp = JasperCompileManager.compileReport(jasperD);
	             JasperPrint jasprint = JasperFillManager.fillReport(jasp,params,conn);
	             //JasperViewer.viewReport(jasprint,true);
	             HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
	             httpServletResponse.addHeader("Content-disposition", "attachment; filename=Details Achats.pdf");
	              ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
	              JasperExportManager.exportReportToPdfStream(jasprint, servletOutputStream);
	              
	              FacesContext.getCurrentInstance().responseComplete();
	              setCodeachat(null);
	        } catch (Exception e) { 
	            
	        }
	}
		}
	}
	public void Achatparfournisseur()
	{
		 System.out.println("paramValue"+codefourn);
	FournisseurEntity four=	metier.FindOneFournisseur(codefourn);
	 
	
	if(four==null){
		FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Code Fournisseur inconnu","");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	else{
	     try {
	    	// File file=new File("C://Users//Ing Johnson//Desktop//pscp//reportachats.jrxml");  
		    		
	    	 File file=new File("//mnt//rapport//reportachats.jrxml");  
	    	 String path  = file.getAbsolutePath();
	    	 System.out.println(path);
	    	 
	    	 	Connection conn = dataSource.getConnection();
	    	 	 JasperDesign jasperD = JRXmlLoader.load(file);
	    	 	String req ="select * from tb_achats where fournisseur_id='"+codefourn+"'";
		     
		           Map params= new HashMap();
	                  JRDesignQuery newquery = new JRDesignQuery();
	             newquery.setText(req);
	             jasperD.setQuery(newquery);
	             JasperReport jasp = JasperCompileManager.compileReport(jasperD);
	             JasperPrint jasprint = JasperFillManager.fillReport(jasp,params,conn);
	             //JasperViewer.viewReport(jasprint,true);
	             HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();    
	             httpServletResponse.addHeader("Content-type", "application/pdf");
	             //httpServletResponse.addHeader("Content-disposition", "attachment; filename=Rapport Achat Par Fournisseur.pdf");
	              ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
	              JasperExportManager.exportReportToPdfStream(jasprint, servletOutputStream);
	              
	              FacesContext.getCurrentInstance().responseComplete();
	              setCodefourn(null);
	        } catch (Exception e) { 
	            
	        }
	     
		}
	}
	public String getCodeachat() {
		return codeachat;
	}

	public void setCodeachat(String codeachat) {
		this.codeachat = codeachat;
	}

	public String getCodefourn() {
		return codefourn;
	}

	public void setCodefourn(String codefourn) {
		this.codefourn = codefourn;
	}

	public String getCodeprod() {
		return codeprod;
	}

	public void setCodeprod(String codeprod) {
		this.codeprod = codeprod;
	}

	public void AchatparDate()
	{
		SimpleDateFormat d = new SimpleDateFormat ("yyyy-MM-dd" );
	    java.sql.Date currentTime_1 = new java.sql.Date(2018,01,01);
	    java.sql.Date currentTime_2 = new java.sql.Date(2018,01,31);
	    String date_debut = d.format(datedebut);
	    String date_fin = d.format(datefin);
		 try {
			// File file=new File("C://Users//Ing Johnson//Desktop//pscp//reportachats.jrxml");  
		    	
			 File file=new File("//mnt//rapport//reportachats.jrxml");  
			 String path  = file.getAbsolutePath();
			 System.out.println(path);
	 	Connection conn = dataSource.getConnection();
	 	 JasperDesign jasperD = JRXmlLoader.load(file);
	 	String req ="select * from tb_achats where AchatDate between '"+datedebut+"' and '"+datefin+"' ";
	     Map params= new HashMap();

        JRDesignQuery newquery = new JRDesignQuery();
         newquery.setText(req);
         jasperD.setQuery(newquery);
         JasperReport jasp = JasperCompileManager.compileReport(jasperD);
         JasperPrint jasprint = JasperFillManager.fillReport(jasp,params,conn);
         //JasperViewer.viewReport(jasprint,true);
         HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
         httpServletResponse.addHeader("Content-type", "application/pdf");
         httpServletResponse.addHeader("Content-disposition", "attachment; filename=Rapport Achat Par Date.pdf");
          ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
          JasperExportManager.exportReportToPdfStream(jasprint, servletOutputStream);
          
          FacesContext.getCurrentInstance().responseComplete();
    } catch (Exception e) { 
        
    }
	}
	
	
	
	public void AchatparProducteur()
	{
		 System.out.println("paramValue"+codeprod);
	ProducteurEntity prod=	metier.FindOneProducteur(codeprod);
	 
	
	if(prod==null){
		FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Code Fournisseur inconnu","");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	else{
	     try {
	    	 File file=new File("C://Users//Ing Johnson//Desktop//pscp//reportachats.jrxml");  
		    		
	    	// File file=new File("//mnt//rapport//reportachats.jrxml");  
	    	 String path  = file.getAbsolutePath();
	    	 System.out.println(path);
	    	 
	    	 	Connection conn = dataSource.getConnection();
	    	 	 JasperDesign jasperD = JRXmlLoader.load(file);
	    	 	String req ="select * from tb_achats where ProducteurId='"+codeprod+"'";
		     
		           Map params= new HashMap();
	                  JRDesignQuery newquery = new JRDesignQuery();
	             newquery.setText(req);
	             jasperD.setQuery(newquery);
	             JasperReport jasp = JasperCompileManager.compileReport(jasperD);
	             JasperPrint jasprint = JasperFillManager.fillReport(jasp,params,conn);
	             //JasperViewer.viewReport(jasprint,true);
	             HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();    
	             httpServletResponse.addHeader("Content-type", "application/pdf");
	             //httpServletResponse.addHeader("Content-disposition", "attachment; filename=Rapport Achat Par Fournisseur.pdf");
	              ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
	              JasperExportManager.exportReportToPdfStream(jasprint, servletOutputStream);
	              
	              FacesContext.getCurrentInstance().responseComplete();
	              setCodeprod(null);
	        } catch (Exception e) { 
	            
	        }
	     
		}
	}
}
