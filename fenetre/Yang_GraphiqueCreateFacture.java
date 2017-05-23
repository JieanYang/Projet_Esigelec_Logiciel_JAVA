package fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.ClientDAO;
import DAO.DevisDAO;
import DAO.FactureDB;
import controller.Yang_founction_fenetre;
import models.Client;
import models.Devis;
import models.Facture;

public class Yang_GraphiqueCreateFacture extends JFrame implements ActionListener{
	
	/*1.private for containerPanel*/
	private JPanel containerPanel_1;
	private String title_1 = new String("CreateFacture");
	private JButton CreateFactureByDevis_1;
	private JButton CreateFactureByTypeInfo_1;
	private JButton no_1;
	
	/*2.private for containerpanel--createbyid*/
	
	
	
	
	private JPanel containerPanelCreateByIdy_2;
	private String title_2 = new String(" CreateFactureByDevis");

	private JLabel IdDevis_label_2;
	private JTextField IdDevis_2;
	private JButton CreateConfirm_2;
	private JButton no_2;
	
	
	private JLabel ModePaiyement_label_2;
	private JLabel Num_label_2;
	private JLabel Date_label_2;
	private JTextField ModePaiement_2;
	private JTextField Num_2;
	private JTextField Date_2;
	
	//3.private for CreateFactureByTypeInfo
	private JPanel CreateFactureByTypeInfo_3;
	private String title_3 =new String ("CreateFactureByTypeInfo");
	private Facture f_3;
	
	private JLabel id_D_label_3;
	private JLabel nomdevis_D_label_3;
	private JLabel client_D_label_3;
	private JLabel categorie_D_label_3;
	private JLabel nomclient_D_label_3;
	private JLabel date_D_label_3;
	private JLabel id_F_label_3;
	private JLabel modepaiement_F_label_3;
	private JLabel num_F_label_3;
	private JLabel date_F_label_3;
	
	private JTextField id_D_3;
	private JTextField nomdevis_D_3;
	private JTextField client_D_3;
	private JTextField categorie_D_3;
	private JTextField nomclient_D_3;
	private JTextField date_D_3;
	private JTextField id_F_3;
	private JTextField modepaiement_F_3;
	private JTextField num_F_3;
	private JTextField date_F_3;
	
