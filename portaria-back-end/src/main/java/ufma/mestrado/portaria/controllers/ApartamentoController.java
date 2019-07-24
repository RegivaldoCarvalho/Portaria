package ufma.mestrado.portaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ufma.mestrado.portaria.entity.Apartamento;
import ufma.mestrado.portaria.repository.ApartamentoRepository;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ApartamentoController {
    private ApartamentoRepository repository;

    @Autowired
    public ApartamentoController(ApartamentoRepository apartamentoRepository){
        this.repository = apartamentoRepository;
    }
    
    @GetMapping("/apartamento")
    public List<Apartamento> getApartamentos(){
    	return this.repository.findAll();
    }
    
    @PostMapping("/apartamento")
    public Apartamento add(@RequestBody Apartamento apartamento) {
      return this.repository.save(apartamento);
    }
    
    @PutMapping("/apartamento/{id}")
    public Apartamento replace(@RequestBody Apartamento apartamentoRequest, @PathVariable Long id) {

      return repository.findById(id)
        .map(apartamento -> {
          apartamento.setBloco(apartamentoRequest.getBloco());
          apartamento.setAndar(apartamentoRequest.getAndar());
          apartamento.setNumero(apartamentoRequest.getNumero());
          return repository.save(apartamento);
        })
        .orElseGet(() -> {
          apartamentoRequest.setId(id);
          return repository.save(apartamentoRequest);
        });
    }
    
    @DeleteMapping("/apartamento/{id}")
    void delete(@PathVariable Long id) {
      repository.deleteById(id);
    }
}
