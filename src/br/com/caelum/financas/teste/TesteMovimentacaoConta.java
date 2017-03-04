package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		EntityManager manager;
		List<Conta> contas;
		Query query;

		manager = new JPAUtil().getEntityManager();
		query = manager.createQuery("SELECT c FROM Conta C");
		contas = query.getResultList();
		
		for (Conta conta : contas) {
			System.out.println(conta.getNumero());
			System.out.println(conta.getTitular() + "\n");
		}
	}
}
