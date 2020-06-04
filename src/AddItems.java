

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
//import org.json.*;
//import java.util.Arrays;
import javax.json.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ItemService;
import model.Item;


/**
 * Servlet implementation class AddItems
 */
@WebServlet("/AddItems")
public class AddItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ItemService serv= new  ItemService();
    /** 
     * @see HttpServlet#HttpServlet()
     */
    public AddItems() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		resp.setContentType("application/json");
		PrintWriter writer = resp.getWriter();		
		List<Item> item = new ArrayList<>();
		item = serv.getItems();
		
		JsonObjectBuilder RootJson =Json.createObjectBuilder();
		JsonArrayBuilder jsonArray= Json.createArrayBuilder();

		for(int i=0;i<item.size();i++){		
				JsonObject itemObject = Json.createObjectBuilder()
						.add("getNum",item.get(i).getNum())
						.add("getName", item.get(i).getName())
						.add("getDescribe", item.get(i).getDescribe())
					.build();
				jsonArray.add(itemObject);
			}
//		jsonArray.build();

			JsonObject root = RootJson.add("Root item", jsonArray).build();
			writer.println("Hiiiiiiiiiiiitem ="+ root);
		writer.flush();
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

}
