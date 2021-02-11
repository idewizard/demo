package br.com.packtudo.demo.model.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PerfilUsuarioDTO {

    private Integer idPerfilUsuario;
    private Timestamp dataHoraInclusao;
    private String descEmail;
    private String descNome;
    private String descSobrenome;
    private UsuarioDTO usuario;

}
