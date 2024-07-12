package com.exemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.dao.ProjetoDAO;
import com.exemplo.model.Projeto;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoDAO projetoDAO;

    public void salvar(Projeto projeto) {
        projetoDAO.salvar(projeto);
    }

    public Projeto buscarPorId(Long id) {
        return projetoDAO.buscarPorId(id);
    }

    public List<Projeto> listar() {
        return projetoDAO.listar();
    }

    public void excluir(Long id) {
        projetoDAO.excluir(id);
    }
}