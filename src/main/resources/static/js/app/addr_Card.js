var addrCard = {
    init : function () {
        var _this = this;
        $('#btn-addrSave').on('click', function () {
            _this.addrSave();
        });

        $('#btn-cardSave').on('click', function () {
            _this.cardSave();
        });
    },
    // ///////////////////////////////////////배송지 등록///////////////////////////////////////
    addrSave : function () {
        var data = {
            addrNic: $('#addrNic').val(),
            addrName: $('#addrName').val(),
            addrZip: $('#addrZip').val(),
            addrBas: $('#addrBas').val(),
            addrDet: $('#addrDet').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'POST',
            url: '/api/addrSave/' + id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data),
        }).done(function() {
            alert('등록 되었습니다..');
            window.location.href = '/users/mypage/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },

    // ///////////////////////////////////////카드 등록///////////////////////////////////////
    cardSave : function () {
        var data = {
            cardNum: $('#cardNum').val(),
            cardCVC: $('#cardCVC').val(),
            cardVal: $('#cardVal').val(),
            cardPeriod: $('#cardPeriod').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'POST',
            url: '/api/cardSave/' + id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data),
        }).done(function() {
            alert('등록 되었습니다..');
            window.location.href = '/users/mypage/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },
};
addrCard.init();