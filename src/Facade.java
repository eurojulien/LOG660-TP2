
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;

public class Facade<T> {

	private static Session session;
	private static Transaction transaction;
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	
	public static Facade facade = null;
	
	private Facade(){
		
		try{
			Configuration configuration = new Configuration();
			configuration.configure();
			serviceRegistry 			= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory 				= configuration.buildSessionFactory(serviceRegistry);
		}

		catch(Throwable ex){
			System.err.println("L'initialisation de SessionFactory a echouee : " + ex);
			System.err.println("MESSAGE : " + ex.getMessage());
			System.err.println("CAUSE   : " + ex.getCause());
			System.err.println("TEST    : " + ex.getStackTrace());
		}
		session		= null;
		transaction	= null;
	}
	
	/*
	 * Demarre une session/Transaction avant une action avec la base de donnees
	 */
	private void beginTransaction(){
		session = sessionFactory.openSession();
		transaction	= session.beginTransaction();
	}
	
	/*
	 * Ferme une session/Transaction apres une action avec la base de donnees
	 */
	private void endTransaction(){
		session.close();
		transaction = null;
	}
	
	public static Facade getFacade(){
		
		if(facade == null){
			facade = new Facade();
		}
		
		return facade;
	}
	
	/*
	 * Ajoute un forfait
	 * 
	 * String idForfait
	 * String nom
	 * BigDecimal coutForfait
	 * BigDecimal locationMax
	 * BigDecimal dureeMax
	 * 
	*/
	public void addForfait(String... parameters){
		
		try {
			
			beginTransaction();
			
			Forfait forfait = new Forfait(
											true,
											parameters[1],
											new BigDecimal(parameters[2]),
											new BigDecimal(parameters[3]),
											new BigDecimal(parameters[4])
										);
			session.save(forfait);
			transaction.commit();
		}
		catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}
		
		finally{
			endTransaction();
		}
	}
	
	/*
	 * Retourne un forfait
	 */
	public Forfait getForfait(String id){
		
		Forfait forfait = null;
		
		try{
			beginTransaction();
			
			forfait = (Forfait) session.get(Forfait.class, id);
			transaction.commit();
		}
		
		catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}
		
		finally{
			endTransaction();
		}
		
		return forfait;
	}
	
	/*
	 * Ajoute un utilisateur
	 * 
	 * 	BigDecimal idutilisateur, String nomfamille,
		String prenom, String utilisateurtype, String telephone,
		String courriel, BigDecimal numerocivique, String rue,
		String ville, String province, String codepostal,
		Date datenaissance, String identificateur, String motdepasse) {
	 */
	public void addUser(String... parameters){
		
		try {
			beginTransaction();
			
			Utilisateur utilisateur = new Utilisateur(
												new BigDecimal(parameters[0]),	// id
												parameters[1],					// nom
												parameters[2],					// prenom
												parameters[3],					// userType
												parameters[4],					// telephone
												parameters[5],					// courriel
												new BigDecimal(parameters[6]),	// numero civique
												parameters[7],					// rue
												parameters[8],					// ville
												parameters[9],					// province
												parameters[10],					// codepostal
												new SimpleDateFormat("yyyy/mm/dd").parse(parameters[11]),		// datenaissance
												parameters[12],					// login
												parameters[13]					// motdepasse
												
										);
			
			session.save(utilisateur);
			transaction.commit();
		}
		catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			endTransaction();
		}
	}
	
	public Utilisateur identifyUser(String login, String password){
		
	}
	
	public Film getFilm(String id){
		
		Film film = null;
		
		try{
			beginTransaction();
			
			film = (Film) session.get(Film.class, new BigDecimal(id));
			transaction.commit();
			
		}
		catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}
		
		finally{
			endTransaction();
		}
		
		return film;
	}
	
	// Accesseurs de liste ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	/*
	 * Liste des films
	 */
	public ArrayList<Film> getFilms(){
		
		ArrayList<Film> list = new ArrayList<Film>();
		
		try{
			beginTransaction();
			list		= (ArrayList<Film>) session.createCriteria(Film.class).list();
			transaction.commit();
			
		}
		catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}
		
		finally{
			endTransaction();
		}
		
		return list;
	}
	
	/*
	 * Liste des utilisateurs
	 */
	public ArrayList<Utilisateur> getUtilisateurs(){
		
		ArrayList<Utilisateur> list = new ArrayList<Utilisateur>();
		
		try{
			beginTransaction();
			
			list		= (ArrayList<Utilisateur>) session.createCriteria(Utilisateur.class).list();
			transaction.commit();
			
		}
		catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}
		
		finally{
			endTransaction();
		}
		
		return list;
	}
	
	/*
	 * Liste des exemplaires
	 */
	public ArrayList<Exemplaire> getExemplaires(){
		
		ArrayList<Exemplaire> list = new ArrayList<Exemplaire>();
		
		try{
			beginTransaction();
			
			list		= (ArrayList<Exemplaire>) session.createCriteria(Exemplaire.class).list();
			transaction.commit();
			
		}
		catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}
		
		finally{
			endTransaction();
		}
		
		return list;
	}
	
	/*
	 * Liste des genres
	 */
	public ArrayList<Genre> getGenres(){
		
		ArrayList<Genre> list = new ArrayList<Genre>();
		
		try{
			beginTransaction();
			list		= (ArrayList<Genre>) session.createCriteria(Genre.class).list();
			transaction.commit();
			
		}
		catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}
		
		finally{
			endTransaction();
		}
		
		return list;
	}
	
	/*
	 * Liste des personnes
	 */
	public ArrayList<Personne> getPersonnes(){
		
		ArrayList<Personne> list = new ArrayList<Personne>();
		
		try{
			beginTransaction();
			list		= (ArrayList<Personne>) session.createCriteria(Personne.class).list();
			transaction.commit();
			
		}
		catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}
		
		finally{
			endTransaction();
		}
		
		return list;
	}
	
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
}