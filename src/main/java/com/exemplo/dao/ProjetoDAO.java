package com.exemplo.dao;

import com.exemplo.model.Projeto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProjetoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void salvar(Projeto projeto) {
		String hql = "UPDATE Projeto p SET p.titulo = :titulo, p.descricao = :descricao, p.dataInicio = :dataInicio WHERE p.id = :id";
		if (projeto.getId() == null) {
			entityManager.persist(projeto);
		} else {
			Query query = entityManager.createQuery(hql);
			query.setParameter("titulo", projeto.getTitulo());
			query.setParameter("descricao", projeto.getDescricao());
			query.setParameter("dataInicio", projeto.getDataInicio());
			query.setParameter("id", projeto.getId());
			query.executeUpdate();
		}
	}

	public Projeto buscarPorId(Long id) {
		String hql = "FROM Projeto p WHERE p.id = :id";
		Query query = entityManager.createQuery(hql, Projeto.class);
		query.setParameter("id", id);
		return (Projeto) query.getSingleResult();
	}

	public List<Projeto> listar() {
		String hql = "FROM Projeto";
		return entityManager.createQuery(hql, Projeto.class).getResultList();
	}

	@Transactional
	public void excluir(Long id) {
		String hql = "DELETE FROM Projeto p WHERE p.id = :id";
		Query query = entityManager.createQuery(hql);
		query.setParameter("id", id);
		query.executeUpdate();
	}
}
