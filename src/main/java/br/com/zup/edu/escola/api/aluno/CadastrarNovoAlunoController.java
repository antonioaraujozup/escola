package br.com.zup.edu.escola.api.aluno;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
public class CadastrarNovoAlunoController {

    private final AlunoRepository repository;

    public CadastrarNovoAlunoController(AlunoRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/alunos")
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid AlunoRequest request, UriComponentsBuilder uriComponentsBuilder) {
        if (repository.existsByNumeroMatriculaAndDataMatricula(request.getNumeroMatricula(), request.getDataMatricula())) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Aluno já cadastrado");
        }

        Aluno aluno = request.toModel();

        repository.save(aluno);

        URI location = uriComponentsBuilder.path("/alunos/{id}")
                .buildAndExpand(aluno.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
