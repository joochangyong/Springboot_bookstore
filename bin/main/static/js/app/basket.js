function basketBookDelete() {
    var check_count = document.getElementsByName("isbn").length;
    for (var i = 0; i < check_count; i++) {
        var checkvalue = document.getElementsByName("isbn");
        if (checkvalue[i].checked == true) {
            var checkValue = document.getElementsByName("isbn")[i].value;
        }
    }

    var data = {
        isbn: checkValue
    };

    if (data.isbn != null) {
        if (confirm("정말 삭제하시겠습니까??") == true) {
            window.location.href = '/basket/delete?isbn=' + data.isbn;
            alert('삭제되었습니다.');
        } else {
        }
    } else {
        alert('삭제할 도서를 선택해주세요');
    }
}