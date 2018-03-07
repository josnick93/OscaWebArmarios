<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Port�til1
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
    <script src="js/jquery.numpad.js"></script>
    <link rel="stylesheet" href="css/jquery.numpad.css">
    <!--<link rel="import" href="pages/Notificaciones.html">-->
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
                <p class="cabecera">LANZADERA </p>
            </a>
        </div>
        <div class="navbar-collapse collapse" id="navbar">
            <ul class="nav navbar-nav navbar-right" style="border-left: 2px solid white">
                <li class="acessosHome" style="border-right: 2px solid white">
                    <a href="/OscaArmarios/EntradaMaterialHome.html">
                        <p class="cabecera text-center">&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon glyphicon-save"></span>&nbsp;&nbsp;Entrada&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                    </a>
                </li>
                <li class="acessosHome" style="border-right: 2px solid white" >
                    <a href="/OscaArmarios/ConsultaMaterialHome.html">
                        <p class="cabecera text-center">&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon glyphicon-search"></span>&nbsp;&nbsp;Consulta&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                    </a>
                </li>
                <li class="acessosHome active" style="border-right: 2px solid white">
                    <a href="/OscaArmarios/SalidaMaterialHome.html">
                        <p class="cabecera text-center ">&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon glyphicon-open"></span>&nbsp;&nbsp;Salida&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                    </a>
                </li>
                <li class="text-center"> </li>
                <li class="text-center">
                    <button id="backButton" class="btn btn-default" onclick="goBack()" style="margin:5px;margin-left:5px;height:60px">
                        <p class="text-center "> <span class="icon-flipped glyphicon glyphicon-share-alt" style="vertical-align:middle;font-size: 28px;"></span> </p>
                    </button>
                </li>
                <li class="acessosHome" class="text-center">
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
            <span class="left"  style="float:left;">${entablado.codigo}</span>
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
                        <font color="#fdfcfc">CANTIDAD ENTRADA</font>
                    </th>
                    <th class="text-center">
                        <font color="#fdfcfc">CANTIDAD A MANIPULAR</font>
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="m-0">${articuloPedido.itemNo}</td>
                    <td>${articuloPedido.description}</td>
                    <td class="text-center">${articuloPedido.qtyOutstanding}</td>
                    <td id="cantidadManip" class="text-center" style="cursor:pointer">${articuloPedido.qtyOutstanding}</td>
                </tr>
                </tbody>
            </table>
            <div id='entradaManual'>
                <h4  class="text-left">ENTRADA MANUAL</h4>
            </div>
            <div id="entradaNoConfirmada" class="form-group form-group-sm">
                <h5>
                <span class="right" style="float:right;">
                    <div id="discountCustomMaterial" class="btn btn-default btn-lg" style="background:#7d7d7d;border-radius:0;color:white">DESCONTAR CANTIDAD MATERIAL</div>
                    <div id="discountMaterial" class="btn btn-default btn-lg" style="background:#7d7d7d;border-radius:0;color:white">DESCONTAR TODO MATERIAL</div>
                </span>
                    <span class="left"  style="float:left;">
                   <div id="PausarPedido" class="btn btn-default btn-lg" style='background:#DD0000;border-radius:0;color:white'>PAUSAR PEDIDO</div>
                </span>
                </h5>
            </div>
            <!--introducir cantidad-->
        </div>
    </div>
    <div id="entablado" style="background-image: url(cajas/entabladoCompleto.png ); background-size: 100% 100%; height: 50%; width: 100%;position:relative" >
        <!--dibujar posiciones-->
        <c:if test="${!empty ubicaciones}">
            <c:forEach items="${ubicaciones}" var="ubicacion">
                <c:choose>
                    <c:when test="${ubicacion.tipoCaja.id_caja==1}">
                        <c:choose>
                            <c:when test="${ubicacion.articulo.equals(articuloPedido.itemNo)}">
                                <div  fila=${ubicacion.fila} fila2=${ubicacion.fila} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap posicionArticulo" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:6.1%;height:11.5%;border:8px solid #DD0000;background:#dadada;cursor:default'><h2 class='desc'>
                                        ${ubicacion.cantidad}</h2></div>
                            </c:when>
                            <c:otherwise>
                                <div  fila=${ubicacion.fila} fila2=${ubicacion.fila} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:6.1%;height:11.5%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                        ${ubicacion.cantidad}</h2></div>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==2}">
                        <c:choose>
                            <c:when test="${ubicacion.articulo.equals(articuloPedido.itemNo)}">
                                <div  fila=${ubicacion.fila} fila2=${ubicacion.fila-1} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap posicionArticulo" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:6.1%;height:23%;border:8px solid #DD0000;background:#dadada;cursor:default'><h2 class='desc'>
                                        ${ubicacion.cantidad}</h2></div>
                            </c:when>
                            <c:otherwise>
                                <div  fila=${ubicacion.fila} fila2=${ubicacion.fila-1} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:6.1%;height:23%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                        ${ubicacion.cantidad}</h2></div>
                            </c:otherwise>
                        </c:choose>

                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==3}">
                        <c:choose>
                            <c:when test="${ubicacion.articulo.equals(articuloPedido.itemNo)}">
                                <div  fila=${ubicacion.fila} fila2=${ubicacion.fila-1} columna=${ubicacion.columna} columna2=${ubicacion.columna+2} class="wrap posicionArticulo" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:23%;border:8px solid #DD0000;background:#dadada;cursor:default'><h2 class='desc'>
                                        ${ubicacion.cantidad}</h2></div>
                            </c:when>
                            <c:otherwise>
                                <div  fila=${ubicacion.fila} fila2=${ubicacion.fila-1} columna=${ubicacion.columna} columna2=${ubicacion.columna+2} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:23%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                        ${ubicacion.cantidad}</h2></div>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==4}">
                        <c:choose>
                            <c:when test="${ubicacion.articulo.equals(articuloPedido.itemNo)}">
                                <div fila=${ubicacion.fila}  fila2=${ubicacion.fila-3} columna=${ubicacion.columna} columna2=${ubicacion.columna+1} class="wrap posicionArticulo" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:46%;border:8px solid #DD0000;background:#dadada;cursor:default'><h2 class='desc'>
                                        ${ubicacion.cantidad}</h2></div>
                            </c:when>
                            <c:otherwise>
                                <div fila=${ubicacion.fila}  fila2=${ubicacion.fila-3} columna=${ubicacion.columna} columna2=${ubicacion.columna+1} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:46%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                        ${ubicacion.cantidad}</h2></div>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==5}">
                        <c:choose>
                            <c:when test="${ubicacion.articulo.equals(articuloPedido.itemNo)}">
                                <div fila=${ubicacion.fila}  fila2=${ubicacion.fila-3} columna=${ubicacion.columna} columna2=${ubicacion.columna+1} class="wrap posicionArticulo" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:46%;border:8px solid #DD0000;background:#dadada;cursor:default'><h2 class='desc'>
                                        ${ubicacion.cantidad}</h2></div>
                            </c:when>
                            <c:otherwise>
                                <div fila=${ubicacion.fila}  fila2=${ubicacion.fila-3} columna=${ubicacion.columna} columna2=${ubicacion.columna+1} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:46%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                        ${ubicacion.cantidad}</h2></div>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==6}">
                        <c:choose>
                            <c:when test="${ubicacion.articulo.equals(articuloPedido.itemNo)}">
                                <div fila=${ubicacion.fila}  fila2=${ubicacion.fila-3} columna=${ubicacion.columna} columna2=${ubicacion.columna+3} class="wrap posicionArticulo" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:24.4%;height:46%;border:8px solid #DD0000;background:#dadada;cursor:default'><h2 class='desc'>
                                        ${ubicacion.cantidad}</h2></div>
                            </c:when>
                            <c:otherwise>
                                <div fila=${ubicacion.fila}  fila2=${ubicacion.fila-3} columna=${ubicacion.columna} columna2=${ubicacion.columna+3} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:24.4%;height:46%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                        ${ubicacion.cantidad}</h2></div>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==7}">
                        <c:choose>
                            <c:when test="${ubicacion.articulo.equals(articuloPedido.itemNo)}">
                                <div fila=${ubicacion.fila}  fila2=${ubicacion.fila-7} columna=${ubicacion.columna} columna2=${ubicacion.columna+3} class="wrap posicionArticulo" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:24.4%;height:92%;border:8px solid #DD0000;background:#dadada;cursor:default'><h2 class='desc'>
                                        ${ubicacion.cantidad}</h2></div>
                            </c:when>
                            <c:otherwise>
                                <div fila=${ubicacion.fila}  fila2=${ubicacion.fila-7} columna=${ubicacion.columna} columna2=${ubicacion.columna+3} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:24.4%;height:92%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                        ${ubicacion.cantidad}</h2></div>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==8}">
                        <c:choose>
                            <c:when test="${ubicacion.articulo.equals(articuloPedido.itemNo)}">
                                <div fila=${ubicacion.fila}  fila2=${ubicacion.fila-7} columna=${ubicacion.columna} columna2=${ubicacion.columna+7} class="wrap posicionArticulo" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:48.8%;height:92%;border:8px solid #DD0000;background:#dadada;cursor:default'><h2 class='desc'>
                                        ${ubicacion.cantidad}</h2></div>
                            </c:when>
                            <c:otherwise>
                                <div fila=${ubicacion.fila}  fila2=${ubicacion.fila-7} columna=${ubicacion.columna} columna2=${ubicacion.columna+7} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:48.8%;height:92%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                        ${ubicacion.cantidad}</h2></div>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==9}">
                        <c:choose>
                            <c:when test="${ubicacion.articulo.equals(articuloPedido.itemNo)}">
                                <div fila=${ubicacion.fila}  fila2=${ubicacion.fila-7} columna=${ubicacion.columna} columna2=${ubicacion.columna+15} class="wrap posicionArticulo" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:97.6%;height:92%;border:8px solid #DD0000;background:#dadada;cursor:default'><h2 class='desc'>
                                        ${ubicacion.cantidad}</h2></div>
                            </c:when>
                            <c:otherwise>
                                <div fila=${ubicacion.fila}  fila2=${ubicacion.fila-7} columna=${ubicacion.columna} columna2=${ubicacion.columna+15} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:97.6%;height:92%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                        ${ubicacion.cantidad}</h2></div>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==10}">
                        <c:choose>
                            <c:when test="${ubicacion.articulo.equals(articuloPedido.itemNo)}">
                                <div id="subdivision2x1" fila2=${ubicacion.fila}  fila=${ubicacion.fila+3} columna=${ubicacion.columna} columna2=${ubicacion.columna+1}  class="wrap posicionArticulo" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:46%;border:8px solid #DD0000'>
                                    <h2 class='desc'></h2>
                                </div>
                                <div fila2=${ubicacion.fila}  fila=${ubicacion.fila+2} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap posicionArticulo" style='margin-left:0.2%;top:${ubicacion.yPos+23.1}%;left:+${ubicacion.xPos}%;width:6.1%;height:23%;border:8px solid #DD0000;background:#dadada;cursor:default'>
                                    <h2 class='desc'>${ubicacion.cantidad}</h2>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div id="subdivision2x1" fila2=${ubicacion.fila}  fila=${ubicacion.fila+3} columna=${ubicacion.columna} columna2=${ubicacion.columna+1}  class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:46%;border:2px solid black'>
                                    <h2 class='desc'></h2>
                                </div>
                                <div fila2=${ubicacion.fila}  fila=${ubicacion.fila+2} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos+23.1}%;left:+${ubicacion.xPos}%;width:6.1%;height:23%;border:2px solid black;background:#dadada'>
                                    <h2 class='desc'>${ubicacion.cantidad}</h2>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==11}">
                        <c:choose>
                            <c:when test="${ubicacion.articulo.equals(articuloPedido.itemNo)}">
                                <div id="subdivision1x1" fila2=${ubicacion.fila}  fila=${ubicacion.fila+3} columna=${ubicacion.columna} columna2=${ubicacion.columna+1}  class="wrap posicionArticulo" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:46%;border:8px solid #DD0000'>
                                    <h2 class='desc'></h2>
                                </div>
                                <div fila=${ubicacion.fila}  fila2=${ubicacion.fila} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap posicionArticulo" style='margin-left:0.2%;top:${ubicacion.yPos+34.6}%;left:+${ubicacion.xPos}%;width:6.1%;height:11.5%;border:8px solid #DD0000;background:#dadada;cursor:default'>
                                    <h2 class='desc'>${ubicacion.cantidad}</h2>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div id="subdivision1x1" fila2=${ubicacion.fila}  fila=${ubicacion.fila+3} columna=${ubicacion.columna} columna2=${ubicacion.columna+1}  class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:46%;border:2px solid black'>
                                    <h2 class='desc'></h2>
                                </div>
                                <div fila=${ubicacion.fila}  fila2=${ubicacion.fila} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos+34.6}%;left:+${ubicacion.xPos}%;width:6.1%;height:11.5%;border:2px solid black;background:#dadada'>
                                    <h2 class='desc'>${ubicacion.cantidad}</h2>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                </c:choose>
            </c:forEach>
        </c:if>
        <!--reservas-->
        <c:if test="${!empty reservas}">
            <c:forEach items="${reservas}" var="reserva">
                <c:choose>
                    <c:when test="${ubicacion.articulo.equals(articuloPedido.itemNo)}">
                        <div  fila=${reserva.fila} fila2=${reserva.fila-reserva.nfilas+1} columna=${reserva.columna} columna2=${reserva.columna+reserva.ncolumnas-1} class="wrap posicionArticulo" style='margin-left:0.2%;top:${reserva.yPos}%;left:+${reserva.xPos}%;width:${6.1*reserva.ncolumnas}%;height:${11.5*reserva.nfilas}%;border:8px solid #DD0000;background:#dadada;cursor:default'><h2 class='desc'>
                                ${reserva.cantidad}</h2></div>
                    </c:when>
                    <c:otherwise>
                        <div  fila=${reserva.fila} fila2=${reserva.fila-reserva.nfilas+1} columna=${reserva.columna} columna2=${reserva.columna+reserva.ncolumnas-1} class="wrap cajaOcupada" style='margin-left:0.2%;top:${reserva.yPos}%;left:+${reserva.xPos}%;width:${6.1*reserva.ncolumnas}%;height:${11.5*reserva.nfilas}%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                ${reserva.cantidad}</h2></div>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </c:if>
        <div id="contenidoEntablado" class="container">
        </div>
    </div>

