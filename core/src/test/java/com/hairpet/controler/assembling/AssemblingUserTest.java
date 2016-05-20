package com.hairpet.controler.assembling;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AssemblingUserTest {

	// private User user1, user2, user3;
	// private List<User> list;
	//
	// @BeforeClass
	// public void setUpBeforeClass() {
	// // Inicializamos datos
	// user1 = new User();
	// user1.setId(1);
	// user1.setName("Lucas");
	// user1.setPassword("1111");
	// list.add(user1);
	// user2 = new User();
	// user2.setId(3);
	// user2.setName("Silvia");
	// user2.setPassword("1704");
	// list.add(user2);
	// user3 = new User();
	// user3.setId(6);
	// user3.setName("Ines");
	// user3.setPassword("1234");
	// list.add(user3);
	// }

	@Test
	public void testAllUsers() {
		AssemblingUser au = new AssemblingUser();
		assertNotNull(au.allUsers());
	}

}
