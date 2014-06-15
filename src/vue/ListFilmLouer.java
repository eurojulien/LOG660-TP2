package vue;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;

import java.awt.Component;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Label;
import java.util.Vector;

import javax.swing.JList;

import controlleur.LouerControlleur;

import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

public class ListFilmLouer extends JFrame {

	private JPanel contentPane;
	private JList list;
	private Vector<String> listModel;
	private LouerControlleur louerControlleur;

	/**
	 * Create the frame.
	 */
	public ListFilmLouer(final LouerControlleur louerControlleur) {
		setResizable(false);
		setVisible(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	louerControlleur.userClosedWindow();
		    } 
		});
		setBounds(100, 50, 635, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Louer");
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btn_Add_Film = new JButton("Recherche et Ajouter");
		btn_Add_Film.setBounds(32, 373, 227, 44);
		btn_Add_Film.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				louerControlleur.partirRecherche();
			}
		});
		btn_Add_Film.setFont(new Font("Verdana", Font.BOLD, 13));
		
		Label label = new Label("Louer");
		label.setBounds(0, 10, 609, 22);
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		label.setBackground(Color.BLUE);
		
		JButton btn_Annuler = new JButton("Annuler");
		btn_Annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				louerControlleur.userClosedWindow();
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
		panel.add(btn_Add_Film);
		panel.add(btn_Annuler);
		
		listModel = new Vector<String>();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 56, 571, 306);
		panel.add(scrollPane);
		list = new JList(listModel);
		scrollPane.setViewportView(list);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBackground(SystemColor.menu);
		list.setAutoscrolls(true);
		
		JButton btn_RemoveSelected = new JButton("Enlever Film Selectionner");
		btn_RemoveSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.isSelectionEmpty()){
					showErrorMessage("Aucun film selectionner.");
				}
				else{
					//list.remove(list.getSelectedIndex());
					louerControlleur.enleverFilm(list.getSelectedIndex());
				}
			}
		});
		btn_RemoveSelected.setFont(new Font("Verdana", Font.BOLD, 13));
		btn_RemoveSelected.setBounds(32, 426, 227, 44);
		panel.add(btn_RemoveSelected);
		
		JButton btn_Confirm = new JButton("Confirmer");
		btn_Confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				louerControlleur.louer();
			}
		});
		btn_Confirm.setFont(new Font("Verdana", Font.BOLD, 13));
		btn_Confirm.setBounds(486, 373, 107, 44);
		panel.add(btn_Confirm);
	}
	
	public void clearList(){
		listModel.removeAllElements();
		listModel.clear();
		list.removeAll();
		list.setListData(listModel);
	}
	
	public void addFilm(String name){
		listModel.addElement(name);
		list.removeAll();
		list.setListData(listModel);
	}
	
	public void showErrorMessage(String string) {
		JOptionPane.showMessageDialog(null, string, "Erreur", JOptionPane.ERROR_MESSAGE);	
	}
}