</div>
<!-- mostrar dialogo seleccion entablado -->
<!--Diagolo espera -->
<!-- Dialogo no se ha bajado el entablado -->
<!-- Modal -->
<div id="errorSeleccionUbicacion" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title">Seleccionar Posición</h4>
            </div>
            <div class="modal-body">
                <p>Debes seleccionar una caja para poder añadir material.</p>
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
<!--Diagolo localizacion a�adida -->
<div id="localizacionadd" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Ubicacion añadida</h4>
            </div>
            <div class="modal-body">
                <p>Se ha añadido una nueva ubicacion correctamente</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">CERRAR</button>
            </div>
        </div>

    </div>
</div>
<!--Diagolo localizacion a�adida -->
<div id="localizacionaddError" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Error al añadir ubicacion</h4>
            </div>
            <div class="modal-body">
                <p>No se ha podido añadir la ubicacion</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-lg outline px-3 mx-3" style="float: right;background:#7d7d7d;color: white;" data-dismiss="modal">CERRAR</button>
            </div>
        </div>
    </div>
</div>

<!--Diagolo espera bajar entablado -->
<div id="esperarEntablado" class="modal fade"  role="dialog" data-backdrop="static" data-keyboard="false"role="dialog">
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
<!--Diagolo fin pedido -->
<div id="finPedido" class="modal fade"  role="dialog" data-backdrop="static" data-keyboard="false"role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title">Salida material completada</h4>
            </div>
            <div class="modal-body"> <strong>Instrucciones:</strong>
                <p/>
                <p>Introduccion de material finalizada</p>
            </div>
            <div class="modal-footer">
                <button type="button"  class="close_window btn btn-primary btn-lg outline px-3 mx-3" style="float: right;background:#DD0000;color: white;" data-dismiss="modal">
                    ACEPTAR
                </button>
            </div>
        </div>
    </div>
