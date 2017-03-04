package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoMax {

	public static void main(String[] args) {
		EntityManager manager;
		Conta conta;
		TypedQuery<BigDecimal> query;
		BigDecimal maiorGasto;
		
		manager = new JPAUtil().getEntityManager();
		conta = manager.find(Conta.class, 2);
		
		query = manager.createQuery(
				" select max(m.valor) "
				+ " from Movimentacao m "
				+ "where m.conta = :pConta", BigDecimal.class);

		query.setParameter("pConta", conta);
		maiorGasto = query.getSingleResult();

		System.out.println("Maior gasto conta ...: " + maiorGasto);
		
		manager.close();
	}

}
