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

public class Graphiquemaintenance extends JFrame implements ActionListener {
	private JPanel containerPanel;
	/**
	 * bouton de selection
	 */
	private JButton creerdemande;
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

		creerdemande = new JButton("creer une demande");
		creerdemande.addActionListener(this);

		textFielddate = new JTextField();
		textFieldnom = new JTextField();
		textFieldcategorie = new JTextField();

		labeldate = new JLabel("date :");
		labelnom = new JLabel("nom:");
		labelcategorie = new JLabel("categorie :");
		// ajout des composants sur le container
		// introduire une espace constant entre le champ texte et le composant
		// suivant
		containerPanel.add(labelnom);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		containerPanel.add(textFieldnom);

		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.add(labeldate);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		containerPanel.add(textFielddate);

		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.add(labelcategorie);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		containerPanel.add(textFieldcategorie);

		containerPanel.add(creerdemande);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
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
			Devis ap = new Devis(this.textFieldnom.getText(),this.textFielddate.getText(),this.textFieldcategorie.getText());
			this.dispose();
			
		}

	}
}
