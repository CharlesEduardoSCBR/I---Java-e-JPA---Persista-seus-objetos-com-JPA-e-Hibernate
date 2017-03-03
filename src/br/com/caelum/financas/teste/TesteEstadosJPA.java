package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteEstadosJPA {

	public static void main(String[] args) {
		Conta conta;
		EntityManager manager;

		manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();

		conta = manager.find(Conta.class, 1);
		
		System.out.println(conta.getTitular());
		
		conta.setTitular("Luiz Ferreira");
		
		System.out.println(conta.getTitular());

		manager.getTransaction().commit();
		manager.close();
	}
}
