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

function init() {
    // value_check();
    const value = value_check();
    checkDelete(value);
}

init();