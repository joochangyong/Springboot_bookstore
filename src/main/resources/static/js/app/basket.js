var basket = {
    init : function () {
        var _this = this;

        $('#btn-basket').on('click', function () {
            _this.basket();
        });
    },

    basket : function () {
        var data = {
            isbn: $('#isbn').val(),
            basAmount: $('#basAmount').val()
        }; 
        
        $.ajax({
            type: 'POST',
            url: '/basket/' + data.isbn,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data),
        }).done(function() {
            alert('장바구니에 등록되었습니다..');
            console.log(basAmount);
            window.location.href = '/books/bookInfo/' + data.isbn;
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    }
};
basket.init();