function save(){
    var data = {
    'nombre' : $('#nombre').val(),
    'descripcion' : $('#descripcion').val(),
    'cantidad' : parseInt($('#cantidad').val()) || 0,
        'precio' : parseFloat($('#precio').val()) || 0,
        'iva' : parseFloat($('#iva').val()) || 0,
        'descuento' : parseFloat($('#descuento').val()) || 0,
    'state' : $('#state').val() == 1 ? true : false 
};
var jsonData = JSON.stringify(data);

    $.ajax({
        url : 'http://localhost:9000/cliente/v1/api/producto',
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
        'nombre' : $('#nombre').val(),
    'descripcion' : $('#descripcion').val(),
    'cantidad' : parseInt($('#cantidad').val()) || 0,
        'precio' : parseFloat($('#precio').val()) || 0,
        'iva' : parseFloat($('#iva').val()) || 0,
        'descuento' : parseFloat($('#descuento').val()) || 0,
        'state' :parseInt ($('#state').val())
    };

    var id = $('#id').val();
    var jsonData = JSON.stringify(data);

    $.ajax({
        url : 'http://localhost:9000/cliente/v1/api/producto/' + id, 
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
        url: 'http://localhost:9000/cliente/v1/api/producto', 
        method : 'GET',
        dataType : 'json',
        success : function(response){
            var html = '';
            var data = response.data;

            if(Array.isArray(data)){
                data.forEach(function(item){

                    html += `<tr>
                    <td>${item.nombre}</td>
                    <td>${item.descripcion}</td>
                    <td>${item.cantidad}</td>
                    <td>${item.precio}</td>
                    <td>${item.iva}</td>
                    <td>${item.descuento}</td>
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
        url : 'http://localhost:9000/cliente/v1/api/producto/' + id, 
        method: "GET",
        dataType: 'json',
        success : function(data){
            $('#id').val(data.data.id);
            $('#nombre').val(data.data.nombre);
            $('#descripcion').val(data.data.descripcion);
            $('#cantidad').val(data.data.cantidad);
            $('#precio').val(data.data.apellido);
            $('#iva').val(data.data.iva);
            $('#descuento').val(data.data.descuento);
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
        url : 'http://localhost:9000/cliente/v1/api/producto/' + id, 
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
    $('#nombre').val('');
    $('#descripcion').val('');
    $('#cantidad').val('');
    $('#precio').val('');
    $('#iva').val('');
    $('#descuento').val('');


}

function filtrar() {
    var nombre = $('#nombreFiltro').val();


    $.ajax({
        url: 'http://localhost:9000/cliente/v1/api/producto/productos',
        method: 'GET',
        dataType: 'json',
        data: {
            nombre: nombre
        },
        success: function (response) {
            var html = '';
            if (response && response.length > 0) {
                response.forEach(function (item) {
                    html += `<tr>
                    <td>${item.nombre}</td>
                    <td>${item.descripcion}</td>
                    <td>${item.cantidad}</td>
                    <td>${item.precio}</td>
                    <td>${item.iva}</td>
                    <td>${item.descuento}</td>
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
                html = '<tr><td colspan="10">No se encontraron Producto</td></tr>';
            }
            $('#resultData').html(html);
        },
        error: function (error) {
            console.error('Error al cargar: ', error);
        }
    });
}



