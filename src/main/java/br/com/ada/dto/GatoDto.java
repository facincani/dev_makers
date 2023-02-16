package br.com.ada.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GatoDto {

    private Integer id;
    private String nome;
    private Date dataNascimento;

}
