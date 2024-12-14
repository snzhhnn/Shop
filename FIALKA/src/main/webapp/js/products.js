function findAllProducts() {
    window.location.href = '/FIALKA_war/admin/product';
}

function deleteProduct() {
    $(document).on('click', '.btn__product', function () {
        const button = $(this);
        const productData = JSON.parse(button.attr('data-product'));

        console.log(productData);

        $.ajax({
            url: '/FIALKA_war/admin/product',
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
            url: '/FIALKA_war/admin/product',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(productData),
            success: function(response) {
                console.log('Product updated successfully:', response);
            },
            error: function(xhr, status, error) {
                console.error('Error updating product:', error);
                console.error('Response:', xhr.responseText);
            }
        });
    });
}