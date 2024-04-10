package eshop.test;

import org.springframework.beans.factory.annotation.Autowired;

import eshop.dao.IDAOProduit;
import eshop.model.Produit;

public class TestSpringJpa {
	
	@Autowired
	IDAOProduit daoproduit;
	
	public void run() {
		
	for(Produit p : daoproduit.findAll()) {
		System.out.println(p);
	}
		
	
}
}
