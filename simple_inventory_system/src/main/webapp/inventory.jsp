<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List" %>
<%@ page import="com.example.inventory.model.InventoryItem" %>
<!DOCTYPE html>
<html>
<head>
    <title>Inventory</title>
</head>
<body>
    <h2>Inventory Management</h2>

    <!-- Form to add items -->
    <form method="post" action="inventory">
        <input type="hidden" name="action" value="add">
        <label>Item Name: </label><input type="text" name="name" required><br>
        <label>Quantity: </label><input type="number" name="quantity" required><br>
        <button type="submit">Add Item</button>
    </form>

    <!-- Inventory items table -->
    <h3>Inventory Items</h3>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Fetch the list of items from the request attribute
                List<com.example.inventory.model.InventoryItem> items = 
                    (List<com.example.inventory.model.InventoryItem>) request.getAttribute("items");

                if (items != null && !items.isEmpty()) {
                    for (com.example.inventory.model.InventoryItem item : items) {
            %>
                        <tr>
                            <td><%= item.getId() %></td>
                            <td><%= item.getName() %></td>
                            <td><%= item.getQuantity() %></td>
                            <td>
                                <!-- Action buttons (Delete item example) -->
                                <form method="post" action="inventory">
                                    <input type="hidden" name="action" value="delete">
                                    <input type="hidden" name="id" value="<%= item.getId() %>">
                                    <button type="submit">Delete</button>
                                </form>
                            </td>
                        </tr>
            <%
                    }
                } else {
            %>
                    <tr>
                        <td colspan="4">No items available in inventory.</td>
                    </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
