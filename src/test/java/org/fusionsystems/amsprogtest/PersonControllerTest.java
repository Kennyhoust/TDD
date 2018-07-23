package org.fusionsystems.amsprogtest;

import org.jmock.*;
import org.junit.Test;

import junit.framework.TestCase;
/** 
 * the test case for the requirement
 * 
 * . 
 * @author kenny.ho 
 */
public class PersonControllerTest extends TestCase {
	Mockery context;
	PersonDAO personDAO;
	PersonController personController;
	
	@Override
	protected void setUp() throws Exception {
		context = new Mockery();
		personDAO = context.mock(PersonDAO.class);

		personController = new PersonController.Builder().setdao(personDAO).build();
		

	}
	

	/**
	 * test the implementation of insert user.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testpersonController1()  {  

        final Person person = new Person.Builder().setName("John Seaman").setAge(55).setGender(Gender.MAN).build();
        
        // expectations
        context.checking(new Expectations() {{
        	never(personDAO).insert(person);
        }});

        // execute
        personController.addPerson(person.getName(),person.getAge(),person.getGender());
        
        // verify
        context.assertIsSatisfied();
	}
	@Test
	public void testpersonController2()  {  

        final Person person = new Person.Builder().setName("John Seaman").setAge(35).setGender(Gender.MAN).build();
        
        // expectations
        context.checking(new Expectations() {{
        	oneOf(personDAO).insert(person);
        }});

        // execute
        personController.addPerson(person.getName(),person.getAge(),person.getGender());
        
        // verify
        context.assertIsSatisfied();
	}
	@Test
	public void testpersonController3()  {  

        final Person person = new Person.Builder().setName("Tomoko Seaman").setAge(20).setGender(Gender.WOMAN).build();
        
        // expectations
        context.checking(new Expectations() {{
        	oneOf(personDAO).insert(person);
        }});

        // execute
        personController.addPerson(person.getName(),person.getAge(),person.getGender());
        
        // verify
        context.assertIsSatisfied();
	}
	@Test
	public void testpersonController4()  {  

        final Person person = new Person.Builder().setName("Caroline Seaman").setAge(20).setGender(Gender.WOMAN).build();
        
        // expectations
        context.checking(new Expectations() {{
        	never(personDAO).insert(person);
        }});

        // execute
        personController.addPerson(person.getName(),person.getAge(),person.getGender());
        
        // verify
        context.assertIsSatisfied();
	}
	@Test
	public void testpersonController5()  {  

        final Person person = new Person.Builder().setName("Caroline Seaman").setAge(60).setGender(Gender.WOMAN).build();
        
        // expectations
        context.checking(new Expectations() {{
        	never(personDAO).insert(person);
        }});

        // execute
        personController.addPerson(person.getName(),person.getAge(),person.getGender());
        
        // verify
        context.assertIsSatisfied();
	}
	@Test
	public void testpersonController6()  {  

        final Person person = new Person.Builder().setName("Caroline Seaman").setAge(60).setGender(Gender.MAN).build();
        
        // expectations
        context.checking(new Expectations() {{
        	oneOf(personDAO).insert(person);
        }});

        // execute
        personController.addPerson(person.getName(),person.getAge(),person.getGender());
        
        // verify
        context.assertIsSatisfied();
	}
	@Test
	public void testpersonController7()  {  

        final Person person = new Person.Builder().setName("Carolineko Seaman").setAge(60).setGender(Gender.WOMAN).build();
        
        // expectations
        context.checking(new Expectations() {{
        	oneOf(personDAO).insert(person);
        }});

        // execute
        personController.addPerson(person.getName(),person.getAge(),person.getGender());
        
        // verify
        context.assertIsSatisfied();
	}
	
	
	
	
	
	/**
	 *  the instantiation of person object
	 * 
	 * 
	 */
	
