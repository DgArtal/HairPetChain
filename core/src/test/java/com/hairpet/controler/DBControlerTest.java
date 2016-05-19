package com.hairpet.controler;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hairpet.controler.context.Session;

public class DBControlerTest {

	static DBControler dbcontroler;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dbcontroler = Session.getDBControler();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dbcontroler.closeConnection();
	}

	@Test
	public void testIsConnection() {
		assertEquals(true, dbcontroler.isConnection());
	}

}
