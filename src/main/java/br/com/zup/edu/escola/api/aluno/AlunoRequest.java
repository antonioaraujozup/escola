package br.com.zup.edu.escola.api.aluno;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class AlunoRequest {

    @NotBlank
    private String nome;

    @NotNull
    @CPF
    @JsonProperty("cpf")
    private String CPF;

    @NotBlank
    @Size(max = 6)
    private String numeroMatricula;

    @NotNull
    @PastOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataMatricula;

    public AlunoRequest(String nome, String CPF, String numeroMatricula, LocalDate dataMatricula) {
        this.nome = nome;
        this.CPF = CPF;
        this.numeroMatricula = numeroMatricula;
        this.dataMatricula = dataMatricula;
    }

    public AlunoRequest() {
    }

    public Aluno toModel() {
        return new Aluno(nome,CPF,numeroMatricula,dataMatricula);
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }
}
