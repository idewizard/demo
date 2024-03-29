package br.com.packtudo.gaia.service;

import br.com.packtudo.gaia.model.entity.Chamado;
import br.com.packtudo.gaia.repository.impl.ChamadoRepositoryExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamadoService extends  AbstractService<Chamado> {

    @Autowired
    private ChamadoRepositoryExtension chamadoRepository;

    public List<Chamado> findAll() {
        return chamadoRepository.findAll();
    }

    public Chamado add(Chamado chamado) {
        return chamadoRepository.add(chamado);
    }
}
