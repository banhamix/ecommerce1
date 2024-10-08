package br.com.senai.ecommerce.controller;

import br.com.senai.ecommerce.emtities.User;
import br.com.senai.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//suporta apenas dados
@RequestMapping("/user")//localhost:8080/user

public class UserController {
    //injeçao de dependencia
    @Autowired
    private UserRepository userRepository;

   //metodo pra criar usuario
    @PostMapping
    public User createUsuario(@RequestBody User user){
        return  userRepository.save(user);
    }
    //listar todos os usuarios banco dados
    @GetMapping
    public List<User> getAllUsers(){
        //SELECT * FROM user
        return userRepository.findAll();
    }
    //pegar um usuario pelo seu id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return  userRepository.findById(id).orElse(null);
    }
    //deletar um usuario
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }
    //atualizar informaçoes do usuario pelo id
    @PutMapping("/{id}")
    public  User updateUser(@PathVariable Long id,
                            @RequestBody User user){
        User usuario = userRepository.findById(id).orElse(null);
        if (usuario != null){
            usuario.setName(user.getName());
            usuario.setEmail(user.getEmail());
            usuario.setPassword(user.getPassword());
            return userRepository.save(usuario);
        }
        return  null;
    }


}
