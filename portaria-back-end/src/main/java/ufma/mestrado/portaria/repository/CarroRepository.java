/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufma.mestrado.portaria.repository;

import ufma.mestrado.portaria.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author elias
 */
public interface CarroRepository extends JpaRepository<Carro,Long>{
    @Query("select c from Carro c where c.placa like %?1%")
    Carro findByNameLike(String placa);
}
