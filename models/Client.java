dddpackage models;

public class Client {
	private int id;
	private String nom;
	private int siret;
	private int codeape;
	private String adresse;

	public Client(int id,String nom, int siret, int codeape, String adresse) {
		this.nom = nom;
		this.siret = siret;
		this.codeape = codeape;
		this.adresse = adresse;
		this.id =id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getSiret() {
		return siret;
	}

	public void setSiret(int siret) {
		this.siret = siret;
	}

	public int getCodeape() {
		return codeape;
	}

	public void setCodeape(int codeape) {
		this.codeape = codeape;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
