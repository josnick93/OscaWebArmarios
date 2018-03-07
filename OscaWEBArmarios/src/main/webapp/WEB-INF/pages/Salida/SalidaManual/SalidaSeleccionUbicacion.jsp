<%--
  Created by IntelliJ IDEA.
  User: José Ángel Caudevílla Casaús
  Date: 19/05/2017
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.oscasistemas.controller.WebService.WebServicesInit" %>
<%@ page import="com.dynamics.webServices.Bin_Content_WS.BinContentWS" %>
<html>

<head>
    <title>Salida Seleccion Ubicacion</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="css/bootstrapstyle.min.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.numpad.js"></script>
    <link rel="stylesheet" href="css/jquery.numpad.css">
    <style>
        /* Remove the navbar's default margin-bottom and rounded borders */

        p.cabecera {
            font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
            font-size: 28px;
            font-style: normal;
            font-variant: normal;
            font-weight: 200;
            line-height: 20px;
            color: #fdfdfd;
        }

        .icon-flipped {
            transform: scaleX(-1);
            -moz-transform: scaleX(-1);
            -webkit-transform: scaleX(-1);
            -ms-transform: scaleX(-1);
        }

        .navbar {
            margin-bottom: 0;
            border-radius: 0;
            background: #626262;
        }

        /* Set height of the grid so .sidenav can be 100% (adjust as needed) */

        .row.content {
            height: 450px
        }

        /* Set gray background color and 100% height */

        .sidenav {
            padding-top: 20px;
            background-color: #f1f1f1;
            height: 100%;
        }

        /* Set black background color, white text and some padding */

        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }

        /* On small screens, set height to 'auto' for sidenav and grid */

        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }

            .row.content {
                height: auto;
            }
        }

        .navbar .nav .active {
            background-color:;
        }

        .navbar .nav .active > a {
            color: #000;
            background-color: #DD0000;
        }

        [class*="col-"] {
            background-clip: padding-box;
            border: 20px solid transparent;
        }

        /***********************
              OUTLINE BUTTONS
            ************************/

        .btn.outline {
            background: none;
            padding: 12px 22px;
        }

        .btn-primary.outline {
            border: 2px solid #DD0000;
            color: #626262;
        }

        .btn-primary.outline:active {
            background: #DD0000;
        }

        .btn-primary.outline:hover,
        .btn-primary.outline:focus,
        .btn-primary.outline:active,
        .btn-primary.outline.active,
        .open > .dropdown-toggle.btn-primary {
            color: #626262;
            border-color: #DD0000;
        }

        .btn-primary.outline:active,
        .btn-primary.outline.active {
            border-color: #DD0000;
            color: #626262;
            box-shadow: none;
        }

        /***********************
              CUSTON BTN VALUES
            ************************/

        .btn {
            padding: 14px 24px;
            border: 0 none;
            font-weight: 700;
            letter-spacing: 1px;
            text-transform: uppercase;
        }

        .btn:focus,
        .btn:active:focus,
        .btn.active:focus {
            outline: 0 none;
        }

        .table:tr {
            border: 0.5px solid #000000;
            background: #fdfcfc;
        }

        .table-bordered > thead > tr > th,
        .table-bordered > tbody > tr > th,
        .table-bordered > tfoot > tr > th,
        .table-bordered > thead > tr > td,
        .table-bordered > tbody > tr > td,
        .table-bordered > tfoot > tr > td {
            border: 0.5px solid #000000;
        }

        .nopadding {
            padding-right: 0;
            padding-left: 0;
        }

        ul.list-group:after {
            clear: both;
            display: block;
            content: "";
            overflow: auto;
        }

        .list-group-item {
            float: left;
        }

        .modal-header-danger {
            color: #fdfcfc;
            padding: 9px 15px;
            border-bottom: 1px solid #eee;
            background-color: #626262;
            -webkit-border-top-left-radius: 5px;
            -webkit-border-top-right-radius: 5px;
            -moz-border-radius-topleft: 5px;
            -moz-border-radius-topright: 5px;
            border-top-left-radius: 5px;
            border-top-right-radius: 5px;
        }

        .nmpd-grid {
            border: none;
            padding: 20px;
        }

        .nmpd-grid > tbody > tr > td {
            border: none;
        }

        /* Some custom styling for Bootstrap */
        .qtyInput {
            display: block;
            width: 100%;
            padding: 6px 12px;
            color: #555;
            background-color: white;
            border: 1px solid #ccc;
            border-radius: 4px;
            -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
            box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
            -webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow ease-in-out .15s;
            -o-transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
            transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
    </style>
    <style>
        table {
            table-layout: fixed;
        }

        .div-table-content {
            height: 225px;
            overflow-y: auto;
        }
    </style>
</head>

<body style="background:#fdfcfc">
<!-- Static navbar -->
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar"><span class="sr-only">Toggle navigation</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span></button>
            <a class="navbar-brand" href="#">
                <p class="cabecera">${lanzadera.descripcion}</p>
            </a>
        </div>
        <div class="navbar-collapse collapse" id="navbar">
            <ul class="nav navbar-nav navbar-right" style="border-left: 2px solid white">
                <li style="border-right: 2px solid white">
                    <a href="/OscaArmarios/EntradaMaterialHome.html?lanzadera=${lanzadera.id_lanzadera}">
                        <p class="cabecera text-center">&nbsp;&nbsp;&nbsp;<span
                                class="glyphicon glyphicon glyphicon-save"></span>&nbsp;&nbsp;Entrada&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </p>
                    </a>
                </li>
                <li style="border-right: 2px solid white">
                    <a href="/OscaArmarios/ConsultaMaterialHome.html?lanzadera=${lanzadera.id_lanzadera}">
                        <p class="cabecera text-center">&nbsp;&nbsp;&nbsp;<span
                                class="glyphicon glyphicon glyphicon-search"></span>&nbsp;&nbsp;Consulta&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </p>
                    </a>
                </li>
                <li class="active" style="border-right: 2px solid white">
                    <a href="/OscaArmarios/SalidaMaterialHome.html?lanzadera=${lanzadera.id_lanzadera}">
                        <p class="cabecera text-center ">&nbsp;&nbsp;&nbsp;<span
                                class="glyphicon glyphicon glyphicon-open"></span>&nbsp;&nbsp;Salida&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </p>
                    </a>
                </li>
                <li class="text-center"></li>
                <li class="text-center">
                    <button class="btn btn-default" onclick="goBack()" style="margin:5px;margin-left:5px;height:60px">
                        <script>
                            function goBack() {
                                window.history.back();
                            }
                        </script>
                        <p class="text-center "><span class="icon-flipped glyphicon glyphicon-share-alt"
                                                      style="vertical-align:middle;font-size: 28px;"></span></p>
                    </button>
                </li>
                <li class="text-center">
                    <button class="btn btn-default" onclick="goHome()" style="margin:5px;margin-left:5px;height:60px">
                        <script>
                            function goHome() {
                                window.location.href = "/OscaArmarios/Home.html";
                            }
                        </script>
                        <a href="/OscaArmarios/Home.html" style='color:black'>
                            <p class="text-center ">
                                <span class="icon-flipped glyphicon glyphicon-home"
                                      style="vertical-align:middle;font-size: 28px;">
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
<div class="container" style="width: 100%;">
    <h3 class="text-left" style="margin-left: 20px;">ARTÍCULO SELECCIONADO</h3>
    <div class="row">
        <div class="col-sm-2">
            <img class="d-block img-fluid float-left"
                 src="http://s2.subirimagenes.com/imagen/previo/thump_9752997pieza.png" height="150" width="170">
        </div>
        <div class="col-sm-10">
            <table class="table table-bordered table-responsive">
                <thead bgcolor="#fdfcfc" style="background:#626262">
                <tr>
                    <th width="13%">
                        <font color="#fdfcfc">CÓDIGO</font>
                    </th>
                    <th width="13%">
                        <font color="#fdfcfc">ALIAS</font>
                    </th>
                    <th width="75%">
                        <font color="#fdfcfc">DESCRIPCIÓN</font>
                    </th>
                    <th>
                        <font color="#fdfcfc">STOCK</font>
                    </th>
                    <th>
                        <font color="#fdfcfc">PESO</font>
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td >${articulo.no}</td>
                    <td >${articulo.searchDescription}</td>
                    <td width="80%">${articulo.description} ${articulo.description2}</td>
                    <td>${articulo.safetyStockQuantity}</td>
                </tr>
                </tbody>
            </table>
            <h4 class="text-left">SALIDA MANUAL</h4>
            <div class="row">
                 <span style="float: right;margin-right: 2%;margin-top:-25px">
									  <!--Introducir cantidad-->
                    <form class="text-right">
                         <h3>INTRODUCIR CANTIDAD&nbsp;&nbsp;
                             <input id="text-basic" type="number"
                                    style="font-size:25px;width:150px;text-align: right;border: 4px solid #DD0000;"
                                    name="fname"> </h3>
                         <h4 id='cantidadTotal'>PESO TOTAL: 0.0 Kg.</h4>
                    </form>
                </span>
            </div>
        </div>
    </div>
    <div class="col-md-12 panel panel-default" style="margin-top:-50px">
        <h4 class="text-left">ACTUALMENTE EN LANZADERA</h4>
        <table class="table  table-condensed  table-responsive ">
            <thead style="background:#626262">
            <tr>
                <th class="text-center">
                    <font color="#fdfcfc">LANZADERA</font>
                </th>
                <th class="text-center">
                    <font color="#fdfcfc">ENTABLADO</font>
                </th>
                <th class="text-center">
                    <font color="#fdfcfc">FILA</font>
                </th>
                <th class="text-center">
                    <font color="#fdfcfc">COL</font>
                </th>
                <th class="text-center">
                    <font color="#fdfcfc">CAJA</font>
                </th>

                <th class="text-center">
                    <font color="#fdfcfc">STOCK</font>
                </th>
                <th class="text-center">
                    <font color="#fdfcfc">PESO</font>
                </th>
                <th class="text-center">
                    <font color="#fdfcfc">PESO MAX ENTABLADO</font>
                </th>
                <th class="text-center">
                    <font color="#fdfcfc">ACCEDER</font>
                </th>
            </tr>
            </thead>
        </table>
        <div class="div-table-content">
            <table class="table table-condensed table-bordered">
                <tbody>
                <c:if test="${!empty ubicaciones}">
                    <c:forEach items="${ubicaciones}" var="ubicacion">
                        <tr>
                            <td class="text-center">${ubicacion.entablado.lanzadera.descripcion}</td>
                            <td class="text-center">${ubicacion.entablado.codigo}</td>
                            <td class="text-center">${ubicacion.fila}</td>
                            <td class="text-center">${ubicacion.columna}</td>
                            <td class="text-center">${ubicacion.tipoCaja.tipo_caja}</td>
                            <td class="text-center">${ubicacion.cantidad}</td>
                            <td class="text-center">${ubicacion.entablado.pesoMaximo}</td>
                            <td class="text-center">${ubicacion.entablado.pesoActual}</td>
                            <td class="text-center">
                                <a id='salida' class="btn btn-primary btn-lg outline px-3 mx-3"
                                   url="/OscaArmarios/SalidaSeleccionUbicacionFinal.html?articulo=${articulo.no}&amp;entablado=${ubicacion.entablado.codigo}&amp;fila=${ubicacion.fila}&amp;columna=${ubicacion.columna}&amp;cantidad=${cantidad}"
                                   url2="/OscaArmarios/TareaSalidaSeleccionUbicacionFinal.html?articulo=${articulo.no}&amp;entablado=${ubicacion.entablado.codigo}&amp;fila=${ubicacion.fila}&amp;columna=${ubicacion.columna}&amp;cantidad=${cantidad}"
                                   ip=${ubicacion.entablado.lanzadera.direccion_ip} articulo="${articulo.no}" lanzadera="${ubicacion.lanzadera.id_lanzadera}" data-toggle="modal">SALIDA</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${!empty reservas}">
                    <c:forEach items="${reservas}" var="reserva">
                        <c:choose>
                            <c:when test="${empty lanzaderaActual || reserva.entablado.lanzadera.id_lanzadera==lanzaderaActual.id_lanzadera}">
                                <tr>
                                    <td class="text-center">${reserva.entablado.lanzadera.descripcion}</td>
                                    <td class="text-center">${reserva.entablado.codigo}</td>
                                    <td class="text-center">${reserva.entablado.codigo}</td>
                                    <td class="text-center">MEDIDA ${reserva.ncolumnas}x${reserva.nfilas}</td>
                                    <td class="text-center"></td>
                                    <td class="text-center">${reserva.cantidad}</td>
                                    <td class="text-center">${reserva.infoArticulo.netWeight}</td>
                                    <td class="text-center">
                                        <a id='salida' class="btn btn-primary btn-lg outline px-3 mx-3"
                                           url="/OscaArmarios/SalidaSeleccionUbicacionFinalMedida.html?articulo=${articulo.no}&amp;entablado=${reserva.entablado.codigo}&amp;fila=${reserva.fila}&amp;columna=${reserva.columna}&amp;cantidad=${cantidad}"
                                           url2="/OscaArmarios/TareaSalidaSeleccionUbicacionFinalMedida.html?articulo=${articulo.no}&amp;entablado=${reserva.entablado.codigo}&amp;fila=${reserva.fila}&amp;columna=${reserva.columna}&amp;cantidad=${cantidad}"
                                           ip=${reserva.entablado.lanzadera.direccion_ip} articulo="${articulo.no}" lanzadera="${reserva.lanzadera.id_lanzadera}" data-toggle="modal">SALIDA</a>
                                    </td>
                                </tr>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
        <div class="col-md-5">
            <c:if test="${!empty destinos}">
                <div class="form-group form-group-sm">
                    <input id="botonDestino" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
                           style="font-size:25px;width:250px;text-align: right;border: 4px solid #DD0000;" value="CMDN.01.0001">
                    </input>
                </div>
            </c:if>
        </div>
    </div>
</div>
<!--row-->
<!--Diagolo cantidad -->
<div id="dialogoCantidad" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title">Introducir cantidad</h4>
            </div>
            <div class="modal-body">
                <p>Debes introducir una cantidad</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-lg outline px-3 mx-3"
                        style="float: right;background:#DD0000;color: white" data-dismiss="modal">CERRAR
                </button>
            </div>
        </div>
    </div>
    <!--container-->
</div>
<!--Diagolo cantidad -->
<div id="dialogoCantidadIncorrecta" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title">Cantidad incorrecta</h4>
            </div>
            <div class="modal-body">
                <p>La cantidad introducida es superior a la de la caja</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-lg outline px-3 mx-3"
                        style="float: right;background:#DD0000;color: white;" data-dismiss="modal">CERRAR
                </button>
            </div>
        </div>
    </div>
    <!--container-->
</div>

<div id="dialogoTareaCreada" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title">Tarea creada correctamente</h4>
            </div>
            <div class="modal-body">
                <p id='nuevaTareaInfo'>Tarea generada en la lanzadera</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-lg outline px-3 mx-3"
                        style="float: right;background:#DD0000;color: white;" data-dismiss="modal">ACEPTAR
                </button>
            </div>
        </div>
    </div>
    <!--container-->
</div>

<!-- Acesso remoto a lanzadera -->
<div id="accesoLanzaderaExito" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title">Lanzadera libre</h4>
            </div>
            <div class="modal-body">
                <p>Ve a otra lanzadera/ubicacion para completar la salida.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-lg outline px-3 mx-3"
                        style="float: right;background:#DD0000;color: white;" data-dismiss="modal">ACEPTAR
                </button>
            </div>
        </div>
    </div>
    <!--container-->
</div>
<div id="dialogoSeleccionDestino" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title">Error</h4>
            </div>
            <div class="modal-body"> <strong>Destino desconocido</strong>
                <p/>
                <p>Debes seleccionar un destino para poder realizar la salida.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-lg outline px-3 mx-3" style="float: right;background:#009900;color: white;" data-dismiss="modal">
                    CERRAR
                </button>
            </div>
        </div>
    </div>
</div>
<div class="modal" id="dialogoSeleccionarDestino" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="label">Selección destino</h4>
            </div>
            <div class="modal-body">
                <table  id="destinTable" class="table table-striped table-bordered nowrap" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Descripcion</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${destinos}" var="dest">
                        <tr  class='clickable-row' style="cursor: pointer;" ubiDest="${dest.code}">
                            <td>
                                    ${dest.code}
                            </td>
                            <td>
                                    ${dest.description}
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="modal-footer"> <a class="btn btn-primary" href="#myModal" style="margin-right: auto; margin-left: auto; width: 300px;background:#DD0000" data-dismiss="modal">Cerrar</a> </div>
        </div>
    </div>
</div>




<script>

    // Set NumPad defaults for jQuery mobile.
    // These defaults will be applied to all NumPads within this document!
    $.fn.numpad.defaults.gridTpl = '<table class="table modal-content"></table>';
    $.fn.numpad.defaults.backgroundTpl = '<div class="modal-backdrop in"></div>';
    $.fn.numpad.defaults.displayTpl = '<input type="text" class="form-control" />';
    $.fn.numpad.defaults.buttonNumberTpl = '<button type="button" class="btn btn-default " style="width: 100%;"></button>';
    $.fn.numpad.defaults.buttonFunctionTpl = '<button type="button" class="btn" style="width: 100%;"></button>';
    $.fn.numpad.defaults.onKeypadCreate = function () {
        $(this).find('.done').addClass('btn-primary').css('background', '#626262');
    };


    $(document).ready(function () {
        $("body").css("overflow", "hidden");
        $('#text-basic').numpad();
        var ubiDest;
        var pesoTotal=
        ${articulo.netWeight}*
        $('#text-basic').val();
        $('#cantidadTotal').text("PESO TOTAL: " + pesoTotal + " Kg.");

        //seleccion ubicacion
        $(".clickable-row").click(function() {
            ubiDest=$(this).attr('ubiDest');
            $("#botonDestino").css('border', 'black');
            $('#botonDestino').val($(this).attr('ubiDest'));
            $('#dialogoSeleccionarDestino').modal('toggle');
        });

        $("#botonDestino").click(function () {
            $('#dialogoSeleccionarDestino').modal('toggle');
        });

        $("a[id=salida]").click(function () {
            if ($('#text-basic').val() > parseInt($(this).attr('cantidad'))) {
                $('#dialogoCantidadIncorrecta').modal('toggle');
            }else if ($('#text-basic').val() == null || $('#text-basic').val() <= 0) {
                $('#dialogoCantidad').modal('toggle');

            }else if(ubiDest=='') {
                $('#dialogoSeleccionDestino').modal('toggle');

            }else if ($('#formGroupInputSmall').val() == "") {
                $('#dialogoProveedor').modal('toggle');
            }else {
                //comprobar si existelanzadera
                if (${empty lanzadera}) {
                    var url2=$(this).attr('url2')+ $('#text-basic').val();
                    var url=$(this).attr('url')+ $('#text-basic').val();
                    var lanzadera=$(this).attr('lanzadera');
                    var ip=$(this).attr('ip');
                    var articulo=$(this).attr('articulo');
                    $.ajax({
                        url: 'http://'+$(this).attr('ip')+':8080/ServidorArmarios/JSONServlet',
                        data: {orden: 'ACCEDER', entablado: 0, codigoAcesso: '000'  ,url: $(this).attr('url') + $('#text-basic').val()+"&origen="+ubiDest },
                        type: 'POST',
                        async: false,
                        dataType: "json",
                        json: "callback",
                        success: function (data) {

                            var result = data['RESULT '];
                            if (result == 'OK') {
                                //la lanzadera esta libre envio carga pagina remota
                                $.ajax({
                                    type: 'GET',
                                    contentType: 'application/json; charset=utf-8',
                                    url: '/OscaArmarios/OperacionEntablado/AbrirVentana',
                                    data: {ip: ip, url: url},
                                    dataType: 'json',
                                    async: true,
                                    success: function () {
                                        //nueva tarea Creada, mostrar mensaje
                                        $('#accesoLanzaderaExito').modal({
                                            show: 'true'
                                        });
                                    }
                                });


                            } else{
                                //la lanzadera esta ocupada, generar tarea
                                //añadir tarea
                                $.ajax({
                                    type: 'GET',
                                    contentType: 'application/json; charset=utf-8',
                                    url: '/OscaArmarios/Operacion/NuevaTarea',
                                    data: {lanzadera: lanzadera, url: url2, articulo: articulo, cantidad: parseInt($('#text-basic').val()), accion: 3},
                                    dataType: 'json',
                                    async: true,
                                    success: function () {
                                        //nueva tarea Creada, mostrar mensaje
                                        $('#dialogoTareaCreada').modal({
                                            show: 'true'
                                        });
                                    }
                                });
                            }
                            $("#guardarEntablado").addClass('hidden');
                        },
                    });
                }else
                    window.location.href = $(this).attr('url') + $('#text-basic').val()+"&dest="+ubiDest;
            }
        });

        $('#text-basic').change(function () {
            var pesoTotal =
            ${articulo.netWeight}*
            $('#text-basic').val();
            $('#cantidadTotal').text("PESO TOTAL: " + pesoTotal + " Kg.");
            $("#text-basic").css('border', 'black');
            $("a[id=salida]").each(function () {
                //entradas
                $(this).css("background-color", "#DD0000");
                $(this).css('color', 'white');
            });


        });


    });
</script>

<style type="text/css">
    .nmpd-grid {
        border: none;
        width: 50%;
        height: 35%;
        padding: 40px;
    }

    .nmpd-grid > tbody > tr > td {
        border: none;
    }

    /* Some custom styling for Bootstrap */
    .qtyInput {
        display: block;
        width: 100%;
        padding: 6px 12px;
        color: #555;
        background-color: white;
        border: 1px solid #ccc;
        border-radius: 4px;
        -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
        box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
        -webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow ease-in-out .15s;
        -o-transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
        transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
    }
</style>
</body>
</html>
