package repas.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepasPlanified {
	
	Integer idRepas;
	private List <Recette> recettes = new ArrayList();
	LocalDate dateDebut;
	LocalDate dateFin;
	
	
	public RepasPlanified() {
	}


	public RepasPlanified(Integer idRepas, List<Recette> recettes, LocalDate dateDebut, LocalDate dateFin) {
		this.idRepas = idRepas;
		this.recettes = recettes;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}


	public Integer getIdRepas() {
		return idRepas;
	}


	public void setIdRepas(Integer idRepas) {
		this.idRepas = idRepas;
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


	public LocalDate getDateFin() {
		return dateFin;
	}


	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}


	@Override
	public String toString() {
		return "RepasPlanified [idRepas=" + idRepas + ", recettes=" + recettes + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + "]";
	}
	
	
	
}