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
import DAO.FichemaintenanceDAO;
import DAO.OperateurDAO;
import models.Client;
import models.Fichemaintenance;

	public class Graphique_affecteroperateur extends JPanel implements ActionListener {
		private Graphique mainApp;
		
		/**
		 * bouton d'affectation d'un operateur
		 */
		private JButton affecteroperateur;
		/**
		 * bouton de retour au menu
		 */
		private JButton retour;
		/**
		 * zone de texte pour le champ id fiche de maintenance
		 */
		private JTextField textFieldmaintenance;

		/**
		 * zone de texte pour le champ operateur
		 */
		private JTextField textFieldoperateur;


		private JLabel labelmaintenance;
		private JLabel labeloperateur;

		private OperateurDAO OperateurDAO;
		private FichemaintenanceDAO fichemaintenceDAO;

		/**
		 * Constructeur Définit la fenêtre et ses composants - affiche la fenêtre
		 */
		public Graphique_affecteroperateur(Graphique main) {
			this.mainApp = main;
			
			// on instancie la classe Client DAO
			this.OperateurDAO = new OperateurDAO();
			this.fichemaintenceDAO = new FichemaintenanceDAO();

			
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

			affecteroperateur = new JButton("affecter un operateur");
			affecteroperateur.addActionListener(this);

			retour = new JButton("retour");
			retour.addActionListener(this);

			textFieldmaintenance = new JTextField();
			textFieldoperateur = new JTextField();
	

			labelmaintenance = new JLabel("mettre la maintenance ou va etre affecter l'operateur :");
			labeloperateur = new JLabel("mettre l'operateur de l'affectation:");
			
			
			this.add(labelmaintenance);
			this.add(textFieldmaintenance);
			
			this.add(labeloperateur);
			this.add(textFieldoperateur);
			
			this.add(affecteroperateur);
			this.add(retour);
		}

		public void actionPerformed(ActionEvent ae) {
			Fichemaintenance retour1;
			if (ae.getSource() == affecteroperateur) {
				try {
					retour1 = FichemaintenanceDAO.affecteroperateur(Integer.parseInt(this.textFieldmaintenance.getText()),
							Integer.parseInt(this.textFieldoperateur.getText()));
					// affichage du nombre de lignes modifie
					// dans la bdd pour vérification
					System.out.println("" + retour + " ligne ajoutée ");
					if (retour1 != null)
						JOptionPane.showMessageDialog(this, "operateur affecter !");
					else
						JOptionPane.showMessageDialog(this, "erreur affectation operateur", "Erreur", JOptionPane.ERROR_MESSAGE);
				
				
			}
				catch(Exception ee){
					ee.printStackTrace();
					}
				}
				
			if (ae.getSource() == retour) {
				this.mainApp.switchPanel();
		

			}

		}

	}
