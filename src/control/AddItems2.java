package control;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
//import org.json.*;
//import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.json.*;

import services.ItemService;
import model.Item;


/**
 * Servlet implementation class AddItems
 */
@WebServlet("/AddItems2")
public class AddItems2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ItemService serv= new  ItemService();
    /** 
     * @see HttpServlet#HttpServlet()
     */
    public AddItems2() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("JSONObject dddddd ddddd ddd ddd ddddd ddddddddddddddddddd");

		resp.setContentType("application/json");

		
		List<Item> item = new ArrayList<>();
		item = serv.getItems();
	
	       ServletOutputStream out = resp.getOutputStream();

	       		JsonObjectBuilder RootJson =Json.createObjectBuilder();
	       		JsonArrayBuilder jsonArray= Json.createArrayBuilder();

			for(int i=0;i<item.size();i++){
				JsonObject itemObject = Json.createObjectBuilder().add("getNum",item.get(i).getNum())
						.add("getName", item.get(i).getName())
						.add("getDescribe", item.get(i).getDescribe())
						.build();
				jsonArray.add(itemObject);
			}

			JsonObject root = RootJson.add("Root item", jsonArray).build();
			out.println("<html>");
		       out.println("<head><title> Servlet</title></head>");
		       out.println("<body>");
		       out.println("<h3>Hello World</h3>");
		       out.println("This is my first Servlet");
		       out.println("Hiiiiiiiiiiiitem ="+ root);
		       out.println("</body>");
		       out.println("<html>");
		       out.flush();
		       out.close();
		
		resp.getWriter().append("Served at: ").append(req.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

}
