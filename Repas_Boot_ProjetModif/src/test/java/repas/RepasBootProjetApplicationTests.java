package repas;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import repas.dao.IDAOCompte;
import repas.dao.IDAOIngredient;
import repas.dao.IDAORecette;
import repas.model.Administrateur;
import repas.model.Compte;
import repas.model.Ingredient;
import repas.model.Instruction;
import repas.model.Recette;
import repas.model.TypeRecette;
import repas.model.Unite;
import repas.model.Utilisateur;

@SpringBootTest
class RepasBootProjetApplicationTests {

	@Autowired
	IDAORecette recetteSrv;
	
	@Autowired
	IDAOIngredient ingredientSrv;
	
	@Autowired
	IDAOCompte utilisateurSrv;
	
	@Autowired
	IDAOCompte administrateurSrv;
	
	@Test
	void contextLoads() {
		
		// Création de la liste d'ingrédients pour la recette
        List<Ingredient> ingredients = new ArrayList<>();
        
        Ingredient ingredient1 = new Ingredient("Pâte à pizza");
        Ingredient ingredient2 = new Ingredient("Sauce tomate");
        Ingredient ingredient3 = new Ingredient("Fromage rapé");
        Ingredient ingredient4 = new Ingredient("Citron");
        Ingredient ingredient5 = new Ingredient("Eau pétillante");
        

        // Ajoutez les ingrédients à la liste      
        ingredient1 = ingredientSrv.save(ingredient1);
        ingredient2 = ingredientSrv.save(ingredient2);
        ingredient3 = ingredientSrv.save(ingredient3);

         //Création de la recette avec le nom "Pizza" et la liste d'ingrédients
        Recette entree1 = new Recette("Pizza",TypeRecette.Entree);
        Recette plat1 = new Recette("Pates",TypeRecette.Plat);
        Recette boisson1 = new Recette("Citronnade",TypeRecette.Boisson);
        Recette dessert1 = new Recette("Tarte au fraise",TypeRecette.Dessert);
		
		//Ajout recettes
        entree1 = recetteSrv.save(entree1);
        plat1 = recetteSrv.save(plat1);
        boisson1 = recetteSrv.save(boisson1);
        dessert1 = recetteSrv.save(dessert1);
        
        // Création de la liste d'instructions pour la recette
        List<Instruction> instructions = new ArrayList();
        
        Instruction instruction1 = new Instruction(entree1, ingredient1,20, Unite.gramme);
        Instruction instruction2 = new Instruction(plat1, ingredient1,20, Unite.gramme);
        Instruction instruction3 = new Instruction(boisson1, ingredient4,20, Unite.gramme);
		
		//Creation de compte
        Utilisateur user1 = new Utilisateur("Bardou", "Hedieh", "test.mail.com", "123456");
        Administrateur admin1 = new Administrateur("BASTAOUI", "Saousane", "test1.mail.com", "987654");
        
        //Ajout compte
        user1 = utilisateurSrv.save(user1);
        admin1 = administrateurSrv.save(admin1);
        
	}

}
