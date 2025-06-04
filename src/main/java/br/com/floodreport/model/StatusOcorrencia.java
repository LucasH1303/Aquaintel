package br.com.floodreport.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "status_ocorrencia")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatusOcorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;
}
