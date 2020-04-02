package com.example.GestionStock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.GestionStock.domain.Client;

public interface ClientRepo extends JpaRepository<Client, Integer>{

	public Client findByNom(@Param("nom") String nom);

}
