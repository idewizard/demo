package br.com.packtudo.demo.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.stream.Collectors;

public class AbstractController<E, D> {

    private final Logger logger;

    @Autowired
    private ModelMapper modelMapper;

    private final Class<E> typeEntity;
    private final Class<D> typeDTO;

    public AbstractController() {
        this.logger = LoggerFactory.getLogger(getClass());
        this.typeEntity = (Class<E>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        this.typeDTO = (Class<D>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
    }

    protected D mapToDTO(Object object){
        return modelMapper.map(object, typeDTO);
    }

    protected List<D> mapToListDTO(List<E> listEntitys){
        return listEntitys.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    protected E mapToEntity(Object object){
        return modelMapper.map(object, typeEntity);
    }

    protected ResponseEntity<D> responseSucesso(D dto) {
        return ResponseEntity.ok(dto);
    }
    
    protected ResponseEntity<List<D>> responseSucesso(List<D> dto) {
        return ResponseEntity.ok(dto);
    }

    protected ResponseEntity responseNotFound() {
        return ResponseEntity.notFound().build();
    }

    protected ResponseEntity responseAnySucesso(Object value) {
        return ResponseEntity.ok(value);
    }

    protected ResponseEntity<D> responseError(Exception e) {
        getLogger().error("Falha para o objeto: " + typeDTO.getClass(), e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    protected Logger getLogger() {
        return logger;
    }
}
