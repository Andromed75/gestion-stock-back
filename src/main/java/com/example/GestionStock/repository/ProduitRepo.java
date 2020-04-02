package com.example.GestionStock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.GestionStock.domain.Produit;

public interface ProduitRepo extends JpaRepository<Produit, Integer>{

	
	@Query("Select p from Produit p where nom IN (?1)")
	public List<Produit> getNom(List<String> list);
	
//	public List<Produit> findByNomIn(List<String> noms);

}
