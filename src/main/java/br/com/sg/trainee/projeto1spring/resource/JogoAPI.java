package br.com.sg.trainee.projeto1spring.resource;

import br.com.sg.trainee.projeto1spring.domain.Jogo;
import br.com.sg.trainee.projeto1spring.service.ClassificacaoService;
import br.com.sg.trainee.projeto1spring.service.JogoService;
import br.com.sg.trainee.projeto1spring.service.TimeService;
import br.com.sg.trainee.projeto1spring.service.TorneioService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "jogo")
public class JogoAPI {
    private final JogoService jogoService;
    private final TorneioService torneioService;
    private final ClassificacaoService classificacaoService;
    private final TimeService timeService;

    public JogoAPI(JogoService jogoService,
                   TorneioService torneioService,
                   ClassificacaoService classificacaoService,
                   TimeService timeService) {
        this.jogoService = jogoService;
        this.torneioService = torneioService;
        this.classificacaoService = classificacaoService;
        this.timeService = timeService;
    }

    @PostMapping(path = "salvar")
    public ResponseEntity salvarJogo(@RequestBody Jogo jogo) {

        this.classificacaoService.atualizarClassificacao(jogo);

        return ResponseEntity.ok(this.jogoService.salvarJogo(jogo));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity buscarJogo(@PathVariable int id) {
        return ResponseEntity.ok(this.jogoService.buscarJogo(id));
    }
}
