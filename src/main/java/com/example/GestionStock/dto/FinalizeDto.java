package com.example.GestionStock.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FinalizeDto {

	String nomClient;
	
	List<ProductWithQuantity> listProduit;
	
}
