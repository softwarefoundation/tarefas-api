package com.softwarefoundation.tarefas.resource;

import com.softwarefoundation.tarefas.dto.TarefaDto;
import com.softwarefoundation.tarefas.service.TarefaService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tarefa")
public class TarefaResource {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    @ApiResponses({@ApiResponse(code = 201, message = "Created")
            , @ApiResponse(code = 400, message = "Bad Request")
            , @ApiResponse(code = 404, message = "Not Foound")
            , @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<TarefaDto> save(@RequestBody TarefaDto dto) {
        TarefaDto tarefaDto = tarefaService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaDto);
    }

    @GetMapping("/{id}")
    @ApiResponses({@ApiResponse(code = 200, message = "Ok")
            , @ApiResponse(code = 400, message = "Bad Request")
            , @ApiResponse(code = 404, message = "Not Foound")
            , @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<TarefaDto> findById(@PathVariable Long id) {
        TarefaDto dto = new TarefaDto();
        dto.setId(id);
        TarefaDto tarefaDto = tarefaService.findById(dto);
        return ResponseEntity.status(HttpStatus.OK).body(tarefaDto);
    }

    @GetMapping("/todos")
    @ApiResponses({@ApiResponse(code = 200, message = "Ok")
            , @ApiResponse(code = 400, message = "Bad Request")
            , @ApiResponse(code = 404, message = "Not Foound")
            , @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<List<TarefaDto>> findAll() {
        List<TarefaDto> tarefaDtos = tarefaService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(tarefaDtos);
    }

    @DeleteMapping("/{id}")
    @ApiResponses({@ApiResponse(code = 200, message = "Ok")
            , @ApiResponse(code = 400, message = "Bad Request")
            , @ApiResponse(code = 404, message = "Not Foound")
            , @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<TarefaDto> delete(@PathVariable(name = "id") Long id) {
        log.info("Deletar tarefa: {}", id);
        TarefaDto dto = new TarefaDto();
        dto.setId(id);
        tarefaService.delete(dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

}
