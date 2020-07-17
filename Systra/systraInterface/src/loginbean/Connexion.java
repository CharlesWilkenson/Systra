package loginbean;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.projetsystra.metier.entities.*;
import com.projetsystra.metier.interfaces.*;
@SessionScoped
@ManagedBean(name="connect")
public class Connexion {
@EJB
private ServiceILocal metier;
		 private String email;
		 private String traceEmail;
		 private String password;
         private String prenom;
         private String nom;
         private String message;
         private String nomProd;
         private String sexe;
      	private String parcelleEtat;
        private String codePacelle;
        private String codeProd;
        private String codeAchat;
        
        private String codeFournisseur;
        private String fournNom;
        private String fournPrenom;
        private String fournSexe;
        private String founAdresse;
        private String fournEmail;
        private String fournNif;
        private String fournEtat;
        private String fournUsine;
        private String fournTel;
         
        private String prodNom;
        private String prodSexe;
        private String prodEtat;
        private String prodTel;
        private String codeLot;
        
        
        private String idMessage;
        private String mailClient;
        private String messageClient;
        private String nomCompletClient;
        private String dateMessage; 
        
        
        
         public String getMailClient() {
        	 return( (String)get("mailClient"));
		}

		public void setMailClient(String mailClient) {
		set("mailClient", mailClient);
		}

		public String getMessageClient() {
		return( (String)get("messageClient"));
		}

		public void setMessageClient(String messageClient) {
			set("messageClient", messageClient);
		}

		public String getNomCompletClient() {
			return( (String)get("nomCompletClient"));
		}

		public void setNomCompletClient(String nomCompletClient) {
			set("nomCompletClient", nomCompletClient);
		}

		public String getDateMessage() {
			return( (String)get("dateMessage"));
		}

		public void setDateMessage(String dateMessage) {
			this.dateMessage = dateMessage;
		}

		public String getIdMessage() {
        	 return( (String)get("idMessage"));
		}

		public void setIdMessage(String idMessage) {
			set("idMessage", idMessage);
		}

		public String getCodeLot() {
        	 return( (String)get("codeLot"));
		}

		public void setCodeLot(String codeLot) {
			set("codeLot", codeLot);
		}

		public String getProdNom() {
        		return( (String)get("prodNom"));
		}

		public void setProdNom(String prodNom) {
			set("prodNom", prodNom);
		}

		public String getProdSexe() {
			return( (String)get("prodSexe"));
		}

		public void setProdSexe(String prodSexe) {
			set("prodSexe", prodSexe);
		}

		public String getProdEtat() {
			return( (String)get("prodEtat"));
		}

		public void setProdEtat(String prodEtat) {
			set("prodEtat", prodEtat);
		}

		public String getProdTel() {
			 return( (String)get("prodTel"));
		}

		public void setProdTel(String prodTel) {
			set("prodTel", prodTel);
		}

		public String getFournTel() {
        	 return( (String)get("fournTel"));
		}

		public void setFournTel(String fournTel) {
			set("fournTel", fournTel);
		}

		public String getFournNom() {
        	 return( (String)get("fournNom"));
		}

		public void setFournNom(String fournNom) {
			set("fournNom", fournNom);
		}

		public String getFournPrenom() {
			 return( (String)get("fournPrenom"));
		}

		public void setFournPrenom(String fournPrenom) {
			set("fournPrenom", fournPrenom);
		}

		public String getFournSexe() {
			 return( (String)get("fournSexe"));
		}

		public void setFournSexe(String fournSexe) {
			set("fournSexe", fournSexe);
		}

		public String getFounAdresse() {
			 return( (String)get("fournAdresse"));
		}

		public void setFounAdresse(String founAdresse) {
			set("fournAdresse", founAdresse);
		}

		public String getFournEmail() {
			 return( (String)get("fournEmail"));
		}

		public void setFournEmail(String fournEmail) {
			set("fournEmail", fournEmail);
		}

		public String getFournNif() {
			 return( (String)get("fournNif"));
		}
		public void setFournNif(String fournNif) {
			set("fournNif", fournNif);
		}

		public String getFournEtat() {
			return( (String)get("fournEtat"));
		}

		public void setFournEtat(String fournEtat) {
			set("fournEtat", fournEtat);
		}

		public String getFournUsine() {
			return( (String)get("fournUsine"));
		}

		public void setFournUsine(String fournUsine) {
			set("fournUsine", fournUsine);
		}

		public String getSexe() {
			return sexe;
		}

		public void setSexe(String sexe) {
			this.sexe = sexe;
		}


