import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Classe graphique
 * 
 * @author Diesnis
 * @version 1
 */

public class Graphique extends JFrame implements ActionListener {

	private JPanel containerPanel;

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
	private JButton boutonfacturation;
	private JButton boutonsuivireglement;
	private JButton boutoncloturedossier;
	private JButton boutoneditionrapport;

	/**
	 * Constructeur Définit la fenêtre et ses composants - affiche la fenêtre
	 */
	public Graphique() {
		// on instancie la classe Station DAO
		// this.DAO = new DAO();

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
		boutonsaisirmaintenance.addActionListener(this);

		boutonsaisiroperateur = new JButton("saisiroperateur");

		boutonmodifierdevis = new JButton("modifierdevis");

		boutonaffecteroperateur = new JButton("affecteroperateur");

		boutonmodifierfiche = new JButton("modifierfiche");
		
		boutonfacturation = new JButton("facturation de prestation");

		boutonsuivireglement = new JButton("suivi du reglement");
		boutonsuivireglement.addActionListener(this);

		boutoncloturedossier = new JButton("cloture du dossier");

		boutoneditionrapport = new JButton("edition du rapport d'activite au client");

		// ajout des composants sur le container
		// introduire une espace constant entre le champ texte et le composant
		// suivant
		containerPanel.add(boutonvalidation);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		containerPanel.add(boutonsaisirclient);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		containerPanel.add(boutonsaisirmaintenance);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		containerPanel.add(boutonsaisiroperateur);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		containerPanel.add(boutonmodifierdevis);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		containerPanel.add(boutonaffecteroperateur);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		containerPanel.add(boutonmodifierfiche);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 5)));

		containerPanel.add(boutonfacturation);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		containerPanel.add(boutonsuivireglement);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		containerPanel.add(boutoncloturedossier);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		containerPanel.add(boutoneditionrapport);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 5)));

		// ajouter une bordure vide de taille constante autour de l'ensemble des
		// composants
		containerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 5));

		// permet de quitter l'application si on ferme la fenêtre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setContentPane(containerPanel);

		// affichage de la fenêtre
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == boutonsaisirmaintenance) {
			//this.dispose();
			Graphiquemaintenance ap = new Graphiquemaintenance();
			if (ae.getSource() == boutonsuivireglement) {
			}
			}
		}

	}


