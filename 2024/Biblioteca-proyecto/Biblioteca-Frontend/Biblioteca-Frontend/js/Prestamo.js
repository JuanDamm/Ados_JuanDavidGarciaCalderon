function save(){
    var data = {
        'fechaPrestamo' : $('#fechaPrestamo').val(),
        'fechaDevolucionEstimada' : $('#fechaDevolucionEstimada').val(),
        'ejemplar': {
            'id': $('#ejemplar').val(),
        },
        'usuario': {
            'id': $('#usuario').val(),
        },
        'state' : $('#state').val() == 1 ? true : false 
    };

    var jsonData = JSON.stringify(data);

    $.ajax({
        url: 'http://localhost:9000/biblioteca/v1/api/prestamo',
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        data: jsonData,
        success: function (data) {
            alert("Registro exitoso");
            loadData();
            clearData();
        },
        error: function (error) {
            console.error('Error al registrar', error)
        }
    });
}

function update(){
    var data = {
        'fechaPrestamo' : $('#fechaPrestamo').val(),
        'fechaDevolucionEstimada' : $('#fechaDevolucionEstimada').val(),
        'valorTotal' : $('#valor_total').val(),
        'ejemplar': {'id': $('#ejemplar').val(),},
        'usuario': {'id': $('#usuario').val(),},
        'state': parseInt ($('#state').val()),
    };

    var id = $('#id').val();
    var jsonData = JSON.stringify(data);

    $.ajax({
        url: 'http://localhost:9000/biblioteca/v1/api/prestamo/' + id, 
        method: "PUT",
        dataType: 'json',
        contentType: 'application/json',
        data: jsonData,
        success: function (result) {
            alert("Actualización exitosa");
            loadData();
            clearData();

            // actualizar botón
            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text('Agregar');
            btnAgregar.attr('onclick', 'save()');
        },
        error: function (error) {
            console.error("Error al actualizar el registro:", error);
        }
    });
}

function loadData(){
    $.ajax({
        url: 'http://localhost:9000/biblioteca/v1/api/prestamo', 
        method : 'GET',
        dataType : 'json',
        success : function(response){
            var html = '';
            var data = response.data;

            if(Array.isArray(data)){
                data.forEach(function(item){
                    html += `<tr>
                    <td>${item.fechaPrestamo}</td>
                    <td>${item.fechaDevolucionEstimada}</td>

                    <td>${item.usuario.name}</td>
                    <td>${item.ejemplar.libro.titulo}</td>

                    <td>${item.state === true ? 'Activo': 'Inactivo'}</td>
                    <td><button onclick="findById(${item.id})">Editar</button></td>
                    <td><button onclick="deleteById(${item.id})">Eliminar</button></td>
                    </tr>`;
                 });
            } else {
                console.error('El atributo "data" no es un arreglo', data);
            }
            $('#resultData').html(html);
        },
        error : function (error){
            console.error('Error al cargar: ',error);
        }
    });
}


function loadSelects(){
    loadEjemplar();
    loadUsuario();

}

function loadEjemplar(){
    $.ajax({
        url: 'http://localhost:9000/biblioteca/v1/api/ejemplar', 
        method : 'GET',
        dataType : 'json',
        success : function (response){
            var options = '';
            if(response.status && Array.isArray(response.data)){
                response.data.forEach(function(ejemplar){
                    options += `<option value="${ejemplar.id}">${ejemplar.libro.titulo}</option>`;
                });
                $('#ejemplar').html(options);
            } else {
                console.error('La estructura no es la esperada: ', response);
            }
        },
        error : function(error){
            console.error('Error al cargar los ejemplars');
        }
    });
}

function loadUsuario(){
    $.ajax({
        url: 'http://localhost:9000/biblioteca/v1/api/usuario', 
        method : 'GET',
        dataType : 'json',
        success : function (response){
            var options = '';
            if(response.status && Array.isArray(response.data)){
                response.data.forEach(function(usuario){
                    options += `<option value="${usuario.id}">${usuario.name}</option>`;
                });
                $('#usuario').html(options);
            } else {
                console.error('La estructura no es la esperada: ', response);
            }
        },
        error : function(error){
            console.error('Error al cargar los ejemplars');
        }
    });
}

function findById(id){
    $.ajax({
        url: 'http://localhost:9000/biblioteca/v1/api/prestamo/' + id, 
        method :'GET',
        dataType : 'json',
        success :function(data){
            $('#id').val(data.data.id);
            $('#fechaPrestamo').val(data.data.fechaPrestamo);
            $('#fechaDevolucionEstimada').val(data.data.fechaDevolucionEstimada);
            $('#valor_total').val(data.data.valorTotal);
            $('#usuario').val(data.data.usuario.id);
            $('#ejemplar').val(data.data.ejemplar.id);
            $('#state').val(data.data.state === true ? 1 : 0); 

            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text('Actualizar');
            btnAgregar.attr('onclick', 'update()');
        },
        error: function (error){
            console.error('Error al registrar:', error)
        }
    });
}

function deleteById(id) {
    $.ajax({
        url: 'http://localhost:9000/biblioteca/v1/api/prestamo/' + id,
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function(result) {
        alert("Registro eliminado exitoso");
        loadData();
        clearData();
    }).fail(function(xhr, status, error) {
        console.error("Error al eliminar el registro:", error);
    });
}


function clearData(){
    $('#id').val('');
    $('#fechaPrestamo').val('');
    $('#fechaDevolucionEstimada').val('');
    $('#valor_total').val('');
    $('#ejemplar').val('');
    $('#usuario').val('');
    $('#state').val('');
}

