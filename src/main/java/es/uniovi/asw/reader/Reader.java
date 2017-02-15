package es.uniovi.asw.reader;

import java.util.List;

import es.uniovi.asw.model.User;

public interface Reader {

	public List<User> readFile(String path);
}
