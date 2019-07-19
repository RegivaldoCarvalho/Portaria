package ufma.mestrado.portaria.controllers;

import ufma.mestrado.portaria.entity.Carro;
import ufma.mestrado.portaria.repository.CarroRepository;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarroController {
    private CarroRepository repository;
    
    public CarroController(CarroRepository carroRepository){
        this.repository = carroRepository;
    }
    
    @GetMapping("/carro")
    public List<Carro> getCarros(){
    	return this.repository.findAll();
    }
    
    @PostMapping("/carro")
    public Carro add(@RequestBody Carro carro) {
      return this.repository.save(carro);
    }
    
    @PutMapping("/carro/{id}")
    public Carro update(@RequestBody Carro carroRequest, @PathVariable Long id) {

      return repository.findById(id)
        .map(carro -> {
          carro.setModelo(carroRequest.getModelo());
          carro.setPlaca(carroRequest.getPlaca());
          return repository.save(carro);
        })
        .orElseGet(() -> {
          carroRequest.setId(id);
          return repository.save(carroRequest);
        });
    }
    
    @DeleteMapping("/carro/{id}")
    void delete(@PathVariable Long id) {
      repository.deleteById(id);
    }
}
