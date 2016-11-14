package dao.service;

import javax.ejb.Remote;

import entites.service.AuthentificationForm;
import entites.service.Token;

@Remote
public interface GestionTokenRemote {
	public Token genererToken(AuthentificationForm af);

	public boolean estValide(Token token);

	public void supprimerToken(Token token);

	public int getNombreUtilisateursConnectes();
}