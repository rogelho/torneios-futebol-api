package br.com.sg.trainee.projeto1spring.resource;

import br.com.sg.trainee.projeto1spring.domain.Time;
import br.com.sg.trainee.projeto1spring.service.TimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "time")
public class TimeAPI {
    private final TimeService timeService;

    public TimeAPI(TimeService timeService) {
        this.timeService = timeService;
    }

    @PostMapping(path = "salvar")
    public ResponseEntity salvarTime(@RequestBody Time time) {
        return ResponseEntity.ok(this.timeService.salvarTime(time));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity buscarTIme(@PathVariable int id) {
        return ResponseEntity.ok(this.timeService.buscarTime(id));
    }
}
