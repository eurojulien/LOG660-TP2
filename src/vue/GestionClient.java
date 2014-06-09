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

public class GestionClient extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Nom;
	private JTextField txt_Prenom;
	private JTextField txt_DateNaissance;
	private JTextField txt_Tel;
	private JTextField txt_Courriel;
	private JTextField txt_TypeCarte;
	private JTextField txt_numeroCarte;
	private JTextField txt_dateExpiration;
	private JTextField txtCVV;
	private JTextField txtTypeForfait;
	private JTextField txt_IdForfait;
	private JTextField txtCout;
	private JTextField txt_LoxationMax;
	private JTextField txtDureeForfait;
	private JTextField txt_NumCivique;
	private JTextField txt_Rue;
	private JTextField txt_Ville;
	private JTextField txt_Province;
	private JTextField txt_Codepostal;


	/**
	 * Create the frame.
	 */
	public GestionClient() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -21, 748, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Authentification");
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		
		JLabel lblNomUtilisateur = new JLabel("ID :");
		lblNomUtilisateur.setBounds(10, 38, 52, 17);
		lblNomUtilisateur.setFont(new Font("Verdana", Font.BOLD, 13));
		
		JLabel lbl_Id = new JLabel("");
		lbl_Id.setBounds(51, 38, 135, 17);
		lbl_Id.setBackground(Color.LIGHT_GRAY);
		lbl_Id.setFont(new Font("Verdana", Font.BOLD, 13));
		
		JButton btn_Gestion_Modifier = new JButton("Modifier");
		btn_Gestion_Modifier.setBounds(127, 437, 107, 44);
		btn_Gestion_Modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

			}
		});
		btn_Gestion_Modifier.setFont(new Font("Verdana", Font.BOLD, 13));
		
		Label label = new Label("Menu principal");
		label.setBounds(0, 10, 427, 22);
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		label.setBackground(SystemColor.inactiveCaption);
		
		JButton btn_Supprimer = new JButton("Supprimer");
		btn_Supprimer.setBounds(261, 437, 107, 44);
		btn_Supprimer.setFont(new Font("Verdana", Font.BOLD, 13));
		
		JButton btn_Ajouter = new JButton("Ajouter");
		btn_Ajouter.setBounds(0, 437, 107, 44);
		btn_Ajouter.setFont(new Font("Verdana", Font.BOLD, 13));
		
		JButton btnAnnuler = new JButton("Fermer");
		btnAnnuler.setBounds(624, 437, 98, 44);
		btnAnnuler.setFont(new Font("Verdana", Font.BOLD, 13));
		panel.setLayout(null);
		panel.add(label);
		panel.add(lbl_Id);
		panel.add(lblNomUtilisateur);
		panel.add(btn_Ajouter);
		panel.add(btnAnnuler);
		panel.add(btn_Gestion_Modifier);
		panel.add(btn_Supprimer);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel1.setBounds(0, 61, 234, 177);
		panel.add(panel1);
		panel1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom Client :");
		lblNewLabel.setBounds(10, 11, 60, 19);
		panel1.add(lblNewLabel);
		
		txt_Nom = new JTextField();
		txt_Nom.setBounds(104, 10, 86, 20);
		panel1.add(txt_Nom);
		txt_Nom.setColumns(10);
		
		txt_Prenom = new JTextField();
		txt_Prenom.setColumns(10);
		txt_Prenom.setBounds(104, 41, 86, 20);
		panel1.add(txt_Prenom);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom :");
		lblPrnom.setBounds(10, 42, 60, 19);
		panel1.add(lblPrnom);
		
		txt_DateNaissance = new JTextField();
		txt_DateNaissance.setColumns(10);
		txt_DateNaissance.setBounds(104, 72, 86, 20);
		panel1.add(txt_DateNaissance);
		
		JLabel lblDateNaissance = new JLabel("Date naissance :");
		lblDateNaissance.setBounds(10, 73, 84, 19);
		panel1.add(lblDateNaissance);
		
		txt_Tel = new JTextField();
		txt_Tel.setColumns(10);
		txt_Tel.setBounds(104, 103, 86, 20);
		panel1.add(txt_Tel);
		
		JLabel lblTl = new JLabel("T\u00E9l :");
		lblTl.setBounds(10, 103, 60, 19);
		panel1.add(lblTl);
		
		txt_Courriel = new JTextField();
		txt_Courriel.setColumns(10);
		txt_Courriel.setBounds(104, 134, 86, 20);
		panel1.add(txt_Courriel);
		
		JLabel lblCourriel = new JLabel("Courriel :");
		lblCourriel.setBounds(10, 133, 60, 19);
		panel1.add(lblCourriel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(310, 249, 260, 177);
		panel.add(panel_1);
		
		JLabel lblTypeCarteCrdit = new JLabel("Type Carte cr\u00E9dit :");
		lblTypeCarteCrdit.setBounds(10, 11, 99, 20);
		panel_1.add(lblTypeCarteCrdit);
		
		txt_TypeCarte = new JTextField();
		txt_TypeCarte.setColumns(10);
		txt_TypeCarte.setBounds(135, 11, 86, 20);
		panel_1.add(txt_TypeCarte);
		
		txt_numeroCarte = new JTextField();
		txt_numeroCarte.setColumns(10);
		txt_numeroCarte.setBounds(135, 42, 86, 20);
		panel_1.add(txt_numeroCarte);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(10, 42, 60, 19);
		panel_1.add(lblNumero);
		
		txt_dateExpiration = new JTextField();
		txt_dateExpiration.setColumns(10);
		txt_dateExpiration.setBounds(135, 73, 86, 20);
		panel_1.add(txt_dateExpiration);
		
		JLabel lblDatexp = new JLabel("Date \u00E9xpiration :");
		lblDatexp.setBounds(10, 73, 84, 19);
		panel_1.add(lblDatexp);
		
		txtCVV = new JTextField();
		txtCVV.setColumns(10);
		txtCVV.setBounds(135, 104, 86, 20);
		panel_1.add(txtCVV);
		
		JLabel lblCvv = new JLabel("CVV :");
		lblCvv.setBounds(10, 103, 60, 19);
		panel_1.add(lblCvv);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(0, 250, 234, 177);
		panel.add(panel_2);
		
		JLabel lblTypeForfait = new JLabel("Type Forfait :");
		lblTypeForfait.setBounds(10, 11, 84, 19);
		panel_2.add(lblTypeForfait);
		
		txtTypeForfait = new JTextField();
		txtTypeForfait.setColumns(10);
		txtTypeForfait.setBounds(104, 10, 86, 20);
		panel_2.add(txtTypeForfait);
		
		txt_IdForfait = new JTextField();
		txt_IdForfait.setColumns(10);
		txt_IdForfait.setBounds(104, 41, 86, 20);
		panel_2.add(txt_IdForfait);
		
		JLabel lblIdForfait = new JLabel("ID Forfait");
		lblIdForfait.setBounds(10, 42, 60, 19);
		panel_2.add(lblIdForfait);
		
		txtCout = new JTextField();
		txtCout.setColumns(10);
		txtCout.setBounds(104, 72, 86, 20);
		panel_2.add(txtCout);
		
		JLabel lblCout = new JLabel("Cout :");
		lblCout.setBounds(10, 73, 84, 19);
		panel_2.add(lblCout);
		
		txt_LoxationMax = new JTextField();
		txt_LoxationMax.setColumns(10);
		txt_LoxationMax.setBounds(104, 103, 86, 20);
		panel_2.add(txt_LoxationMax);
		
		JLabel lblLocation = new JLabel("Location Max");
		lblLocation.setBounds(10, 103, 84, 19);
		panel_2.add(lblLocation);
		
		txtDureeForfait = new JTextField();
		txtDureeForfait.setColumns(10);
		txtDureeForfait.setBounds(104, 134, 86, 20);
		panel_2.add(txtDureeForfait);
		
		JLabel lblDureMax = new JLabel("Dur\u00E9e max :");
		lblDureMax.setBounds(10, 133, 60, 19);
		panel_2.add(lblDureMax);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(310, 61, 248, 177);
		panel.add(panel_3);
		
		JLabel lblNumCiviquet = new JLabel("Num civique :");
		lblNumCiviquet.setBounds(10, 11, 93, 19);
		panel_3.add(lblNumCiviquet);
		
		txt_NumCivique = new JTextField();
		txt_NumCivique.setColumns(10);
		txt_NumCivique.setBounds(135, 8, 86, 20);
		panel_3.add(txt_NumCivique);
		
		txt_Rue = new JTextField();
		txt_Rue.setColumns(10);
		txt_Rue.setBounds(135, 39, 86, 20);
		panel_3.add(txt_Rue);
		
		JLabel lblRue = new JLabel("Rue :");
		lblRue.setBounds(10, 42, 60, 19);
		panel_3.add(lblRue);
		
		txt_Ville = new JTextField();
		txt_Ville.setColumns(10);
		txt_Ville.setBounds(135, 70, 86, 20);
		panel_3.add(txt_Ville);
		
		JLabel lblVille = new JLabel("Ville :");
		lblVille.setBounds(10, 73, 84, 19);
		panel_3.add(lblVille);
		
		txt_Province = new JTextField();
		txt_Province.setColumns(10);
		txt_Province.setBounds(135, 101, 86, 20);
		panel_3.add(txt_Province);
		
		JLabel lblProvince = new JLabel("Province :");
		lblProvince.setBounds(10, 103, 60, 19);
		panel_3.add(lblProvince);
		
		txt_Codepostal = new JTextField();
		txt_Codepostal.setColumns(10);
		txt_Codepostal.setBounds(135, 132, 86, 20);
		panel_3.add(txt_Codepostal);
		
		JLabel lblCode = new JLabel("Code postal :");
		lblCode.setBounds(10, 133, 93, 19);
		panel_3.add(lblCode);
		
		JButton btnRetourMenuPrincipal = new JButton("Retour Menu principal");
		btnRetourMenuPrincipal.setFont(new Font("Verdana", Font.BOLD, 13));
		btnRetourMenuPrincipal.setBounds(597, 325, 125, 86);
		panel.add(btnRetourMenuPrincipal);
	}
}
