package repas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repas.dao.IDAORecette;
import repas.model.Recette;


@Service
public class RecetteService {

	@Autowired
	IDAORecette daoRecette;
	
	public Recette getById(Integer id) 
	{
		Optional<Recette> opt = daoRecette.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		else 
		{
			return opt.get();
		}
	}

	
	public List<Recette> getAll()
	{
		return daoRecette.findAll();
	}
	
	
	/*public List<Recette> getAllByIngredient(Ingredient ingredient)
	{
		return daoRecette.findAllByIngredient();
	}
	*/
	
	
	public Recette insert(Recette recette) 
	{
		return daoRecette.save(recette);
	}
	
	
	public Recette update(Recette recette) 
	{
		if(recette.getId()==null) 
		{
			throw new RuntimeException("Un update sans id ?!");
		}
	
		return daoRecette.save(recette);
	}
	
	public void delete(Recette recette) 
	{
		daoRecette.delete(recette);
	}
	public void deleteById(Integer id) 
	{
		daoRecette.deleteById(id);
	}
	
	public List<Recette> getByIdWithIngredients(Integer id)
	{
	return daoRecette.findAllByIngredient(id);
	}
	
	
}
