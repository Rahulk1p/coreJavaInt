package com.ars.overview;

import java.util.HashSet;
import java.util.Set;

/**
 * What will happen if we not override the hashCode and equals method of POJO?
 * 
 * @author rksck
 *
 */
public class Question3 {

	public static void main(String[] args) {
		/*
		 * Below method is not able to search the person because POJO does not 
		 * override the equals and hashCode method and depend on default
		 * Object class equals and hashCode method which will not give expected result as
		 * Object class equals method return true if both object refer to same memory location.
		 */
		searchPersonDoesNotHaveEqualsAndHashCodeMethodOverridden();
		
		/*
		 * Below method is  able to search the person because POJO  
		 * override the equals and hashCode method and does not depend on default
		 * Object class equals and hashCode method which will not give expected result as
		 * Object class equals method return true if both object refer to same memory location.
		 */
		searchPersonHaveEqualsAndHashCodeMethodOverridden();
		
	}
	
	public static void searchPersonDoesNotHaveEqualsAndHashCodeMethodOverridden() {
		/*
		 * Declaring the Person Set instance variable
		 */
		Set<Person> persons = new HashSet<Person>();

		/*
		 * Initializing the Person Set instance variable
		 */
		persons.add(new Person("John", 35));
		persons.add(new Person("John", 32));
		persons.add(new Person("Simon", 30));
		persons.add(new Person("Shawn", 30));

		System.out.println(persons);

		
		Person search = new Person("John", 35);
		if (persons.contains(search)) {
			System.out.println("[searchPersonDoesNotHaveEqualsAndHashCodeMethodOverridden] Found the Person with name = John and age = 35");
		} else {
			System.out.println("[searchPersonDoesNotHaveEqualsAndHashCodeMethodOverridden] Not Found the Person with name = John and age = 35");

		}
	}
	
	public static void searchPersonHaveEqualsAndHashCodeMethodOverridden() {
		/*
		 * Declaring the Person Set instance variable
		 */
		Set<PersonWithHashCodeAndEquals> persons = new HashSet<PersonWithHashCodeAndEquals>();

		/*
		 * Initializing the Person Set instance variable
		 */
		persons.add(new PersonWithHashCodeAndEquals("John", 35));
		persons.add(new PersonWithHashCodeAndEquals("John", 32));
		persons.add(new PersonWithHashCodeAndEquals("Simon", 30));
		persons.add(new PersonWithHashCodeAndEquals("Shawn", 30));

		System.out.println(persons);

		
		PersonWithHashCodeAndEquals search = new PersonWithHashCodeAndEquals("John", 35);
		if (persons.contains(search)) {
			System.out.println("[searchPersonHaveEqualsAndHashCodeMethodOverridden] Found the Person with name = John and age = 35");
		} else {
			System.out.println("[searchPersonHaveEqualsAndHashCodeMethodOverridden] Not Found the Person with name = John and age = 35");

		}
	}

}

class PersonWithHashCodeAndEquals {
	private String name;
	private Integer age;

	public PersonWithHashCodeAndEquals(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonWithHashCodeAndEquals other = (PersonWithHashCodeAndEquals) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

class Person {
	private String name;
	private Integer age;

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	

}