package com.exemplo.dao;

import org.springframework.stereotype.Repository;
import com.exemplo.model.Tarefa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TarefaDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void salvar(Tarefa tarefa) {
        if (tarefa.getId() == null) {
            entityManager.persist(tarefa);
        } else {
            String hql = "UPDATE Tarefa t SET t.titulo = :titulo, t.descricao = :descricao, t.prioridade = :prioridade, t.estimativaHoras = :estimativaHoras, t.projeto = :projeto WHERE t.id = :id";
            Query query = entityManager.createQuery(hql);
            query.setParameter("titulo", tarefa.getTitulo());
            query.setParameter("descricao", tarefa.getDescricao());
            query.setParameter("prioridade", tarefa.getPrioridade());
            query.setParameter("estimativaHoras", tarefa.getEstimativaHoras());
            query.setParameter("projeto", tarefa.getProjeto());
            query.setParameter("id", tarefa.getId());
            query.executeUpdate();
        }
    }

    public Tarefa buscarPorId(Long id) {
        String hql = "FROM Tarefa t WHERE t.id = :id";
        Query query = entityManager.createQuery(hql, Tarefa.class);
        query.setParameter("id", id);
        return (Tarefa) query.getSingleResult();
    }

    public List<Tarefa> listarPorProjeto(Long projetoId) {
        String hql = "FROM Tarefa t WHERE t.projeto.id = :projetoId";
        return entityManager.createQuery(hql, Tarefa.class)
                            .setParameter("projetoId", projetoId)
                            .getResultList();
    }

    @Transactional
    public void excluir(Long id) {
        String hql = "DELETE FROM Tarefa t WHERE t.id = :id";
        Query query = entityManager.createQuery(hql);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
