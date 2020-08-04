package br.com.sg.trainee.projeto1spring.service;

import br.com.sg.trainee.projeto1spring.domain.Classificacao;
import br.com.sg.trainee.projeto1spring.domain.Jogo;
import br.com.sg.trainee.projeto1spring.domain.Time;
import br.com.sg.trainee.projeto1spring.domain.Torneio;
import br.com.sg.trainee.projeto1spring.repository.ClassificacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;

@Service
public class ClassificacaoService {
    private final ClassificacaoRepository repository;
    private final TimeService timeservice;

    public ClassificacaoService(ClassificacaoRepository repository,
                                TimeService timeservice) {
        this.repository = repository;
        this.timeservice = timeservice;
    }

    @Transactional
    public Classificacao inscreverTime(Classificacao classificacao) {
        return this.repository.save(classificacao);
    }

    @Transactional
    public Classificacao atualizarClassificacao(Jogo jogo) {
        Time mandante   = jogo.getMandante();
        Time visitante  = jogo.getVisitante();
        Torneio torneio = jogo.getTorneio();

        int mandante_id  = mandante.getId();
        int visitante_id = visitante.getId();
        int torneio_id   = torneio.getId();

        Classificacao classificacaoMandante  = this.repository.findByTorneioTime(torneio_id, mandante_id);
        Classificacao classificacaoVisitante = this.repository.findByTorneioTime(torneio_id, visitante_id);

        int golsMandante  = jogo.getMandante_gols();
        int golsVisitante = jogo.getVisitante_gols();

        classificacaoMandante.setPartidas(classificacaoMandante.getPartidas() + 1);
        classificacaoMandante.setGols_pro(classificacaoMandante.getGols_pro() + golsMandante);
        classificacaoMandante.setGols_contra(classificacaoMandante.getGols_contra() + golsVisitante);
        classificacaoMandante.setSaldo(classificacaoMandante.getGols_pro() - classificacaoMandante.getGols_contra());

        classificacaoVisitante.setPartidas(classificacaoVisitante.getPartidas() + 1);
        classificacaoVisitante.setGols_pro(classificacaoVisitante.getGols_pro() + golsVisitante);
        classificacaoVisitante.setGols_contra(classificacaoVisitante.getGols_contra() + golsMandante);
        classificacaoVisitante.setSaldo(classificacaoVisitante.getGols_pro() - classificacaoVisitante.getGols_contra());

        if (golsMandante == golsVisitante){
            classificacaoMandante.setEmpates(classificacaoMandante.getEmpates() + 1);
            classificacaoMandante.setPontos(classificacaoMandante.getPontos() + 1);

            classificacaoVisitante.setEmpates(classificacaoVisitante.getEmpates() + 1);
            classificacaoVisitante.setPontos(classificacaoVisitante.getPontos() + 1);
        } else if (golsMandante > golsVisitante){
            classificacaoMandante.setVitorias(classificacaoMandante.getVitorias() + 1);
            classificacaoMandante.setPontos(classificacaoMandante.getPontos() + 3);

            classificacaoVisitante.setDerrotas(classificacaoVisitante.getDerrotas() + 1);
        } else {
            classificacaoMandante.setDerrotas(classificacaoMandante.getDerrotas() + 1);

            classificacaoVisitante.setVitorias(classificacaoVisitante.getVitorias() + 1);
            classificacaoVisitante.setPontos(classificacaoVisitante.getPontos() + 3);
        }

        this.repository.save(classificacaoMandante);

        return this.repository.save(classificacaoVisitante);
    }

    @Transactional
    public Classificacao buscar(int id) {
        Optional<Classificacao> timeNoBanco = this.repository.findById(id);

        if (timeNoBanco.isPresent()) {
            return timeNoBanco.get();
        }

        return null;
    }

    @Transactional
    public List<Classificacao> listar(int id) {
        List<Classificacao> torneioNoBanco = this.repository.findByTorneio(id);

        return torneioNoBanco;
    }
}
