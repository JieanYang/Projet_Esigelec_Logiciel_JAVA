package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import models.Client;
import models.Devis;
import models.Fichemaintenance;

/**
 * Classe d'accès aux données contenues dans la table Fichemaintenance
 * 
 * @author diesnis
 * @version 1
 */
public class FichemaintenanceDAO {

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
	public FichemaintenanceDAO() {
		// chargement du pilote de bases de données
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err.println(
					"Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}

	}

	/**
	 * Permet d'ajouter un Fichemaintenance dans la table Fichemaintenance Le
	 * mode est auto-commit par défaut : chaque insertion est validée
	 * 
	 * @param Fichemaintenance
	 *            l'Fichemaintenance à ajouter
	 * @return retourne le nombre de lignes ajoutées dans la table
	 */
	public static int ajouter(Fichemaintenance fichemaintenance) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;

		// connexion à la base de données
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// préparation de l'instruction SQL, chaque ? représente une
			// valeur
			// à communiquer dans l'insertion
			// les getters permettent de récupérer les valeurs des attributs
			// souhaités
			ps = con.prepareStatement(
					"INSERT INTO Fichemaintenance_FMA (FMA_ID,FMA_CLIENT,FMA_DEVIS,FMA_CATEGORIE) VALUES (?, ?, ?, ?)");
			ps.setInt(1, fichemaintenance.getId());
			ps.setInt(2, fichemaintenance.getClient().getId());
			ps.setInt(3, fichemaintenance.getDevis().getId());
			ps.setString(4, fichemaintenance.getCategorie());

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
	 * Permet d'ajouter un Fichemaintenance dans la table Fichemaintenance Le
	 * mode est auto-commit par défaut : chaque insertion est validée
	 * 
	 * @param Fichemaintenance
	 *            l'Fichemaintenance à ajouter
	 * @return retourne le nombre de lignes ajoutées dans la table
	 */
	public int suppr(Fichemaintenance fichemaintenance) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;

		// connexion à la base de données
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// préparation de l'instruction SQL, chaque ? représente une
			// valeur
			// à communiquer dans l'insertion
			// les getters permettent de récupérer les valeurs des attributs
			// souhaités
			ps = con.prepareStatement("DELETE FROM Fichemaintenance_FMA WHERE(FMA_ID)");
			ps.setInt(1, fichemaintenance.getId());

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
	 * Permet de récupérer un Fichemaintenance à partir de sa référence
	 * 
	 * @param id
	 *            la référence de l'Fichemaintenance à récupérer
	 * @return l'Fichemaintenance trouvé; null si aucun Fichemaintenance ne
	 *         correspond à cette référence
	 */
	public Fichemaintenance getFichemaintenance(int id) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Fichemaintenance retour = null;

		// connexion à la base de données
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Fichemaintenance_FMA WHERE FMA_ID = ?");
			ps.setInt(1, id);

			// on exécute la requête
			// rs contient un pointeur situé juste avant la première ligne
			// retournée
			rs = ps.executeQuery();
			// passe à la première (et unique) ligne retournée
			if (rs.next()) {
				Client client = ClientDAO.getClient(rs.getInt("FMA_CLIENT"));
				Devis devis = DevisDAO.getDevis(rs.getInt("FMA_DEVIS"));
				retour = new Fichemaintenance(rs.getInt("FMA_ID"), client, devis, rs.getString("FMA_CATEGORIE"));

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
 * methode d'affectation d'un operateur a une fiche de maintenance
 * @param id
 * @param operateur
 * @return void
 */
	public static int affecteroperateur(int id, int operateur) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int retour = 0;

		// connexion à la base de données
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("UPDATE FICHEMAINTENANCE_FMA SET FMA_OPERATEUR = ? WHERE FMA_ID = ?");
			ps.setInt(1, operateur);
			ps.setInt(2, id);
			
			//execute la requete
			retour=ps.executeUpdate();

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
	 * 
	 * @param id
	 * @param fiche de maintenance
	 * @return le nombre de ligne update de la base de donnee
	 */
	
	public static int update(Fichemaintenance fichemaintenance) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int retour = 0;

		// connexion à la base de données
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("UPDATE FICHEMAINTENANCE_FMA SET FMA_CLIENT=?,FMA_CATEGORIE=?,FMA_COMMENTAIRE=? WHERE FMA_ID = ?");
			ps.setInt(1, fichemaintenance.getClient().getId());
			ps.setString(2, fichemaintenance.getCategorie());
			ps.setString(3, fichemaintenance.getCommentaire());
			ps.setInt(4, fichemaintenance.getId());
			
			retour = ps.executeUpdate();
			

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
	 * Permet de récupérer tous les Fichemaintenances stockés dans la table
	 * Fichemaintenance
	 * 
	 * @return une ArrayList d'Fichemaintenances
	 */
	public List<Fichemaintenance> getListeFichemaintenances() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Fichemaintenance> retour = new ArrayList<Fichemaintenance>();

		// connexion à la base de données
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Fichemaintenance_STT");

			// on exécute la requête
			rs = ps.executeQuery();
			// on parcourt les lignes du résultat
			while (rs.next()) {
				Client client = ClientDAO.getClient(rs.getInt("DVI_CLIENT_ID"));
				Devis devis = DevisDAO.getDevis(rs.getInt("DVI_ID"));
				retour.add(new Fichemaintenance(rs.getInt("FMA_ID"), client, devis, rs.getString("FMA_CATEGORIE")));
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
