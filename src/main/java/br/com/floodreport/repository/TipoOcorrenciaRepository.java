package br.com.floodreport.repository;

import br.com.floodreport.model.TipoOcorrencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoOcorrenciaRepository extends JpaRepository<TipoOcorrencia, Long> {
}
