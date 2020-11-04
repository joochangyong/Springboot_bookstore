var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-login').on('click', function () {
            _this.login();
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
    }
};
main.init();