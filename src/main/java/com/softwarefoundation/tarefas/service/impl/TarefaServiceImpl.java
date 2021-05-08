package com.softwarefoundation.tarefas.service.impl;

import com.softwarefoundation.tarefas.dto.TarefaDto;
import com.softwarefoundation.tarefas.entity.Tarefa;
import com.softwarefoundation.tarefas.repository.TarefaRepository;
import com.softwarefoundation.tarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaServiceImpl implements TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Override
    public TarefaDto save(TarefaDto dto) {
        Tarefa tarefa = tarefaRepository.save(dto.toEntity());
        return tarefa.toDto();
    }

    @Override
    public TarefaDto findById(TarefaDto dto) {
        TarefaDto tarefaDto = new TarefaDto();
        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(dto.getId());
        if(tarefaOptional.isPresent()){
            tarefaDto = tarefaOptional.get().toDto();
        }
        return tarefaDto;
    }

    @Override
    public List<TarefaDto> findAll() {
        List<Tarefa> tarefas = tarefaRepository.findAll();
        List<TarefaDto> tarefaDtos = new ArrayList<>();
        tarefas.forEach(t->tarefaDtos.add(t.toDto()));
        return tarefaDtos;
    }

    @Override
    public void delete(TarefaDto dto) {
        TarefaDto tarefaDto = findById(dto);
        tarefaRepository.delete(tarefaDto.toEntity());
    }


}
