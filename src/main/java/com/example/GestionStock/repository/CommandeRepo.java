package com.example.GestionStock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.GestionStock.domain.Comande;

public interface CommandeRepo extends JpaRepository<Comande, Integer>{

}
