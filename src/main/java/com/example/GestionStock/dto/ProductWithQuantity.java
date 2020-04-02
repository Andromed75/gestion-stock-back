package com.example.GestionStock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductWithQuantity {
	
	String nomProduit;
	int quantity;

}
