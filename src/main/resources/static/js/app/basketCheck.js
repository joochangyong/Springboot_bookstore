const isbnCheck  = document.querySelector(".js-isbnCheck"),
    deleteBtn = isbnCheck.querySelector("button");

function value_check() {
    var  check_count = document.getElementsByName("isbn").length;

    for (var i = 0; i < check_count; i++) {
        if (document.getElementsByName("isbn")[i].checked == true) {
            const checkValue = document.getElementsByName("isbn")[i].value;
            console.log(checkValue);
        }
    }
}

function checkDelete(event) {
    // window.location.href = '/basket/delete?isbn=' + checkValue;
    event.preventDefault();
    const currentValue = deleteBtn.value;
    value_check(currentValue);
    currentValue = "";
    console.log("event");
}

// var basketCheck = {
//     init: function () {
//         var _this = this;

//         $('#btn-basketInfoDelete').on('click', function () {
//             _this.basketInfoDelete();
//         });
//     },

//     basketInfoDelete() {
//         var book_isbn = $('#book_isbn').val();

//         $.ajax({
//             type: 'DELETE',
//             url: '/basket/delete/' + book_isbn,
//             dataType: 'json',
//             contentType: 'application/json; charset=utf-8'
//         }).done(function () {
//             window.location.href = '/users/basket';
//         }).fail(function (error) {
//             alert(JSON.stringify(error));
//         });
//     }
// }

function init() {
    // value_check();
    const value = value_check();
    checkDelete(value);
}

init();