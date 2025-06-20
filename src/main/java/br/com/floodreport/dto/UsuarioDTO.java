package br.com.floodreport.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(
    @NotBlank String nome,
    @NotBlank @Email String email,
    @NotBlank String senha
) {}
