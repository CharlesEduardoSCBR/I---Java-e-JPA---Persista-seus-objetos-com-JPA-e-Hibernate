package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaConsultaFuncaoCount {

	public static void main(String[] args) {
		EntityManager manager;
		Conta conta;
		Query query;
		Long quantidade;
		
		manager = new JPAUtil().getEntityManager();
		conta = manager.find(Conta.class, 2);
		
		query = manager.createQuery(
				" select count(m) "
				+ " from Movimentacao m "
				+ "where m.conta = :pConta");

		query.setParameter("pConta", conta);
		quantidade = (Long) query.getSingleResult();
		
		System.out.println("Quantidade de movimentações ..: " + quantidade);
		
	}

}
