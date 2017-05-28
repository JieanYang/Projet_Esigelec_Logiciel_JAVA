package DAO;


	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

import models.Client;
import models.Devis;
import models.Fichemaintenance;
import models.Rapportactivite;

	/**
	 * Classe d'accès aux données contenues dans la table Rapportactivite
	 * 
	 * @author diesnis
	 * @version 1
	 */
public class RapportactiviteDAO {

		/**
		 * Paramètres de connexion à la base de données oracle URL, LOGIN et PASS
		 * sont des constantes
		 */
		final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		final static String LOGIN = "PVL"; // exemple BDD1
		final static String PASS = "BDD1"; // exemple BDD1

		/**
		 * Constructeur de la classe
		 * 
		 */
		public RapportactiviteDAO() {
			// chargement du pilote de bases de données
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				System.err.println(
						"Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
			}

		}

		/**
		 * Permet d'ajouter un Rapportactivite dans la table Rapportactivite Le mode est auto-commit
		 * par défaut : chaque insertion est validée
		 * 
		 * @param Rapportactivite
		 *            l'Rapportactivite à ajouter
		 * @return retourne le nombre de lignes ajoutées dans la table
		 */
		public static int ajouter(Rapportactivite rapportactivite) {
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
						"INSERT INTO Rapportactivite_RPA (RPA_ID,RPA_DATE,RPA_COMMENTAIRE,RPA_DEVIS,RPA_CLIENT) VALUES (?, ?, ?, ?, ?, ?)");
				ps.setInt(1, rapportactivite.getId());
				ps.setString(2, rapportactivite.getDate());
				ps.setString(3, rapportactivite.getCommentaire());
				ps.setInt(4, rapportactivite.getDevis().getId());
				ps.setInt(5, rapportactivite.getClient().getId());

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
		 * Permet de suppr un Rapportactivite dans la table Rapportactivite Le mode est auto-commit
		 * par défaut : chaque insertion est validée
		 * 
		 * @param Rapportactivite
		 *            l'Rapportactivite à ajouter
		 * @return retourne le nombre de lignes ajoutées dans la table
		 */
		public int suppr(Rapportactivite Rapportactivite) {
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
						"DELETE FROM Rapportactivite_RPA WHERE(RPA_ID)");
				ps.setInt(1, Rapportactivite.getId());

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
		 * Permet de récupérer un Rapportactivite à partir de sa référence
		 * 
		 * @param id
		 *            la référence de l'Rapportactivite à récupérer
		 * @return l'Rapportactivite trouvé; null si aucun Rapportactivite ne correspond à cette
		 *         référence
		 */
		public Rapportactivite getRapportactivite(int id) {

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Rapportactivite retour = null;

			// connexion à la base de données
			try {

				con = DriverManager.getConnection(URL, LOGIN, PASS);
				ps = con.prepareStatement("SELECT * FROM Rapportactivite_RPA WHERE RPA_ID = ?");
				ps.setInt(1, id);

				// on exécute la requête
				// rs contient un pointeur situé juste avant la première ligne
				// retournée
				rs = ps.executeQuery();
				// passe à la première (et unique) ligne retournée
				if (rs.next()){
				Client client = ClientDAO.getClient(rs.getInt("DVI_CLIENT_ID"));
				Devis devis = DevisDAO.getDevis(rs.getInt("DVI_ID"));
				retour = new Rapportactivite(rs.getInt("RPA_ID"),rs.getString("RPA_DATE"),rs.getString("RPA_COMMENTAIRE"),devis,client);
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
		 * Permet de récupérer tous les Rapportactivites stockés dans la table Rapportactivite
		 * 
		 * @return une ArrayList d'Rapportactivites
		 */
		public List<Rapportactivite> getListeRapportactivites() {

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Rapportactivite> retour = new ArrayList<Rapportactivite>();

			// connexion à la base de données
			try {

				con = DriverManager.getConnection(URL, LOGIN, PASS);
				ps = con.prepareStatement("SELECT * FROM Rapportactivite_STT");

				// on exécute la requête
				rs = ps.executeQuery();
				// on parcourt les lignes du résultat
				while (rs.next()){
				Client client = ClientDAO.getClient(rs.getInt("DVI_CLIENT_ID"));
				Devis devis = DevisDAO.getDevis(rs.getInt("DVI_ID"));
					retour.add(new Rapportactivite(rs.getInt("RPA_ID"),rs.getString("RPA_DATE"),rs.getString("RPA_COMMENTAIRE"),devis,client));
				}
			} catch (Exception ee) {
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



