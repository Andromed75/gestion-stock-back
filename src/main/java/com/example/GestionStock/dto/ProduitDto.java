package com.example.GestionStock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProduitDto {

	String nom;
	int prix;
	String photo;
}
