package repas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import repas.model.Repas;

public interface IDAORepas extends JpaRepository<Repas, Integer>{

	//@Query("SELECT f from food f where f.ingredient.id=:id")
	//public List<Repas> findAllByIngredient(@Param("id") Integer idIngredient);
	
}
