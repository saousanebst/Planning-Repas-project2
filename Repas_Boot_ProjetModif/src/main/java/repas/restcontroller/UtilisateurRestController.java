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

import com.fasterxml.jackson.annotation.JsonView;

import repas.model.Utilisateur;
import repas.service.UtilisateurService;
import repas.view.Views;

@RestController
@RequestMapping("/api/utilisateur")
@CrossOrigin("*")
public class UtilisateurRestController {
 @Autowired
 UtilisateurService utilisateurSrv; 
 
 @GetMapping
 @JsonView(Views.Utilisateur.class)
 public List<Utilisateur>allUtilisateurs (){
	 
	 return utilisateurSrv.getAll() ; 
 }
	
 @GetMapping("/{id}")
 @JsonView(Views.Utilisateur.class)
	public Utilisateur ficheUtilistaeur(@PathVariable Integer id) 
	{
		return utilisateurSrv.getById(id);
	}

	
	@PostMapping
	public Utilisateur ajoutUtilisateur (@Valid @RequestBody Utilisateur utilisateur, BindingResult result) 
	{
		if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Utilisateur non valide ");
		}
		return utilisateurSrv.insert(utilisateur);
	}
	
	@PutMapping("/{id}")
	public Utilisateur modifierUtilisateur(@PathVariable Integer id,@RequestBody Utilisateur utilisateur) 
	{
		utilisateur.setId(id);
		return utilisateurSrv.update(utilisateur);
	}
	

	@PatchMapping("/{id}")
	public Utilisateur modifierPartiellementUtilisateur(@PathVariable Integer id,@RequestBody Utilisateur utilisateur) 
	{
		utilisateur.setId(id);
		return utilisateurSrv.updatePartiel(utilisateur);
	}
	
	@DeleteMapping("/{id}")
	public void supprimerUtilisateur(@PathVariable Integer id) 
	{
		utilisateurSrv.deleteById(id);
	}

	
}
