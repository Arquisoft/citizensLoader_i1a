package es.uniovi.asw.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.LoadUsers;
import es.uniovi.asw.model.User;

/**
 * Test for the insertion of users in the database
 * (and 2 auxiliary mathods used for that purpose)
 * @author Dani
 */
public class DatabaseTest {

	private User u1, u2;
	private DatabaseUpdate dbimp;
	private String file = "src/test/resources/dbtest.txt";

	@Before
	public void setUp() {
		u1 = new User("name", "lastName", "email", new Date(), "address", "nationality", "1");
		u2 = new User("name2", "lastName2", "email2", new Date(), "address2", "nationality2", "2");
		try {
			dbimp = DatabaseFactory.getDBImpl();
		} catch (IOException e) {
		}
	} 
	
	@Test
	public void test(){}

	/**
	 * Test the insertion of a list of users in the database
	 * @throws IOException 
	 */
/**	@Test
	public void testAddToDatabase() throws IOException {
		List<User> list = new ArrayList<User>();
		list.add(u1); list.add(u2);
		
		System.out.println("HAI");
		try {
			dbimp.addToDatabase(u1, file);
			dbimp.addToDatabase(u2, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		EntityManager map = Jpa.getEntityManager();
		EntityTransaction trx = map.getTransaction();
		trx.begin();
		
		User u = map.find(User.class, u1.getId());
		assertNotNull(u);
		assertEquals(u.getIdentification(), u1.getIdentification());
		
		map.remove(u);
		
		u = map.find(User.class, u2.getId());
		assertNotNull(u);
		assertEquals(u.getIdentification(), u2.getIdentification());
		
		map.remove(u);
		
		trx.commit();
	}*/

	/**
	 * Test if a user exists in the database
	 * @throws IOException 
	 */
 /**   @Test
	public void testDoesUserExist() throws IOException {		
		EntityManager map = Jpa.getEntityManager();
		EntityTransaction trx = map.getTransaction();
		trx.begin();
		map.persist(u1);
		map.persist(u2);
		trx.commit();
		
		dbimp = DatabaseFactory.getDBImpl();
		assertTrue(dbimp.doesUserExist(u1));
		assertTrue(dbimp.doesUserExist(u2));
		
		trx.begin();
		map.remove(u1);
		trx.commit();
		
		assertTrue(!dbimp.doesUserExist(u1));
		assertTrue(dbimp.doesUserExist(u2));
		
		trx.begin();		
		map.remove(u1);
		trx.commit();
		
		assertTrue(!dbimp.doesUserExist(u1));
		assertTrue(!dbimp.doesUserExist(u2));
	}*/

	/**
	   * Test if a user matches other user in the database
	   * @throws IOException 
	   */
/**	  @Test
	  public void testDoesUserMatch() throws IOException {
	    EntityManager map = Jpa.getEntityManager();
	    EntityTransaction trx = map.getTransaction();
	    trx.begin();
	    map.persist(u1);
	    map.persist(u2);
	    trx.commit();
	    
	    dbimp = DatabaseFactory.getDBImpl();
	    assertTrue(dbimp.doesUserMatch(u1));
	    assertTrue(dbimp.doesUserMatch(u2));
	    
	    trx.begin();
	    User user = map.find(User.class, u1.getId());
	    map.remove(user);
	    
	    user = map.find(User.class, u2.getId());
	    map.remove(user);
	    trx.commit();
	  }*/
	  
	  @Test
	  public void loadUsersTest() {
		  LoadUsers l = new LoadUsers();
		  LoadUsers.main();
	  }
	 
}
