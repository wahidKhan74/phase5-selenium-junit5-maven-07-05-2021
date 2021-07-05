package com.webapp.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JunitLifeCycleMethods {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("-- Before class -- ");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("-- After class -- ");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("-- Before Test -- ");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("-- After Test -- ");
	}

	@Test
	void testOne() {
		System.out.println("Test 1 executed ! ");
	}
	
	@Test
	void testTwo() {
		System.out.println("Test 2 executed ! ");
	}

}
