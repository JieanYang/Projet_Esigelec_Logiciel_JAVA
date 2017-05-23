package fenetre;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.ClientDAO;
import DAO.DevisDAO;
import DAO.FichemaintenanceDAO;
import models.Client;
import models.Devis;
import models.Fichemaintenance;

public class Graphique_saisirmaintenance extends JPanel implements ActionListener {
	private Graphique mainApp;
	/**
	 * bouton de selection
	 */
	private JButton creerdemande;

	private JButton retour;

	/**
	 * zone de texte pour le champ id fiche
	 */
	private JTextField textFieldid;
	/**
	 * zone de texte pour le champ id client
	 */
	private JTextField textFieldclient;
	/**
	 * zone de texte pour la categorie
	 * 
	 */
	private JTextField textFieldcategorie;

	private JLabel labelid;

	private JLabel labelclient;

	private JLabel labelcategorie;

	private FichemaintenanceDAO Fiche;

	/**
	 * Constructeur Définit la fenêtre et ses composants - affiche la fenêtre
	 */
	public Graphique_saisirmaintenance(Graphique main) {
		this.mainApp = main;

		// on instancie la classe Client DAO
		this.Fiche = new FichemaintenanceDAO();

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		creerdemande = new JButton("creer une demande");
		creerdemande.addActionListener(this);

		retour = new JButton("retour");
		retour.addActionListener(this);

		textFieldid = new JTextField();
		textFieldclient = new JTextField();
		textFieldcategorie = new JTextField();

		labelid = new JLabel("id fiche:");
		labelclient = new JLabel("id client");
		labelcategorie = new JLabel("categorie :");
		// ajout des composants sur le container
		// introduire une espace constant entre le champ texte et le composant
		// suivant

		this.add(labelid);
		this.add(textFieldid);

		this.add(labelclient);
		this.add(textFieldclient);

		this.add(labelcategorie);
		this.add(textFieldcategorie);

		this.add(creerdemande);
		this.add(retour);

	}

	public void actionPerformed(ActionEvent ae) {
		int retour1;
		if (ae.getSource() == creerdemande) {
			Client client = ClientDAO.getClient(Integer.parseInt(this.textFieldclient.getText()));	
			Devis devis = DevisDAO.creerdevis();
			Fichemaintenance a = new Fichemaintenance(Integer.parseInt(this.textFieldid.getText()), client, devis,
					this.textFieldcategorie.getText());
			// on demande à la classe de communication d'envoyer l'Station
			// dans la table Station
			retour1 = FichemaintenanceDAO.ajouter(a);
			// affichage du nombre de lignes ajoutées
			// dans la bdd pour vérification
			System.out.println("" + retour + " ligne ajoutée ");
			if (retour1 == 1)
				JOptionPane.showMessageDialog(this, "Client ajouter !");
			else
				JOptionPane.showMessageDialog(this, "erreur ajout Client", "Erreur", JOptionPane.ERROR_MESSAGE);

		}

		if (ae.getSource() == retour) {
			this.mainApp.switchPanel();

		}

	}

}
