package com.maven.lecture.example;

import com.maven.lecture.example.NumbersDatabase;
import com.maven.lecture.example.NumbersDatabaseImpl;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppUnitTest extends TestCase {
	
	/**
	 * This is a unit test which tests a block of code
	 */
	public void testNumbersFromDatabase() {
		NumbersDatabase numbers = new NumbersDatabaseImpl();

		Integer numberFromDB = numbers.getNumberFromDB();
		Assert.assertNotNull(numberFromDB);
	}
}
