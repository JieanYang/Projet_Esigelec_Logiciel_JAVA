package DAO;


	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

import models.Comptable;

	/**
	 * Classe d'accès aux données contenues dans la table Comptable
	 * 
	 * @author diesnis
	 * @version 1
	 */
	public class ComptableDAO {
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
		public ComptableDAO() {
			// chargement du pilote de bases de données
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				System.err.println(
						"Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
			}

		}

		/**
		 * Permet d'ajouter un Comptable dans la table Comptable Le mode est auto-commit
		 * par défaut : chaque insertion est validée
		 * 
		 * @param Comptable
		 *            l'Comptable à ajouter
		 * @return retourne le nombre de lignes ajoutées dans la table
		 */
		public int ajouter(Comptable comptable) {
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
						"INSERT INTO COMPTABLE_CPT (STT_ID,STT_NOM) VALUES (?, ?)");
				ps.setInt(1, comptable.getIdentifiant());
				ps.setString(2, comptable.getNom());
			

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
		 * Permet d'ajouter un Comptable dans la table Comptable Le mode est auto-commit
		 * par défaut : chaque insertion est validée
		 * 
		 * @param Comptable
		 *            l'Comptable à ajouter
		 * @return retourne le nombre de lignes ajoutées dans la table
		 */
		public int suppr(Comptable comptable) {
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
						"DELETE FROM COMPTABLE_CPT WHERE(STT_ID)");
				ps.setInt(1, comptable.getIdentifiant());

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
		 * Permet de récupérer un Comptable à partir de sa référence
		 * 
		 * @param id
		 *            la référence de l'Comptable à récupérer
		 * @return l'Comptable trouvé; null si aucun Comptable ne correspond à cette
		 *         référence
		 */
		public Comptable getComptable(int id) {

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Comptable retour = null;

			// connexion à la base de données
			try {

				con = DriverManager.getConnection(URL, LOGIN, PASS);
				ps = con.prepareStatement("SELECT * FROM COMPTABLE_CPT WHERE STT_ID = ?");
				ps.setInt(1, id);

				// on exécute la requête
				// rs contient un pointeur situé juste avant la première ligne
				// retournée
				rs = ps.executeQuery();
				// passe à la première (et unique) ligne retournée
				if (rs.next())
					retour = new Comptable(rs.getString("CPT_NOM"), rs.getInt("CPT_ID"),rs.getString("CPT_MDP"));

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
		 * Permet de récupérer tous les Comptables stockés dans la table Comptable
		 * 
		 * @return une ArrayList d'Comptables
		 */
		public List<Comptable> getListeComptables() {

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Comptable> retour = new ArrayList<Comptable>();

			// connexion à la base de données
			try {

				con = DriverManager.getConnection(URL, LOGIN, PASS);
				ps = con.prepareStatement("SELECT * FROM COMPTABLE_CPT");

				// on exécute la requête
				rs = ps.executeQuery();
				// on parcourt les lignes du résultat
				while (rs.next())
					retour.add(new Comptable(rs.getString("CPT_NOM"), rs.getInt("CPT_ID"),rs.getString("CPT_MDP")));

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


