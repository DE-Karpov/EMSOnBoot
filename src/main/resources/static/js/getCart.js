function getCart() {
    $.ajax({
        type: 'GET',
        url: '/products/list',
        success: function (data) {
            if (data.length === 0) {
                $("#goods_table").html("Cart is empty");
            } else {
                var tableHtml = "";
                tableHtml += '<table style="border-collapse: separate; border-spacing: 10px 0;">';
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
                        '<td>' + '<button class = "btn btn-danger" onclick="deleteProduct(' + data[i].id + ')" formaction="delete" id = ' + 1 + '>Delete</button>' + '</td>' +
                        '</tr>';
                }

                tableHtml += '</table>';
                tableHtml += '<form method="post" action="/products">';
                tableHtml += '<button class="btn btn-warning" type="submit">Submit</button>';
                tableHtml += '</form>';
                $("#goods_table").html(tableHtml);
            }
        }
    })
}