</div>
<div id="finPedidoLanzadera" class="modal fade"  role="dialog" data-backdrop="static" data-keyboard="false"role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title">Salida material completada en Lanzadera</h4>
            </div>
            <div class="modal-body"> <strong>Instrucciones:</strong>
                <p/>
                <p>Introduccion de material finalizada en esta lanzadera.</p>
            </div>
            <div class="modal-footer">
                <button type="button"  onclick="goHome()" class="btn btn-primary btn-lg outline px-3 mx-3" style="float: right;background:#DD0000;color: white;" data-dismiss="modal">
                    ACEPTAR
                </button>
            </div>
        </div>
    </div>
</div>
<!--Diagolo tipo entablado -->
<div id="dialogoPermisosLanzadera" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title">Acceso denegado</h4>
            </div>
            <div class="modal-body"> <strong>Dispositivo incorrecto</strong>
                <p/>
                <p>Este dispositivo no tiene acesso a la lanzadera.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-lg outline px-3 mx-3" style="float: right;background:#DD0000;color: white;" data-dismiss="modal">
                    <a href="/OscaArmarios/Home.html">CERRAR</a>
                </button>
            </div>
        </div>
    </div>
</div>


<div id="dialogoAcessoRemotoDenegado" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title">Acceso denegado</h4>
            </div>
            <div class="modal-body"> <strong>Lanzadera Ocupada</strong>
                <p/>
                <p>La lanzadera esta siendo ocupada en este momento,por seguridad
                    no es posible acceder remotamente.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-lg outline px-3 mx-3" style="float: right;background:#DD0000;color: white;" data-dismiss="modal">
                    <a href="/OscaArmarios/Home.html">CERRAR</a>
                </button>
            </div>
        </div>
    </div>
