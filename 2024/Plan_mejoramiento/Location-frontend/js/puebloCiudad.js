function save(){
    var data = {
        'pueblo':{'id': $('#pueblo').val()},
        'ciudad':{'id': $('#ciudad').val()},
        'state': $('#state').val() === 'Activo' ? true : false


    };

    var jsonData = JSON.stringify(data);
    $.ajax({
        url: 'http://localhost:9000/location/v1/api/pueblo_ciudad',
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        data: jsonData,
        success: function(data){
            alert("Registro exitoso");
            loadData();
            clearData();
        },
        error: function(error){
            console.error('Error al registrar:', error);
        }
       
    });
}

function update() {
    var data = {
        'pueblo': { 'id': $('#pueblo').val() },
        'ciudad': { 'id': $('#ciudad').val() },
        'state': $('#state').val() === 'Activo' ? 1 : 0
    };
    var id = $('#id').val();
    var jsonData = JSON.stringify(data);

    $.ajax({
        url: 'http://localhost:9000/location/v1/api/pueblo_ciudad/' + id,
        data: jsonData,
        method: 'PUT',
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function(result) {
        alert("Registro actualizado exitosamente");
        loadData();
        clearData();

        // actualizar botón
        var btnAgregar = $('button[name="btnAgregar"]');
        btnAgregar.text('Agregar');
        btnAgregar.attr('onclick', 'save()');
    }).fail(function(xhr, status, error) {
        console.error("Error al actualizar el registro:", error);
    });
}



function loadData(){
    $.ajax({
        url: 'http://localhost:9000/location/v1/api/pueblo_ciudad',
        method: 'GET',
        dataType: 'json',
        success: function(response){
            var html = ''; 
            var data = response.data; 

            if(Array.isArray(data)){
                data.forEach(function (item){
                    html += `<tr>
                    <td>${item.pueblo.name}</td>
                    <td>${item.ciudad.name}</td>
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
            console.error('Error al registrar', error);
        }
    });
}

function loadPueblo(){
    $.ajax({
        url: 'http://localhost:9000/location/v1/api/pueblo',
        method: 'GET',
        dataType: 'json',
        success: function(response){
            var options = '';
            if(response.status && Array.isArray(response.data)){ // Verifica si la respuesta tiene la propiedad 'status' y si 'data' es un arreglo
                response.data.forEach(function(pueblo){
                    options += `<option value="${pueblo.id}">${pueblo.name}</option>`;  
                });
                $('#pueblo').html(options);
            } else {
                console.error('La estructura de la respuesta del servidor no es la esperada:', response);
            }
        },
        error: function(error){
            console.error('Error al cargar pueblos:', error);
        }
    });
}

function loadCiudad(){
    $.ajax({
        url: 'http://localhost:9000/location/v1/api/ciudad',
        method: 'GET',
        dataType: 'json',
        success: function(response){
            var options = '';
            if(response.status && Array.isArray(response.data)){ // Verifica si la respuesta tiene la propiedad 'status' y si 'data' es un arreglo
                response.data.forEach(function(ciudad){
                    options += `<option value="${ciudad.id}">${ciudad.name}</option>`;  
                });
                $('#ciudad').html(options);
            } else {
                console.error('La estructura de la respuesta del servidor no es la esperada:', response);
            }
        },
        error: function(error){
            console.error('Error al cargar ciudades:', error);
        }
    });
}





function findById(id){
    $.ajax({
        url: 'http://localhost:9000/location/v1/api/pueblo_ciudad/' + id,
        method: 'GET',
        dataType: 'json',
        success: function(data){
            $('#id').val(data.data.id);
            $('#pueblo').val(data.data.pueblo.id); 
            $('#ciudad').val(data.data.ciudad.id); 
            $('#state').val(data.data.state === true ? 'Activo' : 'Inactivo');

            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text('Actualizar');
            btnAgregar.attr('onclick', 'update()');
        },
        error: function(error){
            console.error('Error al buscar el elemento con ID', id, ':', error);
        }
    });
}

function deleteById(id){
    $.ajax({
        url: 'http://localhost:9000/location/v1/api/pueblo_ciudad/' + id,
        method : 'DELETE',
        headers : {
            'Content-Type' : 'application/json'
        }
    }).done(function(result){
        alert("Registro eliminado");
        loadData();
        clearData();
    });
}

function clearData(){
    $('#pueblo').val('');
    $('#ciudad').val('');
    $('#state').val('');
}


