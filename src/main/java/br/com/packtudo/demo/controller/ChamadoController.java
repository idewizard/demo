package br.com.packtudo.demo.controller;

import br.com.packtudo.demo.model.dto.ChamadoDTO;
import br.com.packtudo.demo.model.dto.NewChamadoDTO;
import br.com.packtudo.demo.model.dto.NewUsuarioDTO;
import br.com.packtudo.demo.model.dto.UsuarioDTO;
import br.com.packtudo.demo.model.entity.Chamado;
import br.com.packtudo.demo.model.entity.Usuario;
import br.com.packtudo.demo.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/chamados")
public class ChamadoController extends AbstractController<Chamado, ChamadoDTO> {

    @Autowired
    private ChamadoService chamadoService;

    @GetMapping
    public List<ChamadoDTO> findAll(){
        return mapToListDTO(chamadoService.findAll());
    }

    @PostMapping
    public ResponseEntity<ChamadoDTO> add(@Valid @RequestBody NewChamadoDTO dto){
        Chamado chamado = mapToEntity(dto);
        Chamado chamadoAdicionado = chamadoService.add(chamado);
        ChamadoDTO chamadoDTO = mapToDTO(chamadoAdicionado);
        return responseSucesso(chamadoDTO);
    }
}
