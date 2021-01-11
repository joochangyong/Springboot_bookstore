var main = {
    init: function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-login').on('click', function () {
            _this.login();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-logout').on('click', function () {
            _this.logout();
        });
    },
    // ///////////////////////////////////////회원가입///////////////////////////////////////
    save: function () {
        var data = {
            id: $('#id').val(),
            pw: $('#pw').val(),
            name: $('#name').val(),
            sex: $('#sex').val(),
            num: $('#num').val(),
            mail: $('#mail').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/users/signUp',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
        }).done(function () {
            alert('회원가입 되었습니다.');
            window.location.href = '/';
        }).fail(function () {
            if (data.id == "") {
                alert('아이디를 입력하시오');
            } else if (data.pw == "") {
                alert('비밀번호를 입력하시오');
            } else if (data.name == "") {
                alert('이름을 입력하시오');
            } else {
                alert('사용중인 아이디입니다.');
            }
        });
    },

    // ///////////////////////////////////////로그인///////////////////////////////////////
    login: function () {
        var data = {
            id: $('#id').val(),
            pw: $('#pw').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/users/signIn',
            dataType: 'text',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    // ///////////////////////////////////////정보 수정///////////////////////////////////////
    update: function () {
        var data = {

            pw: $('#pw').val(),
            num: $('#num').val(),
            mail: $('#mail').val(),
        };

        var id = $('#id').val();

        $.ajax({
            type: 'POST',
            url: '/api/users/update/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
        }).done(function () {
            alert('정보가 수정 되었습니다.');
            window.location.href = '/users/mypage/';
        }).fail(function () {
            alert(JSON.stringify(error));
        });
    },

    // ///////////////////////////////////////로그아웃///////////////////////////////////////
    logout: function () {
        $.ajax({
            type: 'POST',
            url: '/api/users/logout',
        }).done(function () {
            alert('로그아웃 되었습니다.');
            window.location.href = '/';
        })
    }
};
main.init();