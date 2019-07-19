package ufma.mestrado.portaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ufma.mestrado.portaria.entity.User;
import ufma.mestrado.portaria.repository.UserRepository;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
    private UserRepository repository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.repository = userRepository;
    }
    
    @GetMapping("/user")
    public List<User> getUsers(){
    	return this.repository.findAll();
    }
    
    @PostMapping("/user")
    public User add(@RequestBody User user) {
      return this.repository.save(user);
    }
    
    @PutMapping("/user/{id}")
    public User replaceEmployee(@RequestBody User userRequest, @PathVariable Long id) {

      return repository.findById(id)
        .map(user -> {
          user.setName(userRequest.getName());
          user.setEmail(userRequest.getEmail());
          return repository.save(user);
        })
        .orElseGet(() -> {
          userRequest.setId(id);
          return repository.save(userRequest);
        });
    }
    
    @DeleteMapping("/user/{id}")
    void deleteEmployee(@PathVariable Long id) {
      repository.deleteById(id);
    }
}
