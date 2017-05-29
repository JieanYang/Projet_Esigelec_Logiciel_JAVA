package fenetre;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.ClientDAO;
import DAO.DevisDAO;
import DAO.FactureDB;
import controller.Yang_founction_fenetre;
import models.Client;
import models.Devis;
import models.Facture;

public class Graphique_cloturedossier extends JFrame implements ActionListener{

	// containerPanel 1
	private JPanel demand_id_F_container1;
	private JLabel demand_FAC_label;
	private JTextField demand_FAC_ID_textfield;
	private JButton confirm;
	private JButton no_1;
	
	//containerPanel 2
	private JPanel cloture_container2;
	
	private JLabel CLT_ID, CLT_NOM, CLT_SIRET, CLT_CODEAPE,CLT_ADRESSE;
	
	private JLabel FAC_ID, FAC_MODEPAIEMENT,FAC_NUM, FAC_DATE;
	
	private JLabel DVI_ID, DEVI_NOM, DVI_CATEGORIE, DVI_DATE;
		
	private JButton cloture;
	
	private JButton no_2;

	private ClientDAO clientDAO;
	private DevisDAO devisDAO;
	private FactureDB factureDAO;
	
	public Graphique_cloturedossier(int i){
		
		
		
		this.clientDAO = new ClientDAO();
		this.devisDAO = new DevisDAO();
		this.factureDAO = new FactureDB();
		
		this.setSize(500, 630);
		this.setLocationRelativeTo(null);
		

		// choix de la couleur pour le conteneur
		this.setBackground(Color.lightGray);
		// instantiation des composants graphiques

		if(i == 1){
			demand_id_F_container1 = new JPanel();
			Yang_founction_fenetre.setBasicStyleForFenetre(demand_id_F_container1);
			
			demand_FAC_label = new JLabel("id of facture:");
			demand_FAC_ID_textfield = new JTextField();
			confirm = new JButton("confirm");
			no_1 = new JButton("return");
			confirm.addActionListener(this);
			no_1.addActionListener(this);
			
			
			demand_FAC_label.setBounds(20, 100, 150, 30);
			demand_FAC_ID_textfield.setBounds(120, 100, 150, 30);
			confirm.setBounds(20, 150, 150, 30);
			no_1.setBounds(180, 150, 150, 30);
			
			demand_id_F_container1.add(demand_FAC_label);
			demand_id_F_container1.add(demand_FAC_ID_textfield);
			demand_id_F_container1.add(confirm);
			demand_id_F_container1.add(no_1);
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setContentPane(demand_id_F_container1);
			
		}
		
		if(i == 2){
			cloture_container2 = new JPanel();
			Yang_founction_fenetre.setBasicStyleForFenetre(cloture_container2);
			
			
			CLT_ID = new JLabel("id of client");
			CLT_NOM = new JLabel("nom client");
			CLT_SIRET = new JLabel("siret of client");
			CLT_CODEAPE = new JLabel("codeape");
			CLT_ADRESSE = new JLabel("adress");
			
			FAC_ID = new JLabel("id of facture");
			FAC_MODEPAIEMENT = new JLabel("modepaiement");
			FAC_NUM = new JLabel("num de facture");
			FAC_DATE = new JLabel("date de facture");
			
			DVI_ID = new JLabel("id of devis ");
			DEVI_NOM = new JLabel("nom of devis");
			DVI_CATEGORIE = new JLabel("categorie of debis ");
			DVI_DATE = new JLabel("date of devis");
			
			cloture = new JButton("cloture");
			no_2 = new JButton("reutrn");
			cloture.addActionListener(this);
			no_2.addActionListener(this);
			
			
			CLT_ID.setBounds(20, 10, 150, 30);
			CLT_NOM.setBounds(20, 50, 150, 30);
			CLT_SIRET.setBounds(20, 90, 150, 30);
			CLT_CODEAPE.setBounds(20, 130, 150, 30);
			CLT_ADRESSE.setBounds(20, 170, 150, 30);
			FAC_ID.setBounds(20, 210, 150, 30);
			FAC_MODEPAIEMENT.setBounds(20, 250, 150, 30);
			FAC_NUM.setBounds(20, 290, 200, 30);
			FAC_DATE.setBounds(20, 330, 150, 30);
			
			DVI_ID.setBounds(20, 370, 150, 30);
			DEVI_NOM.setBounds(20, 410, 150, 30);
			DVI_CATEGORIE.setBounds(20, 440, 150, 30);
			DVI_DATE.setBounds(20, 480, 150, 30);


			
			cloture.setBounds(20, 550, 150, 30);
			no_2.setBounds(180, 550, 150, 30);
			
			
			cloture_container2.add(CLT_ID);
			cloture_container2.add(CLT_NOM);
			cloture_container2.add(CLT_SIRET);
			cloture_container2.add(CLT_CODEAPE);
			cloture_container2.add(CLT_ADRESSE);
			cloture_container2.add(FAC_ID);
			cloture_container2.add(FAC_MODEPAIEMENT);
			cloture_container2.add(FAC_NUM);
			cloture_container2.add(FAC_DATE);
			cloture_container2.add(DVI_ID);
			cloture_container2.add(DEVI_NOM);
			cloture_container2.add(DVI_CATEGORIE);
			cloture_container2.add(DVI_DATE);
			cloture_container2.add(cloture);
			cloture_container2.add(no_2);
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setContentPane(cloture_container2);
		}

		this.setVisible(true);

	

	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int id_f;
		int id_d;
		int id_c;
		Facture f;
		Devis d;
		Client c;
		if(arg0.getSource() == confirm){
			Graphique_cloturedossier a = new Graphique_cloturedossier(2);
			this.dispose();
		}
		
		if(arg0.getSource() == no_1){
			this.dispose();
			
		}
		
		if(arg0.getSource() == cloture){
			this.dispose();
			
		}
		
		if(arg0.getSource() == no_2){
			Graphique_cloturedossier a = new Graphique_cloturedossier(1);
			this.dispose();
		}
	}
	
	

}
