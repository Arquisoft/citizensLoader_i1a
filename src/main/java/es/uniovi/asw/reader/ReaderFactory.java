package es.uniovi.asw.reader;

import java.util.List;

import es.uniovi.asw.model.User;

public class ReaderFactory {
	public static Reader getFooReader() {
		return new Reader() {
			@Override
			public List<User> readFile(String path) {
				throw new RuntimeException("No class existent yet");
			}
		};
	}
}
