package fenetre;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.Yang_FactureDB;
import models.Facture;

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
	private JTextField ModePaiement;
	private JTextField Num;
	private JTextField Date;
	private JLabel id_F_label;
	private JTextField id_F;
	
	private JButton Yes;
	private JButton No;

	/*
	 * constructeur definit lq fenetre est ajouter ses composants, affiche la
	 * fenetre
	 */

	public Graphique_Yang() {
		this.setTitle("le suivi de reglement");

		this.setSize(500, 630);
		this.setLocationRelativeTo(null);

		containerPanel = new JPanel();
		
		containerPanel.setLayout(null);

		containerPanel.setBackground(Color.lightGray);

		CreerFacture = new JButton("Creer une facture");
		AffichageFacture = new JButton("Afficher la facture");

		ModePaiyement_label = new JLabel("le mode de paiement:");
		Num_label = new JLabel("Num:");
		Date_label = new JLabel("Date:");

		ModePaiement = new JTextField();
		Num = new JTextField();
		Date = new JTextField();
		
		id_F_label = new JLabel("id of facture:");
		id_F = new JTextField();

		Yes = new JButton("Yes");
		No = new JButton("return");
		
		CreerFacture.addActionListener(this);
		AffichageFacture.addActionListener(this);
		Yes.addActionListener(this);
		No.addActionListener(this);

		
		CreerFacture.setBounds(20, 10, 150, 30);
		AffichageFacture.setBounds(20, 50, 150, 30);
		id_F_label.setBounds(20, 90, 150, 30);
		id_F.setBounds(20, 130, 460, 50);
		ModePaiyement_label.setBounds(20, 190, 150, 30);
		ModePaiement.setBounds(20, 230, 460, 50);
		Num_label.setBounds(20, 290, 150, 30);
		Num.setBounds(20, 330, 460, 50);
		Date_label.setBounds(20, 390, 150, 30);
		Date.setBounds(20, 430, 460, 50);
		
		Yes.setBounds(20, 500, 150, 30);
		No.setBounds(180, 500, 150, 30);	
		
		
		
		containerPanel.add(CreerFacture);
		containerPanel.add(AffichageFacture);
		containerPanel.add(ModePaiyement_label);
		containerPanel.add(ModePaiement);
		containerPanel.add(Num_label);
		containerPanel.add(Num);
		containerPanel.add(Date_label);
		containerPanel.add(Date);
		containerPanel.add(id_F_label);
		containerPanel.add(id_F);
		
		containerPanel.add(Yes);
		containerPanel.add(No);

		containerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(containerPanel);
		 
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		int retour;
		Yang_FactureDB cao_F = new Yang_FactureDB();
		Facture f_old = new Facture();
		Facture f = new Facture();// sans doute marche pas pour new
		
		if (ae.getSource() == Yes) {
			
			retour=0;
			/*
			cao = new Yang_FactureDB();
			f_old = new Facture();
			f = new Facture();
			*/
			f_old = cao_F.getFacture(Integer.parseInt(this.id_F.getText()));
			f = f_old;
			f.setModepaiement_Facture(this.ModePaiement.getText());
			f.setNum_Facture(Integer.parseInt(this.Num.getText()));
			f.setDate_Facture(this.Date.getText());
			
			cao_F.suppr(f_old);
			retour = cao_F.ajouter(f);
			if (retour == 1){
				JOptionPane.showMessageDialog(this, "Facture update !");
			}else{
				cao_F.ajouter(f_old);
				JOptionPane.showMessageDialog(this, "erreur update Facture", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (ae.getSource() == No) {
			Graphique ap = new Graphique();
			this.dispose();
		}
		
		if (ae.getSource() == CreerFacture) {
			Yang_GraphiqueCreateFacture a = new Yang_GraphiqueCreateFacture();
			this.dispose();
		}
		
		if (ae.getSource() == AffichageFacture) {
			Yang_GraphiqueAfficherFacture a = new Yang_GraphiqueAfficherFacture();
			this.dispose();
		}

	}

}
