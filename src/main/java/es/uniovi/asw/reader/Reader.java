package es.uniovi.asw.reader;

import java.util.List;

import es.uniovi.asw.model.User;

/**
 * Interface for Reader implementations 
 * @author Pabloski
 *
 */
public interface Reader {

	public List<User> readFile(String path);
}
