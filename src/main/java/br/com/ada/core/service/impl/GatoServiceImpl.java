package br.com.ada.core.service.impl;

import br.com.ada.core.data.entities.Gato;
import br.com.ada.core.data.repositories.DonoRepository;
import br.com.ada.core.data.repositories.GatoRepository;
import br.com.ada.core.service.GatoService;
import br.com.ada.dto.GatoDto;

public class GatoServiceImpl implements GatoService {

    private GatoRepository repository;
    private DonoRepository donoRepository;

    public GatoServiceImpl(GatoRepository repository, DonoRepository donoRepository){
        this.repository = repository;
        this.donoRepository = donoRepository;
    }

    @Override
    public GatoDto findById(Integer id) {

        Gato gatoEntity = repository.findById(id);

        GatoDto gatoDto = new GatoDto();
        gatoDto.setNome(gatoEntity.getNome());
        gatoDto.setId(gatoEntity.getId());
        gatoDto.setDataNascimento(gatoEntity.getDataNascimento());

        return gatoDto;
    }

    @Override
    public String createGato(GatoDto gatoDto) {

        Gato gatoEntity = new Gato();

        if (gatoDto.getNome().equalsIgnoreCase("TOM")){
            return "não pode colocar esse nome";
        }

        gatoEntity.setNome(gatoDto.getNome());
        gatoEntity.setDataNascimento(gatoDto.getDataNascimento());
        gatoEntity.setDono(donoRepository.findById(2));

        return repository.createGato(gatoEntity);
    }
}
