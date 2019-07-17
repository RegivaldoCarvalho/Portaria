package ufma.mestrado.portaria.controllers;

import ufma.mestrado.portaria.entity.Funcionario;
import ufma.mestrado.portaria.repository.FuncionarioRepository;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FuncionarioController {
    private FuncionarioRepository repository;
    
    public FuncionarioController(FuncionarioRepository funcionarioRepository){
        this.repository = funcionarioRepository;
    }
    
    @GetMapping("/funcionario")
    public List<Funcionario> getFuncionarios(){
    	return this.repository.findAll();
    }
    
    @PostMapping("/funcionario")
    Funcionario add(@RequestBody Funcionario funcionario) {
      return this.repository.save(funcionario);
    }
    
    @PutMapping("/funcionario/{id}")
    Funcionario update(@RequestBody Funcionario funcionarioRequest, @PathVariable Long id) {

      return repository.findById(id)
        .map(funcionario -> {
          funcionario.setCpf(funcionarioRequest.getCpf());
          funcionario.setNome(funcionarioRequest.getNome());
          return repository.save(funcionario);
        })
        .orElseGet(() -> {
          funcionarioRequest.setId(id);
          return repository.save(funcionarioRequest);
        });
    }
    
    @DeleteMapping("/funcionario/{id}")
    void delete(@PathVariable Long id) {
      repository.deleteById(id);
    }
}
