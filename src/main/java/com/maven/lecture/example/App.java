package com.maven.lecture.example;

import java.net.UnknownHostException;

public class App
{
	public static void main(String[] args) throws UnknownHostException {
		
		NumbersDatabase numbersDatabase = new NumbersDatabaseImpl();

		Integer sum = null;

		sum = sumTwoRandomNumbersFromDB(numbersDatabase);

		System.out.println("The sum of two random numbers from DB is: " + sum);
	}

	/*
	 * This is the function we want to unit test
	 */
	public static Integer sumTwoRandomNumbersFromDB(NumbersDatabase numbersDatabase) throws UnknownHostException {

		Integer a = numbersDatabase.getNumberFromDB();
		Integer b = numbersDatabase.getNumberFromDB();

		return a + b;
	}
}
