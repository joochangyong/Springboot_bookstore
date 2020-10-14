var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-login').on('click', function () {
            _this.login();
        });

        $('#btn-booksSave').on('click', function () {
            _this.bookSave();
        });
    },

    save : function () {
        var data = {
            id: $('#id').val(),
            pw: $('#pw').val(),
            name: $('#name').val(),
            sex: $('#sex').val(),
            num: $('#num').val(),
            mail: $('#mail').val(),
            nic_name: $('#nic_name').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/users/signUp',
            dataType: 'text',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원가입 되었습니다..');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    login : function () {
        var data = {
            id: $('#id').val(),
            pw: $('#pw').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/users/signIn',
            dataType: 'text',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            console.log("들어왔는가");
            alert('로그인 되었습니다..');
            window.location.href = '/';
        }).fail(function (error) {
            console.log("들어왔는가");
            alert(JSON.stringify(error));
        });
    },

    bookSave : function () {
        var data = {
            isbm: $('#ISBM').val(),
            bookName: $('#bookName').val(),
            bookAut: $('#bookAut').val(),
            bookTrans: $('#bookTrans').val(),
            bookHouse: $('#bookHouse').val(),
            bookDate: $('#bookDate').val(),
            bookCov: $('#bookCov').val(),
            bookPri: $('#bookPri').val(),
            bookGen: $('#bookGen').val(),
            bookDet: $('#bookDet').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/books/save',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(data) {
            console.log(JSON.stringify(data))
            alert('도서가 등록되었습니다..');
            window.location.href = '/';
        }).fail(function (error, data) {
            console.log("data" + data)
            console.log(error)
            alert(JSON.stringify(error));
        });
    }
};
main.init();