package ufma.mestrado.portaria.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import ufma.mestrado.portaria.entity.Morador;
import ufma.mestrado.portaria.repository.MoradorRepository;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Controller
public class MoradorController {
    private MoradorRepository repository;

    @Autowired
    public MoradorController(MoradorRepository moradorRepository){
        this.repository = moradorRepository;
    }
    
    @GetMapping("/morador")
    public List<Morador> getMoradores(){
    	return this.repository.findAll();
    }
    
    @PostMapping("/morador")
    public String add(@Valid Morador morador, BindingResult result, Model model) {
        model.addAttribute("morador", morador);
        this.repository.save(morador);
        return "cadastroMorador";
    }
    
    @PutMapping("/morador/{id}")
    public Morador update(@RequestBody Morador moradorRequest, @PathVariable Long id) {

      return repository.findById(id)
        .map(morador -> {
          morador.setCpf(moradorRequest.getCpf());
          morador.setNome(moradorRequest.getNome());
          return repository.save(morador);
        })
        .orElseGet(() -> {
          moradorRequest.setId(id);
          return repository.save(moradorRequest);
        });
    }
    
    @DeleteMapping("/morador/{id}")
    void delete(@PathVariable Long id) {
      repository.deleteById(id);
    }
}