</div>
<div id="dialogoSeleccionCantidadDivision" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Seleccionar cantidad</h4>
            </div>
            <div class="modal-body">
                <form class="text-left">
                    <h3>Seleccionar Cantidad Material&nbsp;&nbsp;&nbsp;
                        <input id="entradaSalidaCantidadDivision" type="number" style="font-size:25px;width:150px;text-align:right; " name="fname"> </h3>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-lg outline px-3 mx-3" style="float: right;background:#DD0000;color: white;" data-dismiss="modal">CERRAR</button>
                <button id="botonCantidadParcial" type="button" class="btn btn-primary btn-lg outline px-3 mx-3" style="float: right;background:#DD0000;color: white;" data-dismiss="modal">ACEPTAR</button>
            </div>
        </div>
    </div>
</div>
<div id="dialogoSeleccionCantidad" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Seleccionar cantidad</h4>
            </div>
            <div class="modal-body">
                <form class="text-left">
                    <h3>Seleccionar Cantidad Material&nbsp;&nbsp;&nbsp;
                        <input id="entradaCantidad" type="number" style="font-size:25px;width:150px;text-align:right; " name="fname"> </h3>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-lg outline px-3 mx-3" style="float: right;background:#DD0000;color: white;" data-dismiss="modal">CERRAR</button>
                <button id="botonCantidad" type="button" class="btn btn-primary btn-lg outline px-3 mx-3" style="float: right;background:#DD0000;color: white;" data-dismiss="modal">ACEPTAR</button>
            </div>
        </div>
    </div>
