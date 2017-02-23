package es.uniovi.asw.letter;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.model.User;

public class LetterTest {

	private Letter letter;
	private User user;
	
	@Before
	public void setUp() throws Exception {
		letter = new TxtLetter();
		user = new User("name", "lastName", "email", new Date(), "address", "nationality", "1");
	}

	@Test
	public void testWrite() {
		letter.write(user);
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader("generatedFiles/1.txt"));
			String line = bf.readLine();
			assertTrue(line.equals("Su registro se ha procesado con éxito. "
					+ "Procederemos a enviarle un correo. Su correo es: " + user.getEmail()
					+ " y su contraseña: " + user.getPassword())
				);
			bf.close();
			
		} catch (FileNotFoundException e) {
			assertTrue(false);
			System.out.println("No se encontró el archivo");
		} catch (IOException e) {
			assertTrue(false);
			System.out.println("Ha habido un problema leyendo del archivo");
		}
	}

}
