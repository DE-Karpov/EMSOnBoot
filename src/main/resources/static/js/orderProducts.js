function orderProducts() {
    $.ajax({
        type: 'POST',
        url: '/products',
        data: {
            action: 'order'
        }
    }).done(
        getCart()
    )
}
