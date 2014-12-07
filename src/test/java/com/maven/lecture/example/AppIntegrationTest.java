package com.maven.lecture.example;

import java.io.IOException;
import java.net.UnknownHostException;

import junit.framework.Assert;

import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;

public class AppIntegrationTest {

	MongodExecutable	mongodExecutable	= null;

	public AppIntegrationTest() throws IOException {
		MongodStarter starter = MongodStarter.getDefaultInstance();

		int port = 27017;
		IMongodConfig mongodConfig = new MongodConfigBuilder()
				.version(Version.Main.PRODUCTION)
				.net(new Net(port, false))
				.build();

		mongodExecutable = starter.prepare(mongodConfig);
		MongodProcess mongod = mongodExecutable.start();

		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("numbers");
		DBCollection col = db.createCollection("numberscollection", new BasicDBObject());
		col.save(new BasicDBObject("number", 3));
	}

	/**
	 * This is an integration test which tests a block of code within it's integration with actual inner objects
	 * 
	 * @throws UnknownHostException
	 */
	@Test
	public void testDatabaseIntegration() throws UnknownHostException {
		/**
		 * No mocks here, real embedded mongoDb is been loaded during the test
		 */
		Integer sumTwoRandomNumbersFromDB = App.sumTwoRandomNumbersFromDB(new NumbersDatabaseImpl());
		Assert.assertNotNull(sumTwoRandomNumbersFromDB);

		if (mongodExecutable != null)
			mongodExecutable.stop();
	}
}
