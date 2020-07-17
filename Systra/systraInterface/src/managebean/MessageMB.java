package managebean;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.projetsystra.metier.entities.Lots_detailsEntity;
import com.projetsystra.metier.entities.MessageEntity;
import com.projetsystra.metier.entities.ReadEmail;
import com.projetsystra.metier.entities.SendEmail;
import com.projetsystra.metier.interfaces.ServiceILocal;
import loginbean.Connexion;

@ManagedBean(name="messageMB")
@ViewScoped
public class MessageMB{

@EJB
private ServiceILocal metier;
private String mail;
private String message;
private String nomComplet;
private Date date;
private boolean showread=true;
private boolean showresponse=false;
private int nb;
public int getNb() {
	return nb;
}
public void setNb(int nb) {
	this.nb = nb;
}

private Map<Long, MessageEntity> map=new HashMap<Long, MessageEntity>();
public boolean isShowread() {
	return showread;
}
public Map<Long, MessageEntity> getMap() {
	return map;
}
public void setMap(Map<Long, MessageEntity> map) {
	this.map = map;
}
public void setShowread(boolean showread) {
	this.showread = showread;
}
public boolean isShowresponse() {
	return showresponse;
}
public void setShowresponse(boolean showresponse) {
	this.showresponse = showresponse;
}

private  Connexion connect=new Connexion();
public Connexion getConnect() {
	return connect;
}
public void setConnect(Connexion connect) {
	this.connect = connect;
}

private List<MessageEntity>listerMsgLus;
public List<MessageEntity> getListerMsgLus() {
	return listerMsgLus;
}
public void setListerMsgLus(List<MessageEntity> listerMsgLus) {
	this.listerMsgLus = listerMsgLus;
}
public List<MessageEntity> getListerMsgNonLus() {
	return listerMsgNonLus;
}
public void setListerMsgNonLus(List<MessageEntity> listerMsgNonLus) {
	this.listerMsgNonLus = listerMsgNonLus;
}

private List<MessageEntity>listerMsgNonLus;
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
		FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_INFO,"Votre message a ete envoye","");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	vider();
		}catch(Exception e){
			
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Votre message n'a pas ete envoye","");
			FacesContext.getCurrentInstance().addMessage(null, msg);			
		}
		}
	return"";	
	}
	
	
	public String readMessage(){
		if(getParam()==null){
}else{
try{
	Long id=Long.parseLong(getParam());
	MessageEntity msg=metier.readMessage(id);
	mail=msg.getEmail();
	message=msg.getMessage();
	nomComplet=msg.getNomComplet();
	date=msg.getDate();
}catch(Exception e){}
}
		
		return"";
	}
	
	
	public String readMessageRead(){
		if(getParam()==null){
}else{
try{
	Long id=Long.parseLong(getParam());
	MessageEntity msg=metier.readMessageRead(id);
	mail=msg.getEmail();
	message=msg.getMessage();
	nomComplet=msg.getNomComplet();
	date=msg.getDate();
	
	listerMessagesNonLu();
}catch(Exception e){}
}
		
		return"";
	}
	 
	public String getParam(){
		FacesContext fc= FacesContext.getCurrentInstance();
		Map<String, String> param= fc.getExternalContext().getRequestParameterMap();
		String idmsg= param.get("idmsg");
		
	return idmsg;	
	}
	
	
	
	
	public String deleteMessage(){
		if(getParam()==null){
		}else{
			try{
				Long id=Long.parseLong(getParam());
			metier.deleteMessage(id);
			}catch(Exception e){}
		}
		
		
		return"";
	}
	
	
	public List<MessageEntity> listerMessagesNonLu(){
		if(listerMsgNonLus!=null){
}else{
	
	listerMsgNonLus=metier.listerMessages("non lu");
}
		
		return listerMsgNonLus;
	}
	
	public List<MessageEntity> listerMessagesLu(){
		if(listerMsgLus!=null){
}else{
	
	listerMsgLus=metier.listerMessages("lu");
}
		
		return listerMsgLus;
	}
	
