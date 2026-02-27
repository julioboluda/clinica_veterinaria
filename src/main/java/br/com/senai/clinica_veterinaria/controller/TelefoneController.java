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

import br.com.senai.clinica_veterinaria.entity.Dono;
import br.com.senai.clinica_veterinaria.entity.Telefone;
import br.com.senai.clinica_veterinaria.exception.Response;
import br.com.senai.clinica_veterinaria.repository.TelefoneRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/telefone")
public class TelefoneController {
    @Autowired
    private TelefoneRepository repository;

    @PostMapping
    public Response agendaTelefone(@Valid @RequestBody Telefone entity) {
        repository.save(entity);
        return new Response(201, "Telefone Agendada"); 
    }
    
    @GetMapping
    public List<Telefone> retornaTodos() {
        return repository.findAll();
    }
    
     @PutMapping("/{id}")
    public Response atualizaTelefone(@PathVariable Long id, @RequestBody Telefone entity) {

        if (!repository.existsById(id)) {
            return new Response(201, "Telefone não encontrado");
        }

        Telefone telefoneAntigo = repository.findById(id).get();

            if (entity.getNumero() != null) {
            telefoneAntigo.setNumero(entity.getNumero());
        }
            
             repository.save(telefoneAntigo);

        return new Response(200, "Dono Atualizado!");
    }


    @DeleteMapping("/{id}")
    public Response deleteAnimal(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Telefone Não Encontrada");
        }

        repository.deleteById(id);

       return new Response(204, "Telefone Deletada");
    }
}
