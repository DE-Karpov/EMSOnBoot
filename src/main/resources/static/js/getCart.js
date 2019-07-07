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
                'Name' +
                '</th>' +
                '<th>' +
                'Count' +
                '</th>' +
                '</tr>';
            for (var i = 0; i < data.length; i++) {
                tableHtml += '<tr>' +
                    '<td>' + data[i].name + '</td>' +
                    '<td>' + data[i].counter + '</td>' +
                    '<td>' + '<button onclick="deleteProduct(' + data[i].id + ')" formaction="delete" id = ' + 1 + '>Delete</button>' + '</td>' +
                    '</tr>';
            }
            tableHtml += '</table>';
            $("#goods_table").html(tableHtml);
        }
    })
}
