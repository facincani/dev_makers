package br.com.ada.core.data.repositories;

import br.com.ada.core.data.entities.Gato;

public interface GatoRepository {

    Gato findById(Integer id);
    String createGato(Gato gato);

}