public List<MessageEntity> listerAllMessages(){
		
		
		return metier.listerMessages();
	}



public String lireMessage(){
	if(connect.getIdMessage()==null){
}else{
try{
	Long id=Long.parseLong(connect.getIdMessage());
MessageEntity msg=metier.readMessage(id);
mail=msg.getEmail();
message=msg.getMessage();
nomComplet=msg.getNomComplet();
date=msg.getDate();
}catch(Exception e){}
}
	
	return"";
}


public String lireRead(){
	if(connect.getIdMessage()==null){
		System.out.println("getParam"+getParam());
}else{
try{
	Long id=Long.parseLong(connect.getIdMessage());
MessageEntity msg=metier.readMessageRead(id);
mail=msg.getEmail();
message=msg.getMessage();
nomComplet=msg.getNomComplet();
date=msg.getDate();
}catch(Exception e){}
}
	
	return"";
}


public String redirect1(){
	if(getParam()==null){
		
}else{
try{
Long id=Long.parseLong(getParam());
MessageEntity msg=metier.readMessage(id);
//connect.setIdMessage(msg.getId());
connect.setMailClient(msg.getEmail());
connect.setIdMessage(msg.getMessage());
connect.setNomCompletClient(msg.getNomComplet());
connect.setDateMessage(msg.getDate().toString());
connect.setMessageClient(msg.getMessage());

}catch(Exception e){}
	
}

return"Message.xhtml?faces-redirect=true";
}


public String redirect2(){
	if(getParam()==null){
}else{
try{
Long id=Long.parseLong(getParam());
MessageEntity msg=metier.readMessageRead(id);
//connect.setIdMessage(msg.getId());
connect.setMailClient(msg.getEmail());
connect.setIdMessage(msg.getMessage());
connect.setNomCompletClient(msg.getNomComplet());
connect.setDateMessage(msg.getDate().toString());
connect.setMessageClient(msg.getMessage());

}catch(Exception e){}
	
}

	return"/faces/Views/MessageLu.xhtml?faces-redirect=true";
}
public String repondre(){
	showread=false;
	 showresponse=true;
	return"";
}

public String retour(){
	showread=true;
	 showresponse=false;
	return"";
}


public String repondreClient(){
	try{
		metier.repondreClient(message, connect.getMailClient());
	System.out.println("Methode calle");
FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_INFO,"Message envoyé avec succes","");
FacesContext.getCurrentInstance().addMessage(null, msg);
vider();
	}catch(Exception e){		
		FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),"Votre message n'a pas été envoyé");
		FacesContext.getCurrentInstance().addMessage(null, msg);	
	}
	
	return"";
}


public String vider(){
	connect.setIdMessage(null);
	connect.setMailClient(null);
	connect.setIdMessage(null);
	connect.setNomCompletClient(null);
	connect.setDateMessage(null);
	connect.setMessageClient(null);
	
	mail=null;
	message=null;
	nomComplet=null;
	date=null;
	return"";
}



public  List<Map.Entry<Long, MessageEntity>> lister(){
	List<MessageEntity> list= metier.listerMessages("lu");
	
	for (MessageEntity ms : list) {
		map.put(ms.getId(), new MessageEntity(ms.getNomComplet(),ms.getEmail(),ms.getMessage(),ms.getDate()));
	}
	Collection<Map.Entry<Long, MessageEntity>> values = map.entrySet();
	nb=map.entrySet().size();
    //Creating an ArrayList of values
	return new ArrayList<Map.Entry<Long, MessageEntity>>(values);
}


public String delete(){
	if(getParam()==null){
		
	}else{
		Long id=Long.parseLong(getParam());
		deleteMessage();
	map.remove(id)	;

	nb=map.size();
	System.out.println("Method called successfully");
	}
	
	return"";
}

public String readmails(){
ReadEmail.getMails();	
	
	return"";
}


}
