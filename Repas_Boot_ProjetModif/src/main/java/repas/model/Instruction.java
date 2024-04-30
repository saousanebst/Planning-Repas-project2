package repas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import repas.view.Views;

@Entity
@Table(name="recipe_instruction")
public class Instruction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;
	
	@Column(name="quantity_ingredient", nullable=false, length=50)
	@JsonView(Views.Common.class)
	private int quantiteIngredient;
	
	@ManyToOne
	@JoinColumn(name="recette")
	@JsonView(Views.Instruction.class)
	private Recette recette;
	
	@ManyToOne
	@JoinColumn(name="ingredient")
	@JsonView(Views.Instruction.class)
	private Ingredient ingredient;
	
	
	public Instruction() {
	}

	public Instruction(Integer id, int quantiteIngredient) {
		this.id = id;
		this.quantiteIngredient = quantiteIngredient;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getQuantiteIngredient() {
		return quantiteIngredient;
	}

	public void setQuantiteIngredient(int quantiteIngredient) {
		this.quantiteIngredient = quantiteIngredient;
	}

	@Override
	public String toString() {
		return "Instruction [id=" + id + ", quantiteIngredient=" + quantiteIngredient + "]";
	}
	
}
