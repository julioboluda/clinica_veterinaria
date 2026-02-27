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

import br.com.senai.clinica_veterinaria.entity.Animal;
import br.com.senai.clinica_veterinaria.exception.Response;
import br.com.senai.clinica_veterinaria.repository.AnimalRepository;


@RestController
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    private AnimalRepository repository;

    @PostMapping
    public Response cadastraNomeAnimal(@RequestBody Animal entity) {
        repository.save(entity);
        return new Response(201, "Animal Registrado"); 
    }
    
    @GetMapping
    public List<Animal> retornaTodos() {
        return repository.findAll();
    }
    
     @PutMapping("/{id}")
    public Response atualizaProduto(@PathVariable Long id, @RequestBody Animal entity) {

        if (!repository.existsById(id)) {
            return new Response(201, "Produto não encontrado");
        }

        Animal AnimalAntigo = repository.findById(id).get();

        if (entity.getNome() != null) {
            AnimalAntigo.setNome(entity.getNome());
        }
        if (entity.getEspecie() != null) {
            AnimalAntigo.setEspecie(entity.getEspecie());
        }
        if (entity.getRaca() != null) {
            AnimalAntigo.setRaca(entity.getRaca());
        }
        if (entity.getIdade() != null) {
            AnimalAntigo.setIdade(entity.getIdade());
        }
         if (entity.getInfos_medicas() != null) {
            AnimalAntigo.setInfos_medicas(entity.getInfos_medicas());
        }
         if (entity.getStatus() != null) {
            AnimalAntigo.setStatus(entity.getStatus());
        }

             repository.save(AnimalAntigo);

        return new Response(200, "Nome Animal Atualizado!");
    }


    @DeleteMapping("/{id}")
    public Response deleteAnimal(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Animal Não Encontrado");
        }

        repository.deleteById(id);

       return new Response(204, "Animal Registro Deletado");
    }
}
