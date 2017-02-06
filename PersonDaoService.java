package com.services;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.entities.Person;
import com.models.PersonDAO;

@Service
public class PersonDaoService {
	private Logger log = Logger.getLogger(PersonDaoService.class);
	@Autowired
	private PersonDAO personDao;

	@Transactional
	public void addPerson(Person p) {
		log.debug("Add Person Transaction Started...!");
		this.personDao.addPerson(p);
		log.debug("Add Person Transaction Completed...!");
	}

	@Transactional
	public void updatePerson(Person p) {
		log.debug("Update Person Transaction Started...!");
		this.personDao.updatePerson(p);
		log.debug("Update Person Transaction Started...!");
	}

	@Transactional
	public List<Person> listPersons() {
		log.debug("Get Person List Transaction is in Process...!");
		return this.personDao.listPersons();
	}

	@Transactional
	public Person getPersonById(int id) {
		log.debug("Get Person By ID Transaction is in Process...!");
		return this.personDao.getPersonById(id);
	}

	@Transactional
	public void removePerson(int id) {
		log.debug("Remove Person Transaction Started...!");
		this.personDao.removePerson(id);
		log.debug("Remove Person Transaction Started...!");
	}
}