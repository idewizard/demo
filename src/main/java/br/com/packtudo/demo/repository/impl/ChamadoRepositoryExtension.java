package br.com.packtudo.demo.repository.impl;

import br.com.packtudo.demo.model.entity.Chamado;
import br.com.packtudo.demo.repository.interfaces.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChamadoRepositoryExtension {

    @Autowired
    private ChamadoRepository chamadoRepository;

    public List<Chamado> findAll() {
        return chamadoRepository.findAll();
    }

    public Chamado add(Chamado chamado) {
        return chamadoRepository.save(chamado);
    }
}