	private JButton yes_3;
	private JButton no_3;
	
	
	public Yang_GraphiqueCreateFacture(){
		this.setTitle(title_1);
		//this.setTitle(title_2);���޸ı���
		
		this.setSize(500, 630);
		this.setLocationRelativeTo(null);
		
			/*1.containerPanel*/
			containerPanel_1 = new JPanel();
			Yang_founction_fenetre.setBasicStyleForFenetre(containerPanel_1);
			
			
			CreateFactureByDevis_1 = new JButton("Creer une facture par ID Devis");
			CreateFactureByTypeInfo_1 = new JButton("Creer une facture et entrer les infos");
			no_1 = new JButton("return");
			
			CreateFactureByDevis_1.addActionListener(this);
			CreateFactureByTypeInfo_1.addActionListener(this);
			no_1.addActionListener(this);
			
			CreateFactureByDevis_1.setBounds(125, 200, 250, 60);
			CreateFactureByTypeInfo_1.setBounds(125, 300, 250, 60);
			no_1.setBounds(125, 400, 250, 60);
			
			containerPanel_1.add(CreateFactureByDevis_1);
			//
			containerPanel_1.add(CreateFactureByTypeInfo_1);
			containerPanel_1.add(no_1);
			
			//containerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			/*1.containerPanel*/
			
			/*2.cntainerpanel--createbyid*/
			containerPanelCreateByIdy_2 = new JPanel();
			Yang_founction_fenetre.setBasicStyleForFenetre(containerPanelCreateByIdy_2);
			
			
			IdDevis_label_2 = new JLabel("Id of Devis:");
			IdDevis_2 = new JTextField();
			CreateConfirm_2 = new JButton("Create");
			no_2 = new JButton("return");
			
			ModePaiyement_label_2 = new JLabel("le mode de paiement:");
			Num_label_2 = new JLabel("Num:");
			Date_label_2 = new JLabel("Date:");

			ModePaiement_2 = new JTextField();
			Num_2 = new JTextField();
			Date_2 = new JTextField();
			
			CreateConfirm_2.addActionListener(this);
			no_2.addActionListener(this);	
			
			
			IdDevis_label_2.setBounds(20, 10, 150, 30);
			IdDevis_2.setBounds(20, 50, 460, 50);
			ModePaiyement_label_2.setBounds(20, 110, 150, 30);
			ModePaiement_2.setBounds(20, 150, 460, 50);
			Num_label_2.setBounds(20, 210, 150, 30);
			Num_2.setBounds(20, 250, 460, 50);
			Date_label_2.setBounds(20, 310, 150, 30);
			Date_2.setBounds(20, 350, 460, 50);
			
			CreateConfirm_2.setBounds(20, 420, 150, 30);
			no_2.setBounds(180, 420, 150, 30);
			
			containerPanelCreateByIdy_2.add(IdDevis_label_2);
			containerPanelCreateByIdy_2.add(IdDevis_2);
			containerPanelCreateByIdy_2.add(ModePaiyement_label_2);
			containerPanelCreateByIdy_2.add(ModePaiement_2);
			containerPanelCreateByIdy_2.add(Num_label_2);
			containerPanelCreateByIdy_2.add(Num_2);
			containerPanelCreateByIdy_2.add(Date_label_2);
			containerPanelCreateByIdy_2.add(Date_2);
			
			containerPanelCreateByIdy_2.add(CreateConfirm_2);
			containerPanelCreateByIdy_2.add(no_2);
			
			/*2.containerpael--createbyid*/
			
			
			//3.containerpanel -- CreateFactureByTypeInfo
			CreateFactureByTypeInfo_3 =new JPanel();
			Yang_founction_fenetre.setBasicStyleForFenetre(CreateFactureByTypeInfo_3);
			
			
			id_D_label_3 = new JLabel("id de Devis");
			nomdevis_D_label_3 = new JLabel("nomdevis de Devis");
			client_D_label_3 = new JLabel("client de Devis");
			categorie_D_label_3 = new JLabel("categorie de Devis");
			nomclient_D_label_3 = new JLabel("nomClient de Devis");
			date_D_label_3 = new JLabel("date de Devis");
			id_F_label_3 = new JLabel("id de facture");
			modepaiement_F_label_3 = new JLabel("mode de paiement de facture");
			num_F_label_3 = new JLabel("num de facture");
			date_F_label_3 = new JLabel("date de facture");
			
			id_D_3 = new JTextField();
			nomdevis_D_3 = new JTextField();
			client_D_3 = new JTextField();
			categorie_D_3 = new JTextField();
			nomclient_D_3 = new JTextField();
			date_D_3 = new JTextField();
			id_F_3 = new JTextField();
			modepaiement_F_3 = new JTextField();
			num_F_3 = new JTextField();
			date_F_3 = new JTextField();
			
			yes_3 = new JButton("creer");
			no_3 = new JButton("return");
			yes_3.addActionListener(this);
			no_3.addActionListener(this);
			

			id_D_label_3.setBounds(20, 10, 150, 30);
			nomdevis_D_label_3.setBounds(20, 50, 150, 30);
			client_D_label_3.setBounds(20, 90, 150, 30);
			categorie_D_label_3.setBounds(20, 130, 150, 30);
			nomclient_D_label_3.setBounds(20, 170, 150, 30);
			date_D_label_3.setBounds(20, 210, 150, 30);
			
			id_F_label_3.setBounds(20, 250, 150, 30);
			modepaiement_F_label_3.setBounds(20, 290, 200, 30);
			num_F_label_3.setBounds(20, 330, 150, 30);
			date_F_label_3.setBounds(20, 370, 150, 30);

			id_D_3.setBounds(220, 10, 150, 30);
			nomdevis_D_3.setBounds(220, 50, 150, 30);
			client_D_3.setBounds(220, 90, 150, 30);
			categorie_D_3.setBounds(220, 130, 150, 30);
			nomclient_D_3.setBounds(220, 170, 150, 30);
			date_D_3.setBounds(220, 210, 150, 30);
			id_F_3.setBounds(220, 250, 150, 30);
			modepaiement_F_3.setBounds(220, 290, 150, 30);
			num_F_3.setBounds(220, 330, 150, 30);
			date_F_3.setBounds(220, 370, 150, 30);
			
			yes_3.setBounds(20, 430, 150, 30);
			no_3.setBounds(180, 430, 150, 30);

			CreateFactureByTypeInfo_3.add(id_D_label_3);
			CreateFactureByTypeInfo_3.add(nomdevis_D_label_3);
			CreateFactureByTypeInfo_3.add(client_D_label_3);
			CreateFactureByTypeInfo_3.add(categorie_D_label_3);
			CreateFactureByTypeInfo_3.add(nomclient_D_label_3);
			CreateFactureByTypeInfo_3.add(date_D_label_3);
			CreateFactureByTypeInfo_3.add(id_F_label_3);
			CreateFactureByTypeInfo_3.add(modepaiement_F_label_3);
			CreateFactureByTypeInfo_3.add(num_F_label_3);
			CreateFactureByTypeInfo_3.add(date_F_label_3);
			
			CreateFactureByTypeInfo_3.add(id_D_3);
			CreateFactureByTypeInfo_3.add(nomdevis_D_3);
			CreateFactureByTypeInfo_3.add(client_D_3);
			CreateFactureByTypeInfo_3.add(categorie_D_3);
			//CreateFactureByTypeInfo_3.add(nomclient_D_3);
			CreateFactureByTypeInfo_3.add(date_D_3);
			CreateFactureByTypeInfo_3.add(id_F_3);
			CreateFactureByTypeInfo_3.add(modepaiement_F_3);
			CreateFactureByTypeInfo_3.add(num_F_3);
			CreateFactureByTypeInfo_3.add(date_F_3);
			
			CreateFactureByTypeInfo_3.add(yes_3);
			CreateFactureByTypeInfo_3.add(no_3);
			
			//3.containerpanel -- CreateFactureByTypeInfo
			
			
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(containerPanel_1);
		//this.setContentPane(containerPanelCreateByIdy_2);
		//this.setContentPanel(CreateFactureByTypeInfo_3);
		
		this.setVisible(true);
		
	}
	
