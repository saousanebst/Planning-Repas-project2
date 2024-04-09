package repas.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="recipe")
public class Recette {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRecette;
	@Column(name="label_recipe", nullable=false, length=50)
	private String nomRecette;
	@OneToMany
	private List <Ingredient> ingredients = new ArrayList();
	
	
	
	public Recette() {
	}

	public Recette(String nomRecette, List<Ingredient> ingredients) {
		this.nomRecette = nomRecette;
		this.ingredients = ingredients;
	}

	public Integer getIdRecette() {
		return idRecette;
	}

	public void setIdRecette(Integer idRecette) {
		this.idRecette = idRecette;
	}

	public String getNomRecette() {
		return nomRecette;
	}

	public void setNomRecette(String nomRecette) {
		this.nomRecette = nomRecette;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Recette [idRecette=" + idRecette + ", nomRecette=" + nomRecette + ", ingredients=" + ingredients + "]";
	}
	
	

	
	
}

