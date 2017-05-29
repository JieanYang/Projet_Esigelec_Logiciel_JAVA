package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe d'accès aux données contenues dans la table Mdp
 * 
 * @author diesnis
 * @version 1
 */
public class MdpDAO {
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
	public MdpDAO() {
		// chargement du pilote de bases de données
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err.println(
					"Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}

	}

/**
 * permet de test un mdp operateur
 * @param id
 * @param mdp
 * @return mdp de la base de donnee associer a l'id de l'operateur
 */
	public String OptMdp(int id) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String retour = null;

		// connexion à la base de données
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT OPT_MDP FROM Operateur_OPT WHERE OPT_ID = ?");
			ps.setInt(1, id);

			// on exécute la requête
			// rs contient un pointeur situé juste avant la première ligne
			// retournée
			rs = ps.executeQuery();
			// passe à la première (et unique) ligne retournée
			if (rs.next())
				retour = (rs.getString("OPT_MDP"));

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
	 * permet de verif le mdp d'un comptable
	 * @param id
	 * @param mdp
	 * @return mdp associer a l'id du comptable
	 */

	public String CompMdp(int id) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String retour = null;

		// connexion à la base de données
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT CPT_MDP FROM COMPTABLE_CPT WHERE CPT_ID = ?");
			ps.setInt(1, id);

			// on exécute la requête
			// rs contient un pointeur situé juste avant la première ligne
			// retournée
			rs = ps.executeQuery();
			// passe à la première (et unique) ligne retournée
			if (rs.next())
				retour = (rs.getString("CPT_MDP"));

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
	 * permet de tester le mdp du responsable
	 * @param id
	 * @param mdp
	 * @return le mdp associer a l'id du responsable
	 */
	public static String RespMdp(int id ) {


		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String retour = "";

		// connexion à la base de données
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT RSP_MDP FROM Responsable_RSP WHERE RSP_ID = ?");
			ps.setInt(1, id);

			// on exécute la requête
			// rs contient un pointeur situé juste avant la première ligne
			// retournée
			rs = ps.executeQuery();
			// passe à la première (et unique) ligne retournée
			if (rs.next())
				retour = rs.getString("RSP_MDP");

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
}
