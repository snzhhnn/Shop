<%@ page import="com.fialka.dto.ProductDTO" %>
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
        <%ProductDTO productDTO = (ProductDTO) session.getAttribute("productDTO");%>
        <form id="addProductForm">
            <div class="filter-group">
                <label for="productName">Product Name</label>
                <input type="text" id="productName" name="title" value="<%= productDTO.getTitle()%>" required>
            </div>

            <div class="filter-group">
                <label for="productColor">Product Color</label>
                <input type="text" id="productColor" name="color" value="<%= productDTO.getColor()%>" required>
            </div>

            <div class="filter-group">
                <label for="productPrice">Product Price</label>
                <input type="number" id="productPrice" name="price" value="<%= productDTO.getPrice()%>" required>
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
                <input type="text" id="productParameter" name="parameter" value="<%= productDTO.getParameter()%>" required>
            </div>

            <div class="filter-group">
                <label for="productDescription">Product Description</label>
                <textarea id="productDescription" name="description" value="<%= productDTO.getDescription()%>" required></textarea>
            </div>

            <div class="filter-group">
                <label for="productUrl">Product Url Image</label>
                <input type="text" id="productUrl" name="urlImage" value="<%= productDTO.getUrlImage()%>" required>
            </div>
            <button type="button" class="btn btn__profile" onclick="updateProduct('<%= productDTO.getId()%>')">Update Product</button>
        </form>
    </div>
</div>

<script src="js/products.js"></script>
</body>
</html>
