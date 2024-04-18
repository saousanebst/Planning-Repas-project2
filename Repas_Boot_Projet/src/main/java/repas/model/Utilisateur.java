package repas.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("user")
public class Utilisateur extends Compte {

	public Utilisateur() {}

	public Utilisateur(String nom, String prenom, String email, String password) {
		super(nom, prenom, email, password);
		
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password="
				+ password + "]";
	}
	

}
