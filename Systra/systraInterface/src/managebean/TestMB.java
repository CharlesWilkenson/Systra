package managebean;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import com.projetsystra.metier.entities.MessageEntity;
import com.projetsystra.metier.interfaces.ServiceILocal;


@RequestScoped
@ManagedBean
public class TestMB {
	@EJB
	private ServiceILocal metier;
private String mail;
private String message;
private String nomComplet;
private Date date;
	public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}



	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNomComplet() {
		return nomComplet;
	}
	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}
	
	public String envoyerMessage(){
		if(mail==null || message==null ||equals(nomComplet==null)){
			
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Il faut remplir tous les champs","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		
		}else{
		try{	
		metier.envoyerMessage(new MessageEntity(nomComplet, mail, message, "non lu", new Date()));	
		FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Votre message a ete envoye","");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	
		}catch(Exception e){
			
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Votre message n'a pas ete envoye","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		
			
		}
		}
	return"";	
	}

	 
	public String getParam(){
		FacesContext fc= FacesContext.getCurrentInstance();
		Map<String, String> param= fc.getExternalContext().getRequestParameterMap();
		String idmsg= param.get("idmsg");
	return idmsg;	
	}
	
	
	

	
	public List<MessageEntity> listerMessagesNonLu(){
		
		
		return metier.listerMessages("non lu");
	}
	
	public List<MessageEntity> listerMessagesLu(){
		
		
		return metier.listerMessages("lu");
	}
	
	
}
