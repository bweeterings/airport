package com.airport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightApplicationTests {

	@Test
	public void contextLoads() {

		String valid = "junit werkt!";
		assertEquals("Junit werkt!",valid);
	}
}