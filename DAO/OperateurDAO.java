package DAO;


	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

import models.Operateur;

	/**
	 * Classe d'accès aux données contenues dans la table Operateur
	 * 
	 * @author diesnis
	 * @version 1
	 */
public class OperateurDAO {
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
		public OperateurDAO() {
			// chargement du pilote de bases de données
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				System.err.println(
						"Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
			}

		}

		/**
		 * Permet d'ajouter un Operateur dans la table Operateur Le mode est auto-commit
		 * par défaut : chaque insertion est validée
		 * 
		 * @param Operateur
		 *            l'Operateur à ajouter
		 * @return retourne le nombre de lignes ajoutées dans la table
		 */
		public int ajouter(Operateur operateur) {
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
						"INSERT INTO Operateur_OPT (OPT_ID,OPT_NOM,OPT_MDP) VALUES (?, ?, ?)");
				ps.setInt(1, operateur.getIdentifiant());
				ps.setString(2, operateur.getNom());
				ps.setString(3, operateur.getMdp());
				

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
		 * Permet d'ajouter un Operateur dans la table Operateur Le mode est auto-commit
		 * par défaut : chaque insertion est validée
		 * 
		 * @param Operateur
		 *            l'Operateur à ajouter
		 * @return retourne le nombre de lignes ajoutées dans la table
		 */
		public int suppr(Operateur Operateur) {
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
						"DELETE FROM Operateur_OPT WHERE(OPT_ID)");
				ps.setInt(1, Operateur.getIdentifiant());

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
		 * Permet de récupérer un Operateur à partir de sa référence
		 * 
		 * @param id
		 *            la référence de l'Operateur à récupérer
		 * @return l'Operateur trouvé; null si aucun Operateur ne correspond à cette
		 *         référence
		 */
		public Operateur getOperateur(int id) {

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Operateur retour = null;

			// connexion à la base de données
			try {

				con = DriverManager.getConnection(URL, LOGIN, PASS);
				ps = con.prepareStatement("SELECT * FROM Operateur_STT WHERE STT_ID = ?");
				ps.setInt(1, id);

				// on exécute la requête
				// rs contient un pointeur situé juste avant la première ligne
				// retournée
				rs = ps.executeQuery();
				// passe à la première (et unique) ligne retournée
				if (rs.next())
					retour = new Operateur(rs.getString("OPT_NOM"),rs.getInt("OPT_ID"), rs.getString("OPT_MDP"));

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
		 * Permet de récupérer tous les Operateurs stockés dans la table Operateur
		 * 
		 * @return une ArrayList d'Operateurs
		 */
		public List<Operateur> getListeOperateurs() {

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Operateur> retour = new ArrayList<Operateur>();

			// connexion à la base de données
			try {

				con = DriverManager.getConnection(URL, LOGIN, PASS);
				ps = con.prepareStatement("SELECT * FROM Operateur_STT");

				// on exécute la requête
				rs = ps.executeQuery();
				// on parcourt les lignes du résultat
				while (rs.next())
					retour.add(new Operateur(rs.getString("OPT_NOM"),rs.getInt("OPT_ID"), rs.getString("OPT_MDP")));


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



