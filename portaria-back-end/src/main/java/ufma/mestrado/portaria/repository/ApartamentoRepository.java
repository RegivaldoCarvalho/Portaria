/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufma.mestrado.portaria.repository;

import ufma.mestrado.portaria.entity.Apartamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author elias
 */
public interface ApartamentoRepository extends JpaRepository<Apartamento,Long>{
    @Query("select a from Apartamento a where a.bloco like %?1%")
    Apartamento findByBlocoLike(String name);
}
