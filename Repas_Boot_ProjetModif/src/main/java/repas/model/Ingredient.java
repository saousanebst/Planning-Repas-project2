package repas.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@Column(name="photo_ingredient", nullable=false, length=255)
	@JsonView(Views.Common.class)
	private String photo;
	
	@OneToMany(mappedBy="ingredient")
	@JsonView(Views.IngredientWithInstruction.class)
	private List<Instruction> instructions= new ArrayList();
	
	
	public Ingredient() {
	}

	public Ingredient(Integer id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	
	
	public Ingredient(String nom, String photo, List<Instruction> instructions) {
		this.nom = nom;
		this.photo = photo;
		this.instructions = instructions;
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

	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<Instruction> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", nom=" + nom + ", photo=" + photo + ", instructions=" + instructions + "]";
	}
	
}
