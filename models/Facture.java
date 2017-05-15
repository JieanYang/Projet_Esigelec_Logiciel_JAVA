package models;

public class Facture extends Devis{
	
	private int id_facture;//produire automatiquement
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
	
	public String getModepaiement_Facture(){
		return modepaiement;
	}
	
	public int getNum_Facture(){
		return num;
	}
	
	public String getDate_Facture(){
		return date;
	}
//set
	public void setId_Facture(int n){
		this.id_facture = n;
	}
	
	public void setModepaiement_Facture(String m){
		this.modepaiement = m;
	}
	
	public void setNum_Facture(int n){
		this.num = n;
	}
	
	public void setDate_Facture(String d){
		this.date = d;
	}
	
}
