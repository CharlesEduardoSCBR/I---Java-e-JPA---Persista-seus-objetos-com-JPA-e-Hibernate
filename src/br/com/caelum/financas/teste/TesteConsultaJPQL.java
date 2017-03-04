package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaJPQL {

	public static void main(String[] args) {
		EntityManager manager;
		Conta conta;
		Query query;
		List<Movimentacao> movimentacoes;
		
		manager = new JPAUtil().getEntityManager();
		
		conta = new Conta();
		conta.setId(1);
		
		query = manager.createQuery("    SELECT m "
									+ "    FROM Movimentacao m "
									+ "   WHERE m.conta.id = :pConta"
									+ "     AND m.tipoMovimentacao = :pTipo "
									+ "ORDER BY m.valor desc");
		
		query.setParameter("pConta", conta.getId());
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		movimentacoes = query.getResultList();
		
		for (Movimentacao m : movimentacoes) {
			System.out.println("\nDescricao ..: " + m.getDescricao());
			System.out.println("Valor .....: R$ " + m.getValor());
		}
		manager.close();
	}
}
