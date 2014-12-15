package com.maven.lecture.example;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class NumbersDatabaseImpl implements NumbersDatabase {

	MongoClient mongo = null;
	
	/*
	 * This is the module we want to integration test
	 */
	public Integer getNumberFromDB() throws UnknownHostException {
		
		Integer number = null;
		mongo = new MongoClient( "localhost" , 27017 );
		DB db = mongo.getDB("numbers");
		DBCollection table = db.getCollection("numberscollection");
		
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("number", 3);
	 
		DBCursor cursor = table.find(searchQuery);
	 
		while (cursor.hasNext()) {
			DBObject next = cursor.next();
			number = (Integer) next.get("number");
		}
		
		mongo.close();
		
		return number;
	}
}
