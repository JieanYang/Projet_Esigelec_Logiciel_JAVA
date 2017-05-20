package models;

public class Fichemaintenance {
	private int id;
	private Client client;
	private Devis devis;
	private String categorie;
	private Operateur operateur;

	public Fichemaintenance(int id, Client client, Devis devis, String categorie) {
		this.id = id;
		this.client = client;
		this.devis = devis;
		this.categorie = categorie;
		this.operateur = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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