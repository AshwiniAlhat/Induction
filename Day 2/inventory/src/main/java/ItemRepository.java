import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ideas.model.Item;


public class ItemRepository {

	private Connection connection;
	
	public ItemRepository(Connection connection) {
		this.connection = connection;
		
	}
	public List<Item> findAll() {
		List<Item> items = new ArrayList<Item>();
		try {
			ResultSet rs = connection.createStatement().executeQuery("select name, quantity from item");
			while(rs.next()){
				Item item = new Item(rs.getString(1), rs.getInt(2));
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return items;
	}

}
