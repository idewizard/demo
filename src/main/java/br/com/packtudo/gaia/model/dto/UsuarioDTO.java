package br.com.packtudo.gaia.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class UsuarioDTO {

    private Integer idUsuario;

    private short bolAtivo;

    @NotBlank(message = "Campo login é de preenchimento obrigatório.")
    private String descLogin;

    @JsonIgnoreProperties("usuario")
    private PerfilUsuarioDTO perfilUsuario;
    private List<GrupoPermissaoDTO> grupoPermissaos;

}
