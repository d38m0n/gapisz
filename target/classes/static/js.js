function loadSpinner21() {
    document.getElementById("spinnerLoading").innerHTML = '<span class="spinner-grow spinner-grow-sm" style="text-align: center" role="status" aria-hidden="true"></span> Loading...'

}

$('#myModal').on('shown.bs.modal', function () {
    $('#myInput').trigger('focus')
})
$(function () {
    $("#spinner").spinner({
        step: 1,
        numberFormat: "n"
    });

    $("#culture").on("change", function () {
        var current = $("#spinner").spinner("value");
        Globalize.culture($(this).val());
        $("#spinner").spinner("value", current);
    });
});

$(function () {
    $("#datepicker").datepicker();
});

$(function () {
    var handle = $("#custom-handle");
    $("#slider").slider({
        max: 24,
        create: function () {
            handle.text($(this).slider("value"));
        },
        slide: function (event, ui) {
            handle.text(ui.value);
        }
    });
});

$('#myModal').on('shown.bs.modal', function () {
    $('#myInput').trigger('focus')
})

$('body').scrollspy({ target: '#navbar-example' })