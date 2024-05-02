package repas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	
	

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('gramme', 'millilitre', 'quantite')",nullable=false)
	@JsonView(Views.Common.class)
	private Unite unite;
	
	
	
	public Instruction() {
	}

	public Instruction(Integer id, Unite unite) {
		this.id = id;
		/*this.quantiteIngredient = quantiteIngredient;*/
		this.unite=unite;
	}

	
	
	public Instruction(Recette recette, Ingredient ingredient, int quantiteIngredient, Unite unite) {
		this.quantiteIngredient = quantiteIngredient;
		this.recette = recette;
		this.ingredient = ingredient;
		this.unite = unite;
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

	
	public Recette getRecette() {
		return recette;
	}

	public void setRecette(Recette recette) {
		this.recette = recette;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}

	@Override
	public String toString() {
		return "Instruction [id=" + id + ", quantiteIngredient=" + quantiteIngredient + ", recette=" + recette
				+ ", ingredient=" + ingredient + ", unite=" + unite + "]";
	}

	
}
