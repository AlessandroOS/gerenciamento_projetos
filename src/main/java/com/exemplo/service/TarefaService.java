package com.exemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.dao.TarefaDAO;
import com.exemplo.model.Tarefa;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaDAO tarefaDAO;

    public void salvar(Tarefa tarefa) {
        tarefaDAO.salvar(tarefa);
    }

    public Tarefa buscarPorId(Long id) {
        return tarefaDAO.buscarPorId(id);
    }

    public List<Tarefa> listarPorProjeto(Long projetoId) {
        return tarefaDAO.listarPorProjeto(projetoId);
    }

    public void excluir(Long id) {
        tarefaDAO.excluir(id);
    }
}