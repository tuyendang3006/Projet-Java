package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Page_Recherche extends JFrame{
	Titre_Panneau tPanel;
	Principal_Panneau pPanel;
	public Page_Recherche() {
		setTitle("Recherche");
		setBounds(400,0,600,400);
		setResizable(false);
		tPanel=new Titre_Panneau();
		pPanel=new Principal_Panneau();
		add(tPanel,"North");
		add(pPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
//	public static void main(String[] args) {
//		new Page_Recherche();
//
//	}
	public class Titre_Panneau extends JPanel{
		public Titre_Panneau() {
			this.setBackground(Color.GREEN);
			JLabel t=new JLabel("Un logement, bonne recherche!");
			t.setFont(new Font("Time New Roman",Font.CENTER_BASELINE,24));
			add(t);
		
		}
	}
	public class Principal_Panneau extends JPanel implements ActionListener  {
		JPanel p,namePanel,inputPanel;
		JButton rechercher;
		public Principal_Panneau() {
			p=new JPanel(new BorderLayout(10,10));
			p.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
			add(p,BorderLayout.CENTER);
			
			namePanel=new JPanel(new GridLayout(2,1,15,15));
			JLabel nomVille=new JLabel("Ville ou Code postal :");
			nomVille.setFont(new Font("Time New Roman", Font.CENTER_BASELINE,15));
			JLabel type=new JLabel("Type de logement :");
			type.setFont(new Font("Time New Roman", Font.CENTER_BASELINE,15));
			namePanel.add(nomVille);
			namePanel.add(type);
			p.add(namePanel,BorderLayout.WEST);
			
			inputPanel=new JPanel(new GridLayout(2,1,15,15));
			inputPanel.add(new JTextField(20));
			String option[]= {"Tous les types","Appartement T1","Appartement T2","Appartement T3","Appartement T4","Maison F1","Maison F2","Maison F3","Maison F4","Chambre","Studio"};
			JComboBox cb=new JComboBox(option);
			inputPanel.add(cb);
			p.add(inputPanel,BorderLayout.CENTER);
			
			rechercher=new JButton("Rechercher");
			rechercher.setForeground(Color.white);
			rechercher.setBackground(Color.decode("#dc4c18"));
			rechercher.setFont(new Font("Time New Roman", Font.CENTER_BASELINE,16));
			rechercher.setFocusable(false);
			rechercher.addActionListener(this);
			add(rechercher,BorderLayout.SOUTH);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("Rechercher")) {
				dispose();
				new Page_Resultat();
			}
		}
	}

}

