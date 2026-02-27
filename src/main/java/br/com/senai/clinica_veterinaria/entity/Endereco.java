package br.com.senai.clinica_veterinaria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
     @NotNull(message = "Precisa informar o cep")
     @Size(min = 8, max = 8, message = "Numero de 8 digitos")
    private Integer cep;
    
    @NotBlank(message = "Precisa informar o logradouro")
    private String logradouro;
    
    @NotBlank(message = "Precisa informar a localidade")
    private String localidade;
    
    @NotBlank(message = "Precisa informar a Unidade Federativa")
    private String uf;
    
    @NotBlank(message = "Precisa informar o bairro")
    private String bairro;
    
    @NotNull(message = "Precisa informar o n°")
    private Integer numero;
        
    private String complemento;
    
    @NotBlank(message = "Precisa informar uma referência")
    private String referencia;
    
    @NotBlank(message = "Precisa informar o Status")
    private Boolean principal;
    
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getCep() {
        return cep;
    }
    public void setCep(Integer cep) {
        this.cep = cep;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getLocalidade() {
        return localidade;
    }
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getReferencia() {
        return referencia;
    }
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    public Boolean getPrincipal() {
        return principal;
    }
    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

    


}