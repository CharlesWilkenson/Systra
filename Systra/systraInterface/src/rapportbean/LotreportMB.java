package rapportbean;

import java.io.File;
import java.sql.Connection;
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
@ManagedBean(name="lotreportMB")
public class LotreportMB {
	 @Resource(mappedName="java:jboss/systraDS")
		private DataSource dataSource;
	 @EJB
		private ServiceILocal metier;
	private String codelot;
	private String codefourn;
	
	 public String getCodelot() {
		return codelot;
	}

	public void setCodelot(String codelot) {
		this.codelot = codelot;
	}

	public String getCodefourn() {
		return codefourn;
	}

	public void setCodefourn(String codefourn) {
		this.codefourn = codefourn;
	}
	

	
	public void Tousleslots()
	{
	     try {
	    	// File file=new File("//mnt//rapport//lotsreport.jrxml");
	     File file=new File("D://rapport//lotsreport.jrxml");    	 
	    	 String path  = file.getAbsolutePath();
	    	 System.out.println(path);
	    	 	Connection conn = dataSource.getConnection();
	            JasperDesign jasperD = JRXmlLoader.load(file);
	          
	            String req="select * from tb_lots_details inner join  tb_lots  on (tb_lots.lot_id=tb_lots_details.LotsId)inner join tb_achats on (tb_achats.Achat_id=tb_lots_details.AchatsId) inner join tb_Producteur on (tb_achats.ProducteurId=tb_Producteur.producteur_id)";
	            
	            Map params= new HashMap();
	    
	            JRDesignQuery newquery = new JRDesignQuery();
	             newquery.setText(req);
	             jasperD.setQuery(newquery);
	             JasperReport jasp = JasperCompileManager.compileReport(jasperD);
	             JasperPrint jasprint = JasperFillManager.fillReport(jasp,params,conn);
	             //JasperViewer.viewReport(jasprint,true);
	             HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
	             httpServletResponse.addHeader("Content-type", "application/pdf");
	             //httpServletResponse.addHeader("Content-disposition", "attachment; filename=Tous les lots.pdf");
	              ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
	              JasperExportManager.exportReportToPdfStream(jasprint, servletOutputStream);
	              
	              FacesContext.getCurrentInstance().responseComplete();
	              
	        } catch (Exception e) { 
	        	System.out.println("Erreur "+e.getMessage());  
	        }
	     
	}
	public void Lotparcode()
	{System.out.println("paramValue"+codelot);
		LotsEntity lot=metier.FindOneLots(codelot);
		if(lot==null){
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Code Lot inconnu","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		else{
	     try {
	    	// File file=new File("//mnt//rapport//lotsreport.jrxml");
	       File file=new File("D://rapport//lotsreport.jrxml");    	 
	    	 String path  = file.getAbsolutePath();
	    	 System.out.println(path);
	    	 	Connection conn = dataSource.getConnection();
	            JasperDesign jasperD = JRXmlLoader.load(file);
	           
	            String req1="select * from tb_lots_details inner join  tb_lots  on (tb_lots.lot_id=tb_lots_details.LotsId)inner join tb_achats on (tb_achats.Achat_id=tb_lots_details.AchatsId) inner join tb_Producteur on (tb_achats.ProducteurId=tb_Producteur.producteur_id) where tb_lots.lot_id='"+codelot+"'";
	            
	            
	          Map params= new HashMap();
	    
	            JRDesignQuery newquery = new JRDesignQuery();
	             newquery.setText(req1);
	             jasperD.setQuery(newquery);
	             JasperReport jasp = JasperCompileManager.compileReport(jasperD);
	             JasperPrint jasprint = JasperFillManager.fillReport(jasp,params,conn);
	             //JasperViewer.viewReport(jasprint,true);
	             HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
	             httpServletResponse.addHeader("Content-type", "application/pdf");
	            // httpServletResponse.addHeader("Content-disposition", "attachment; filename=Rapport Lot par Code.pdf");
	              ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
	              JasperExportManager.exportReportToPdfStream(jasprint, servletOutputStream);
	              	              FacesContext.getCurrentInstance().responseComplete();
	              	            setCodelot(null);
	        } catch (Exception e) { 
	            
	        }
		}
	}
	public void Lotparfournisseur()
	{
		FournisseurEntity four=	metier.FindOneFournisseur(codefourn);
		if(four==null){
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Code Fournisseur inconnu","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		else{
	     try {
	    	 File file=new File("//mnt//rapport//lotsreport.jrxml");
	      	// File file=new File("C://Users//Ing Johnson//Desktop//pscp//lotsreport.jrxml");    	 
	    	 String path  = file.getAbsolutePath();
	    	 System.out.println(path);
	    	 	Connection conn = dataSource.getConnection();
	            JasperDesign jasperD = JRXmlLoader.load(file);
	            String req ="select * from tb_achat_details inner join  tb_producteur on (tb_achat_details.producteurid=producteur_id) join tb_achat "
	            		+ "on (tb_achat_details.achatcode=tb_achat.achat_code) join tb_lot on (tb_lot.achat_code=tb_achat.achat_code)"
	            		+ " where tb_lot.fournisseur_id='"+codefourn+"' " ;
	         
	            
	            String req1="select * from tb_lots_details inner join  tb_lots  on (tb_lots.lot_id=tb_lots_details.LotsId)inner join tb_achats on (tb_achats.Achat_id=tb_lots_details.AchatsId) inner join tb_Producteur on (tb_achats.ProducteurId=tb_Producteur.producteur_id) where tb_lots.fournisseur_id='"+codefourn+"'";
	            
	            Map params= new HashMap();
	    
	            JRDesignQuery newquery = new JRDesignQuery();
	             newquery.setText(req1);
	             jasperD.setQuery(newquery);
	             JasperReport jasp = JasperCompileManager.compileReport(jasperD);
	             JasperPrint jasprint = JasperFillManager.fillReport(jasp,params,conn);
	             //JasperViewer.viewReport(jasprint,true);
	             HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
	             httpServletResponse.addHeader("Content-type", "application/pdf");
	            // httpServletResponse.addHeader("Content-disposition", "attachment; filename=Rapport Lot par fournisseur.pdf");
	              ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
	              JasperExportManager.exportReportToPdfStream(jasprint, servletOutputStream);
	              FacesContext.getCurrentInstance().responseComplete();
	              setCodefourn(null);
	        } catch (Exception e) { 
	            
	        }
		}
	}
}
