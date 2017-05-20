package models;

public class Rapportactivite {
	private int id;
	private String date;
	private String commentaire;
	private Devis devis;
	private Client client;
	
	public Rapportactivite(int id,String date,String commentaire,Devis devis,Client client){
		this.id = id;
		this.date = date;
		this.commentaire =commentaire;
		this.devis = devis;
		this.client = client;	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Devis getDevis() {
		return devis;
	}

	public void setDevis(Devis devis) {
		this.devis = devis;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	

}
