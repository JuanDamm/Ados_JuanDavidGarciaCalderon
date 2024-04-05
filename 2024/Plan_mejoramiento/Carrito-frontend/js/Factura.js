function save(){
    var data = {
        'codigo' : $('#codigo').val(),
        'fecha' : $('#fecha').val(),
        'valorTotal' : $('#valor_total').val(),
        'cliente': {
            'id': $('#cliente').val(),
        },
        'productoId': {
            'id': $('#producto').val(),
        },
        'state' : $('#state').val() == 1 ? true : false 
    };

    var jsonData = JSON.stringify(data);

    $.ajax({
        url: 'http://localhost:9000/carrito/v1/api/factura',
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
        'codigo' : $('#codigo').val(),
        'fecha' : $('#fecha').val(),
        'valorTotal' : $('#valor_total').val(),
        'cliente': {'id': $('#cliente').val(),},
        'productoId': {'id': $('#producto').val(),},
        'state': parseInt ($('#state').val()),
    };

    var id = $('#id').val();
    var jsonData = JSON.stringify(data);

    $.ajax({
        url: 'http://localhost:9000/carrito/v1/api/factura/' + id, 
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
        url: 'http://localhost:9000/carrito/v1/api/factura', 
        method : 'GET',
        dataType : 'json',
        success : function(response){
            var html = '';
            var data = response.data;

            if(Array.isArray(data)){
                data.forEach(function(item){
                    html += `<tr>
                    <td>${item.codigo}</td>
                    <td>${item.fecha}</td>
                    <td>${item.valorTotal}</td>
                    <td>${item.cliente.nombre}</td>
                    <td>${item.productoId.nombre}</td>
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

function loadCliente(){
    $.ajax({
        url: 'http://localhost:9000/carrito/v1/api/cliente', 
        method : 'GET',
        dataType : 'json',
        success : function (response){
            var options = '';
            if(response.status && Array.isArray(response.data)){
                response.data.forEach(function(cliente){
                    options += `<option value="${cliente.id}">${cliente.nombre}</option>`;
                });
                $('#cliente').html(options);
            } else {
                console.error('La estructura no es la esperada: ', response);
            }
        },
        error : function(error){
            console.error('Error al cargar los clientes');
        }
    });
}

function loadProducto(){
    $.ajax({
        url: 'http://localhost:9000/carrito/v1/api/producto', 
        method : 'GET',
        dataType : 'json',
        success : function (response){
            var options = '';
            if(response.status && Array.isArray(response.data)){
                response.data.forEach(function(producto){
                    options += `<option value="${producto.id}">${producto.nombre}</option>`;
                });
                $('#producto').html(options);
            } else {
                console.error('La estructura no es la esperada: ', response);
            }
        },
        error : function(error){
            console.error('Error al cargar los clientes');
        }
    });
}

function findById(id){
    $.ajax({
        url: 'http://localhost:9000/carrito/v1/api/factura/' + id, 
        method :'GET',
        dataType : 'json',
        success :function(data){
            $('#id').val(data.data.id);
            $('#codigo').val(data.data.codigo);
            $('#fecha').val(data.data.fecha);
            $('#valor_total').val(data.data.valorTotal);
            $('#cliente').val(data.data.cliente.id);
            $('#producto').val(data.data.productoId.id);
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
        url: 'http://localhost:9000/carrito/v1/api/factura/' + id,
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
    $('#fecha').val('');
    $('#valor_total').val('');
    $('#cliente').val('');
    $('#producto').val('');
    $('#state').val('');
}

