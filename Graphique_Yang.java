import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Graphique_Yang extends JFrame implements ActionListener {

	private JPanel containerPanel;/* container */

	/*
	 * 1.creer une facture(bouton) 2.afficher la facture(bouton)
	 * 3.modePaiyement( la boite d'entree ) 4.num( la boite d'entree ) 5.date(
	 * la boite d'entree ) ajouter dans la facture
	 */
	private JButton CreerFacture;
	private JButton AffichageFacture;

	private JLabel ModePaiyement_label;
	private JLabel Num_label;
	private JLabel Date_label;
	private JTextField ModePaiyement;
	private JTextField Num;
	private JTextField Date;

	private JButton Yes;
	private JButton No;

	/*
	 * constructeur definit lq fenetre est ajouter ses composants, affiche la
	 * fenetre
	 */

	public Graphique_Yang() {
		this.setTitle("le suivi de reglement");

		this.setSize(400, 600);

		containerPanel = new JPanel();

		containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.PAGE_AXIS));

		containerPanel.setBackground(Color.lightGray);

		CreerFacture = new JButton("Creer une facture");
		AffichageFacture = new JButton("Afficher la facture");

		ModePaiyement_label = new JLabel("le mode de paieent:");
		Num_label = new JLabel("Num:");
		Date_label = new JLabel("Date:");

		ModePaiyement = new JTextField();
		Num = new JTextField();
		Date = new JTextField();

		Yes = new JButton("Yes");
		No = new JButton("return");
		No.addActionListener(this);

		containerPanel.add(CreerFacture);
		containerPanel.add(AffichageFacture);
		containerPanel.add(ModePaiyement_label);
		containerPanel.add(ModePaiyement);
		containerPanel.add(Num_label);
		containerPanel.add(Num);
		containerPanel.add(Date_label);
		containerPanel.add(Date);
		containerPanel.add(Yes);
		containerPanel.add(No);

		containerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(containerPanel);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == No) {
			this.dispose();
		}

	}

}
