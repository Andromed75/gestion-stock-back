package com.example.GestionStock.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {

	@Id
	@GeneratedValue
	int id;
	
	@Column(unique = true)
	String nom;
	
	@OneToMany(targetEntity = Comande.class)
	List<Comande> commandList;
	
	
	


	

}
