package br.com.ada.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "GATO")
@Getter
@Setter
public class Gato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String nome;
    @Column(name = "DT_NASCIMENTO")
    private Date dataNascimento;
    @Column(name = "ID_DONO")
    private Integer idDono;

}
