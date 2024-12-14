<%@ page import="com.fialka.dto.WarehouseDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin Panel - Update Product</title>
  <link rel="stylesheet" href="css/manageUpdateStyle.css">
  <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
<div class="container">
  <header class="header">
    <h1 style="text-align: center; color: #6b4e3d; margin-top: 20px;">Admin Panel</h1>
  </header>

  <div class="card-container" style="padding: 20px;">
    <h2>Update New Product</h2>
    <%WarehouseDTO warehouseDTO = (WarehouseDTO) session.getAttribute("warehouseDTO");%>
    <form id="addProductForm">
      <div class="filter-group">
        <label for="warehouseName">Warehouse Name</label>
        <input type="text" id="warehouseName" name="title" value="<%= warehouseDTO.getTitle()%>" required>
      </div>

      <div class="filter-group">
        <label for="warehouseAddress">Warehouse Address</label>
        <input id="warehouseAddress" name="address" value="<%= warehouseDTO.getAddress()%>" required>
      </div>

      <button class="btn btn__profile" onclick="updateWarehouse('<%= warehouseDTO.getId()%>')">Update Product</button>
    </form>
  </div>
</div>

<script src="js/warehouses.js"></script>
</body>
</html>