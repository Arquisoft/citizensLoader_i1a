package es.uniovi.asw;

import java.util.List;
import java.util.logging.Logger;

import es.uniovi.asw.model.User;
import es.uniovi.asw.reader.Reader;
import es.uniovi.asw.reader.ReaderImpl;

/**
 * Main application
 * 
 * @author Labra
 *
 */
public class LoadUsers {

	public static void main(String... args) {
		final LoadUsers runner = new LoadUsers();
		runner.run(args);
	}

	// TODO
	void run(String... args) {
		Reader r = new ReaderImpl();
		List<User> list = r.readFile("src/test/resources/test.xlsx");
		for(User u : list)
			System.out.println(u.toString());
	}
}
