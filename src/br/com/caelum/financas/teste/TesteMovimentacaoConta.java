package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		EntityManager manager;
		Conta conta;

		manager = new JPAUtil().getEntityManager();
		conta = manager.find(Conta.class, 2);
		
		manager.close();
		
		System.out.println(conta.getMovimentacoes().size());
	}
}
