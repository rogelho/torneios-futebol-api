package br.com.sg.trainee.projeto1spring.service;

import br.com.sg.trainee.projeto1spring.domain.Jogo;
import br.com.sg.trainee.projeto1spring.repository.JogoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class JogoService {
    private final JogoRepository repository;

    public JogoService(JogoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Jogo salvarJogo(Jogo jogo) {
        return this.repository.save(jogo);
    }

    @Transactional
    public Jogo buscarJogo(int id) {
        Optional<Jogo> jogoNoBanco = this.repository.findById(id);

        if (jogoNoBanco.isPresent()) {
            return jogoNoBanco.get();
        }

        return null;
    }
}
