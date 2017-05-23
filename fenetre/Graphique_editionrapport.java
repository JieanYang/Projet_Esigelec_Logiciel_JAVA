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
import DAO.RapportactiviteDAO;
import models.Client;
import models.Devis;
import models.Rapportactivite;

public class Graphique_editionrapport extends JPanel implements ActionListener {
	private Graphique mainApp;
	/**
	 * bouton de selection
	 */
	private JButton creerrapport;

	private JButton retour;
	/**
	 * zone de texte pour le champ l'id du rapport
	 */
	private JTextField textFieldid;

	/**
	 * zone de texte pour le champ date
	 */
	private JTextField textFielddate;

	/**
	 * zone de texte pour le commentaire
	 * 
	 */
	private JTextField textFieldcommentaire;
	/**
	 * zone de texte pour le devis
	 * 
	 */
	private JTextField textFielddevis;
	/**
	 * zone de texte pour l' client
	 * 
	 */
	private JTextField textFieldclient;

	private JLabel labelid;
	private JLabel labeldate;
	private JLabel labelcommentaire;
	private JLabel labeldevis;
	private JLabel labelclient;
	private ClientDAO clientDAO;
	private DevisDAO devisDAo;

	/**
	 * Constructeur Définit la fenêtre et ses composants - affiche la fenêtre
	 */
	public Graphique_editionrapport(Graphique main) {

		// permet le retour fenetre main
		this.mainApp = main;
		// on instancie la classe Client DAO
		this.clientDAO = new ClientDAO();
		this.devisDAo = new DevisDAO();

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

		creerrapport = new JButton("creer un client");
		creerrapport.addActionListener(this);

		retour = new JButton("retour");
		retour.addActionListener(this);

		textFieldid = new JTextField();
		textFielddate = new JTextField();
		textFieldclient = new JTextField();
		textFieldcommentaire = new JTextField();
		textFielddevis = new JTextField();

		labelid = new JLabel("id  :");
		labeldate = new JLabel("date:");
		labelcommentaire = new JLabel("commentaire :");
		labelclient = new JLabel("client id :");
		labeldevis = new JLabel("devis id:");

		// ajout des composants sur le container
		// introduire une espace constant entre le champ texte et le composant
		// suivant

		this.add(labelid);
		this.add(textFieldid);

		this.add(labeldate);
		this.add(textFielddate);

		this.add(labelcommentaire);
		this.add(textFieldcommentaire);

		this.add(labelclient);
		this.add(textFieldclient);

		this.add(labeldevis);
		this.add(textFielddevis);

		this.add(creerrapport);
		
		this.add(retour);

	}

	public void actionPerformed(ActionEvent ae) {
		int retour1;
		if (ae.getSource() == creerrapport) {
			Client client = ClientDAO.getClient(Integer.parseInt(this.textFieldid.getText()));
			Devis devis = DevisDAO.getDevis(Integer.parseInt(this.textFieldid.getText()));
			Rapportactivite a = new Rapportactivite(Integer.parseInt(this.textFieldid.getText()), this.textFielddate.getText(),
					 this.textFieldcommentaire.getText(),devis, client);
			// on demande à la classe de communication d'envoyer l'Station
			// dans la table Station
			retour1 = RapportactiviteDAO.ajouter(a);
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

