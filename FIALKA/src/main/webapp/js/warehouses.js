function findAllWarehouses() {
    window.location.href = '/FIALKA_war/admin/warehouse';
}

function deleteWarehouse() {
    $(document).on('click', '.btn__item', function () {
        const button = $(this);
        const warehouse = JSON.parse(button.attr('data-warehouse'));

        $.ajax({
            url: '/FIALKA_war/admin/warehouse',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(warehouse),
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

function updateWarehouse(id) {
    $(document).on('click', '.btn__profile', function () {

        const warehouseData = {
            id: id,
            title: $('#warehouseName').val(),
            address: $('#warehouseAddress').val()
        };

        $.ajax({
            url: '/FIALKA_war/admin/warehouse',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(warehouseData),
            success: function(response) {
                console.log('Warehouse updated successfully:', response);
            },
            error: function(xhr, status, error) {
                console.error('Error updating product:', error);
                console.error('Response:', xhr.responseText);
            }
        });
    });
}