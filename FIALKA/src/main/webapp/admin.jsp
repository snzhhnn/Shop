<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Panel - Manage</title>
    <link rel="stylesheet" href="css/admin.css">
</head>
<body>
<div class="container">
    <header class="header">
        <h1 style="text-align: center; color: #6b4e3d; margin-top: 20px;">Admin Panel - Management</h1>
    </header>

    <div class="card-container">
        <h2>Managing</h2>
        <div style="display: flex; gap: 20px;">
            <button class="btn btn__profile" onclick="manageProducts()">Manage Products</button>
            <button class="btn btn__profile" onclick="manageWarehouses()">Manage Warehouse</button>
            <button class="btn btn__profile" onclick="">Manage ProductLocation</button>
            <button class="btn btn__profile" onclick="">Manage Orders</button>
            <button class="btn btn__profile" onclick="">Manage ProductInOrder</button>
        </div>
    </div>
</div>

<script src="js/main.js"></script>
</body>
</html>