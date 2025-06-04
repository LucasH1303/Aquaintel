package br.com.floodreport.controller;

import br.com.floodreport.dto.StatusOcorrenciaDTO;
import br.com.floodreport.model.StatusOcorrencia;
import br.com.floodreport.repository.StatusOcorrenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
@RequiredArgsConstructor
public class StatusOcorrenciaController {

    private final StatusOcorrenciaRepository repository;

    @PostMapping
    public StatusOcorrencia criar(@RequestBody StatusOcorrenciaDTO dto) {
        var status = StatusOcorrencia.builder()
                .nome(dto.nome())
                .build();
        return repository.save(status);
    }

    @GetMapping
    public List<StatusOcorrencia> listar() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
