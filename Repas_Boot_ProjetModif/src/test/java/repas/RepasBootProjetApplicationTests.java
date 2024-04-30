package repas;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import repas.dao.IDAOCompte;
import repas.dao.IDAOIngredient;
import repas.dao.IDAORecette;
import repas.model.Ingredient;
import repas.model.Recette;

@SpringBootTest
class RepasBootProjetApplicationTests {

	@Autowired
	IDAORecette recetteSrv;
	
	@Autowired
	IDAOIngredient ingredientSrv;
	
	@Autowired
	IDAOCompte userSrv;
	
	@Test
	void contextLoads() {
		
		// Création de la liste d'ingrédients pour la recette
        List<Ingredient> ingredients = new ArrayList<>();
        
        Ingredient ingredient1 = new Ingredient("Pâte à pizza");
        Ingredient ingredient2 = new Ingredient("Sauce tomate");
        

        // Ajoutez les ingrédients à la liste
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        
        ingredient1 = ingredientSrv.save(ingredient1);
        

        // Création de la recette avec le nom "Pizza" et la liste d'ingrédients
        Recette entree1 = new Recette("Pizza");
		
		
		
		
		
	}

}
