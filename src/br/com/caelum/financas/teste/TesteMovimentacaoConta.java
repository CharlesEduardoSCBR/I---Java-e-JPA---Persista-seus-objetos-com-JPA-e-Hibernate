package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		EntityManager manager;
		Movimentacao movimentacao;

		manager = new JPAUtil().getEntityManager();
		movimentacao = manager.find(Movimentacao.class, 2);
		
		System.out.println(movimentacao.getConta().getTitular());
	}
}
