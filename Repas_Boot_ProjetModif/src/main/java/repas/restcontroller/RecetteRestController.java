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

import repas.model.Recette;
import repas.service.RecetteService;
import repas.view.Views;


@RestController
@RequestMapping("/api/recette")
@CrossOrigin("*")

public class RecetteRestController {
	@Autowired 
		RecetteService recetteSrv;
		@GetMapping
		@JsonView(Views.Recette.class)
		public List<Recette> allRecettes() 
		{
			return recetteSrv.getAll();
		}
		@GetMapping("/{id}")
		@JsonView(Views.Recette.class)
		
		public Recette ficheRecette(@PathVariable Integer id) 
		{
			return recetteSrv.getById(id);
		}
		@PostMapping
		public Recette ajoutRecette(@Valid @RequestBody Recette Recette, BindingResult result) 
		{
			if(result.hasErrors()) 
			{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le Recette n'est pas valide");
			}
			return recetteSrv.insert(Recette);
		}
		
		@PutMapping("/{id}")
		public Recette modifierRecette(@PathVariable Integer id,@RequestBody Recette Recette) 
		{
			Recette.setId(id);
			return recetteSrv.update(Recette);
		}
		
		@JsonView(Views.RecetteWithInstruction.class)
		public List<Recette> RecetteWithInstruction(Integer id) 
		{
			return recetteSrv.getByIdWithInstruction(id);
		}
		
		
		@DeleteMapping("/{id}")
		public void supprimerRecette(@PathVariable Integer id) 
		{
			recetteSrv.deleteById(id);
		}
				
}
