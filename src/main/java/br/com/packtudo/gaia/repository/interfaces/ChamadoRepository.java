package br.com.packtudo.gaia.repository.interfaces;

import br.com.packtudo.gaia.model.entity.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {
}
