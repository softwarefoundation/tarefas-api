package com.softwarefoundation.tarefas.repository;

import com.softwarefoundation.tarefas.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa,Long> {

}
