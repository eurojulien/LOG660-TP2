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
import javax.swing.JTable;
import javax.swing.JList;

import controlleur.RechercheFilmCont;

public class ListFilm extends JFrame {

	private JPanel contentPane;

	private RechercheFilmCont rechercheFilmCont;
	/**
	 * Create the frame.
	 * @param rechercheFilmCont 
	 */
	public ListFilm(final RechercheFilmCont rechercheFilmCont) {
		this.rechercheFilmCont = rechercheFilmCont;
		setVisible(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -21, 635, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Résultat de recherhce");
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btn_New_Recherche = new JButton("Nouvelle recherche");
		btn_New_Recherche.setBounds(89, 426, 189, 44);
		btn_New_Recherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

			}
		});
		btn_New_Recherche.setFont(new Font("Verdana", Font.BOLD, 13));
		
		Label label = new Label("Résultat de rechrche");
		label.setBounds(0, 10, 609, 22);
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		label.setBackground(Color.BLUE);
		
		JButton btn_Annuler = new JButton("Annuler");
		btn_Annuler.setBounds(329, 426, 107, 44);
		btn_Annuler.setFont(new Font("Verdana", Font.BOLD, 13));
		
		JButton btnAnnuler = new JButton("Fermer");
		btnAnnuler.setBounds(624, 437, 98, 44);
		btnAnnuler.setFont(new Font("Verdana", Font.BOLD, 13));
		panel.setLayout(null);
		panel.add(label);
		panel.add(btnAnnuler);
		panel.add(btn_New_Recherche);
		panel.add(btn_Annuler);
		
		JList list = new JList();
		list.setBackground(SystemColor.inactiveCaption);
		list.setBounds(22, 56, 571, 359);
		panel.add(list);
	}
}
