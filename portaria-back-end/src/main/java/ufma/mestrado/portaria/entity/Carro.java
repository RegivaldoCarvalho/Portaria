package ufma.mestrado.portaria.entity;

import java.util.Set;
import javax.persistence.*;

@Entity
public class Carro{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String placa;
    private String modelo;
    
    @ManyToMany
    private Set<Permissao> roles;
    
    public Carro(){}
    
    public Carro(String placa, String modelo){
        super();
        this.placa = placa;
        this.modelo = modelo;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getPlaca() {
        return placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
  
}
