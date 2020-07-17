package managebean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import com.projetsystra.metier.entities.Role;
import com.projetsystra.metier.interfaces.ServiceILocal;

@RequestScoped
@ManagedBean
public class RoleMB {
	@EJB
	private ServiceILocal metier;
	private String rolename;
	
	public String getRolename() {
		return rolename;
	}


	public void setRolename(String rolename) {
		this.rolename = rolename;
	}


	public String addRole(){
		try{
		metier.addRole(new Role(rolename));
		FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_INFO,"Role cree avec succes","");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		}catch(Exception e){
			
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec de creation du role","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return "";
	}
	
	
	public String editer(){
		Role r=metier.getRole(rolename);
		rolename=r.getRolename();
		return"";	
	}
	
	public String update(){
		
		try{
			metier.updateRole(new Role(rolename));
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_INFO,"Role modifie avec succes","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			}catch(Exception e){
				
				FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec de modification du role","");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		
		
	
		return"";
	}
	
	public List<Role> listerRoles(){	
	return metier.listerRole();	
	}
	
}
