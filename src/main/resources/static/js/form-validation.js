// Example starter JavaScript for disabling form submissions if there are invalid fields
(function () {
    'use strict'

    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.querySelectorAll('.needs-validation')

    // Loop over them and prevent submission
    Array.prototype.slice.call(forms)
        .forEach(function (form) {
            form.addEventListener('submit', function (event) {
                if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }
                form.classList.add('was-validated')
            //TODO Здесь добавить AJAX запрос к серверу

                $.ajax({
                    url: '/index/convert?result-currency=' + result-currency + '&source-currency=' + source-currency + '&source-value' + source-value,
                    type: 'POST',
                    success: function (result) {
                        $('#result-value').text(result.value);
                        alert(result);
                    }
                });

            }, false)
        })
})()
