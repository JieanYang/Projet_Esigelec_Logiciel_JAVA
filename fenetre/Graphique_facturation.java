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

public class Graphique_facturation extends JPanel implements ActionListener {
	private Graphique mainApp;

	/**
	 * bouton de selection
	 */
	private JButton ajooutfacture;
	private JButton choixdevis;

	private JButton retour;
	/**
	 * zone de texte pour le choix du devis a facturer
	 */
	private JTextField textFieldid;
	private JLabel labelid;
	/**
	 * zone de texte pour la description des elements facturable
	 */
	private JTextField textFielddescription;
	private JLabel labeldescription;
	/**
	 * zone de texte pour le prix
	 */
	private JTextField textFieldprix;
	private JLabel labelprix;
	/**
	 * zone de texte pour les taxes
	 */
	private JTextField textFieldtaxe;
	private JLabel labeltaxe;
	/**
	 * zone de texte pour le surcout
	 */
	private JTextField textFieldsurcout;
	private JLabel labeldatesurcout;
	
	private JLabel labelnom;
	private JLabel labelclient;
	private JLabel labelcategorie;
	private JLabel labeldate;

	private OperateurDAO OperateurDAO;
	private ClientDAO ClientDAO;
	private DevisDAO DevisDAO;

	/**
	 * Constructeur Définit la fenêtre et ses composants - affiche la fenêtre
	 */
	public Graphique_facturation(Graphique main) {
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

		ajooutfacture = new JButton("ajout facture");
		ajooutfacture.addActionListener(this);

		choixdevis = new JButton("choix du devis a modifier");
		choixdevis.addActionListener(this);

		retour = new JButton("retour");
		retour.addActionListener(this);

		textFieldid = new JTextField();
		textFieldprix = new JTextField();
		textFieldtaxe = new JTextField();
		textFieldsurcout = new JTextField();
		textFielddescription = new JTextField();

		labelid = new JLabel("id du devis a facturer");
		labelprix = new JLabel("prix de la maintenance");
		labeldescription = new JLabel("description");
		labeldatesurcout = new JLabel("cout du surcout");
		labeltaxe = new JLabel("taxe/TVA");
		labelnom = new JLabel("");
		labelclient = new JLabel("");
		labelcategorie = new JLabel("");
		labeldate = new JLabel("");
		
		

		this.add(labelid);
		this.add(textFieldid);
		this.add(choixdevis);
		this.add(labelnom);
		this.add(labelclient);
		this.add(labelcategorie);
		this.add(labeldate);
		

		this.add(labelprix);
		this.add(textFieldprix);
		this.add(labeldatesurcout);
		this.add(textFieldsurcout);
		this.add(labeldescription);
		this.add(textFielddescription);
		this.add(labeltaxe);
		this.add(textFieldtaxe);
		this.add(ajooutfacture);

		this.add(retour);

	}

	public void actionPerformed(ActionEvent ae) {
		int retour1;
		if (ae.getSource() == choixdevis) {
			Devis retour;
			retour = DevisDAO.getDevis(Integer.parseInt(this.textFieldid.getText()));
			labelnom.setText("nom dans la bdd=		"+DevisDAO.getDevis(Integer.parseInt(this.textFieldid.getText())).getNomdevis());
			labelclient.setText("categorie dans la bdd=		"+DevisDAO.getDevis(Integer.parseInt(this.textFieldid.getText())).getCategorie());
			labelcategorie.setText("id client dans la bdd=		"+Integer.toString(DevisDAO.getDevis(Integer.parseInt(this.textFieldid.getText())).getClient().getId()));
			labeldate.setText("date dans la bdd=		"+DevisDAO.getDevis(Integer.parseInt(this.textFieldid.getText())).getDate());
			if (retour != null)
				JOptionPane.showMessageDialog(this, "Devis choisie !");
			else
				JOptionPane.showMessageDialog(this, "erreur choix du devis", "Erreur", JOptionPane.ERROR_MESSAGE);

		}
		if (ae.getSource() == ajooutfacture) {
			int prix;
			int surcout;
			int taxe;
			String description;
					prix = Integer.parseInt(textFieldprix.getText());
					surcout=Integer.parseInt(textFieldtaxe.getText());
					taxe=Integer.parseInt(textFieldtaxe.getText());
					description = textFielddescription.getText();
			// on demande à la classe de communication d'envoyer l'Station
			// dans la table Station
			retour1 = DevisDAO.facture(Integer.parseInt(this.textFieldid.getText()),prix,surcout,taxe,description);
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

