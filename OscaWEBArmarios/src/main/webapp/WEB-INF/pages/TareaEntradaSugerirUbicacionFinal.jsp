<%--
  Created by IntelliJ IDEA.
  User: Portátil1
  Date: 03/08/2017
  Time: 9:42
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
        .open>.dropdown-toggle.btn-primary {
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
                <p class="cabecera">${lanzadera.descripcion}</p>
            </a>
        </div>
        <div class="navbar-collapse collapse" id="navbar">
            <ul class="nav navbar-nav navbar-right" style="border-left: 2px solid white">
                <li class="active" style="border-right: 2px solid white">
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
                                window.location.href="/OscaArmarios/EntradaSeleccionTipoCajaSugerirUbi.html?lanzadera=${lanzadera.id_lanzadera}&articulo=${articulo.articulo}&cantidad=${cantidad}";
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
            <span class="right" style="float:right;">${entablado.descripcion}</span>
            <span class="left"  style="float:left;">ENTABLADO ${entablado.id_entablado}</span>
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
                    <td class="m-0">${articulo.articulo}</td>
                    <td>${articulo.descripcion}</td>
                    <td class="text-center">${cantidad}</td>
                </tr>
                </tbody>
            </table>
            <div id='entradaManual'>
                <h4  class="text-left">ENTRADA MANUAL</h4>
            </div>
            <div id="entradaNoConfirmada" class="form-group form-group-sm">
                <h5>
                <span class="right" style="float:right;">
                  <div id="CrearUbicacion" class="btn btn-default btn-lg" style="background:#7d7d7d;border-radius:0;color:white">CREAR UBICACIÓN</div>
                </span>
                    <span class="left"  style="float:left;">
                   <div id="traerEntablado" class="btn btn-default btn-lg" style='background:#009900;border-radius:0;color:white'>TRAER ENTABLADO</div>
                </span>
                </h5>
            </div>
            <!--itroducir cantidad-->
        </div>

    </div>
    <div id="entablado" style="background: #ffffff;background-image: url(cajas/entabladoCompleto.png ); background-size: 100% 100%; height: 50%; width: 100%;position:relative" >
        <!--dibujar posiciones-->
        <c:if test="${!empty ubicaciones}">

            <c:forEach items="${ubicaciones}" var="ubicacion">
                <c:choose>
                    <c:when test="${ubicacion.tipoCaja.id_caja==1 && ubicacion.fila==localizacionArticulo.fila && ubicacion.columna==localizacionArticulo.columna}">
                        <div  id='entradaArticulo' fila=${ubicacion.fila} fila2=${ubicacion.fila} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:6.1%;height:11.5%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==2 && ubicacion.fila==localizacionArticulo.fila && ubicacion.columna==localizacionArticulo.columna}">
                        <div  id='entradaArticulo' fila=${ubicacion.fila} fila2=${ubicacion.fila-1} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:6.1%;height:23%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==3 && ubicacion.fila==localizacionArticulo.fila && ubicacion.columna==localizacionArticulo.columna}">
                        <div id='entradaArticulo' fila=${ubicacion.fila} fila2=${ubicacion.fila-1} columna=${ubicacion.columna} columna2=${ubicacion.columna+2} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:23%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==4 && ubicacion.fila==localizacionArticulo.fila && ubicacion.columna==localizacionArticulo.columna}">
                        <div  id='entradaArticulo' fila=${ubicacion.fila}  fila2=${ubicacion.fila-3} columna=${ubicacion.columna} columna2=${ubicacion.columna+1} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:46%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==5 && ubicacion.fila==localizacionArticulo.fila && ubicacion.columna==localizacionArticulo.columna}">
                        <div id='entradaArticulo' fila=${ubicacion.fila}  fila2=${ubicacion.fila-3} columna=${ubicacion.columna} columna2=${ubicacion.columna+1} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:46%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==6 && ubicacion.fila==localizacionArticulo.fila && ubicacion.columna==localizacionArticulo.columna}">
                        <div id='entradaArticulo' fila=${ubicacion.fila}  fila2=${ubicacion.fila-3} columna=${ubicacion.columna} columna2=${ubicacion.columna+3} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:24.4%;height:46%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==7 && ubicacion.fila==localizacionArticulo.fila && ubicacion.columna==localizacionArticulo.columna}">
                        <div id='entradaArticulo' fila=${ubicacion.fila}  fila2=${ubicacion.fila-7} columna=${ubicacion.columna} columna2=${ubicacion.columna+3} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:24.4%;height:92%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==8 && ubicacion.fila==localizacionArticulo.fila && ubicacion.columna==localizacionArticulo.columna}">
                        <div id='entradaArticulo' fila=${ubicacion.fila}  fila2=${ubicacion.fila-7} columna=${ubicacion.columna} columna2=${ubicacion.columna+7} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:48.8%;height:92%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==9 && ubicacion.fila==localizacionArticulo.fila && ubicacion.columna==localizacionArticulo.columna}">
                        <div id='entradaArticulo' fila=${ubicacion.fila}  fila2=${ubicacion.fila-7} columna=${ubicacion.columna} columna2=${ubicacion.columna+15} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:97.6%;height:92%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==10 && ubicacion.fila==localizacionArticulo.fila && ubicacion.columna==localizacionArticulo.columna}">
                        <div id="subdivision2x1" fila2=${ubicacion.fila}  fila=${ubicacion.fila+3} columna=${ubicacion.columna} columna2=${ubicacion.columna+1}  class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:46%;border:2px solid black'>
                            <h2 class='desc'></h2>
                        </div>
                        <div id='entradaArticulo' fila2=${ubicacion.fila}  fila=${ubicacion.fila+2} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos+23.1}%;left:+${ubicacion.xPos}%;width:6.1%;height:23%;border:2px solid black;background:#dadada'>
                            <h2 class='desc'>${ubicacion.cantidad}</h2>
                        </div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==11 && ubicacion.fila==localizacionArticulo.fila && ubicacion.columna==localizacionArticulo.columna}">
                        <div id="subdivision1x1" fila2=${ubicacion.fila}  fila=${ubicacion.fila+3} columna=${ubicacion.columna} columna2=${ubicacion.columna+1}  class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:46%;border:2px solid black'>
                            <h2 class='desc'></h2>
                        </div>
                        <div id='entradaArticulo' fila=${ubicacion.fila}  fila2=${ubicacion.fila} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos+34.6}%;left:+${ubicacion.xPos}%;width:6.1%;height:11.5%;border:2px solid black;background:background:#dadada'>
                            <h2 class='desc'>${ubicacion.cantidad}</h2>
                        </div>
                    </c:when>




                    <c:when test="${ubicacion.tipoCaja.id_caja==1}">
                        <div  fila=${ubicacion.fila} fila2=${ubicacion.fila} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:6.1%;height:11.5%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                ${ubicacion.cantidad}</h2></div>
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
                            <h2 class='desc'></h2>
                        </div>
                        <div fila=${ubicacion.fila}  fila2=${ubicacion.fila} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos+34.6}%;left:+${ubicacion.xPos}%;width:6.1%;height:11.5%;border:2px solid black;background:#dadada'>
                            <h2 class='desc'>${ubicacion.cantidad}</h2>
                        </div>
                    </c:when>
                </c:choose>
            </c:forEach>
        </c:if>
        <c:if test="${!empty reservas}">
            <c:forEach items="${reservas}" var="reserva">
                <c:choose>
                    <c:when test="${reserva.fila==localizacionArticulo.fila && reserva.columna==localizacionArticulo.columna}">
                        <div id='entradaArticulo' tipo='medida' fila=${reserva.fila} fila2=${reserva.fila-reserva.nfilas+1} columna=${reserva.columna-reserva.ncolumnas+1} columna2=${reserva.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${reserva.yPos}%;left:+${reserva.xPos}%;width:${6.1*reserva.ncolumnas}%;height:${11.5*reserva.nfilas}%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                ${reserva.cantidad}</h2></div>
                    </c:when>
                    <c:otherwise>
                        <div  fila=${reserva.fila} fila2=${reserva.fila-reserva.nfilas+1} columna=${reserva.columna-reserva.ncolumnas+1} columna2=${reserva.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${reserva.yPos}%;left:+${reserva.xPos}%;width:${6.1*reserva.ncolumnas}%;height:${11.5*reserva.nfilas}%;border:2px solid black;background:#dadada'><h2 class='desc'>
                                ${reserva.cantidad}</h2></div>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </c:if>
        <div id="contenidoEntablado" class="container">

        </div>
    </div>
    <div class="form-group form-group-sm">
        <h5> <span class="left" style="float:left;margin-left: 0%;">
                   <div id="anteriorUicacion" class="btn btn-default btn-lg" style="background:#7d7d7d;border-radius:0;color:white; ">UBICACIÓN ANTERIOR</div>
                </span>
            <span class="right" style="float:right;  margin-right: 0%;">
             			<div id="siguienteEntablado"  class="btn btn-default btn-lg" style="background:#009900;border-radius:0;color:white;">SIGUIENTE ENTABLADO</div>
                </span>
            <span class="right" style="float:right;  margin-right: 2%;">
                  <div id="siguienteUbicacion"  class="btn btn-default btn-lg" style="background:#009900;border-radius:0;color:white;">SIGUIENTE UBICACIÓN</div>
                </span>
        </h5>
    </div>
    <!-- mostrar dialogo seleccion entablado -->
    <!--Diagolo tipo entablado -->

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
                    <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>
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
                    <h4 class="modal-title">Ubicacion añadida</h4>
                </div>
                <div class="modal-body">
                    <p>Se ha añadido una nueva ubicacion correctamente</p>
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
    <!--Diagolo tipo entablado -->
    <div id="esperarEntablado" class="modal fade" role="dialog">
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



    <script src="js/tether.min.js" type="text/javascript"></script>
    <script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="js/dataTables.bootstrap.min.js" type="text/javascript"></script>
    <script type="text/javascript">
    </script>
    <script>
        var nPosicion=0;
        var yCoord=0;
        var xCoord=0;
        var listaUbicaciones=${posiblesPosiciones};
        var fila=0;
        var columna=0;
        var modoSubdivision=false;


        $(document).ready(function() {

            if(parseInt(${TipoCaja.id_caja})==10 && ${posiblesPosicionesSubdivision!=[]}){
                listaUbicaciones=${posiblesPosicionesSubdivision};
                modoSubdivision=true;
            }
            if(parseInt(${TipoCaja.id_caja})==11 && ${posiblesPosicionesSubdivision!=[]}){
                listaUbicaciones=${posiblesPosicionesSubdivision};
                modoSubdivision=true;
            }
            actualizarUbicacionSugerida();
            if( ${nsugerencia!=0}){
                $("#anteriorUicacion").css('background-color','#00af00');
            }
        });
        $("#anteriorUicacion").click(function() {
            if(nPosicion>=1){
                nPosicion--;
                $("div[id=nuevaCaja]").remove();
                $("div[id=cajaSubdividida]").remove();
                actualizarUbicacionSugerida();

            }else if(nPosicion==0 && ${nsugerencia!=0}){
                if( modoSubdivision==false && ${posiblesPosicionesSubdivision!=[]}){
                    listaUbicaciones=${posiblesPosicionesSubdivision};
                    nPosicion=listaUbicaciones.length;
                    modoSubdivision=true;
                }
                else{
                    window.location.href = "TareaEntradaSugerirUbicacionFinal.html?articulo=" + ${articulo.articulo} + "&cantidad=" +parseInt(${cantidad}) + "&caja="
                        +  ${TipoCaja.id_caja} +"&lanzadera="+${lanzadera.id_lanzadera}+"&nsugerencia="+ ${nsugerencia-1}+"&idTarea="+${id_tarea};
                }
            }else{
                $("#anteriorUicacion").css('background-color',' #7d7d7d');
            }



        });
        $('#entablado').click(function () {
            if($("#nuevaCaja").css("border-color") == 'rgb(0, 175, 0)'){
                $("#nuevaCaja").delay(200).css("border-style",'solid');
                $('#CrearUbicacion').css('background','#009900');
            }
        });

        $("#siguienteUbicacion").click(function() {

            nPosicion++;
            if(nPosicion==1){
                $("#anteriorUicacion").css('background-color','#00af00');
            }if(listaUbicaciones.length==nPosicion && modoSubdivision){
                modoSubdivision=false;
                listaUbicaciones=${posiblesPosiciones};
                nPosicion=0;
            }else if(listaUbicaciones.length==nPosicion){
                //saltar al siguiente entablado
                window.location.href = "EntradaSugerirUbicacionFinal.html?articulo=" + ${articulo.articulo} + "&cantidad=" +parseInt(${cantidad}) + "&caja="
                    +  ${TipoCaja.id_caja} +"&lanzadera="+${lanzadera.id_lanzadera}+"&nsugerencia="+${1+nsugerencia}+"&idTarea="+${id_tarea};
            }

            $("div[id=nuevaCaja]").remove();
            $("div[id=cajaSubdividida]").remove();
            actualizarUbicacionSugerida();

        });

        $("#siguienteEntablado").click(function() {
            window.location.href = "EntradaSugerirUbicacionFinal.html?articulo=" + ${articulo.articulo} + "&cantidad=" +parseInt(${cantidad}) + "&caja="
                +  ${TipoCaja.id_caja} +"&lanzadera="+2+"&nsugerencia="+${1+nsugerencia};
        });


        $("#traerEntablado").click(function() {
            $.ajax({
                url: 'http://${lanzadera.direccion_ip}:8080/ServidorArmarios/JSONServlet',
                type: 'POST',
                async: true,
                dataType : "json",
                json : "callback",
                data: { orden:'MOVER', lanzadera:parseInt(${lanzadera.id_lanzadera}) , entablado:parseInt(${entablado.id_entablado}) , codigoAcesso:'${lanzadera.punto_acesso}'},
                beforeSend: function() {
                    $('#esperarEntablado').modal({
                        show: 'true'
                    });
                    $('#traerEntablado').css('background','#626262');
                    $('#CrearUbicacion').css('background','#009900');
                    $('#entradaArticulo').css('border','4px solid #009900');
                },
                success: function(data){
                    $('#esperarEntablado').modal('toggle');
                    var result=JSON.stringify(data);
                    alert(result);
                    if(result=== "{\"RESULT \":\"OK\"}"){
                        //TRAIDO
                        $("#traerEntablado").css("background-color","#626262");
                        Crear.msg="Correct";
                        alert("Entablado Bajado");
                    }else if(result=== "{\"RESULT \":\"TRAIDO\"}"){
                        $("#traerEntablado").css("background-color","#626262");
                        Crear.msg="Correct";
                    }else if(result=== "{\"RESULT \":\"MOVIDO\"}"){
                        $("#traerEntablado").css("background-color","#626262");
                        Crear.msg="Correct";
                    }
                },
                error: function(data)
                {
                    $('#esperarEntablado').modal('toggle');
                }
            });
        });



        //peticion añadir material

        $("#CrearUbicacion").click(function() {
            var auxCaja=${TipoCaja.id_caja};
            if(modoSubdivision && auxCaja==10)
                auxCaja=2;
            if(modoSubdivision && auxCaja==11)
                auxCaja=1;
            if($('#nuevaCaja').css('border-style') == 'solid'){
                $.ajax({
                    type: 'GET',
                    contentType : 'application/json; charset=utf-8',
                    url: '/OscaArmarios/Operacion/CrearUbicacion',
                    //lanzadera entablado x y articulo cantidad
                    data: { lanzadera:parseInt(${lanzadera.id_lanzadera}) , entablado:parseInt(${entablado.id_entablado}) ,
                        xPos:parseInt(fila) , yPos: parseInt(columna) , articulo: ${articulo.articulo} , cantidad:parseFloat(${cantidad}),
                        caja:parseInt(auxCaja) , xCoord:parseFloat(xCoord), yCoord:parseFloat(yCoord)
                    },
                    dataType: 'json',
                    async : true,
                    beforeSend: function()
                    {

                    },
                    success: function(data){
                        //mostrar unformuki sobre la entrada
                        $( "#entradaManual" ).replaceWith(" <h4  class='text-left'>ENTRADA MANUAL - MATERIAL AÑADIDO</h4>");

                        $("#entradaNoConfirmada").replaceWith("<h5><span class='right' style='float:right;'>" +
                            "<div class='btn btn-default btn-lg' style='background:#009900;border-radius:0;color:white'><a class='nav-link' href='/OscaArmarios/Home.html' style='color:white'>Volver</a></div>" +
                            "</span>" +
                            "<span class='left'  style='float:left;'>" +
                            "ENTRADA CONFIRMADA DE ${cantidad} UDS EN LA UBICACION "+ fila+" , "+ columna+"</span></h5>");
                        dibujarEntablado();
                        //borrarTarea
                        $.ajax({
                            type: 'GET',
                            contentType : 'application/json; charset=utf-8',
                            url: '/OscaArmarios/BorrarTarea',
                            //lanzadera entablado x y articulo cantidad
                            data: { idTarea:${id_tarea}},
                            dataType: 'json',
                            async : true,
                            success: function () {
                                $("#entradaNoConfirmada").replaceWith("<h5><span class='right' style='float:right;'>" +
                                    "<div class='btn btn-default btn-lg' style='background:#009900;border-radius:0;color:white'><a class='nav-link' href='/OscaArmarios/TareaSeleccionTarea.html?lanzadera=${lanzadera.id_lanzadera}' style='color:white'>Volver</a></div>" +
                                    "</span>" +
                                    "<span class='left'  style='float:left;'>" +
                                    "ENTRADA CONFIRMADA DE ${cantidad} UDS EN LA UBICACION "+ Crear.fila+" , "+ Crear.columna+"</span></h5>");
                            }
                        });


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

        function actualizarUbicacionSugerida() {
            var auxCaja=${TipoCaja.id_caja};
            if(modoSubdivision && auxCaja==10)
                auxCaja=2;
            if(modoSubdivision && auxCaja==11)
                auxCaja=1;
            switch(auxCaja){
                case 1:
                    yCoord=(83-(11.4*(parseInt(listaUbicaciones[nPosicion]['fila']))));
                    xCoord=(1.1+(6.125*(parseInt(listaUbicaciones[nPosicion]['columna']-1))));
                    fila=parseInt(listaUbicaciones[nPosicion]['fila']+1);
                    columna=parseInt(listaUbicaciones[nPosicion]['columna']);
                    $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+  yCoord+"%;left:"+ xCoord+"%;width:6.1%;height:11.5%;border:8px dashed #00af00;'><h5 class='desc'></h5></div>");
                    break;
                //2x1
                case 2:
                    yCoord=(83-(11.4*(parseInt(listaUbicaciones[nPosicion]['fila']))));
                    xCoord=(1.1+(6.125*(parseInt(listaUbicaciones[nPosicion]['columna']-1))));
                    fila=parseInt(listaUbicaciones[nPosicion]['fila']+1);
                    columna=parseInt(listaUbicaciones[nPosicion]['columna']);
                    $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+  yCoord+"%;left:"+ xCoord+"%;width:6.1%;height:23%;border:8px dashed #00af00;'><h5 class='desc'></h5></div>");
                    break;
                case 3:
                    //2x2
                    yCoord=(83-(11.4*(parseInt(listaUbicaciones[nPosicion]['fila']))));
                    xCoord=(1.1+(6.125*(parseInt(listaUbicaciones[nPosicion]['columna']))));
                    fila=parseInt(listaUbicaciones[nPosicion]['fila']+1);
                    columna=parseInt(listaUbicaciones[nPosicion]['columna']+1);
                    $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+yCoord+"%;left:"+ xCoord+"%;width:12.2%;height:23%;border:8px dashed #00af00;'><h5 class='desc'>" + "</h5></div>");
                    break;
                case 4:
                    //2x4
                    yCoord =(83-(11.4*(parseInt(listaUbicaciones[nPosicion]['fila'])+2)));
                    xCoord =(1.1+(6.125*(parseInt(listaUbicaciones[nPosicion]['columna']))));
                    fila=parseInt(listaUbicaciones[nPosicion]['fila']+3);
                    columna=parseInt(listaUbicaciones[nPosicion]['columna']+1);
                    $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+yCoord+"%;left:"+ xCoord+"%;width:12.2%;height:46%;border:8px dashed #00af00;'><h5 class='desc'>");
                    break;
                case 5:
                    //2x4 A
                    yCoord=(83-(11.4*(parseInt(listaUbicaciones[nPosicion]['fila'])+2)));
                    xCoord=(1.1+(6.125*(parseInt(listaUbicaciones[nPosicion]['columna']))));
                    fila=parseInt(listaUbicaciones[nPosicion]['fila']+3);
                    columna=parseInt(listaUbicaciones[nPosicion]['columna']+1);
                    $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+yCoord+"%;left:"+ xCoord+"%;width:12.2%;height:46%;border:8px dashed #00af00;'><h5 class='desc'>");
                    break;
                case 6:
                    //4x4
                    yCoord =(83-(11.4*(parseInt(listaUbicaciones[nPosicion]['fila'])+2)));
                    xCoord=(1.1+(6.125*(parseInt(listaUbicaciones[nPosicion]['columna']))));
                    fila=parseInt(listaUbicaciones[nPosicion]['fila']+3);
                    columna=parseInt(listaUbicaciones[nPosicion]['columna']+1);
                    $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+yCoord+"%;left:"+ xCoord+"%;width:24.4%;height:46%;border:8px dashed #00af00;'><h5 class='desc'>" +
                        "</h5></div>");
                    break;
                case 7:
                    //4x8
                    yCoord=(83-(11.4*(parseInt(listaUbicaciones[nPosicion]['fila'])+6)));
                    xCoord=(1.1+(6.125*(parseInt(listaUbicaciones[nPosicion]['columna']))));
                    fila=parseInt(listaUbicaciones[nPosicion]['fila']+7);
                    columna=parseInt(listaUbicaciones[nPosicion]['columna']+1);
                    $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+yCoord+"%;left:"+ xCoord+"%;width:24.4%;height:92%;border:8px dashed #00af00;'><h5 class='desc'>" +
                        "</h5></div>");
                    break;
                //medio entablado
                case 8:
                    yCoord=(83-(11.4*(parseInt(listaUbicaciones[nPosicion]['fila'])+6)));
                    xCoord=(1.1+(6.125*(parseInt(listaUbicaciones[nPosicion]['columna']))));
                    fila=parseInt(listaUbicaciones[nPosicion]['fila']+7);
                    columna=parseInt(listaUbicaciones[nPosicion]['columna']+1);
                    $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+yCoord+"%;left:"+ xCoord+"%;width:48.8%;height:92%;border:8px dashed #00af00'><h5 class='desc'></h5></div>");
                    break;
                //entablado completo
                case 9:
                    yCoord=(83-(11.4*(parseInt(listaUbicaciones[nPosicion]['fila'])+6)));
                    xCoord=(1.1+(6.125*(parseInt(listaUbicaciones[nPosicion]['columna']))));
                    fila=parseInt(listaUbicaciones[nPosicion]['fila']+7);
                    columna=parseInt(listaUbicaciones[nPosicion]['columna']+1);
                    $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+yCoord+"%;left:"+ xCoord+"%;width:97.6%;height:92%;border:8px dashed #00af00'><h5 class='desc'></h5></div>");
                    break;
                //1x2_2x4
                case 10:
                    yCoord=(83-(11.4*(parseInt(listaUbicaciones[nPosicion]['fila'])+2)));
                    xCoord=(1.1+(6.125*(parseInt(listaUbicaciones[nPosicion]['columna']))));
                    var yCoord2=(83-(11.4*(parseInt(listaUbicaciones[nPosicion]['fila']))));
                    var xCoord2=(1.1+(6.125*(parseInt(listaUbicaciones[nPosicion]['columna']))));

                    fila=parseInt(listaUbicaciones[nPosicion]['fila']);
                    columna=parseInt(listaUbicaciones[nPosicion]['columna']+1);
                    $("#contenidoEntablado").after("<div  id='cajaSubdividida' class='wrap' style='margin-left:0.2%;top:"+yCoord+"%;left:"+ xCoord+"%;width:12.2%;height:46%;border:8px dashed #00af00;'><h5 class='desc'></h5></div>" +
                        "<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+yCoord2+"%;left:"+ xCoord2+"%;width:6.1%;height:23%;border:8px dashed #00af00;'><h5 class='desc'></h5></div>");
                    break;
                //1x1_2x4
                case 11:
                    yCoord=(83-(11.4*(parseInt(listaUbicaciones[nPosicion]['fila'])+2)));
                    xCoord=(1.1+(6.125*(parseInt(listaUbicaciones[nPosicion]['columna']))));

                    var yCoord2=(83-(11.4*(parseInt(listaUbicaciones[nPosicion]['fila']-1))));
                    var xCoord2=(1.1+(6.125*(parseInt(listaUbicaciones[nPosicion]['columna']))));

                    fila=parseInt(listaUbicaciones[nPosicion]['fila']);
                    columna=parseInt(listaUbicaciones[nPosicion]['columna']+1);
                    $("#contenidoEntablado").after("<div id='cajaSubdividida' class='wrap' style='margin-left:0.2%;top:"+yCoord+"%;left:"+ xCoord+"%;width:12.2%;height:46%;border:8px dashed #00af00;'><h5 class='desc'></h5></div>" +
                        "<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+yCoord2+"%;left:"+ xCoord2+"%;width:6.1%;height:11.5%;border:8px dashed #00af00;'><h5 class='desc'></h5></div>");
                    break;
            }
        }
        function dibujarEntablado() {
            var auxCaja=${TipoCaja.id_caja};
            if(modoSubdivision && auxCaja==10)
                auxCaja=2;
            if(modoSubdivision && auxCaja==11)
                auxCaja=1;
            switch(auxCaja){
                case 1:
                    $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+  yCoord+"%;left:"+ xCoord+"%;width:6.1%;height:11.5%;background: #00af00;'><h5 class='desc'><font color='#fdfcfc'>${cantidad}</font></h5>");
                    break;
                case 2:
                    $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+  yCoord+"%;left:"+ xCoord+"%;width:6.1%;height:23%;background: #00af00;'><h5 class='desc'><font color='#fdfcfc'>${cantidad}</font></h5>");
                    break;
                case 3:
                    //2x2
                    $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+yCoord+"%;left:"+ xCoord+"%;width:12.2%;height:23%;background: #00af00;'><h5 class='desc'><font color='#fdfcfc'>${cantidad}</font></h5>");
                    break;
                case 4:
                    //2x4
                    $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+yCoord+"%;left:"+ xCoord+"%;width:12.2%;height:46%;background: #00af00;'><h5 class='desc'><font color='#fdfcfc'>${cantidad}</font></h5>");
                    break;
                case 5:
                    //2x4 A
                    $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+yCoord+"%;left:"+ xCoord+"%;width:12.2%;height:46%;background: #00af00;'><h5 class='desc'><font color='#fdfcfc'>${cantidad}</font></h5>");
                    break;
                case 6:
                    //4x4
                    $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+yCoord+"%;left:"+ xCoord+"%;width:24.4%;height:46%;background: #00af00;'><h5 class='desc'><font color='#fdfcfc'>${cantidad}</font></h5></div>");
                    break;
                case 7:
                    //4x8
                    $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+yCoord+"%;left:"+ xCoord+"%;width:24.4%;height:92%;background: #00af00;'><h5 class='desc'><font color='#fdfcfc'>${cantidad}</font></h5></div>");
                    break;
                //medio entablado
                case 8:
                    $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+yCoord+"%;left:"+ xCoord+"%;width:48.8%;height:92%;background: #00af00;'><h5 class='desc'><font color='#fdfcfc'>${cantidad}</font></h5></div>");
                    break;
                //entablado completo
                case 9:
                    $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+yCoord+"%;left:"+ xCoord+"%;width:97.6%;height:92%;background: #00af00;'><h5 class='desc'><font color='#fdfcfc'>${cantidad}</font></h5></div>");
                    break;
                case 10:
                    $("#contenidoEntablado").after("<div class='wrap' style='margin-left:0.2%;top:"+yCoord+"%;left:"+ xCoord+"%;width:12.2%;height:46%;background: #00af00;'><h5 class='desc'></h5></div>" +
                        "<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+yCoord+"%;left:"+ xCoord+"%;width:6.1%;height:23%;;background: #00af00;'><h5 class='desc'><font color='#fdfcfc'>${cantidad}</font></h5></div>");
                    break;
                case 11:
                    $("#contenidoEntablado").after("<div class='wrap' style='margin-left:0.2%;top:"+yCoord+"%;left:"+ xCoord+"%;width:12.2%;height:46%;background: #00af00;'><h5 class='desc'></h5></div>" +
                        "<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+yCoord+"%;left:"+ xCoord+"%;width:6.1%;height:11.5%;background: #00af00;'><h5 class='desc'><font color='#fdfcfc'>${cantidad}</font></h5></div>");
                    break;
            }
        }
    </script>
</body>

</html>