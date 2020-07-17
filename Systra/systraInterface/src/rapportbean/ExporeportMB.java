package rapportbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@RequestScoped
@ManagedBean(name="exporeportMB")
public class ExporeportMB {
	 private Boolean renderInput=false;
	 private Boolean renderDate=false;
	 private String label;
	 private String generateValue;
	 private int Itemenu;
	public Boolean getRenderInput() {
		return renderInput;
	}
	public void setRenderInput(Boolean renderInput) {
		this.renderInput = renderInput;
	}
	public Boolean getRenderDate() {
		return renderDate;
	}
	public void setRenderDate(Boolean renderDate) {
		this.renderDate = renderDate;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getGenerateValue() {
		return generateValue;
	}
	public void setGenerateValue(String generateValue) {
		this.generateValue = generateValue;
	}
	public int getItemenu() {
		return Itemenu;
	}
	public void setItemenu(int itemenu) {
		Itemenu = itemenu;
	}
	public void Renderingexpo()
	 {
		 switch (Itemenu) {
		case 1:
			renderInput=false;
			 renderDate=false;
			break;
		case 2:
			renderInput=true;
			 renderDate=false;
			 label="Code Exportation";
			break;
		case 3:
			renderInput=true;
			 renderDate=false;
			 label="Client";
			break;
		case 4:
			renderInput=false;
			 renderDate=true;
			break;
		default:
			 renderInput=false;
			 renderDate=false;
			break;
		}
		 
	 }
	
	public void Generatereport()
	 {
		 switch (Itemenu) {
		case 1:
			//Touslesachats();
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		default:
			
			break;
		}
		 
	 }
	 
}
