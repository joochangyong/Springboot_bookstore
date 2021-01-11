var orders = {
    init: function () {
        var _this = this;

        $('#btn-orders').on('click', function () {
            _this.orders();
        });

        $('#btn-ordersBuy').on('click', function () {
            _this.ordersBuy();
        });

        $('#btn-basket').on('click', function () {
            _this.basket();
        });
    },

    orders: function () {
        var data = {
            isbn: $('#isbn').val(),
            basAmount: $('#amount').val(),
        };
        window.location.href = '/orders?isbn=' + data.isbn + '&basAmount=' + data.basAmount;
    },

    ordersBuy: function () {
        var data = {
            addrCode: $('#addr option:selected').val(),
            cardNum: $('#card option:selected').val(),
            orderSum: $('#orderSum').text()
        };

        if (data.addrCode == "0" || data.cardNum == "0") {
            alert("배송지와 카드를 선택해주세요");
            return false
        } else {
            $.ajax({
                type: 'POST',
                url: '/ordersBuy?isbn=' + searchParam('isbn') + '&orderAmount=' + searchParam('basAmount'),
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data),
            }).done(function () {
                alert('구매완료했습니다.');
                window.location.href = '/users/mypage/';
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        }
    },

    basket: function () {
        var data = {
            isbn: $('#isbn').val(),
            basAmount: $('#amount').val()
        };

        $.ajax({
            type: 'POST',
            url: '/basket/' + data.isbn,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
        }).done(function () {
            alert('장바구니에 담았습니다..');
            if (confirm("장바구니로 이동하시겠습니까?") == true) {
                window.location.href = '/basket'
            } else {
                window.location.href = '/books/bookInfo/' + data.isbn;
            }
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
};


function searchParam(key) {
    return new URLSearchParams(location.search).get(key);
}
orders.init();