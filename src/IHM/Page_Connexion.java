package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Page_Connexion extends JFrame {
	Titre_Panneau tPanel;
	Principal_Panneau pPanel;
	Bas_Panneau bPanel;
	JButton seConnecter;
	JButton creerUnCompte;
	public Page_Connexion() {
		setTitle("Connexion");
		setBounds(400,0,600,400);
		setResizable(false);
		tPanel = new Titre_Panneau();
		pPanel = new Principal_Panneau();
		bPanel = new Bas_Panneau();
		add(tPanel,"North");
		add(pPanel,"Center");
		add(bPanel,"South");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		Page_Connexion pc = new Page_Connexion();
		
	}
	public class Titre_Panneau extends JPanel {
		public Titre_Panneau() {
			this.setBackground(Color.GREEN);
			JLabel t=new JLabel("Un logement, bonne recherche!");
			t.setFont(new Font("Time New Roman",Font.CENTER_BASELINE,24));
			add(t);		
		}
	}
	public class Principal_Panneau extends JPanel implements ActionListener {

		JPanel p;
		
		public Principal_Panneau() {
			p = new JPanel(new BorderLayout(10,10));
			p.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
			add(p, BorderLayout.CENTER);
			JLabel lbCon = new JLabel("Connexion", JLabel.CENTER);
			lbCon.setFont(new Font("Time New Roman", Font.CENTER_BASELINE,22));
			lbCon.setForeground(Color.BLUE);
			p.add(lbCon,BorderLayout.NORTH); 
			
			JPanel namePanel = new JPanel(new GridLayout(2,1,15,15)); 
			JLabel lbMail=new JLabel("Adresse email");
			JLabel lbPW=new JLabel("Mot de passe");
			lbMail.setFont(new Font("Time New Roman", Font.CENTER_BASELINE,15));
			lbPW.setFont(new Font("Time New Roman", Font.CENTER_BASELINE,15));
			namePanel.add(lbMail); 
			namePanel.add(lbPW);
			p.add(namePanel,BorderLayout.WEST);
			
			JPanel inputPanel=new JPanel(new GridLayout(2,1,15,15));
			inputPanel.add(new JTextField(20));
			inputPanel.add(new JPasswordField(20));
			p.add(inputPanel,BorderLayout.CENTER);
			
			JPanel statusPanel=new JPanel(new GridLayout(2,1,15,15));
			statusPanel.add(new JLabel(""));
			statusPanel.add(new JLabel(""));
			p.add(statusPanel,BorderLayout.EAST);
			
			seConnecter = new JButton("Se connecter");
			seConnecter.setFont(new Font("Time New Roman", Font.CENTER_BASELINE, 16));
			seConnecter.setForeground(Color.WHITE);
			seConnecter.setBackground(Color.BLUE);
			seConnecter.addActionListener(this);
			seConnecter.setFocusable(false);
			p.add(seConnecter,BorderLayout.SOUTH);
			p.setOpaque(false);
    	}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		}
	public  class Bas_Panneau extends JPanel implements ActionListener{
        public Bas_Panneau() {
           this.setBackground(Color.WHITE);
           JPanel p = new JPanel(new GridLayout(2,1,8,8));
           add(p, BorderLayout.CENTER);
			JLabel label = new JLabel("Vous n'avez pas de compte?",JLabel.CENTER);
			label.setFont(new Font("Time New Roman",Font.CENTER_BASELINE,14));
			label.setForeground(Color.BLACK);
			p.add(label);
			creerUnCompte = new JButton("Créer un compte");
			creerUnCompte.setFont(new Font("Time New Roman",Font.CENTER_BASELINE,14));
			creerUnCompte.setForeground(Color.BLUE);
			creerUnCompte.addActionListener(this);
			creerUnCompte.setFocusable(false);
			p.add(creerUnCompte);
            p.setOpaque(false);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Créer un compte")) {
			dispose();
			new Page_CreationCompte();
		}
		
	}
}

}
