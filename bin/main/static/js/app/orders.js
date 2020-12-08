var orders = {
    init : function () {
        var _this = this;

        $('#btn-basket').on('click', function () {
            _this.basket();
        });

        $('#btn-basketInfoDelete').on('click', function () {
            _this.basketInfoDelete();
        });
        
        $('#btn-orders').on('click', function () {
            _this.orders();
        });

        $('#btn-ordersBuy').on('click', function () {
            _this.ordersBuy();
        });
    },

    basket : function () {
        var data = {
            isbn: $('#isbn').val(),
            basAmount: $('#amount').val()
        }; 
        
        $.ajax({
            type: 'POST',
            url: '/basket/' + data.isbn,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data),
        }).done(function() {
            alert('장바구니에 담았습니다..');
            console.log(basAmount);
            window.location.href = '/books/bookInfo/' + data.isbn;
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },

    basketInfoDelete : function () {
        var book_isbn = $('#book_isbn').val();

        $.ajax({
            type: 'DELETE',
            url: '/basket/delete/'+ book_isbn,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            window.location.href = '/users/basket';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    orders: function () {
        var data = {
          isbn: $('#isbn').val(),
          basAmount: $('#amount').val(),
        };
        
        console.log(data.isbn)
        window.location.href = '/orders?isbn=' + data.isbn + '&basAmount=' + data.basAmount;
      },

      ordersBuy : function () {
        var data = {
            addrCode: $('#addr option:selected').val(),
            cardNum: $('#card option:selected').val(),
            orderSum: $('#orderSum').val()
        }; 
        
        $.ajax({
            type: 'POST',
            url: '/ordersBuy?isbn='+searchParam('isbn')+'&orderAmount='+searchParam('basAmount'),
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data),
        }).done(function() {
            alert('구매완료했습니다.');
            console.log(basAmount);
            window.location.href = '/users/mypage/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    }
};

function searchParam (key) {
    return new URLSearchParams(location.search).get(key);
}
orders.init();