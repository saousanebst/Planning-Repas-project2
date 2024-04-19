package repas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import repas.model.Administrateur;
import repas.model.Compte;
import repas.model.Utilisateur;


public interface IDAOCompte extends JpaRepository<Compte,Integer>{

	public Compte findByEmailAndPassword(String email, String password); 

	@Query("from Utilisateur")
	public List<Utilisateur> findAllUtilisateur();

	@Query("from Administrateur")
	public List<Administrateur> findAllAdministrateur();

}
