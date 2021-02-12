package br.com.packtudo.demo.controller;

import br.com.packtudo.demo.model.dto.UsuarioDTO;
import br.com.packtudo.demo.model.entity.Usuario;
import br.com.packtudo.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController extends AbstractController<Usuario, UsuarioDTO> {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> findAll(){
        return mapToListDTO(usuarioService.findAll());
    }
}
