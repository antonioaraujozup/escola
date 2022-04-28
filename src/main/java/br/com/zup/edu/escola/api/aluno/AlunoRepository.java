package br.com.zup.edu.escola.api.aluno;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
    boolean existsByNumeroMatriculaAndDataMatricula(String numeroMatricula, LocalDate dataMatricula);
}
