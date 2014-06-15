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

import javax.swing.JList;

import java.net.URI;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import controlleur.Facade;
import controlleur.RechercheFilmCont;
import modele.Film;
import modele.Annonce;
import modele.Genre;
import modele.Implication;
import modele.Pays;
import javax.swing.JScrollPane;


public class FicheFilm extends JFrame {

	private JPanel contentPane;
	
	private InformationPersonne infoPersonne;
	
	private RechercheFilmCont rechercheFilmCont;
	
	public class ItemJListImplication{
		private Implication implication;
		private String description;
		
		public ItemJListImplication(Implication implication, String descrition){
			this.implication = implication;
			this.description = descrition;
		}
		
		public Implication getImpilication(){
			return implication;
		}
		
		public String getDescription(){
			return description;
		}
		
		public String toString(){
			return description;
		}
	}
	
	/**
	 * Create the frame.
	 * @param rechercheFilmCont 
	 * @param film 
	 */
	public FicheFilm(final RechercheFilmCont rechercheFilmCont, final Film film) {
		this.rechercheFilmCont = rechercheFilmCont;
		setVisible(false);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	rechercheFilmCont.userClosedFicheFilm();
		    } 
		});
		setBounds(100, 50, 716, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Fiche Film");
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btn_initialiser = new JButton("Liste de recherche");
		btn_initialiser.setBounds(481, 504, 191, 44);
		btn_initialiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rechercheFilmCont.userClosedFicheFilm();
			}
		});
		btn_initialiser.setFont(new Font("Verdana", Font.BOLD, 13));
		
		Label label = new Label("Fiche Film");
		label.setBounds(0, 10, 700, 22);
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		label.setBackground(Color.BLUE);
		
		JButton btn_Annuler = new JButton("Annuler");
		btn_Annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rechercheFilmCont.userClosedFicheFilm();
			}
		});
		btn_Annuler.setBounds(589, 410, 107, 44);
		btn_Annuler.setFont(new Font("Verdana", Font.BOLD, 13));
		
		JButton btn_Rechercher = new JButton("Loyer");
		btn_Rechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rechercheFilmCont.addLoction(film);
			}
		});
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
		lbl_Titre_PaysProd.setBounds(41, 129, 124, 19);
		panel.add(lbl_Titre_PaysProd);
		
		JLabel lbl_Titre_langueOriginal = new JLabel("Langue originale :");
		lbl_Titre_langueOriginal.setBounds(41, 190, 107, 19);
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
		lblTitre.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblTitre.setBackground(SystemColor.inactiveCaption);
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
		
		JTextArea txt_Resume = new JTextArea(film.getResume());
		txt_Resume.setLineWrap(true);
		txt_Resume.setWrapStyleWord(true);
		txt_Resume.setBackground(SystemColor.inactiveCaption);
		txt_Resume.setBounds(164, 520, 230, 78);
		panel.add(txt_Resume);
		
		
		Vector<ItemJListImplication>listDesScenaristes = new Vector<ItemJListImplication>();
		Vector<ItemJListImplication>listDesRealisateur = new Vector<ItemJListImplication>();
		Vector<ItemJListImplication>listDesActeurs = new Vector<ItemJListImplication>();
		Vector<ItemJListImplication>listDesProducteur = new Vector<ItemJListImplication>();
		
		
		ArrayList<Implication> listImplication = new ArrayList<Implication>();
		listImplication.addAll(film.getImplications());
		
		for(Implication i : listImplication){
			if(i.getTypepersonne().getTypepersonne().equals("realisateur"))
				listDesRealisateur.add(new ItemJListImplication(i, i.getPersonne().getPrenom() + " " + i.getPersonne().getNom()));
			else if(i.getTypepersonne().getTypepersonne().equals("scenariste"))
				listDesScenaristes.add(new ItemJListImplication(i, i.getPersonne().getPrenom() + " " + i.getPersonne().getNom()));
			else if(i.getTypepersonne().getTypepersonne().equals("acteur"))
				listDesActeurs.add(new ItemJListImplication(i, i.getPersonne().getPrenom() + " " + i.getPersonne().getNom()));
			else if(i.getTypepersonne().getTypepersonne().equals("producteur"))
				listDesProducteur.add(new ItemJListImplication(i, i.getPersonne().getPrenom() + " " + i.getPersonne().getNom()));
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(164, 456, 230, 53);
		panel.add(scrollPane);
		
		final JList list_Acteurs = new JList(listDesActeurs);
		scrollPane.setViewportView(list_Acteurs);
		list_Acteurs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ItemJListImplication item = (ItemJListImplication)list_Acteurs.getSelectedValue();
				infoPersonne = new InformationPersonne(item.getImpilication());
				infoPersonne.setVisible(true);
			}
		});
		list_Acteurs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_Acteurs.setBackground(SystemColor.inactiveCaption);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(164, 392, 230, 53);
		panel.add(scrollPane_1);
		
		final JList list_Scenaristes = new JList(listDesScenaristes);
		scrollPane_1.setViewportView(list_Scenaristes);
		list_Scenaristes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ItemJListImplication item = (ItemJListImplication)list_Scenaristes.getSelectedValue();
				Implication imp = item.getImpilication();
				Facade.getFacade().initHibernateFilm(imp);
				infoPersonne = new InformationPersonne(imp);
				infoPersonne.setVisible(true);
			}
		});
		list_Scenaristes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_Scenaristes.setBackground(SystemColor.inactiveCaption);
		
		Vector<String>listDesGenre = new Vector<String>();
		ArrayList<Genre> listGenre = new ArrayList<Genre>();
		listGenre.addAll(film.getGenres());
		for(Genre g : listGenre){
			listDesGenre.add(g.getLibellegenre());
		}
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(164, 258, 230, 53);
		panel.add(scrollPane_3);
		JList list_Genres = new JList(listDesGenre);
		scrollPane_3.setViewportView(list_Genres);
		list_Genres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_Genres.setBackground(SystemColor.inactiveCaption);
		list_Genres.setAutoscrolls(true);
		
		Vector<String>listDesPays = new Vector<String>();
		ArrayList<Pays> listPays = new ArrayList<Pays>();
		listPays.addAll(film.getPayses());
		for(Pays p : listPays){
			listDesPays.add(p.getNompays());
		}
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(164, 120, 230, 53);
		panel.add(scrollPane_4);
		JList list_pays = new JList(listDesPays);
		scrollPane_4.setViewportView(list_pays);
		list_pays.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_pays.setBackground(SystemColor.inactiveCaption);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(164, 324, 230, 53);
		panel.add(scrollPane_2);
		
		final JList list_Realisateur = new JList(listDesRealisateur);
		scrollPane_2.setViewportView(list_Realisateur);
		list_Realisateur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ItemJListImplication item = (ItemJListImplication)list_Realisateur.getSelectedValue();
				infoPersonne = new InformationPersonne(item.getImpilication());
				infoPersonne.setVisible(true);
			}
		});
		list_Realisateur.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_Realisateur.setBackground(SystemColor.inactiveCaption);
		
		JButton btnImage = new JButton("Image");
		//http://stackoverflow.com/questions/10967451/open-a-link-in-browser-with-java-button
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
			    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			        try {
			            desktop.browse(URI.create(film.getImage()));
			        } catch (Exception ee) {
			            ee.printStackTrace();
			        }
			    }
			}
		});
		btnImage.setFont(new Font("Verdana", Font.BOLD, 13));
		btnImage.setBounds(445, 48, 124, 36);
		panel.add(btnImage);
		
		JLabel lblAnnounce = new JLabel("Announce :");
		lblAnnounce.setBounds(445, 131, 89, 14);
		panel.add(lblAnnounce);
		
		Vector<String>listDesAnnounce = new Vector<String>();
		ArrayList<Annonce> listAnnonce = new ArrayList<Annonce>();
		listAnnonce.addAll(film.getAnnonces());
		for(Annonce a : listAnnonce){
			listDesAnnounce.add(a.getAnnounce());
		}
		final JList list_Announce = new JList(listDesAnnounce);
		list_Announce.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_Announce.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
			    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE) && !list_Announce.isSelectionEmpty()) {
			        try {
			            desktop.browse(URI.create( (String)list_Announce.getSelectedValue() ));
			        } catch (Exception ee) {
			            ee.printStackTrace();
			        }
			    }
			}
		});
		list_Announce.setBackground(SystemColor.inactiveCaption);
		list_Announce.setBounds(445, 156, 211, 90);
		list_Announce.setAutoscrolls(true);
		panel.add(list_Announce);
		
	}
}
