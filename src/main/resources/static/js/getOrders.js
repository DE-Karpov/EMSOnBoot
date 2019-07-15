function getOrders() {
    $.ajax({
        type: 'GET',
        url: '/orders',
        async: false,
        success: function (data) {
            var tableHtml = "";
            tableHtml += '<table>';
            tableHtml +=
                '<tr>' +
                '<th>' +
                'Name' +
                '</th>' +
                '<th>' +
                'Count' +
                '</th>' +
                '</tr>';
            for (var i = 0; i < data.length; i++) {
                tableHtml += '<tr>' +
                    '<td>' + data[i].name + '</td>' +
                    '<td>' + getAmount(data[i].name) + '</td>' +
                    '</tr>';
            }
            tableHtml += '</table>';
            $("#orders_table").html(tableHtml);
        }
    })
}
