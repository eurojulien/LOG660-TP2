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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.border.BevelBorder;
import javax.swing.JEditorPane;

public class InformationPersonne extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public InformationPersonne() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -21, 545, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Information");
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		Label label = new Label("Informations");
		label.setBounds(0, 10, 528, 22);
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		label.setBackground(Color.BLUE);
		
		JButton btn_Annuler = new JButton("Annuler");
		btn_Annuler.setBounds(263, 410, 107, 44);
		btn_Annuler.setFont(new Font("Verdana", Font.BOLD, 13));
		
		JButton btnAnnuler = new JButton("Fermer");
		btnAnnuler.setBounds(624, 437, 98, 44);
		btnAnnuler.setFont(new Font("Verdana", Font.BOLD, 13));
		panel.setLayout(null);
		panel.add(label);
		panel.add(btnAnnuler);
		panel.add(btn_Annuler);
		
		JLabel lblNomFilm = new JLabel("Nom et prénom :");
		lblNomFilm.setBounds(38, 83, 84, 19);
		panel.add(lblNomFilm);
		
		JLabel lblIntervalleAnnes = new JLabel("Date de naissance :");
		lblIntervalleAnnes.setBounds(38, 128, 122, 19);
		panel.add(lblIntervalleAnnes);
		
		JLabel lblPaysDeProduction = new JLabel("Lieu de naissance :");
		lblPaysDeProduction.setBounds(38, 177, 107, 19);
		panel.add(lblPaysDeProduction);
		
		JLabel lblLangueOriginale = new JLabel("biographie");
		lblLangueOriginale.setBounds(38, 227, 84, 19);
		panel.add(lblLangueOriginale);
		
		Label label_nom = new Label("");
		label_nom.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		label_nom.setBackground(SystemColor.inactiveCaption);
		label_nom.setAlignment(Label.CENTER);
		label_nom.setBounds(167, 80, 233, 22);
		panel.add(label_nom);
		
		Label label_DateNaissance = new Label("");
		label_DateNaissance.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		label_DateNaissance.setBackground(SystemColor.inactiveCaption);
		label_DateNaissance.setAlignment(Label.CENTER);
		label_DateNaissance.setBounds(166, 128, 233, 22);
		panel.add(label_DateNaissance);
		
		Label label_LieuNaissance = new Label("");
		label_LieuNaissance.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		label_LieuNaissance.setBackground(SystemColor.inactiveCaption);
		label_LieuNaissance.setAlignment(Label.CENTER);
		label_LieuNaissance.setBounds(167, 177, 233, 22);
		panel.add(label_LieuNaissance);
		
		JEditorPane lblBio = new JEditorPane();
		lblBio.setBackground(SystemColor.inactiveCaption);
		lblBio.setBounds(167, 231, 225, 115);
		panel.add(lblBio);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Verdana", Font.BOLD, 13));
		btnRetour.setBounds(109, 410, 107, 44);
		panel.add(btnRetour);
	}
}
