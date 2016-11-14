package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entites.Utilisateur;

@Stateless
public class GestionUtilisateurBean implements GestionUtilisateurLocal, GestionUtilisateurRemote {
	@PersistenceContext(unitName = "YABS-PU")
	private EntityManager em;

	public void creerUtilisateur(Utilisateur utilisateur) {
		em.persist(utilisateur);
	}

	public Utilisateur authentifierUtilisateur(String login, String mdp) throws NoResultException {
		Query query = em
				.createQuery("select u from Utilisateur u where u.login='" + login + "' and u.mdp='" + mdp + "'");
		return (Utilisateur) query.getSingleResult();
	}

	public Utilisateur getUtilisateurById(int id) {
		return em.find(Utilisateur.class, id);
	}

	public void modifierUtilisateur(Utilisateur utilisateur) {
		em.merge(utilisateur);
	}

	public void supprimerUtilisateur(Utilisateur utilisateur) {
		em.remove(utilisateur);
	}

	@SuppressWarnings("unchecked")
	public List<Utilisateur> getAllUtilisateurs() {
		Query query = em.createQuery("select u from Utilisateur u");
		return query.getResultList();
	}
}