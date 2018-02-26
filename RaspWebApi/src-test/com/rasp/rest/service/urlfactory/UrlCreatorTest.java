package com.rasp.rest.service.urlfactory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

public class UrlCreatorTest {

	@Test
	public void testCreateURL() {

		MockHttpServletRequest request = new MockHttpServletRequest();

		request.setContextPath("/ldp");

		request.setServerPort(80);
		request.setScheme("http");

		// Test URL where given path starts with a forward slash and the port is
		// 80
		String urlA = UrlCreator.createURL(request, "/starts/with/slash.html");
		assertEquals("urlA should eq 'http://localhost/ldp/starts/with/slash.html'",
				"http://localhost/ldp/starts/with/slash.html", urlA);

		// Test the same with non-standard HTTP port
		request.setServerPort(8080);
		String urlA2 = UrlCreator.createURL(request, "/http/with/non-standard/port.html");
		assertEquals("urlA2 should contain port 8080", "http://localhost:8080/ldp/http/with/non-standard/port.html",
				urlA2);

		// Test where path does not start with slash
		String urlB = UrlCreator.createURL(request, "does/not/start/with/slash.html");
		assertEquals("urlB should eq 'http://localhost:8080/ldp/does/not/start/with/slash.html'",
				"http://localhost:8080/ldp/does/not/start/with/slash.html", urlB);

		request.setScheme("https");
		request.setServerPort(443);

		// Test HTTPS URL on standard HTTPS port
		String urlC = UrlCreator.createURL(request, "/ssl/on/standard/port.html");
		assertEquals("urlC should eq 'https://localhost/ldp/ssl/on/standard/port.html'",
				"https://localhost/ldp/ssl/on/standard/port.html", urlC);

		request.setServerPort(4040);
		String urlD = UrlCreator.createURL(request, "/ssl/on/non-standard/port.html");
		assertEquals("urlD should eq 'https://localhost:4040/ldp/ssl/on/non-standard/port.html'",
				"https://localhost:4040/ldp/ssl/on/non-standard/port.html", urlD);

	}

}
