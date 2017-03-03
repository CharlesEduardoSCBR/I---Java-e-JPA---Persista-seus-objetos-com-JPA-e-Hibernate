package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {
		Conta conta;
		EntityManager em;
		Movimentacao movimentacao;

		conta = new Conta();
		conta.setTitular("Ana Maria");
		conta.setBanco("Itau");
		conta.setAgencia("111");
		conta.setNumero("54321");

		movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta da Luz");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("123.9"));
		movimentacao.setConta(conta);

		em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		//em.persist(conta);
		em.persist(movimentacao);
		em.getTransaction().commit();
		em.close();
	}
}
