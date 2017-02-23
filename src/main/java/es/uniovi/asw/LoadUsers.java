package es.uniovi.asw;

import java.io.IOException;
import java.util.List;

import es.uniovi.asw.letter.Letter;
import es.uniovi.asw.letter.TxtLetter;
import es.uniovi.asw.model.User;
import es.uniovi.asw.persistence.DatabaseFactory;
import es.uniovi.asw.persistence.DatabaseUpdate;
import es.uniovi.asw.reader.Reader;
import es.uniovi.asw.reader.ReaderFactory;

/**
 * Main application
 * 
 * @author Labra
 *
 */
public class LoadUsers {

	public static void main(String... args) {
		final LoadUsers runner = new LoadUsers();
		
		if (args.length == 0) {
			System.out.println("Proceeding to parse the default file. "
					+ "If you want to specify other pass it as a parameter");
			runner.run("src/test/resources/test.xlsx");
		}
		else {
			runner.run(args);
		}	
		
	}

	public void run(String... args) {
		Reader r = ReaderFactory.getReader();
		/**DatabaseUpdate db = null;
		try {
			db = DatabaseFactory.getDBImpl();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		String filename = args[0];
		Letter txt = new TxtLetter();
		List<User> list = r.readFile(filename);
		for (User u : list) {
			//db.addToDatabase(u, "generatedFiles/errors.txt");
			txt.write(u);
		}
		System.out.println("Los datos del fichero se han procesado.");
	}
}
