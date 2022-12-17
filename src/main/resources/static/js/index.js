var main = {
    init: function () {
        var _this = this;
        $("#btn-register").on('click', function() {
            _this.register();
        });
        $("#btn-login").on('click', function() {
            _this.login();
        });
    },
    register: function () {
        var data = {
            username: $('#username').val(),
            password: $('#password').val(),
            email: $('#email').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/sign-up',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('회원가입 되었습니다.');
            window.location.href = '/sign-in';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    login: function () {
        var data = {
            username: $('#username').val(),
            password: $('#password').val()
        };

        $.ajax({
            type: 'POST',
            url: '/login',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('로그인 되었습니다.');
            window.location.href = '/main';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};
main.init();