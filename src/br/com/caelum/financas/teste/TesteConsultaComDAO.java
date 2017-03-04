package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.persistence.dao.MovimentacaoDAO;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaComDAO {

	public static void main(String[] args) {
		EntityManager manager;
		MovimentacaoDAO dao;
		Double media;
		Conta conta;
		
		conta = new Conta();
		conta.setId(2);
		
		manager = new JPAUtil().getEntityManager();
		dao = new MovimentacaoDAO(manager);
		media = dao.mediaDaConta(conta);
		
		System.out.println("Media da conta ...: " + media);
	}

}
