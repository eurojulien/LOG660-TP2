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

import javax.swing.JComboBox;

import controlleur.MenuControlleur;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lbl_Id;
	
	private MenuControlleur menuControlleur;

	/**
	 * Create the frame.
	 * @param menuControlleur 
	 */
	public MenuPrincipal(final MenuControlleur menuControlleur) {
		this.menuControlleur = menuControlleur;
		setVisible(false);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	menuControlleur.userClosedWindow();
		    } 
		});
		
		setBounds(100, 50, 457, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Authentification");
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		JLabel lblNomUtilisateur = new JLabel("ID :");
		lblNomUtilisateur.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNomUtilisateur.setBounds(10, 38, 52, 17);
		panel.add(lblNomUtilisateur);
		
		lbl_Id = new JLabel("");
		lbl_Id.setBackground(Color.LIGHT_GRAY);
		lbl_Id.setFont(new Font("Verdana", Font.BOLD, 13));
		lbl_Id.setBounds(51, 38, 135, 17);
		panel.add(lbl_Id);
		
		JButton btn_Gestion_Client = new JButton("Gestion des clients");
		btn_Gestion_Client.setEnabled(false);
		btn_Gestion_Client.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

			}
		});
		btn_Gestion_Client.setFont(new Font("Verdana", Font.BOLD, 13));
		btn_Gestion_Client.setBounds(68, 78, 197, 44);
		panel.add(btn_Gestion_Client);
		
		Label label = new Label("Menu principal");
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		label.setBackground(SystemColor.inactiveCaption);
		label.setBounds(0, 10, 427, 22);
		panel.add(label);
		
		JButton btnGestionForfaits = new JButton("Gestion forfaits");
		btnGestionForfaits.setEnabled(false);
		btnGestionForfaits.setFont(new Font("Verdana", Font.BOLD, 13));
		btnGestionForfaits.setBounds(68, 145, 197, 44);
		panel.add(btnGestionForfaits);
		
		JButton btnGestionDesLocations = new JButton("Gestion des locations");
		btnGestionDesLocations.setFont(new Font("Verdana", Font.BOLD, 13));
		btnGestionDesLocations.setBounds(68, 211, 197, 44);
		panel.add(btnGestionDesLocations);
		
		JButton btnAnnuler = new JButton("Fermer");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuControlleur.userClosedWindow();
			}
		});
		btnAnnuler.setFont(new Font("Verdana", Font.BOLD, 13));
		btnAnnuler.setBounds(329, 238, 102, 44);
		panel.add(btnAnnuler);
	}
	
	public void setUserInfo(String id){
		lbl_Id.setText(id);
	}
}
