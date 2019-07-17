/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufma.mestrado.portaria.repository;

import ufma.mestrado.portaria.entity.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author elias
 */
public interface VisitanteRepository extends JpaRepository<Visitante,Long>{
    @Query("select v from Visitante v where v.nome like %?1%")
    Visitante findByNameLike(String name);
}
