document.querySelector('.register-btn').addEventListener('click', () => {
    const container = document.querySelector('.container');
    container.classList.toggle('expanded'); 
});

document.querySelector('.login-btn').addEventListener('click', () => {
    const container = document.querySelector('.container');
    container.classList.remove('expanded'); 
});

function resetFiltersOrSearch() {
    event.preventDefault();
    window.location.href = '/FIALKA_war/product';
}

function openUserProfile() {
    document.getElementById('userModal').style.display = 'block';
}

function closeUserProfile() {
    document.getElementById('userModal').style.display = 'none';
}
function manageOrders() {
    window.location.href = '/FIALKA_war/orders.jsp';
}
function manageProducts() {
    window.location.href = '/FIALKA_war/products.jsp';
}
function manageWarehouses() {
    window.location.href = '/FIALKA_war/warehouses.jsp';
}
