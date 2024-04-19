package repas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repas.dao.IDAOCompte;
import repas.model.Compte;
import repas.model.Utilisateur;

@Service
public class UtilisateurService {

	@Autowired
	IDAOCompte daoCompte;
	
	//le get by id
	
	public Utilisateur getById(Integer id) 
	{
		Optional<Compte> opt = daoCompte.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		else 
		{
			return (Utilisateur) opt.get();
		}
	}

	
	//le get all 
	
	public List<Utilisateur> getAll()
	{
		return daoCompte.findAllUtilisateur();
	}
	
	
	//l'insert
	
	public Utilisateur insert(Utilisateur utilisateur) 
	{
		return daoCompte.save(utilisateur);
	}
	
	//l'update
	public Utilisateur update(Utilisateur utilisateur) 
	{
		if(utilisateur.getId()==null) 
		{
			throw new RuntimeException("Un update sans id ?!");
		}
		return daoCompte.save(utilisateur);
	}
	
	//update partiel
	
	
	/*public Utilisateur(String nom, String prenom, String email, String password) {
		super(nom, prenom, email, password);*/
	
	public Utilisateur updatePartiel(Utilisateur utilisateurJSON) 
	{
		if(utilisateurJSON.getId()==null) 
		{
			throw new RuntimeException("Un update sans id ?!");
		}
		Optional<Compte> opt = daoCompte.findById(utilisateurJSON.getId());
		if(opt.isPresent()) {
			Utilisateur utilisateurBdd = (Utilisateur) opt.get();
			
			if(utilisateurJSON.getNom()!=null) 
			{
				utilisateurBdd.setNom(utilisateurJSON.getNom());
			}
			
			if(utilisateurJSON.getPrenom()!=null) 
			{
				utilisateurBdd.setPrenom(utilisateurJSON.getPrenom());
			}
			
			if(utilisateurJSON.getEmail()!=null) 
			{
				utilisateurBdd.setEmail(utilisateurJSON.getEmail());
			}
			
			if(utilisateurJSON.getPassword()!=null) 
			{
				utilisateurBdd.setPassword(utilisateurJSON.getPassword());
			}
			
			return daoCompte.save(utilisateurBdd);
		}
		else 
		{
			return null;
		}
		
		
	}
	
	
	//delete utilisateur
	
	public void delete(Utilisateur utilisateur) 
	{
		daoCompte.delete(utilisateur);
	}
	public void deleteById(Integer id) 
	{
		daoCompte.deleteById(id);
	}
	
	
}
