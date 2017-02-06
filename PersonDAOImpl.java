package com.models;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.entities.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {
	private Logger log = Logger.getLogger(PersonDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Person person;
	private List<Person> list = null;

	@Override
	public void addPerson(Person p) {
		log.debug("Enter into Add Person in Database...!");
		try {
			session = this.sessionFactory.getCurrentSession();
			session.save(p);
		} catch (Exception e) {
			log.debug(e.getMessage());
			e.printStackTrace();
		}
		log.debug("End of Adding Person...!");
	}

	@Override
	public void updatePerson(Person p) {
		log.debug("Enter into Updating Person in Database...!");
		try {
			session = this.sessionFactory.getCurrentSession();
			session.update(p);
		} catch (Exception e) {
			log.debug(e.getMessage());
			e.printStackTrace();
		}
		log.debug("End of Updating Person...!");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listPersons() {
		log.debug("Enter into Get List of Person...!");
		try {
			session = this.sessionFactory.getCurrentSession();
			list = session.createQuery(" from Person").list();
		} catch (Exception e) {
			log.debug(e.getMessage());
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Person getPersonById(int id) {
		log.debug("Enter into Get Person By ID...!");
		try {
			session = this.sessionFactory.getCurrentSession();
			person = session.load(Person.class, new Integer(id));
		} catch (Exception e) {
			log.debug(e.getMessage());
			e.printStackTrace();
		}
		return person;
	}

	@Override
	public void removePerson(int id) {
		log.debug("Enter into Remove Person from Database...!");
		try {
			session = this.sessionFactory.getCurrentSession();
			person = session.load(Person.class, new Integer(id));
			if (null != person) {
				session.delete(person);
			}
		} catch (Exception e) {
			log.debug(e.getMessage());
			e.printStackTrace();
		}
		log.debug("End of Removing Person...!");
	}
}