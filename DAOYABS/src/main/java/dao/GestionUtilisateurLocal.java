package dao;

import java.util.List;

import javax.ejb.Local;
import entites.Utilisateur;

@Local
public interface GestionUtilisateurLocal {
	public void creerUtilisateur(Utilisateur utilisateur);

	public Utilisateur authentifierUtilisateur(String login, String mdp);

	public Utilisateur getUtilisateurById(int id);

	public void modifierUtilisateur(Utilisateur utilisateur);

	public void supprimerUtilisateur(Utilisateur utilisateur);

	public List<Utilisateur> getAllUtilisateurs();
}