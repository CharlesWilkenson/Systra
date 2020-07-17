package com.projetsystra.metier.interfaces;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import com.projetsystra.metier.entities.AchatsEntity;
import com.projetsystra.metier.entities.Commune;
import com.projetsystra.metier.entities.Departement;
import com.projetsystra.metier.entities.ExportationEntity;
import com.projetsystra.metier.entities.FournisseurEntity;
import com.projetsystra.metier.entities.LotExporter;
import com.projetsystra.metier.entities.LotsEntity;
import com.projetsystra.metier.entities.Lots_detailsEntity;
import com.projetsystra.metier.entities.MessageEntity;
import com.projetsystra.metier.entities.ParcelleEntity;
import com.projetsystra.metier.entities.ProducteurEntity;
import com.projetsystra.metier.entities.RegionEntity;
import com.projetsystra.metier.entities.Role;
import com.projetsystra.metier.entities.Section_communal;
import com.projetsystra.metier.entities.TraceEntity;
import com.projetsystra.metier.entities.UserRole;
import com.projetsystra.metier.entities.UtilisateurEntity;
import com.projetsystra.metier.entities.ZoneEntity;

@Local
public interface ServiceILocal {


	//Service Nouvel Achats
			public void Addachats(AchatsEntity ach);
			public void Updateachats(AchatsEntity ach);
			public AchatsEntity  FindOneachats(String id);
			public List<AchatsEntity> GetAllachats();
			public List<AchatsEntity> GetAllachats(String codeAchat);
			public List<AchatsEntity> getAllachatsByEtat(String etat);
			public List<AchatsEntity> GetAllachatsbylot(String idlot);
			public List<AchatsEntity> achatsNonLivreFourn(String codeFournisseur);
			public List<AchatsEntity> GetAllachatsbyfourn( String idfourn);
			public void AddAchats(Map<String, AchatsEntity> a);
	
	//Service Commune
	public void Addcommune(Commune com);
	public void Updatecommune(Commune  com);
	public List<Commune> GetAllcommune();
	public void Deletecommune(String id);
	public Commune getCommune(String id);
	
	
	//Service DeptComSec
	public List<Departement> GetAllDepartement();
	public List<Commune> GetCommunebyDept(String id);
	public List<Commune> GetCommunebyDept();
	public List<Section_communal> GetSectionbyCom(String id);
	public List<Section_communal> GetSectionbyCom();
	public Section_communal getSection(String id);
	
	//Service Exportation
	public void AddExportation(ExportationEntity exp, Map<String, LotExporter> a);
	public void UpdateExportation(ExportationEntity exp);
	public ExportationEntity FindOneExportation(String id);
	public ExportationEntity  FindOneByExportation(String MC);
	public List<ExportationEntity> GetAllExportation();
	public void DeleteExportation(String id);
	
	//Service Fournisseurs
	public String AddFournisseur(FournisseurEntity fou);
	public void UpdateFournisseur(FournisseurEntity fou);
	public FournisseurEntity FindOneFournisseur(String id);
	public FournisseurEntity FindOneByFournisseur(String MC);
	public List<FournisseurEntity> GetAllFournisseur();
	public List<FournisseurEntity> getFournisseurByetat(String etat);
	public void DeleteFournisseur(String id);
	

	
	//Service LotExporter
	public void AddLotExporter(LotExporter lex);
	public void UpdateLotExporter(LotExporter lex);
	public LotExporter  FindOneLotExporter(String id);
	public LotExporter  FindOneByLotExporter(String MC);
	public List<LotExporter> GetAllLotExporter();
	
	public List<LotExporter> GetAllLotExporterbyCodeExpo(String codeexpo);
	public void DeleteLotExporter(String id);
	
	//Service Parcelle
	public void AddParcelle(ParcelleEntity par);
	public void UpdateParcelle(ParcelleEntity par);
	public ParcelleEntity FindOneParcelle(String id);
	public ParcelleEntity FindOneByParcelle(String MC);
	public List<ParcelleEntity> GetAllParcelle();
	
	public List<ParcelleEntity> getparcellesByetat(String etat);
	public List<ParcelleEntity> GetAllParcellebyprod(String idProd);
	public List<ParcelleEntity> GetAllParcelleSuppress();
	public void DeleteParcelle(String id);
	
	//Service Producteur
	public void AddProducteur(ProducteurEntity pro,ParcelleEntity par);
	public List<ProducteurEntity> GetAllProducteurByEtat();
	public void activerDesactiver(ProducteurEntity pro);
	public void UpdateProducteur(ProducteurEntity pro);
	public ProducteurEntity FindOneProducteur(String id);
	public List<ProducteurEntity> getProducteurByetat(String etat);
	public List<ProducteurEntity> autoComplProducteur(String nomComplet);
	public ProducteurEntity FindOneProducteurBy(String MC);
	public List<ProducteurEntity> GetAllProducteur();
	public void DeleteProducteur(String id);
	
	//Service Region
	public void AddRegion(RegionEntity reg);
	public void UpdateRegion(RegionEntity   reg);
	public List<RegionEntity> GetAllRegion();
	public void DeleteRegion(String id);
	
	//Service Role
	public void addRole(Role r);
	public Role getRole(String role);
	public void updateRole(Role r);
	public List<Role> listerRole();
	
	//Service Trace
	public void addTrace(TraceEntity tr);
	public List<TraceEntity> listalltrace();
	
	//Service Utilisateur
	public void AddUtilisateur(UtilisateurEntity u,UserRole ur);
	public void UpdateUtilisateur(UtilisateurEntity u);
	public UtilisateurEntity FindOneUtilisateur(String id);
	public UtilisateurEntity FindOneUtilisateurBy(String MC);
	public void ChangerPassword(String email, String ancien, String nouveau);
	public List<UtilisateurEntity> GetAllUtilisateur();
	public void DeleteUtilisateur(String id);
	
	//Service Zone
	public void AddZone(ZoneEntity zo);
	public void UpdateZone(ZoneEntity zo);
	public List<ZoneEntity> GetAllZone();
	public void DeleteZone(String id);
	
	
	        //Service nouveau Lot
			public void AddLots(Map<String, Lots_detailsEntity> a,LotsEntity lot);
			public void UpdateLots(LotsEntity lot);
			public LotsEntity FindOneLots(String id);
			public List<LotsEntity> GetAllLots();
			public List<LotsEntity> getAllLotByEtat(String etat);
			
		    	//Service LotsDetails
					public void AddLotdetails(Lots_detailsEntity lotd);
					public void UpdateLotdetails(Lots_detailsEntity lotd);
					public Lots_detailsEntity FindOneLotdetails(String id);
					public List<Lots_detailsEntity> GetAllLotdetails();
					public List<Lots_detailsEntity> GetAllalldetailsbyId(String idlot);
					
					
					
		        //service Message
					public void envoyerMessage(MessageEntity msg);
					public MessageEntity readMessage(Long id);	
					public MessageEntity readMessageRead(Long id);
					public void deleteMessage(Long id);
					public List<MessageEntity>listerMessages(String critere);
					public List<MessageEntity>listerMessages();
					public void repondreClient(String message,String emailTo);
					public void readEmail();
}
