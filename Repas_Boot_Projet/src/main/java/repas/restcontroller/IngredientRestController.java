package repas.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import repas.model.Ingredient;
import repas.service.IngredientService;
import repas.view.Views;



@RestController
@RequestMapping("/api/ingredient")
@CrossOrigin("*")

public class IngredientRestController {
	@Autowired 
	IngredientService ingredientSrv;

	@GetMapping
	@JsonView(Views.Ingredient.class)
	public List<Ingredient> allIngredients() 
	{
		return ingredientSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Ingredient.class)
	public Ingredient ficheIngredient(@PathVariable Integer id) 
	{
		return ingredientSrv.getById(id);
	}

	
	@PostMapping
	public Ingredient ajoutIngredient(@Valid @RequestBody Ingredient Ingredient, BindingResult result) 
	{
		if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le Ingredient n'est pas valide");
		}
		return ingredientSrv.insert(Ingredient);
	}
	
	@PutMapping("/{id}")
	public Ingredient modifierIngredient(@PathVariable Integer id,@RequestBody Ingredient Ingredient) 
	{
		Ingredient.setId(id);
		return ingredientSrv.update(Ingredient);
	}
	
	
	@DeleteMapping("/{id}")
	public void supprimerIngredient(@PathVariable Integer id) 
	{
		ingredientSrv.deleteById(id);
	}
	
}
	
	
	

