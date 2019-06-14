function addProduct(id) {
    $.ajax({
        type: 'POST',
        url: '/products/addProduct',
        async: false,
        data: {
            id: id,
            action: 'buy'
        }
    }).done(
        getCart()
    )
}
