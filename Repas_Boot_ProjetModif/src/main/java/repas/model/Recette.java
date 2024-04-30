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
@Table(name="recipe")
public class Recette {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;
	
	@Column(name="label_recipe", nullable=false, length=50)
	@JsonView(Views.Common.class)
	private String nom;
	
	
	@OneToMany(mappedBy="recette")
	@JsonView(Views.RecetteWithInstruction.class)
	private List<Instruction> instructions = new ArrayList();
	
	
	public Recette() {
	}

	public Recette(String nom) {
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

	public List<Instruction> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}

	@Override
	public String toString() {
		return "Recette [id=" + id + ", nom=" + nom + ", instructions=" + instructions + "]";
	}
	
}

