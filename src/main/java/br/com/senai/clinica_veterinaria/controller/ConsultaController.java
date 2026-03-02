package br.com.senai.clinica_veterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.senai.clinica_veterinaria.entity.Consulta;
import br.com.senai.clinica_veterinaria.exception.Response;
import br.com.senai.clinica_veterinaria.repository.ConsultaRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    @Autowired
    private ConsultaRepository repository;

    @PostMapping
    public Response agendaConsulta(@Valid @RequestBody Consulta entity) {
        repository.save(entity);
        return new Response(201, "Consulta Agendada"); //Um novo registro foi criado com sucesso no banco de dados
    }
    
    @GetMapping
    public List<Consulta> retornaTodos() {
        return repository.findAll();
    }
    
    @PutMapping("/{id}")
    public Response atualizaData_hora(@PathVariable Long id, @RequestBody Consulta entity) {

        if (!repository.existsById(id)) {
            return new Response(204, "Consulta não encontrada"); //Um registro não foi encontrado no banco de dados
        }

        Consulta ConsultaAntigo = repository.findById(id).get();

        if (entity.getData_hora() != null) {
            ConsultaAntigo.setData_hora(entity.getData_hora());
        }
        
             repository.save(ConsultaAntigo);

        return new Response(200, "COnsulta Atualizada!"); //sucesso na busca ou sucesso na alteração
    }


    @DeleteMapping("/{id}")
    public Response deleteAnimal(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Consulta Não Encontrada"); //O recurso com o ID informado não existe ou a URL digitada está incorreta.
        }

        repository.deleteById(id);

       return new Response(204, "Consulta Deletada"); //Um registro não foi encontrado no banco de dados
    }
}
