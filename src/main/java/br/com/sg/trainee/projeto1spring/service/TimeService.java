package br.com.sg.trainee.projeto1spring.service;

import br.com.sg.trainee.projeto1spring.domain.Time;
import br.com.sg.trainee.projeto1spring.repository.TimeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TimeService {
    private final TimeRepository repository;

    public TimeService(TimeRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Time salvarTime(Time time) {
        return this.repository.save(time);
    }

    @Transactional
    public Time buscarTime(int id) {
        Optional<Time> timeNoBanco = this.repository.findById(id);

        if (timeNoBanco.isPresent()) {
            return timeNoBanco.get();
        }

        return null;
    }
}
