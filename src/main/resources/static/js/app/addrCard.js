var main = {
    init : function () {
        var _this = this;
        $('#btn-addrSave').on('click', function () {
            _this.addrSave();
        });

        $('#btn-addrDelete').on('click', function () {
            _this.delete();
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
            window.location.href = '/users/mypage/' + id;
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },
    // ///////////////////////////////////////배송지 삭제///////////////////////////////////////
    delete : function () {
        var addrCode = $('#addrCode').val();
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/addr/delete/'+ addrCode,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('배송지가 삭제되었습니다.');
            window.location.href = '/users/mypage/' + id';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};
main.init();