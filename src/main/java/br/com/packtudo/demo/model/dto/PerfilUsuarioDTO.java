package br.com.packtudo.demo.model.dto;

import lombok.Data;

@Data
public class PerfilUsuarioDTO {

    private Integer idPerfilUsuario;
    private String descEmail;
    private String descNome;
    private String descSobrenome;
    private UsuarioDTO usuario;

}
