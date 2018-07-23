package org.fusionsystems.amsprogtest;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.ToStringBuilder;
/**
 * 
 * Actual Implementation of requirement.
 * @author kenny.ho
 *
 */
public class PersonController {
	/**
	 * 
	 * Builder Object
	 * 
	 *
	 */
	public static class Builder {
		/**
		 * the data access object of person
		 * 
		 */
		private PersonDAO personDao;
		/**
		 * 
		 *  Sets Person DAO object.  
		 * 
		 * @param personDao
		 * @return builder object
		 */
		public Builder setdao(PersonDAO personDao) {
			this.personDao = personDao;
			return this;
		}
		/**
		 * 
		 *  Builds the result object. 
		 * 
		 * @return created object
		 */
		public PersonController build() {
			return new PersonController(this);
		}
	}
	/**
	 * 
	 * the data access object of person
	 * 
	 */
	private PersonDAO personDao;
	/**
	 * 
	 *  Creates new instance. 
	 *  @param builder builder object 
	 *  
	 */
	public PersonController(Builder builder) {
		personDao = builder.personDao;
		guardInvariants();
	}
	/**
	 * 
	 * Guards this object to be consistent. Throws exception if this is not the
	 * case.
	 * 
	 */
	private void guardInvariants()  {
		Validate.notNull(personDao);
	}
	/**
	 * 
	 * if age is more then 50, then first name cannot be John
	 * if gender is WOMAN, then first name must end with "ko"
	 * 
	 * @param name user 's Name
	 * @param age user 's age
	 * @param gender user 's gender
	 * 
	 * 
	 */
	public void addPerson(String name, int age, Gender gender) {

		Person person = null;

		person = new Person.Builder().setName(name).setAge(age).setGender(gender).build();

		if (person.getAge() > 50) {
			if (person.getName().toUpperCase().contains("JOHN")) {
				return;
			} else {
				if (person.getGender().equals(Gender.WOMAN))
					if (person.getFirstName().toUpperCase().endsWith("KO"))
						personDao.insert(person);
					else
						return;
				else
					personDao.insert(person);
			}

		} else {
			if (person.getGender().equals(Gender.WOMAN))
				if (person.getFirstName().toUpperCase().endsWith("KO"))
					personDao.insert(person);
				else
					return;
			else
				personDao.insert(person);
		}

	}
	/**
	 * find all people who has name which contains sub string equal to subname and return average of this age
	 * @param parm substring of name
	 * @return average of their age
	 */
	public Double calculateAverageAge(String parm) {
		return personDao.selectByName(parm).mapToInt(Person::getAge).average().orElse(0);

	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
