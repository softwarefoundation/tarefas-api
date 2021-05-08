package com.softwarefoundation.tarefas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.softwarefoundation.tarefas.entity.Tarefa;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class TarefaDto implements Serializable {

    private Long id;
    private String descricao;
    private Boolean concluido;
    private LocalDateTime dataCadastro;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataConclusao;

    public Tarefa toEntity() {
        return new ModelMapper().map(this, Tarefa.class);
    }
}
