function getCart() {
    $.ajax({
        type: 'GET',
        url: '/products/list',
        success: function (data) {
            var tableHtml = "";
            tableHtml += '<table>';
            tableHtml +=
                '<tr>' +
                '<th>' +
                'id' +
                '</th>' +
                '<th>' +
                'name' +
                '</th>' +
                '</tr>';
            for (var i = 0; i < data.length; i++) {
                tableHtml += '<tr>' +
                    '<td>' + data[i].id + '</td>' +
                    '<td>' + data[i].name + '</td>' +
                    '<td>' + '<button onclick="deleteProduct(' + data[i].id + ')" formaction="delete" id = ' + 1 + '>Delete</button>' + '</td>' +
                    '</tr>';
            }
            tableHtml += '</table>';
            $("#goods_table").html(tableHtml);
        }
    })
}
