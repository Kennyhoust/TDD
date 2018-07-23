package org.fusionsystems.amsprogtest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
/**
 * 
 * This Implementaion of Person DAO functionality
 * @author kenny.ho
 *
 */
public class PersonDAOImpl implements PersonDAO {
	private List<Person> list = new ArrayList<Person>();
	/**
	 * 
	 * inserts new Person
	 * @param person
	 * 
	 */
	@Override
	public void insert(Person person) {
		list.add(person);
	}
	/**
	 * 
	 * find all people who has name which contains sub string equal to subname
	 * @param parm substring of user full name
	 * @return stream of person which user name contain substring
	 * 
	 */
	@Override
	public Stream<Person> selectByName(String parm) {
		return list.stream().filter(person -> person.getName().contains(parm));
	}
}
