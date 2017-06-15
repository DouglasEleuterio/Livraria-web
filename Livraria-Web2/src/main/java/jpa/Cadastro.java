package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import login.Usuario;

public class Cadastro {
	public static void main(String[] args) {

		Empresa empresa = new Empresa();
		empresa.setNome("3way Networks");
		Usuario usr1 = new Usuario();
		usr1.setName("João");
		usr1.setProfissao("Programador");
		Usuario usr2 = new Usuario();
		usr2.setName("Mário");
		usr2.setProfissao("Técnico");
		List<Usuario> empregados = new ArrayList<Usuario>();
		empregados.add(usr1);
		empregados.add(usr2);
		empresa.setEmpregados(empregados);
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(empresa);
		em.persist(usr1);
		em.persist(usr2);
		em.getTransaction().commit();
		em.close();
		PersistenceManager.INSTANCE.close();
	}

}
