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
import javax.swing.JList;

import modele.Film;

public class FicheFilm extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 * @param film 
	 */
	public FicheFilm(Film film) {
		setVisible(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 716, 647);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Fiche Film");
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btn_initialiser = new JButton("Liste de recherche");
		btn_initialiser.setBounds(494, 504, 167, 44);
		btn_initialiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btn_initialiser.setFont(new Font("Verdana", Font.BOLD, 13));
		
		Label label = new Label("Fiche Film");
		label.setBounds(0, 10, 700, 22);
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		label.setBackground(Color.BLUE);
		
		JButton btn_Annuler = new JButton("Annuler");
		btn_Annuler.setBounds(589, 410, 107, 44);
		btn_Annuler.setFont(new Font("Verdana", Font.BOLD, 13));
		
		JButton btn_Rechercher = new JButton("Loyer");
		btn_Rechercher.setBounds(445, 410, 134, 44);
		btn_Rechercher.setFont(new Font("Verdana", Font.BOLD, 13));
		panel.setLayout(null);
		panel.add(label);
		panel.add(btn_Rechercher);
		panel.add(btn_initialiser);
		panel.add(btn_Annuler);
		
		JLabel lblNomFilm = new JLabel("Titre de Film :");
		lblNomFilm.setBounds(41, 50, 84, 19);
		panel.add(lblNomFilm);
		
		JLabel lbl_Titre_AnneeSortie = new JLabel("Année de sortie :");
		lbl_Titre_AnneeSortie.setBounds(41, 88, 107, 19);
		panel.add(lbl_Titre_AnneeSortie);
		
		JLabel lbl_Titre_PaysProd = new JLabel("Pays de production :");
		lbl_Titre_PaysProd.setBounds(41, 129, 107, 19);
		panel.add(lbl_Titre_PaysProd);
		
		JLabel lbl_Titre_langueOriginal = new JLabel("langue originale :");
		lbl_Titre_langueOriginal.setBounds(41, 190, 84, 19);
		panel.add(lbl_Titre_langueOriginal);
		
		JLabel lbl_Titre_Duree = new JLabel("Durrée (min) :");
		lbl_Titre_Duree.setBounds(41, 227, 84, 19);
		panel.add(lbl_Titre_Duree);
		
		JLabel lbl_Titre_Genres = new JLabel("Genres :");
		lbl_Titre_Genres.setBounds(41, 257, 84, 19);
		panel.add(lbl_Titre_Genres);
		
		JLabel lbl_Titre_Realisateur = new JLabel("Réalisateur :");
		lbl_Titre_Realisateur.setBounds(41, 323, 84, 19);
		panel.add(lbl_Titre_Realisateur);
		
		Label lblTitre = new Label(film.getTitre());
		lblTitre.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblTitre.setBackground(SystemColor.inactiveCaption);
		lblTitre.setAlignment(Label.CENTER);
		lblTitre.setBounds(164, 50, 230, 22);
		panel.add(lblTitre);
		
		Label lblAnnee = new Label(String.valueOf(film.getAnneesortie()));
		lblAnnee.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblAnnee.setBackground(SystemColor.inactiveCaption);
		lblAnnee.setAlignment(Label.CENTER);
		lblAnnee.setBounds(164, 88, 230, 22);
		panel.add(lblAnnee);
		
		Label lblLangue = new Label(film.getLangue());
		lblLangue.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblLangue.setBackground(SystemColor.inactiveCaption);
		lblLangue.setAlignment(Label.CENTER);
		lblLangue.setBounds(164, 187, 230, 22);
		panel.add(lblLangue);
		
		Label lblDuree = new Label(String.valueOf(film.getDuree()));
		lblDuree.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblDuree.setBackground(SystemColor.inactiveCaption);
		lblDuree.setAlignment(Label.CENTER);
		lblDuree.setBounds(164, 224, 230, 22);
		panel.add(lblDuree);
		
		JLabel lbl_Titre_Scenaristes = new JLabel("Scénaristes :");
		lbl_Titre_Scenaristes.setBounds(41, 391, 84, 19);
		panel.add(lbl_Titre_Scenaristes);
		
		JLabel lbl_Titre_Acteurs = new JLabel("Acteurs :");
		lbl_Titre_Acteurs.setBounds(41, 455, 84, 19);
		panel.add(lbl_Titre_Acteurs);
		
		JLabel lbl_Titre_Resume = new JLabel("Résumé :");
		lbl_Titre_Resume.setBounds(41, 519, 84, 19);
		panel.add(lbl_Titre_Resume);
		
		JEditorPane txt_Resume = new JEditorPane();
		txt_Resume.setBackground(SystemColor.inactiveCaption);
		txt_Resume.setBounds(164, 520, 230, 78);
		panel.add(txt_Resume);
		
		JList list_Acteurs = new JList();
		list_Acteurs.setBackground(SystemColor.inactiveCaption);
		list_Acteurs.setBounds(164, 456, 230, 53);
		panel.add(list_Acteurs);
		
		JList list_Scenaristes = new JList();
		list_Scenaristes.setBackground(SystemColor.inactiveCaption);
		list_Scenaristes.setBounds(164, 392, 230, 53);
		panel.add(list_Scenaristes);
		
		JList list_Genres = new JList();
		list_Genres.setBackground(SystemColor.inactiveCaption);
		list_Genres.setBounds(164, 258, 230, 53);
		panel.add(list_Genres);
		
		JList list_1 = new JList();
		list_1.setBackground(SystemColor.inactiveCaption);
		list_1.setBounds(164, 120, 230, 53);
		panel.add(list_1);
		
		JList list_Realisateur = new JList();
		list_Realisateur.setBackground(SystemColor.inactiveCaption);
		list_Realisateur.setBounds(164, 324, 230, 53);
		panel.add(list_Realisateur);
	}
}
