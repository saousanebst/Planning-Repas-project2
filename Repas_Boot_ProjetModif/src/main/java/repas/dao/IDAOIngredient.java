package repas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import repas.model.Ingredient;

public interface IDAOIngredient extends JpaRepository<Ingredient, Integer>{

	public List<Ingredient> findAllByNomContaining(String nom);
	
	@Query("select i from Repas r join r.recettes rec join rec.ingredients i where r.id = ?1")
	public List<Ingredient> findAllByRepas(Integer idRepas);
}
