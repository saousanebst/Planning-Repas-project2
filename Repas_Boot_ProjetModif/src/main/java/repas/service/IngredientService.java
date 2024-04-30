package repas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repas.dao.IDAOIngredient;
import repas.model.Ingredient;
import repas.model.Instruction;
import repas.model.Recette;


@Service
public class IngredientService {

	@Autowired
	IDAOIngredient daoIngredient;
	
	public Ingredient getById(Integer id) 
	{
		Optional<Ingredient> opt = daoIngredient.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		else 
		{
			return opt.get();
		}
	}
	
	

	
	public List<Ingredient> getAll()
	{
		return daoIngredient.findAll();
	}
	
	

	
	public Ingredient insert(Ingredient ingredient) 
	{
		return daoIngredient.save(ingredient);
	}
	
	
	public Ingredient update(Ingredient ingredient) 
	{
		if(ingredient.getId()==null) 
		{
			throw new RuntimeException("Un update sans id ?!");
		}
	
		return daoIngredient.save(ingredient);
	}
	
	
	public void deleteById(Integer id) 
	{
		daoIngredient.deleteById(id);
	}
	
	
	/*public List<Instruction> getByIdWithInstruction(Integer id)
	{
		return daoIngredient.findAllByInstruction(id);
	}*/
	public Ingredient getByIdWithInstruction(Integer id)
	{
		return daoIngredient.findAllByInstruction(id);
	}
}
