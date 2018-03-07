<%--
  Created by IntelliJ IDEA.
  User: Portátil1
  Date: 15/05/2017
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="DialogosNotificacion.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.net.*" %>
<%@ page import=" javax.servlet.jsp.PageContext" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%
    String hostname, serverAddress = "hola";
    hostname = "error";
    serverAddress = "error";
    try {
        InetAddress iAddress = InetAddress.getLocalHost();
        String currentIp = iAddress.getHostAddress();
        pageContext.setAttribute("localAdress", request.getRemoteAddr());
    } catch (UnknownHostException e) {
        e.printStackTrace();
    }
%>
<html>

<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="css/bootstrapstyle.min.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.numpad.js"></script>


    <link rel="stylesheet" href="css/jquery.numpad.css">
    <script src="js/operacionesLanzadera.js"></script>
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
            background-color: #009900;
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
            border: 2px solid #009900;
            color: #626262;
        }

        .btn-primary.outline:active {
            background: #009900;
        }

        .btn-primary.outline:hover,
        .btn-primary.outline:focus,
        .btn-primary.outline:active,
        .btn-primary.outline.active,
        .open > .dropdown-toggle.btn-primary {
            color: #626262;
            border-color: #009900;
        }

        .btn-primary.outline:active,
        .btn-primary.outline.active {
            border-color: #009900;
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

        tbody.scrollable {
            height: 5px; /* Just for the demo          */
            overflow-y: auto; /* Trigger vertical scroll    */
            width: 45px; /* Just for the demo          */
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
            height: 150px;
            overflow-y: auto;
            overflow-x: hidden;
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
                <li class="active" style="border-right: 2px solid white">
                    <a href="/OscaArmarios/EntradaMaterialHome.html?lanzadera=${lanzadera.id_lanzadera}">
                        <p class="cabecera text-center">&nbsp;&nbsp;&nbsp;<span
                                class="glyphicon glyphicon glyphicon-save"></span>&nbsp;&nbsp;Entrada&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </p>
                    </a>
                </li>
                <li style="border-right: 2px solid white">
                    <a href="/OscaArmarios/ConsultaMaterialHome.html">
                        <p class="cabecera text-center">&nbsp;&nbsp;&nbsp;<span
                                class="glyphicon glyphicon glyphicon-search"></span>&nbsp;&nbsp;Consulta&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </p>
                    </a>
                </li>
                <li style="border-right: 2px solid white">
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
                    <th>
                        <font color="#fdfcfc">CÓDIGO</font>
                    </th>
                    <th>
                        <font color="#fdfcfc">DESCRIPCIÓN</font>
                    </th>
                    <th>
                        <font color="#fdfcfc">PESO</font>
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="m-0">${articulo.articulo}</td>
                    <td>${articulo.descripcion}</td>
                    <td>${articulo.peso} KG</td>
                </tr>
                </tbody>
            </table>
            <h4 class="text-left">SELECIONAR MÉTODO DE ENTRADA</h4>
            <div class="row">
                 <span style="float: right;margin-right: 2%;margin-top:-25px">
									  <!--itroducir cantidad-->
                    <form class="text-right">
                         <h3>INTRODUCIR CANTIDAD&nbsp;&nbsp;
                             <input id="text-basic" type="number"
                                    style="font-size:25px;width:150px;text-align: right;border: 4px solid #009900;"
                                    name="fname"> </h3>
                         <h4 id='cantidadTotal'>PESO TOTAL: 0.0 Kg.</h4>
                    </form>
                </span>
            </div>
        </div>
    </div>
    <div class="col-md-12 panel panel-default" style="margin-top:-50px">
        <h4 class="text-left">ACTUALMENTE EN LANZADERA ${lanzadera.id_lanzadera}</h4>
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
                    <font color="#fdfcfc">DESCRIPCIÓN ENTABLADO</font>
                </th>
                <th class="text-center">
                    <font color="#fdfcfc">CAJA</font>
                </th>

                <th class="text-center">
                    <font color="#fdfcfc">CANTIDAD</font>
                </th>
                <th class="text-center">
                    <font color="#fdfcfc">PESO</font>
                </th>
                <th class="text-center">
                    <font color="#fdfcfc">PESO ENTABLADO</font>
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
                            <td class="text-center">${ubicacion.lanzadera.descripcion}</td>
                            <td class="text-center">${ubicacion.entablado.id_entablado}</td>
                            <td class="text-center">${ubicacion.entablado.descripcion}</td>
                            <td class="text-center">${ubicacion.tipoCaja.tipo_caja}</td>
                            <td class="text-center">${ubicacion.cantidad}</td>
                            <td class="text-center">${ubicacion.peso}</td>
                            <td class="text-center">${ubicacion.entablado.pesoActual}</td>
                            <td class="text-center">
                                <a id='salida' class="btn btn-primary btn-lg outline px-3 mx-3"
                                   url="/OscaArmarios/EntradaSeleccionUbicacionFinal.html?articulo=${articulo.articulo}&amp;lanzadera=${ubicacion.lanzadera.id_lanzadera}&amp;entablado=${ubicacion.entablado.id_entablado}&amp;fila=${ubicacion.fila}&amp;columna=${ubicacion.columna}&amp;cantidad=${cantidad}"
                                   url2="/OscaArmarios/TareaEntradaSeleccionUbicacionFinal.html?articulo=${articulo.articulo}&amp;lanzadera=${reserva.lanzadera.id_lanzadera}&amp;entablado=${reserva.entablado.id_entablado}&amp;fila=${reserva.fila}&amp;columna=${reserva.columna}&amp;cantidad=${cantidad}"
                                   ip=${ubicacion.lanzadera.direccion_ip} articulo="${articulo.articulo}" lanzadera="${ubicacion.lanzadera.id_lanzadera}" data-toggle="modal">ENTRADA</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${!empty reservas}">
                    <c:forEach items="${reservas}" var="reserva">
                        <c:choose>
                            <c:when test="${empty lanzaderaActual || reserva.lanzadera.id_lanzadera==lanzaderaActual.id_lanzadera}">
                                <tr>
                                    <td class="text-center">${reserva.lanzadera.descripcion}</td>
                                    <td class="text-center">${reserva.entablado.id_entablado}</td>
                                    <td class="text-center">${reserva.entablado.descripcion}</td>
                                    <td class="text-center">MEDIDA ${reserva.ncolumnas}x${reserva.nfilas}</td>
                                    <td class="text-center"></td>
                                    <td class="text-center">${reserva.cantidad}</td>
                                    <td class="text-center">${reserva.peso}</td>
                                    <td class="text-center">
                                        <a id='salida' class="btn btn-primary btn-lg outline px-3 mx-3"
                                           url="/OscaArmarios/EntradaSeleccionUbicacionFinalMedida.html?articulo=${articulo.articulo}&amp;lanzadera=${reserva.lanzadera.id_lanzadera}&amp;entablado=${reserva.entablado.id_entablado}&amp;fila=${reserva.fila}&amp;columna=${reserva.columna}&amp;cantidad=${cantidad}"
                                           url2="/OscaArmarios/TareaEntradaSeleccionUbicacionFinalMedida.html?articulo=${articulo.articulo}&amp;lanzadera=${reserva.lanzadera.id_lanzadera}&amp;entablado=${reserva.entablado.id_entablado}&amp;fila=${reserva.fila}&amp;columna=${reserva.columna}&amp;cantidad=${cantidad}"
                                           ip=${reserva.lanzadera.direccion_ip} articulo="${articulo.articulo}" lanzadera="${ubicacion.lanzadera.id_lanzadera}" data-toggle="modal">ENTRADA</a>
                                    </td>
                                </tr>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>
    <div class="col-md-5">
        <div class="form-group form-group-sm">
            <label class="col-sm-7 control-label" for="formGroupInputSmall"
                   style="max-width: 250px; word-wrap: break-word">
                <h4 class="text-left" style="padding: 0;">UBICACIÓN ORIGEN</h4>
            </label>
            <div class="col-sm-5 text-left text-left">
                <div class="btn-group dropup" style="border: 1px solid #000000">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">ENTRADA
                        <span class="caret"></span>
                    </button>

                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">UBICACION 1</a></li>
                        <li><a href="#">UBICACION 2</a></li>
                        <li><a href="#">UBICACION 3</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Acción #4</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-4 center-block">
        <br><span class="border-2"><button id="sugerirUbicacion" type="button"
                                           class="btn btn-primary btn-lg outline px-3 text-center mx-3">SUGERIR UBICACIÓN</button></span>
    </div>
    <div class="col-md-3 center-block">
        <br><span class="border-2"><button id="nuevaUbicacion" type="button"
                                           class="btn btn-primary btn-lg outline py-3 text-center mx-3">NUEVA UBICACIÓN</button></span>
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
    function sugerirTarea(event, lanzadera,articulo,cantidad,ipdir) {
        //comprobar si lanzadera esta libre
        $('#dialogoMostrarLanzaderas').modal('toggle');
        if (${empty lanzadera}) {
            var acceso=//comprobar acceso lanzadera
                $.ajax({
                    url: 'http://' + ipdir + ':8080/ServidorArmarios/JSONServlet',
                    data: {orden: 'ACCEDER', entablado: 0, codigoAcesso: '000', url: ""},
                    type: 'POST',
                    async: false,
                    dataType: "json",
                    json: "callback",
                    success: function (data) {
                        var result = JSON.stringify(data);
                        if (result === "{\"RESULT \":\"true\"}") return true;
                        else return false;
                    },
                    error: function () {
                        console.log("fataliti");
                        return false;
                    }
                });
            if (acceso) {
                var url = "/OscaArmarios/EntradaSeleccionTipoCajaSugerirUbi.html?lanzadera=" + lanzadera + "&articulo=" + articulo + "&cantidad=" + cantidad;
                //enviar señal remota
                if (abrirVentanaRemota(ipdir, url)) {
                    $('#accesoLanzaderaExito').modal({
                        show: 'true'
                    });
                }
            }
            //lanzadera no libre o apagada,generar tarea.
            else {
                var url = "/OscaArmarios/TareaEntradaSeleccionTipoCajaSugerirUbi.html?lanzadera=" + lanzadera + "&articulo=" + articulo + "&cantidad=" + cantidad;
                //nueva tarea sugerir ubicacion
                if (generarTareaNueva(lanzadera, url, articulo, cantidad, 4)) {
                    $('#dialogoTareaCreada').modal({
                        show: 'true'
                    });
                }
            }
        }
        //accedo directamente
        else
            window.location.href = $(this).attr('url') + $('#text-basic').val();
    }
    $(document).ready(function () {
        $('#text-basic').numpad();
        var pesoTotal = ${articulo.peso}* $('#text-basic').val();
        $('#cantidadTotal').text("PESO TOTAL: " + pesoTotal + " Kg.");
        if ($('#text-basic').val() > 0) {
            $("#nuevaUbicacion").css("background-color", "#009900");
            $("#nuevaUbicacion").css('color', 'white');
            $("#sugerirUbicacion").css("background-color", "#009900");
            $("#sugerirUbicacion").css('color', 'white');
            //entradas
            $("a[id=salida]").css("background-color", "#009900");
            $("a[id=salida]").css('color', 'white');
        }

        $("#nuevaUbicacion").click(function () {
            if ($('#text-basic').val() == null || $('#text-basic').val() <= 0) {
                $('#dialogoCantidad').modal('toggle');

            } else if (${empty lanzadera}) {
                $.ajax({
                    type: 'GET',
                    contentType: 'application/json; charset=utf-8',
                    url: '/OscaArmarios/Operacion/ListarLanzaderas',
                    data: {ip: '${localAdress}'},
                    dataType: 'json',
                    async: true,
                    success: function (data, status) {
                        $('#dialogoMostrarLanzaderas').modal('toggle');
                        createTableByForLoop2(data);
                    }
                });
            }
            else {
                window.location.href = "EntradaSeleccionTipoCajaNuevaUbi.html?lanzadera=" + parseInt(${lanzadera.id_lanzadera}) + "&cantidad=" + parseInt($('#text-basic').val()) + "&articulo=${articulo.articulo}";

            }
        });

        $('#text-basic').change(function () {
            var pesoTotal =
            ${articulo.peso}*
            $('#text-basic').val();
            $('#cantidadTotal').text("PESO TOTAL: " + pesoTotal + " Kg.");
            $("#text-basic").css('border', '');
            $("#nuevaUbicacion").css("background-color", "#009900");
            $("#nuevaUbicacion").css('color', 'white');
            $("#sugerirUbicacion").css("background-color", "#009900");
            $("#sugerirUbicacion").css('color', 'white');
            //entradas
            $("a[id=salida]").css("background-color", "#009900");
            $("a[id=salida]").css('color', 'white');

        });
        $("#sugerirUbicacion").click(function () {
            if ($('#text-basic').val() <= 0) {
                $('#dialogoCantidad').modal('toggle');

            } else if ($('#formGroupInputSmall').val() == "") {
                $('#dialogoProveedor').modal('toggle');
            } else if (${empty lanzadera}) {
                $.ajax({
                    type: 'GET',
                    contentType: 'application/json; charset=utf-8',
                    url: '/OscaArmarios/Operacion/ListarLanzaderas',
                    dataType: 'json',
                    async: true,
                    success: function (data, status) {
                        $('#dialogoMostrarLanzaderas').modal('toggle');
                        createTableByForLoop(data);
                        //añadir a tareas

                    }
                });
            }
            //continuar
            else {
                window.location.href = "EntradaSeleccionTipoCajaSugerirUbi.html?lanzadera=" + parseInt(${lanzadera.id_lanzadera}) + "&articulo=" + ${articulo.articulo} +"&cantidad=" + parseInt($('#text-basic').val());
            }
        });
        $("a[id=salida]").click(function () {
            if ($('#text-basic').val() == null || $('#text-basic').val() <= 0) {
                $('#dialogoCantidad').modal('toggle');

            } else if ($('#formGroupInputSmall').val() == "") {
                $('#dialogoProveedor').modal('toggle');
            }
            //continuar
            else {
                //comprobar si existelanzadera
                if (${empty lanzadera}) {
                    var url2=$(this).attr('url2')+ $('#text-basic').val();
                    var url=$(this).attr('url')+ $('#text-basic').val();
                    var lanzadera=$(this).attr('lanzadera');
                    var ip=$(this).attr('ip');
                    var articulo=$(this).attr('articulo');
                    $.ajax({
                        url: 'http://'+$(this).attr('ip')+':8080/ServidorArmarios/JSONServlet',
                        data: {orden: 'ACCEDER', entablado: 0, codigoAcesso: '000'  ,url: $(this).attr('url') + $('#text-basic').val() },
                        type: 'POST',
                        async: false,
                        dataType: "json",
                        json: "callback",
                        success: function (data) {
                            var result = JSON.stringify(data);
                            if (result === "{\"RESULT \":\"true\"}") {
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
                            } else {
                                $.ajax({
                                    type: 'GET',
                                    contentType: 'application/json; charset=utf-8',
                                    url: '/OscaArmarios/Operacion/TareaNuevaUbicacion',
                                    data: {
                                        lanzadera: $(this).attr('lanzadera'),
                                        url: $(this).attr('url2') + $('#text-basic').val(),
                                        articulo: $(this).attr('articulo'),
                                        cantidad: parseInt($('#text-basic').val()),
                                        accion: 2
                                    },
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
                    window.location.href = $(this).attr('url') + $('#text-basic').val();

            }
        });
    });
    //nueva ubicacion
    function createTableByForLoop(data) {
        var eTable = "";
        for (var i = 0; i < data.length; i++) {
          //  eTable += "<tr  style=\"cursor: pointer\" onclick=\"location.href='/OscaArmarios/EntradaSeleccionTipoCajaSugerirUbi.html" +
          //      "?lanzadera=" + data[i]['Lanzadera']['Id_lanzadera'] + "&articulo=${articulo.articulo}&cantidad=" + parseInt($('#text-basic').val()) + "'\">";
            eTable += "<tr style=\"cursor: pointer\" onclick=\"sugerirTarea("+data[i]['Lanzadera']['Id_lanzadera']+",${articulo.articulo},"+parseInt($('#text-basic').val())+",'"+data[i]['Lanzadera']['direccion_ip']+"' )\" >";
            eTable += "<td>" + data[i]['Lanzadera']['descripcion'] + "</td>";
            eTable += "<td>" + data[i]['Lanzadera']['Alias_lanzadera'] + "</td>";
            eTable += "</tr>";
        }
        $('#forTable').html(eTable);
    }

    //sugerir ubicacion
    function createTableByForLoop2(data) {
        var eTable = "";
        for (var i = 0; i < data.length; i++) {
            //enviar tarea
           // eTable += "<tr  style=\"cursor: pointer\" onclick=\"location.href='/OscaArmarios/EntradaSeleccionTipoCajaNuevaUbi.html" +
           //  "?lanzadera=" + data[i]['Lanzadera']['Id_lanzadera'] + "&articulo=${articulo.articulo}&cantidad=" + parseInt($('#text-basic').val()) + "'\">";
            eTable += "<tr style=\"cursor: pointer\" onclick=\"nuevaTarea("+data[i]['Lanzadera']['Id_lanzadera']+",${articulo.articulo},"+parseInt($('#text-basic').val())+",'"+data[i]['Lanzadera']['direccion_ip']+"' )\" >";
            eTable += "<td>" + data[i]['Lanzadera']['descripcion'] + "</td>";
            eTable += "<td>" + data[i]['Lanzadera']['Alias_lanzadera'] + "</td>";
            eTable += "</tr>";
            alert("<tr style=\"cursor: pointer\" onclick='nuevaTarea("+data[i]['Lanzadera']['Id_lanzadera']+",${articulo.articulo},"+parseInt($('#text-basic').val())+",'"+data[i]['Lanzadera']['direccion_ip']+"' )' >");
        }
        $('#forTable').html(eTable);
    }
    function nuevaTarea(lanzadera,articulo,cantidad,ipdir) {
        //comprobar si lanzadera esta libre
        $('#dialogoMostrarLanzaderas').modal('toggle');
        if (${empty lanzadera}) {
            $.ajax({
                url: 'http://' + ipdir + ':8080/ServidorArmarios/JSONServlet',
                data: {orden: 'ACCEDER', entablado: 0, codigoAcesso: '000', url: ""},
                type: 'POST',
                async: false,
                dataType: "json",
                json: "callback",
                success: function (data) {
                    var result = JSON.stringify(data);
                    if (result === "{\"RESULT \":\"true\"}") {
                        var url = "/OscaArmarios/EntradaSeleccionTipoCajaNuevaUbi.html?lanzadera=" + lanzadera + "&articulo=" + articulo + "&cantidad=" + cantidad;
                        //la lanzadera esta libre envio carga pagina remota
                        $.ajax({
                            type: 'GET',
                            contentType: 'application/json; charset=utf-8',
                            url: '/OscaArmarios/OperacionEntablado/AbrirVentana',
                            data: {ip: ipdir, url: url},
                            dataType: 'json',
                            async: true,
                            success: function () {
                                //nueva tarea Creada, mostrar mensaje
                                $('#accesoLanzaderaExito').modal({
                                    show: 'true'
                                });
                            }
                        });
                    } else {
                        var url = "/OscaArmarios/TareaEntradaSeleccionTipoCajaNuevaUbi.html?lanzadera=" + lanzadera + "&articulo=" + articulo + "&cantidad=" + cantidad;
                        //la lanzadera esta ocupada, generar tarea
                        //añadir tarea
                        $.ajax({
                            type: 'GET',
                            contentType: 'application/json; charset=utf-8',
                            url: '/OscaArmarios/Operacion/TareaNuevaUbicacion',
                            data: {lanzadera: lanzadera, url: url, articulo: articulo, cantidad: cantidad, accion: 1},
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
            window.location.href = $(this).attr('url') + $('#text-basic').val();
    }


    /***
     *
     *
     *
     *
     * FUNIONES LIBRERIA
     *
     *
     *
     *
     */
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
                if (result === "{\"RESULT \":\"true\"}") return true;
                else return false;
            },
            error: function () {
                console.log("fataliti");
                return false;
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
            url: '/OscaArmarios/Operacion/TareaNuevaUbicacion',
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

