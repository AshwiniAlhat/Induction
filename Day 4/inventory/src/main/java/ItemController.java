

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ideas.model.Item;

public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemRepository itemRepository;
     
	@Override
    public void init(final ServletConfig config){
    	 itemRepository = (ItemRepository) config.getServletContext().getAttribute("repository");
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =  request.getRequestDispatcher("/items-view.jsp");
		List<Item> items = itemRepository.findAll();
		Collections.sort(items);
		request.setAttribute("items", items);
		dispatcher.forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String itemName = (String) request.getParameter("name"); 
		String quantity = (String) request.getParameter("quantity"); 
		try {
			itemRepository.save(new Item(itemName,Integer.valueOf(quantity)));
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		//doGet(request,response);
		
		
	}
}
