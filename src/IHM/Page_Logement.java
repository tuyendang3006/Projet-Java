package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.io.Console;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import IHM.Page_Publication.Dessus_Panneau;
import IHM.Page_Publication.Principal_Panneau;
import IHM.Page_Publication.Titre_Panneau;

public class Page_Logement extends JFrame{
	Titre_Panneau tPanel;
	Dessus_Panneau dPanel;
	Principal_Panneau pPanel;
	public Page_Logement() {
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
		new Page_Logement();
	}
	
	public class Titre_Panneau extends JPanel{
		public Titre_Panneau() {
			this.setBackground(Color.GREEN);
			JLabel t=new JLabel("Un logement, bonne recherche!");
			t.setFont(new Font("Time New Roman",Font.CENTER_BASELINE,24));
			add(t);
		}
	}
	public class Dessus_Panneau extends JPanel{
		
		public Dessus_Panneau() {
			FlowLayout layout=new FlowLayout();
			layout.setHgap(60);
			layout.setVgap(10);
			setLayout(layout);
			
			ImageIcon returnIcon=new ImageIcon("return.png");
			JLabel retourner=new JLabel("Retouner");
			retourner.setFont(new Font("Time New Roman", Font.CENTER_BASELINE,14));
			retourner.setIcon(returnIcon);
			add(retourner,FlowLayout.LEFT);
						
			ImageIcon searchIcon=new ImageIcon("search.png");
			JLabel recherche=new JLabel("Nouvelle recherche");
			recherche.setFont(new Font("Time New Roman", Font.CENTER_BASELINE,14));
			recherche.setIcon(searchIcon);
			add(recherche);
			
		}
	}
	
	public class Principal_Panneau extends JPanel{
		JPanel p;
		North_Panneau nPanel;
		Center_Panneau cPanel;
		South_Panneau sPanel;
		
		public Principal_Panneau() {
			this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			add(nPanel);
			add(cPanel);
			add(sPanel);
		}
		
		public class North_Panneau extends JPanel {
			public North_Panneau() {
				p=new JPanel(new BorderLayout(500,100));
				JLabel name1Panel=new JLabel("Appartement");
				p.add(name1Panel,BorderLayout.WEST);
			}
		}
		
		public class Center_Panneau extends JPanel{
			public Center_Panneau() {
				p=new JPanel(new BorderLayout(500,100));
				JLabel name2Panel=new JLabel("Description");
				p.add(name2Panel,BorderLayout.WEST);
			}
		}
		
		public class South_Panneau extends JPanel{
			public South_Panneau() {
				p=new JPanel(new BorderLayout(500,100));
				JLabel name3Panel=new JLabel("Description");
				p.add(name3Panel,BorderLayout.WEST);
			}
		} 
	}	
	
	
}
