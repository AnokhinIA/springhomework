// Example starter JavaScript for disabling form submissions if there are invalid fields
(function () {
    $('#convert').click(function () {
        let sourceCurrency = $('#source-currency').val();
        let resultCurrency = $('#result-cerrency').val();
        let sourceCurrencyValue = $('#source-currency-value').val();

        if (!sourceCurrencyValue) {
            $('#source-currency-value').removeClass();
            $('#source-currency-value').addClass("form-control is-invalid");
        } else {
            if (sourceCurrencyValue < 0) {
                $('#source-currency-value').removeClass();
                $('#source-currency-value-invalid-feedback').text("Число должно быть больше нуля.")
                $('#source-currency-value').addClass("form-control is-invalid");
            } else {
                $('#source-currency-value').removeClass();
                $('#source-currency-value').addClass("form-control is-valid");
            }
        }

        if ($('#source-currency-value').hasClass("form-control is-valid")) {
            $('#result-value').val("");
            $.ajax({
                url: 'http://localhost:8080/convert?source-currency=' + sourceCurrency +
                    '&result-currency=' + resultCurrency +
                    '&source-currency-value=' + sourceCurrencyValue,
                type: 'POST',
                success: function (result) {
                    $('#result-value').val("Результат: " + result.value + " рублей РФ.");
                }
            });
        } else {
            $('#result-value').val("Расчет невозможен");
        }
    });

})()
