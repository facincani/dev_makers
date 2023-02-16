package br.com.ada.controller;

import br.com.ada.core.data.repositories.impl.DonoRepositoryImpl;
import br.com.ada.core.data.repositories.impl.GatoRepositoryImpl;
import br.com.ada.core.service.GatoService;
import br.com.ada.core.service.impl.GatoServiceImpl;
import br.com.ada.dto.GatoDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    GatoService service = new GatoServiceImpl(new GatoRepositoryImpl(), new DonoRepositoryImpl());

    @PostMapping
    public String criaGato(@RequestBody GatoDto gatoDto){

        service.createGato(gatoDto);

        return "Gato criado";
    }

    @GetMapping
    public String helo(){
        return "Helo Alex";
    }

}
