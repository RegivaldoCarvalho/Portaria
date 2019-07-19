package ufma.mestrado.portaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ufma.mestrado.portaria.entity.Visitante;
import ufma.mestrado.portaria.repository.VisitanteRepository;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class VisitanteController {
    private VisitanteRepository repository;

    @Autowired
    public VisitanteController(VisitanteRepository visitanteRepository){
        this.repository = visitanteRepository;
    }
    
    @GetMapping("/visitante")
    public List<Visitante> getVisitantes(){
    	return this.repository.findAll();
    }
    
    @PostMapping("/visitante")
    public Visitante add(@RequestBody Visitante visitante) {
      return this.repository.save(visitante);
    }
    
    @PutMapping("/visitante/{id}")
    public Visitante update(@RequestBody Visitante visitanteRequest, @PathVariable Long id) {

      return repository.findById(id)
        .map(visitante -> {
          visitante.setCpf(visitanteRequest.getCpf());
          visitante.setNome(visitanteRequest.getNome());
          return repository.save(visitante);
        })
        .orElseGet(() -> {
          visitanteRequest.setId(id);
          return repository.save(visitanteRequest);
        });
    }
    
    @DeleteMapping("/visitante/{id}")
    void delete(@PathVariable Long id) {
      repository.deleteById(id);
    }
}
