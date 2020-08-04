package br.com.sg.trainee.projeto1spring.service;

import br.com.sg.trainee.projeto1spring.domain.Torneio;
import br.com.sg.trainee.projeto1spring.repository.TorneioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TorneioService {
    private final TorneioRepository repository;

    public TorneioService(TorneioRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Torneio salvarTorneio(Torneio torneio) {
        return this.repository.save(torneio);
    }

    @Transactional
    public Torneio buscarTorneio(int id) {
        Optional<Torneio> torneioNoBanco = this.repository.findById(id);

        if (torneioNoBanco.isPresent()) {
            return torneioNoBanco.get();
        }

        return null;
    }
}
