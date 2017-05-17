package models;

public class Facture extends Devis{
	
	private int id_f;//produire automatiquement
	private String modepaiement_f;
	private int num_f;
	private String date_f;
	
		public Facture(Devis d, int id_f, String m, int num, String date){
		super( d.id, d.nomdevis,d.client,d.categorie,d.date);
		this.id_f=id_f;
		this.modepaiement_f=m;
		this.num_f=num;
		this.date_f=date;

		
	}

	
	//get
	public int getId_Facture(){
		return id_f;
	}
	public String getModepaiement_Facture(){
		return modepaiement_f;
	}
	
	public int getNum_Facture(){
		return num_f;
	}
	
	public String getDate_Facture(){
		return date_f;
	}
//set
	public void setId_Facture(int n){
		this.id_f = n;
	}
	
	public void setModepaiement_Facture(String m){
		this.modepaiement_f = m;
	}
	
	public void setNum_Facture(int n){
		this.num_f = n;
	}
	
	public void setDate_Facture(String d){
		this.date_f = d;
	}
	
}