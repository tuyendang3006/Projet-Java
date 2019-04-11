package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import IHM.Page_CreationCompte.Compte_Panneau;
import IHM.Page_CreationCompte.Infos_Panneau;
import IHM.Page_Resultat.Dessus_Panneau;
import IHM.Page_Resultat.Principal_Panneau;
import IHM.Page_Resultat.Titre_Panneau;

public class Page_Publication extends JFrame{
	Titre_Panneau tPanel;
	Dessus_Panneau dPanel;
	Principal_Panneau pPanel;
	public Page_Publication() {
		setTitle("Recherche");
		setBounds(400,0,600,800);
		setResizable(false);
		tPanel=new Titre_Panneau();
		dPanel=new Dessus_Panneau();
		pPanel=new Principal_Panneau();
		
		JPanel panel=new JPanel(new GridLayout(2,1,0,0));
		panel.add(tPanel);
		panel.add(dPanel);
		add(panel,BorderLayout.NORTH);
		add(pPanel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public Page_Publication(int idPro) {
		// TODO Auto-generated constructor stubthis.idPro=idPro;
		setTitle("Recherche");
		setBounds(400,0,600,800);
		setResizable(false);
		tPanel=new Titre_Panneau();
		dPanel=new Dessus_Panneau();
		pPanel=new Principal_Panneau();
		
		JPanel panel=new JPanel(new GridLayout(2,1,0,0));
		panel.add(tPanel);
		panel.add(dPanel);
		add(panel,BorderLayout.NORTH);
		add(pPanel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	public static void main(String []args) {
		new Page_Publication();
	}
	
	public class Titre_Panneau extends JPanel{
		public Titre_Panneau() {
			this.setBackground(Color.GREEN);
			JLabel t=new JLabel("Un logement, bonne recherche!");
			t.setFont(new Font("Time New Roman",Font.CENTER_BASELINE,24));
			add(t);
		}
	}
	
    public class Dessus_Panneau extends JPanel implements ActionListener{	
		public Dessus_Panneau() {		
			FlowLayout layout=new FlowLayout();
			layout.setHgap(60);
			layout.setVgap(10);
			setLayout(layout);		

			ImageIcon returnIcon=new ImageIcon("return.png");
			JLabel retourner=new JLabel("Retourener");
			retourner.setFont(new Font("Time New Roman", Font.CENTER_BASELINE,14));
			retourner.setIcon(returnIcon);
			add(retourner,FlowLayout.LEFT);
			
			ImageIcon compteIcon=new ImageIcon("compte.png");
			JLabel compte=new JLabel("Compte");
			compte.setFont(new Font("Time New Roman", Font.CENTER_BASELINE,14));
			compte.setIcon(compteIcon);
			add(compte);
			
			JButton deconnecter=new JButton("Deconnexion");
			add(deconnecter);
			deconnecter.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(e.getActionCommand().equals("Deconnexion")) {
						dispose();
						new Page_Connexion();
					}
				}
				
			});		
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		}
	}
    
    public class Principal_Panneau extends JPanel implements ActionListener{

    	JPanel p,namePanel,inputPanel, extraPanel;
		JButton retourner, publier;
		JTextArea texte;
		
		public Principal_Panneau() {
			JLabel title=new JLabel("Votre Publication",JLabel.CENTER);
			title.setFont(new Font("Time New Roman",Font.CENTER_BASELINE,20));
			title.setForeground(Color.blue);
			add(title,BorderLayout.NORTH);
			
			p=new JPanel(new BorderLayout(10,10));
			p.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
			add(p,BorderLayout.CENTER);
					
			namePanel=new JPanel(new GridLayout(8,1,15,15));
			String array[]= {"Titre de publication","Type de logement","Adresse","Ville","Code Postal","Surface","Prix","Description" };
			for(int i=0;i<array.length;i++) {
				JLabel l=new JLabel(array[i]);
				l.setFont(new Font("Time New Roman",Font.CENTER_BASELINE,15));
				namePanel.add(l);
			}		
			p.add(namePanel,BorderLayout.WEST);
			
			inputPanel=new JPanel(new GridLayout(8,1,15,15));
			inputPanel.add(new JTextField(20));
			String option[]= {"Tous les types","Appartement T1","Appartement T2","Appartement T3","Appartement T4","Maison F1","Maison F2","Maison F3","Maison F4","Chambre","Studio"};
			JComboBox cb=new JComboBox(option);
			inputPanel.add(cb);
			
			JTextField adresse=new JTextField(20);
			JTextField ville=new JTextField(20);
			JTextField codePostal=new JTextField(20);
			JTextField surface=new JTextField(20);
			JTextField prix=new JTextField(20);
			
			inputPanel.add(adresse);
			inputPanel.add(ville);
			inputPanel.add(codePostal);
			inputPanel.add(surface);
			inputPanel.add(prix);
			p.add(inputPanel,BorderLayout.CENTER);
			
			extraPanel=new JPanel(new GridLayout(8,1,15,15));
			String extra[]= {"","","","","","m2","€/Mois",""};
			for(int j=0;j<extra.length;j++) {
				JLabel lExtra=new JLabel(extra[j]);
				lExtra.setFont(new Font("Time New Roman",Font.CENTER_BASELINE,15));
				extraPanel.add(lExtra);
			}
			p.add(extraPanel,BorderLayout.EAST);

			texte=new JTextArea(5,10);
			JScrollPane sp=new JScrollPane(texte);
			p.add(sp,BorderLayout.SOUTH);
			
			JButton creerBt=new JButton("Publier");
			creerBt.setFocusable(false);
			creerBt.setBackground(Color.blue);
			creerBt.setForeground(Color.white);
			creerBt.setFont(new Font("Time New Roman",Font.CENTER_BASELINE,16));
			add(creerBt,BorderLayout.SOUTH);
			
		}
    	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
    	
    }
}
