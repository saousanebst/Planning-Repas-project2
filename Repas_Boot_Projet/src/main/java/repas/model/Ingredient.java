package repas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import repas.view.Views;

@Entity
@Table(name="ingredient")
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;
	
	@Column(name="label_ingredient", nullable=false, length=50)
	@JsonView(Views.Common.class)
	private String nom;
	
	
	public Ingredient() {
	}

	public Ingredient(Integer id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	
	public Ingredient(String nom) {
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", nom=" + nom + "]";
	}
	
}
