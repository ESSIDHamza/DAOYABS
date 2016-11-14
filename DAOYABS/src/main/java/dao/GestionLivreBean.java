package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entites.Livre;

@Stateless
public class GestionLivreBean implements GestionLivreLocal, GestionLivreRemote {
	@PersistenceContext(unitName = "YABS-PU")
	private EntityManager em;

	public void creerLivre(Livre livre) {
		em.persist(livre);
	}

	public Livre getLivre(int id) {
		return em.find(Livre.class, id);
	}

	public void modifierLivre(Livre livre) {
		em.merge(livre);
	}

	public void supprimerLivre(Livre livre) {
		em.remove(em.contains(livre) ? livre : em.merge(livre));
	}

	@SuppressWarnings("unchecked")
	public List<Livre> getAllLivres() {
		Query query = em.createQuery("select l from Livre l");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<String> getCategories() {
		Query query = em.createQuery("select distinct (l.categorie) from Livre l");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Livre> rechercher(String motCle) {
		Query query = em.createQuery("select l from Livre l where l.titre like '%" + motCle + "%' or l.auteur like '%"
				+ motCle + "%' or l.categorie like '%" + motCle + "%' or l.synopsis like '%" + motCle + "%'");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Livre> getLivresByCategorie(String categorie) {
		Query query = em.createQuery("select l from Livre l where l.categorie='" + categorie + "'");
		return query.getResultList();
	}
}