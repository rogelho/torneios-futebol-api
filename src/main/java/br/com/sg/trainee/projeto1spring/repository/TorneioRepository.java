package br.com.sg.trainee.projeto1spring.repository;

import br.com.sg.trainee.projeto1spring.domain.Torneio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorneioRepository extends JpaRepository<Torneio, Integer> {
}
