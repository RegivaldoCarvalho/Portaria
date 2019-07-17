/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufma.mestrado.portaria.repository;

import ufma.mestrado.portaria.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author elias
 */
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long>{
    @Query("select a from Apartamento a where a.nome like %?1%")
    Funcionario findByNameLike(String nome);
}
