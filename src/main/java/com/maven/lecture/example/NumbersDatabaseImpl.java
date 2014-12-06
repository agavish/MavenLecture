package com.maven.lecture.example;

import java.util.Date;
import java.util.Random;

public class NumbersDatabaseImpl implements NumbersDatabase {

	/**
	 * This function return a random number from database only until the year of 2016
	 */
	public Integer getNumberFromDB() {
		/**
		 * In this function, the class return a number from the database
		 * using the database logic structure, and its java connector
		 */
		Date date = new Date();
		
		if (date.getYear() <= 2016) {
			return new Random().nextInt(10);			
		} else {
			return null;
		}
	}
}
