package rapportbean;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.ws.rs.core.Response;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

@RequestScoped
@ManagedBean(name="ProdRPbean")
public class ProdRPbean {

	@Resource(mappedName="java:jboss/systraDS")
	private DataSource dataSource;
	
	
	public void RapportTotal()
	{
	  //  SimpleDateFormat d = new SimpleDateFormat ("yyyy-MM-dd" );
	  //  java.util.Date currentTime_1 = new java.util.Date();
	 
	     try {
	    	 	Connection conn = dataSource.getConnection();
	            JasperDesign jasperD = JRXmlLoader.load("C://Users//Ing Johnson//Documents//server//reports//reportProd.jrxml");
	            String req ="select * from tb_producteur " ;
	          Map params= new HashMap();
	    
	            JRDesignQuery newquery = new JRDesignQuery();
	             newquery.setText(req);
	             jasperD.setQuery(newquery);
	             JasperReport jasp = JasperCompileManager.compileReport(jasperD);
	             JasperPrint jasprint = JasperFillManager.fillReport(jasp,params,conn);
	             // JasperPrint jp= JasperFillManager.fillReport(filename, hlotex,con);
	             //JasperViewer.viewReport(jasprint,true);
	             //JasperExportManager.exportReportToPdfFile(jasprint, "reportprod.pdf");
	             HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
	             httpServletResponse.addHeader("Content-disposition", "attachment; filename=reportprod.pdf");
	              ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
	              JasperExportManager.exportReportToPdfStream(jasprint, servletOutputStream);
	              
	              FacesContext.getCurrentInstance().responseComplete();
	        } catch (Exception e) { 
	            
	        }
	     
	}
	    public void printReport() throws ClassNotFoundException, IOException, JRException {
	        Map parameterMap = new HashMap();

	        FacesContext ctx = FacesContext.getCurrentInstance();
	        HttpServletResponse response = (HttpServletResponse) ctx.getExternalContext().getResponse();
	        InputStream reportStream = ctx.getExternalContext().getResourceAsStream("C:/Users/PJS/Documents/rapport/reportProd.jasper");
	        //C:/Users/PJS/Documents/rapport/reportProd.jasper
	        ServletOutputStream servletOutputStream = response.getOutputStream();
	        servletOutputStream.flush();

	        response.setContentType("application/pdf");
	        JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream, parameterMap);

	        servletOutputStream.flush();
	        servletOutputStream.close();
	        ctx.responseComplete();
	}
}
