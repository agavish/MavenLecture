package com.maven.lecture.example;


import java.net.UnknownHostException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/*
 * Unit test for simple App.
 */
public class AppUnitTest {
	
	private NumbersDatabase numbersDatabaseMock = null;
	
	/*
	 * This function prepare the database mock object before running the unit test
	 */
	@Before
	public void before() throws UnknownHostException {
		numbersDatabaseMock = Mockito.mock(NumbersDatabase.class);
		
		/*
		 * When we mock an object's function, every time our test code will use
		 * that specific mocked object and that specific function, it'll return the mock data 3
		 * instead of actual running that function
		 */
		Mockito.when(numbersDatabaseMock.getNumberFromDB()).thenReturn(3);		
	}
	
	/*
	 * This is a unit test which tests a block of code
	 * using a database mock object 
	 */
	@Test
	public void UnitTest() throws UnknownHostException {

		Integer sumTwoRandomNumbersFromDB = App.sumTwoRandomNumbersFromDB(numbersDatabaseMock);
		Integer expectedResult = 6;

		/*
		 * If assertion fails, it will throw AssertionErrorException and fail the test
		 */
		Assert.assertNotNull(sumTwoRandomNumbersFromDB);
		Assert.assertEquals(expectedResult, sumTwoRandomNumbersFromDB);
		
		System.out.println("UnitTest finished successfully");
	}
}
