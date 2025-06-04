package br.com.floodreport.controller;

import br.com.floodreport.dto.ReporteDTO;
import br.com.floodreport.model.Reporte;
import br.com.floodreport.repository.ReporteRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    private final ReporteRepository repository;

    @Autowired
    public ReporteController(ReporteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Reporte criarReporte(@RequestBody @Valid ReporteDTO dto) {
        Reporte reporte = new Reporte();
        reporte.setEndereco(dto.endereco());
        reporte.setLatitude(dto.latitude());
        reporte.setLongitude(dto.longitude());
        reporte.setDescricao(dto.descricao());
        return repository.save(reporte);
    }

    @GetMapping
    public Page<Reporte> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return repository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Reporte buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Reporte não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
