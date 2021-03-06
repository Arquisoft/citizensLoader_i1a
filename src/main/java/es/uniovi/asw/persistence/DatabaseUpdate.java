package es.uniovi.asw.persistence;

import java.io.IOException;

import es.uniovi.asw.model.User;

/**
 * Interface containing the template methods needed to update 
 * an user into the databse.
 * @author Diego
 */
public interface DatabaseUpdate {

	/**
	 * Checks if the users' data is all correct and adds them to the database.
	 * @param users List of users to be added.
	 * @param filename File's name to be written on.
	 * @throws IOException
	 */
	public void addToDatabase(User user, String filename) throws IOException;

	/**
	 * Checks if the parameter user already exists in the database.
	 * @param user To be checked
	 * @return True if the user exists in the database
	 */
	public boolean doesUserExist(User user);

	/**
	 * Checks if the user's data matches with its corresponding data 
	 * inside the database.
	 * @param user To be checked
	 * @return True if the user's data matches.
	 */
	public boolean doesUserMatch(User user);
}
