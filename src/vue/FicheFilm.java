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

public class FicheFilm extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public FicheFilm() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -21, 716, 647);
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
		
		JLabel label2 = new JLabel("Année de sortie :");
		label2.setBounds(41, 88, 107, 19);
		panel.add(label2);
		
		JLabel label3 = new JLabel("Pays de production :");
		label3.setBounds(41, 129, 107, 19);
		panel.add(label3);
		
		JLabel labl4 = new JLabel("langue originale :");
		labl4.setBounds(41, 190, 84, 19);
		panel.add(labl4);
		
		JLabel labl5 = new JLabel("Durrée (min) :");
		labl5.setBounds(41, 227, 84, 19);
		panel.add(labl5);
		
		JLabel labl6 = new JLabel("Genres :");
		labl6.setBounds(41, 257, 84, 19);
		panel.add(labl6);
		
		JLabel label7 = new JLabel("Réealisateur :");
		label7.setBounds(41, 323, 84, 19);
		panel.add(label7);
		
		Label lblTitre = new Label("");
		lblTitre.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblTitre.setBackground(SystemColor.inactiveCaption);
		lblTitre.setAlignment(Label.CENTER);
		lblTitre.setBounds(164, 50, 230, 22);
		panel.add(lblTitre);
		
		Label lblAnnee = new Label("");
		lblAnnee.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblAnnee.setBackground(SystemColor.inactiveCaption);
		lblAnnee.setAlignment(Label.CENTER);
		lblAnnee.setBounds(164, 88, 230, 22);
		panel.add(lblAnnee);
		
		Label lblLangue = new Label("");
		lblLangue.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblLangue.setBackground(SystemColor.inactiveCaption);
		lblLangue.setAlignment(Label.CENTER);
		lblLangue.setBounds(164, 187, 230, 22);
		panel.add(lblLangue);
		
		Label lblDuree = new Label("");
		lblDuree.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblDuree.setBackground(SystemColor.inactiveCaption);
		lblDuree.setAlignment(Label.CENTER);
		lblDuree.setBounds(164, 224, 230, 22);
		panel.add(lblDuree);
		
		Label lblRealisateur = new Label("");
		lblRealisateur.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblRealisateur.setBackground(SystemColor.inactiveCaption);
		lblRealisateur.setAlignment(Label.CENTER);
		lblRealisateur.setBounds(164, 320, 230, 22);
		panel.add(lblRealisateur);
		
		JLabel labl8 = new JLabel("Scénaristes :");
		labl8.setBounds(41, 361, 84, 19);
		panel.add(labl8);
		
		JLabel labl9 = new JLabel("Acteurs :");
		labl9.setBounds(41, 425, 84, 19);
		panel.add(labl9);
		
		JLabel label10 = new JLabel("Résumé :");
		label10.setBounds(41, 504, 84, 19);
		panel.add(label10);
		
		JEditorPane dtrpnAdadadasdBfkjbskjSjdfkjsh = new JEditorPane();
		dtrpnAdadadasdBfkjbskjSjdfkjsh.setBackground(SystemColor.inactiveCaption);
		dtrpnAdadadasdBfkjbskjSjdfkjsh.setBounds(164, 490, 230, 108);
		panel.add(dtrpnAdadadasdBfkjbskjSjdfkjsh);
		
		JList list_Acteurs = new JList();
		list_Acteurs.setBackground(SystemColor.inactiveCaption);
		list_Acteurs.setBounds(164, 426, 230, 53);
		panel.add(list_Acteurs);
		
		JList list_Scenaristes = new JList();
		list_Scenaristes.setBackground(SystemColor.inactiveCaption);
		list_Scenaristes.setBounds(164, 362, 230, 53);
		panel.add(list_Scenaristes);
		
		JList list_Genres = new JList();
		list_Genres.setBackground(SystemColor.inactiveCaption);
		list_Genres.setBounds(164, 258, 230, 53);
		panel.add(list_Genres);
		
		JList list_1 = new JList();
		list_1.setBackground(SystemColor.inactiveCaption);
		list_1.setBounds(164, 120, 230, 53);
		panel.add(list_1);
	}
}
