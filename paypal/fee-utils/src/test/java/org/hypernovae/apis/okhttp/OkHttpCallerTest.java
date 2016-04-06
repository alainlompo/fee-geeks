package org.hypernovae.apis.okhttp;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class OkHttpCallerTest {
	@Test
	public void callerTest() throws IOException {
		OkHttpCaller.main(null);
		assertTrue(true);
	}
}
