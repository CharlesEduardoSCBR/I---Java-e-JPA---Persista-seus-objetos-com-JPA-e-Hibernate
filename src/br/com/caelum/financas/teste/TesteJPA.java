package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;

public class TesteJPA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		double inicio = System.currentTimeMillis();
		
		Conta conta = new Conta();
		conta.setTitular("Maria dos Santos");
		conta.setBanco("Caixa");
		conta.setAgencia("043");
		conta.setNumero("54321");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas-mysql");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close();
		
		double fim = System.currentTimeMillis();
		System.out.println("Executado em: " + (fim - inicio)/1000 + "s");
	}
}
