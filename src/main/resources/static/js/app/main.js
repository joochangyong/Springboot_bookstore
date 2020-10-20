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
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data),
        }).done(function() {
            alert('회원가입 되었습니다..');
            window.location.href = '/';
        }).fail(function() {
            if(data.id == "") {
                alert('입력하시오');
            } else {
                alert('사용중인 아이디입니다.');
            }
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
            alert(JSON.stringify(error));
        });
    },

    bookSave : function () {
        var data = {
            isbm: $('#ISBM').val(),
            book_Name: $('#book_Name').val(),
            book_Aut: $('#book_Aut').val(),
            book_Trans: $('#book_Trans').val(),
            book_House: $('#book_House').val(),
            book_Date: $('#book_Date').val(),
            book_Cov: $('#book_Cov').val(),
            book_Pri: $('#book_Pri').val(),
            book_Gen: $('#book_Gen').val(),
            book_Det: $('#book_Det').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/books/save',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            console.log("성공"+data.isbm);
            alert('도서가 등록되었습니다..');
            window.location.href = '/';
        }).fail(function() {
            console.log("실패"+data.isbm);
            if(data.isbm == "") {
                alert('입력하시오');
            } else {
                alert('등록된 도서입니다.');
            }
        });
    }
};
main.init();