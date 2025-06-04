package br.com.floodreport.dto;

import jakarta.validation.constraints.*;

public record ReporteDTO(
    @NotBlank(message = "O endereço é obrigatório")
    String endereco,

    @NotNull(message = "A latitude é obrigatória")
    Double latitude,

    @NotNull(message = "A longitude é obrigatória")
    Double longitude,

    @NotBlank(message = "A descrição é obrigatória")
    String descricao
) {}
