<%@ page import="com.fialka.dto.ProductDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Panel - Manage Products</title>
    <link rel="stylesheet" href="css/manage.css">
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
<div class="container">
    <header class="header">
        <h1>Admin Panel - Manage Products</h1>
    </header>

    <div class="content-container">
        <h2>Product Management</h2>
        <form action="/FIALKA_war/admin/product" method="POST" id="productForm">
            <div class="filter-group">
                <label for="productName">Product Name</label>
                <input type="text" id="productName" name="title" placeholder="Enter product name" required>
            </div>

            <div class="filter-group">
                <label for="productColor">Product Color</label>
                <input type="text" id="productColor" name="color" placeholder="Enter product color" required>
            </div>

            <div class="filter-group">
                <label for="productPrice">Product Price</label>
                <input type="number" id="productPrice" name="price" placeholder="Enter product price" required>
            </div>

            <div class="filter-group">
                <label for="productCategory">Product Category</label>
                <select name="category" id="productCategory">
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
                <label for="productParameter">Product Parameter</label>
                <input type="text" id="productParameter" name="parameter" placeholder="Enter product parameter" required>
            </div>

            <div class="filter-group">
                <label for="productDescription">Product Description</label>
                <textarea id="productDescription" name="description" placeholder="Enter product description" required></textarea>
            </div>

            <div class="filter-group">
                <label for="productUrl">Product Url Image</label>
                <input type="text" id="productUrl" name="urlImage" placeholder="Enter product url image" required>
            </div>

            <button type="submit" class="btn btn__profile">Add Product</button>
        </form>
    </div>

    <div class="content-container">
        <div class="manage-buttons">
            <button class="btn btn__profile" onclick="findAllProducts()">Find All Products</button>
        </div>
    </div>

    <div class="card-container">
        <% ObjectMapper mapper = new ObjectMapper();
            List<ProductDTO> productDTOS = (List<ProductDTO>) session.getAttribute("productDTOS");
            if (productDTOS != null) {
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
                    <form action="/FIALKA_war/productUpdate.jsp" method="GET">
                        <%HttpSession httpSession = request.getSession();
                        httpSession.setAttribute("productDTO", product);%>
                        <button class="btn btn__item">Update Product</button>
                    </form>
                    <button class="btn btn__item"
                            data-product='<%= mapper.writeValueAsString(product).replace("'", "\\'") %>'
                            onclick=deleteProduct()>Delete Product</button>
                </div>
            </div>
        </card>
        <%
                }
            }
        %>
    </div>
</div>

<script src="js/products.js"></script>
</body>
</html>