	@Test
	public void testpersonController8() {  
	    try {
	    	personController.addPerson("Car",60,Gender.MAN);
	        fail("expected exception was not occured.");
	    } catch(Exception e) {

	    }

	}
	@Test
	public void testpersonController9() {  
	    try {
	    	personController.addPerson(null,60,Gender.MAN);
	        fail("expected exception was not occured.");
	    } catch(Exception e) {

	    }
        	

	}
	@Test
	public void testpersonController10() {  
	    try {
	    	personController.addPerson("xxx xxx",60,Gender.MAN);
	        fail("expected exception was not occured.");
	    } catch(Exception e) {

	    }
        

	}	
	@Test
	public void testpersonController11()  {  
	    try {
	    	personController.addPerson("Carolineko Seaman",-1,Gender.MAN);
	        fail("expected exception was not occured.");
	    } catch(Exception e) {

	    }
        	

	}	
	@Test
	public void testpersonController12()  {  
	    try {
	    	personController.addPerson("aarolineko aeaman",0,Gender.MAN);
	        fail("expected exception was not occured.");
	    } catch(Exception e) {

	    }
        	

	}	
	@Test
	public void testpersonController13()  {  
	    try {
	    	personController.addPerson("Carolineko Seaman",0,null);
	        fail("expected exception was not occured.");
	    } catch(Exception e) {

	    }
	}	
	
	
	/**
	 * 
	 * test the average of user name with delegate substring
	 * 
	 * 
	 */
	@Test
	public void testpersonController14()  {  

		PersonController personController;
		PersonDAO personDAO = new PersonDAOImpl();
		personController = new PersonController.Builder().setdao(personDAO).build();
		personController.addPerson("John Seaman", 30, Gender.MAN);
		personController.addPerson("Peter Seaman", 40, Gender.MAN);
		personController.addPerson("Joko Uehara", 20, Gender.WOMAN);
		assertEquals(35.0d,personController.calculateAverageAge("Seaman"));
	}
	@Test
	public void testpersonController15()  {  

		PersonController personController;
		PersonDAO personDAO = new PersonDAOImpl();
		personController = new PersonController.Builder().setdao(personDAO).build();
		personController.addPerson("John Seaman", 30, Gender.MAN);
		personController.addPerson("Peter Seaman", 40, Gender.MAN);
		personController.addPerson("Joko Uehara", 20, Gender.WOMAN);
		assertEquals(25.0d,personController.calculateAverageAge("Jo"));
	}
	@Test
	public void testpersonController16()  {  

		PersonController personController;
		PersonDAO personDAO = new PersonDAOImpl();
		personController = new PersonController.Builder().setdao(personDAO).build();
		personController.addPerson("John Seaman", 30, Gender.MAN);
		personController.addPerson("Peter Seaman", 40, Gender.MAN);
		personController.addPerson("Joko Uehara", 20, Gender.WOMAN);
		assertEquals(30.0d,personController.calculateAverageAge("e"));
	}
	@Test
	public void testpersonController17()  {  

		PersonController personController;
		PersonDAO personDAO = new PersonDAOImpl();
		personController = new PersonController.Builder().setdao(personDAO).build();
		assertEquals(0.0d,personController.calculateAverageAge("e"));
	}
	@Test
	public void testpersonController18()  {  

		PersonController personController;
		PersonDAO personDAO = new PersonDAOImpl();
		personController = new PersonController.Builder().setdao(personDAO).build();
		personController.addPerson("John Seaman", 30, Gender.MAN);
		personController.addPerson("Peter Seaman", 40, Gender.MAN);
		personController.addPerson("Joko Uehara", 20, Gender.WOMAN);
		assertEquals(30.0d,personController.calculateAverageAge(""));
	}
	@Test
	public void testpersonController19()  {  

		PersonController personController;
		PersonDAO personDAO = new PersonDAOImpl();
		personController = new PersonController.Builder().setdao(personDAO).build();
		personController.addPerson("John Seaman", 30, Gender.MAN);
		personController.addPerson("Peter Seaman", 40, Gender.MAN);
		personController.addPerson("Joko Uehara", 20, Gender.WOMAN);
		assertEquals(30.0d,personController.calculateAverageAge(" "));
	}
	@Test
	public void testpersonController20()  {  

		PersonController personController;
		PersonDAO personDAO = new PersonDAOImpl();
		personController = new PersonController.Builder().setdao(personDAO).build();
		assertEquals(0.0d,personController.calculateAverageAge(""));
	}
}
