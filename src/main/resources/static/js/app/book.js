var main = {
    init : function () {
        var _this = this;

        $('#btn-booksSave').on('click', function () {
            _this.bookSave();
        });

        $('#btn-booksUpdate').on('click', function () {
            _this.bookUpdate();
        });

        $('#btn-booksDelete').on('click', function () {
            _this.delete();
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
        }).done(function() {
            alert('도서가 등록되었습니다..');
            window.location.href = '/books/bookList';
        }).fail(function() {
            if(data.isbm == "") {
                alert('입력하시오');
            } else {
                alert('등록된 도서입니다.');
            }
        });
    },

    bookUpdate : function () {
        var data = {
            bookTrans: $('#bookTrans').val(),
            bookCov: $('#bookCov').val(),
            bookPri: $('#bookPri').val(),
            bookDet: $('#bookDet').val()
        };

        var ISBM = $('#ISBM').val();

        $.ajax({
            type: 'POST',
            url: '/api/books/update/' + ISBM,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('도서가 수정되었습니다..');
            window.location.href = '/books/bookInfo/' + ISBM;
        }).fail(function (error) {
           alert(JSON.stringify(error));
       });
    },

    delete : function () {
        var ISBM = $('#ISBM').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/books/delete/'+ISBM,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('도서가 삭제되었습니다.');
            window.location.href = '/books/bookList';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};
main.init();