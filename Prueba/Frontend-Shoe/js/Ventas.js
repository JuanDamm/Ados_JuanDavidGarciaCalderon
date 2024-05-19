function save(){
    var data = {
    'cliente' :{'id': $('#cliente_id').val()},
    'total' : $('#total').val(),
    'fecha_venta' : $('#fecha_venta').val(),
    'estado' : $('#estado').val(),
    'state' : $('#state').val() == 1 ? true : false 
};
var jsonData = JSON.stringify(data);

    $.ajax({
        url : 'http://localhost:9000/cliente/v1/api/ventas',
        method : 'POST',
        dataType : 'json',
        contentType : 'application/json',
        data : jsonData,
        success : function(data){
            alert("Registro guardado.");
            loadData();
            clearData();
        },
        error : function(error){
            console.error('Error al guardar: ',error);
        }
    });
}

function update(){
    var data = {
        'cliente' :{'id': $('#cliente_id').val()},
    'total' : $('#total').val(),
    'fecha_venta' : $('#fecha_venta').val(),
    'estado' : $('#estado').val(),
        'state' :parseInt ($('#state').val())
    };

    var id = $('#id').val();
    var jsonData = JSON.stringify(data);

    $.ajax({
        url : 'http://localhost:9000/cliente/v1/api/ventas/' + id, 
        method: "PUT",
        dataType: 'json',
        contentType: 'application/json',
        data: jsonData,
        success : function(result){
            alert("Actualizado.");
            loadData(); 
            clearData();

            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text('Agregar');
            btnAgregar.attr('onclick', 'save()');
        },
        error : function(error){
            console.error('Error al actualizar: ', error);
        }
    });
}

function loadData(){
    $.ajax({
        url: 'http://localhost:9000/cliente/v1/api/ventas', 
        method : 'GET',
        dataType : 'json',
        success : function(response){
            var html = '';
            var data = response.data;

            if(Array.isArray(data)){
                data.forEach(function(item){

                    html += `<tr>
                    <td>${item.cliente.nombre} ${item.cliente.apellido}</td>
                    <td>${item.total}</td>
                    <td>${item.fecha_venta}</td>
                    <td>${item.estado}</td>
                    <td>${item.state === true ? 'Activo': 'Inactivo'}</td>
                    <td><button class= "actualizar" onclick="findById(${item.id})">
                    <span class="shadow-a"></span>
                    <span class="edge-a"></span>
                    <span class="front-a text"> Actualizar
                    </span>
                  </button></td>
                    <td><button class= "eliminar" onclick="deleteById(${item.id})">
                    <span class="shadow"></span>
                    <span class="edge"></span>
                    <span class="front text"> Eliminar
                    </span>
                  </button></td>
                    </tr>`;
                });
            } else {
                console.error('El atributo "data" no es un arreglo: ',data);
            }
            $('#resultData').html(html);
        },
        error : function(error){
            console.error('Error al cargar: ',error);
        }
    });
}

function findById(id){
    $.ajax({
        url : 'http://localhost:9000/cliente/v1/api/ventas/' + id, 
        method: "GET",
        dataType: 'json',
        success : function(data){
            $('#id').val(data.data.id);
            var clienteId = data.data.cliente.id;
            var clienteText = data.data.cliente.nombre + ' ' + data.data.cliente.apellido;
            $('#cliente').val(clienteText);
            $('#cliente_id').val(clienteId);
            $('#total').val(data.data.total);
            $('#fecha_venta').val(data.data.fecha_venta);
            $('#estado').val(data.data.estado);
            $('#state').val(data.data.state === true ? 1 : 0);

            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text('Actualizar');
            btnAgregar.attr('onclick', 'update()');

        },
        error : function(error){
            console.error('Error al encontrar: ',error);
        }
    });
}

function loadCliente() {
    $.ajax({
        url: 'http://localhost:9000/cliente/v1/api/cliente',
        method: "GET",
        dataType: 'json',
        success: function(response) {
            if (response.status && Array.isArray(response.data)) {
                var clientes = response.data.map(function(cliente) {
                    return {
                        label: `${cliente.nombre} ${cliente.apellido}`,
                        id: cliente.id,

                    };
                });

                $('#cliente').autocomplete({
                    source : function(request, response){
                        var results = $.ui.autocomplete.filter(clientes, request.term);
                        if (!results.length){
                            results = [{label : 'No se encontraron resultados', value: null}];
                        }
                        response(results);
                    },
                    select: function(event, ui) {
                        $("#cliente_id").val(ui.item.id);
                        $('#cliente').val(ui.item.label); 
                        return false;
                    }
                });
                
            } else {
                console.error("No se obtuvo la lista de personas.");
            }
        },
        error: function(error) {
            console.error("Error de la solicitud: ", error);
        }
    });
}

function deleteById(id){
    $.ajax({
        url : 'http://localhost:9000/cliente/v1/api/ventas/' + id, 
        method : 'DELETE',
        dataType : 'json',
        headers : {
            'Content-Type' : 'application/jsons'
        }
    }).done(function(result){
        alert("Registro eliminado exitoso");
        loadData();
        clearData();
    }).fail(function(xhr, status, error) {
        console.error("Error al eliminar el registro:", error);
    });
}

function clearData(){
    $('#cliente').val('');
    $('#total').val('');
    $('#fecha_venta').val('');
    $('#estado').val('');
}

function filtrar() {
    var nombreFiltro = $('#nombreFiltro').val();
    var nombre, apellido;

    // Verifica si hay un espacio para dividir nombre y apellido
    if (nombreFiltro.includes(' ')) {
        nombre = nombreFiltro.split(' ')[0];
        apellido = nombreFiltro.split(' ')[1];
    } else {
        nombre = nombreFiltro;
        apellido = null; 
    }


    $.ajax({
        url: 'http://localhost:9000/cliente/v1/api/ventas/ventasPorCliente',
        method: 'GET',
        dataType: 'json',
        data: {
            nombre: nombre,
            apellido: apellido
        },
        success: function (response) {
            var html = '';
            if (response && response.length > 0) {
                response.forEach(function (item) {
                    html += `<tr>
                        <td>${item.cliente.nombre} ${item.cliente.apellido}</td>
                        <td>${item.total}</td>
                        <td>${item.fecha_venta}</td>
                        <td>${item.estado}</td>
                        <td>${item.state === true ? 'Activo' : 'Inactivo'}</td>
                        <td><button class= "actualizar" onclick="findById(${item.id})">
                            <span class="shadow-a"></span>
                            <span class="edge-a"></span>
                            <span class="front-a text"> Actualizar </span>
                        </button></td>
                        <td><button class= "eliminar" onclick="deleteById(${item.id})">
                            <span class="shadow"></span>
                            <span class="edge"></span>
                            <span class="front text"> Eliminar </span>
                        </button></td>
                        </tr>`;
                });
            } else {
                html = '<tr><td colspan="10">No se encontraron clientes</td></tr>';
            }
            $('#resultData').html(html);
        },
        error: function (error) {
            console.error('Error al cargar: ', error);
        }
    });
}



