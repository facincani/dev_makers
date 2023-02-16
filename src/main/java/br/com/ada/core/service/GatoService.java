package br.com.ada.core.service;

import br.com.ada.dto.GatoDto;

public interface GatoService {

    GatoDto findById(Integer id);
    String createGato(GatoDto gatoDto);

}
