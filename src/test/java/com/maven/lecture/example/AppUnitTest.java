package com.maven.lecture.example;


import java.net.UnknownHostException;

import junit.framework.Assert;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit test for simple App.
 */
public class AppUnitTest {
	
	/**
	 * This is a unit test which tests a block of code
	 * and mock an inner objects method calls
	 * @throws UnknownHostException 
	 */
	@Test
	public void testMock() throws UnknownHostException {
		NumbersDatabase numbersDatabaseMock = Mockito.mock(NumbersDatabase.class);
		Mockito.when(numbersDatabaseMock.getNumberFromDB()).thenReturn(10);

		Integer sumTwoRandomNumbersFromDB = App.sumTwoRandomNumbersFromDB(numbersDatabaseMock);
		Assert.assertNotNull(sumTwoRandomNumbersFromDB);
	}
}
