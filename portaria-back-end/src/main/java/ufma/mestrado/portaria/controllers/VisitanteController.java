package ufma.mestrado.portaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

import javax.validation.Valid;

@Controller
public class VisitanteController {
    private VisitanteRepository repository;

    @Autowired
    public VisitanteController(VisitanteRepository visitanteRepository) {
        this.repository = visitanteRepository;
    }

    @GetMapping("/visitante")
    public List<Visitante> getVisitantes() {
        return this.repository.findAll();
    }

    @PostMapping("/visitante")
    public String add(@Valid Visitante Visitante, BindingResult result, Model model) {
        model.addAttribute("Visitante", Visitante);
        this.repository.save(Visitante);
        return "cadastroVisitante";
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
