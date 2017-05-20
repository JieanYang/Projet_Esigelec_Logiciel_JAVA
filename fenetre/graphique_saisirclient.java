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
import models.Client;
import models.Devis;

public class Graphique_saisirclient extends JPanel implements ActionListener {
	private Graphique mainApp;
	/**
	 * bouton de selection
	 */
	private JButton creerclient;

	private JButton retour;
	/**
	 * zone de texte pour le champ l'id du client
	 */
	private JTextField textFieldid;

	/**
	 * zone de texte pour le champ nom
	 */
	private JTextField textFieldnom;

	/**
	 * zone de texte pour le siret
	 * 
	 */
	private JTextField textFieldsiret;
	/**
	 * zone de texte pour le codeape
	 * 
	 */
	private JTextField textFieldcodeape;
	/**
	 * zone de texte pour l' adresse
	 * 
	 */
	private JTextField textFieldadresse;

	private JLabel labelid;
	private JLabel labelnom;
	private JLabel labelsiret;
	private JLabel labelcodeape;
	private JLabel labeladresse;
	private ClientDAO clientDAO;

	/**
	 * Constructeur Définit la fenêtre et ses composants - affiche la fenêtre
	 */
	public Graphique_saisirclient(Graphique main) {

		// permet le retour fenetre main
		this.mainApp = main;
		// on instancie la classe Client DAO
		this.clientDAO = new ClientDAO();

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

		creerclient = new JButton("creer un client");
		creerclient.addActionListener(this);

		retour = new JButton("retour");
		retour.addActionListener(this);

		textFieldid = new JTextField();
		textFieldnom = new JTextField();
		textFieldsiret = new JTextField();
		textFieldcodeape = new JTextField();
		textFieldadresse = new JTextField();

		labelid = new JLabel("id  :");
		labelnom = new JLabel("nom:");
		labelsiret = new JLabel("siret :");
		labelcodeape = new JLabel("codeape :");
		labeladresse = new JLabel("adresse:");

		// ajout des composants sur le container
		// introduire une espace constant entre le champ texte et le composant
		// suivant

		this.add(labelid);
		this.add(textFieldid);

		this.add(labelnom);
		this.add(textFieldnom);

		this.add(labelsiret);
		this.add(textFieldsiret);

		this.add(labelcodeape);
		this.add(textFieldcodeape);

		this.add(labeladresse);
		this.add(textFieldadresse);

		this.add(creerclient);
		
		this.add(retour);

	}

	public void actionPerformed(ActionEvent ae) {
		int retour1;
		if (ae.getSource() == creerclient) {
			Client a = new Client(Integer.parseInt(this.textFieldid.getText()), this.textFieldnom.getText(),
					Integer.parseInt(this.textFieldsiret.getText()), Integer.parseInt(this.textFieldcodeape.getText()),
					this.textFieldadresse.getText());
			// on demande à la classe de communication d'envoyer l'Station
			// dans la table Station
			retour1 = clientDAO.ajouter(a);
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
