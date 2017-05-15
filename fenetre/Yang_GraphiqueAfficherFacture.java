package fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Yang_founction_fenetre;
import models.Facture;

public class Yang_GraphiqueAfficherFacture extends JFrame implements ActionListener{
	
	//1.private for demand Id Facture
	private JPanel containerDemandIdFacture_1;
	private String title_1 = new String("DemandFacture");
	private JLabel IdFacture_label_1;
	private JTextField IdFacture_1;
	private JButton yes_1;
	private JButton no_1;
	
	//2.private for display the Facture
	private JPanel containerAffiFacutre_2;
	private String title_2 = new String("DisplayFacture");
	private Facture F_2;
	
	
	private JLabel id_D_label_2;
	private JLabel nomdevis_D_label_2;
	private JLabel client_D_label_2;
	private JLabel categorie_D_label_2;
	private JLabel nomclient_D_label_2;
	private JLabel date_D_label_2;
	private JLabel id_F_label_2;
	private JLabel modepaiement_F_label_2;
	private JLabel num_F_label_2;
	private JLabel date_F_label_2;
	
	//private JButton yes_2;
	private JButton no_2;
	
	
	public Yang_GraphiqueAfficherFacture() {
		this.setTitle(title_1);
		
		
		this.setSize(500, 630);
		this.setLocationRelativeTo(null);
		
			//1.private for demand Id Facture
			containerDemandIdFacture_1 = new JPanel();
			Yang_founction_fenetre.setBasicStyleForFenetre(containerDemandIdFacture_1);
			
			
			IdFacture_label_1 = new JLabel("Id of Facture:");
			IdFacture_1 = new JTextField();
			yes_1 = new JButton("yes");
			no_1 = new JButton("return");
			
			yes_1.addActionListener(this);
			no_1.addActionListener(this);
			
			IdFacture_label_1.setBounds(20, 100, 150, 30);
			IdFacture_1.setBounds(120, 100, 150, 30);
			yes_1.setBounds(20, 150, 150, 30);
			no_1.setBounds(180, 150, 150, 30);
			
			containerDemandIdFacture_1.add(IdFacture_label_1);
			containerDemandIdFacture_1.add(IdFacture_1);
			containerDemandIdFacture_1.add(yes_1);
			containerDemandIdFacture_1.add(no_1);
			
			
			
			//2.private for display the Facture
			containerAffiFacutre_2 =new JPanel();
			Yang_founction_fenetre.setBasicStyleForFenetre(containerAffiFacutre_2);
			
			
			id_D_label_2 = new JLabel("id de Devis");
			nomdevis_D_label_2 = new JLabel("nomdevis de Devis");
			client_D_label_2 = new JLabel("client de Devis");
			categorie_D_label_2 = new JLabel("categorie de Devis");
			nomclient_D_label_2 = new JLabel("nomClient de Devis");
			date_D_label_2 = new JLabel("date de Devis");
			id_F_label_2 = new JLabel("id de facture");
			modepaiement_F_label_2 = new JLabel("mode de paiement de facture");
			num_F_label_2 = new JLabel("num de facture");
			date_F_label_2 = new JLabel("date de facture");
			
			//yes_2 = new JButton("creer");
			no_2 = new JButton("return");
			//yes_2.addActionListener(this);
			no_2.addActionListener(this);
			
			
			id_D_label_2.setBounds(20, 10, 150, 30);
			nomdevis_D_label_2.setBounds(20, 50, 150, 30);
			client_D_label_2.setBounds(20, 90, 150, 30);
			categorie_D_label_2.setBounds(20, 130, 150, 30);
			nomclient_D_label_2.setBounds(20, 170, 150, 30);
			date_D_label_2.setBounds(20, 210, 150, 30);
			id_F_label_2.setBounds(20, 250, 150, 30);
			modepaiement_F_label_2.setBounds(20, 290, 200, 30);
			num_F_label_2.setBounds(20, 330, 150, 30);
			date_F_label_2.setBounds(20, 370, 150, 30);
			
			
			no_2.setBounds(300, 430, 150, 30);
			
			containerAffiFacutre_2.add(id_D_label_2);
			containerAffiFacutre_2.add(nomdevis_D_label_2);
			containerAffiFacutre_2.add(client_D_label_2);
			containerAffiFacutre_2.add(categorie_D_label_2);
			containerAffiFacutre_2.add(nomclient_D_label_2);
			containerAffiFacutre_2.add(date_D_label_2);
			containerAffiFacutre_2.add(id_F_label_2);
			containerAffiFacutre_2.add(modepaiement_F_label_2);
			containerAffiFacutre_2.add(num_F_label_2);
			containerAffiFacutre_2.add(date_F_label_2);
	
			//containerAffiFacutre_2.add(yes_2);
			containerAffiFacutre_2.add(no_2);
	
	
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setContentPane(containerDemandIdFacture_1);
			
			this.setVisible(true);
	
	}

	//set label in container_2
	public void setId_D_Label_2(String l){
		this.id_D_label_2.setText(l);
	}
	public void setNomdevis_D_label_2(String l){
		this.nomdevis_D_label_2.setText(l);
	}public void setClient_D_label_2(String l){
		this.client_D_label_2.setText(l);
	}public void setCategorie_D_label_2(String l){
		this.categorie_D_label_2.setText(l);
	}public void setNomclient_D_label_2(String l){
		this.nomclient_D_label_2.setText(l);
	}public void setDate_D_label_2(String l){
		this.date_D_label_2.setText(l);
	}public void setId_F_label_2(String l){
		this.id_F_label_2.setText(l);
	}public void setModepaiement_F_label_2(String l){
		this.modepaiement_F_label_2.setText(l);
	}public void setNum_F_label_2(String l){
		this.num_F_label_2.setText(l);
	}public void setDate_F_label_2(String l){
		this.date_F_label_2.setText(l);
	}
		
		
	//get contaienr
	public JPanel getContainerPanel_1(){
		return containerDemandIdFacture_1;
	}
	
	public JPanel getcontainerPanel_2(){
		return containerAffiFacutre_2;
	}
	
	//set container
	public void setContentPanel(JPanel c){
		this.setContentPane(c);
			
	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
	//1.demand id of facture
		//button yes_1
		if (arg0.getSource() == yes_1){
			//il must verify the existance of facture
			Yang_GraphiqueAfficherFacture a = new Yang_GraphiqueAfficherFacture();
			a.setContentPane(a.getcontainerPanel_2());
			a.setTitle(title_2);
			this.dispose();
		}
		
		//button no_1
		if (arg0.getSource() == no_1){
			Graphique_Yang a = new Graphique_Yang();
			this.dispose();
		}
		
	
	//2.display facture	
		
		if (arg0.getSource() == no_2){
			Yang_GraphiqueAfficherFacture a = new Yang_GraphiqueAfficherFacture();
			this.dispose();
		}
	
	}
	
	
	
	
	
}
