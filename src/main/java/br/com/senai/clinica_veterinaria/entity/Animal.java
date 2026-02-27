package br.com.senai.clinica_veterinaria.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank(message = "Precisa de um nome")
    private String nome;

    @NotBlank(message = "Precisa declarar a espécie do animal")
    private String especie;

    @NotBlank(message = "Precisa declarar a raça do animal")
    private String raca;

    @NotNull(message = "Precisa definir a idade do animal")
    @Size(min = 1, max = 2, message = "Mínimo de 1 e máximo de 3 digitos")
    private Integer idade;

    @NotBlank(message = "Precisa registrar informacoes médicas")
    private String infos_medicas;
    
    @NotNull(message =  "Precisa definir o status")
    private Boolean status;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    public String getInfos_medicas() {
        return infos_medicas;
    }
    public void setInfos_medicas(String infos_medicas) {
        this.infos_medicas = infos_medicas;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }

   
}
