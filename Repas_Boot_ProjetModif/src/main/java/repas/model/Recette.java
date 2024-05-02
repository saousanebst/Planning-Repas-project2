package repas.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name="recipe")
public class Recette {
	 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;
	
	@Column(name="label_recipe", nullable=false, length=50)
	@JsonView(Views.Common.class)
	private String nom;
	
	@Column(name="photo_recipe", nullable=false, length=255)
	@JsonView(Views.Common.class)
	private String photo;
	
	
	@OneToMany(mappedBy="recette")
	@JsonView(Views.RecetteWithInstruction.class)
	private List<Instruction> instructions = new ArrayList();
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Entree','Plat','Dessert','Boisson')",nullable=false)
	@JsonView(Views.Common.class)
	private TypeRecette typeRecette;
	
	public Recette() {
	}

	public Recette(String nom, TypeRecette typeRecette) {
		this.nom = nom;
		this.typeRecette=typeRecette;	
	}
	

	public Recette(String nom, List<Instruction> instructions, TypeRecette typeRecette) {
		this.nom = nom;
		this.instructions = instructions;
		this.typeRecette = typeRecette;
	}
	
	

	public Recette(String nom, String photo, List<Instruction> instructions, TypeRecette typeRecette) {
		this.nom = nom;
		this.photo = photo;
		this.instructions = instructions;
		this.typeRecette = typeRecette;
	}

	public TypeRecette getTypeRecette() {
		return typeRecette;
	}

	public void setTypeRecette(TypeRecette typeRecette) {
		this.typeRecette = typeRecette;
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
		return "Recette [id=" + id + ", nom=" + nom + ", photo=" + photo + ", instructions=" + instructions
				+ ", typeRecette=" + typeRecette + "]";
	}

}

