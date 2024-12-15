<%@ page import="java.util.List" %>
<%@ page import="com.fialka.dto.ProductDTO" %>
<%@ page import="com.fialka.dto.UserDTO" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/resetSt.css">
  <link rel="stylesheet" href="css/catalog.css">
  <title>FIALKA SHOP</title>
</head>

<body>
<header class="header">
  <div class="container">
    <form action="/FIALKA_war/search" method="GET" class="search-container">
      <input class="search-container-input" type="text" name="title">
      <div class="button-group">
        <div class="button-group">
          <div class="search-reset">
            <button type="submit" class="btn btn__search">Search</button>
            <button type="button" class="btn btn__reset" onclick="resetFiltersOrSearch(event)">Reset</button>
          </div>
          <div class="profile-cart">
            <button type="button" class="btn btn__profile" onclick="openUserProfile()">Profile</button>
            <button type="button" class="btn btn__cart" onclick="openBucket()">Bucket</button>
          </div>
        </div>
        <div id="userModal" class="modal">
            <div class="modal-content">
              <%
                UserDTO user = (UserDTO) session.getAttribute("userDTO");
                if (user != null) {
              %>
              <span class="close" onclick="closeUserProfile()">&times;</span>
              <h2>User Information</h2>
              <p><strong>Name:</strong> <%= user.getFirstname() %> <%= user.getLastname() %> <%= user.getSurname() %></p>
              <p><strong>Username:</strong> <%= user.getSurname() %></p>
              <p><strong>Birthdate:</strong> <%= user.getBirthdate() %></p>
              <p><strong>Email:</strong> <%= user.getEmail() %></p>
              <p><strong>Phone:</strong> <%= user.getPhoneNumber() %></p>
              <p><strong>Address:</strong> <%= user.getAddress() %></p>
              <%
                }
              %>
            </div>
        </div>
      </div>
  </form>
    <div class="header-img">
      <h1 class="header-title"> FiALKA SHOP</h1>
    </div>
  </div>
</header>
<main class="main">
  <div class="container">
    <form action="/FIALKA_war/filter" method="GET" class="filter-container">
      <div class="filter-group">
        <label for="category">Category:</label>
        <select name="category" id="category">
          <option value="">Select category</option>
          <option value="electronics">Electronics</option>
          <option value="clothing">Clothing</option>
          <option value="beauty">Beauty</option>
          <option value="sports">Sports</option>
          <option value="toys">Toys</option>
          <option value="books">Books</option>
        </select>
      </div>

      <div class="filter-group">
        <label>Price Range:</label>
        <input type="number" name="min-price" placeholder="Min price" step="0.01">
        <input type="number" name="max-price" placeholder="Max price" step="0.01">
      </div>

      <button type="submit" class="btn btn__filter">Apply Filters</button>
      <button type="button" class="btn btn__reset__filter" onclick="resetFiltersOrSearch(event)">Reset</button>
    </form>

    <div class="card-container">
      <%
        ObjectMapper mapper = new ObjectMapper();
        List<ProductDTO> productDTOS = (List<ProductDTO>) session.getAttribute("productDTOS");
        for (ProductDTO product : productDTOS) {
      %>
      <card class="card">
        <div class="card-bg">
          <img class="card-bg__img" src="<%= product.getUrlImage()%>" alt="">
        </div>
        <div class="card-content">
          <div class="card-content__type-color">
            <p class="card-content__type"><%= product.getCategory()%></p>
            <p class="card-content__color"><%= product.getColor()%></p>
          </div>
          <h4 class="card-content__title"><%= product.getTitle()%></h4>

          <div class="card-footer">
            <p class="card-content__price"><%= product.getPrice()%>$</p>
            <form action="/FIALKA_war/bucket" method="POST">
              <button data-product='<%= mapper.writeValueAsString(product).replace("'", "\\'")%>'
                      class="btn btn__buy">Buy now</button>
            </form>
          </div>
        </div>
      </card>
      <%
        }
      %>
    </div>
  </div>
</main>

<script src="js/main.js"></script>
</body>
</html>