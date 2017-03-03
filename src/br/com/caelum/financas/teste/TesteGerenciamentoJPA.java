package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteGerenciamentoJPA {

	public static void main(String[] args) {
		EntityManager manager;
		Conta conta;

		manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();

		conta = manager.find(Conta.class, 1);

		manager.getTransaction().commit();

		conta.setTitular("Alura ensino e inovação");

		manager.getTransaction().begin();
		manager.merge(conta);
		manager.getTransaction().commit();
		manager.close();
	}
}
