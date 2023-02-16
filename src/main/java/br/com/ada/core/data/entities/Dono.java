package br.com.ada.core.data.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DONO")
@Getter
@Setter
public class Dono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @OneToMany(mappedBy = "dono", cascade = CascadeType.MERGE)
    private List<Gato> gatos;

}
