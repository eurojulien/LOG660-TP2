package controlleur;

import modele.*;

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
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
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
			System.err.println("L'initialisation de SessionFactory a echouee ...");
			System.err.println("MESSAGE : " + ex.getMessage());
			System.err.println("CAUSE   : " + ex.getCause());
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
	
	/*
	 * Singleton concept
	 */
	public static Facade getFacade(){
		
		if(facade == null){
			facade = new Facade();
		}
		
		return facade;
	}
	
	/*
	 * Sauvegarde tout objet !
	 */
	public void saveObject( Class<T> classType, Object object){
		try{
			beginTransaction();
			session.save((T) object);
		}
		catch(HibernateException e){
			transaction.rollback();
			System.out.println("ERREUR DURANT LA SAUVEGARDE (" + classType + ") : " + e);
		}
		finally{
			endTransaction();
		}
	}
	
	/*
	 * Met a jour tout objet !
	 */
	public void updateObject( Class<T> classType, Object object){
		try{
			beginTransaction();
			session.update((T) object);
		}
		catch(HibernateException e){
			transaction.rollback();
			System.out.println("ERREUR DURANT LA MISE A JOUR (" + classType + ") : " + e);
		}
		finally{
			endTransaction();
		}
	}
	
	/*
	 * classType : Type de la classe
	 * parameters : idFilm = '12131' ... par exemple
	 * */
	public List<T> getObjects(Class<T> classType, String... parameters){
		
		List<T> objects = null;
		String sqlQuery = "from " + classType.getCanonicalName() + " where";
		try{
			beginTransaction();
			
			for (int i = 0; i < parameters.length; i++){
				sqlQuery += " " + parameters[i];
				if(i < parameters.length - 1){
					sqlQuery += " and";
				}
			}
			
			Query query = session.createQuery(sqlQuery);
			objects = (List<T>) query.list();
			transaction.commit();
		}
		
		catch(HibernateException e){
			transaction.rollback();
			System.out.println("ERREUR DURANT LA RECUPERATION (" + classType + ", SQL : " + sqlQuery + ") : " + e);
		}
		
		finally{
			endTransaction();
		}
		
		return objects;
	}
	
	/*
	 * Retourne la liste de tous les objets
	 */
	public List<T> getAllObjects(Class<T> classType){
		
		List<T> objects = null;
		
		try{
			beginTransaction();
			objects = (List<T>) session.createCriteria(classType).list();
			transaction.commit();
		}
		
		catch(HibernateException e){
			transaction.rollback();
			System.out.println("ERREUR DURANT LES RECUPERATIONS (" + classType + ") : " + e);
		}
		
		finally{
			endTransaction();
		}
		
		return objects;
	}
	
	public void closeSessionForExit(){
		sessionFactory.close();
	}
	
	
	/*public ArrayList<Film> getFilms(String... parameters){

		ArrayList<Film> films = null;
		String sql =	"SELECT " + 
		  				"Film.idfilm, " +  
		  				"Film.titre, " + 
		  				"Film.anneesortie, " + 
		  				"Film.Langue, " +
		  				"Film.duree, " + 
		  				"Film.resume, " +
		  				"Film.image " +
		  				"FROM " +
		  				"Film inner join FILMPAYS on Film.IDFILM = FILMPAYS.IDFILM " +
		  				"inner join Pays on PAYS.IDPAYS = FILMPAYS.IDPAYS " +
		  				"inner join FILMGENRE on Film.IDFILM = FILMGENRE.IDFILM " +
		  				"inner join GENRE on FILMGENRE.IDGENRE = GENRE.IDGENRE " +
		  				"inner join IMPLICATION on FILM.IDFILM = IMPLICATION.IDFILM " +
		  				"inner join PERSONNE on IMPLICATION.IDPERSONNE = PERSONNE.IDPERSONNE " +
		  				"inner join TYPEPERSONNE on IMPLICATION.IDTYPEPERSONNE = TYPEPERSONNE.IDTYPEPERSONNE " +
		  				//"WHERE " +
		  				//"Film.Titre like 'The' " +
		  				"GROUP BY Film.idFilm " +
		  				"ORDER BY Film.titre ASC ;";
 
		
		
		try{
			beginTransaction();
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Film.class);
			
			/*
			Query query = session.createQuery("from VueFilm where " +
					  						  "titre like :title " +
					  						  "film.anneesortie >= :beginDate and " +
					  						  "film.anneesortie >= :endDate and " +
					  						  "langue = :language and " + 
					  						  "Pays.nompays = :country and " +
					  						  "genre.libellegenre = :gender and " +
					  						  "nompersonne >= :name " +
					  						  "group by idfilm " +
					  						  "order by titre ASC");
			
			// pays, genre, nom realisateur, nom acteur
			
			if(parameters.length >= 1 ) query.setParameter("title", parameters[0]);
			if(parameters.length >= 2 ) query.setParameter("beginDate", parameters[1]);
			if(parameters.length >= 3 ) query.setParameter("endDate", parameters[2]);
			if(parameters.length >= 4 ) query.setParameter("langue", parameters[3]);
			if(parameters.length >= 5 ) query.setParameter("pays", parameters[4]);
			if(parameters.length >= 6 ) query.setParameter("gender", parameters[5]);
			if(parameters.length >= 7 ) query.setParameter("name", parameters[6]);
			
			films = (ArrayList<Film>) query.list();
			
		}
		catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}
		
		finally{
			endTransaction();
		}
		
		return films;
	} */
}