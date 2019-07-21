package ufma.mestrado.portaria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String index() {
        return "/index";
    }

    @GetMapping("/index")
    public String home() {
        return "/index";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/cadastro")
    public String cadastro() {
        return "/cadastro";
    }

    @GetMapping("/cadastroFuncionario")
    public String cadastroFuncionario() {
        return "/cadastroFuncionario";
    }

    @GetMapping("/cadastroMorador")
    public String cadastroMorador() {
        return "/cadastroMorador";
    }

    @GetMapping("/cadastroPermissao")
    public String cadastroPermissao() {
        return "/cadastroPermissao";
    }

    @GetMapping("/cadastroVisitante")
    public String CadastroVisitante() {
        return "cadastroVisitante";
    }

    @GetMapping("/principalFuncionario")
    public String principalfuncionario() {
        return "/principalFuncionario";
    }

    @GetMapping("/principalMorador")
    public String principalMorador() {
        return "/principalMorador";
    }

    @GetMapping("/principalVisitante")
    public String principalVisitante() {
        return "/principalVisitante";
    }

    @GetMapping("/userProfile   ")
    public String user() {
        return "/user";
    }

    @GetMapping("/visualizarPermissao")
    public String visualizarPermissao() {
        return "/visualizarPermissao";
    }
}
