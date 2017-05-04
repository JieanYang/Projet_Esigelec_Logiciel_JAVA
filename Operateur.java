
public class Operateur {

	protected  String nom;
	protected int identifiant;

	public Operateur(String Nom, int identifiant) {
		this.nom = Nom;
		this.identifiant = identifiant;

	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

}
