package br.com.ada.core.data.entities;

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
//    @Column(name = "ID_DONO")
//    private Integer idDono;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ID_DONO")
    private Dono dono;

}
