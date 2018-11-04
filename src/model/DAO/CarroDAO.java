package model.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.DTO.Car;

public class CarroDAO {
	private static final String persistenceUnitName = "RestEasy-Server";
	private static EntityManagerFactory emf;
	private static EntityManager em;

	public CarroDAO() {
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		em = emf.createEntityManager();
	}

	public Boolean createcar(Car car) {
		try {
			em.getTransaction().begin();
			em.persist(car);
			em.getTransaction().commit();
			em.close();
			System.out.println("Hecho");
			return true;
		} catch (Exception e) {
			System.err.println("Exception" + e + "\n");
			em.getTransaction().rollback();
			em.close();
			return false;
		}
	}

	public Car selectCar(String idEAN) {
		return (Car) em.find(Car.class, idEAN);
	}

	public boolean updateamount(String idEAN, int amount) {
		int newamount;
		try {
			em.getTransaction().begin();
			Car car = em.find(Car.class, idEAN);
			newamount = car.getAmount() - amount;
			if (newamount >= 0) {
				car.setAmount(newamount);
				em.merge(car);
				em.getTransaction().commit();
				em.close();
				System.out.println("Hecho");
				return true;
			} else {
				System.out.println("No hay suficientes autos");
				em.getTransaction().rollback();
				em.close();
				return false;
			}
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
			em.close();
			return false;
		}
	}

}
