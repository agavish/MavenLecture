package com.howtodoinjava;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.mockito.Mockito;

import com.maven.lecture.example.App;
import com.maven.lecture.example.NumbersDatabase;

public class AppIntegrationTest extends TestCase {

	public void testSumTwoRandomNumbersFromDB() {

		/**
		 * App.sumTwoRandomNumbersFromDB method is using the numbers from database class
		 * We want to test the integration between the App class to the numbers from database class
		 * with proper values, so we 'mock' the numbers from database class so it'll return correct value
		 */
		NumbersDatabase numbersDatabaseMock = Mockito.mock(NumbersDatabase.class);
		Mockito.when(numbersDatabaseMock.getNumberFromDB()).thenReturn(10);
		
		/**
		 * Now, when calling App.sumTwoRandomNumbersFromDB, we'll test it's code
		 * when we know that numbers from database return a proper value so it won't 'break' the method we test 
		 */
		Integer sumTwoRandomNumbersFromDB = App.sumTwoRandomNumbersFromDB();
		Assert.assertNotNull(sumTwoRandomNumbersFromDB);
	}
}
