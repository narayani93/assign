package com.incubetlabs.assignment.operationstests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.incubetlabs.assignment.operations.DBFunctions;
import com.incubetlabs.assignment.model.Hotel;

public class OperationsTest {
	@Test
	public void testSaveToDatabase() {
		DBFunctions db = new DBFunctions();
		Hotel h = new Hotel();
		h.setName("aaa");
		h.setAddress("10, bhyu");
		h.setCity("1");
		
		assertEquals(true, db.saveToDatabase(h));
	}
}
