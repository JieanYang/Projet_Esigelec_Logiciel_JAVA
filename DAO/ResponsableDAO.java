package DAO;


	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

import models.Responsable;

	/**
	 * Classe d'accès aux données contenues dans la table Responsable
	 * 
	 * @author diesnis
	 * @version 1
	 */
public class ResponsableDAO {

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
		public ResponsableDAO() {
			// chargement du pilote de bases de données
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				System.err.println(
						"Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
			}

		}

		/**
		 * Permet d'ajouter un Responsable dans la table Responsable Le mode est auto-commit
		 * par défaut : chaque insertion est validée
		 * 
		 * @param Responsable
		 *            l'Responsable à ajouter
		 * @return retourne le nombre de lignes ajoutées dans la table
		 */
		public int ajouter(Responsable responsable) {
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
						"INSERT INTO Responsable_RSP (RSP_ID,RSP_NOM,RSP_MDP) VALUES (?, ?, ?)");
				ps.setInt(1, responsable.getIdentifiant());
				ps.setString(2, responsable.getNom());
				ps.setString(3, responsable.getMdp());


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
		 * Permet d'ajouter un Responsable dans la table Responsable Le mode est auto-commit
		 * par défaut : chaque insertion est validée
		 * 
		 * @param Responsable
		 *            l'Responsable à ajouter
		 * @return retourne le nombre de lignes ajoutées dans la table
		 */
		public int suppr(Responsable Responsable) {
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
						"DELETE FROM Responsable_RSP WHERE(RSP_ID)");
				ps.setInt(1, Responsable.getIdentifiant());

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
		 * Permet de récupérer un Responsable à partir de sa référence
		 * 
		 * @param id
		 *            la référence de l'Responsable à récupérer
		 * @return l'Responsable trouvé; null si aucun Responsable ne correspond à cette
		 *         référence
		 */
		public Responsable getResponsable(int id) {

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Responsable retour = null;

			// connexion à la base de données
			try {

				con = DriverManager.getConnection(URL, LOGIN, PASS);
				ps = con.prepareStatement("SELECT * FROM Responsable_STT WHERE STT_ID = ?");
				ps.setInt(1, id);

				// on exécute la requête
				// rs contient un pointeur situé juste avant la première ligne
				// retournée
				rs = ps.executeQuery();
				// passe à la première (et unique) ligne retournée
				if (rs.next())
					retour = new Responsable(rs.getString("RSP_NOM"), rs.getInt("RSP_ID"), rs.getString("RSP_MDP"));
							
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
		 * Permet de récupérer tous les Responsables stockés dans la table Responsable
		 * 
		 * @return une ArrayList d'Responsables
		 */
		public List<Responsable> getListeResponsables() {

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Responsable> retour = new ArrayList<Responsable>();

			// connexion à la base de données
			try {

				con = DriverManager.getConnection(URL, LOGIN, PASS);
				ps = con.prepareStatement("SELECT * FROM Responsable_STT");

				// on exécute la requête
				rs = ps.executeQuery();
				// on parcourt les lignes du résultat
				while (rs.next())
					retour.add(new Responsable(rs.getString("RSP_NOM"), rs.getInt("RSP_ID"), rs.getString("RSP_MDP")));

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



