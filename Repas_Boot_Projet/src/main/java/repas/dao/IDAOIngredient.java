package repas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import repas.model.Ingredient;

public interface IDAOIngredient extends JpaRepository<Ingredient, Integer>{

	public List<Ingredient> findAllByLibelleContaining(String nom);
	
	
}
