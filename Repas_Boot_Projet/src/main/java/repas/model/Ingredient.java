package repas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ingredient")
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="label_ingredient", nullable=false, length=50)
	private String nom;
	
	
	public Ingredient() {
	}

	public Ingredient(Integer id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	public Integer getIdIngredient() {
		return id;
	}


	public void setIdIngredient(Integer id) {
		this.id = id;
	}


	public String getNomIngredient() {
		return nom;
	}


	public void setNomIngredient(String nom) {
		this.nom = nom;
	}


	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", nom=" + nom + "]";
	}
	
}
