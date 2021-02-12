package br.com.packtudo.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
public class UsuarioDTO {

    private short bolAtivo;
    private String descLogin;
    @JsonIgnoreProperties("usuario")
    private PerfilUsuarioDTO perfilUsuario;
    private List<GrupoPermissaoDTO> grupoPermissaos;
    private List<ChamadoDTO> chamadosUsuarioResponsavel;
    private List<ChamadoDTO> chamadosUsuarioSolicitante;

}
