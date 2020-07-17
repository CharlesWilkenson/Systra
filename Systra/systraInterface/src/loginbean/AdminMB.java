package loginbean;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;

import com.projetsystra.metier.EJBImpl.HashPassword;
import com.projetsystra.metier.entities.*;
import com.projetsystra.metier.interfaces.*;

@RequestScoped
@ManagedBean
public class AdminMB {

	@EJB
	private ServiceILocal metier;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	private  Connexion connect=new Connexion();
	private String UtilisateurEmail;
	private String UtilisateurNom;
	private String UtilisateurPrenom;
	private String UtilisateurAdresse;
	private String UtilisateurTelephone;
	private String UtilisateurFonction;
	private String UtilisateurPseudo;
	private String ancienMotdepasse;	
	private String nouveauMotdepasse;
	private String ConfirmerMotdepasse;
	private String UtilisateurEtatcompte;
	private String rolename;
	private String utilisateurSexe;
	
	public String getUtilisateurSexe() {
		return utilisateurSexe;
	}
	public void setUtilisateurSexe(String utilisateurSexe) {
		this.utilisateurSexe = utilisateurSexe;
	}

	private UtilisateurEntity user;
	private Role role;
	private String message;
	public String getAncienMotdepasse() {
		return ancienMotdepasse;
	}
	public void setAncienMotdepasse(String ancienMotdepasse) {
		this.ancienMotdepasse = ancienMotdepasse;
	}


