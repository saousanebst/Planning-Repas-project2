package repas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import repas.model.Repas;

public interface IDAORepas extends JpaRepository<Repas, Integer>{

	@Query("from Repas")
	public List<Repas> findAllRepas();
	
	@Query("SELECT r from Repas r join r.recettes rec join rec.ingredients i where i.id=:id")
	public List<Repas> findAllByIngredient(@Param("id") Integer idIngredient);
	
}
