package repas.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import repas.view.Views;

@Entity
@Table(name="food")
public class Repas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;
	
	@Column(name="date_debut",nullable = false)
	@JsonView(Views.Common.class)
	private LocalDate dateDebut;
	
	@OneToMany
	@JsonView(Views.RepasWithRecette.class)
	private List <Recette> recettes = new ArrayList<>();
	
	

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Petit_déjeuner', 'Déjeuner', 'Goûter', 'Dîner'",nullable=false)
	@JsonView(Views.Common.class)
	private Creneau creneau;
	
	
	public Repas() {
	}


	public Repas(Integer id, List<Recette> recettes, LocalDate dateDebut, Creneau creneau) {
		this.id = id;
		this.recettes = recettes;
		this.dateDebut = dateDebut;
		this.creneau= creneau;
	}


	


	public Creneau getCreneau() {
		return creneau;
	}


	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDate getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}


	public List<Recette> getRecettes() {
		return recettes;
	}


	public void setRecettes(List<Recette> recettes) {
		this.recettes = recettes;
	}


	@Override
	public String toString() {
		return "Repas [id=" + id + ", dateDebut=" + dateDebut + ", recettes=" + recettes + ", creneau=" + creneau + "]";
	}


	
	
}