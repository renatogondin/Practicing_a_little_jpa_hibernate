package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "caca@gmail.com");
		Pessoa p2 = new Pessoa(null, "Joao da Silva", "jo@gmail.com");
		Pessoa p3 = new Pessoa(null, "Paulo da Silva", "p@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); 
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		System.out.println("Ok. Pronto");
		
		Pessoa q = em.find(Pessoa.class, 2);
		System.out.println(q);
		
		em.getTransaction().begin();
		em.remove(q);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
