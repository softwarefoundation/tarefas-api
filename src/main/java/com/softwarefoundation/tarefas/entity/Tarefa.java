package com.softwarefoundation.tarefas.entity;

import com.softwarefoundation.tarefas.dto.TarefaDto;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB01_TAREFA")
public class Tarefa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "CONCLUIDO")
    private Boolean concluido;

    @Column(name = "DATA_CADASTRO")
    private LocalDateTime dataCadastro;

    @Column(name = "DATA_CONCLUSAO")
    private LocalDateTime dataConclusao;

    public TarefaDto toDto() {
        return new ModelMapper().map(this, TarefaDto.class);
    }

}
