package es.uniovi.asw.persistence;

import java.io.IOException;

public class DatabaseFactory {
	
	public DatabaseUpdate getDBImpl() throws IOException {
		return new DatabaseUpdateImpl();
	}

}
