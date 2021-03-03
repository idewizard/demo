package br.com.packtudo.gaia.controller;

import br.com.packtudo.gaia.model.dto.ChamadoDTO;
import br.com.packtudo.gaia.model.dto.NewChamadoDTO;
import br.com.packtudo.gaia.model.entity.Chamado;
import br.com.packtudo.gaia.service.ChamadoService;
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
    public ResponseEntity<List<ChamadoDTO>> findAll(){
        return responseAnySucesso(mapToListDTO(chamadoService.findAll()));
    }

    @PostMapping
    public ResponseEntity<ChamadoDTO> add(@Valid @RequestBody NewChamadoDTO dto){
        Chamado chamado = mapToEntity(dto);
        Chamado chamadoAdicionado = chamadoService.add(chamado);
        ChamadoDTO chamadoDTO = mapToDTO(chamadoAdicionado);
        return responseSucesso(chamadoDTO);
    }
}
