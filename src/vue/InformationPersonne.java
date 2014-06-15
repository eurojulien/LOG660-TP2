package vue;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Desktop;
import java.awt.SystemColor;
import java.awt.Label;
import java.net.URI;
import javax.swing.JTextArea;

import modele.Implication;


public class InformationPersonne extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 * @param implication 
	 */
	public InformationPersonne(final Implication implication) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 50, 545, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Information");
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		Label label = new Label("Informations");
		label.setBounds(0, 10, 528, 22);
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		label.setBackground(Color.BLUE);
		panel.add(label);
		
		JLabel lblNomFilm = new JLabel("Nom et prénom :");
		lblNomFilm.setBounds(38, 83, 122, 19);
		panel.add(lblNomFilm);
		
		JLabel lblIntervalleAnnes = new JLabel("Date de naissance :");
		lblIntervalleAnnes.setBounds(38, 128, 122, 19);
		panel.add(lblIntervalleAnnes);
		
		JLabel lblPaysDeProduction = new JLabel("Lieu de naissance :");
		lblPaysDeProduction.setBounds(38, 177, 122, 19);
		panel.add(lblPaysDeProduction);
		
		JLabel lblLangueOriginale = new JLabel("Biographie :");
		lblLangueOriginale.setBounds(38, 227, 84, 19);
		panel.add(lblLangueOriginale);
		
		Label label_nom = new Label(implication.getPersonne().getPrenom() + " " +
										implication.getPersonne().getNom());
		label_nom.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		label_nom.setBackground(SystemColor.inactiveCaption);
		label_nom.setBounds(167, 80, 233, 22);
		panel.add(label_nom);
		
		Label label_DateNaissance;
		if(implication.getPersonne().getDatedenaissance() != null)
			label_DateNaissance = new Label(implication.getPersonne().getDatedenaissance().toString());
		else
			label_DateNaissance = new Label();
		label_DateNaissance.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		label_DateNaissance.setBackground(SystemColor.inactiveCaption);
		label_DateNaissance.setBounds(166, 128, 233, 22);
		panel.add(label_DateNaissance);
		
		Label label_LieuNaissance;
		if(implication.getPersonne().getLieudenaissance() != null)
			label_LieuNaissance = new Label(implication.getPersonne().getLieudenaissance());
		else
			label_LieuNaissance = new Label();
		label_LieuNaissance.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		label_LieuNaissance.setBackground(SystemColor.inactiveCaption);
		label_LieuNaissance.setBounds(167, 177, 233, 22);
		panel.add(label_LieuNaissance);
		
		JTextArea txt_Bio;
		if(implication.getPersonne().getBiographie() != null)
			txt_Bio = new JTextArea(implication.getPersonne().getBiographie());
		else
			txt_Bio = new JTextArea();
		txt_Bio.setLineWrap(true);
		txt_Bio.setWrapStyleWord(true);
		txt_Bio.setBackground(SystemColor.inactiveCaption);
		txt_Bio.setBounds(167, 231, 225, 115);
		panel.add(txt_Bio);
		
		JButton btn_Photo = new JButton("Photo");
		btn_Photo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
			    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			        try {
			        	if(implication.getPersonne().getPhoto() != null)
			        		desktop.browse(URI.create(implication.getPersonne().getPhoto()));
			        } catch (Exception ee) {
			            ee.printStackTrace();
			        }
			    }
			}
		});
		btn_Photo.setFont(new Font("Verdana", Font.BOLD, 13));
		btn_Photo.setBounds(167, 405, 122, 47);
		panel.add(btn_Photo);
	}
}
