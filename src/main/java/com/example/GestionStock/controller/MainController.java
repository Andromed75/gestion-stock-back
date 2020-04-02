package com.example.GestionStock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestionStock.domain.Client;
import com.example.GestionStock.domain.Produit;
import com.example.GestionStock.dto.ClientDto;
import com.example.GestionStock.dto.FinalizeDto;
import com.example.GestionStock.dto.ProduitDto;
import com.example.GestionStock.service.GestionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping("/gestion")
@Slf4j
public class MainController {
    
	@Autowired
	GestionService gestionService;

	@PostMapping("/create/client")
	public ResponseEntity<Client> createClient(@RequestBody ClientDto client) {
		return ResponseEntity.ok(gestionService.createClient(client));
	}
	
	@PostMapping("/create/produit")
	public ResponseEntity<Produit> createProd(@RequestBody ProduitDto produit) {
		log.info("ProduitDto = {}", produit);
		Produit p = Produit.builder().nom(produit.getNom()).prix(produit.getPrix()).photo(produit.getPhoto()).build();
		gestionService.createProduit(p);
		return ResponseEntity.ok(p);
	}
	
	@GetMapping("/clients")
	public ResponseEntity<List<Client>> getAllClients() {
		return ResponseEntity.ok(gestionService.getAllClients());
	}
	
	@GetMapping("/produits")
	public ResponseEntity<List<Produit>> getAllProduits() {
		return ResponseEntity.ok(gestionService.getAllproduits());
	}
	
	@GetMapping("produit/{id}")
	public ResponseEntity<Produit> getProduitById(@PathVariable("id") int id) {
		return ResponseEntity.ok(gestionService.getProduitById(id));
	}
	
	@PostMapping("/finalize")
	public ResponseEntity<Client> createCommande(@RequestBody FinalizeDto finalize) {
		return ResponseEntity.ok(gestionService.createCommande(finalize));
	}
	
	@DeleteMapping("/doom")
	public void doom() {
		gestionService.doom();
	}
}
