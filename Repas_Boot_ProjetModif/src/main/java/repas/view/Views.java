package repas.view;


public class Views{

	public class Common {}
	
	public class Administrateur extends Common {} //Acces JSON présent sur toutes les relations toOne dans la classe compte

	public class Utilisateur extends Common {}	

	public class Ingredient extends Common {}
	 public class IngredientWithInstruction extends Ingredient{}
	public class Instruction extends Common {}

	public class Recette extends Common {}

         public class RecetteWithInstruction extends Recette{} //Acces JSON spécifique pour les chargements toMany
	public class Repas extends Common {}

		public class RepasWithRecette extends Repas{} 

}