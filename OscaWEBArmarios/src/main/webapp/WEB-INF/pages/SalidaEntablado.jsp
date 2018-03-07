<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Portátil1
  Date: 19/05/2017
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Salida Entablado</title>
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css" type="text/css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/css/dataTables.bootstrap.min.css" rel="stylesheet"/>
    <link href="css/calculator.css" rel="stylesheet"/>
    <script type="text/javascript" src="js/calculator.js"></script>

</head>

<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
            <a class="navbar-brand" href="#">
                <p class="cabecera">${lanzadera.descripcion}</p>
            </a>
        </div>
        <div class="navbar-collapse collapse" id="navbar">
            <ul class="nav navbar-nav navbar-right" style="border-left: 2px solid white">
                <li  style="border-right: 2px solid white">
                    <a href="/OscaArmarios/EntradaMaterialHome.html?lanzadera=${lanzadera.id_lanzadera}">
                        <p class="cabecera text-center">&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon glyphicon-save"></span>&nbsp;&nbsp;Entrada&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                    </a>
                </li>
                <li  style="border-right: 2px solid white" >
                    <a href="/OscaArmarios/ConsultaMaterialHome.html?lanzadera=${lanzadera.id_lanzadera}">
                        <p class="cabecera text-center">&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon glyphicon-search"></span>&nbsp;&nbsp;Consulta&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                    </a>
                </li>
                <li class="active" style="border-right: 2px solid white">
                    <a href="/OscaArmarios/SalidaMaterialHome.html?lanzadera=${lanzadera.id_lanzadera}">
                        <p class="cabecera text-center ">&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon glyphicon-open"></span>&nbsp;&nbsp;Salida&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                    </a>
                </li>
                <li class="text-center"> </li>
                <li class="text-center">
                    <button class="btn btn-default" onclick="goBack()" style="margin:5px;margin-left:5px;height:60px">
                        <script>
                            function goBack() {
                                window.history.back();
                            }
                        </script>
                        <p class="text-center "> <span class="icon-flipped glyphicon glyphicon-share-alt" style="vertical-align:middle;font-size: 28px;"></span> </p>
                    </button>
                </li>
                <li class="text-center">
                    <button class="btn btn-default" onclick="goHome()" style="margin:5px;margin-left:5px;height:60px">
                        <script>
                            function goHome() {
                                window.location.href="/OscaArmarios/Home.html";
                            }
                        </script>
                        <a href="/OscaArmarios/Home.html" style='color:black'>
                            <p class="text-center ">
                                <span class="icon-flipped glyphicon glyphicon-home" style="vertical-align:middle;font-size: 28px;">
					            </span>
                            </p>
                        </a>
                    </button>
                </li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
    <!--/.container-fluid -->
    <!--fin nav-->
</nav>
<div class="py-5">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h1 class="my-3">Confirmar Salida</h1>
            </div>
            <table class="table table-striped custab">
                <thead>
                <tr>
                    <th>Código</th>
                    <th>Proveedor</th>
                    <th>Descripción</th>
                    <th class="text-center bg-primary">Cantidad</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${articulo.articulo}</td>
                    <td></td>
                    <td>${articulo.descripcion}</td>
                    <td class="bg-success">
                        <val id="cantidad" type="number" class="bg-success one input-group-addon w-100 m-0 text-center" contenteditable="">
					  <h3 class="text-center w-100">0.0</h3>
				   </val> </td>
                </tr>
                </tbody>
            </table>
            <div class="col-md-6">
                <div class="row">
                    <div class="col-md-8">
                        <table class="table table-striped custab w-100 py-1">
                            <thead>
                            <tr>
                                <th>Lanzadera</th>
                                <th>Entablado</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>${posicionArticulo.lift}</td>
                                <td>${posicionArticulo.shelf}</td>
                            </tr>
                            </tbody>
                        </table>

                    </div>
                    <div class="col-md-4"></div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-6">
                        <a id="sacarMaterial" class="btn btn-warning my-3 mx-0 btn-lg w-25 text-center">Sacar Material</a>
                    </div>
                    <div class="col-md-6">
                        <a class="btn btn-primary my-3 mx-0 btn-lg w-25 text-center" id="traerEntablado">Traer entablado</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <h1 class="mx-4 py-4">Entablado</h1>
            </div>
        </div>
        <div class="row">
            <!--dibujar entablado-->
            <div class="table-responsive col-md-17" id='entablado'>
                <c:out value="${entabladoHTML}" escapeXml="false"/>
            </div>
        </div>
    </div>

