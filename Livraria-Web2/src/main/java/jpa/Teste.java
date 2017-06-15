package jpa;
import jpa.Endereco;
import javax.persistence.EntityManager;

public class Teste {

	public static void main(String[] args) {
		Endereco endereco = new Endereco();
		endereco.setCidade("Goiânia");
		endereco.setPais("Brazil");
		endereco.setEstado("Goiás");
		endereco.setCep("74000-000");
		endereco.setRua("Quarta Radial");
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(endereco);
		em.getTransaction().commit();
		em.close();
		PersistenceManager.INSTANCE.close();
		}

	}
	

