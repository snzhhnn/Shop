<%@ page import="java.util.List" %>
<%@ page import="com.fialka.dto.ProductDTO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/resetSt.css">
    <link rel="stylesheet" href="css/catalog.css">
    <title>My Bucket</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>

<body>
<header class="header">
    <div class="container">
        <h1 class="header-title">Your Shopping Bucket</h1>
    </div>
</header>
<main class="main">
    <div class="container">
        <div class="card-container">
            <%
                List<ProductDTO> bucketItems = (List<ProductDTO>) session.getAttribute("bucketItems");
                if (bucketItems != null && !bucketItems.isEmpty()) {
                    for (ProductDTO product : bucketItems) {
            %>
            <card class="card">
                <div class="card-bg">
                    <img class="card-bg__img" src="<%= product.getUrlImage()%>" alt="<%= product.getTitle()%>">
                </div>
                <div class="card-content">
                    <h4 class="card-content__title"><%= product.getTitle()%></h4>
                    <p class="card-content__price"><%= product.getPrice()%> $</p>
                    <div class="card-footer">
                        <input type="hidden" name="productId" value="<%= product.getId() %>">
                        <button type="submit" class="btn btn__buy">Remove</button>
                    </div>
                </div>
            </card>
            <%
                }
            } else {
            %>
            <p>Your bucket is empty. Start shopping!</p>
            <%
                }
            %>
        </div>
    </div>
</main>

<script src="js/products.js"></script>
</body>

</html>