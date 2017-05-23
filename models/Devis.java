package models;

public class Devis {
	protected int id;
	protected String nomdevis;
	protected Client client;
	protected String categorie;
	protected String date;

	public Devis(){
		
	}


	public Devis(int id, String nomdevis, Client client, String categorie, String date) {
		this.id = id;
		this.nomdevis = nomdevis;
		this.client = client;
		this.categorie = categorie;
		this.date = date;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomdevis() {
		return nomdevis;
	}

	public void setNomdevis(String nomdevis) {
		this.nomdevis = nomdevis;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
