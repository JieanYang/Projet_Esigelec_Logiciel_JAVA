import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.Box;

import java.util.List;

/**
 * Classe graphique
 * 
 * @author Diesnis
 * @version 1
 */

public class Graphique extends JFrame implements ActionListener {
	/**
	 * label saisir un client
	 */
	private JLabel labelsaisirunclient;

	/**
	 * label saisir une maintenance
	 */
	private JLabel labelsaisirunemaintenance;

	/**
	 * label validation d'une maintenance
	 */

	private JLabel labelvalidation;

	/**
	 * label saisir un operateur
	 */
	private JLabel labelsaisirunoperateur;

	/**
	 * label modifier fiche de maintenance
	 */
	private JLabel labelmodifierfiche;

	/**
	 * label modifier un devis
	 */
	private JLabel labelmodifierdevis;

	/**
	 * label affecter un operateur
	 */
	private JLabel labelaffecteroperateur;
	/**
	 * bouton de selection
	 */
	private JButton boutonvalidation;
	private JButton boutonsaisirclient;
	private JButton boutonsaisirmaintenance;
	private JButton boutonsaisiroperateur;
	private JButton boutonmodifierdevis;
	private JButton boutonaffecteroperateur;
	private JButton boutonmodifierfiche;

	/**
	 * Constructeur Définit la fenêtre et ses composants - affiche la fenêtre
	 */
	public Graphique() {
		// on instancie la classe Station DAO
		this.DAO = new DAO();

		// on fixe le titre de la fenêtre
		this.setTitle("Menu");
		// initialisation de la taille de la fenêtre
		this.setSize(400, 600);

		// création du conteneur
		containerPanel = new JPanel();

		// choix du Layout pour ce conteneur
		// il permet de gérer la position des éléments
		// il autorisera un retaillage de la fenêtre en conservant la
		// présentation
		// BoxLayout permet par exemple de positionner les élements sur une
		// colonne ( PAGE_AXIS )
		containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.PAGE_AXIS));

		// choix de la couleur pour le conteneur
		containerPanel.setBackground(Color.lightGray);
		// instantiation des composants graphiques
		
				boutonvalidation = new JButton("validation");
				boutonsaisirclient = new JButton("saisirclient");
				boutonsaisirmaintenance = new JButton("saisirmaintenance");
				boutonsaisiroperateur = new JButton("saisiroperateur");
				boutonmodifierdevis = new JButton("modifierdevis");
				boutonaffecteroperateur = new JButton("affecteroperateur");
				boutonmodifierfiche = new JButton("modifierfiche");
				labelsaisirunclient = new JLabel("saisir :");
				labelsaisirunemaintenance = new JLabel("nom:");
				labelvalidation = new JLabel("ville :");
				labelsaisirunoperateur = new JLabel("adresse :");
				labelmodifierfiche = new JLabel("date:");
				labelaffecteroperateur = new JLabel("tstid :");
				labelmodifierdevis = new Jlabel("modifier devis:");

				zoneTextListStation = new JTextArea(10, 20);
				zoneDefilement = new JScrollPane(zoneTextListStation);
				zoneTextListStation.setEditable(false);

				// ajout des composants sur le container
				containerPanel.add(labelid);

				// introduire une espace constant entre le champ texte et le composant
				// suivant
				containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
				containerPanel.add(labelnom);


				containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
				containerPanel.add(labelville);


				containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
				containerPanel.add(labeladresse);

				containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

				containerPanel.add(labeldate);

				containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

				containerPanel.add(labeltstid);

				containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

				containerPanel.add(boutonAjouter);
				containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

				containerPanel.add(boutonsuppr);
				containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

				containerPanel.add(boutonAffichageTousLesStations);
				containerPanel.add(Box.createRigidArea(new Dimension(0, 5)));

				containerPanel.add(zoneDefilement);

				// ajouter une bordure vide de taille constante autour de l'ensemble des
				// composants
				containerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

				// ajout des écouteurs sur les boutons pour gérer les évènements
				boutonAjouter.addActionListener(this);
				boutonAffichageTousLesStations.addActionListener(this);

				// permet de quitter l'application si on ferme la fenêtre
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				this.setContentPane(containerPanel);

				// affichage de la fenêtre
				this.setVisible(true);
	}
}
