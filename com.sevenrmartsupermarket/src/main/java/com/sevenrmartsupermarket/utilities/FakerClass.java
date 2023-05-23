package com.sevenrmartsupermarket.utilities;

import com.github.javafaker.Faker;

public class FakerClass {
	static Faker faker = new Faker();

	public static String getRandomFirstName() {
		String firstName = faker.name().firstName();
		return firstName;
	}
	public static String getRandomFullName() {
		String fullName = faker.name().fullName();
		return fullName;
	}
	public static String getRandomlastName() {
		String lastName = faker.name().lastName();
		return lastName;
	}
	public static String getRandomAddress() {
		String streetAddress = faker.address().streetAddress();
		return streetAddress;
	}
}
