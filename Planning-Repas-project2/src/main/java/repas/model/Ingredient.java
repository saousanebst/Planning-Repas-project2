package repas.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
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
	Integer idIngredient;
	@Column(name="label_ingredient", nullable=false, length=50)
	String nomIngredient;
	@Column(name= "quantity", columnDefinition = "int(4)")
	int quantiteIngredient;
	
	
	
	public Ingredient() {
	}


	public Ingredient(Integer idIngredient, String nomIngredient, int quantiteIngredient) {
		this.idIngredient = idIngredient;
		this.nomIngredient = nomIngredient;
		this.quantiteIngredient = quantiteIngredient;
	}


	public Integer getIdIngredient() {
		return idIngredient;
	}


	public void setIdIngredient(Integer idIngredient) {
		this.idIngredient = idIngredient;
	}


	public String getNomIngredient() {
		return nomIngredient;
	}


	public void setNomIngredient(String nomIngredient) {
		this.nomIngredient = nomIngredient;
	}


	public int getQuantiteIngredient() {
		return quantiteIngredient;
	}


	public void setQuantiteIngredient(int quantiteIngredient) {
		this.quantiteIngredient = quantiteIngredient;
	}


	@Override
	public String toString() {
		return "Ingredient [idIngredient=" + idIngredient + ", nomIngredient=" + nomIngredient + ", quantiteIngredient="
				+ quantiteIngredient + "]";
	}
	
	
	
	/*+ AjouterIngredient() : idIngredient
	+ SupprimerIngredient () :void
	 */
	
}
