package br.com.packtudo.gaia.utils;

import br.com.packtudo.gaia.model.dto.ChamadoDTO;
import br.com.packtudo.gaia.model.entity.Chamado;
import br.com.packtudo.gaia.model.entity.Usuario;
import br.com.packtudo.gaia.model.enums.EnumStatusChamado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;

public abstract class UtilsTest {

    @Autowired
    private ModelMapper modelMapper;

    protected Chamado obterChamado(Integer idChamado){
        Chamado chamado = new Chamado();
        chamado.setIdChamado(idChamado);
        chamado.setDescChamado("Chamado de Teste");
        chamado.setDescTituloChamado("Titulo do Chamado");
        chamado.setStatusChamado(EnumStatusChamado.NOVO.getEntidade());
        chamado.setDataHoraInclusao(new Timestamp(new Date().getTime()));
        chamado.setUsuarioSolicitante(Usuario.of(1));
        chamado.setUsuarioResponsavel(Usuario.of(1));
        return chamado;
    }

    protected ChamadoDTO obterChamadoDTO(Integer idChamado){
        return modelMapper.map(obterChamado(idChamado), ChamadoDTO.class);
    }
}
