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
import DAO.OperateurDAO;
import models.Client;
import models.Operateur;

public class Graphique_saisiroperateur extends JPanel implements ActionListener {
	private Graphique mainApp;

	/**
	 * bouton de selection
	 */
	private JButton creeroperateur;

	private JButton retour;
	/**
	 * zone de texte pour le champ nom du client
	 */
	private JTextField textFielid;

	/**
	 * zone de texte pour le champ date
	 */
	private JTextField textFieldnom;

	/**
	 * zone de texte pour la categorie
	 * 
	 */
	private JTextField textFieldmdp;

	private JLabel labelid;

	private JLabel labeldnom;

	private JLabel labelmdp;

	private OperateurDAO operateurDAO;

	/**
	 * Constructeur Définit la fenêtre et ses composants - affiche la fenêtre
	 */
	public Graphique_saisiroperateur(Graphique main) {
		this.mainApp = main;

		// on instancie la classe OperateurDAO
		this.operateurDAO = new OperateurDAO();

		// on fixe le titre de la fenêtre
		this.setName("saisir un operateur");

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

		creeroperateur = new JButton("creer un operateur");
		creeroperateur.addActionListener(this);

		retour = new JButton("retour");
		retour.addActionListener(this);
		
		labelid = new JLabel("id :");
		textFielid = new JTextField();
		labeldnom = new JLabel("nom:");
		textFieldnom = new JTextField();
		labelmdp = new JLabel("mdp :");
		textFieldmdp = new JTextField();

		this.add(labelid);
		this.add(textFielid);
		
		this.add(labeldnom);
		this.add(textFieldnom);
		
		this.add(labelmdp);
		this.add(textFieldmdp);
		
		this.add(creeroperateur);
		this.add(retour);
	}

	public void actionPerformed(ActionEvent ae) {
		int retour1;
		if (ae.getSource() == creeroperateur) {
			Operateur a = new Operateur(this.textFieldnom.getText(), Integer.parseInt(this.textFielid.getText()),
					this.textFieldmdp.getText());
			// on demande à la classe de communication d'envoyer l'Station
			// dans la table Station
			retour1 = OperateurDAO.ajouter(a);
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