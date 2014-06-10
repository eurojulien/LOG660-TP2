package vue;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JPasswordField;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.SwingConstants;




//import Controleur.Authentification;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.JComboBox;

import modele.Exemplaire;
import modele.Film;
import modele.Utilisateur;
import controlleur.Facade;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomUtilisateur;
	private JPasswordField txtMotDePasse;
	//static Authentification Authentifi = new Authentification();

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -21, 457, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Authentification");
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtNomUtilisateur = new JTextField();
		txtNomUtilisateur.setForeground(new Color(0, 128, 0));
		txtNomUtilisateur.setFont(new Font("Verdana", Font.BOLD, 13));
		txtNomUtilisateur.setBounds(194, 80, 160, 28);
		txtNomUtilisateur.setColumns(10);
		panel.add(txtNomUtilisateur);
		
		
		JLabel lblNomUtilisateur = new JLabel("Identificateur");
		lblNomUtilisateur.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNomUtilisateur.setBounds(33, 85, 151, 17);
		panel.add(lblNomUtilisateur);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setFont(new Font("Verdana", Font.BOLD, 13));
		lblMotDePasse.setBounds(33, 125, 135, 17);
		panel.add(lblMotDePasse);
		
		txtMotDePasse = new JPasswordField();
		txtMotDePasse.setForeground(new Color(0, 128, 0));
		txtMotDePasse.setBounds(194, 121, 160, 28);
		panel.add(txtMotDePasse);
		
		final JLabel lblMessage = new JLabel("");
		lblMessage.setForeground(new Color(255, 0, 0));
		lblMessage.setFont(new Font("Verdana", Font.BOLD, 13));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(33, 231, 333, 31);
		panel.add(lblMessage);
		
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnAnnuler.setFont(new Font("Verdana", Font.BOLD, 13));
		btnAnnuler.setBounds(228, 179, 91, 23);
		panel.add(btnAnnuler);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Facade facade = Facade.getFacade();

			
				ArrayList<Utilisateur> user = (ArrayList<Utilisateur>) facade.getObjects(Utilisateur.class, 
									"identificateur = '" + txtNomUtilisateur.getText() + "'", 
									"motdepasse = '" + txtMotDePasse.getText() + "'");
				if(!user.isEmpty()){
				MenuPrincipal menu = new MenuPrincipal();
				menu.setVisible(true);
								
				}else 
				{
					lblMessage.setText("Error !!");
				}
				
//				ArrayList<Film> films = (ArrayList<Film>) facade.getObjects(Film.class, "idFilm = 34492");
//				System.out.println("Film : " + films.get(0).getResume());
//				
//				ArrayList<Exemplaire> exe = (ArrayList<Exemplaire>) facade.getObjects(Exemplaire.class,"idFilm = " + films.get(0).getIdfilm().toPlainString());
//				System.out.println("Exemplaires : " + exe.get(0).getIdexemplaire());
				
			}
		});
		btnValider.setFont(new Font("Verdana", Font.BOLD, 13));
		btnValider.setBounds(93, 179, 91, 23);
		panel.add(btnValider);
		
		Label label = new Label("Page d'acc\u00E8s");
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		label.setBackground(SystemColor.inactiveCaption);
		label.setBounds(0, 22, 427, 22);
		panel.add(label);
	}
}
