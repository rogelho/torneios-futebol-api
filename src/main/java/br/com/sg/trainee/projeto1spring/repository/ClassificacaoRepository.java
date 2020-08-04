package br.com.sg.trainee.projeto1spring.repository;

import br.com.sg.trainee.projeto1spring.domain.Classificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassificacaoRepository extends JpaRepository<Classificacao, Integer> {

    @Query(value = "SELECT * FROM CLASSIFICACAO WHERE TORNEIO_ID = ?1 AND TIME_ID = ?2", nativeQuery = true)
    Classificacao findByTorneioTime(int torneio, int time);

    @Query(value = "SELECT * FROM CLASSIFICACAO WHERE TORNEIO_ID = ?1 ORDER BY PONTOS DESC", nativeQuery = true)
    List<Classificacao> findByTorneio(int torneio);
}
