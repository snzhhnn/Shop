const container = document.querySelector('.container');
const registerBtn = document.querySelector('.register-btn');
const loginBtn = document.querySelector('.login-btn');

registerBtn.addEventListener('click', () => {
    container.classList.add('active');
})

loginBtn.addEventListener('click', () => {
    container.classList.remove('active');
})

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
function findAllProducts() {
    window.location.href = '/FIALKA_war/product';
}

function deleteProduct(button) {
    $(document).on('click', '.btn__product', function () {
        const button = $(this);
        const productData = JSON.parse(button.attr('data-product'));

        console.log(productData);

        $.ajax({
            url: '/FIALKA_war/product',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(productData),
            success: function (response) {
                button.closest('.card').remove();
            },
            error: function (xhr, status, error) {
                console.error('Error deleting product:', error);
                console.error('Response:', xhr.responseText);
            }
        });
    });
}

function updateProduct(id) {
    $(document).on('click', '.btn__profile', function () {

        const productData = {
            id: id,
            title: $('#productName').val(),
            color: $('#productColor').val(),
            price: $('#productPrice').val(),
            category: $('#productCategory').val(),
            parameter: $('#productParameter').val(),
            description: $('#productDescription').val(),
            urlImage: $('#productUrl').val()
        };

        $.ajax({
            url: '/FIALKA_war/product',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(productData),
            success: function(response) {
                console.log('Product updated successfully:', response);
                alert('Product updated successfully!');
            },
            error: function(xhr, status, error) {
                console.error('Error updating product:', error);
                console.error('Response:', xhr.responseText);
                alert('Failed to update product!');
            }
        });
    });
}

