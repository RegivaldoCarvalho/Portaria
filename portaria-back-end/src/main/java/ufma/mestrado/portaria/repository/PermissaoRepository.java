/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufma.mestrado.portaria.repository;

import ufma.mestrado.portaria.entity.Morador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author elias
 */
public interface PermissaoRepository extends JpaRepository<Morador,Long>{
    @Query("select p from Morador p where p.nome like %?1%")
    Morador findByNameLike(String name);
}
