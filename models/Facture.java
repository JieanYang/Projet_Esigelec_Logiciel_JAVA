package models;

public class Facture extends Devis{
	
	private int id_facture;
	private String modepaiement;
	private int num;
	private String date;
	
	public Facture(){
		super();
	}
	
	public Facture(int id, String nomdevis, Client client, String categorie){
		super(id, nomdevis, client, categorie);
	}

	public Facture(Devis devis){
		super(devis.getId(), devis.getNomdevis(), devis.getClient(),devis.getCategorie() );
	}
	
	public Facture(String text, String text2, String text3){
		super(text, text2, text3);
	}
//get
	public int getId_Facture(){
		return id_facture;
	}
	
	public String getModepaiement(){
		return modepaiement;
	}
	
	public int getNum(){
		return num;
	}
	
	public String getDate(){
		return date;
	}
//set
	public void setId(int n){
		this.id_facture = n;
	}
	
	public void setModepaiement(String m){
		this.modepaiement = m;
	}
	
	public void setNum(int n){
		this.num = n;
	}
	
	public void setDate(String d){
		this.date = d;
	}
	
}
