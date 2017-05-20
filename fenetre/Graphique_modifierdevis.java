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
		private JTextField textField1;
		private JTextField textField2;
		private JTextField textField3;

		private JLabel labelnom;

		private JLabel labeldate;

		private JLabel labelcategorie;
		private JLabel label1;
		private JLabel label2;
		private JLabel label3;
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

			textFielddate = new JTextField();
			textFieldnom = new JTextField();
			textField1 = new JTextField();
			textField2 = new JTextField();
			textField3 = new JTextField();
			textFieldcategorie = new JTextField();

			labeldate = new JLabel("date :");
			labelnom = new JLabel("nom:");
			labelcategorie = new JLabel("categorie :");
			label1 = new JLabel("categorie1 :");
			label2 = new JLabel("categorie 2:");
			label3 = new JLabel("categorie 3:");
			
			// ajout des composants sur le container
			// introduire une espace constant entre le champ texte et le composant
			// suivant
			labelnom.setBounds(20, 10, 150, 30);
			textFieldnom.setBounds(20, 20, 460, 50);
			label1.setBounds(20, 500, 150, 30);
			textField1.setBounds(20, 550, 460, 50);
			label2.setBounds(20, 600, 150, 30);
			textField2.setBounds(20, 650, 460, 50);
			label3.setBounds(20, 750, 150, 30);
			textField3.setBounds(20, 800, 460, 50);
			labeldate.setBounds(20, 110, 150, 30);
			textFielddate.setBounds(20, 150, 460, 50);
			labelcategorie.setBounds(20, 210, 150, 30);
			textFieldcategorie.setBounds(20, 250, 460, 50);
			modifierdevis.setBounds(20, 330, 150, 30);
			retour.setBounds(180, 330, 150, 30);
			
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
