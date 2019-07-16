package ufma.mestrado.portaria.entity;

import java.util.Set;
import javax.persistence.*;

@Entity
public class Morador implements Pessoa{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cpf;
    
    @ManyToMany
    private Set<Carro> carros;
    
    @ManyToMany
    private Set<Apartamento> apartamentos;
    
    public Morador(){}
    
    public Morador(String name, String email){
        super();
        this.nome = name;
        this.cpf = email;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public String getNome() {
        return nome;
    }
    
    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String getCpf() {
        return cpf;
    }
    
    @Override
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

	public Set<Carro> getCarros() {
		return carros;
	}

	public void setCarros(Set<Carro> carros) {
		this.carros = carros;
	}

	public Set<Apartamento> getApartamentos() {
		return apartamentos;
	}

	public void setApartamentos(Set<Apartamento> apartamentos) {
		this.apartamentos = apartamentos;
	}
    
}
