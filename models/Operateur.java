package models;

import java.awt.List;

public class Operateur {

	protected  String nom;
	protected int identifiant;
	protected String mdp;
	protected List maintenance;

	public Operateur( String Nom,int identifiant, String mdp) {
		this.nom = Nom;
		this.identifiant = identifiant;
		this.mdp = mdp;
		this.maintenance = null;

	}
	public List getmaintenance(){
		return maintenance;
	}


	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
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
