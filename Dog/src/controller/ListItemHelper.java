package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Dog;

public class ListItemHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Dog");
	public void insetItem(Dog li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	public List<Dog>showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<Dog>allItems = em.createQuery("SELECT i FROM Dog i").getResultList();
		return allItems;
	}
	public void deleteItem(Dog toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Dog>typedQuery = em.createQuery("select li from Dog li where li.name =:selectedName and li.owner =:selectedOwner and li.breed =:selectedBreed",Dog.class);
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedOwner", toDelete.getOwner());
		typedQuery.setParameter("selectedBreed", toDelete.getBreed());
		typedQuery.setMaxResults(1);
		Dog result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	public Dog searchForItemById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Dog found = em.find(Dog.class, idToEdit);
		em.close();
		return found;
	}
	public void updateItem(Dog toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	public List<Dog> searchForDogByName(String dogName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Dog>typedQuery = em.createQuery("select li from Dog li where li.name =:selectedName",Dog.class);
		typedQuery.setParameter("selectedName", dogName);
		List<Dog>foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	public List<Dog> searchForDogByOwner(String OwnerName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Dog>typedQuery = em.createQuery("select li from Dog li where li.owner =:selectedOwner",Dog.class);
		typedQuery.setParameter("selectedOwner", OwnerName);
		List<Dog>foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	public List<Dog> searchForDogByBreed(String BreedName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Dog>typedQuery = em.createQuery("select li from Dog li where li.breed =:selectedBreed",Dog.class);
		typedQuery.setParameter("selectedBreed", BreedName);
		List<Dog>foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	public void cleanUp() {
		emfactory.close();
	}
}
