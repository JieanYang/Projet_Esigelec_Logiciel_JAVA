package fenetre;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.ClientDAO;
import DAO.FichemaintenanceDAO;
import models.Devis;

public class Graphique_saisirmaintenance extends JPanel implements ActionListener {
	private Graphique mainApp;
	/**
	 * bouton de selection
	 */
	private JButton creerdemande;

	private JButton retour;
	/**
	 * zone de texte pour le champ nom du client
	 */
	private JTextField textFieldnom;

	/**
	 * zone de texte pour le champ date
	 */
	private JTextField textFielddate;

	/**
	 * zone de texte pour la categorie
	 * 
	 */
	private JTextField textFieldcategorie;

	private JLabel labelnom;

	private JLabel labeldate;

	private JLabel labelcategorie;
	
	private FichemaintenanceDAO Fiche;

	/**
	 * Constructeur Définit la fenêtre et ses composants - affiche la fenêtre
	 */
	public Graphique_saisirmaintenance(Graphique main) {
			this.mainApp = main;
			
			// on instancie la classe Client DAO
			this.Fiche = new FichemaintenanceDAO();

			// on fixe le titre de la fenêtre
			this.setName("saisir un operateur");

		creerdemande = new JButton("creer une demande");
		creerdemande.addActionListener(this);

		retour = new JButton("retour");
		retour.addActionListener(this);

		textFielddate = new JTextField();
		textFieldnom = new JTextField();
		textFieldcategorie = new JTextField();

		labeldate = new JLabel("date :");
		labelnom = new JLabel("nom:");
		labelcategorie = new JLabel("categorie :");
		// ajout des composants sur le container
		// introduire une espace constant entre le champ texte et le composant
		// suivant
		labelnom.setBounds(20, 10, 150, 30);
		textFieldnom.setBounds(20, 50, 460, 50);
		labeldate.setBounds(20, 110, 150, 30);
		textFielddate.setBounds(20, 150, 460, 50);
		labelcategorie.setBounds(20, 210, 150, 30);
		textFieldcategorie.setBounds(20, 250, 460, 50);
		creerdemande.setBounds(20, 330, 150, 30);
		retour.setBounds(180, 330, 150, 30);
		
		
		this.add(labelnom);
		this.add(textFieldnom);
		this.add(labeldate);
		this.add(textFielddate);
		this.add(labelcategorie);
		this.add(textFieldcategorie);
		this.add(creerdemande);
		this.add(retour);



	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == creerdemande) {
		}
		if (ae.getSource() == retour) {
			this.mainApp.switchPanel();

		}

	}

}
