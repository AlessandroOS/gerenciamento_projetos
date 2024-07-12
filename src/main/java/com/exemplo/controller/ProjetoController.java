package com.exemplo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.exemplo.model.Projeto;
import com.exemplo.model.Tarefa;
import com.exemplo.model.enumeration.Prioridade;
import com.exemplo.service.ProjetoService;
import com.exemplo.service.TarefaService;

@Controller
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private TarefaService tarefaService;

    private Projeto projeto;
    private List<Projeto> projetos;
    private List<Tarefa> tarefas;
    private List<SelectItem> prioridades;
    private Tarefa tarefa;

    @PostConstruct
    public void init() {
        projeto = new Projeto();
        tarefa = new Tarefa();
        atualizarProjetos();

        prioridades = new ArrayList<>();
        for (Prioridade p : Prioridade.values()) {
            prioridades.add(new SelectItem(p, p.getDescricao()));
        }
    }

    public void salvarProjeto() {
        projetoService.salvar(projeto);
        projeto = new Projeto();
        atualizarProjetos();
    }

    public void editarProjeto(Projeto projeto) {
        this.projeto = projeto;
        atualizarTarefas(projeto.getId());
    }

    public void excluirProjeto(Long id) {
        projetoService.excluir(id);
        atualizarProjetos();
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    private void atualizarProjetos() {
        projetos = projetoService.listar();
    }

    public List<SelectItem> getPrioridades() {
        return prioridades;
    }

    public void setPrioridades(List<SelectItem> prioridades) {
        this.prioridades = prioridades;
    }

    public void salvarTarefa() {
        if (projeto == null || projeto.getId() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Tarefa deve estar vinculada a um projeto."));
            return;
        }
        tarefa.setProjeto(projeto);
        tarefaService.salvar(tarefa);
        tarefa = new Tarefa();
        atualizarTarefas(projeto.getId());
    }

    public void editarTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public void excluirTarefa(Long id) {
        tarefaService.excluir(id);
        atualizarTarefas(projeto.getId());
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    private void atualizarTarefas(Long projetoId) {
        tarefas = tarefaService.listarPorProjeto(projetoId);
    }
    
    public void adicionarTarefa(Projeto projeto) {
    	this.projeto = projeto;
        atualizarTarefas(projeto.getId());
    }
    
    public void limparCampos() {
        projeto = new Projeto();
        tarefa = new Tarefa();
        atualizarTarefas(projeto.getId());
    }
}
