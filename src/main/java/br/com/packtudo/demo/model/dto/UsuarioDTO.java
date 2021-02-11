package br.com.packtudo.demo.model.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class UsuarioDTO {

    private Integer idUsuario;
    private short bolAtivo;
    private Timestamp dataHoraInclusao;
    private String descLogin;
    private String descSenha;
    private PerfilUsuarioDTO perfilUsuario;
    private List<GrupoPermissaoDTO> grupoPermissaos;
    private List<ChamadoDTO> chamadosUsuarioResponsavel;
    private List<ChamadoDTO> chamadosUsuarioSolicitante;

}
