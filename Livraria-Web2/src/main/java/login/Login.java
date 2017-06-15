package login;

import javax.persistence.EntityManager;

import jpa.PersistenceManager;

public class Login {

	public static void main(String[] args) {
		
		Usuario usr = new Usuario();
		usr.setName("Jo�o");
		usr.setProfissao("Programador");
		
		Status status = new Status();
		status.setStatus("Ativo");
				
		//usr.setStatus(status);
		
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(usr);
		em.persist(status);
		em.getTransaction().commit();
		em.close();
		PersistenceManager.INSTANCE.close();
	}

}
