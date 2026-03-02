package br.com.senai.clinica_veterinaria.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull(message = "Precisa registrar data e hora")
    private LocalDateTime data_hora;

    @OneToMany(mappedBy = "consulta")
    private List<VeterinariaConsulta> veterinarioconsultas;

    public Consulta(Long id, LocalDateTime data_hora)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;
    }
    public List<VeterinariaConsulta> getVeterinarioconsultas() {
        return veterinarioconsultas;
    }
    public void setVeterinarioconsultas(List<VeterinariaConsulta> veterinarioconsultas) {
        this.veterinarioconsultas = veterinarioconsultas;
    }

}