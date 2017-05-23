package DAO;


	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

import models.Client;
import models.Devis;

	/**
	 * Classe d'accès aux données contenues dans la table Devis
	 * 
	 * @author diesnis
	 * @version 1
	 */
public class DevisDAO {
		/**
		 * Paramètres de connexion à la base de données oracle URL, LOGIN et PASS
		 * sont des constantes
		 */
		final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		final static String LOGIN = "BDD7"; // exemple BDD1
		final static String PASS = "BDD7"; // exemple BDD1

		/**
		 * Constructeur de la classe
		 * 
		 */
		public DevisDAO() {
			// chargement du pilote de bases de données
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				System.err.println(
						"Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
			}

		}

		
		public static Devis creerdevis() {
			Connection con = null;
			PreparedStatement ps = null;
			PreparedStatement ts = null;
			ResultSet rs = null;
			Devis d =new Devis();
			int retour;
			// connexion à la base de données
			try {
				// tentative de connexion
				con = DriverManager.getConnection(URL, LOGIN, PASS);
				// préparation de l'instruction SQL, chaque ? représente une valeur
				// à communiquer dans l'insertion
				// les getters permettent de récupérer les valeurs des attributs
				// souhaités
				ts = con.prepareStatement(
						"SELECT MAX(DVI_ID) AS DVI_MAX FROM DEVIS_DVI");
				rs=ts.executeQuery();
				if(rs.next()) {	
					d.setId(rs.getInt("DVI_MAX")+1);
				}
				
				ps = con.prepareStatement(
						"INSERT INTO DEVIS_DVI (DVI_ID) VALUES (?)");
				ps.setInt(1,d.getId());

			

				// Exécution de la requête
				retour = ps.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// fermeture du preparedStatement et de la connexion
				try {
					if (ps != null)
						ps.close();
				} catch (Exception ignore) {
				}
				try {
					if (con != null)
						con.close();
				} catch (Exception ignore) {
				}
			}
			return d;

		}
		/**
		 * Permet d'ajouter un Devis dans la table Devis Le mode est auto-commit
		 * par défaut : chaque insertion est validée
		 * 
		 * @param Devis
		 *            l'Devis à ajouter
		 * @return retourne le nombre de lignes ajoutées dans la table
		 */
		public int ajouter(Devis devis) {
			Connection con = null;
			PreparedStatement ps = null;
			int retour = 0;

			// connexion à la base de données
			try {

				// tentative de connexion
				con = DriverManager.getConnection(URL, LOGIN, PASS);
				// préparation de l'instruction SQL, chaque ? représente une valeur
				// à communiquer dans l'insertion
				// les getters permettent de récupérer les valeurs des attributs
				// souhaités
				ps = con.prepareStatement(
						"INSERT INTO DEVIS_DVI (DVI_ID,DVI_NOM,DVI_CLIENT_ID,DVI_CATEGORIE,DVI_DATE) VALUES (?, ?, ?, ?, ?)");
				ps.setInt(1, devis.getId());
				ps.setString(2, devis.getNomdevis());
				ps.setInt(3, devis.getClient().getId());
				ps.setString(4, devis.getCategorie());
				ps.setString(5, devis.getDate());
			

				// Exécution de la requête
				retour = ps.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// fermeture du preparedStatement et de la connexion
				try {
					if (ps != null)
						ps.close();
				} catch (Exception ignore) {
				}
				try {
					if (con != null)
						con.close();
				} catch (Exception ignore) {
				}
			}
			return retour;

		}
		/**
		 * Permet de suppr un Devis dans la table Devis Le mode est auto-commit
		 * par défaut : chaque insertion est validée
		 * 
		 * @param Devis
		 *            l'Devis à ajouter
		 * @return retourne le nombre de lignes ajoutées dans la table
		 */
		public int suppr(Devis devis) {
			Connection con = null;
			PreparedStatement ps = null;
			int retour = 0;

			// connexion à la base de données
			try {

				// tentative de connexion
				con = DriverManager.getConnection(URL, LOGIN, PASS);
				// préparation de l'instruction SQL, chaque ? représente une valeur
				// à communiquer dans l'insertion
				// les getters permettent de récupérer les valeurs des attributs
				// souhaités
				ps = con.prepareStatement(
						"DELETE FROM DEVIS_DVI WHERE(DVI_ID)");
				ps.setInt(1, devis.getId());

				// Exécution de la requête
				retour = ps.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// fermeture du preparedStatement et de la connexion
				try {
					if (ps != null)
						ps.close();
				} catch (Exception ignore) {
				}
				try {
					if (con != null)
						con.close();
				} catch (Exception ignore) {
				}
			}
			return retour;

		}


		/**
		 * Permet de récupérer un Devis à partir de sa référence
		 * 
		 * @param id
		 *            la référence de l'Devis à récupérer
		 * @return l'Devis trouvé; null si aucun Devis ne correspond à cette
		 *         référence
		 */
		public static Devis getDevis(int id) {

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Devis retour = null;

			// connexion à la base de données
			try {

				con = DriverManager.getConnection(URL, LOGIN, PASS);
				ps = con.prepareStatement("SELECT * FROM DEVIS_DVI WHERE DVI_ID = ?");
				ps.setInt(1, id);

				// on exécute la requête
				// rs contient un pointeur situé juste avant la première ligne
				// retournée
				rs = ps.executeQuery();
				// passe à la première (et unique) ligne retournée
				if (rs.next()) {
					Client client = ClientDAO.getClient(rs.getInt("DVI_CLIENT_ID"));
				
					retour = new Devis(rs.getInt("DVI_ID"), rs.getString("DVI_NOM"),client,
							rs.getString("DVI_CATEGORIE"),rs.getString("DVI_DATE"));
				}
			} catch (Exception ee) { 
				ee.printStackTrace();
			} finally {
				// fermeture du ResultSet, du PreparedStatement et de la Connexion
				try {
					if (rs != null)
						rs.close();
				} catch (Exception ignore) {
				}
				try {
					if (ps != null)
						ps.close();
				} catch (Exception ignore) {
				}
				try {
					if (con != null)
						con.close();
				} catch (Exception ignore) {
				}
			}
			return retour;

		}

		/**
		 * Permet de récupérer tous les Devis stockés dans la table Devis
		 * 
		 * @return une ArrayList d'Deviss
		 */
		public List<Devis> getListeDeviss() {

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Devis> retour = new ArrayList<Devis>();

			// connexion à la base de données
			try {

				con = DriverManager.getConnection(URL, LOGIN, PASS);
				ps = con.prepareStatement("SELECT * FROM DEVIS_DVI");

				// on exécute la requête
				rs = ps.executeQuery();
				// on parcourt les lignes du résultat
				while (rs.next()){
					Client client = ClientDAO.getClient(rs.getInt("DVI_CLIENT_ID"));
				
					Devis toto = new Devis(rs.getInt("DVI_ID"), rs.getString("DVI_NOM"), client ,
							rs.getString("DVI_CATEGORIE"),rs.getString("DVI_DATE"));
				
					retour.add(toto);

				}} catch (Exception ee) {
				ee.printStackTrace();
			} finally {
				// fermeture du rs, du preparedStatement et de la connexion
				try {
					if (rs != null)
						rs.close();
				} catch (Exception ignore) {
				}
				try {
					if (ps != null)
						ps.close();
				} catch (Exception ignore) {
				}
				try {
					if (con != null)
						con.close();
				} catch (Exception ignore) {
				}
			}
			return retour;

		}
	}