</div>

<!--Diagolo espera -->
<div id="waitDialog" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Bajando entablado</h4>
            </div>
            <div class="modal-body">
                <p><img src="https://upload.wikimedia.org/wikipedia/commons/b/b1/Loading_icon.gif" /></p>
                <p>Bajando entablado , por favor espere...</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>
<!--Diagolo espera -->

<!-- Dialogo no se ha bajado el entablado -->
<!-- Modal -->
<div id="traerEntabladoError" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Sacar entablado</h4>
            </div>
            <div class="modal-body">
                <p>Antes de selecionar una posicion debes traer el entablado</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>

<!--Diagolo localizacion añadida -->
<div id="localizacionadd" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Material extraido correctamente</h4>
            </div>
            <div class="modal-body">
                <p>Se ha extraido el material correctamente</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>
<!--Diagolo localizacion añadida -->
<div id="localizacionaddError" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Error al añadir ubicacion</h4>
            </div>
            <div class="modal-body">
                <p>No se ha podido añadir la ubicacion</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>

<!--Diagolo localizacion añadida -->
<div id="ErrorCantidad" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Cantidad incorrecta</h4>
            </div>
            <div class="modal-body">
                <p>No puedes sacar una cantidad igual a 0 ó mayor que el stock</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>






    <script src="js/tether.min.js" type="text/javascript"></script>
    <script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="js/dataTables.bootstrap.min.js" type="text/javascript"></script>
    <script>

        function Info () { // constructor function
            this.msg="Inicio";
        }
        var msg = new Info();



        $(document).ready(function(){
            $( "#addMaterial" ).click(function() {
                if(parseInt($('#cantidad').text())==0){
                    $('#errorModal').modal('toggle');
                }
                else if(parseInt($('#cantidad').text())>${posicionArticulo.cantidad}){
                    $('#errorModal').modal('toggle');
                }
                else{
                    window.location.href = '/OscaArmarios/EntradaSeleccionUbicacionFinal.html';
                }
            });

            $("#traerEntablado").click(function() {
                $.ajax({
                    type: 'GET',
                    contentType : 'application/json; charset=utf-8',
                    url: '/OscaArmarios/SalidaEntalado/TraerEntablado',
                    data: { lanzadera:parseInt(${lanzadera}) , entablado:parseInt(${entablado})},
                    dataType: 'json',
                    async : true,
                    beforeSend: function()
                    {
                        $('#waitDialog').modal('toggle');
                    },
                    success: function(data){
                        $('#waitDialog').modal('hide');
                        msg.msg="Correct";
                    },
                    error: function(data)
                    {

                    }
                });
            });


            $("#sacarMaterial").click(function() {
                if(parseFloat(${posicionArticulo.cantidad})<parseFloat($('#cantidad').text())
                 || parseFloat($('#cantidad').text()) <=0.0 ){

                    $('#ErrorCantidad').modal('toggle');
                }
                else if(msg.msg=="Correct"){
                    $.ajax({
                        type: 'GET',
                        contentType : 'application/json; charset=utf-8',
                        url: '/OscaArmarios/SalidaEntalado/SacarMaterial',
                        //lanzadera entablado x y articulo cantidad
                        data: { lanzadera:parseInt(${lanzadera}) , entablado:parseInt(${entablado}) ,
                            xPos:parseFloat(${columna}) , yPos: parseFloat(${fila}), cantidad:parseFloat($('#cantidad').text())},
                        dataType: 'json',
                        async : true,
                        beforeSend: function()
                        {
                            $('#waitDialog').modal('toggle');
                        },
                        success: function(data){
                            $('#waitDialog').modal('hide');
                            $('#localizacionadd').modal('toggle');
                            location.reload();

                        },
                        error: function()
                        {
                            $('#localizacionaddError').modal('toggle');
                        }
                    });
                }else{
                    $('#traerEntabladoError').modal({
                        show: 'true'
                    });
                }

            });



        });


    </script>
</body>

</html>
