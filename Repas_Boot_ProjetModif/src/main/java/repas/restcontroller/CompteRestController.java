package repas.restcontroller;

import java.util.List;
import java.util.Optional;

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

import repas.dao.IDAOCompte;
import repas.dto.ConnexionDTO;
import repas.model.Compte;
import repas.model.Utilisateur;
import repas.service.UtilisateurService;
import repas.view.Views;

@RestController
@RequestMapping("/api/compte")
@CrossOrigin("*")
public class CompteRestController {
	@Autowired
	IDAOCompte idaoCompte;

	@PostMapping("/login")
	public Compte connexion(@RequestBody ConnexionDTO connexionDTO) {
		Compte compte = (Compte) this.idaoCompte.findByEmailAndPassword(connexionDTO.getLogin(),
				connexionDTO.getPassword());

		if (compte == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Compte non trouvé");
		}

		return compte;
	}

}
