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


import br.com.senai.clinica_veterinaria.entity.Veterinario;
import br.com.senai.clinica_veterinaria.exception.Response;
import br.com.senai.clinica_veterinaria.repository.VeterinarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/veterinario")
public class VeterinarioController {
    @Autowired
    private VeterinarioRepository repository;

    @PostMapping
    public Response agendaVeterinario(@Valid @RequestBody Veterinario entity) {
        repository.save(entity);
        return new Response(201, "Veterinario Agendada"); //Um novo registro foi criado com sucesso no banco de dados
    }
    
    @GetMapping
    public List<Veterinario> retornaTodos() {
        return repository.findAll();
    }
    
     @PutMapping("/{id}")
    public Response atualizaVeterinario(@PathVariable Long id, @RequestBody Veterinario entity) {

        if (!repository.existsById(id)) {
            return new Response(204, "Dono não encontrado"); //Um registro não foi encontrado no banco de dados
        }

        Veterinario veterinarioAntigo = repository.findById(id).get();

        if (entity.getNome() != null) {
            veterinarioAntigo.setNome(entity.getNome());
        }
        if (entity.getCrmv() != null) {
            veterinarioAntigo.setCrmv(entity.getCrmv());
        }
        if (entity.getEspecializacao() != null) {
            veterinarioAntigo.setEspecializacao(entity.getEspecializacao());
        }
        if (entity.getJornada() != null) {
            veterinarioAntigo.setJornada(entity.getJornada());
        }
        
             repository.save(veterinarioAntigo);

        return new Response(200, "Dono Atualizado!"); //sucesso na busca ou sucesso na alteração
    }


    @DeleteMapping("/{id}")
    public Response deleteAnimal(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Veterinario Não Encontrada"); //O recurso com o ID informado não existe ou a URL digitada está incorreta.
        }

        repository.deleteById(id);

       return new Response(204, "Veterinario Deletada"); //Um registro não foi encontrado no banco de dados
    }
}
