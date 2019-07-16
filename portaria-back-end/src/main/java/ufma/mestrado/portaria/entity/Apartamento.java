package ufma.mestrado.portaria.entity;

import java.util.Set;
import javax.persistence.*;

@Entity
public class Apartamento{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bloco;
    private Integer andar;
    private Integer numero;
    
    @ManyToMany
    private Set<Permissao> roles;
    
    public Apartamento(){}
    
    public Apartamento(String bloco, Integer andar, Integer numero){
        super();
        this.bloco = bloco;
        this.andar = andar;
        this.numero = numero;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public Integer getAndar() {
		return andar;
	}

	public void setAndar(Integer andar) {
		this.andar = andar;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
    
}
