var basket = {
    init : function () {
        var _this = this;

        $('#btn-basket').on('click', function () {
            _this.basket();
        });
    },

    basket : function () {
        var isbn = $('#isbn').val();

        $.ajax({
            type: 'POST',
            url: '/basket',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('장바구니에 등록되었습니다..');
            window.location.href = '/basket/' + isbn;
        }).fail(function() {
            alert(JSON.stringify(error));
        });
    }
};
basket.init();