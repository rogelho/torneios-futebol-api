package br.com.sg.trainee.projeto1spring.resource;

import br.com.sg.trainee.projeto1spring.domain.Classificacao;
import br.com.sg.trainee.projeto1spring.domain.Time;
import br.com.sg.trainee.projeto1spring.domain.Torneio;
import br.com.sg.trainee.projeto1spring.service.ClassificacaoService;
import br.com.sg.trainee.projeto1spring.service.TimeService;
import br.com.sg.trainee.projeto1spring.service.TorneioService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "torneio")
public class TorneioAPI {
    private final TorneioService torneioService;
    private final ClassificacaoService classificacaoService;
    private final TimeService timeService;

    public TorneioAPI(TorneioService torneioService,
                      ClassificacaoService classificacaoService,
                      TimeService timeService) {

        this.torneioService = torneioService;
        this.classificacaoService = classificacaoService;
        this.timeService = timeService;
    }

    @PostMapping(path = "salvar")
    public ResponseEntity salvarTorneio(@RequestBody Torneio torneio) {
        return ResponseEntity.ok(this.torneioService.salvarTorneio(torneio));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity buscarTorneio(@PathVariable int id) {
        return ResponseEntity.ok(this.torneioService.buscarTorneio(id));
    }

    @GetMapping(path = "inscrever/{torneio_id}/{time_id}")
    public ResponseEntity inscreverTime(@PathVariable int torneio_id, @PathVariable int time_id) {

        Torneio torneio = this.torneioService.buscarTorneio(torneio_id);
        Time time = this.timeService.buscarTime(time_id);
        Classificacao classificacao = new Classificacao();

        classificacao.setTorneio(torneio);
        classificacao.setTime(time);

        return ResponseEntity.ok(this.classificacaoService.inscreverTime(classificacao));
    }
}
