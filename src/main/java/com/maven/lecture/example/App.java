package com.maven.lecture.example;

public class App
{
	public static void main(String[] args) {
		System.out.println(sumTwoRandomNumbersFromDB());
	}

	public static Integer sumTwoRandomNumbersFromDB() {
		NumbersDatabase numbers = new NumbersDatabaseImpl();

		Integer a = numbers.getNumberFromDB();
		Integer b = numbers.getNumberFromDB();

		return a + b;
	}
}
