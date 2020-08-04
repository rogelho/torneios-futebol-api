package br.com.sg.trainee.projeto1spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Time {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String estadio;
}
