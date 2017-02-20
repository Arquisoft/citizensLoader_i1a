package es.uniovi.asw.persistence;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import es.uniovi.asw.model.User;
import es.uniovi.asw.logger.Logger;

/**
 * An implementation of the DatabaseUpdate interface.
 * @author Diego
 *
 */
public class DatabaseUpdateImpl implements DatabaseUpdate {

	Logger logger = new Logger();

	@Override
	public void addToDatabase(List<User> users, String filename) throws IOException {
		EntityManager em = Jpa.getEntityManager();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		for (User u : users) {
			if(doesUserExist(u)) {
				logger.log(filename, "User " + u.getFirstName()
				+ " " + u.getLastName() + " already exists");
				if (!doesUserMatch(u)){
					logger.log(filename, "The user " + u.getFirstName()
					+ " " + u.getLastName() + " data in the "
							+ "database is different from the document");	
				}
			} else
				em.persist(u);
		}
		logger.close();
		trx.commit();
	}

	@Override
	public boolean doesUserExist(User user) {
		String query = "SELECT COUNT(u)"
				+ " FROM User u"
				+ " WHERE u.identification = ?1";
		Long result = (Long) Jpa.getEntityManager().createQuery(query)
		.setParameter(1, user.getIdentification())
		.getSingleResult();
		return result != 0;
	}

	@Override
	public boolean doesUserMatch(User user) {
		String query = "SELECT COUNT(u)"
				+ " FROM User u"
				+ " WHERE u.identification = ?1"
				+ " AND (c.firstName !=?2 OR"
				+ " u.lastName!=?3 OR"
				+ " u.Email !=?4 OR"
				+ " u.dateOfBirth!=?5 OR"
				+ " u.Address!=?6 OR"
				+ " u.Nationality!=?7";
		Long result = (Long) Jpa.getEntityManager().createQuery(query)
		.setParameter(1, user.getIdentification())
		.setParameter(2, user.getFirstName())
		.setParameter(3, user.getLastName())
		.setParameter(4, user.getEmail())
		.setParameter(5, user.getDateOfBirth())
		.setParameter(6, user.getAddress())
		.setParameter(7, user.getNationality())
		.getSingleResult();
		return result == 0;
	}

}
