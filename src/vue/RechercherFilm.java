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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Label;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.border.BevelBorder;

import controlleur.Item;
import modele.Pays;
import controlleur.Facade;
import controlleur.RechercheFilmCont;

public class RechercherFilm extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomFilm;
	private JTextField txtDateDebut;
	private JTextField txtDateFin;
	private JComboBox comboBox_Pays;
	private JComboBox comboBox_Genre;
	private JTextField txt_Realisateur;
	private JTextField txt_Acteur;
	private JComboBox comboBox_Langue;

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
				  Item item = (Item)comboBox_Pays.getSelectedItem();
			      //System.out.println( item.getId() + " : " + item.getDescription() );
			      //rechercheFilmCont.rechercheFilmParTitre(txtNomFilm.getText(), null/*comboBox_Langue.getSelectedItem().toString()*/);
				  Item itempays = (Item)comboBox_Pays.getSelectedItem();
			      rechercheFilmCont.rechercheFilmFonctionAwesome(txtNomFilm.getText(), 
			    		  											itempays.getDescription(), 
			    		  											(String)comboBox_Langue.getSelectedItem(), 
			    		  											(String)comboBox_Genre.getSelectedItem(), 
			    		  											txt_Realisateur.getText(), 
			    		  											txt_Acteur.getText(), 
			    		  											txtDateDebut.getText(), 
			    		  											txtDateFin.getText());
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
		lblPaysDeProduction.setBounds(90, 167, 122, 19);
		panel.add(lblPaysDeProduction);
		
		JLabel lblLangueOriginale = new JLabel("Langue originale:");
		lblLangueOriginale.setBounds(90, 217, 122, 19);
		panel.add(lblLangueOriginale);
		
		JLabel lblGenre = new JLabel("Genre :");
		lblGenre.setBounds(90, 275, 84, 19);
		panel.add(lblGenre);
		
		txtDateFin = new JTextField();
		txtDateFin.setColumns(10);
		txtDateFin.setBounds(368, 117, 98, 20);
		panel.add(txtDateFin);
		
		JLabel lblRealisateur = new JLabel("Réalisateur:");
		lblRealisateur.setBounds(90, 321, 122, 19);
		panel.add(lblRealisateur);
		
		JLabel lblActeur = new JLabel("Acteur :");
		lblActeur.setBounds(90, 361, 84, 19);
		panel.add(lblActeur);
		
		JLabel lblEt = new JLabel("et");
		lblEt.setBounds(329, 120, 38, 19);
		panel.add(lblEt);
		
		comboBox_Pays = new JComboBox();
		comboBox_Pays.setBounds(224, 166, 142, 20);
		panel.add(comboBox_Pays);
		
		comboBox_Genre = new JComboBox();
		comboBox_Genre.setBounds(224, 274, 144, 20);
		panel.add(comboBox_Genre);
		
		txt_Realisateur = new JTextField();
		txt_Realisateur.setBounds(222, 320, 146, 20);
		panel.add(txt_Realisateur);
		
		txt_Acteur = new JTextField();
		txt_Acteur.setBounds(222, 360, 146, 20);
		panel.add(txt_Acteur);
		
		comboBox_Langue = new JComboBox();
		comboBox_Langue.setBounds(222, 216, 144, 20);
		panel.add(comboBox_Langue);

	}
	
	public void showErrorMessage(String string) {
		JOptionPane.showMessageDialog(null, string, "Erreur", JOptionPane.ERROR_MESSAGE);	
	}
	
	
	public void addPays(Vector pays){
		comboBox_Pays.addItem(pays.remove(0));
	}
	
	public void addGenre(String genre){
		comboBox_Genre.addItem(genre);
	}
	
	public void addLangue(String langue){
		comboBox_Langue.addItem(langue);
	}
	
}
