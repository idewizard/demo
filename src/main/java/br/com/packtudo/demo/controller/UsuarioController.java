package br.com.packtudo.demo.controller;

import br.com.packtudo.demo.model.dto.NewUsuarioDTO;
import br.com.packtudo.demo.model.dto.UsuarioDTO;
import br.com.packtudo.demo.model.entity.Usuario;
import br.com.packtudo.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    public ResponseEntity<UsuarioDTO> add(@Valid @RequestBody NewUsuarioDTO dto){
        Usuario usuario = mapToEntity(dto);
        Usuario usuarioAdicionado = usuarioService.add(usuario);
        UsuarioDTO usuarioDTO = mapToDTO(usuarioAdicionado);
        return responseSucesso(usuarioDTO);
    }

    @DeleteMapping(value = "/{descLogin}")
    public ResponseEntity<Integer> deleteUsuario(@PathVariable String descLogin) {

        var isRemoved = usuarioService.deleteByDescLogin(descLogin);

        if (!isRemoved) {
            return responseNotFound();
        }

        return responseAnySucesso(descLogin);
    }

}
