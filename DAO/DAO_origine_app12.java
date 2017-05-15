package DAO;


	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

	/**
	 * Classe d'accès aux données contenues dans la table Station
	 * 
	 * @author diesnis
	 * @version 1
	 */
	public class StationDAO {
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
		public StationDAO() {
			// chargement du pilote de bases de données
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				System.err.println(
						"Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
			}

		}

		/**
		 * Permet d'ajouter un Station dans la table Station Le mode est auto-commit
		 * par défaut : chaque insertion est validée
		 * 
		 * @param Station
		 *            l'Station à ajouter
		 * @return retourne le nombre de lignes ajoutées dans la table
		 */
		public int ajouter(Station Station) {
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
						"INSERT INTO STATION_STT (STT_ID,STT_NOM,STT_VILLE,STT_ADR,STT_DATE_INST,STT_TST_ID) VALUES (?, ?, ?, ?, ?, ?)");
				ps.setInt(1, Station.getid());
				ps.setString(2, Station.getnom());
				ps.setString(3, Station.getville());
				ps.setString(4, Station.getadresse());
				ps.setString(5, Station.getdate());
				ps.setInt(6, 5);

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
		 * Permet d'ajouter un Station dans la table Station Le mode est auto-commit
		 * par défaut : chaque insertion est validée
		 * 
		 * @param Station
		 *            l'Station à ajouter
		 * @return retourne le nombre de lignes ajoutées dans la table
		 */
		public int suppr(Station Station) {
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
						"DELETE FROM STATION_STT WHERE(STT_ID)");
				ps.setInt(1, Station.getid());

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
		 * Permet de récupérer un Station à partir de sa référence
		 * 
		 * @param id
		 *            la référence de l'Station à récupérer
		 * @return l'Station trouvé; null si aucun Station ne correspond à cette
		 *         référence
		 */
		public Station getStation(int id) {

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Station retour = null;

			// connexion à la base de données
			try {

				con = DriverManager.getConnection(URL, LOGIN, PASS);
				ps = con.prepareStatement("SELECT * FROM STATION_STT WHERE STT_ID = ?");
				ps.setInt(1, id);

				// on exécute la requête
				// rs contient un pointeur situé juste avant la première ligne
				// retournée
				rs = ps.executeQuery();
				// passe à la première (et unique) ligne retournée
				if (rs.next())
					retour = new Station(rs.getInt("STT_ID"), rs.getString("STT_NOM"), rs.getString("STT_VILLE"),
							rs.getString("STT_ADRESSE"), rs.getString("STT_DATE_INST"), rs.getInt("STT_TST_ID"));

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
		 * Permet de récupérer tous les Stations stockés dans la table Station
		 * 
		 * @return une ArrayList d'Stations
		 */
		public List<Station> getListeStations() {

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Station> retour = new ArrayList<Station>();

			// connexion à la base de données
			try {

				con = DriverManager.getConnection(URL, LOGIN, PASS);
				ps = con.prepareStatement("SELECT * FROM STATION_STT");

				// on exécute la requête
				rs = ps.executeQuery();
				// on parcourt les lignes du résultat
				while (rs.next())
					retour.add(new Station(rs.getInt("STT_ID"), rs.getString("STT_NOM"), rs.getString("STT_VILLE"),
							rs.getString("STT_ADR"), rs.getString("STT_DATE_INST"), rs.getInt("STT_TST_ID")));

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

}
