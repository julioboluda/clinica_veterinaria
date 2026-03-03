package br.com.senai.clinica_veterinaria.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Dono {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank(message = "Precisa registrar um nome")
    private String nome;

    @NotNull(message = "Precisa de um numero de cpf válido")
    @Size(min = 11, message = "Minimo de 11 digitos")
    @Column(unique = true)
    private String cpf;

    @NotNull(message = "Precisa definir o status")
    private Boolean status;

    @OneToMany(mappedBy = "dono")
    private List<Telefone> telefones;

    @OneToMany(mappedBy = "dono")
    private List<Endereco> enderecos;

    @OneToMany(mappedBy = "dono")
    private List<Animal> animais;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }


    
   
}
