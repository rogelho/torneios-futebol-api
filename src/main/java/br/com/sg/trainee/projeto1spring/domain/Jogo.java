package br.com.sg.trainee.projeto1spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Jogo {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "torneio_id")
    private Torneio torneio;
    private String data;
    @ManyToOne
    @JoinColumn(name = "mandante_id")
    private Time mandante;
    private Integer mandante_gols = 0;
    @ManyToOne
    @JoinColumn(name = "visitante_id")
    private Time visitante;
    private Integer visitante_gols = 0;
}
