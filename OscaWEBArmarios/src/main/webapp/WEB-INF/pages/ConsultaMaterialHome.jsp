<%--
  Created by IntelliJ IDEA.
  User: Portátil1
  Date: 08/05/2017
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.net.*" %>
<%@ page import=" javax.servlet.jsp.PageContext" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%
    String hostname, serverAddress= "hola";
    hostname = "error";
    serverAddress = "error";
    try {
        InetAddress iAddress = InetAddress.getLocalHost();
        String currentIp = iAddress.getHostAddress();
        pageContext.setAttribute("localAdress",  request.getRemoteAddr());
    } catch (UnknownHostException e) {
        e.printStackTrace();
    }
%>
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
            background-color: ;
        }

        .navbar .nav .active>a {
            color: #000;
            background-color: #324891;
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
</head>

<body style="background:#fdfcfc">
<!-- Static navbar -->
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
            <a class="navbar-brand" href="#">
                <p id='titulo' class="cabecera">CONSULTA</p>
            </a>
        </div>
        <div class="navbar-collapse collapse" id="navbar">
            <ul class="nav navbar-nav navbar-right" style="border-left: 2px solid white">
                <li  style="border-right: 2px solid white">
                    <a href="/OscaArmarios/EntradaMaterialHome.html">
                        <p class="cabecera text-center">&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon glyphicon-save"></span>&nbsp;&nbsp;Entrada&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                    </a>
                </li>
                <li class="active" style="border-right: 2px solid white" >
                    <a href="/OscaArmarios/ConsultaMaterialHome.html">
                        <p class="cabecera text-center">&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon glyphicon-search"></span>&nbsp;&nbsp;Consulta&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                    </a>
                </li>
                <li style="border-right: 2px solid white">
                    <a href="/OscaArmarios/SalidaMaterialHome.html">
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
<div class="text-center w-100 h-100 my-2 text-white py-5 text-uppercase">
    <div class="container" style="height:75%;text-align: center;margin-top:7%">
        <div class="row">
            <div class="col-md-4">
                <a href="/OscaArmarios/ConsultaBusquedaArticulo.html" class="btn btn-primary btn-lg btn-block my-4" data-toggle="" style="background:#324891">Artículo</a>
            </div>
            <div class="col-md-4">
                <a  id='consultaEntablado' href="/OscaArmarios/ConsultaSeleccionEntablado.html" class="btn btn-primary btn-lg btn-block my-4" data-toggle="" style="background:#324891">Entablado</a>
            </div>
            <div class="col-md-4">
                <a id='consultaLanzadera' href="/OscaArmarios/ConsultaMaterialArmario.html" class="btn btn-primary btn-lg btn-block my-4" data-toggle="" style="background:#324891">Lanzaderas</a>
            </div>
        </div>
        <div class="row" style="margin-top:7%">
            <div class="col-md-4">
                <a href="/OscaArmarios/ConsultaOrdenProduccion.html" class="btn btn-primary btn-lg btn-block my-4 text-center" data-toggle="" style="background:#324891">Orden de producción</a>
            </div>
            <div class="col-md-4">
                <a href="/OscaArmarios/ConsultaEliminarCajasVacias.html" class="btn btn-primary btn-lg btn-block my-4" data-toggle="" style="background:#324891">Cajas vacias</a>
            </div>
            <div class="col-md-4">
                <a href="/OscaArmarios/ConsultaEliminarUbicacion.html" class="btn btn-primary btn-lg btn-block my-4" data-toggle="" style="background:#324891">Eliminar ubicación</a>
            </div>
        </div>
    </div>
</div>
<!--row-->
<!--Diagolo cantidad -->
<!--Diagolo cantidad -->
</body>
<script>
    $(document).ready(function() {
        //Consultar si es una lanzadera
        $.ajax({
            type: 'GET',
            contentType : 'application/json; charset=utf-8',
            url: '/OscaArmarios/Operacion/EsLanzadera',
            data: { ip: '${localAdress}'},
            //
            dataType: 'json',
            async : true,
            success: function(data){
                if(jQuery.isEmptyObject(data)){
                    $("#EntradaMaterial").attr("href","/OscaArmarios/EntradaMaterialHome.html");
                    $("#SalidaMaterial").attr("href","/OscaArmarios/SalidaMaterialHome.html");
                    $("#EntradaMaterialHome").attr("href","/OscaArmarios/EntradaMaterialHome.html");
                    $("#SalidaMaterialHome").attr("href","/OscaArmarios/EntradaMaterialHome.html");
                }else{
                    $("#EntradaMaterial").attr("href","/OscaArmarios/EntradaMaterialHome.html?lanzadera="+data.id_lanzadera);
                    $("#SalidaMaterial").attr("href","/OscaArmarios/SalidaMaterialHome.html?lanzadera="+data.Id_lanzadera);
                    $("#EntradaMaterialHome").attr("href","/OscaArmarios/EntradaMaterialHome.html?lanzadera="+data.id_lanzadera);
                    $("#SalidaMaterialHome").attr("href","/OscaArmarios/EntradaMaterialHome.html?lanzadera="+data.id_lanzadera);
                    $('#titulo').text(data.descripcion);
                    $("#consultaEntablado").attr("href","/OscaArmarios/ConsultaSeleccionEntablado.html?lanzadera="+data.id_lanzadera);
                    $("#consultaLanzadera").attr("href","/OscaArmarios/ConsultaMaterialArmarioDetalle.html?lanzadera="+data.id_lanzadera);
                }
            },
            error: function()
            {
            }
        });
    });
</script>

</html>
