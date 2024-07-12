package com.exemplo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.exemplo.model.enumeration.Prioridade;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 50)
    private String titulo;
    

    @NotNull
    @Size(max = 255)
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    private int estimativaHoras;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    @NotNull
    private Projeto projeto;

    public Tarefa() {
		
	}

	public Tarefa(@NotNull @Size(max = 50) String titulo, @NotNull @Size(max = 255) String descricao,
			Prioridade prioridade, int estimativaHoras, @NotNull Projeto projeto) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.estimativaHoras = estimativaHoras;
		this.projeto = projeto;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public int getEstimativaHoras() {
        return estimativaHoras;
    }

    public void setEstimativaHoras(int estimativaHoras) {
        this.estimativaHoras = estimativaHoras;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
}
