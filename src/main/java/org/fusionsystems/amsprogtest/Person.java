package org.fusionsystems.amsprogtest;

import java.util.Arrays;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.*;

/**
 * 
 * Object which defines the status of the individual. Please see how the
 * properties are handled and validated.
 * 
 * @author kenny.ho
 * 
 */
public class Person {
	/**
	 * 
	 * Builder object.
	 *
	 */
	public static class Builder {
		/**
		 * 
		 * user name
		 * 
		 */
		private String name;
		/**
		 * 
		 * user 's age
		 * 
		 */
		private int age;
		/**
		 * 
		 * user 's gender
		 * 
		 */
		private Gender gender;

		/**
		 * 
		 *  Sets user's name.  
		 *  @param name name
		 *  @return this instance
		 *  
		 */
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		/**
		 * 
		 *  Sets user's age.  
		 *  @param age age
		 *  @return this instance
		 *  
		 */
		public Builder setAge(int age) {
			this.age = age;
			return this;
		}
		/**
		 * 
		 *  Sets user's gender.  
		 *  @param gender gender
		 *  @return this instance
		 *  
		 */
		public Builder setGender(Gender gender) {
			this.gender = gender;
			return this;
		}

		/**
		 * 
		 *  Builds the result object. 
		 * 
		 * @return created object
		 */
		public Person build() {
			return new Person(this);
		}
	}

	/**
	 * 
	 * User name 
	 * name[0] is first name
	 * name[1] is last name
	 * 
	 */
	private String[] name;

	/**
	 * 
	 * user age
	 * 
	 */
	private int age;
	/**
	 * 
	 * user gender
	 * 
	 */
	private Gender gender;

	/**
	 * 
	 *  Creates new instance. 
	 *  @param builder builder object 
	 *  
	 */
	public Person(Builder builder) {
		Validate.notNull(builder.name, "Name cannot be null");
		name = builder.name.split(" ");
		age = builder.age;
		gender = builder.gender;
		guardInvariants();
	}
	/**
	 * 
	 * Guards this object to be consistent. Throws exception if this is not the
	 * case.
	 * 
	 */
	private void guardInvariants() {

		Validate.validState(name.length == 2, Arrays.toString(name) + " do not a valid name");
		Validate.notEmpty(name[0]);
		Validate.notEmpty(name[1]);
		Validate.notNull(name[0]);
		Validate.notNull(name[1]);
		
		Validate.validState(Character.isUpperCase(name[0].charAt(0)), "first Name is wrong format");
		Validate.validState(Character.isUpperCase(name[1].charAt(0)), "last Name is wrong format");

		Validate.isTrue(age >= 0, "Age must be larger than 0");

		Validate.isTrue(gender != null, "gender cannot null");
	}


    /**    
     *  Returns the user's full name.
     *      
     *  @return user's names    
     *  
     */
	public String getName() {
		return name[0] + " " + name[1];
	}
    /**    
     *  Returns the user's first name.
     *      
     *  @return user's first names    
     *  
     */
	public String getFirstName() {
		return name[0];
	}
    /**    
     *  Returns the user's age.
     *      
     *  @return user's age    
     *  
     */
	public int getAge() {
		return age;
	}
    /**    
     *  Returns the user's gender.
     *      
     *  @return user's gender    
     *  
     */
	public Gender getGender() {
		return gender;
	}
	
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
