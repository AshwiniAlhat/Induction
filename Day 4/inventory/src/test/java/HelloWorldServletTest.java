import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import junit.framework.Assert;

import org.eclipse.jetty.testing.HttpTester;
import org.eclipse.jetty.testing.ServletTester;
import org.junit.BeforeClass;
import org.junit.Test;


public class HelloWorldServletTest {
	
	
	public  Connection createConnection() throws ClassNotFoundException, SQLException {
			Class.forName("org.hsqldb.jdbcDriver");
			return DriverManager.getConnection("jdbc:hsqldb:mem:inventoryDb",
					"SA", "");
	}
	
	@Test
	public void itGetsAllItems() throws Exception{
		ServletTester servletTester = new ServletTester();
		servletTester.addServlet(ItemController.class, "/items");
		
		Connection connection = createConnection();
		servletTester.setAttribute("repository", new ItemRepository(connection));
		servletTester.start();
		
		HttpTester request = new HttpTester();
		request.setMethod("GET");
		request.setURI("/items");
		request.setVersion("HTTP/1.0");

		HttpTester response = new HttpTester();
		response.parse(servletTester.getResponses(request.generate()));
		
		Assert.assertEquals(200,response.getStatus());
		connection.close();


	}
	
	/*@Test
	public void itSavesAnItem() throws Exception{
		ServletTester servletTester = new ServletTester();
		servletTester.addServlet(ItemController.class, "/add");
		Connection connection = createConnection();
		servletTester.setAttribute("repository", new ItemRepository(connection));
		servletTester.setAttribute("name", "Pen");
		servletTester.setAttribute("quantity", 10);
		servletTester.start();
		
		HttpTester request = new HttpTester();
		request.setMethod("POST");
		request.setURI("/add");
		request.setVersion("HTTP/1.0");
		

		HttpTester response = new HttpTester();
		response.parse(servletTester.getResponses(request.generate()));
		
		Assert.assertEquals(200,response.getStatus());
		connection.close();

	}*/
	
}
