package repas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repas.dao.IDAOCompte;
import repas.model.Administrateur;
import repas.model.Compte;


@Service
public class AdministrateurService {

	@Autowired
	IDAOCompte daoCompte;
	
	//le get by id
	
	public Administrateur getById(Integer id) 
	{
		Optional<Compte> opt = daoCompte.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		else 
		{
			return (Administrateur) opt.get();
		}
	}

	
	//le get all 
	
	public List<Administrateur> getAll()
	{
		return daoCompte.findAllAdministrateur();
	}
	
	
	//l'insert
	
	public Administrateur insert(Administrateur administrateur) 
	{
		return daoCompte.save(administrateur);
	}
	
	//l'update
	public Administrateur update(Administrateur administrateur) 
	{
		if(administrateur.getId()==null) 
		{
			throw new RuntimeException("Un update sans id ?!");
		}
		return daoCompte.save(administrateur);
	}
	
	//update partiel
	
	
	
	public Administrateur updatePartiel(Administrateur administrateurJSON) 
	{
		if(administrateurJSON.getId()==null) 
		{
			throw new RuntimeException("Un update sans id ?!");
		}
		Optional<Compte> opt = daoCompte.findById(administrateurJSON.getId());
		if(opt.isPresent()) {
			Administrateur administrateurBdd = (Administrateur) opt.get();
			
			if(administrateurJSON.getNom()!=null) 
			{
				administrateurBdd.setNom(administrateurJSON.getNom());
			}
			
			if(administrateurJSON.getPrenom()!=null) 
			{
				administrateurBdd.setPrenom(administrateurJSON.getPrenom());
			}
			
			if(administrateurJSON.getEmail()!=null) 
			{
				administrateurBdd.setEmail(administrateurJSON.getEmail());
			}
			
			if(administrateurJSON.getPassword()!=null) 
			{
				administrateurBdd.setPassword(administrateurJSON.getPassword());
			}
			
			return daoCompte.save(administrateurBdd);
		}
		else 
		{
			return null;
		}
		
		
	}
	
	
	//delete administrateur
	
	public void delete(Administrateur administrateur) 
	{
		daoCompte.delete(administrateur);
	}
	public void deleteById(Integer id) 
	{
		daoCompte.deleteById(id);
	}
	
	
}
