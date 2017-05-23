package fenetre;
	import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JButton;
	import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
	import javax.swing.JTextField;

	import DAO.ClientDAO;
import DAO.OperateurDAO;
import DAO.DevisDAO;
import models.Client;

	public class Graphique_modifierdevis extends JPanel implements ActionListener {
		private Graphique mainApp;
		
		/**
		 * bouton de selection
		 */
		private JButton modifierdevis;

		private JButton retour;
		/**
		 * zone de texte pour le devis a modifier
		 */
		private JTextField textFieldid;
		private JLabel labelid;

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
			

			// on fixe le titre de la fenêtre
			this.setName("validation");
			

			// choix du Layout pour ce conteneur
			// il permet de gérer la position des éléments
			// il autorisera un retaillage de la fenêtre en conservant la
			// présentation
			// BoxLayout permet par exemple de positionner les élements sur une
			// colonne ( PAGE_AXIS )
			this.setLayout(new GridLayout(8,1));

			// choix de la couleur pour le conteneur
			this.setBackground(Color.lightGray);

			// instantiation des composants graphiques

			modifierdevis = new JButton("modifier devis");
			modifierdevis.addActionListener(this);

			retour = new JButton("retour");
			retour.addActionListener(this);

			textFieldid = new JTextField();
			
			
			
			this.add(retour);
		}

		public void actionPerformed(ActionEvent ae) {
			int retour1;
			if (ae.getSource() == modifierdevis) {
				
			}
			if (ae.getSource() == retour) {
				this.mainApp.switchPanel();
		

			}

		}

	}
