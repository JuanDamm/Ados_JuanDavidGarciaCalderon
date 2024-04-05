//Save
function save(){
    var data = {
        'name': $('#nombre').val(),
        'capital': $('#capital').val(),
        'poblacion': $('#poblacion').val(),
        'state': $('#state').val() == 1 ? true : false //Aquí convertí los valores a tipo Boolean
    };

    var jsonData = JSON.stringify(data);
    $.ajax({
        url: 'http://localhost:9000/location/v1/api/pais' ,
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        data: jsonData,
        success: function (data){
            alert("Registro exitoso");
            loadData();
            clearData();
        },
        error: function (error){
         console.error('Error al registrar', error)
        }

    });
} 

function update(){
    var data = {
        'name': $('#nombre').val(),
        'capital': $('#capital').val(),
        'poblacion': $('#poblacion').val(),
        'state': parseInt($('#state').val()), 
    };
    var id = $('#id').val(); 
    var jsonData = JSON.stringify(data);

    $.ajax({
        url: 'http://localhost:9000/location/v1/api/pais/' + id,
        data: jsonData,
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (result) {
        alert("Registro exitoso");
        loadData();
        clearData();

        // actualizar botón
        var btnAgregar = $('button[name="btnAgregar"]');
        btnAgregar.text('Agregar');
        btnAgregar.attr('onclick', 'save()');
    });
}

function loadData(){
    $.ajax({
        url: 'http://localhost:9000/location/v1/api/pais',
        method: 'GET',
        dataType: 'json',
        success: function(response){
            var html = '';
            var data = response.data;
            if(Array.isArray(data)){
                data.forEach(function (item){
                    html += `<tr>
                    <td>${item.name}</td>
                    <td>${item.capital}</td>
                    <td>${item.poblacion}</td>
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
        url: 'http://localhost:9000/location/v1/api/pais/' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data){
            $('#id').val(data.data.id); 
            $('#nombre').val(data.data.name); 
            $('#capital').val(data.data.capital); 
            $('#poblacion').val(data.data.poblacion); 
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
        url: 'http://localhost:9000/location/v1/api/pais/' + id,
        method: "DELETE",
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
    $('#id').val('');
    $('#nombre').val('');
    $('#capital').val('');
    $('#poblacion').val('');
    $('#state').val('');
}