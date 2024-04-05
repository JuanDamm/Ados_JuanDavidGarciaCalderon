function save(){
    var data = {
        'codigo': $('#codigo').val(),
        'nombre': $('#nombre').val(),
        'precio': $('#precio').val(),
        'cantidad': $('#cantidad').val(), 
        'state': $('#state').val() == 1 ? true : false 
    };

    var jsonData = JSON.stringify(data);
    $.ajax({
        url: 'http://localhost:9000/carrito/v1/api/producto',
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
        'codigo': $('#codigo').val(),
        'nombre': $('#nombre').val(),
        'precio': $('#precio').val(),
        'cantidad': $('#cantidad').val(), 
        'state': parseInt ($('#state').val()),
    };
    var id = $('#id').val(); 
    var jsonData = JSON.stringify(data);

    $.ajax({
        url: 'http://localhost:9000/carrito/v1/api/producto/' + id, 
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
        url: 'http://localhost:9000/carrito/v1/api/producto',
        method : 'GET',
        dataType : 'json',
        success : function (response){
            var html = '';
            var data = response.data;
            if(Array.isArray(data)){
                data.forEach(function (item){
                    html += `<tr>
                    <td>${item.codigo}</td>
                    <td>${item.nombre}</td>
                    <td>${item.precio}</td>
                    <td>${item.cantidad}</td>
                    <td>${item.state === true ? 'Activo': 'Inactivo'}</td>
                    <td><button onclick="findById(${item.id})">Editar</button></td>
                    <td><button onclick="deleteById(${item.id})">Eliminar</button></td>
                    </tr>`;
                }); 
            } else {
                console.error('el atributo "data" no es un arreglo: ', data);
            }
            $('#resultData').html(html);
        },
        error: function (error){
            console.error('Error al registrar', error)
        }

    });
}

function findById(id){
    $.ajax({
        url: 'http://localhost:9000/carrito/v1/api/producto/' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data){
            $('#id').val(data.data.id); 
            $('#codigo').val(data.data.codigo); 
            $('#nombre').val(data.data.nombre);
            $('#precio').val(data.data.precio); 
            $('#cantidad').val(data.data.cantidad);  
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
        url: 'http://localhost:9000/carrito/v1/api/producto/' + id,
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
    $('#codigo').val('');
    $('#nombre').val('');
    $('#precio').val('');
    $('#cantidad').val('');
    $('#state').val('');
}