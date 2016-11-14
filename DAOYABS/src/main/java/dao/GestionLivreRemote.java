package dao;

import java.util.List;

import javax.ejb.Remote;

import entites.Livre;

@Remote
public interface GestionLivreRemote {
	public void creerLivre(Livre livre);

	public Livre getLivre(int id);

	public void modifierLivre(Livre livre);

	public void supprimerLivre(Livre livre);

	public List<Livre> getAllLivres();

	public List<String> getCategories();

	public List<Livre> rechercher(String motCle);

	public List<Livre> getLivresByCategorie(String categorie);
}