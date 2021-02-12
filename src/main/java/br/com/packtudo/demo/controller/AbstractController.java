package br.com.packtudo.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.stream.Collectors;

public class AbstractController<E, D> {

    @Autowired
    private ModelMapper modelMapper;

    private final Class<E> typeEntity;
    private final Class<D> typeDTO;

    public AbstractController() {
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
}
