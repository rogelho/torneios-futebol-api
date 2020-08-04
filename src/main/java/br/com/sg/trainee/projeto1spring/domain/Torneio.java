package br.com.sg.trainee.projeto1spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Torneio {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private Date datainicio;
    private Date datafim;
}
