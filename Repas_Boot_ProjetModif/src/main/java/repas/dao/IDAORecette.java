package repas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import repas.model.Recette;

public interface IDAORecette extends JpaRepository<Recette, Integer>{

	@Query("SELECT r from Recette r join r.instructions i where i.id=:id")
	public List<Recette> findAllByInstruction(@Param("id") Integer idInstruction);
	
	// coder RecetteWithInstruction 
	
	@Query("select r from Recette r join r.instructions where r.id=:id")
	public Recette getByIdWithInstruction (@Param("id") Integer idRecette) ; 

}
