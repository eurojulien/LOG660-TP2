package vue;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Label;
import javax.swing.JOptionPane;
import javax.swing.JList;
import controlleur.RechercheFilmCont;
import javax.swing.ListSelectionModel;
import java.util.Vector;

public class ListFilm extends JFrame {

	private JPanel contentPane;
	private JList list;
	private Vector<String> listModel;
	private RechercheFilmCont rechercheFilmCont;
	
	/**
	 * Create the frame.
	 * @param rechercheFilmCont 
	 */
	public ListFilm(final RechercheFilmCont rechercheFilmCont) {
		this.rechercheFilmCont = rechercheFilmCont;
		setVisible(false);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	rechercheFilmCont.userClosedWindowResultat();
		    } 
		});
		setBounds(100, 50, 635, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Résultat de recherhce");
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btn_New_Recherche = new JButton("Nouvelle recherche");
		btn_New_Recherche.setBounds(10, 426, 185, 44);
		btn_New_Recherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rechercheFilmCont.userClosedWindowResultat();
			}
		});
		btn_New_Recherche.setFont(new Font("Verdana", Font.BOLD, 13));
		
		Label label = new Label("Résultat de rechrche");
		label.setBounds(0, 10, 609, 22);
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		label.setBackground(Color.BLUE);
		
		JButton btn_Annuler = new JButton("Annuler");
		btn_Annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rechercheFilmCont.userClosedWindowResultat();
			}
		});
		btn_Annuler.setBounds(486, 426, 107, 44);
		btn_Annuler.setFont(new Font("Verdana", Font.BOLD, 13));
		
		JButton btnAnnuler = new JButton("Fermer");
		btnAnnuler.setBounds(624, 437, 98, 44);
		btnAnnuler.setFont(new Font("Verdana", Font.BOLD, 13));
		panel.setLayout(null);
		panel.add(label);
		panel.add(btnAnnuler);
		panel.add(btn_New_Recherche);
		panel.add(btn_Annuler);
		
		listModel = new Vector<String>();
		list = new JList(listModel);
		list.setSelectedIndex(0);
		list.setVisibleRowCount(24);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBackground(SystemColor.menu);
		list.setBounds(22, 56, 571, 359);
		
		
		JButton btn_Louer = new JButton("Louer");
		btn_Louer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.isSelectionEmpty()){
					showErrorMessage("Aucun film selectionner.");
				}
				else{
					rechercheFilmCont.addLoction(list.getSelectedIndex());
				}				
			}
		});
		btn_Louer.setFont(new Font("Verdana", Font.BOLD, 13));
		btn_Louer.setBounds(221, 426, 107, 44);
		
		panel.add(list);
		panel.add(btn_Louer);
		
		JButton btnFicheFilm = new JButton("Fiche Film");
		btnFicheFilm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.isSelectionEmpty()){
					showErrorMessage("Aucun film selectionner.");
				}
				else{
					rechercheFilmCont.affichierFicheFilm(list.getSelectedIndex());
				}
			}
		});
		btnFicheFilm.setFont(new Font("Verdana", Font.BOLD, 13));
		btnFicheFilm.setBounds(353, 426, 112, 44);
		panel.add(btnFicheFilm);
	}
	
	public void clearList(){
		list.removeAll();
		listModel.clear();
	}
	
	public void addFilm(String name){
		listModel.addElement(name);
		list.setListData(listModel);
	}
	
	public void showErrorMessage(String string) {
		JOptionPane.showMessageDialog(null, string, "Erreur", JOptionPane.ERROR_MESSAGE);	
	}
}
