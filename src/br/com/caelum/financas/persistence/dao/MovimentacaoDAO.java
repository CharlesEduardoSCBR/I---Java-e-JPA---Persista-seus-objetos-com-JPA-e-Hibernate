package br.com.caelum.financas.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;

public class MovimentacaoDAO {

	private EntityManager manager;

	public MovimentacaoDAO(EntityManager manager) {
		this.manager = manager;
	}

	public Double mediaDaConta(Conta conta) {
		TypedQuery<Double> query = manager.createQuery(
				"select avg(m.valor) from Movimentacao m where m.conta=:pConta and m.tipoMovimentacao = 'SAIDA'",
				Double.class);
		query.setParameter("pConta", conta);
		return query.getSingleResult();
	}
}
