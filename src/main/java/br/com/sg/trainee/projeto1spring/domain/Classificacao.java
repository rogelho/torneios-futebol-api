package br.com.sg.trainee.projeto1spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Classificacao {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "torneio_id")
    private Torneio torneio;
    @ManyToOne
    @JoinColumn(name = "time_id")
    private Time time;
    private Integer pontos = 0;
    private Integer partidas = 0;
    private Integer vitorias = 0;
    private Integer derrotas = 0;
    private Integer empates  = 0;
    private Integer gols_pro = 0;
    private Integer gols_contra = 0;
    private Integer saldo = 0;
}
