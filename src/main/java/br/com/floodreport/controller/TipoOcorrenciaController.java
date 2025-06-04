package br.com.floodreport.controller;

import br.com.floodreport.dto.TipoOcorrenciaDTO;
import br.com.floodreport.model.TipoOcorrencia;
import br.com.floodreport.repository.TipoOcorrenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos")
@RequiredArgsConstructor
public class TipoOcorrenciaController {

    private final TipoOcorrenciaRepository repository;

    @PostMapping
    public TipoOcorrencia criar(@RequestBody TipoOcorrenciaDTO dto) {
        var tipo = TipoOcorrencia.builder()
                .nome(dto.nome())
                .build();
        return repository.save(tipo);
    }

    @GetMapping
    public List<TipoOcorrencia> listar() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
