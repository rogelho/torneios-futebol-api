package br.com.sg.trainee.projeto1spring.resource;

import br.com.sg.trainee.projeto1spring.domain.Classificacao;
import br.com.sg.trainee.projeto1spring.service.ClassificacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "classificacao")
public class ClassificacaoAPI {
    private final ClassificacaoService classificacaoService;

    public ClassificacaoAPI(ClassificacaoService classificacaoService) {
        this.classificacaoService = classificacaoService;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity listar(@PathVariable int id) {
        return ResponseEntity.ok(this.classificacaoService.listar(id));
    }
}
