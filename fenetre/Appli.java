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

import models.Client;

public class Appli extends JFrame implements ActionListener {

	private JPanel containerPanel_Authentifier;

	private JLabel compte_label_authentifier;
	private JLabel passeword_label_authentifier;
	private JTextField compte_authentifier;
	private JTextField passeword_authentifier;

	private JButton yes_authentifier;
	private JButton no_authentifier;

	public Appli() {
		this.setTitle("Authentifier");

		this.setSize(500, 630);
		this.setLocationRelativeTo(null);

		containerPanel_Authentifier = new JPanel();

		containerPanel_Authentifier.setLayout(null);
		containerPanel_Authentifier.setBackground(Color.lightGray);

		compte_label_authentifier = new JLabel("compte:");
		passeword_label_authentifier = new JLabel("passeword:");
		compte_authentifier = new JTextField();
		passeword_authentifier = new JTextField();

		yes_authentifier = new JButton("yes");
		no_authentifier = new JButton("no");
		yes_authentifier.addActionListener(this);
		no_authentifier.addActionListener(this);

		compte_label_authentifier.setBounds(20, 90, 150, 30);
		compte_authentifier.setBounds(20, 130, 460, 50);
		passeword_label_authentifier.setBounds(20, 190, 150, 30);
		passeword_authentifier.setBounds(20, 230, 460, 50);

		yes_authentifier.setBounds(20, 300, 150, 30);
		no_authentifier.setBounds(180, 300, 150, 30);

		containerPanel_Authentifier.add(compte_label_authentifier);
		containerPanel_Authentifier.add(compte_authentifier);
		containerPanel_Authentifier.add(passeword_label_authentifier);
		containerPanel_Authentifier.add(passeword_authentifier);
		containerPanel_Authentifier.add(yes_authentifier);
		containerPanel_Authentifier.add(no_authentifier);

		containerPanel_Authentifier.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(containerPanel_Authentifier);

		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
		int retour1;
		if (ae.getSource() == yes_authentifier) {
			Graphique ap = new Graphique();
			this.dispose();


		}
		if (ae.getSource() == no_authentifier) {
			this.dispose();

		}
		
	}

}
