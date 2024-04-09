package repas.model;

import java.util.ArrayList;
import java.util.List;

public class Course {

		Integer idCourse;
		private List <Ingredient> listeCourses = new ArrayList();
		
		
		public Course() {
		}


		public Course(Integer idCourse, List<Ingredient> listeCourses) {
			this.idCourse = idCourse;
			this.listeCourses = listeCourses;
		}


		public Integer getIdCourse() {
			return idCourse;
		}


		public void setIdCourse(Integer idCourse) {
			this.idCourse = idCourse;
		}


		public List<Ingredient> getListeCourses() {
			return listeCourses;
		}


		public void setListeCourses(List<Ingredient> listeCourses) {
			this.listeCourses = listeCourses;
		}


		@Override
		public String toString() {
			return "Course [idCourse=" + idCourse + ", listeCourses=" + listeCourses + "]";
		}
		
		
}
