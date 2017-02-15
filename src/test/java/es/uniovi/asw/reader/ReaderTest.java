package es.uniovi.asw.reader;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import es.uniovi.asw.model.User;

public class ReaderTest {

	@Test
	public void extremelyBasicTest() {
		Reader reader = ReaderFactory.getFooReader();
		String path = "src/test/resources/test.xlsx";
		List<User> users = reader.readFile(path);
		
		assertTrue(users.size() == 3);
		
		User juan = users.get(0);
		assertEquals("Juan", juan.getFirstName());
		assertEquals("Torres Pardo", juan.getLastName());
		assertEquals("juan@example.com", juan.getEmail());
		assertEquals("1985-10-10", juan.getAddress());
		assertEquals("C/ Federico García Lorca 2", juan.getAddress());
		assertEquals("Español", juan.getNationality());
		assertEquals("90500084Y", juan.getDNI());
	}

}
