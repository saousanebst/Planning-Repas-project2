package repas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import repas.model.Recette;

public interface IDAORecette extends JpaRepository<Recette, Integer>{

	@Query("SELECT r from Recette r join r.ingredients i where i.id=:id")
	public List<Recette> findAllByIngredient(@Param("id") Integer idIngredient);
	
	//rajouter la méthode : getByIdWithIngredients


}
