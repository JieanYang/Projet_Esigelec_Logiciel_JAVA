package fenetre;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.ClientDAO;
import DAO.DevisDAO;
import DAO.OperateurDAO;
import DAO.FichemaintenanceDAO;
import models.Client;
import models.Devis;
import models.Fichemaintenance;

public class Graphique_validation extends JPanel implements ActionListener {
	private Graphique mainApp;

	/**
	 * bouton de selection d'une fiche
	 * 
	 */
	private JButton choixfiche;
	/**
	 * bouton pour update une fiche sur la bdd comme valider
	 * 
	 */
	private JButton validation;
	/**
	 * bouton pour update une fiche sur la bdd comme non valider
	 */
	private JButton novalidation;

	/**
	 * bouton de retour au menu principal
	 * 
	 */
	private JButton retour;

	/**
	 * zone de texte pour l'id de la fiche de maintenance
	 */
	private JTextField textFieldid;
	private JLabel labelid;
	/**
	 * zone de texte pour l'id du client
	 */
	private JTextField textFieldclient;
	private JLabel labelclient;
	
	private JLabel labeldevis;
	private JLabel labelcategorie;
	private JLabel labeloperateur;
	private JLabel labelcommentaire;

	private OperateurDAO OperateurDAO;
	private ClientDAO ClientDAO;
	private FichemaintenanceDAO FichemaintenanceDAO;

	/**
	 * Constructeur Définit la fenêtre et ses composants - affiche la fenêtre
	 */
	public Graphique_validation(Graphique main) {
		this.mainApp = main;

		// on instancie la classe Client DAO et operateur
		this.OperateurDAO = new OperateurDAO();
		this.ClientDAO = new ClientDAO();
		this.FichemaintenanceDAO = new FichemaintenanceDAO();

		// choix du Layout pour ce conteneur
		// il permet de gérer la position des éléments
		// il autorisera un retaillage de la fenêtre en conservant la
		// présentation
		// BoxLayout permet par exemple de positionner les élements sur une
		// colonne ( PAGE_AXIS )
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		// choix de la couleur pour le conteneur
		this.setBackground(Color.lightGray);

		// instantiation des composants graphiques

		validation = new JButton("valider");
		validation.addActionListener(this);
		
		novalidation = new JButton("non valider");
		novalidation.addActionListener(this);

		choixfiche = new JButton("choix fiche");
		choixfiche.addActionListener(this);

		retour = new JButton("retour");
		retour.addActionListener(this);

		textFieldid = new JTextField();

		labelid = new JLabel("id de la fiche a modifier :");
		labelclient = new JLabel("id du client:");
		labelcategorie = new JLabel("categorie :");
		labeldevis = new JLabel("id du devis :");
		labelcommentaire = new JLabel("commentaire:");

		// ajout des composants sur le container
		// introduire une espace constant entre le champ texte et le composant
		// suivant

		this.add(labelid);
		this.add(textFieldid);
		this.add(choixfiche);

		this.add(labelclient);
		this.add(labeldevis);
		this.add(labelcategorie);
		this.add(labelcommentaire);
		this.add(validation);
		this.add(novalidation);

		this.add(retour);
	}

	public void actionPerformed(ActionEvent ae) {
		int retour1;
		if (ae.getSource() == choixfiche) {
			Fichemaintenance retour;
			retour = FichemaintenanceDAO.getFichemaintenance(Integer.parseInt(this.textFieldid.getText()));
			labelclient.setText("id du client de la bdd=		" + Integer.toString(FichemaintenanceDAO
					.getFichemaintenance(Integer.parseInt(this.textFieldid.getText())).getClient().getId()));
			labeldevis.setText("id du devis de la bdd=		" + Integer.toString(FichemaintenanceDAO
					.getFichemaintenance(Integer.parseInt(this.textFieldid.getText())).getDevis().getId()));
			labelcategorie.setText("categorie=		" + FichemaintenanceDAO
					.getFichemaintenance(Integer.parseInt(this.textFieldid.getText())).getCategorie());
			labelcommentaire.setText("commentaire de la bdd=		" + FichemaintenanceDAO
					.getFichemaintenance(Integer.parseInt(this.textFieldid.getText())).getCommentaire());
			if (retour != null)
				JOptionPane.showMessageDialog(this, "Fiche choisie !");
			else
				JOptionPane.showMessageDialog(this, "erreur choix de Fiche", "Erreur", JOptionPane.ERROR_MESSAGE);

		}
		if (ae.getSource() == validation) {
			int retour2;
			String reponse;
			reponse = "maintenance valider";

			retour2 = FichemaintenanceDAO.valider(Integer.parseInt(this.textFieldid.getText()),reponse);
			// affichage du nombre de lignes ajoutées
			// dans la bdd pour vérification
			if (retour2 != 0)
				JOptionPane.showMessageDialog(this, "Fiche valider !");
			else
				JOptionPane.showMessageDialog(this, "erreur validation fiche", "Erreur", JOptionPane.ERROR_MESSAGE);

		}
		if (ae.getSource() == novalidation) {
			int retour2;
			String reponse;
			reponse = "maintenance non valider";

			retour2 = FichemaintenanceDAO.valider(Integer.parseInt(this.textFieldid.getText()),reponse);
			// affichage du nombre de lignes ajoutées
			// dans la bdd pour vérification
			if (retour2 != 0)
				JOptionPane.showMessageDialog(this, "Fiche non valider !");
			else
				JOptionPane.showMessageDialog(this, "erreur validation fiche", "Erreur", JOptionPane.ERROR_MESSAGE);
		}

		if (ae.getSource() == retour) {
			this.mainApp.switchPanel();

		}

	}

}
