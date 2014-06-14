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
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.border.BevelBorder;

import controlleur.RechercheFilmCont;

public class RechercherFilm extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomFilm;
	private JTextField txtDateDebut;
	private JTextField txtDateFin;

	private RechercheFilmCont rechercheFilmCont;
	/**
	 * Create the frame.
	 * @param rechercheFilmCont 
	 */
	public RechercherFilm(final RechercheFilmCont rechercheFilmCont) {
		this.rechercheFilmCont = rechercheFilmCont;
		setVisible(false);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	rechercheFilmCont.userClosedWindowRechercher();
		    } 
		});
		setBounds(100, 50, 545, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Recherche Film");
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btn_initialiser = new JButton("Initialiser");
		btn_initialiser.setEnabled(false);
		btn_initialiser.setBounds(235, 437, 107, 44);
		btn_initialiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btn_initialiser.setFont(new Font("Verdana", Font.BOLD, 13));
		
		Label label = new Label("Rechercher Film");
		label.setBounds(0, 10, 528, 22);
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		label.setBackground(Color.BLUE);
		
		JButton btn_Annuler = new JButton("Annuler");
		btn_Annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rechercheFilmCont.userClosedWindowRechercher();
			}
		});
		btn_Annuler.setBounds(412, 437, 107, 44);
		btn_Annuler.setFont(new Font("Verdana", Font.BOLD, 13));
		
		JButton btn_Rechercher = new JButton("Rechecher");
		btn_Rechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rechercheFilmCont.rechercheFilmParTitre(txtNomFilm.getText());
			}
		});
		btn_Rechercher.setBounds(57, 437, 117, 44);
		btn_Rechercher.setFont(new Font("Verdana", Font.BOLD, 13));
		
		JButton btnAnnuler = new JButton("Fermer");
		btnAnnuler.setBounds(624, 437, 98, 44);
		btnAnnuler.setFont(new Font("Verdana", Font.BOLD, 13));
		panel.setLayout(null);
		panel.add(label);
		panel.add(btn_Rechercher);
		panel.add(btnAnnuler);
		panel.add(btn_initialiser);
		panel.add(btn_Annuler);
		
		JLabel lblNomFilm = new JLabel("Nom Film :");
		lblNomFilm.setBounds(90, 73, 84, 19);
		panel.add(lblNomFilm);
		
		txtNomFilm = new JTextField();
		txtNomFilm.setColumns(10);
		txtNomFilm.setBounds(222, 72, 205, 20);
		panel.add(txtNomFilm);
		
		txtDateDebut = new JTextField();
		txtDateDebut.setColumns(10);
		txtDateDebut.setBounds(222, 117, 86, 20);
		panel.add(txtDateDebut);
		
		JLabel lblIntervalleAnnes = new JLabel("Intervalle années :");
		lblIntervalleAnnes.setBounds(90, 118, 122, 19);
		panel.add(lblIntervalleAnnes);
		
		JLabel lblPaysDeProduction = new JLabel("Pays de production :");
		lblPaysDeProduction.setBounds(90, 167, 107, 19);
		panel.add(lblPaysDeProduction);
		
		JLabel lblLangueOriginale = new JLabel("Langue originale:");
		lblLangueOriginale.setBounds(90, 217, 84, 19);
		panel.add(lblLangueOriginale);
		
		JLabel lblGenre = new JLabel("Genre :");
		lblGenre.setBounds(90, 275, 84, 19);
		panel.add(lblGenre);
		
		txtDateFin = new JTextField();
		txtDateFin.setColumns(10);
		txtDateFin.setBounds(368, 117, 98, 20);
		panel.add(txtDateFin);
		
		JLabel lblRalisateur = new JLabel("Réalisateur:");
		lblRalisateur.setBounds(90, 321, 84, 19);
		panel.add(lblRalisateur);
		
		JLabel lblActeur = new JLabel("Acteur :");
		lblActeur.setBounds(90, 361, 84, 19);
		panel.add(lblActeur);
		
		JLabel lblEt = new JLabel("et");
		lblEt.setBounds(329, 120, 54, 19);
		panel.add(lblEt);
		
		JComboBox comboBox_Pays = new JComboBox();
		comboBox_Pays.setBounds(224, 166, 142, 20);
		panel.add(comboBox_Pays);
		
		JComboBox comboBox_Genre = new JComboBox();
		comboBox_Genre.setBounds(224, 274, 144, 20);
		panel.add(comboBox_Genre);
		
		JComboBox comboBox_Realisateur = new JComboBox();
		comboBox_Realisateur.setBounds(222, 320, 146, 20);
		panel.add(comboBox_Realisateur);
		
		JComboBox comboBox_Acteur = new JComboBox();
		comboBox_Acteur.setBounds(222, 360, 146, 20);
		panel.add(comboBox_Acteur);
		
		JComboBox comboBox_Langue = new JComboBox();
		comboBox_Langue.setBounds(222, 216, 144, 20);
		panel.add(comboBox_Langue);
	}
	
	public void showErrorMessage(String string) {
		JOptionPane.showMessageDialog(null, string, "Erreur", JOptionPane.ERROR_MESSAGE);	
	}
}