	public String getNouveauMotdepasse() {
		return nouveauMotdepasse;
	}
	public void setNouveauMotdepasse(String nouveauMotdepasse) {
		this.nouveauMotdepasse = nouveauMotdepasse;
	}


	
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public UtilisateurEntity getUser() {
		return user;
	}
	public void setUser(UtilisateurEntity user) {
		this.user = user;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getUtilisateurEmail() {
		return UtilisateurEmail;
	}
	public void setUtilisateurEmail(String utilisateurEmail) {
		UtilisateurEmail = utilisateurEmail;
	}
	public String getUtilisateurNom() {
		return UtilisateurNom;
	}
	public void setUtilisateurNom(String utilisateurNom) {
		UtilisateurNom = utilisateurNom;
	}
	public String getUtilisateurPrenom() {
		return UtilisateurPrenom;
	}
	public void setUtilisateurPrenom(String utilisateurPrenom) {
		UtilisateurPrenom = utilisateurPrenom;
	}
	public String getUtilisateurAdresse() {
		return UtilisateurAdresse;
	}
	public void setUtilisateurAdresse(String utilisateurAdresse) {
		UtilisateurAdresse = utilisateurAdresse;
	}
	public String getUtilisateurTelephone() {
		return UtilisateurTelephone;
	}
	public void setUtilisateurTelephone(String utilisateurTelephone) {
		UtilisateurTelephone = utilisateurTelephone;
	}
	public String getUtilisateurFonction() {
		return UtilisateurFonction;
	}
	public void setUtilisateurFonction(String utilisateurFonction) {
		UtilisateurFonction = utilisateurFonction;
	}
	public String getUtilisateurPseudo() {
		return UtilisateurPseudo;
	}
	public void setUtilisateurPseudo(String utilisateurPseudo) {
		UtilisateurPseudo = utilisateurPseudo;
	}

	public String getUtilisateurEtatcompte() {
		return UtilisateurEtatcompte;
	}
	public void setUtilisateurEtatcompte(String utilisateurEtatcompte) {
		UtilisateurEtatcompte = utilisateurEtatcompte;
	}
	
	
	public String getConfirmerMotdepasse() {
		return ConfirmerMotdepasse;
	}
	public void setConfirmerMotdepasse(String confirmerMotdepasse) {
		ConfirmerMotdepasse = confirmerMotdepasse;
	}
	public String adduser() {
		if(UtilisateurEmail==null|| UtilisateurNom==null||
				 UtilisateurPrenom==null|| UtilisateurAdresse==null|| UtilisateurTelephone==null){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Il faut remplir tous les champs",""));
			
		}
		else if(metier.FindOneUtilisateur(UtilisateurEmail)!=null){
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Cet utilisateur existe déja",""));
		
		}else{
			
		 UtilisateurEntity u=new UtilisateurEntity(UtilisateurEmail, UtilisateurNom,
				 UtilisateurPrenom, utilisateurSexe, UtilisateurAdresse, UtilisateurTelephone, UtilisateurFonction, 
				  password(), "Actif");
		 UserRole ur=new UserRole(u, new Role(UtilisateurFonction));
		 try{
		 metier.AddUtilisateur(u, ur); 
		 metier.addTrace(new TraceEntity(connect.getEmail(), new Date(), "Add USer-"+UtilisateurEmail));

		 FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_INFO,"Utilisateur crée avec succes","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		 clearField();
		 }catch(Exception e){
			 FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec de création de l'utilisateur","");
				FacesContext.getCurrentInstance().addMessage(null, msg); 
		 }
		}		
	 return"succes";
		 
		}
		

	public String updateUser(){
		if(UtilisateurEmail==null|| UtilisateurNom==null||
				 UtilisateurPrenom==null|| UtilisateurAdresse==null|| UtilisateurTelephone==null){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Il faut remplir tous les champs",""));
			
		}
		else{
			try{
				UtilisateurEntity ut=metier.FindOneUtilisateur(UtilisateurEmail);
				
		UtilisateurEntity u=new UtilisateurEntity(UtilisateurEmail, UtilisateurNom,
				 UtilisateurPrenom,utilisateurSexe, UtilisateurAdresse, UtilisateurTelephone, ut.getUtilisateurFonction(), 
				  ut.getUtilisateurMotdepasse(), ut.getUtilisateurEtatcompte());	
		 metier.UpdateUtilisateur(u);
	     metier.addTrace(new TraceEntity(emailUser(), new Date(), "Modifier USer-"+UtilisateurEmail));
		 
		 clearField();
		FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_INFO,"Utilisateur modifié avec succes","");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		}catch(Exception e){
			
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec de modification de l'utilisateur","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
}

		
		return"";
	}
	
	
	public List<UtilisateurEntity> allUsers() {
	return metier.GetAllUtilisateur();
	}
	
	public List<TraceEntity> listtrace() {
		return metier.listalltrace();
		}
	
	public List<Role> listrole() {
		return metier.listerRole();
		}
	private String password(){
	Random rd=new Random();	
		String password=String.format("%s%s%s",rd.nextInt(999),rd.nextInt(999),rd.nextInt(999));
		return password;
	}
	
	public  void Sendmail() {
		String fromEmail="fflgroup06@gmail.com";	
		String username="fflgroup06";
		String password="p@ssw0rd06";
		String subject="Confirmation";
		String message="Bienvenue sur AGRITECH-SYSTRA"
				+ "Votre mot de passe: "+password();
		//mailsend.SendEmail(fromEmail, username, password, UtilisateurEmail,subject, message);
		/*try {
			mailsender.sendMail(subject, message, fromEmail, UtilisateurEmail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	 public String getparam()
	 {
	FacesContext fc= FacesContext.getCurrentInstance();
	Map<String, String> param= fc.getExternalContext().getRequestParameterMap();
	String idprod = param.get("useremail");
		return idprod; 
	 }
	 public String editUser()
	 {
		
		UtilisateurEntity u=metier.FindOneUtilisateur(getparam());
		 UtilisateurEmail = u.getUtilisateurEmail();
		 UtilisateurFonction = u.getUtilisateurFonction();
		 UtilisateurNom = u.getUtilisateurNom();
		 UtilisateurPrenom = u.getUtilisateurPrenom();
		 UtilisateurTelephone = u.getUtilisateurTelephone();
		 UtilisateurAdresse = u.getUtilisateurAdresse();
		 utilisateurSexe=u.getUtilisateurSexe();
		 return "User Updated";
		 
	 }
	 public String editpassword()
	 {
		UtilisateurEntity ut=metier.FindOneUtilisateur(UtilisateurEmail);
		if(ut==null)
		{
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Email Utilisateur Incorrect","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "";
		}
		
		
		
		else if(!ut.getUtilisateurMotdepasse().equals(HashPassword.hashPassword(ancienMotdepasse))){
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ancien mot de passe incorecte","");
			FacesContext.getCurrentInstance().addMessage(null, msg);	
			return "";   
		}
		
		else if (!nouveauMotdepasse.equals(ConfirmerMotdepasse)) {
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Les mots de passe doivent etre identiques","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "";
		}
		
		
		
		else
		{
			try{
			metier.ChangerPassword(UtilisateurEmail, ancienMotdepasse, nouveauMotdepasse);	
		 metier.addTrace(new TraceEntity(emailUser(), new Date(), "Changer Mot de passe-"+UtilisateurEmail));
		 FacesContext fc=  FacesContext.getCurrentInstance();
		
	    	fc.getExternalContext().invalidateSession();
	    	connect.setEmail(null);
			connect.setPassword(null);
			connect.setPrenom(null);
		fc.getExternalContext().redirect("/faces/static/signin.xhtml");
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Mot de passe change avec succes", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		 }catch(Exception e){
				FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec de changement de mot de passe", "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				
			}
			}
		return "success";
	 }
	 
	public String clearField() {
		setUtilisateurEmail(null);
		setUtilisateurNom(null);
		setUtilisateurPrenom(null);
		setUtilisateurAdresse(null);
		setUtilisateurTelephone(null);
		setUtilisateurFonction(null);
		setUtilisateurPseudo(null);
		setUtilisateurEtatcompte(null);	
		setUtilisateurSexe(null);
		return"";
	}
	
	
public String activerUser(){
	UtilisateurEntity ut=metier.FindOneUtilisateur(getparam());
	 UtilisateurEntity u=new UtilisateurEntity();
	u.setUtilisateurEmail(ut.getUtilisateurEmail());
	u.setUtilisateurFonction(ut.getUtilisateurFonction());
	u.setUtilisateurNom(ut.getUtilisateurNom());
	u.setUtilisateurPrenom(ut.getUtilisateurPrenom());
	u.setUtilisateurTelephone(ut.getUtilisateurTelephone());
	u.setUtilisateurAdresse(ut.getUtilisateurAdresse());
	u.setUtilisateurMotdepasse(ut.getUtilisateurMotdepasse());
	 u.setUtilisateurEtatcompte("Actif");	
	 u.setUtilisateurSexe(ut.getUtilisateurSexe());
	 try{
		 metier.UpdateUtilisateur(u);
		 metier.addTrace(new TraceEntity(emailUser(), new Date(), "Ractiver Utilisateur-"+UtilisateurEmail));
			
		FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_INFO,"Utilisateur active avec succes","");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		}catch(Exception e){
			
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec de reactivation de l'utilisateur","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
 
	return"";
}

public String desactiverUser(){
	UtilisateurEntity ut=metier.FindOneUtilisateur(getparam());
	 UtilisateurEntity u=new UtilisateurEntity();
	 u.setUtilisateurEmail(ut.getUtilisateurEmail());
	u.setUtilisateurFonction(ut.getUtilisateurFonction());
	 u.setUtilisateurNom(ut.getUtilisateurNom());
	 u.setUtilisateurPrenom(ut.getUtilisateurPrenom());
	u.setUtilisateurTelephone(ut.getUtilisateurTelephone());
	u.setUtilisateurAdresse(ut.getUtilisateurAdresse());
	u.setUtilisateurMotdepasse(ut.getUtilisateurMotdepasse());
	 u.setUtilisateurEtatcompte("Passif");	
	 u.setUtilisateurSexe(ut.getUtilisateurSexe());
		try{
			 metier.UpdateUtilisateur(u);
			 metier.addTrace(new TraceEntity(emailUser(), new Date(), "Desactiver Utilisateur-"+UtilisateurEmail));
				
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_INFO,"Utilisateur desactive avec succes","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			}catch(Exception e){
				
				FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec de desactivation de l'utilisateur","");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
	 
	 
	
	return"";
}

public String sendEmail() throws MessagingException{
	try{
	SendEmail.sendEmail(password(), UtilisateurEmail);
FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_INFO,"Email envoye avec succes","");
FacesContext.getCurrentInstance().addMessage(null, msg);
	}catch(Exception e){
		
		FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),"Email not sent");
		FacesContext.getCurrentInstance().addMessage(null, msg);	
	}
	return"Test";
}

private String emailUser(){
	String nomUtilisateur =
			FacesContext.getCurrentInstance()
			.getExternalContext().getRemoteUser();	
	return nomUtilisateur;
	}
}
  