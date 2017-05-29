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
import DAO.DevisDAO;
import models.Client;
import models.Devis;

public class Graphique_modifierdevis extends JPanel implements ActionListener {
	private Graphique mainApp;

	/**
	 * bouton de selection
	 */
	private JButton modifierdevis;
	private JButton choixdevis;

	private JButton retour;
	/**
	 * zone de texte pour le choix du devis a modifier
	 */
	private JTextField textFieldid;
	private JLabel labelid;
	/**
	 * zone de texte pour le nom du devis
	 */
	private JTextField textFieldnom;
	private JLabel labelnom;
	/**
	 * zone de texte pour le client du devis
	 */
	private JTextField textFieldclient;
	private JLabel labelclient;
	/**
	 * zone de texte pour la categorie du devis
	 */
	private JTextField textFieldcategorie;
	private JLabel labelcategorie;
	/**
	 * zone de texte pour la date du devis
	 */
	private JTextField textFielddate;
	private JLabel labeldate;

	private OperateurDAO OperateurDAO;
	private ClientDAO ClientDAO;
	private DevisDAO DevisDAO;

	/**
	 * Constructeur Définit la fenêtre et ses composants - affiche la fenêtre
	 */
	public Graphique_modifierdevis(Graphique main) {
		this.mainApp = main;

		// on instancie la classe Client DAO et operateur
		this.OperateurDAO = new OperateurDAO();
		this.ClientDAO = new ClientDAO();
		this.DevisDAO = new DevisDAO();

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

		modifierdevis = new JButton("modifier devis");
		modifierdevis.addActionListener(this);

		choixdevis = new JButton("choix du devis a modifier");
		choixdevis.addActionListener(this);

		retour = new JButton("retour");
		retour.addActionListener(this);

		textFieldid = new JTextField();
		textFieldnom = new JTextField();
		textFieldcategorie = new JTextField();
		textFieldclient = new JTextField();
		textFielddate = new JTextField();

		labelid = new JLabel("id du devis a modifier");
		labelnom = new JLabel("nom du devis");
		labelcategorie = new JLabel("categorie du devis");
		labelclient = new JLabel("client du devis");
		labeldate = new JLabel("date du devis");

		this.add(labelid);
		this.add(textFieldid);
		this.add(choixdevis);

		this.add(labelnom);
		this.add(textFieldnom);
		this.add(labelclient);
		this.add(textFieldclient);
		this.add(labelcategorie);
		this.add(textFieldcategorie);
		this.add(labeldate);
		this.add(textFielddate);
		this.add(modifierdevis);

		this.add(retour);

	}

	public void actionPerformed(ActionEvent ae) {
		int retour1;
		if (ae.getSource() == choixdevis) {
			Devis retour;
			retour = DevisDAO.getDevis(Integer.parseInt(this.textFieldid.getText()));
			labelnom.setText("nom dans la bdd=		"+DevisDAO.getDevis(Integer.parseInt(this.textFieldid.getText())).getNomdevis());
			labelcategorie.setText("categorie dans la bdd=		"+DevisDAO.getDevis(Integer.parseInt(this.textFieldid.getText())).getCategorie());
			labelclient.setText("id client dans la bdd=		"+Integer.toString(DevisDAO.getDevis(Integer.parseInt(this.textFieldid.getText())).getClient().getId()));
			labeldate.setText("date dans la bdd=		"+DevisDAO.getDevis(Integer.parseInt(this.textFieldid.getText())).getDate());
			if (retour != null)
				JOptionPane.showMessageDialog(this, "Devis choisie !");
			else
				JOptionPane.showMessageDialog(this, "erreur choix du devis", "Erreur", JOptionPane.ERROR_MESSAGE);

		}
		if (ae.getSource() == modifierdevis) {
			Client client = ClientDAO.getClient(Integer.parseInt(this.textFieldclient.getText()));
			Devis a = new Devis(Integer.parseInt(this.textFieldid.getText()), this.textFieldnom.getText(), client,
					this.textFieldcategorie.getText(), this.textFielddate.getText());
			// on demande à la classe de communication d'envoyer l'Station
			// dans la table Station
			retour1 = DevisDAO.update(a);
			// affichage du nombre de lignes ajoutées
			// dans la bdd pour vérification
			System.out.println("" + retour1 + " ligne ajoutée ");
			if (retour1 == 1)
				JOptionPane.showMessageDialog(this, "Devis modifier !");
			else
				JOptionPane.showMessageDialog(this, "erreur modification devis", "Erreur", JOptionPane.ERROR_MESSAGE);

		}
		if (ae.getSource() == retour) {
			this.mainApp.switchPanel();

		}

	}

}
