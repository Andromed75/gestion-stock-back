package com.example.GestionStock.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comande {

	@Id
	@GeneratedValue
	int id;
	
	LocalDate date;
	
	@OneToMany(targetEntity = Produit.class)
	List<Produit> productList;
}
