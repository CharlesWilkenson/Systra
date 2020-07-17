package com.projetsystra.metier.EJBImpl;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import com.projetsystra.metier.entities.*;
import com.projetsystra.metier.interfaces.ServiceILocal;


@Stateless
public class ServiceEJBImpl implements ServiceILocal{
	@PersistenceContext(name="systraPU")
	private EntityManager em;
	private TraceEntity t=new TraceEntity();
	
	/* @Resource SessionContext securityContext;   
     private String callerId = securityContext.getCallerIdentity().getName() ;*/
	//CommuneEJBImpl*****************************************************************************
	@Override
	public void Addcommune(Commune com) {
		// TODO Auto-generated method stub
		em.persist(com);
	}

	@Override
	public void Updatecommune(Commune com) {
		// TODO Auto-generated method stub
		em.merge(com);
	}



	@Override
	public List<Commune> GetAllcommune() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select com from CommuneEntity com");
		return q.getResultList();
	}

	@Override
	public void Deletecommune(String id) {
		// TODO Auto-generated method stub
		Commune com =em.find(Commune.class, id);
		if(com==null) throw new RuntimeException("Commune Not Found");
		em.remove(id);
	}

	//DepartementEJBImpl*****************************************************************************
	@Override
	public List<Departement> GetAllDepartement() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select dep from Departement dep");
		return q.getResultList();
	}

	@Override
	public List<Commune> GetCommunebyDept(String id) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select com from Commune com where com.departement.IdDepartement=:x");
		q.setParameter("x", id);
		return q.getResultList();
	}
	@Override
	public List<Commune> GetCommunebyDept() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select com from Commune com");
		return q.getResultList();
	}
	
	@Override
	public List<Section_communal> GetSectionbyCom(String id) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select sec from Section_communal sec where sec.commune.IdCommune=:x");
		q.setParameter("x", id);
		return q.getResultList();
	}
	@Override
	public List<Section_communal> GetSectionbyCom() {
		Query q = em.createQuery("select sec from Section_communal sec");
		return q.getResultList();
	}
	//ExportationEJBImpl*****************************************************************************
	@Override
	public void AddExportation(ExportationEntity exp, Map<String, LotExporter> items) {
				em.persist(exp);
				LotsEntity lots=new LotsEntity();
				for(LotExporter lex:items.values())
				{
					lots=em.find(LotsEntity.class, lex.getIdLot().getLotid());
	                LotsEntity lot=new LotsEntity();
                    lot.setLotdate_livraison(lots.getLotdate_livraison());
                    lot.setLotdate_transport(lots.getLotdate_transport());
                    lot.setLotetat("exporté");
                    lot.setFournisseur(new FournisseurEntity(lots.getFournisseur().getFournisseurId()));
					lot.setLotnoplaque(lots.getLotnoplaque());
					lot.setLotqttTotapc(lots.getLotqttTotapc());
					lot.setLotqttTotrecu(lots.getLotqttTotrecu());
					lot.setLottransporteur(lots.getLottransporteur());
                    lot.setLotno(lots.getLotno());
                    lot.setRegion(lots.getRegion());
                    lot.setLotid(lots.getLotid());
                    lex.setIdExportation(exp);
					em.persist(lex);
					em.merge(lot);
				}
				
			/*	TraceEntity tr=new TraceEntity(t.getTraceEmail(), t.getTraceDate(), t.getTraceOperation()+"-"+exp.getIdExportation());
			    em.persist(tr);*/
				
	}

	@Override
	public void UpdateExportation(ExportationEntity exp) {
		em.merge(exp);
	/*	TraceEntity tr=new TraceEntity(t.getTraceEmail(), t.getTraceDate(), t.getTraceOperation());
	    em.persist(tr);*/
	}

	@Override
	public ExportationEntity FindOneExportation(String id) {
		ExportationEntity exp = em.find(ExportationEntity .class, id);
		return exp;
	}

	@Override
	public ExportationEntity FindOneByExportation(String MC) {
		return null;
	}

	@Override
	public List<ExportationEntity> GetAllExportation() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select exp from ExportationEntity exp");
		return q.getResultList();
	}

	@Override
	public void DeleteExportation(String id) {
		// TODO Auto-generated method stub
		ExportationEntity exp =em.find(ExportationEntity.class, id);
		if(exp==null) throw new RuntimeException("expo Not Found");
		em.remove(id);
	}

	//FournisseurEJBImpl*****************************************************************************
	@Override
	public String AddFournisseur(FournisseurEntity fou) {
		em.persist(fou);
	/*	TraceEntity tr=new TraceEntity(t.getTraceEmail(), t.getTraceDate(), t.getTraceOperation()+"-"+fou.getFournisseurId());
	    em.persist(tr);*/
		return "Fournisseur Created";
	}

	@Override
	public void UpdateFournisseur(FournisseurEntity fou) {
		em.merge(fou);
		
		/*TraceEntity tr=new TraceEntity(callerId, new Date(), "Update fournisseur"+"-"+fou.getFournisseurId());
        em.persist(tr);*/
	}

	@Override
	public FournisseurEntity FindOneFournisseur(String id) {
		// TODO Auto-generated method stub
		FournisseurEntity  fou = em.find(FournisseurEntity.class, id);
		//if(fou == null) throw new RuntimeException("Fournisseur introuvable");
			return fou;
	}

	@Override
	public FournisseurEntity FindOneByFournisseur(String MC) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FournisseurEntity> GetAllFournisseur() {
		// TODO Auto-generated method stub
		//Query q = em.createQuery("select fou from FournisseurEntity fou");
		StoredProcedureQuery q=em.createNamedStoredProcedureQuery("getAllFournisseur");
		return q.getResultList();
	}
	
	@Override
	public List<FournisseurEntity> getFournisseurByetat(String etat) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("SELECT fou FROM FournisseurEntity fou WHERE fou.FournisseurEtat=:x");
		q.setParameter("x", etat);
		return q.getResultList();
	}

	@Override
	public void DeleteFournisseur(String id) {
		// TODO Auto-generated method stub
		FournisseurEntity fou =em.find(FournisseurEntity.class, id);
		if(fou==null) throw new RuntimeException("Fourn Not Found");
		em.remove(fou);
	}

		
	//LotExporterEJBImpl*****************************************************************************
	@Override
	public void AddLotExporter(LotExporter lex) {
		em.persist(lex);
	/*	TraceEntity tr=new TraceEntity(t.getTraceEmail(), t.getTraceDate(), t.getTraceOperation());
	    em.persist(tr);*/
	}

	@Override
	public void UpdateLotExporter(LotExporter lex) {
		em.merge(lex);
		/*TraceEntity tr=new TraceEntity(t.getTraceEmail(), t.getTraceDate(), t.getTraceOperation());
	    em.persist(tr);*/
	}

	@Override
	public LotExporter FindOneLotExporter(String id) {
		// TODO Auto-generated method stub
		LotExporter lex = em.find(LotExporter.class, id);
		return lex;
	}

	@Override
	public LotExporter FindOneByLotExporter(String MC) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LotExporter> GetAllLotExporter() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select lex from LotExporter lex");
		return q.getResultList();
	}

	@Override
	public List<LotExporter> GetAllLotExporterbyCodeExpo(String codeexpo) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select lex from LotExporter lex where lex.idExportation.idExportation=:x");
		q.setParameter("x", codeexpo);
		 List<LotExporter> listexpo=q.getResultList();
		 return listexpo;
	}

	@Override
	public void DeleteLotExporter(String id) {
		// TODO Auto-generated method stub
		LotExporter lex =em.find(LotExporter.class, id);
		em.remove(id);
	}
	
	//ParcelleEJBImpl*****************************************************************************
	@Override
	public void AddParcelle(ParcelleEntity par) {
em.persist(par);
/*TraceEntity tr=new TraceEntity(t.getTraceEmail(), t.getTraceDate(), t.getTraceOperation()+"-"+par.getParcelleId());
em.persist(tr);*/
	}

	@Override
	public void UpdateParcelle(ParcelleEntity par) {
em.merge(par);
/*TraceEntity tr=new TraceEntity(t.getTraceEmail(), t.getTraceDate(), t.getTraceOperation()+"-"+par.getParcelleId());
em.persist(tr);*/
	}

	@Override
	public ParcelleEntity FindOneParcelle(String id) {
	
		ParcelleEntity par = em.find(ParcelleEntity.class, id);
		return par;
	}

	@Override
	public ParcelleEntity FindOneByParcelle(String MC) {
	
		return null;
	}

	@Override
	public List<ParcelleEntity> GetAllParcelle() {
		int lon=12;
		int lat=11;
		Query q = em.createQuery("select par from ParcelleEntity par WHERE par.ParcelleEtat=:x AND"
				+ " LENGTH(par.ParcellePointLatitude1)=:y1 AND"
				+ " LENGTH(par.ParcellePointLatitude2)=:y2 AND"
				+ " LENGTH(par.ParcellePointLatitude3)=:y3 AND"
				+ " LENGTH(par.ParcellePointLatitude4)=:y4 AND"
				+ " LENGTH(par.ParcellePointLongitude1)=:y5 AND"
				+ " LENGTH(par.ParcellePointLongitude2)=:y6 AND"
				+ " LENGTH(par.ParcellePointLongitude3)=:y7 AND"
				+ " LENGTH(par.ParcellePointLongitude4)=:y8");
		q.setParameter("x", "Actif");
		q.setParameter("y1", lat);
		q.setParameter("y2", lat);
		q.setParameter("y3", lat);
		q.setParameter("y4", lat);
		q.setParameter("y5", lon);
		q.setParameter("y6", lon);
		q.setParameter("y7", lon);
		q.setParameter("y8", lon);

		//StoredProcedureQuery q=em.createNamedStoredProcedureQuery("GetAllParcelle");		
		return q.getResultList();
	}


	@Override
	public List<ParcelleEntity> getparcellesByetat(String etat) {
		
		Query q = em.createQuery("select par from ParcelleEntity par WHERE par.ParcelleEtat=:x");
		q.setParameter("x", etat);
		return q.getResultList();
	}

	@Override
	public List<ParcelleEntity> GetAllParcellebyprod(String idProd) {
		
	     //Query q = em.createQuery("select par from ParcelleEntity par WHERE par.producteur.ProducteurId=:x");
		//q.setParameter("x", idProd);
		StoredProcedureQuery q=em.createNamedStoredProcedureQuery("GetAllParcellebyprod");
		q.setParameter("idprod", idProd);
		
		return q.getResultList();
	}

	@Override
	public List<ParcelleEntity> GetAllParcelleSuppress() {
		
		Query q = em.createQuery("select par from ParcelleEntity par WHERE par.ParcelleEtat=:x");
		q.setParameter("x", "Passif");
		return q.getResultList();
	}

	@Override
	public void DeleteParcelle(String id) {
		
		ParcelleEntity par =em.find(ParcelleEntity.class, id);
		if(par==null) throw new RuntimeException("Parcelle Not Found");
		em.remove(par);
	}

	//ProducteurEJBImpl*****************************************************************************
	@Override
	public void AddProducteur(ProducteurEntity pro,ParcelleEntity par) {
		
		em.persist(pro);
		em.persist(par);
		/*TraceEntity tr=new TraceEntity(t.getTraceEmail(), t.getTraceDate(), t.getTraceOperation()+"-"+pro.getProducteurId());
	    em.persist(tr);*/
	}

	@Override
	public void UpdateProducteur(ProducteurEntity pro) {
		
		em.merge(pro);
		/*TraceEntity tr=new TraceEntity(t.getTraceEmail(), t.getTraceDate(), t.getTraceOperation()+"-"+pro.getProducteurId());
	    em.persist(tr);*/
	}
	@Override
	public void activerDesactiver(ProducteurEntity pro) {
		ParcelleEntity pa=new ParcelleEntity();
		ProducteurEntity p=em.find(ProducteurEntity.class, pro.getProducteurId());
		Query q = em.createQuery("select par from ParcelleEntity par WHERE par.producteur.ProducteurId=:x");
		q.setParameter("x", pro.getProducteurId());
		List<ParcelleEntity>lst=  q.getResultList();
		if(p.getProducteurEtat().equals("Actif")){
			pro.setProducteurEtat("Passif");
			pro.setProducteurNomComplet(p.getProducteurNomComplet());
			pro.setProducteurSexe(p.getProducteurSexe());
			pro.setProducteurTelephone(p.getProducteurTelephone());
		
			em.merge(pro);
			for(ParcelleEntity par:lst){
			
			pa.setParcelleEtat("Passif");	
			pa.setParcelleId(par.getParcelleId()); 
			pa.setProducteur(new ProducteurEntity(p.getProducteurId())); 
			pa.setParcelleCommune(par.getParcelleCommune()); 
			pa.setParcelleSectioncommunale(par.getParcelleSectioncommunale());
			 pa.setParcelleLocalite(par.getParcelleLocalite()); 
			 pa.setParcelleMarndr(par.getParcelleMarndr());
			 pa.setParcelleRegimeFoncier(par.getParcelleRegimeFoncier()); 
			 pa.setParcelleTypeCulture(par.getParcelleTypeCulture());
			 pa.setParcelleFertilisationChimique(par.getParcelleFertilisationChimique()); 
			 pa.setParcelleFertilisationOrganique(par.getParcelleFertilisationOrganique());
			 pa.setParcellePresenceElevage(par.getParcellePresenceElevage());
			 pa.setParcelleTypeElevage(par.getParcelleTypeElevage()); 
			 pa.setParcellePresenceLatrine(par.getParcellePresenceLatrine());
			 pa.setParcellePointLatitudeLatrine(par.getParcellePointLatitudeLatrine()); 
			 pa.setParcellePointLongitudeLatrine(par.getParcellePointLongitudeLatrine());
			 pa.setParcelleTypeTraitrementPhytosanitaire(par.getParcelleTypeTraitrementPhytosanitaire());
			 pa.setParcelleProblemeInondation(par.getParcelleProblemeInondation()); 
			 pa.setParcelleFrequenceInondation(par.getParcelleFrequenceInondation());
			 pa.setParcellePlanteHote(par.getParcellePlanteHote()); 
			 pa.setParcelleAgePlantation(par.getParcelleAgePlantation());
			 pa.setParcelleNbreManguier(par.getParcelleNbreManguier()); 
			 pa.setParcelleNbreManguierEnProduction(par.getParcelleNbreManguierEnProduction());
			 pa.setParcelleProductionAnnuelleMangue(par.getParcelleProductionAnnuelleMangue());
			 pa.setParcelleParcIrrigue(par.getParcelleParcIrrigue());
			 pa.setParcelleTypeEau(par.getParcelleTypeEau()); 
			 pa.setParcelleCommercialisation(par.getParcelleCommercialisation()); 
			 pa.setParcellePointLatitude1(par.getParcellePointLatitude1());
			 pa.setParcellePointLongitude1(par.getParcellePointLongitude1());
			 pa.setParcellePointLatitude2(par.getParcellePointLatitude2()); 
			 pa.setParcellePointLongitude2(par.getParcellePointLongitude2());
			 pa.setParcellePointLatitude3(par.getParcellePointLatitude3());
			 pa.setParcellePointLongitude3(par.getParcellePointLongitude3());
			 pa.setParcellePointLatitude4(par.getParcellePointLatitude4());
			 pa.setParcellePointLongitude4(par.getParcellePointLatitude4()); 
			 pa.setParcelleSuperficie(par.getParcelleSuperficie());
			 em.merge(pa);	
			}	
		/*	TraceEntity tr=new TraceEntity(t.getTraceEmail(), t.getTraceDate(), t.getTraceOperation()+"-"+pro.getProducteurId());
		    em.persist(tr);*/
		}
		else{
			
			
			pro.setProducteurEtat("Actif");
			pro.setProducteurNomComplet(p.getProducteurNomComplet());
			pro.setProducteurSexe(p.getProducteurSexe());
			pro.setProducteurTelephone(p.getProducteurTelephone());
			em.merge(pro);
			for(ParcelleEntity par:lst){
			
			pa.setParcelleEtat("Actif");	
			pa.setParcelleId(par.getParcelleId()); 
			pa.setProducteur(new ProducteurEntity(p.getProducteurId())); 
			pa.setParcelleCommune(par.getParcelleCommune()); 
			pa.setParcelleSectioncommunale(par.getParcelleSectioncommunale());
			 pa.setParcelleLocalite(par.getParcelleLocalite()); 
			 pa.setParcelleMarndr(par.getParcelleMarndr());
			 pa.setParcelleRegimeFoncier(par.getParcelleRegimeFoncier()); 
			 pa.setParcelleTypeCulture(par.getParcelleTypeCulture());
			 pa.setParcelleFertilisationChimique(par.getParcelleFertilisationChimique()); 
			 pa.setParcelleFertilisationOrganique(par.getParcelleFertilisationOrganique());
			 pa.setParcellePresenceElevage(par.getParcellePresenceElevage());
			 pa.setParcelleTypeElevage(par.getParcelleTypeElevage()); 
			 pa.setParcellePresenceLatrine(par.getParcellePresenceLatrine());
			 pa.setParcellePointLatitudeLatrine(par.getParcellePointLatitudeLatrine()); 
			 pa.setParcellePointLongitudeLatrine(par.getParcellePointLongitudeLatrine());
			 pa.setParcelleTypeTraitrementPhytosanitaire(par.getParcelleTypeTraitrementPhytosanitaire());
			 pa.setParcelleProblemeInondation(par.getParcelleProblemeInondation()); 
			 pa.setParcelleFrequenceInondation(par.getParcelleFrequenceInondation());
			 pa.setParcellePlanteHote(par.getParcellePlanteHote()); 
			 pa.setParcelleAgePlantation(par.getParcelleAgePlantation());
			 pa.setParcelleNbreManguier(par.getParcelleNbreManguier()); 
			 pa.setParcelleNbreManguierEnProduction(par.getParcelleNbreManguierEnProduction());
			 pa.setParcelleProductionAnnuelleMangue(par.getParcelleProductionAnnuelleMangue());
			 pa.setParcelleParcIrrigue(par.getParcelleParcIrrigue());
			 pa.setParcelleTypeEau(par.getParcelleTypeEau()); 
			 pa.setParcelleCommercialisation(par.getParcelleCommercialisation()); 
			 pa.setParcellePointLatitude1(par.getParcellePointLatitude1());
			 pa.setParcellePointLongitude1(par.getParcellePointLongitude1());
			 pa.setParcellePointLatitude2(par.getParcellePointLatitude2()); 
			 pa.setParcellePointLongitude2(par.getParcellePointLongitude2());
			 pa.setParcellePointLatitude3(par.getParcellePointLatitude3());
			 pa.setParcellePointLongitude3(par.getParcellePointLongitude3());
			 pa.setParcellePointLatitude4(par.getParcellePointLatitude4());
			 pa.setParcellePointLongitude4(par.getParcellePointLatitude4()); 
			 pa.setParcelleSuperficie(par.getParcelleSuperficie());
			em.merge(pa);	
			}
			/*TraceEntity tr=new TraceEntity(t.getTraceEmail(), t.getTraceDate(), t.getTraceOperation()+"-"+pro.getProducteurId());
		    em.persist(tr);*/
		}
		
		
		
		
	}
	@Override
	public ProducteurEntity FindOneProducteur(String id) {
		// TODO Auto-generated method stub
		ProducteurEntity pro = em.find(ProducteurEntity.class, id);
		return pro;
	}

	@Override
	public ProducteurEntity FindOneProducteurBy(String MC) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProducteurEntity> GetAllProducteur(){
	//Query q = em.createQuery("select pro from ProducteurEntity pro");
		StoredProcedureQuery q=
		em.createNamedStoredProcedureQuery("getAllProductors");
        return q.getResultList();	
	}

	@Override
	public List<ProducteurEntity> getProducteurByetat(String etat) {
		Query q = em.createQuery("select pro from ProducteurEntity pro where pro.ProducteurEtat=:x");
		q.setParameter("x", etat);
		return q.getResultList();
	}
	
	
	@Override
	public List<ProducteurEntity> autoComplProducteur(String nomComplet) {
		Query q = em.createQuery("select pro from ProducteurEntity pro where pro.ProducteurNomComplet=:x OR pro.");
		q.setParameter("x", nomComplet);	      
		return q.getResultList();
	}
	
	@Override
	public List<ProducteurEntity> GetAllProducteurByEtat() {
		//Query q = em.createQuery("select pro from ProducteurEntity pro where pro.ProducteurEtat=:x");
		//q.setParameter("x", "Actif");
	StoredProcedureQuery q=em.createNamedStoredProcedureQuery("getAllProductorsByEtat");
		   
		return q.getResultList();
	}

	@Override
	public void DeleteProducteur(String id) {
		// TODO Auto-generated method stub
		ProducteurEntity pro =em.find(ProducteurEntity.class, id);
		if(pro==null) throw new RuntimeException("Producteur Not Found");
		em.remove(pro);
	}
	
	//RegionEJBImpl*****************************************************************************
	@Override
	public void AddRegion(RegionEntity reg) {
		em.persist(reg);
	}

	@Override
	public void UpdateRegion(RegionEntity reg) {
		// TODO Auto-generated method stub
		em.merge(reg);
	}

	@Override
	public List<RegionEntity> GetAllRegion() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select reg from RegionEntity reg");
		return q.getResultList();
	}

	@Override
	public void DeleteRegion(String id) {
		// TODO Auto-generated method stub
		RegionEntity reg =em.find(RegionEntity.class, id);
		if(reg==null) throw new RuntimeException("Region Not Found");
		em.remove(id);
	}
	
	//ROleEJBImpl*****************************************************************************
	@Override
	public void addRole(Role r) {
		// TODO Auto-generated method stub
		em.persist(r);
	}

	@Override
	public Role getRole(String role) {
		// TODO Auto-generated method stub
		Role r=em.find(Role.class, role);
		return r;
	}

	@Override
	public void updateRole(Role r) {
		// TODO Auto-generated method stub
		em.merge(r);
	}

	@Override
	public List<Role> listerRole() {
		// TODO Auto-generated method stub
		Query req=em.createQuery("SELECT r FROM Role r");
		List<Role> list=req.getResultList();
			return list;
	}

	//TraceEJBImpl*****************************************************************************
	@Override
	public void addTrace(TraceEntity tr) {
		// TODO Auto-generated method stub
		em.persist(tr);
	}

	@Override
	public List<TraceEntity> listalltrace() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select t from TraceEntity t");
		return q.getResultList();
	}

	//UtilisateurEJBImpl*****************************************************************************
	@Override
	public void AddUtilisateur(UtilisateurEntity u, UserRole ur) {
	
		boolean result=SendEmail.sendEmail(u.getUtilisateurMotdepasse(), u.getUtilisateurEmail());
	if(result==false){
		
		
	}else{
		
		u.setUtilisateurMotdepasse(HashPassword.hashPassword(u.getUtilisateurMotdepasse()));
		/*	u.setiDuserRole(ur);*/
			em.persist(u);
			em.persist(ur);	
	}
	
		
	}

	@Override
	public void UpdateUtilisateur(UtilisateurEntity u) {
		em.merge(u);
		TraceEntity tr=new TraceEntity(t.getTraceEmail(), t.getTraceDate(), t.getTraceOperation()+"-"+u.getUtilisateurEmail());
	    em.persist(tr);
	}

	@Override
	public UtilisateurEntity FindOneUtilisateur(String id) {
		// TODO Auto-generated method stub
		UtilisateurEntity u = em.find(UtilisateurEntity.class, id);
		return u;
	}

	@Override
	public UtilisateurEntity FindOneUtilisateurBy(String MC) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ChangerPassword(String email, String ancien, String nouveau) {
		// TODO Auto-generated method stub
		UtilisateurEntity u=em.find(UtilisateurEntity.class, email);
		u.setUtilisateurMotdepasse(HashPassword.hashPassword(nouveau));
		u.setUtilisateurAdresse(u.getUtilisateurAdresse());
		u.setUtilisateurFonction(u.getUtilisateurFonction());
		u.setUtilisateurNom(u.getUtilisateurNom());
		u.setUtilisateurPrenom(u.getUtilisateurPrenom());
		u.setUtilisateurTelephone(u.getUtilisateurTelephone());
		u.setUtilisateurEtatcompte(u.getUtilisateurEtatcompte());
		u.setUtilisateurSexe(u.getUtilisateurSexe());
		em.merge(u);
		TraceEntity tr=new TraceEntity(t.getTraceEmail(), t.getTraceDate(), t.getTraceOperation());
	    em.persist(tr);
	}

	@Override
	public List<UtilisateurEntity> GetAllUtilisateur() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select u from UtilisateurEntity u");
		return q.getResultList();
	}

	@Override
	public void DeleteUtilisateur(String id) {
		// TODO Auto-generated method stub
		UtilisateurEntity u =em.find(UtilisateurEntity.class, id);
		if(u==null) throw new RuntimeException("Utilisateur Not Found");
		em.remove(u);
	}

	//ZoneEJBImpl*****************************************************************************
	@Override
	public void AddZone(ZoneEntity zo) {
		// TODO Auto-generated method stub
		em.persist(zo);
	}

	@Override
	public void UpdateZone(ZoneEntity zo) {
		// TODO Auto-generated method stub
		em.merge(zo);
	}

	@Override
	public List<ZoneEntity> GetAllZone() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select zone from ZoneEntity zone");
		return q.getResultList();
	}

	@Override
	public void DeleteZone(String id) {
		// TODO Auto-generated method stub
		ZoneEntity zone =em.find(ZoneEntity.class, id);
		if(zone==null) throw new RuntimeException("Zone Not Found");
		em.remove(zone);
	}
	
	
	//AchatEJBImpl*****************************************************************************
	  //Service Nouvel Achats************************************************************
	    @Override
	    public void Addachats(AchatsEntity ach)
		{
			em.persist(ach);
			TraceEntity tr=new TraceEntity(t.getTraceEmail(), t.getTraceDate(), t.getTraceOperation());
		    em.persist(tr);
		}
	    @Override
		public void Updateachats(AchatsEntity ach)
		{
			em.merge(ach);
			TraceEntity tr=new TraceEntity(t.getTraceEmail(), t.getTraceDate(), t.getTraceOperation());
		    em.persist(tr);
		}
	    @Override
		public AchatsEntity  FindOneachats(String id)
		{
			AchatsEntity ach = em.find(AchatsEntity.class, id);
			return ach;
		}
	    @Override
		public List<AchatsEntity> GetAllachats()
		{
			// TODO Auto-generated method stub
			Query q = em.createQuery("select ach from AchatsEntity ach where ach.AchatEtat=:x");
			q.setParameter("x", "non livré");
	    	//StoredProcedureQuery q=em.createNamedStoredProcedureQuery("getAllAchats");
			return q.getResultList();	
		}
	    
	    @Override
  		public List<AchatsEntity> GetAllachats(String codeAchat)
  		{
  			// TODO Auto-generated method stub
  			Query q = em.createQuery("select ach from AchatsEntity ach where ach.AchatId=:x");
  			q.setParameter("x", codeAchat);
  			return q.getResultList();	
  		}
	    @Override
	    public List<AchatsEntity> GetAllachatsbylot(String idlot) {
			// TODO Auto-generated method stub
			//Query q = em.createQuery("select fou from FournisseurEntity fou");
	    	StoredProcedureQuery q=em.createNamedStoredProcedureQuery("GetAllAchatbyLot");
			q.setParameter("lotid", idlot);
			
			return q.getResultList();
		}
	    @Override
	  		public List<AchatsEntity> GetAllachatsbyfourn( String idfourn)
	  		{
	  			// TODO Auto-generated method stub
	  			Query q = em.createQuery("select ach from AchatsEntity ach where ach.AchatEtat='non livré' and ach.fournisseur.FournisseurId =:x");
	  			q.setParameter("x", idfourn);
	  			return q.getResultList();	
	  		}

	    
	    @Override
		public List<AchatsEntity> achatsNonLivreFourn(String codeFournisseur)
		{
		
			Query q = em.createQuery("select ach from AchatsEntity ach where ach.AchatEtat=:x AND  ach.fournisseur.FournisseurId=:y");
			q.setParameter("x", "non livré");
			q.setParameter("y", codeFournisseur);
			
	    //	StoredProcedureQuery q=em.createNamedStoredProcedureQuery("getAllAchatsByFourn");
			//q.setParameter("idfourn", codeFournisseur);
			return q.getResultList();	
		}
	    
		@Override
		public List<AchatsEntity> getAllachatsByEtat(String etat) {
			Query q = em.createQuery("select ach from AchatsEntity ach where ach.AchatEtat=:x");
			q.setParameter("x", etat);					
	    //	StoredProcedureQuery q=em.createNamedStoredProcedureQuery("getAllAchatsByFourn");
			//q.setParameter("idfourn", codeFournisseur);
			return q.getResultList();
		}
	 
	//LotEJBImpl*****************************************************************************
		public void AddLots(Map<String, Lots_detailsEntity> items,LotsEntity lots){
			AchatsEntity achs=new AchatsEntity();
			em.persist(lots);
			
			for(Lots_detailsEntity l:items.values())
			{
				l.setLot(lots);
				achs=em.find(AchatsEntity.class, l.getAchats().getAchatId());
				AchatsEntity a=new AchatsEntity();
				a.setAchatId(achs.getAchatId());
				a.setAchatDate(achs.getAchatDate());
				a.setAchatEtat("livré");
				a.setAchatPrix(achs.getAchatPrix());
				a.setAchatQtTotal(achs.getAchatQtTotal());
				a.setProducteur(new ProducteurEntity(achs.getProducteur().getProducteurId()));
				a.setFournisseur(new FournisseurEntity(achs.getFournisseur().getFournisseurId()));
				a.setRegion(new RegionEntity(achs.getRegion().getRegionId()));
				a.setParcelle(new ParcelleEntity(achs.getParcelle().getParcelleId()));
				em.persist(l);
				em.merge(a);
			}
			TraceEntity tr=new TraceEntity(t.getTraceEmail(), t.getTraceDate(), t.getTraceOperation());
		    em.persist(tr);
		}
		public void UpdateLots(LotsEntity lot){
			em.merge(lot);
			TraceEntity tr=new TraceEntity(t.getTraceEmail(), t.getTraceDate(), t.getTraceOperation());
		    em.persist(tr);
		}
		public LotsEntity FindOneLots(String id){
			// TODO Auto-generated method stub
			LotsEntity lots = em.find(LotsEntity.class, id);
		//	if(lots == null) throw new RuntimeException("Lot introuvable");
			return lots;
		}
		public List<LotsEntity> GetAllLots(){
			
			Query q = em.createQuery("select lots from LotsEntity lots WHERE lots.lotetat=:x");
			q.setParameter("x", "non exporté");
			//StoredProcedureQuery q=em.createNamedStoredProcedureQuery("getAllLots");
			return q.getResultList();
		}

	//Nouveau LotsDetails EJBImpl*****************************************************************************
	@Override
	public void AddLotdetails(Lots_detailsEntity lotd){
		em.persist(lotd);
		TraceEntity tr=new TraceEntity(t.getTraceEmail(), t.getTraceDate(), t.getTraceOperation());
	    em.persist(tr);
	}
	@Override
	public void UpdateLotdetails(Lots_detailsEntity lotd){
		em.merge(lotd);
		TraceEntity tr=new TraceEntity(t.getTraceEmail(), t.getTraceDate(), t.getTraceOperation());
	    em.persist(tr);
	}
	@Override
	public Lots_detailsEntity FindOneLotdetails(String id){
		Lots_detailsEntity lotd = em.find(Lots_detailsEntity.class, id);
		if(lotd == null) throw new RuntimeException("Details Lot introuvable");
		return lotd;
	}
	@Override
	public List<Lots_detailsEntity> GetAllLotdetails(){
		Query q = em.createQuery("select lotd from Lots_detailsEntity lotd");
		return q.getResultList();
	}
	@Override
	public List<Lots_detailsEntity> GetAllalldetailsbyId(String idlot)
	{
		Query q = em.createQuery("select lotd from Lots_detailsEntity lotd where lotd.Lot.Lotid=:x");
		q.setParameter("x", idlot);
		return q.getResultList();
	}

	@Override
	public List<LotsEntity> getAllLotByEtat(String etat) {
		Query q = em.createQuery("select lotd from LotsEntity lotd where lotd.lotetat=:x");
		q.setParameter("x", etat);
		return q.getResultList();
	}
	
	@Override
	public Commune getCommune(String id) {
		
		return em.find(Commune.class,id);
	}

	@Override
	public Section_communal getSection(String id) {
		// TODO Auto-generated method stub
		return em.find(Section_communal.class, id);
	}

	@Override
	public void AddAchats(Map<String, AchatsEntity> a) {
		TraceEntity tr=new TraceEntity();
		for(AchatsEntity ach:a.values()){
			em.persist(ach);
			
		}
		
	}

	@Override
	public void envoyerMessage(MessageEntity msg) {
		em.persist(msg);
		
	}

	@Override
	public MessageEntity readMessage(Long id) {
	MessageEntity msg=em.find(MessageEntity.class, id);
	MessageEntity message=new MessageEntity();
	message.setId(msg.getId());
	message.setDate(msg.getDate());
	message.setEmail(msg.getEmail());
	message.setEtat("lu");
	message.setNomComplet(msg.getNomComplet());
	message.setMessage(msg.getMessage());
	em.merge(message);
		return msg;
	}

	@Override
	public void deleteMessage(Long id) {
		MessageEntity msg=em.find(MessageEntity.class, id);
		if(msg!=null){
			
			em.remove(msg);	
		}
		
		
	}

	@Override
	public List<MessageEntity> listerMessages( String critere) {
		Query q = em.createQuery("SELECT msg FROM MessageEntity msg WHERE msg.etat=:x");	
		q.setParameter("x", critere);
		return q.getResultList();
	}

	@Override
	public List<MessageEntity> listerMessages() {
		Query q = em.createQuery("SELECT msg FROM MessageEntity msg");	
		return q.getResultList();
	}

	@Override
	public MessageEntity readMessageRead(Long id) {
		MessageEntity msg=em.find(MessageEntity.class, id);
			return msg;
	}

	@Override
	public void repondreClient(String message,String emailTo) {
		
	SendEmail.repondreClient(message, emailTo);	
	}

	@Override
	public void readEmail() {
		ReadEmail.getMails();
		
	}



}



	


