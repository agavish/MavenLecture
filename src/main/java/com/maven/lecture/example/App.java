package com.maven.lecture.example;

import java.net.UnknownHostException;

public class App
{
	public static void main(String[] args) throws UnknownHostException {
		NumbersDatabase numbersDatabase = new NumbersDatabaseImpl();
		System.out.println(sumTwoRandomNumbersFromDB(numbersDatabase));
	}

	public static Integer sumTwoRandomNumbersFromDB(NumbersDatabase numbersDatabase) throws UnknownHostException {

		Integer a = numbersDatabase.getNumberFromDB();
		Integer b = numbersDatabase.getNumberFromDB();

		return a + b;
	}
}
