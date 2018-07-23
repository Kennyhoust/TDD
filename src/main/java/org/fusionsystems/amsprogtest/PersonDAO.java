package org.fusionsystems.amsprogtest;

import java.util.stream.Stream;
/**
 * 
 * This interface defines Person DAO functionality
 * @author kenny.ho
 *
 */
public interface PersonDAO {
	/**
	 * 
	 * inserts new Person
	 * @param person
	 * 
	 */
	
	public void insert(Person person);
	/**
	 * 
	 * find all people who has name which contains sub string equal to subname
	 * @param parm substring of user full name
	 * @return stream of person which user name contain substring
	 * 
	 */
	public Stream<Person> selectByName(String parm);

}
