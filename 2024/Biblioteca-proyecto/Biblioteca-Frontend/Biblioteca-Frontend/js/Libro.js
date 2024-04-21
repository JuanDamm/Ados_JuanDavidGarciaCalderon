function save() {
    var data = {
        'titulo': $('#titulo').val(),
        'autor': $('#autor').val(),
        'isbn': $('#isbn').val(),
        'anoPublicacion': $('#anoPublicacion').val(), 
        'genero': $('#genero').val(),
        'editorial': $('#editorial').val(),
        'state': $('#state').val() == 1 ? true : false 
    };

    var jsonData = JSON.stringify(data);
    $.ajax({
        url: 'http://localhost:9000/biblioteca/v1/api/libro',
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



function update() {
    var data = {
        'titulo': $('#titulo').val(),
        'autor': $('#autor').val(),
        'isbn': $('#isbn').val(),
        'anoPublicacion': $('#anoPublicacion').val(), 
        'genero': $('#genero').val(),
        'editorial': $('#editorial').val(),
        'state': parseInt($('#state').val())
    };
    var id = $('#id').val(); 
    var jsonData = JSON.stringify(data);

    $.ajax({
        url: 'http://localhost:9000/biblioteca/v1/api/libro/' + id, 
        method: "PUT",
        dataType: 'json',
        contentType: 'application/json',
        data: jsonData,
        success: function (result) {
            alert("Actualización exitosa");
            loadData();
            clearData();

            // actualizar botón
            var btnAgregar = $('button[titulo="btnAgregar"]');
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
        url: 'http://localhost:9000/biblioteca/v1/api/libro',
        method: 'GET',
        dataType: 'json',
        success: function(response){
            var html = '';
            var data = response.data;
            if(Array.isArray(data)){
                data.forEach(function (item){
                    html += `<tr>
                    <td>${item.titulo}</td>
                    <td>${item.autor}</td>
                    <td>${item.isbn}</td>
                    <td>${item.anoPublicacion}</td>
                    <td>${item.genero}</td>
                    <td>${item.editorial}</td>
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
        url: 'http://localhost:9000/biblioteca/v1/api/libro/' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data){
            $('#id').val(data.data.id); 
            $('#titulo').val(data.data.titulo); 
            $('#autor').val(data.data.autor);
            $('#isbn').val(data.data.isbn); 
            $('#anoPublicacion').val(data.data.anoPublicacion);  
            $('#genero').val(data.data.genero);  
            $('#editorial').val(data.data.editorial);  
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
        url: 'http://localhost:9000/biblioteca/v1/api/libro/' + id,
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
    $('#titulo').val('');
    $('#autor').val('');
    $('#isbn').val('');
    $('#anoPublicacion').val('');
    $('#genero').val('');
    $('#editorial').val('');
    $('#state').val('');
}