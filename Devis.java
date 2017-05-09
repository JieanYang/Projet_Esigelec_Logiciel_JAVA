
public class Devis {
	private int id;
	private String nomdevis;
	private Client client;
	private String categorie;
	private String nomclient;
	private String date;

	public Devis() {
		id = 0;
		nomdevis = null;
		client = null;
		categorie = null;
	}

	public Devis(int id, String nomdevis, Client client, String categorie) {
		this.id = id;
		this.nomdevis = nomdevis;
		this.client = client;
		this.categorie = categorie;
	}

	public Devis(String text, String text2, String text3) {
		this.nomclient = text;
		this.date = text2;
		this.categorie = text3;
	}

	public String getNom() {
		return nomclient;
	}

	public void setNom(String nom) {
		this.nomclient = nom;
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

}
