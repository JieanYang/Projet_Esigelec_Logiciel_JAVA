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
import models.Devis;

public class Graphiquemaintenance extends JFrame implements ActionListener {
	private JPanel containerPanel;
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

	/**
	 * Constructeur Définit la fenêtre et ses composants - affiche la fenêtre
	 */
	public Graphiquemaintenance() {

		// on fixe le titre de la fenêtre
		this.setTitle("saisir une maintenance");
		// initialisation de la taille de la fenêtre
		this.setSize(500, 630);
		this.setLocationRelativeTo(null);
		// création du conteneur
		containerPanel = new JPanel();

		// choix du Layout pour ce conteneur
		// il permet de gérer la position des éléments
		// il autorisera un retaillage de la fenêtre en conservant la
		// présentation
		// BoxLayout permet par exemple de positionner les élements sur une
		// colonne ( PAGE_AXIS )
		containerPanel.setLayout(null);

		// choix de la couleur pour le conteneur
		containerPanel.setBackground(Color.lightGray);
		// instantiation des composants graphiques

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
		
		
		containerPanel.add(labelnom);
		containerPanel.add(textFieldnom);
		containerPanel.add(labeldate);
		containerPanel.add(textFielddate);
		containerPanel.add(labelcategorie);
		containerPanel.add(textFieldcategorie);
		containerPanel.add(creerdemande);
		containerPanel.add(retour);
		// ajouter une bordure vide de taille constante autour de l'ensemble des
		// composants
		containerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// permet de quitter l'application si on ferme la fenêtre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setContentPane(containerPanel);

		// affichage de la fenêtre
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == creerdemande) {
			this.dispose();
		}
		if (ae.getSource() == retour) {
			Graphique ap = new Graphique();
			this.dispose();

		}

	}

}
