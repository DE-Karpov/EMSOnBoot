function getAmount(name) {
    $.ajax({
        type: 'GET',
        url: '/products/getAmount',
        data: {
            name: name,
        },
        success: function (data) {
            return data;
        }
    })
}