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
function openBucket() {
    window.location.href = '/FIALKA_war/bucket.jsp';
}

function addProductToBucket() {
    $(document).on('click', '.btn__buy', function () {
        const button = $(this);
        const productData = JSON.parse(button.attr('data-product'));

        console.log(productData);

        $.ajax({
            url: '/bucket',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(productData),
            success: function (response) {
                console.log('Product updated successfully:', response);
            },
            error: function (xhr, status, error) {
                console.error('Error deleting product:', error);
                console.error('Response:', xhr.responseText);
            }
        });
    });
}