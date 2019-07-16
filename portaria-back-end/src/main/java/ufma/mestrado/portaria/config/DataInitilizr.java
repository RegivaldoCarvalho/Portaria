package ufma.mestrado.portaria.config;

import java.util.List;
import ufma.mestrado.portaria.entity.User;
import ufma.mestrado.portaria.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataInitilizr implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    UserRepository userRepository;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        List<User> users = userRepository.findAll();
        if(users.isEmpty()){
            this.create("Elias Bruno", "elias.ccarneiro@gmail.com");
            this.create("Jeciane Ferreira", "jeciane.ferreira@hotmail.com");
            this.create("Joel Carlos", "carlos@hotmail.com");
        }
        User user = userRepository.findByNameLike("Elias");
//        User user = userRepository.getOne(1L);
//        user.setName("Joao Alvez de Souza");
//        user.setEmail("joao.sousa@ferrazdenovo.com");
//        userRepository.save(user);
        System.out.println("Dados :" + user.getName() +" | "+ user.getEmail());
    }
    
    public void create(String name, String email){
        User user = new User(name,email);
        userRepository.save(user);
    }
    
}
