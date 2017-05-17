package models;

public class Fichemaintenance {
	private int id;
	private String nom;
	private Client client;
	private Devis devis;
	private String categorie;

	public Fichemaintenance(int id, String nom, Client client, Devis devis, String categorie) {
		this.id = id;
		this.nom = nom;
		this.client = client;
		this.devis = devis;
		this.categorie = categorie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Devis getDevis() {
		return devis;
	}

	public void setDevis(Devis devis) {
		this.devis = devis;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
}