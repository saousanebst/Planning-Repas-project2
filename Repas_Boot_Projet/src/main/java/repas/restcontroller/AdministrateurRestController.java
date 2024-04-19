package repas.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import repas.model.Administrateur;
import repas.service.AdministrateurService;
@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdministrateurRestController {
	 @Autowired
	 AdministrateurService administrateurSrv; 
	 
	 @GetMapping
	 public List<Administrateur>alladministrateurs (){
		 
		 return administrateurSrv.getAll() ; 
	 }
		
	 @GetMapping("/{id}")
		public Administrateur ficheadministrateur(@PathVariable Integer id) 
		{
			return administrateurSrv.getById(id);
		}

		
		@PostMapping
		public Administrateur ajoutAdmin (@Valid @RequestBody Administrateur administrateur, BindingResult result) 
		{
			if(result.hasErrors()) 
			{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Utilisateur non valide ");
			}
			return administrateurSrv.insert(administrateur);
		}
		
		@PutMapping("/{id}")
		public Administrateur modifierAdministrateur(@PathVariable Integer id,@RequestBody Administrateur administrateur) 
		{
			administrateur.setId(id);
			return administrateurSrv.update(administrateur);
		}
		

		@PatchMapping("/{id}")
		public Administrateur modifierPartiellementAdministrateur(@PathVariable Integer id,@RequestBody Administrateur administrateur) 
		{
			administrateur.setId(id);
			return administrateurSrv.updatePartiel(administrateur);
		}
		
		@DeleteMapping("/{id}")
		public void supprimerAdministrateur(@PathVariable Integer id) 
		{
			administrateurSrv.deleteById(id);
		}
		
	}
