package es.uniovi.asw.persistence;

import java.io.IOException;

/**
 * Simple class used to access the implementation of the 
 * database updater.
 * @author Diego
 */
public class DatabaseFactory {
	
	/**
	 * Returns an implementation of the DatabaseUpdate interface
	 * in order to perform the necessary persistence operations.
	 * @return
	 * @throws IOException
	 */
	public DatabaseUpdate getDBImpl() throws IOException {
		return new DatabaseUpdateImpl();
	}

}
