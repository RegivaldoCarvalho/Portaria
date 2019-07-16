/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufma.mestrado.portaria.repository;

import ufma.mestrado.portaria.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author elias
 */
public interface UserRepository extends JpaRepository<User,Long>{
    @Query("select u from User u where u.name like %?1%")
    User findByNameLike(String name);
}
