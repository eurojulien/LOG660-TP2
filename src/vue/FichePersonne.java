package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import modele.Personne;

public class FichePersonne extends JFrame {

	private JPanel contentPane;
	private JTextField txtboxNomPrenom;
	private JTextField txtBoxDateNaissance;
	private JTextField txtBoxLieuNaissance;
	private JTextArea txtAreaBiographie;


	/**
	 * Create the frame.
	 */
	public FichePersonne() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 260);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtboxNomPrenom = new JTextField();
		txtboxNomPrenom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtboxNomPrenom.setEditable(false);
		txtboxNomPrenom.setBounds(10, 59, 194, 20);
		panel.add(txtboxNomPrenom);
		txtboxNomPrenom.setColumns(10);
		
		JLabel lblFiche = new JLabel("Fiche");
		lblFiche.setBounds(186, 11, 43, 26);
		lblFiche.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel.add(lblFiche);
		
		txtBoxDateNaissance = new JTextField();
		txtBoxDateNaissance.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBoxDateNaissance.setEditable(false);
		txtBoxDateNaissance.setColumns(10);
		txtBoxDateNaissance.setBounds(10, 92, 194, 20);
		panel.add(txtBoxDateNaissance);
		
		txtBoxLieuNaissance = new JTextField();
		txtBoxLieuNaissance.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBoxLieuNaissance.setEditable(false);
		txtBoxLieuNaissance.setColumns(10);
		txtBoxLieuNaissance.setBounds(10, 128, 194, 20);
		panel.add(txtBoxLieuNaissance);
		
		txtAreaBiographie = new JTextArea();
		txtAreaBiographie.setEditable(false);
		txtAreaBiographie.setBounds(10, 159, 394, 90);
		panel.add(txtAreaBiographie);
		
		JButton btnBack = new JButton("Retour");
		btnBack.setBounds(335, 282, 89, 23);
		contentPane.add(btnBack);
	}
	
	public void showPersonInformations(Personne personne){
		this.txtboxNomPrenom.setText(personne.getNom() + ", " + personne.getPrenom());
		this.txtBoxDateNaissance.setText(new SimpleDateFormat("YY-MM-JJ").format(personne.getDatedenaissance()));
		this.txtBoxLieuNaissance.setText(personne.getLieudenaissance());
		this.txtAreaBiographie.setText(personne.getBiographie());
	}
}
