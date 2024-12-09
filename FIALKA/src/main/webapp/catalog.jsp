<%@ page import="java.util.List" %>
<%@ page import="com.fialka.dto.ProductDTO" %>
<%@ page import="com.fialka.dto.UserDTO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Catalog</title>
  <link rel="stylesheet" href="css/styles.css">
  <style>
    .user-info-btn {
      position: absolute;
      top: 10px;
      right: 10px;
      padding: 10px 20px;
      background-color: #4CAF50;
      color: white;
      border: none;
      cursor: pointer;
      border-radius: 5px;
    }
    .user-info-modal {
      display: none;
      position: fixed;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
      padding: 20px;
      background-color: white;
      border: 1px solid #ddd;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    .user-info-modal.active {
      display: block;
    }
    button {
      padding: 10px 20px;
      font-size: 16px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      transition: background-color 0.3s ease, transform 0.2s ease;
      margin: 5px;
    }

    button:hover {
      background-color: #0056b3;
      transform: scale(1.05);
      color: white;
    }

    button:focus {
      outline: none;
    }

    button.close {
      background-color: #dc3545;
      color: white;
    }

    button.change-info {
      background-color: #007bff;
      color: white;
    }
    .filter-btn {
      position: absolute;
      top: 50px;
      right: 10px;
      padding: 10px 20px;
      background-color: #FFA500;
      color: white;
      border: none;
      cursor: pointer;
      border-radius: 5px;
    }
    .filter-modal {
      display: none;
      position: fixed;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
      padding: 20px;
      background-color: white;
      border: 1px solid #ddd;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      width: 300px;
      border-radius: 8px;
    }
    .filter-modal.active {
      display: block;
    }
    .filter-modal input, .filter-modal select {
      width: 100%;
      margin: 10px 0;
      padding: 8px;
      border: 1px solid #ddd;
      border-radius: 4px;
    }
    .filter-modal button {
      width: 100%;
      margin-top: 10px;
    }
  </style>
  <script>
    <%
      UserDTO user = (UserDTO) session.getAttribute("userDTO");
      if (user != null) {
    %>
    function toggleUserInfo() {
      const modal = document.getElementById('user-info-modal');
      modal.classList.toggle('active');
    }

    function toggleFilterModal() {
      const filterModal = document.getElementById('filter-modal');
      filterModal.classList.toggle('active');
    }

    function resetFiltersOrSearch() {
      window.location.href = '/FIALKA_war/product';
    }
  </script>
</head>
<body>
<div class="container">

  <form action="/FIALKA_war/search" method="GET" style="margin-bottom: 20px;">
    <input
            type="text"
            name="title"
            placeholder="Search by title..."
            style="padding: 10px; width: 300px; border: 1px solid #ddd; border-radius: 5px;"
    >
    <button
            type="submit"
            style="padding: 10px 20px; background-color: #007bff; color: white; border: none; border-radius: 5px; cursor: pointer;"
    >
      Search
    </button>
    <button
            type="button"
            onclick="resetFiltersOrSearch()"
            style="padding: 10px 20px; background-color: #6c757d; color: white; border: none; border-radius: 5px; cursor: pointer;"
    >
      Reset
    </button>
  </form>

  <button class="filter-btn" onclick="toggleFilterModal()">Filter Products</button>

  <form action="/FIALKA_war/filter" method="GET">
  <div id="filter-modal" class="filter-modal">
    <h3>Filter Products</h3>
    <label for="min-price">Min Price:</label>
    <input type="number" id="min-price" name="min-price" placeholder="Enter minimum price">

    <label for="max-price">Max Price:</label>
    <input type="number" id="max-price" name="max-price" placeholder="Enter maximum price">

    <label for="category">Category:</label>
    <select id="category" name="category">
      <option value="">All Categories</option>
      <option value="electronics">Electronics</option>
      <option value="clothing">Clothing</option>
      <option value="beauty">Beauty</option>
      <option value="sports">Sports</option>
      <option value="toys">Toys</option>
      <option value="books">Books</option>
    </select>

    <input type="submit" value="Apply">
    <button class="close" onclick="toggleUserInfo()">Close</button>
    <button type="button" class="reset-btn" onclick="resetFiltersOrSearch()">Reset Filters</button>

  </div>
  </form>


  <button class="user-info-btn" onclick="toggleUserInfo()">User Info</button>
  <div id="user-info-modal" class="user-info-modal">
    <h2>User Information</h2>
    <p><strong>Name:</strong> <%= user.getFirstname() %> <%= user.getLastname() %> <%= user.getSurname() %></p>
    <p><strong>Username:</strong> <%= user.getSurname() %></p>
    <p><strong>Birthdate:</strong> <%= user.getBirthdate() %></p>
    <p><strong>Email:</strong> <%= user.getEmail() %></p>
    <p><strong>Phone:</strong> <%= user.getPhoneNumber() %></p>
    <p><strong>Address:</strong> <%= user.getAddress() %></p>
    <button class="close" onclick="toggleUserInfo()">Close</button>

    <%
    } else {
    %>
    <p>No user information available.</p>
    <button onclick="toggleUserInfo()">Close</button>
    <%
      }
    %>
  </div>

  <div class="header">
    <h1>Welcome to shop «FIALKA»</h1>
    <p>Check out our latest products</p>
  </div>

  <div class="products">
    <%
      List<ProductDTO> productDTOS = (List<ProductDTO>) session.getAttribute("productDTOS");
      for (ProductDTO product : productDTOS) {
    %>
    <div class="product">
      <div class="product-details">
        <h2><%= product.getTitle()%></h2>
        <p><%= product.getCategory()%></p>
        <p><%= product.getDescription()%></p>
        <p>Price: <%= product.getPrice()%></p>
        <a href="#">Buy Now</a>
      </div>
    </div>
    <%
      }
    %>
  </div>
</div>
</body>
</html>
