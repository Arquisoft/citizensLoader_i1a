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
		if (args.length == 0)
			System.out.println("You must pass as parameter the route of the excel file");
		else {
			final LoadUsers runner = new LoadUsers();
			runner.run(args);
		}
	}

	void run(String... args) {
		Reader r = ReaderFactory.getReader();
		/**DatabaseUpdate db = null;
		try {
			db = DatabaseFactory.getDBImpl();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		String filename = "src/test/resources/test.xlsx";
		Letter txt = new TxtLetter();
		List<User> list = r.readFile(filename);
		for (User u : list) {
			//db.addToDatabase(u, "generatedFiles/errors.txt");
			txt.write(u);
		}
		System.out.println("Los datos del fichero se han procesado.");
	}
}
