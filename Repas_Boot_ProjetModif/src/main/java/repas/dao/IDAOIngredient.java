package repas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import repas.model.Ingredient;
import repas.model.Instruction;
import repas.model.Recette;

public interface IDAOIngredient extends JpaRepository<Ingredient, Integer>{

	public List<Ingredient> findAllByNomContaining(String nom);
	
	@Query("select i from Repas r join r.recettes rec join rec.ingredients i where r.id = ?1")
	public List<Ingredient> findAllByRepas(Integer idRepas);
	
	// coder findAllByInstruction
	@Query("SELECT r from Ingredient r join r.instructions i where i.id=:id")
	public List<Instruction> findAllByInstruction(@Param("id") Integer idInstruction);
	
}
