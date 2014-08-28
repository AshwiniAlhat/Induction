import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class IMSServletContextListener implements ServletContextListener
{
	private static final String DB_URL = "db.url";
	private static final String DB_DRIVER = "db.driver";
	private static final String DB_USER_NAME = "db.username";
	private static final String DB_PASSWORD = "db.password";
	
	public void contextInitialized(ServletContextEvent sce){
		ServletContext servletContext = sce.getServletContext();
		String url = servletContext.getInitParameter(DB_URL);
		String driver = servletContext.getInitParameter(DB_DRIVER);
		String userName = servletContext.getInitParameter(DB_USER_NAME);
		String password = servletContext.getInitParameter(DB_PASSWORD);
		try {
			servletContext.setAttribute("repository", new ItemRepository(connection(url,driver,userName,password)));
			
		} catch (ClassNotFoundException e) {
			System.out.println("Falied to create servlet context");
			throw new RuntimeException("Failed to Create Connection Class for " + "Driver :" + driver  + e.getMessage());
			
		} catch (SQLException e) {
			System.out.println("Falied to create connection");
			throw new RuntimeException("Failed to Create Connection Class for " + e.getMessage());
		}
		
	}

	private Connection connection(String url, String driver, String userName, String password) throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		return DriverManager.getConnection(url,userName,password);
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