</div>

<div id="errorNav" class="modal fade"  role="dialog" data-backdrop="static" data-keyboard="false"role="dialog" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title">Error en el servicio web</h4>
            </div>
            <div class="modal-body"> <strong>Causas:</strong>
                <p/>
                <p>1- No hay ninguna respuesta a mostrar</p>
                <p>2- El servidor de navision esta caido o no hay conexion</p>
                <p>3- La version de la base de datos es incompatible</p>
            </div>
        </div>
        <div class="modal-footer"> <a class="btn btn-primary" href="#errorNav" style="margin-right: auto; margin-left: auto; width: 300px;background:#009900" data-dismiss="modal">Cerrar</a> </div>
    </div>
</div>
<div id="esperaSalidaMaterial" class="modal fade"  role="dialog" data-backdrop="static" data-keyboard="false"role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal"></button>
                <h4 class="modal-title">Se esta añadiendo el material , por favor espere...</h4>
            </div>
            <div class="modal-body"> <strong>Instrucciones:</strong>
                <p/>
                <p>1- Espera a que se termine el proceso </p>
                <p>2- Se pasara a la siguiente linea de pedido</p>
            </div>
        </div>
    </div>
</div>

<script src="js/tether.min.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="js/dataTables.bootstrap.min.js" type="text/javascript"></script>
<script src="js/jquery.numpad.js"></script>
<script  type="text/javascript">
    $.fn.numpad.defaults.gridTpl = '<table class="table modal-content"></table>';
    $.fn.numpad.defaults.backgroundTpl = '<div class="modal-backdrop in"></div>';
    $.fn.numpad.defaults.displayTpl = '<input type="text" class="form-control" />';
    $.fn.numpad.defaults.buttonNumberTpl =  '<button type="button" class="btn btn-default " style="width: 100%;"></button>';
    $.fn.numpad.defaults.buttonFunctionTpl = '<button type="button" class="btn" style="width: 100%;"></button>';
    $.fn.numpad.defaults.onKeypadCreate = function(){$(this).find('.done').addClass('btn-primary').css('background','#626262');};
    $('#entradaSalidaCantidadDivision').numpad();


    $(document).ready(function() {
        if(${!empty tengoLineaPedido && !tengoLineaPedido}){
            $('#finPedidoLanzadera').modal('toggle');
        }
        if(${cerrar==1}){
            $('.acessosHome').each(function(i, obj) {
                $(this).hide();
            });
        }

        $('#cantidadManip').click(function () {
            $('#dialogoSeleccionCantidad').modal('toggle');
        });
        $("#botonCantidad").click(function () {
            if(parseInt($('#entradaCantidad').val()) > 0) {
                $("#cantidadManip").append();
                $("#cantidadManip").append($('#entradaCantidad').val());
            }
        });
        
        $("backButton").click(function() {

            if(${cerrar==1}) {
                $.ajax({
                    url: '/OscaArmarios/OperacionEntablado/CerrarVentana',
                    type: 'POST',
                    async: true,
                    dataType : "json",
                    json : "callback",
                    data: { ip:'${entablado.lanzadera.direccion_ip}'},
                    success:function () {
                    }
                });
            }else{
                window.location.href="/OscaArmarios/SalidaInfoPedido.html?pedido=${articuloPedido.no}";
            }
        });
        var closeButtons = $('.close_window');
        closeButtons.on('click', function() {
            if(${cerrar==1}){
                $.ajax({
                    url: '/OscaArmarios/OperacionEntablado/CerrarVentana',
                    type: 'POST',
                    async: true,
                    dataType : "json",
                    json : "callback",
                    data: { ip:'${entablado.lanzadera.direccion_ip}'},
                    success:function () {
                    }
                });
            }
            else window.location.href="/OscaArmarios/Home.html";
        });

        $("#discountCustomMaterial").click(function() {
            $('#dialogoSeleccionCantidadDivision').modal('toggle');
        });

        var fila=0;
        var columna=0;
        //traer entablado
        if(!${empty lanzadera}){
            $.ajax({
                url: 'http://${entablado.lanzadera.direccion_ip}:8080/ServidorArmarios/JSONServlet',
                type: 'POST',
                async: true,
                dataType : "json",
                json : "callback",
                data: { orden:'MOVER', lanzadera:parseInt(${entablado.lanzadera.id_lanzadera}) ,
                    entablado:parseInt(${entablado.codigo.substring(10)},10) , codigoAcesso:'${entablado.lanzadera.punto_acesso}'},
                success: function(data){
                    $('#esperarEntablado').modal('toggle');
                    console.log(data);
                    var result = JSON.stringify(data);
                    if (data['RESULT '] == 'OK') {
                        $('#traerEntablado').addClass('hidden');
                    }
                    else if (result === "{\"RESULT \":\"DENEGADO\"}") {
                        $('#dialogoAcessoRemotoDenegado').modal('toggle');

                    }
                },
                error: function(data)
                {
                    $('#esperarEntablado').modal('toggle');
                },
                beforeSend: function() {
                    $('#esperarEntablado').modal({
                        show: 'true'
                    });
                }
            });
        }else{
            //mostrar que no tienes permisos
            $('#dialogoPermisosLanzadera').modal('toggle');
        }

        $(".posicionArticulo").click(function(){
            $( ".posicionArticulo" ).each(function( index ) {
                $(this).css('backgroundColor', '#DD0000');
            });
            fila=parseInt($(this).attr("fila"));
            columna=parseInt($(this).attr("columna"));
            console.log(fila);
            console.log(columna);
            $(this).css('backgroundColor', '#DD0000');
            $("#discountMaterial").css('backgroundColor', '#DD0000');
            $("#discountCustomMaterial").css('backgroundColor', '#DD0000');
        });

        /**
         *
         * Dividir la linea
         */
        $("#botonCantidadParcial").click( function () {
            //añadir material
            if($("#addCustomMaterial").css("backgroundColor")=="rgb(6, 169, 11)" && parseInt($('#entradaSalidaCantidadDivision').val()) > 0){
                $('#esperaSalidaMaterial').modal('toggle');
                $("#addCustomMaterial").modal('toggle');
                //marcar pedido y lanzar siguiente orden
                $.ajax({
                    type: 'GET',
                    contentType : 'application/json; charset=utf-8',
                    url: '/OscaArmarios/Operacion/DiscountMaterialPedidoDividir',
                    //lanzadera entablado x y articulo cantidad
                    data: {
                        No:'${articuloPedido.no}',
                        Line_No:${articuloPedido.lineNo},
                        sourceNo:'${articuloPedido.sourceNo}',
                        Item_No:'${articuloPedido.itemNo}',
                        Bin_Code:'${articuloPedido.binCode}',
                        fila:fila,
                        columna:columna,
                        cantidad:parseInt($('#entradaSalidaCantidadDivision').val()),
                        cerrar:${cerrar}
                    },
                    dataType: 'json',
                    async : true,
                    success: function(data) {
                        if(data['res']=='true'){
                            //liberar lanzadera
                            $.ajax({
                                url: 'http://${entablado.lanzadera.direccion_ip}:8080/ServidorArmarios/JSONServlet',
                                type: 'POST',
                                async: true,
                                dataType : "json",
                                json : "callback",
                                data: { orden:'LIBERAR', lanzadera:parseInt(${entablado.lanzadera.id_lanzadera}) ,
                                    entablado:parseInt(${entablado.codigo.substring(10)},10) , codigoAcesso:'${entablado.lanzadera.punto_acesso}'},
                                success:function () {
                                    window.location.href="/OscaArmarios/SalidaArticuloPedido.html?pedido=${articuloPedido.no}&cerrar=${cerrar}";
                                }
                            });

                        }
                        else if(data['res']=='fin'){
                            $('#finPedido').modal('toggle');
                            $.ajax({
                                url: 'http://${entablado.lanzadera.direccion_ip}:8080/ServidorArmarios/JSONServlet',
                                type: 'POST',
                                async: true,
                                dataType : "json",
                                json : "callback",
                                data: { orden:'LIBERAR', lanzadera:parseInt(${entablado.lanzadera.id_lanzadera}) ,
                                    entablado:parseInt(${entablado.codigo.substring(10)},10) , codigoAcesso:'${entablado.lanzadera.punto_acesso}'},
                                success:function () {
                                }
                            });

                        }if(data['res']=='finLanzadera'){
                            $('#finPedido').modal('toggle');
                            $.ajax({
                                url: 'http://${entablado.lanzadera.direccion_ip}:8080/ServidorArmarios/JSONServlet',
                                type: 'POST',
                                async: true,
                                dataType : "json",
                                json : "callback",
                                data: { orden:'LIBERAR', lanzadera:parseInt(${entablado.lanzadera.id_lanzadera}) ,
                                    entablado:parseInt(${entablado.codigo.substring(10)},10) , codigoAcesso:'${entablado.lanzadera.punto_acesso}'},
                                success:function () {
                                    if(${cerrar==1}){
                                        $.ajax({
                                            url: '/OscaArmarios/OperacionEntablado/CerrarVentana',
                                            type: 'POST',
                                            async: true,
                                            dataType : "json",
                                            json : "callback",
                                            data: { ip:'${entablado.lanzadera.direccion_ip}'},
                                            success:function () {
                                            }
                                        });
                                    }else{
                                        window.location.href="/OscaArmarios/Home.html";
                                    }

                                }
                            });
                        }else{
                            alert(data['res']);
                        }

                    },error: function(XMLHttpRequest, textStatus, errorThrown) {
                        $('#localizacionaddError').modal('toggle');
                    },beforeSend : function () {

                    }
                });
            }
            //notificacion selecionar posicion
            else{
                $('#errorSeleccionUbicacion').modal('toggle');
            }
        });





        $("#discountMaterial").click(function() {
            //añadir material
           // if($(this).css("backgroundColor") == 'rgb(221,0, 0)'){
            if(true){
                     $('#esperaSalidaMaterial').modal('toggle');
                    //marcar pedido y lanzar siguiente orden
                    $.ajax({
                        type: 'GET',
                        contentType : 'application/json; charset=utf-8',
                        url: '/OscaArmarios/Operacion/DiscountMaterialPedido',
                        //lanzadera entablado x y articulo cantidad
                        data: {
                            No:'${articuloPedido.no}',
                            Line_No:${articuloPedido.lineNo},
                            sourceNo:'${articuloPedido.sourceNo}',
                            Item_No:'${articuloPedido.itemNo}',
                            Bin_Code:'${articuloPedido.binCode}',
                            fila:fila,
                            columna:columna,
                            cantidad:${articuloPedido.qtyOutstanding},
                            cerrar:${cerrar}
                        },
                        dataType: 'json',
                        async : true,
                        success: function(data) {
                            alert(data['res']);
                            if(data['res']=='true'){
                                //liberar lanzadera
                                $.ajax({
                                    url: 'http://${entablado.lanzadera.direccion_ip}:8080/ServidorArmarios/JSONServlet',
                                    type: 'POST',
                                    async: true,
                                    dataType : "json",
                                    json : "callback",
                                    data: { orden:'LIBERAR', lanzadera:parseInt(${entablado.lanzadera.id_lanzadera}) ,
                                        entablado:parseInt(${entablado.codigo.substring(10)},10) , codigoAcesso:'${entablado.lanzadera.punto_acesso}'},
                                    success:function () {
                                        window.location.href="/OscaArmarios/SalidaArticuloPedido.html?pedido=${articuloPedido.no}&cerrar=${cerrar}";
                                    }
                                });

                            }else if(data['res']=='fin'){
                                $('#finPedido').modal('toggle');
                                $.ajax({
                                    url: 'http://${entablado.lanzadera.direccion_ip}:8080/ServidorArmarios/JSONServlet',
                                    type: 'POST',
                                    async: true,
                                    dataType : "json",
                                    json : "callback",
                                    data: { orden:'LIBERAR', lanzadera:parseInt(${entablado.lanzadera.id_lanzadera}) ,
                                        entablado:parseInt(${entablado.codigo.substring(10)},10) , codigoAcesso:'${entablado.lanzadera.punto_acesso}'},
                                    success:function () {
                                    }
                                });

                            }if(data['res']=='finLanzadera'){
                                $('#finPedido').modal('toggle');
                                $.ajax({
                                    url: 'http://${entablado.lanzadera.direccion_ip}:8080/ServidorArmarios/JSONServlet',
                                    type: 'POST',
                                    async: true,
                                    dataType : "json",
                                    json : "callback",
                                    data: { orden:'LIBERAR', lanzadera:parseInt(${entablado.lanzadera.id_lanzadera}) ,
                                        entablado:parseInt(${entablado.codigo.substring(10)},10) , codigoAcesso:'${entablado.lanzadera.punto_acesso}'},
                                    success:function () {
                                        if(${cerrar==1}){
                                            $.ajax({
                                                url: '/OscaArmarios/OperacionEntablado/CerrarVentana',
                                                type: 'POST',
                                                async: true,
                                                dataType : "json",
                                                json : "callback",
                                                data: { ip:'${entablado.lanzadera.direccion_ip}'},
                                                success:function () {
                                                }
                                            });
                                        }else{
                                            window.location.href="/OscaArmarios/Home.html";
                                        }

                                    }
                                });
                            }
                        },
                        error: function () {
                            //notificar error

                        }
                    });
                }
                //notificacion selecionar posicion
                else{
                    $('#errorSeleccionUbicacion').modal('toggle');
                }
        });

        $("#PausarPedido").click(function(){
            //tarea pedido entrada
            $.ajax({
                type: 'GET',
                contentType : 'application/json; charset=utf-8',
                url: '/OscaArmarios/Operacion/PedidoNuevaTarea',
                //lanzadera entablado x y articulo cantidad
                data: {lanzadera: ${entablado.lanzadera.id_lanzadera}, url: '/OscaArmarios/SalidaInfoPedido.html?pedido=${articuloPedido.no}' ,pedido: '${articuloPedido.no}', articulo: ${articuloPedido.itemNo}, accion: 5},
                dataType: 'json',
                async : true,
                success: function () {
                    $.ajax({
                        url: 'http://${entablado.lanzadera.direccion_ip}:8080/ServidorArmarios/JSONServlet',
                        type: 'POST',
                        async: true,
                        dataType : "json",
                        json : "callback",
                        data: { orden:'LIBERAR', lanzadera:parseInt(${entablado.lanzadera.id_lanzadera}) ,
                            entablado:parseInt(${entablado.codigo.substring(10)},10) , codigoAcesso:'${entablado.lanzadera.punto_acesso}'},
                        success:function () {
                            alert("Free");
                            window.location.href="/OscaArmarios/Home.html";
                        }
                    });

                }
            });

        });
    });
</script>
</body>
</html>