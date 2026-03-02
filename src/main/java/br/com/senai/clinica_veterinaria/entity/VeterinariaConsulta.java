package br.com.senai.clinica_veterinaria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "veterinario_consulta")
public class VeterinariaConsulta {
    
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@ManyToOne
@JoinColumn(name = "id_veterinario")
private Veterinario veterinario;

@ManyToOne
@JoinColumn(name = "id_consulta")
private Consulta consulta;

@NotBlank
private String obsMEdicas;

}
