package ufma.mestrado.portaria.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

import javax.jws.WebParam;
import javax.validation.Valid;

@Controller
public class FuncionarioController {
    private FuncionarioRepository repository;

    @Autowired
    public FuncionarioController(FuncionarioRepository funcionarioRepository){
        this.repository = funcionarioRepository;
    }
    
    @GetMapping("/funcionario")
    public List<Funcionario> getFuncionarios(){
    	return this.repository.findAll();
    }
    
    @PostMapping("/funcionario")
    public String add(@Valid Funcionario funcionario, BindResult bindResult, Model model) {
        model.addAttribute(funcionario);
        this.repository.save(funcionario);
        return "cadastroFuncionario";
    }
    
    @PutMapping("/funcionario/{id}")
    public Funcionario update(@RequestBody Funcionario funcionarioRequest, @PathVariable Long id) {

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
    public void delete(@PathVariable Long id) {
      repository.deleteById(id);
    }
}
