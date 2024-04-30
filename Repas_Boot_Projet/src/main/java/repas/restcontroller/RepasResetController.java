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

import repas.model.Repas;
import repas.service.RepasService;
import repas.view.Views;

@RestController
@RequestMapping("/repas")
@CrossOrigin("*")

public class RepasResetController {

	
	@Autowired 
	RepasService repasSrv;
	@GetMapping
	@JsonView(Views.Repas.class)
	public List<Repas> allRepass() 
	{
		return repasSrv.getAll();
	}
	@GetMapping("/{id}")
	@JsonView(Views.Repas.class)
	public Repas ficheRepas(@PathVariable Integer id) 
	{
		return repasSrv.getById(id);
	}
	@PostMapping
	public Repas ajoutRepas(@Valid @RequestBody Repas Repas, BindingResult result) 
	{
		if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le Repas n'est pas valide");
		}
		return repasSrv.insert(Repas);
	}
	
	@PutMapping("/{id}")
	public Repas modifierRepas(@PathVariable Integer id,@RequestBody Repas Repas) 
	{
		Repas.setId(id);
		return repasSrv.update(Repas);
	}
	
	@JsonView(Views.RepasWithRecette.class)
	public List<Repas> RepasWithRecette(Integer id) 
	{
		return repasSrv.findAllByIngredient(id);
	}
	
	
	@DeleteMapping("/{id}")
	public void supprimerRepas(@PathVariable Integer id) 
	{
		repasSrv.deleteById(id);
	}
	
	
}
