function banUser(id, state) {
    $.ajax({
        type: 'POST',
        url: '/users/changeState',
        async: false,
        data: {
            id: id,
            state: state,
            action: 'changeState'
        }
    })
}
