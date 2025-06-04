package br.com.floodreport.repository;

import br.com.floodreport.model.StatusOcorrencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusOcorrenciaRepository extends JpaRepository<StatusOcorrencia, Long> {
}
