package br.com.floodreport.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;

    @NotNull(message = "A latitude é obrigatória")
    private Double latitude;

    @NotNull(message = "A longitude é obrigatória")
    private Double longitude;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    private LocalDateTime dataHora = LocalDateTime.now();

    public Reporte() {
    }

    public Reporte(Long id, String endereco, Double latitude, Double longitude, String descricao, LocalDateTime dataHora) {
        this.id = id;
        this.endereco = endereco;
        this.latitude = latitude;
        this.longitude = longitude;
        this.descricao = descricao;
        this.dataHora = dataHora;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}

