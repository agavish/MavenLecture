package com.maven.lecture.example;

import java.io.IOException;
import java.net.UnknownHostException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
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
	MongodProcess		mongod				= null;

	@Before
	public void before() throws IOException {
		MongodStarter starter = MongodStarter.getDefaultInstance();

		/*
		 * Use the mongo executable file to start a new mongod process
		 */
		int port = 27017;
		IMongodConfig mongodConfig = new MongodConfigBuilder()
				.version(Version.Main.PRODUCTION)
				.net(new Net(port, false))
				.build();

		mongodExecutable = starter.prepare(mongodConfig);
		mongod = mongodExecutable.start();

		/*
		 * Insert some data to the database
		 */
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("numbers");
		DBCollection col = db.createCollection("numberscollection", new BasicDBObject());
		col.save(new BasicDBObject("number", 3));
		mongo.close();
	}

	/*
	 * This is an integration test which tests a block of code within it's integration with actual inner objects
	 * 
	 * @throws UnknownHostException
	 */
	@Test
	public void IntegrationTest() throws UnknownHostException {
		/*
		 * No mocks here, real embedded mongoDb is been loaded during the test
		 */
		Integer sumTwoRandomNumbersFromDB = App.sumTwoRandomNumbersFromDB(new NumbersDatabaseImpl());

		Integer expectedResult = 6;

		/*
		 * If assertion fails, it will throw AssertionErrorException and fail the test
		 */
		Assert.assertNotNull(sumTwoRandomNumbersFromDB);
		Assert.assertEquals(expectedResult, sumTwoRandomNumbersFromDB);

		System.out.println("IntegrationTest finished successfully");
	}

	/*
	 * When test is finished, clear the mongod process and executable run
	 */
	@After
	public void after() {
		if (mongod != null) {
			mongod.stop();
		}
		
		if (mongodExecutable != null) {
			mongodExecutable.stop();
		}
	}
}
