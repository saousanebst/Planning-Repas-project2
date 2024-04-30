package repas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import repas.model.Instruction;

public interface IDAOInstruction extends JpaRepository<Instruction, Integer>{

//	@Query("SELECT i from Instruction i where i.ingredient.id=:id")
//	public List<Instruction> findAllByIngredient(@Param("id") Integer idIngredient);
	
}
