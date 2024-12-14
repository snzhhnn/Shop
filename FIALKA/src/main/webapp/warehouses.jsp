<%@ page import="java.util.List" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ page import="com.fialka.dto.WarehouseDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin Panel - Manage Warehouses</title>
  <link rel="stylesheet" href="css/manage.css">
  <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
<div class="container">
  <header class="header">
    <h1>Admin Panel - Manage Warehouses</h1>
  </header>

  <div class="content-container">
    <h2>Product Management</h2>
    <form action="/FIALKA_war/admin/warehouse" method="POST" id="warehouseForm">
      <div class="filter-group">
        <label for="warehouseName">Warehouse Name</label>
        <input type="text" id="warehouseName" name="title" placeholder="Enter warehouse name" required>
      </div>

      <div class="filter-group">
        <label for="warehouseAddress">Warehouse Address</label>
        <textarea id="warehouseAddress" name="address" placeholder="Enter warehouse address" required></textarea>
      </div>

      <button type="submit" class="btn btn__profile">Add WareHouse</button>
    </form>
  </div>

  <div class="content-container">
    <div class="manage-buttons">
      <button class="btn btn__profile" onclick="findAllWarehouses()">Find All Warehouses</button>
    </div>
  </div>

  <div class="card-container">
    <% ObjectMapper mapper = new ObjectMapper();
      List<WarehouseDTO> warehouseDTOS = (List<WarehouseDTO>) session.getAttribute("warehouseDTOS");
      if (warehouseDTOS != null) {
        for (WarehouseDTO warehouse : warehouseDTOS) {
    %>
    <card class="card">
      <div class="card-content">
        <h4 class="card-content__title"><%= warehouse.getTitle()%></h4>
        <h4 class="card-content__title"><%= warehouse.getAddress()%></h4>


        <div class="card-footer">
          <form action="/FIALKA_war/warehouseUpdate.jsp" method="GET">
            <%HttpSession httpSession = request.getSession();
              httpSession.setAttribute("warehouseDTO", warehouse);%>
            <button class="btn btn__item">Update Product</button>
          </form>
          <button class="btn btn__item"
                  data-warehouse='<%= mapper.writeValueAsString(warehouse).replace("'", "\\'") %>'
                  onclick=deleteWarehouse()>Delete Product</button>
        </div>
      </div>
    </card>
    <%
        }
      }
    %>
  </div>
</div>

<script src="js/warehouses.js"></script>
</body>
</html>
