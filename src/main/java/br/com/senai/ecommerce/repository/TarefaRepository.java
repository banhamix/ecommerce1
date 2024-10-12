package br.com.senai.ecommerce.repository;

import br.com.senai.ecommerce.emtities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa,Long> {

}

