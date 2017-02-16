package es.uniovi.asw.reader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import es.uniovi.asw.model.User;

public class UserBuilder {

	// Creates a user quickly.
	// Holly shit, that beautiful amount of parameters.
	protected static User newUser(String firstName, String lastName,
			String email, String dateOfBirthStr, String address,
			String nationality, String identification) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOfBirth;
		try {
			dateOfBirth = format.parse(dateOfBirthStr);
		} catch (ParseException e) {
			throw new RuntimeException(
					"Bad date string [" + dateOfBirthStr + "]. "
							+ "Contact Pablo García Ledo UO245120 or fix it yourself. "
							+ "I'm sorry :(");
		}

		User result = new User(identification);
		result.setFirstName(firstName);
		result.setLastName(lastName);
		result.setEmail(email);
		result.setDateOfBirth(dateOfBirth);
		result.setAddress(address);
		result.setNationality(nationality);

		return result;
	}
}
