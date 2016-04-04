package org.hypernovae.apis;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class StuffsMvnJavaTest {
	
	
	@Test
	public void doubleDotLevelTest() {
		File  doubleDot = new File("./src/test/resources");
		assertTrue(doubleDot.isDirectory());
		String[] files = doubleDot.list();
		for (String file:files) {
			System.out.println(file);
		}
		
	}

}
