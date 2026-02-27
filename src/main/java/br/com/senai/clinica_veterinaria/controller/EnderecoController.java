package br.com.senai.clinica_veterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.senai.clinica_veterinaria.entity.Endereco;
import br.com.senai.clinica_veterinaria.exception.Response;
import br.com.senai.clinica_veterinaria.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoRepository repository;

    @PostMapping
    public Response agendaEndereco(@RequestBody Endereco entity) {
        repository.save(entity);
        return new Response(201, "Endereco Agendada"); 
    }
    
    @GetMapping
    public List<Endereco> retornaTodos() {
        return repository.findAll();
    }
   
    @PutMapping("/{id}")
    public Response atualizaEndereco(@PathVariable Long id, @RequestBody Endereco entity) {

        if (!repository.existsById(id)) {
            return new Response(201, "Endereço não encontrado");
        }

        Endereco enderecoAntigo = repository.findById(id).get();

        if (entity.getCep() != null) {
            enderecoAntigo.setCep(entity.getCep());
        }
        if (entity.getLogradouro() != null) {
            enderecoAntigo.setLogradouro(entity.getLogradouro());
        }
        if (entity.getLocalidade() != null) {
            enderecoAntigo.setLocalidade(entity.getLocalidade());
        }
        if (entity.getUf() != null) {
            enderecoAntigo.setUf(entity.getUf());
        }
         if (entity.getBairro() != null) {
            enderecoAntigo.setBairro(entity.getBairro());
        }
         if (entity.getNumero() != null) {
            enderecoAntigo.setNumero(entity.getNumero());
        }
         if (entity.getComplemento() != null) {
            enderecoAntigo.setComplemento(entity.getComplemento());
        }
         if (entity.getReferencia() != null) {
            enderecoAntigo.setReferencia(entity.getReferencia());
        }
         if (entity.getPrincipal() != null) {
            enderecoAntigo.setPrincipal(entity.getPrincipal());
        }

             repository.save(enderecoAntigo);

        return new Response(200, "Endereco Atualizado!");
    }



    @DeleteMapping("/{id}")
    public Response deleteEndereco(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Endereco Não Encontrado");
        }

        repository.deleteById(id);

       return new Response(204, "Endereco Deletado");
    }
}
