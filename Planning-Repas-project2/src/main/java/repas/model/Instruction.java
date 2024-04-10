package repas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="recipe_instruction")
public class Instruction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="quantity_ingredient", nullable=false, length=50)
	private int quantiteIngredient;
	
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
