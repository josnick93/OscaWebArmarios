<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import=" javax.servlet.jsp.PageContext" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Salida Seleccion Ubicacion</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrapstyle.min.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
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
            background-color: ;
        }

        .navbar .nav .active>a {
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
        .open>.dropdown-toggle.btn-primary {
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
        .table-bordered>thead>tr>th,
        .table-bordered>tbody>tr>th,
        .table-bordered>tfoot>tr>th,
        .table-bordered>thead>tr>td,
        .table-bordered>tbody>tr>td,
        .table-bordered>tfoot>tr>td {
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
        .nmpd-grid>tbody>tr>td {
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
            height: 300px;
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
            <button id="apagar" class="btn btn-default hidden" style="margin:5px;margin-left:5px;height:60px">
                <p class="text-center "> <span  class="icon-flipped glyphicon glyphicon-off" style="vertical-align:middle;font-size: 28px;"></span> </p>
            </button>
        </div>
        <div class="navbar-collapse collapse" id="navbar">
            <ul class="nav navbar-nav navbar-right" style="border-left: 2px solid white">
                <li style="border-right: 2px solid white">
                    <a href="/OscaArmarios/EntradaMaterialHome.html?lanzadera=${lanzadera.id_lanzadera}">
                        <p class="cabecera text-center">&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon glyphicon-save"></span>&nbsp;&nbsp;Entrada&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                    </a>
                </li>
                <li style="border-right: 2px solid white" >
                    <a href="/OscaArmarios/ConsultaMaterialHome.html">
                        <p class="cabecera text-center">&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon glyphicon-search"></span>&nbsp;&nbsp;Consulta&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                    </a>
                </li>
                <li style="border-right: 2px solid white">
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
    <div class="text-center w-100 h-100 my-3 text-white py-5 text-uppercase">
        <div class="container" style="height:75%;text-align: center;margin-top:7%">
            <div class="row" >
                <div class="col-md-4" style='height:50%'>
                    <a id='EntradaMaterial' href="/OscaArmarios/EntradaMaterialHome.html" class="btn btn-primary btn-lg text-center my-5" style="margin-right: auto; margin-left: auto; width: 300px;background:#009900">Entrada Material</a>
                </div>
                <div class="col-md-4" style='height:50%'>
                    <a id='ConsultaMaterial' class="btn btn-primary btn-lg text-center my-5" href="/OscaArmarios/ConsultaMaterialHome.html" style="margin-right: auto; margin-left: auto; width: 300px;background:#324891">Consulta Material</a>
                </div>
                <div class="col-md-4" style='height:50%'>
                    <a id='SalidaMaterial' href="/OscaArmarios/SalidaMaterialHome.html" class="btn btn-primary btn-lg text-center my-5" style="margin-right: auto; margin-left: auto; width: 300px;background:#DD0000">Salida Material</a>
                </div>
            </div>

            <div class="row" >
                <div class="col-md-4" style='height:50%'>
                    <a id='guardarEntablado' class="hidden btn btn-primary btn-lg text-center my-5" style="margin-right: auto; margin-left: auto; width: 300px;background:#324891">Guardar entablado</a>
                </div>
                <div class="col-md-4" style='height:50%'>
                    <a id='admin' class="hidden btn btn-primary btn-lg text-center my-5" href="/OscaArmarios/AdministradorHome.html" style="margin-right: auto; margin-left: auto; width: 300px;background:#FFD700">Administrador</a>
                </div>
            </div>
        </div>
        <c:if test="${!empty TareasPendientes}">
        <div class="col-md-12">
            <table id="table"
                   data-toggle="table"
                   data-search="false"
                   data-filter-control="true"
                   data-show-export="false"
                   data-click-to-select="true"
                   data-toolbar="#toolbar" class="table table-striped table-bordered nowrap" cellspacing="0" width="100%">
                <thead bgcolor="#fdfcfc" style="background:#626262">
                <tr>
                    <th id='usuario' data-filter-control="select" data-sortable="true" class="text-center">
                        <font color="#fdfcfc">ACCION</font>
                    </th>
                    <th id='usuario' data-filter-control="select" data-sortable="true" class="text-center">
                        <font color="#fdfcfc">LANZADERA</font>
                    </th>
                    <th data-field="articulo" data-filter-control="select" data-sortable="true" class="text-center">
                        <font color="#fdfcfc">ARTÍCULO</font>
                    </th>
                    <th data-field="descripcion" data-filter-control="select" data-sortable="true" class="text-center">
                        <font color="#fdfcfc">DESCRIPCIÓN</font>
                    </th>
                    <th data-field="cantidad" data-filter-control="input" data-sortable="true" class="text-center">
                        <font color="#fdfcfc">CANTIDAD</font>
                    </th>
                    <th data-field="examen" data-filter-control="input" data-sortable="true" class="text-center">
                        <font color="#fdfcfc">FECHA</font>
                    </th>
                </tr>
                </thead>
            </table>
            <div class="div-table-content">
                <table class="table table-condensed table-bordered">
                    <tbody>
                    <c:forEach items="${TareasPendientes}" var="tarea">
                        <tr class='clickable-row' style="cursor: pointer;"  href='${tarea.URL}&idTarea=${tarea.idTareaPendiente}'>
                            <td class="text-center">${tarea.accion.descripcion}</td>
                            <td class="text-center">${tarea.lanzadera.id_lanzadera}</td>
                            <td class="text-center">${tarea.articulo.articulo}</td>
                            <td class="text-center">${tarea.articulo.descripcion}</td>
                            <td class="text-center">${tarea.cantidad}</td>
                            <td class="text-center">${tarea.fecha_creacion}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        </c:if>
    </div>
</body>

<!--dialogo confirmar apagado -->
<div class="modal fade" id="confirmarApagado" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title">CONFIRMAR APAGADO EQUIPO</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <fieldset>
                        <!-- Text input-->
                        <h3 id="confBorradoText">¿Deseas apagar el equipo? </h3>
                    </fieldset>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success" id="apagarEquipoSumbit" style="background:#324891">ACEPTAR</button>
                <a href="#" class="btn" data-dismiss="modal" style="background:#324891;color:white">CERRAR</a>
            </div>
        </div>
    </div>
</div>

<div id="esperarEntablado" class="modal fade"  role="dialog" data-backdrop="static" data-keyboard="false"role="dialog" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title">Bajando entablado , por favor espere...</h4>
            </div>
            <div class="modal-body"> <strong>Instrucciones:</strong>
                <p/>
                <p>1- Pulse el boton ENTER de la lanzadera en caso de que aparezca el mensaje</p>
                <p>2- Espera a que el entablado baje</p>
                <p>3- Una vez el entablado este abajo se cerrará esta ventana</p>
                <p>4- En caso de error aparecera un mensaje</p>
            </div>
        </div>
    </div>
</div>
<script>
    var subirEntabladoAntesApagar=false;
    $(document).ready(function() {
        //comprobar si es lanzadera
        if(${EsLanzadera}){
            $("#EntradaMaterial").attr("href","/OscaArmarios/EntradaMaterialHome.html?lanzadera=${Lanzadera.id_lanzadera}");
            $("#SalidaMaterial").attr("href","/OscaArmarios/SalidaMaterialHome.html?lanzadera=${Lanzadera.id_lanzadera}");
            $("#EntradaMaterialHome").attr("href","/OscaArmarios/EntradaMaterialHome.html?lanzadera=${Lanzadera.id_lanzadera}");
            $("#SalidaMaterialHome").attr("href","/OscaArmarios/EntradaMaterialHome.html?lanzadera=${Lanzadera.id_lanzadera}");
            $("#apagar").removeClass('hidden');
            estaEntabladoAbajo('${Lanzadera.direccion_ip}','${Lanzadera.punto_acesso}');
            //liberar lanzadera
            $.ajax({
                url: 'http://${Lanzadera.direccion_ip}:8080/ServidorArmarios/JSONServlet',
                type: 'POST',
                async: false,
                dataType: "json",
                json: "callback",
                data: { orden:'LIBERAR', lanzadera:parseInt(${entablado.lanzadera.id_lanzadera}) ,
                    entablado:parseInt(0,10) , codigoAcesso:'${entablado.lanzadera.punto_acesso}'},
                beforeSend: function () {
                }
            });
        }
        //comprobar si es administrador
        if(${EsAdministrador}){
            $("#admin").removeClass('hidden');
        }
        $("#apagar").click(function() {
            $('#confirmarApagado').modal({
                show: 'true'
            });
        });
        $('#apagarEquipoSumbit').click(function () {
           // if (subirEntabladoAntesApagar) {
           //     $('#apagarEquipoSumbit').modal('toggle');
           //     $('#esperarEntablado').modal({
           //         show: 'true'
           //     });
            /**
                    $.ajax({
                        url: 'http://${Lanzadera.direccion_ip}:8080/ServidorArmarios/JSONServlet',
                        type: 'POST',
                        async: false,
                        dataType: "json",
                        json: "callback",
                        data: {orden: 'MOVER', entablado: 0, codigoAcesso: punto_acesso},
                        success: function (data) {
                            $.ajax({
                                url: 'http://${Lanzadera.direccion_ip}:8080/ServidorArmarios/JSONServlet',
                                data: {orden: 'APAGAR'},
                                type: 'POST',
                                async: true,
                                dataType: "jsonp",
                                json: "callback",
                                beforeSend: function() {
                                    $('#confirmarApagado').modal('toggle');
                                }
                            });
                        },
                    });
                } else {
               */

                $.ajax({
                    url: 'http://${Lanzadera.direccion_ip}:8080/ServidorArmarios/JSONServlet',
                    data:  { orden:'APAGAR', lanzadera:parseInt(1) ,
                        entablado:'0' , codigoAcesso:'000'},
                    type: 'POST',
                    async: true,
                    dataType: "json",
                    json: "callback",

                });
            //}
        });

        $(".clickable-row").click(function() {
               window.location = "http://192.168.2.8"+$(this).data("href");
        });
    function estaEntabladoAbajo(ipLanzadera,codigoAcesso){
        $.ajax({
            url: 'http://'+ipLanzadera+':8080/ServidorArmarios/JSONServlet',
            type: 'POST',
            async: true,
            dataType : "json",
            json : "callback",
            data: {orden: 'CONSULTAR', codigoAcesso: codigoAcesso},
            error: function (data) {
                var result = JSON.stringify(data);
            },
            success: function (data) {
                var result = JSON.stringify(data);
                if(result==="{\"RESULT \":\"-1\"}" || result==="{\"RESULT \":\"0\"}"){
                }
                //mostrar boton guardar entablado
                else{
                    subirEntabladoAntesApagar=true;
                    $("#guardarEntablado").removeClass('hidden');
                }
            }
        });
    }
    $('#guardarEntablado').click(function () {
        subirEntablado();
    });
    function subirEntablado() {
        //subir entablado
        $.ajax({
            url: 'http://${Lanzadera.direccion_ip}:8080/ServidorArmarios/JSONServlet',
            type: 'POST',
            async: false,
            dataType: "json",
            json: "callback",
            data: {orden: 'MOVER', entablado: 0, codigoAcesso: '${Lanzadera.punto_acesso}'},
            beforeSend:function () {

            },
            success: function (data) {
                $.ajax({
                        url: 'http://${lanzadera.direccion_ip}:8080/ServidorArmarios/JSONServlet',
                        type: 'POST',
                        async: false,
                        dataType: "json",
                        json: "callback",
                        data: { orden:'LIBERAR', lanzadera:parseInt(${entablado.lanzadera.id_lanzadera}) ,
                            entablado:parseInt(0,10) , codigoAcesso:'${entablado.lanzadera.punto_acesso}'},
                        beforeSend: function () {
                        }
                });
                $("#guardarEntablado").addClass('hidden');
            },
            error: function (data) {
                $("#guardarEntablado").addClass('hidden');
            }
        });
    }
    });
</script>
</html>