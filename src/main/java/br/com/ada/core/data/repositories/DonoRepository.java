package br.com.ada.core.data.repositories;

import br.com.ada.core.data.entities.Dono;

public interface DonoRepository {

    Dono findById(Integer id);

}
