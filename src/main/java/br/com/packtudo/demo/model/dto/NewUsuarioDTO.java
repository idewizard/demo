package br.com.packtudo.demo.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class NewUsuarioDTO extends UsuarioDTO {

    @Getter
    @Setter
    @NotBlank(message = "Campo senha é de preenchimento obrigatório.")
    private String descSenha;
}
