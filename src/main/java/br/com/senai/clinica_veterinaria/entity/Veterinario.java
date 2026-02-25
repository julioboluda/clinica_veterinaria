package br.com.senai.clinica_veterinaria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;
    private String crmv;
    private String especializacao;
    private Integer jornada;

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
    public String getCrmv() {
        return crmv;
    }
    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }
    public String getEspecializacao() {
        return especializacao;
    }
    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
    public Integer getJornada() {
        return jornada;
    }
    public void setJornada(Integer jornada) {
        this.jornada = jornada;
    }
 
    
}
