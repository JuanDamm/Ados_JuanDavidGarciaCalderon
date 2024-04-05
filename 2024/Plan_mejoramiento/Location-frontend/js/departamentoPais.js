function save(){
    var data = {
        'departamento':{'id': $('#departamento').val()},
        'pais':{'id': $('#pais').val()},
        'state': $('#state').val() === 'Activo' ? true : false


    };

    var jsonData = JSON.stringify(data);
    $.ajax({
        url: 'http://localhost:9000/location/v1/api/departamento_pais',
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
        'departamento': { 'id': $('#departamento').val() },
        'pais': { 'id': $('#pais').val() },
        'state': $('#state').val() === 'Activo' ? 1 : 0

    };
    var id = $('#id').val();
    var jsonData = JSON.stringify(data);

    $.ajax({
        url: 'http://localhost:9000/location/v1/api/departamento_pais/' + id,
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
        url: 'http://localhost:9000/location/v1/api/departamento_pais',
        method: 'GET',
        dataType: 'json',
        success: function(response){
            var html = ''; // Corregido: se cambió htm a html
            var data = response.data; // Se obtiene la data de la respuesta

            if(Array.isArray(data)){
                data.forEach(function (item){
                    html += `<tr>
                    <td>${item.departamento.name}</td>
                    <td>${item.pais.name}</td>
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

function loadDepartamento(){
    $.ajax({
        url: 'http://localhost:9000/location/v1/api/departamento',
        method: 'GET',
        dataType: 'json',
        success: function(response){
            var options = '';
            if(response.status && Array.isArray(response.data)){ // Verifica si la respuesta tiene la propiedad 'status' y si 'data' es un arreglo
                response.data.forEach(function(departamento){
                    options += `<option value="${departamento.id}">${departamento.name}</option>`;  
                });
                $('#departamento').html(options);
            } else {
                console.error('La estructura de la respuesta del servidor no es la esperada:', response);
            }
        },
        error: function(error){
            console.error('Error al cargar departamentos:', error);
        }
    });
}

function loadPais(){
    $.ajax({
        url: 'http://localhost:9000/location/v1/api/pais',
        method: 'GET',
        dataType: 'json',
        success: function(response){
            var options = '';
            if(response.status && Array.isArray(response.data)){ // Verifica si la respuesta tiene la propiedad 'status' y si 'data' es un arreglo
                response.data.forEach(function(pais){
                    options += `<option value="${pais.id}">${pais.name}</option>`;  
                });
                $('#pais').html(options);
            } else {
                console.error('La estructura de la respuesta del servidor no es la esperada:', response);
            }
        },
        error: function(error){
            console.error('Error al cargar departamentos:', error);
        }
    });
}

function findById(id){
    $.ajax({
        url: 'http://localhost:9000/location/v1/api/departamento_pais/' + id,
        method: 'GET',
        dataType: 'json',
        success: function(data){
            $('#id').val(data.data.id);
            $('#departamento').val(data.data.departamento.id); 
            $('#pais').val(data.data.pais.id); 
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
        url: 'http://localhost:9000/location/v1/api/departamento_pais/' + id,
        method: 'DELETE',
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (result) {
        alert("Registro eliminado exitoso");
        loadData(); 
        clearData();
    }).fail(function (xhr, status, error) {
        console.error("Error al eliminar el registro:", error);
    });
}

function clearData(){
    $('#departamento').val('');
    $('#pais').val('');
    $('#state').val('');
}


