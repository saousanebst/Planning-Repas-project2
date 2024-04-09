package repas.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Administrateur extends Compte {
	
	public Administrateur() {}

	public Administrateur(String nom, String prenom, String email, String password) {
		super(nom, prenom, email, password);
		
	}

	@Override
	public String toString() {
		return "Administrateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password="
				+ password + "]";
	}
	
	
	/*
	public Recette ajouterRecette(Recette recette) {}
	public Recette supprimerRecette(Recette recette) {}
	public Recette modifierRecette(Recette recette) {}
*/
}





