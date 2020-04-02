package com.example.GestionStock.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GestionStock.domain.Client;
import com.example.GestionStock.domain.Comande;
import com.example.GestionStock.domain.Produit;
import com.example.GestionStock.dto.ClientDto;
import com.example.GestionStock.dto.FinalizeDto;
import com.example.GestionStock.dto.ProduitDto;
import com.example.GestionStock.repository.ClientRepo;
import com.example.GestionStock.repository.CommandeRepo;
import com.example.GestionStock.repository.ProduitRepo;

@Service
public class GestionService {

	final ClientRepo clientRepo;
	final CommandeRepo commandeRepo;
	final ProduitRepo produitRepo;

	@Autowired
	public GestionService(ClientRepo clientRepo, CommandeRepo commandeRepo, ProduitRepo produitRepo) {
		this.clientRepo = clientRepo;
		this.commandeRepo = commandeRepo;
		this.produitRepo = produitRepo;
	}

	public Client createClient(ClientDto clientDto) {
		Client toPersist = Client.builder().nom(clientDto.getNom()).commandList(new ArrayList<Comande>()).build();
		return clientRepo.save(toPersist);
	}

	public List<Client> getAllClients() {
		return clientRepo.findAll();
	}

	public List<Produit> getAllproduits() {
		return produitRepo.findAll();
	}

	public Client createCommande(FinalizeDto finalize) {
		Client client = clientRepo.findByNom(finalize.getNomClient());
		List<String> productsName = finalize.getListProduit().stream().map(p -> p.getNomProduit()).collect(Collectors.toList());
		List<Produit> listProduits = produitRepo.getNom(productsName);
		Comande commande = new Comande();
		commandeRepo.save(commande);
		commande.setDate(LocalDate.now());
		commande.setProductList(listProduits);
		commandeRepo.save(commande);
		client.getCommandList().add(commande);
		return clientRepo.save(client);
	}

	public Produit createProduit(Produit p) {
		return produitRepo.save(Produit.builder().nom(p.getNom()).prix(p.getPrix()).photo(p.getPhoto()).build());
	}

	public Produit getProduitById(int id) {
		Optional<Produit> optional = produitRepo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public void doom() {
		produitRepo.deleteAll();
	}
	
}
