import junit.framework.Assert;

import org.eclipse.jetty.testing.HttpTester;
import org.eclipse.jetty.testing.ServletTester;
import org.junit.Test;


public class HelloWorldServletTest {
	@Test
	public void itGetsAllItems() throws Exception{
		ServletTester servletTester = new ServletTester();
		servletTester.addServlet(ItemController.class, "/items");
		servletTester.start();
		
		HttpTester request = new HttpTester();
		request.setMethod("GET");
		request.setURI("/items");
		request.setVersion("HTTP/1.0");

		HttpTester response = new HttpTester();
		response.parse(servletTester.getResponses(request.generate()));
		
		Assert.assertEquals(200,response.getStatus());


	}
	
}
