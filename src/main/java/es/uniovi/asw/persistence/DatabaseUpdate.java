package es.uniovi.asw.persistence;

import java.io.IOException;
import java.util.List;

import es.uniovi.asw.model.User;

public interface DatabaseUpdate {

	public void addToDatabase(List<User> users, String filename) throws IOException;
	public boolean doesUserExist(User user);
	public boolean doesUserMatch(User user);
}
