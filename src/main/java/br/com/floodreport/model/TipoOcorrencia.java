package br.com.floodreport.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipo_ocorrencia")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoOcorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;
}
