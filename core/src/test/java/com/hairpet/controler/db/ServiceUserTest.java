package com.hairpet.controler.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.hairpet.controler.DBControler;
import com.hairpet.model.User;

@RunWith(MockitoJUnitRunner.class)
public class ServiceUserTest {

	ServiceUser serviceUser;
	User user, noUser;

	@Mock
	DBControler dbcontroler;


	@Before
	public void setUp() {
		serviceUser = new ServiceUser();
		user = new User();
		user.setId(1);
		user.setName("admin");
		user.setPassword("1234");
		noUser = new User();
		noUser.setId(1);
		noUser.setName("admin");
		noUser.setPassword(null);
	}

	@Test
	public void testInsert() {
		try {
			assertEquals(false, serviceUser.insert(user));

			// assertEquals(false, serviceUser.insert(noUser));
			// fail("No permitir inserciones incompletas");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testExists() {
		try {
			assertEquals((Integer) 1, serviceUser.exists(user));
			assertEquals((Integer) (-1), serviceUser.exists(noUser));
		} catch (Exception e) {
			fail("no se espera excepción");
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			int id = 19;
			assertEquals(true, serviceUser.delete(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFind() {
		try {
			assertEquals(null, serviceUser.find(4));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
