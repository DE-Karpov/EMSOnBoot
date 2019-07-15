function getAmount(name) {
    let obj;
    $.ajax({
        type: 'GET',
        url: '/products/getAmount',
        async : false,
        data: {
            name: name,
        },
        success: function (data) {
            obj = data;
        }
    });
    return obj;
}