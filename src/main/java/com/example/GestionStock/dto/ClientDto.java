package com.example.GestionStock.dto;

import javax.validation.constraints.NegativeOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

	String nom;
	
}
