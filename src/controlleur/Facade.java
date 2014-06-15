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

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.math.BigDecimal;

public class Facade<T> {

	private static Session session;
	//private static Transaction transaction;
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	
	public static Facade facade = null;
	
	private Facade(){
		
		try{
			Configuration configuration = new Configuration();
			configuration.configure();
			serviceRegistry 			= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory 				= configuration.buildSessionFactory(serviceRegistry);
			session 					= sessionFactory.openSession();

		}

		catch(Throwable ex){
			System.err.println("L'initialisation de SessionFactory a echouee ...");
			System.err.println("MESSAGE : " + ex.getMessage());
			System.err.println("CAUSE   : " + ex.getCause());
		}
		
	}
	
	/*
	 * Demarre une session/Transaction avant une action avec la base de donnees
	 */
	/*private void beginTransaction(){
		//session = sessionFactory.openSession();
		//transaction	= session.beginTransaction();
		session.beginTransaction();
	}/*
	
	/*
	 * Ferme une session/Transaction apres une action avec la base de donnees
	 */
	/*private void endTransaction(){
		//transaction = null;
		//session.close();
		session.getTransaction().commit();
	}*/
	
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
	 * Sauvegarde ou met a jour tout objet !
	 */
	public void saveOrUpdateObject(Class<T> classType, Object object){
		try{
			session.beginTransaction();
			session.saveOrUpdate((T) object);
			session.getTransaction().commit();
		}
		catch(HibernateException e){
			session.getTransaction().rollback();
			System.out.println("ERREUR DURANT LA SAUVEGARDE (" + classType + ") : " + e);
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
			session.beginTransaction();
			for (int i = 0; i < parameters.length; i++){
				sqlQuery += " " + parameters[i];
				if(i < parameters.length - 1){
					sqlQuery += " and";
				}
			}
			
			Query query = session.createQuery(sqlQuery);
			objects = (List<T>) query.list();
			session.getTransaction().commit();
		}
		
		catch(HibernateException e){
			session.getTransaction().rollback();
			System.out.println("ERREUR DURANT LA RECUPERATION (" + classType + ", SQL : " + sqlQuery + ") : " + e);
		}
		
		
		return objects;
	}
	
	/*
	 * Retourne la liste de tous les objets
	 */
	public List<T> getAllObjects(Class<T> classType){
		
		List<T> objects = null;
		
		try{
			session.beginTransaction();
			objects = (List<T>) session.createCriteria(classType).list();
			session.getTransaction().commit();
		}
		
		catch(HibernateException e){
			session.getTransaction().rollback();
			System.out.println("ERREUR DURANT LES RECUPERATIONS (" + classType + ") : " + e);
		}
		
		return objects;
	}
	
	public ArrayList<String> normalSQLSelect(String queryString){
		ArrayList<String> results = new ArrayList<String>();
		
		Query query = session.createSQLQuery(queryString);
		results = (ArrayList<String>) query.list();
		
		return results;
	}
	
	public void closeSessionForExit(){
		session.close();
		sessionFactory.close();
	}
	
	public void initHibernateFilm(Object o){
		try{
			Hibernate.initialize(o);
		}
		catch(HibernateException e){
			System.out.println("ERREUR DURANT LES RECUPERATIONS (avec Hibernate.initlize) : " + e);
		}
		
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