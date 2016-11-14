package dao.service;

import javax.ejb.Local;

import entites.service.AuthentificationForm;
import entites.service.Token;

@Local
public interface GestionTokenLocal {
	public Token genererToken(AuthentificationForm af);

	public boolean estValide(Token token);

	public void supprimerToken(Token token);

	public int getNombreUtilisateursConnectes();
}