		/*get container*/
		public JPanel getContainerPanel_1(){
			return containerPanel_1;
		}
		
		public JPanel getcontainerPanel_2(){
			return containerPanelCreateByIdy_2;
		}
		
		public JPanel getContainerPanel_3(){
			return CreateFactureByTypeInfo_3;
		}
		
		/*set container*/
		public void setContentPanel(JPanel c){
			this.setContentPane(c);
			
			
		}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		int retour;
		FactureDB cao_F = new FactureDB();
		DevisDAO cao_D = new DevisDAO();
		ClientDAO cao_C = new ClientDAO();
		Devis d =new Devis();
		//Facture f_old = new Facture();
		Facture f = new Facture();
		
		
	//1.containerPanel
			//click button creer une facture par ID Devis
			if (arg0.getSource() == CreateFactureByDevis_1){
				Yang_GraphiqueCreateFacture a = new Yang_GraphiqueCreateFacture();
				a.setContentPanel(a.getcontainerPanel_2());
				a.setTitle(title_2);
				this.dispose();
			}
		
		
			//click button Creer une facture et entrer les infos
			if (arg0.getSource() == CreateFactureByTypeInfo_1){
				Yang_GraphiqueCreateFacture a = new Yang_GraphiqueCreateFacture();
				a.setContentPanel(a.getContainerPanel_3());
				a.setTitle(title_3);
				this.dispose();
			}
			//Click button return 
			if (arg0.getSource() == no_1){
				Graphique_Yang a = new Graphique_Yang();
				this.dispose();
			}

		
		
	//2.cntainerpanel--createbyid
		//click button creer in page CreateFactureByDevis
			if (arg0.getSource() == CreateConfirm_2){
				retour = 0;
				d = cao_D.getDevis(Integer.parseInt(this.IdDevis_2.getText()));
				f = new Facture(d, d.getId(), this.ModePaiement_2.getText(),Integer.parseInt(this.Num_2.getText()),this.Date_2.getText());
				retour = cao_F.ajouter(f);
				if (retour == 1){
					JOptionPane.showMessageDialog(this, "Facture update !");
				}else{
					JOptionPane.showMessageDialog(this, "erreur update Facture", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			} 
		
		//click button return in page CreateFactureByDevis
		if (arg0.getSource() == no_2){
			Yang_GraphiqueCreateFacture a = new Yang_GraphiqueCreateFacture();
			this.dispose();
		} 
	
		
	//3.containerpanel -- CreateFactureByTypeInfo
			//yes
			if (arg0.getSource() == yes_3){
				retour = 0;
				Client client = ClientDAO.getClient(Integer.parseInt(this.client_D_3.getText()));
				d = new Devis(Integer.parseInt(this.id_D_3.getText()),this.nomdevis_D_3.getText(),client,this.categorie_D_3.getText(),this.date_D_3.getText());
				
			} 
			//return
			if (arg0.getSource() == no_3){
				Yang_GraphiqueCreateFacture a = new Yang_GraphiqueCreateFacture();
				a.setContentPanel(a.getContainerPanel_1());
				a.setTitle(title_1);
				this.dispose();
			}
	
	}

}
