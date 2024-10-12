package br.com.senai.ecommerce.controller;

import br.com.senai.ecommerce.emtities.Tarefa;
import br.com.senai.ecommerce.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController//suporta apenas dados
    @RequestMapping("/Tarefa")//localhost:8080/Tarefa

    public class TarefaController {
        //injeçao de dependencia
        @Autowired
        private TarefaRepository TarefaRepository;

        //metodo pra criar usuario
        @PostMapping
        public Tarefa createUsuario(@RequestBody Tarefa Tarefa) {
            return TarefaRepository.save(Tarefa);
        }

        //listar todos os usuarios banco dados
        @GetMapping
        public List<Tarefa> getAllTarefas() {
            //SELECT * FROM Tarefa
            return TarefaRepository.findAll();
        }

        //pegar um usuario pelo seu id
        @GetMapping("/{id}")
        public Tarefa getTarefaById(@PathVariable Long id) {
            return TarefaRepository.findById(id).orElse(null);
        }

        //deletar um usuario
        @DeleteMapping("/{id}")
        public void deleteTarefa(@PathVariable Long id) {
            TarefaRepository.deleteById(id);
        }

        //atualizar informaçoes do usuario pelo id
        @PutMapping("/{id}")
        public Tarefa updateTarefa(@PathVariable Long id,
                                   @RequestBody Tarefa Tarefa) {
            Tarefa usuario = TarefaRepository.findById(id).orElse(null);
            if (Tarefa != null) {
                Tarefa.setDescription(Tarefa.getDescription());
                Tarefa.setTitle(Tarefa.getTitle());
                return TarefaRepository.save(Tarefa);
            }
            return null;
        }
    }


    
