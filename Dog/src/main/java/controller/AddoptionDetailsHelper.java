package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.AddoptionDetails;


public class AddoptionDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Dog");
	public void insertNewAddoptionDetails(AddoptionDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	public List<AddoptionDetails> getAddoptions(){
		EntityManager em = emfactory.createEntityManager();
		List<AddoptionDetails> allDetails = em.createQuery("SELECT d FROM AddoptionDetails d").getResultList();
		return allDetails;
	}
	public AddoptionDetails searchForAddoptionDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		AddoptionDetails found = em.find(AddoptionDetails.class, tempId);
		return found;
	}
	public void deleteAddoption(AddoptionDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<AddoptionDetails> typedQuery = em.createQuery("select detail from AddoptionDetails detail where detail.id = :selectedId", AddoptionDetails.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		AddoptionDetails result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	public void updateAddoption(AddoptionDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
