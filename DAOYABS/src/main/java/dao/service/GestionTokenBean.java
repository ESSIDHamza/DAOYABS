package dao.service;

import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.GestionUtilisateurLocal;
import entites.Utilisateur;
import entites.service.AuthentificationForm;
import entites.service.Token;

@Stateless
public class GestionTokenBean implements GestionTokenLocal, GestionTokenRemote {
	@PersistenceContext(unitName = "YABS-PU")
	private EntityManager em;

	@EJB
	GestionUtilisateurLocal gestionUtilisateurLocal;

	@Override
	public Token genererToken(AuthentificationForm af) {
		Utilisateur utilisateur = gestionUtilisateurLocal.authentifierUtilisateur(af.getLogin(), af.getMdp());
		Random random = new Random(System.currentTimeMillis());
		Token token = new Token(utilisateur.getId(),
				utilisateur.getId() + utilisateur.getLogin() + utilisateur.getMdp().hashCode() + random.nextLong());
		em.persist(token);
		return token;
	}

	@Override
	public boolean estValide(Token token) {
		Token validToken = em.find(Token.class, token.getId());
		return token.equals(validToken);
	}

	@Override
	public void supprimerToken(Token token) {
		em.remove(em.contains(token) ? token : em.merge(token));
	}

	@Override
	public int getNombreUtilisateursConnectes() {
		return em.createQuery("select t from Token t").getResultList().size();
	}
}