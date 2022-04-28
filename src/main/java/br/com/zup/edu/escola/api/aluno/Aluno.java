package br.com.zup.edu.escola.api.aluno;

import javax.persistence.*;
import java.time.LocalDate;

@Table(uniqueConstraints = {
        @UniqueConstraint(name = "Unique_Aluno_numero_data_matricula", columnNames = {"numeroMatricula","dataMatricula"}),
        @UniqueConstraint(name = "UK_Aluno_numero_matricula", columnNames = {"numeroMatricula"})
})
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 11)
    private String CPF;

    @Column(nullable = false, length = 6)
    private String numeroMatricula;

    @Column(nullable = false)
    private LocalDate dataMatricula;

    public Aluno(String nome, String CPF, String numeroMatricula, LocalDate dataMatricula) {
        this.nome = nome;
        this.CPF = CPF;
        this.numeroMatricula = numeroMatricula;
        this.dataMatricula = dataMatricula;
    }

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate.
     */
    @Deprecated
    public Aluno() {
    }

    public Long getId() {
        return id;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }
}
