package repas.model;

import java.time.LocalDate;
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
@Table(name="food")
public class Repas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="date_debut",nullable = false)
	private LocalDate dateDebut;
	
	@OneToMany
	private List <Recette> recettes = new ArrayList();
	
	
	public Repas() {
	}


	public Repas(Integer id, List<Recette> recettes, LocalDate dateDebut) {
		this.id = id;
		this.recettes = recettes;
		this.dateDebut = dateDebut;
	}


	public Integer getIdRepas() {
		return id;
	}


	public void setIdRepas(Integer id) {
		this.id = id;
	}


	public List<Recette> getRecettes() {
		return recettes;
	}


	public void setRecettes(List<Recette> recettes) {
		this.recettes = recettes;
	}


	public LocalDate getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}


	@Override
	public String toString() {
		return "Repas [id=" + id + ", recettes=" + recettes + ", dateDebut=" + dateDebut + "]";
	}
	
}