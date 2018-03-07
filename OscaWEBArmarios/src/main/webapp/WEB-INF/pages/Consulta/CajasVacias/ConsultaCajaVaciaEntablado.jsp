<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: José Ángel Caudevílla Casaús
  Date: 19/05/2017
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="css/bootstrapstyle.min.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style>
        /* Remove the navbar's default margin-bottom and rounded borders */
        .modal {
            text-align: center;
            padding: 0!important;
        }

        .modal:before {
            content: '';
            display: inline-block;
            height: 100%;
            vertical-align: middle;
            margin-right: -4px;
        }

        .modal-dialog {
            display: inline-block;
            text-align: left;
            vertical-align: middle;
        }
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
            border: 2px solid #324891;
            color: #626262;
        }

        .btn-primary.outline:active {
            background: #324891;
        }

        .btn-primary.outline:hover,
        .btn-primary.outline:focus,
        .btn-primary.outline:active,
        .btn-primary.outline.active,
        .open>.dropdown-toggle.btn-primary {
            color: #626262;
            border-color: #324891;
        }

        .btn-primary.outline:active,
        .btn-primary.outline.active {
            border-color: #324891;
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

        img {
            border: 0;
        }

        .product-holder {
            position: relative;
            display: block;
        }

        .plus-image {
            left: 0%;
            top:81.5%;
            position: absolute;
            margin-top:0.5%;
            margin-left: 1%;
            border:3px solid black;
            display: inline-block;
        }
        .plus-image p{
            font-family: 'Dancing Script', cursive;
            color: #ffffff;
            font-size: 2em;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }
        .modal-header-danger {
            color:#fdfcfc;
            padding:9px 15px;
            border-bottom:1px solid #eee;
            background-color: #626262;
            -webkit-border-top-left-radius: 5px;
            -webkit-border-top-right-radius: 5px;
            -moz-border-radius-topleft: 5px;
            -moz-border-radius-topright: 5px;
            border-top-left-radius: 5px;
            border-top-right-radius: 5px;
        }
        .wrap {
            /* force the div to properly contain the floated images: */
            position:absolute;
            float:left;
            clear:none;
            overflow:hidden;
        }
        .wrap img {
            position:relative;
            z-index:1;
        }
        .wrap .desc {
            display:block;
            position:absolute;
            width:100%;
            top:5%;
            left:0;
            z-index:2;
            text-align:center;
        }
    </style>
</head>

<body style="background:#fdfcfc">
<!-- Static navbar -->
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
            <a class="navbar-brand" href="#">
                <p class="cabecera">CONSULTA</p>
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
<div class="container" style="width: 100%;">
    <div class="form-group form-group-sm">
        <h4>
            <span class="right" style="float:right;">${entablado.codigo}</span>
            <span class="left"  style="float:left;"></span>
        </h4>
    </div>
    </br>
    <div class="row">
        <div class="col-sm-2">
            <img class="d-block img-fluid float-left" src="http://s2.subirimagenes.com/imagen/previo/thump_9752997pieza.png" height="150" width="170">
        </div>
        <div class="col-sm-10">
            <table class="table table-bordered table-responsive">
                <thead bgcolor="#fdfcfc" style="background:#626262">
                <tr>
                    <th>
                        <font color="#fdfcfc">CÓDIGO</font>
                    </th>
                    <th>
                        <font color="#fdfcfc">DESRIPCIÓN</font>
                    </th>
                    <th class="text-center">
                        <font color="#fdfcfc">CANT</font>
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td id='codigoArtSel' class="m-0">${articulo.no}</td>
                    <td id='descArtSel'>${articulo.description}</td>
                    <td id='catArtSel' class="text-center">${localizacionArticulo.cantidad}</td>
                </tr>
                </tbody>
            </table>
            <div id='entradaManual'>
                <h4  class="text-left">CONSULTA</h4>
            </div>
            <div id="entradaNoConfirmada" class="form-group form-group-sm">
                <h5>
                <span class="right" style="float:right;">
                   <div id="historico" class="btn btn-default btn-lg" style='background:#324891;border-radius:0;color:white'>Historico</div>
                </span>
                    <span class="left"  style="float:left;">
                          <c:if test="${!empty lanzadera && entablado.lanzadera.id_lanzadera==lanzadera.id_lanzadera}">
                             <div id="traerEntablado" class="btn btn-default btn-lg" style='background:#324891;border-radius:0;color:white'>EXTRAER ENTABLADO</div>
                            <div id="regularizar" class="btn btn-default btn-lg" style='background:#324891;border-radius:0;color:white ' >Regularizar</div>
                          </c:if>
                </span>
                </h5>
            </div>
            <!--Introducir cantidad-->
        </div>
    </div>
    <div id="entablado" style="background-image: url(cajas/entabladoCompleto.png ); background-size: 100% 100%; height: 50%; width: 100%;position:relative" >
        <!--dibujar posiciones-->
        <c:if test="${!empty ubicaciones}">

            <c:forEach items="${ubicaciones}" var="ubicacion">
                <c:choose>
                    <c:when test="${ubicacion.tipoCaja.id_caja==1 && ubicacion.fila==localizacionArticulo.fila && ubicacion.columna==localizacionArticulo.columna}">
                        <div  fila=${ubicacion.fila} fila2=${ubicacion.fila} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:6.1%;height:11.5%;border:2px solid black;background:#324891'><h4 class='desc'>
                                ${ubicacion.cantidad}</h4></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==2 && ubicacion.fila==localizacionArticulo.fila && ubicacion.columna==localizacionArticulo.columna}">
                        <div  fila=${ubicacion.fila} fila2=${ubicacion.fila-1} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:6.1%;height:23%;border:2px solid black;background:#324891'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==3 && ubicacion.fila==localizacionArticulo.fila && ubicacion.columna==localizacionArticulo.columna}">
                        <div  fila=${ubicacion.fila} fila2=${ubicacion.fila-1} columna=${ubicacion.columna} columna2=${ubicacion.columna+2} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:23%;border:2px solid black;background:#324891'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==4 && ubicacion.fila==localizacionArticulo.fila && ubicacion.columna==localizacionArticulo.columna}">
                        <div fila=${ubicacion.fila}  fila2=${ubicacion.fila-3} columna=${ubicacion.columna} columna2=${ubicacion.columna+1} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:46%;border:2px solid black;background:#324891'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==5 && ubicacion.fila==localizacionArticulo.fila && ubicacion.columna==localizacionArticulo.columna}">
                        <div fila=${ubicacion.fila}  fila2=${ubicacion.fila-3} columna=${ubicacion.columna} columna2=${ubicacion.columna+1} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:46%;border:2px solid black;background:#324891'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==6 && ubicacion.fila==localizacionArticulo.fila && ubicacion.columna==localizacionArticulo.columna}">
                        <div fila=${ubicacion.fila}  fila2=${ubicacion.fila-3} columna=${ubicacion.columna} columna2=${ubicacion.columna+3} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:24.4%;height:46%;border:2px solid black;background:#324891'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==7 && ubicacion.fila==localizacionArticulo.fila && ubicacion.columna==localizacionArticulo.columna}">
                        <div fila=${ubicacion.fila}  fila2=${ubicacion.fila-7} columna=${ubicacion.columna} columna2=${ubicacion.columna+3} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:24.4%;height:92%;border:2px solid black;background:#324891'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==8 && ubicacion.fila==localizacionArticulo.fila && ubicacion.columna==localizacionArticulo.columna}">
                        <div fila=${ubicacion.fila}  fila2=${ubicacion.fila-7} columna=${ubicacion.columna} columna2=${ubicacion.columna+7} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:48.8%;height:92%;border:2px solid black;background:#324891'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==9 && ubicacion.fila==localizacionArticulo.fila && ubicacion.columna==localizacionArticulo.columna}">
                        <div fila=${ubicacion.fila}  fila2=${ubicacion.fila-7} columna=${ubicacion.columna} columna2=${ubicacion.columna+15} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:97.6%;height:92%;border:2px solid black;background:#324891'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==10 && ubicacion.fila==localizacionArticulo.fila && ubicacion.columna==localizacionArticulo.columna}">
                        <div id="subdivision2x1" fila2=${ubicacion.fila}  fila=${ubicacion.fila+3} columna=${ubicacion.columna} columna2=${ubicacion.columna+1}  class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:46%;border:2px solid black'>
                            <h4 class='desc'></h4>
                        </div>
                        <div fila2=${ubicacion.fila}  fila=${ubicacion.fila+2} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos+23.1}%;left:+${ubicacion.xPos}%;width:6.1%;height:23%;border:2px solid black;background:#324891'>
                            <h2 class='desc'>${ubicacion.cantidad}</h2>
                        </div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==11 && ubicacion.fila==localizacionArticulo.fila && ubicacion.columna==localizacionArticulo.columna}">
                        <div id="subdivision1x1" fila2=${ubicacion.fila}  fila=${ubicacion.fila+3} columna=${ubicacion.columna} columna2=${ubicacion.columna+1}  class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:46%;border:2px solid black'>
                            <h2 class='desc'></h2>
                        </div>
                        <div fila=${ubicacion.fila}  fila2=${ubicacion.fila} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos+34.6}%;left:+${ubicacion.xPos}%;width:6.1%;height:11.5%;border:2px solid black;background:#324891'>
                            <h2 class='desc'>${ubicacion.cantidad}</h2>
                        </div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==1}">
                        <div  fila=${ubicacion.fila} fila2=${ubicacion.fila} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:6.1%;height:11.5%;border:2px solid black;background:#dadada'><h4 class='desc'>
                                ${ubicacion.cantidad}</h4></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==2}">
                        <div  fila=${ubicacion.fila} fila2=${ubicacion.fila-1} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:6.1%;height:23%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==3}">
                        <div  fila=${ubicacion.fila} fila2=${ubicacion.fila-1} columna=${ubicacion.columna} columna2=${ubicacion.columna+2} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:23%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==4}">
                        <div fila=${ubicacion.fila}  fila2=${ubicacion.fila-3} columna=${ubicacion.columna} columna2=${ubicacion.columna+1} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:46%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==5}">
                        <div fila=${ubicacion.fila}  fila2=${ubicacion.fila-3} columna=${ubicacion.columna} columna2=${ubicacion.columna+1} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:46%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==6}">
                        <div fila=${ubicacion.fila}  fila2=${ubicacion.fila-3} columna=${ubicacion.columna} columna2=${ubicacion.columna+3} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:24.4%;height:46%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==7}">
                        <div fila=${ubicacion.fila}  fila2=${ubicacion.fila-7} columna=${ubicacion.columna} columna2=${ubicacion.columna+3} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:24.4%;height:92%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==8}">
                        <div fila=${ubicacion.fila}  fila2=${ubicacion.fila-7} columna=${ubicacion.columna} columna2=${ubicacion.columna+7} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:48.8%;height:92%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==9}">
                        <div fila=${ubicacion.fila}  fila2=${ubicacion.fila-7} columna=${ubicacion.columna} columna2=${ubicacion.columna+15} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:97.6%;height:92%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==10}">
                        <div id="subdivision2x1" fila2=${ubicacion.fila}  fila=${ubicacion.fila+3} columna=${ubicacion.columna} columna2=${ubicacion.columna+1}  class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:46%;border:2px solid black'>
                            <h2 class='desc'></h2>
                        </div>
                        <div fila2=${ubicacion.fila}  fila=${ubicacion.fila+2} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos+23.1}%;left:+${ubicacion.xPos}%;width:6.1%;height:23%;border:2px solid black;background:#dadada'>
                            <h2 class='desc'>${ubicacion.cantidad}</h2>
                        </div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==11}">
                        <div id="subdivision1x1" fila2=${ubicacion.fila}  fila=${ubicacion.fila+3} columna=${ubicacion.columna} columna2=${ubicacion.columna+1}  class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:46%;border:2px solid black'>
                            <h4 class='desc'></h4>
                        </div>
                        <div fila=${ubicacion.fila}  fila2=${ubicacion.fila} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos+34.6}%;left:+${ubicacion.xPos}%;width:6.1%;height:11.5%;border:2px solid black;background:#dadada'>
                            <h4 class='desc'>${ubicacion.cantidad}</h4>
                        </div>
                    </c:when>
                </c:choose>
            </c:forEach>
        </c:if>
        <c:if test="${!empty reservas}">
            <c:forEach items="${reservas}" var="reserva">
                <c:choose>
                    <c:when test="${reserva.fila==localizacionArticulo.fila && reserva.columna==localizacionArticulo.columna}">
                        <div tipo='medida' fila=${reserva.fila} fila2=${reserva.fila-reserva.nfilas+1} columna=${reserva.columna-reserva.ncolumnas+1} columna2=${reserva.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${reserva.yPos}%;left:+${reserva.xPos}%;width:${6.1*reserva.ncolumnas}%;height:${11.5*reserva.nfilas}%;border:2px solid black;background:#324891'><h2 class='desc'>
                                ${reserva.cantidad}</h2></div>
                    </c:when>
                    <c:otherwise>
                        <div  fila=${reserva.fila} fila2=${reserva.fila-reserva.nfilas+1} columna=${reserva.columna-reserva.ncolumnas+1} columna2=${reserva.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${reserva.yPos}%;left:+${reserva.xPos}%;width:${6.1*reserva.ncolumnas}%;height:${11.5*reserva.nfilas}%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                ${reserva.cantidad}</h2></div>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </c:if>
        <!-- muestra un dibujo con el contenido del entablado -->
        <div id="contenidoEntablado" class="container">
        </div>
    </div>
</div>
<!--Diagolo espera -->
<!--Diagolo localizacion añadErrorrror -->
<div id="seleccionarArtiulo" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Selecionar Articulo</h4>
            </div>
            <div class="modal-body">
                <p>Para regularizar debes seleccionar un articulo</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<!--Diagolo regularizar -->
<div id="regularizarArtiulo" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Regularizar Articulo</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label>Cantidad a regularizar:</label>
                    <input id='cantidadRegularizar' type="number" class="form-control">
                </div>
            </div>
            <div class="modal-footer">
                <button id='botonRegularizar' type="button" class="btn btn-primary" data-dismiss="modal">Regularizar</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div>
<div id="esperarEntablado" class="modal fade"  role="dialog" data-backdrop="static" data-keyboard="false">
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

<div id="ErrorRegularizar" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title">Acceso denegado</h4>
            </div>
            <div class="modal-body"> <strong>Error</strong>
                <p/>
                <p>No se ha podido regularizar el material.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-lg outline px-3 mx-3" style="float: right;background:#324891;color: white;" data-dismiss="modal">
                    CERRAR
                </button>
            </div>
        </div>
    </div>
</div>
<script src="js/tether.min.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="js/dataTables.bootstrap.min.js" type="text/javascript"></script>
<script>
   function Posicion () { // constructor function
        this.fila=0;
        this.columna=0;
        this.xCoord=0.0;
        this.yCoord=0.0;
        this.subdivision=false;
        this.insertarSubdivision=false;
        this.msg="${entabladoCorrecto}";

        this.privilegedMethod = function () {  // Public Method

        };
    }
    var Crear = new Posicion();

    $(document).ready(function() {
            $("#traerEntablado").click(function() {
                $.ajax({
                    url: 'http://${entablado.lanzadera.direccion_ip}:8080/ServidorArmarios/JSONServlet',
                    type: 'POST',
                    async: true,
                    dataType : "json",
                    json : "callback",
                    data: { orden:'MOVER', lanzadera:parseInt(${entablado.lanzadera.id_lanzadera}) ,
                        entablado:parseInt(${entablado.codigo.substring(10)},10) ,
                        codigoAcesso:'${entablado.lanzadera.punto_acesso}'},
                    success: function(data){
                        $('#esperarEntablado').modal('toggle');
                        console.log(data);
                        var result = JSON.stringify(data);
                        if (data['RESULT '] == 'OK') {
                            heBajado=true;
                            $('#traerEntablado').addClass('hidden');
                        }
                        else if (data['RESULT '] == 'DENEGADO') {
                            $('#traerEntablado').addClass('hidden');
                            $('#dialogoAcessoRemotoDenegado').modal('toggle');
                        }
                    },
                    error: function(data)
                    {
                        $('#esperarEntablado').modal('toggle');
                    },
                    beforeSend: function() {
                        console.log(parseInt(${entablado.codigo.substring(10)},10));
                        $('#esperarEntablado').modal({
                            show: 'true'
                        });
                    }
                });
            });

        $('#historico').click(function(){
            window.location.href = "ConsultaHistoricoEntablado.html?entablado=${entablado.codigo}";
        });

        //mostrar informacion articulo
        $("div[id=nuevaCaja]").click(function(){
            $("div[id=nuevaCaja]").each(function () {
                $(this).css('background','#dadada');
                $(this).css('color','black');
            });
            $("#codigoArtSel").text( $(this).attr('codigo'));
            $("#provoArtSel").text('');
            $("#descArtSel").text( $(this).attr('descripcion'));
            $("#catArtSel").text( parseInt($(this).attr('cant')));
            $(this).css('background','#324891');
            $(this).css('color','white');
            $('#regularizar').css('background','#324891');
            Crear.fila=$(this).attr('fila');
            Crear.columna=$(this).attr('col');
        });

        //mostrar informacion articulo
        $("div[id=regularizar]").click(function(){
            if($(this).css('background-color') != 'rgb(50, 72, 145)'){
                $('#seleccionarArtiulo').modal({
                    show: 'true'
                });
            }else{
                //selecionar cantidad a regularizar
                $('#regularizarArtiulo').modal({
                    show: 'true'
                });
            }
        });


        //mostrar informacion articulo
        $('#botonRegularizar').click(function(){
            if($("#cantidadRegularizar").val() > 0){
              //regularizar
                        $.ajax({
                            type: 'GET',
                            contentType : 'application/json; charset=utf-8',
                            url: '/OscaArmarios/Operacion/regularizarCaja',
                            //lanzadera entablado x y articulo cantidad
                            data: { entablado:'${localizacionArticulo.entablado.codigo}', articulo: '${articulo.no}',
                                xPos:parseInt(${localizacionArticulo.fila}) , yPos: parseInt(${localizacionArticulo.columna}) , cantidad:parseInt($("#cantidadRegularizar").val()),
                            },
                            dataType: 'json',
                            async : true,
                            beforeSend: function()
                            {

                            },success: function(data) {
                                if(data['res']=='true') {
                                    window.location.href = window.location.href;
                                }
                            },error: function() {
                                $('#ErrorRegularizar').modal({
                                    show: 'true'
                                });
                            }
                        });
                        }
                    });

    });

</script>
</body>

</html>