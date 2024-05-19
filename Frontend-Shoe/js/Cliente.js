function save(){
    var data = {
    'tipo_id' : $('#tipo_id').val(),
    'identificacion' : $('#identificacion').val(),
    'nombre' : $('#nombre').val(),
    'apellido' : $('#apellido').val(),
    'telefono' : $('#telefono').val(),
    'ciudad' : $('#ciudad').val(),
    'direccion' : $('#direccion').val(),
    'state' : $('#state').val() == 1 ? true : false 
};
var jsonData = JSON.stringify(data);

    $.ajax({
        url : 'http://localhost:9000/cliente/v1/api/cliente',
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
        'tipo_id' : $('#tipo_id').val(),
        'identificacion' : $('#identificacion').val(),
        'nombre' : $('#nombre').val(),
        'apellido' : $('#apellido').val(),
        'telefono' : $('#telefono').val(),
        'ciudad' : $('#ciudad').val(),
        'direccion' : $('#direccion').val(),
        'state' :parseInt ($('#state').val())
    };

    var id = $('#id').val();
    var jsonData = JSON.stringify(data);

    $.ajax({
        url : 'http://localhost:9000/cliente/v1/api/cliente/' + id, 
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
        url: 'http://localhost:9000/cliente/v1/api/cliente', 
        method : 'GET',
        dataType : 'json',
        success : function(response){
            var html = '';
            var data = response.data;

            if(Array.isArray(data)){
                data.forEach(function(item){

                    html += `<tr>
                    <td>${item.tipo_id}</td>
                    <td>${item.identificacion}</td>
                    <td>${item.nombre}</td>
                    <td>${item.apellido}</td>
                    <td>${item.telefono}</td>
                    <td>${item.ciudad}</td>
                    <td>${item.direccion}</td>
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
        url : 'http://localhost:9000/cliente/v1/api/cliente/' + id, 
        method: "GET",
        dataType: 'json',
        success : function(data){
            $('#id').val(data.data.id);
            $('#tipo_id').val(data.data.tipo_id);
            $('#identificacion').val(data.data.identificacion);
            $('#nombre').val(data.data.nombre);
            $('#apellido').val(data.data.apellido);
            $('#telefono').val(data.data.telefono);
            $('#ciudad').val(data.data.ciudad);
            $('#direccion').val(data.data.direccion);
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

function deleteById(id){
    $.ajax({
        url : 'http://localhost:9000/cliente/v1/api/cliente/' + id, 
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
    $('#tipo_id').val('');
    $('#identificacion').val('');
    $('#nombre').val('');
    $('#apellido').val('');
    $('#telefono').val('');
    $('#ciudad').val('');
    $('#direccion').val('');

}

function filtrar() {
    var nombre = $('#nombreFiltro').val();
    var ciudad = $('#ciudadFiltro').val();

    $.ajax({
        url: 'http://localhost:9000/cliente/v1/api/cliente/clientes',
        method: 'GET',
        dataType: 'json',
        data: {
            nombre: nombre,
            ciudad: ciudad
        },
        success: function (response) {
            var html = '';
            if (response && response.length > 0) {
                response.forEach(function (item) {
                    html += `<tr>
                        <td>${item.tipo_id}</td>
                        <td>${item.identificacion}</td>
                        <td>${item.nombre}</td>
                        <td>${item.apellido}</td>
                        <td>${item.telefono}</td>
                        <td>${item.ciudad}</td>
                        <td>${item.direccion}</td>
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



