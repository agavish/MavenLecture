package com.maven.lecture.example;


import java.net.UnknownHostException;

import org.mockito.Mockito;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppUnitTest extends TestCase {
	
	/**
	 * This is a unit test which tests a block of code
	 * and mock an inner objects method calls
	 * @throws UnknownHostException 
	 */
	public void testMock() throws UnknownHostException {
		NumbersDatabase numbersDatabaseMock = Mockito.mock(NumbersDatabase.class);
		Mockito.when(numbersDatabaseMock.getNumberFromDB()).thenReturn(10);

		Integer sumTwoRandomNumbersFromDB = App.sumTwoRandomNumbersFromDB(numbersDatabaseMock);
		Assert.assertNotNull(sumTwoRandomNumbersFromDB);
	}
}
