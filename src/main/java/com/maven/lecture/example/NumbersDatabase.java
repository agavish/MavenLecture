package com.maven.lecture.example;

import java.net.UnknownHostException;

public interface NumbersDatabase {

	/**
	 * This class should interact with a database and return numbers from it
	 * @throws UnknownHostException 
	 */

	public abstract Integer getNumberFromDB() throws UnknownHostException;

}