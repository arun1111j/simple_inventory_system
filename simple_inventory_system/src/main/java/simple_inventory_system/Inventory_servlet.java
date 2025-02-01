package simple_inventory_system;

import com.example.dao.InventoryDAO;
import com.example.inventory.model.InventoryItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/inventory")
public class Inventory_servlet extends HttpServlet {
    private InventoryDAO inventoryDAO;

    @Override
    public void init() throws ServletException {
        inventoryDAO = new InventoryDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch inventory items
        List<InventoryItem> items = inventoryDAO.getAllItems();
        request.setAttribute("items", items);

        // Forward to JSP
        request.getRequestDispatcher("inventory.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String name = request.getParameter("name");
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            // Create a new inventory item and save it
            InventoryItem item = new InventoryItem();
            item.setName(name);
            item.setQuantity(quantity);
            inventoryDAO.addItem(item);
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));

            // Delete the inventory item by ID
            inventoryDAO.deleteItem(id);
        }

        // Redirect to GET handler to refresh the inventory list
        response.sendRedirect("inventory");
    }
}
