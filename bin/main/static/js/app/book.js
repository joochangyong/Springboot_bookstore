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
            isbn: $('#isbn').val(),
            bookName: $('#bookName').val(),
            bookAut: $('#bookAut').val(),
            bookTrans: $('#bookTrans').val(),
            bookHouse: $('#bookHouse').val(),
            bookDate: $('#bookDate').val(),
            bookCov: $('#bookCov').val(),
            bookPri: $('#bookPri').val(),
            bookGen: $('#bookGen').val(),
            bookDet: $('#bookDet').val(),
            bookSto: $('#bookSto').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/books/save',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('도서가 등록되었습니다.');
            window.location.href = '/';
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
            bookPri: $('#bookPri').val(),
            bookDet: $('#bookDet').val()
        };

        var isbn = $('#isbn').val();

        $.ajax({
            type: 'POST',
            url: '/api/books/update/' + isbn,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('도서가 수정되었습니다.');
            window.location.href = '/books/bookInfo/' + isbn;
        }).fail(function (error) {
           alert(JSON.stringify(error));
       });
    },

    delete : function () {
        var isbn = $('#isbn').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/books/delete/'+ isbn,
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