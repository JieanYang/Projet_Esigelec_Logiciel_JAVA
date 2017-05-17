package DAO;


	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

import javax.swing.JButton;

import models.Client;

	/**
	 * Classe d'accès aux données contenues dans la table Comptable
	 * 
	 * @author diesnis
	 * @version 1
	 */
public class ClientDAO {


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
		public ClientDAO () {
			// chargement du pilote de bases de données
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				System.err.println(
						"Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
			}

		}
		

		/**
		 * Permet d'ajouter un Client dans la table ClientLe mode est auto-commit
		 * par défaut : chaque insertion est validée
		 * 
		 * @param Client
		 *            Client à ajouter
		 * @return retourne le nombre de lignes ajoutées dans la table
		 */
		public int ajouter(Client client) {
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
						"INSERT INTO CLIENT_CLT (CLT_ID,CLT_NOM,CLT_SIRET,CLT_CODEAPE,CLT_ADRESSE) VALUES (?, ?, ?, ?, ?)");
				ps.setInt(1, client.getId());
				ps.setString(2, client.getNom());
				ps.setInt(3, client.getSiret());
				ps.setInt(4, client.getCodeape());
				ps.setString(5, client.getAdresse());
				g("CreateClient");
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
		private void g(String string) {
			// TODO Auto-generated method stub
			
		}

		/**
		 * Permet de supprimer un Client dans la table Client Le mode est auto-commit
		 * par défaut : chaque insertion est validée
		 * 
		 * @param Client
		 *            Client à supprimer
		 * @return retourne le nombre de lignes supprimer dans la table
		 */
		public int suppr(Client client) {
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
						"DELETE FROM CLIENT_CLT WHERE(CLT_ID)");
				ps.setInt(1, client.getId());

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
		 * Permet de récupérer un Client à partir de sa référence
		 * 
		 * @param id
		 *            la référence du Client à récupérer
		 * @return Client trouvé; null si aucun Client ne correspond à cette
		 *         référence
		 */
		public static Client getClient(int id) {

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Client retour = null;

			// connexion à la base de données
			try {

				con = DriverManager.getConnection(URL, LOGIN, PASS);
				ps = con.prepareStatement("SELECT * FROM CLIENT_CLT WHERE CLT_ID = ?");
				ps.setInt(1, id);

				// on exécute la requête
				// rs contient un pointeur situé juste avant la première ligne
				// retournée
				rs = ps.executeQuery();
				// passe à la première (et unique) ligne retournée
				if (rs.next())
					retour = new Client(rs.getInt("CLT_ID"), rs.getString("STT_NOM"), rs.getInt("CLT_SIRET"),
							rs.getInt("CLT_CODEAPE"), rs.getString("CLT_ADRESSE"));

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
		public List<Client> getListeClient() {

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Client> retour = new ArrayList<Client>();

			// connexion à la base de données
			try {

				con = DriverManager.getConnection(URL, LOGIN, PASS);
				ps = con.prepareStatement("SELECT * FROM CLIENT_CLT");

				// on exécute la requête
				rs = ps.executeQuery();
				// on parcourt les lignes du résultat
				while (rs.next())
					retour.add(new Client(rs.getInt("CLT_ID"), rs.getString("STT_NOM"), rs.getInt("CLT_SIRET"),
							rs.getInt("CLT_CODEAPE"), rs.getString("CLT_ADRESSE")));


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