		private String codeParcelleLocaliser;
    	 public String getCodeParcelleLocaliser() {
			 return( (String)get("codeParcelleLocaliser"));
		}

		public void setCodeParcelleLocaliser(String codeParcelleLocaliser) {
			set("codeParcelleLocaliser", codeParcelleLocaliser);
		}
         
         public String getTraceEmail() {
        	 return( (String)get("traceEmail"));
		}

		public void setTraceEmail(String traceEmail) {
			set("traceEmail",email);
		}


		
         public String getNomProd() {
        	 return( (String)get("nomprod"));
		}

		public void setNomProd(String nomProd) {
			set("nomprod",nomProd);
		}



         
        public String getShowCodeParcelleModal() {
       	 return( (String)get("showCodeParcelleModal"));
		}

		public void setShowCodeParcelleModal(String showCodeParcelleModal) {
			set("showCodeParcelleModal", showCodeParcelleModal);
		}
        
         public String getShowCodeProd() {
        	 return( (String)get("showCodeProd"));
		}

		public void setShowCodeProd(String showCodeProd) {
			set("showCodeProd", showCodeProd);
		}

	    public String getShowCodeProdModal() {
	    	 return( (String)get("showCodeProdModal"));
			}

			public void setShowCodeProdModal(String showCodeProdModal) {
				set("showCodeProdModal", showCodeProdModal);
			}
     
	
         public String getShowCodeParcelle() {
        	 return( (String)get("showCodeParcelle"));
		}

		public void setShowCodeParcelle(String showCodeParcelle) {
			set("showCodeParcelle", showCodeParcelle);
		}

		public String getCodeFournisseur() {
         	 return( (String)get("codeFournisseur"));
		}

		public void setCodeFournisseur(String codeFournisseur) {
			set("codeFournisseur", codeFournisseur);
		}

		public String getMessage() {
			return message;
		}

        


	
         public String getCodeAchat() {
        	 return( (String)get("codeAchat"));
		}

		public void setCodeAchat(String codeAchat) {
			set("codeAchat", codeAchat);
		}

		public String getParcelleEtat() {
        	 return( (String)get("parcEtat"));
		}

		public void setParcelleEtat(String parcelleEtat) {
			set("parcEtat", parcelleEtat);
		}

		
         
		 public String getCodePacelle() {
			 return( (String)get("codeParc"));
		}

		public void setCodePacelle(String codePacelle) {
			set("codeParc", codePacelle);
		}

		public String getCodeProd() {
			return( (String)get("codeProd"));
		}

		public void setCodeProd(String codeProd) {
			set("codeProd", codeProd);
		}

		

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		

		
		
			public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

			public String getPrenom() {
			return prenom;
		}
		
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

	
		
	public void login() throws IOException {
			FacesContext context =
			FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest)
			context.getExternalContext().getRequest();
						
			try {
			request.login(email,password); 
			UtilisateurEntity ut= metier.FindOneUtilisateur(email);
			nom=ut.getUtilisateurNom();
			prenom=ut.getUtilisateurPrenom();
			traceEmail=ut.getUtilisateurEmail();
			sexe=ut.getUtilisateurSexe();
			context = FacesContext.getCurrentInstance();
			context.getExternalContext().redirect("/faces/Views/overview.xhtml");  
	        metier.addTrace(new TraceEntity(email, new Date(), "Connexion"));
			
	
			} catch (ServletException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Email ou mot de passe invalide",""));
			//message="Email ou mot de passe invalide";
			}
		
		}
		

		   public void logout() throws ServletException {
				/*FacesContext context =
						FacesContext.getCurrentInstance();
						HttpServletRequest request = (HttpServletRequest)
						context.getExternalContext().getRequest();
						*/
						
					    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
					    
					    
	            try {
	            //	request.logout();
	            	ec.invalidateSession();
	            	metier.addTrace(new TraceEntity(email, new Date(), "Deconnexion"));
	    			ec.redirect(ec.getRequestContextPath() + "/faces/static/signin.xhtml");

	            	message="Vous vous êtes deconnecté du systeme";
	            	password=""; 
			        email="";
			        
		} catch (IOException e) {
				
				e.printStackTrace();
			}  
		       
		  
		    }
		
		   public void setMessage(String message) {
			this.message = message;
		}

		private static void set(String cle, Object valeur){
				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
				HttpSession session = request.getSession(false);
				session.setAttribute(cle, valeur);
		        }
		
		    private static Object get(String cle){
		    	FacesContext context = FacesContext.getCurrentInstance();
		    	HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		    	HttpSession session = request.getSession(false);
		    	 Object res = null;		       
		        res = session.getAttribute(cle);
		        
		        return res;
		    }
}

