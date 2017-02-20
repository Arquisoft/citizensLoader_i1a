package es.uniovi.asw.letter;

import java.io.*;

import es.uniovi.asw.model.User;

/**
 * An implementation of the Letter interface. It writes the content 
 * in a simple txt file.
 * @author Diego
 */
public class TxtLetter implements Letter {

	@Override
	public void write(User u) {
		BufferedWriter file;
		String filename = "generatedFiles/"+u.getIdentification()+".txt";
		try {
			file = new BufferedWriter(new FileWriter(filename));
			file.write("Su registro se ha procesado con éxito."
					+ " Procederemos a enviarle un correo. Su correo es: "
			        + u.getEmail()+ " y su contraseña: "+u.getPassword());
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
