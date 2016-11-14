package entites;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement
@Entity
@Table(name = "LIVRES")
public class Livre implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	@Column(name = "TITRE")
	private String titre;
	@Column(name = "AUTEUR")
	private String auteur;
	@Lob
	@Column(name = "IMAGE")
	private String image;
	@Column(name = "CATEGORIE")
	private String categorie;
	@Column(name = "PRIX")
	private float prix;
	@Column(name = "NOMBRE_COPIES")
	private int nbrCopies;
	@Lob
	@Column(name = "SYNOPSIS")
	private String synopsis;

	public Livre() {
		super();
	}

	public Livre(String titre, String auteur, String image, String categorie, float prix, int nbrCopies,
			String synopsis) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.image = image;
		this.categorie = categorie;
		this.prix = prix;
		this.nbrCopies = nbrCopies;
		this.synopsis = synopsis;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getNbrCopies() {
		return nbrCopies;
	}

	public void setNbrCopies(int nbrCopies) {
		this.nbrCopies = nbrCopies;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auteur == null) ? 0 : auteur.hashCode());
		result = prime * result + ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result + id;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + nbrCopies;
		result = prime * result + Float.floatToIntBits(prix);
		result = prime * result + ((synopsis == null) ? 0 : synopsis.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livre other = (Livre) obj;
		if (auteur == null) {
			if (other.auteur != null)
				return false;
		} else if (!auteur.equals(other.auteur))
			return false;
		if (categorie == null) {
			if (other.categorie != null)
				return false;
		} else if (!categorie.equals(other.categorie))
			return false;
		if (id != other.id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (nbrCopies != other.nbrCopies)
			return false;
		if (Float.floatToIntBits(prix) != Float.floatToIntBits(other.prix))
			return false;
		if (synopsis == null) {
			if (other.synopsis != null)
				return false;
		} else if (!synopsis.equals(other.synopsis))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}
}