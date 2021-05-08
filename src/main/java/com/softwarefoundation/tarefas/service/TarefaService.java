package com.softwarefoundation.tarefas.service;

import com.softwarefoundation.tarefas.dto.TarefaDto;

import java.util.List;

public interface TarefaService {

    TarefaDto save(TarefaDto dto);

    TarefaDto findById(TarefaDto dto);

    List<TarefaDto> findAll();

    void delete(TarefaDto dto);

}
