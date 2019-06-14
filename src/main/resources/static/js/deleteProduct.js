function deleteProduct(id) {
    $.ajax({
        type: 'POST',
        url: '/products/deleteProduct',
        async: false,
        data: {
            id: id,
            action: 'delete'
        }
    }).done(
        getCart()
    )
}
