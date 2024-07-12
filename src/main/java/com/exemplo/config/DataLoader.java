package com.exemplo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.exemplo.model.Projeto;
import com.exemplo.model.Tarefa;
import com.exemplo.model.enumeration.Prioridade;
import com.exemplo.service.ProjetoService;
import com.exemplo.service.TarefaService;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class DataLoader {

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private TarefaService tarefaService;

    @PostConstruct
    public void init() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date dataInicio1 = dateFormat.parse("2024-01-01");
            Date dataInicio2 = dateFormat.parse("2024-02-01");
            Date dataInicio3 = dateFormat.parse("2024-03-01");

            Projeto projeto1 = new Projeto("Projeto Alpha", "Descrição do Projeto Alpha", dataInicio1);
            Projeto projeto2 = new Projeto("Projeto Beta", "Descrição do Projeto Beta", dataInicio2);
            Projeto projeto3 = new Projeto("Projeto Gamma", "Descrição do Projeto Gamma", dataInicio3);

            projetoService.salvar(projeto1);
            projetoService.salvar(projeto2);
            projetoService.salvar(projeto3);

            Tarefa tarefa1 = new Tarefa("Tarefa 1 do Projeto Alpha", "Descrição da Tarefa 1 do Projeto Alpha", Prioridade.ALTA, 5, projeto1);
            Tarefa tarefa2 = new Tarefa("Tarefa 2 do Projeto Alpha", "Descrição da Tarefa 2 do Projeto Alpha", Prioridade.MUITO_ALTA, 3, projeto1);
            Tarefa tarefa3 = new Tarefa("Tarefa 1 do Projeto Beta", "Descrição da Tarefa 1 do Projeto Beta", Prioridade.BAIXA, 8, projeto2);
            Tarefa tarefa4 = new Tarefa("Tarefa 2 do Projeto Beta", "Descrição da Tarefa 2 do Projeto Beta", Prioridade.ALTA, 4, projeto2);
            Tarefa tarefa5 = new Tarefa("Tarefa 1 do Projeto Gamma", "Descrição da Tarefa 1 do Projeto Gamma", Prioridade.MUITO_BAIXA, 2, projeto3);

            tarefaService.salvar(tarefa1);
            tarefaService.salvar(tarefa2);
            tarefaService.salvar(tarefa3);
            tarefaService.salvar(tarefa4);
            tarefaService.salvar(tarefa5);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
