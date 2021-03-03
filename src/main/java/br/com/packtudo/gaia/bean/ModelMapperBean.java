package br.com.packtudo.gaia.bean;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class ModelMapperBean {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
