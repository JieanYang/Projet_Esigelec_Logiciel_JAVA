package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import models.Facture;


public class Yang_FactureDB {

	//parametre pour DB
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String LOGIN = "BDD7"; // exemple BDD1
	final static String PASS = "BDD7"; // exemple BDD1
	
	public Yang_FactureDB(){
		//chargement du pilote de DB
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err.println(
					"Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}
	}
	
	
	
	public int ajouter (Facture f){
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;
		
		//connexion
		try {
			con =DriverManager.getConnection(URL, LOGIN, PASS);
			
			ps = con.prepareStatement(//insert contents in oracle
					"INSERT INTO Yang_Facture (id_D,client_id_D,modepaiement_F,num_F,date_F) VALUES (?, ?, ?, ?,?)");
			
			ps.setInt(1,f.getId());//Id of devis, une public facon dans Devis.java
			ps.setInt(2,f.getClient().getSiret());//facon dans client.java
			ps.setString(3, f.getModepaiement_Facture());
			ps.setInt(4,f.getNum_Facture());
			ps.setString(5, f.getDate_Facture());
			
			
			//excution de la requete
			retour = ps.executeUpdate();
		
		
		} catch (Exception e) {

			e.printStackTrace();
		}finally{
			//close the preparedStatement and the connexion
			try{
				if(ps != null)
					ps.close();
			}catch(Exception ignore){}
			
			try{
				if( con != null)
					con.close();
			}catch(Exception ignore){}
		}
		
		return retour;
	}
	
	
	
	
	
	public int suppr(Facture f){
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;
		
		//connexion  with DB
		try{
			//intention to do connection
			con = DriverManager.getConnection(URL,LOGIN,PASS);
			
			
			ps = con.prepareStatement(
					"DELETE FROM Yang_Facture WHERE id_F = ?");
			ps.setInt(1,f.getId_Facture());
			
			
			//excution de la requete
			retour = ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//close the preparedStatement and the connection
			
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {}	
			
		}
		
		return retour;	
	}
	
	
	public Facture getFacture(int id){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Facture retour = null;

		//connexion DB
		try{
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Yang_Facture WHERE id_F = ?");
			ps.setInt(1, id);
			
			//excute la requete
			//rs contient un pointeur situe juste avant la premiere ligne
			//retournee
			rs = ps.executeQuery();
			//passe la premiere ( et unique ) ligne retournee
			if(rs.next())
				retour = new Facture(rs.getInt("id_D"), null, null, null, null, null, 
						rs.getInt("id_F"), rs.getString("modepaiement_F"),rs.getInt("num_F"),
						rs.getString("date_F"));		
		}catch(Exception ee){
			ee.printStackTrace();
		}finally{
			//close the rs, the ps and the con
			try{
				if(rs != null)
					rs.close();
			}catch(Exception ignore){}
			try{
				if(ps != null)
					ps.close();
			}catch(Exception ignore){}
			try{
				if(con != null)
					con.close();
			}catch(Exception ignore){}
		}
		return retour;	
	}
	
	
	
	public List<Facture> getListeFactures(){
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Facture> retour = new ArrayList<Facture>();
		
		//connexion DB
		try{
			
			con = DriverManager.getConnection( URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Yang_Facture");
			
			//execute request
			rs = ps.executeQuery();
			//travel the lines of the result
			while(rs.next())
				retour.add(new Facture(rs.getInt("id_D"), null, null, null, null, null, 
						rs.getInt("id_F"), rs.getString("modepaiement_F"),rs.getInt("num_F"),
						rs.getString("date_F")));
			
		}catch(Exception ee){
			ee.printStackTrace();
		}finally{
			//close rs, ps and con
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {}
		}
		return retour;
		
	}
	
}
