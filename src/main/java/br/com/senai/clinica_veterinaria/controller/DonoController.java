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
import br.com.senai.clinica_veterinaria.exception.Response;
import br.com.senai.clinica_veterinaria.repository.DonoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/dono")
public class DonoController {
    @Autowired
    private DonoRepository repository;

    @PostMapping
    public Response agendaDono(@Valid @RequestBody Dono entity) {
        boolean cpfJaExiste = repository.existsByCpf(entity.getCpf());

        if (cpfJaExiste) {
            return new Response(409, "Ja existe um dono com esse cpf");
        }
        
        
        repository.save(entity);
        return new Response(201, "Dono Registrado"); //Um novo registro foi criado com sucesso no banco de dados
    }
    
    @GetMapping
    public List<Dono> retornaTodos() {
        return repository.findAll();
    }
    
        @PutMapping("/{id}")
    public Response atualizaDono(@PathVariable Long id, @RequestBody Dono entity) {

        if (!repository.existsById(id)) {
            return new Response(404, "Dono não encontrado");  //Um registro não foi encontrado no banco de dados
        }

        Dono donoAntigo = repository.findById(id).get();

        if (entity.getNome() != null) {
            donoAntigo.setNome(entity.getNome());
        }
        if (entity.getCpf() != null) {
            donoAntigo.setCpf(entity.getCpf());
        }
        if (entity.getStatus() != null) {
            donoAntigo.setStatus(entity.getStatus());
        }
        
             repository.save(donoAntigo);

        return new Response(200, "Dono Atualizado!"); //sucesso na busca ou sucesso na alteração
    }


    @DeleteMapping("/{id}")
    public Response deleteAnimal(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Dono Não Encontrada"); //O recurso com o ID informado não existe ou a URL digitada está incorreta.
        }

        repository.deleteById(id);

       return new Response(204, "Dono Deletada"); //Um registro não foi encontrado no banco de dados
    }
}
