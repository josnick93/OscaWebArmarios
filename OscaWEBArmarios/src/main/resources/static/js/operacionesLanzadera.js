//deuelve true si se ha coseguido acceder a una lamzadera
function accederLanzadera(ipdir){
    var ret=false;
    $.ajax({
        url: 'http://' + ipdir + ':8080/ServidorArmarios/JSONServlet',
        data: {orden: 'ACCEDER', entablado: 0, codigoAcesso: '000', url: ""},
        type: 'POST',
        async: false,
        dataType: "json",
        json: "callback",
        success: function (data) {
            var result = JSON.stringify(data);
            if (result === "{\"RESULT \":\"true\"}") ret= true;
            else ret = false;
        },
        error: function () {
            console.log("fataliti");
            ret= false;
        }
    });
    return ret;
}

//abre una ventana remota en una lanzadera
function abrirVentanaRemota(ipdir,urldir){
    $.ajax({
        type: 'GET',
        contentType: 'application/json; charset=utf-8',
        url: '/OscaArmarios/OperacionEntablado/AbrirVentana',
        data: {ip: ipdir, url: urldir},
        dataType: 'json',
        async: true,
        success: function () {
            return true;
        },
        error: function () {
            return false;
        }
    });
}

//geeraunanueva tarea
function generarTareaNueva(lanzadera,urldir,articulo,cantidad,tipo){
    $.ajax({
        type: 'GET',
        contentType: 'application/json; charset=utf-8',
        url: '/OscaArmarios/Operacion/NuevaTarea',
        data: {lanzadera: lanzadera, url: urldir, articulo: articulo, cantidad: cantidad, accion: parseInt(tipo)},
        dataType: 'json',
        async: true,
        success: function () {
            return true;
        },
        error:function(){
            return false;
        }
    });
}