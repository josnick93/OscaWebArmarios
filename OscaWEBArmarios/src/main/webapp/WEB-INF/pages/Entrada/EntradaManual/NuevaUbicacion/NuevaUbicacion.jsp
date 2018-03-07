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
    <script src="js/jquery.numpad.js"></script>
    <link rel="stylesheet" href="css/jquery.numpad.css">
    <!--<link rel="import" href="pages/Notificaciones.html">-->
    <style>
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
                <li class="active acessosHome" style="border-right: 2px solid white">
                    <a href="/OscaArmarios/EntradaMaterialHome.html">
                        <p class="cabecera text-center">&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon glyphicon-save"></span>&nbsp;&nbsp;Entrada&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                    </a>
                </li>
                <li class="acessosHome" style="border-right: 2px solid white" >
                    <a href="/OscaArmarios/ConsultaMaterialHome.html">
                        <p class="cabecera text-center">&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon glyphicon-search"></span>&nbsp;&nbsp;Consulta&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                    </a>
                </li>
                <li class="acessosHome" style="border-right: 2px solid white">
                    <a href="/OscaArmarios/SalidaMaterialHome.html">
                        <p class="cabecera text-center ">&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon glyphicon-open"></span>&nbsp;&nbsp;Salida&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                    </a>
                </li>
                <li class="text-center"> </li>
                <li class="text-center">
                    <button class="btn btn-default" onclick="goBack()" style="margin:5px;margin-left:5px;height:60px">
                        <script>
                            function goBack() {
                                    window.location.href="/OscaArmarios/EntradaSeleccionTipoCajaNuevaUbi.html?lanzadera=${entablado.lanzadera.id_lanzadera}&articulo=${articulo.no}&cantidad=${cantidad}&origen=${origen}";
                            }
                        </script>
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
                        <font color="#fdfcfc">ALIAS</font>
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
                    <td class="m-0">${articulo.no}</td>
                    <td class="m-0">${articulo.searchDescription}</td>
                    <td>${articulo.description}</td>
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
                  <div id="addMaterial" class="btn btn-default btn-lg" style="background:#7d7d7d;border-radius:0;color:white">AÑADIR MATERIAL</div>
                </span>
                    <span class="left"  style="float:left;">
                   <div id="traerEntablado" class="btn btn-default btn-lg" style='background:#009900;border-radius:0;color:white'>EXTRAER ENTABLADO</div>
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
                    <c:when test="${ubicacion.tipoCaja.id_caja==1}">
                        <div  fila=${ubicacion.fila} fila2=${ubicacion.fila} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:6.1%;height:11.5%;border:2px solid black;background:#dadada'><h4 class='desc'>
                                ${ubicacion.cantidad}</h4></div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==2}">
                        <div  fila=${ubicacion.fila} fila2=${ubicacion.fila-1} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:6.1%;height:23%;border:2px solid black;background:#dadada'><h4 class='desc'>
                                ${ubicacion.cantidad}</h4></div>
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
                        </div>
                        <div fila2=${ubicacion.fila}  fila=${ubicacion.fila+2} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos+23.1}%;left:+${ubicacion.xPos}%;width:6.1%;height:23%;border:2px solid black;background:#dadada'>
                            <h4 class='desc'>${ubicacion.cantidad}</h4>
                        </div>
                    </c:when>
                    <c:when test="${ubicacion.tipoCaja.id_caja==11}">
                        <div id="subdivision1x1" fila2=${ubicacion.fila}  fila=${ubicacion.fila+3} columna=${ubicacion.columna} columna2=${ubicacion.columna+1}  class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos}%;left:+${ubicacion.xPos}%;width:12.2%;height:46%;border:2px solid black'>
                        </div>
                        <div fila=${ubicacion.fila}  fila2=${ubicacion.fila} columna=${ubicacion.columna} columna2=${ubicacion.columna} class="wrap cajaOcupada" style='margin-left:0.2%;top:${ubicacion.yPos+34.6}%;left:+${ubicacion.xPos}%;width:6.1%;height:11.5%;border:2px solid black;background:#dadada'>
                            <h4 class='desc'>${ubicacion.cantidad}</h4>
                        </div>
                    </c:when>
                </c:choose>
            </c:forEach>
        </c:if>
        <!--reservas-->
        <c:if test="${!empty reservas}">
            <c:forEach items="${reservas}" var="reserva">
                <div  fila=${reserva.fila} fila2=${reserva.fila-reserva.nfilas+1} columna=${reserva.columna} columna2=${reserva.columna+reserva.ncolumnas-1} class="wrap cajaOcupada" style='margin-left:0.2%;top:${reserva.yPos}%;left:+${reserva.xPos}%;width:${6.1*reserva.ncolumnas}%;height:${11.5*reserva.nfilas}%;border:2px solid black;background:#dadada'><h2 class='desc'>
                        ${reserva.cantidad}</h2></div>
            </c:forEach>
        </c:if>
        <div id="contenidoEntablado" class="container">
        </div>
    </div>
    <div class="form-group form-group-sm">
        <h5>
            <span class="right" style="float:right;  margin-right: 0%;">
             			<div id="siguienteEntablado"  class="btn btn-default btn-lg" style="background:#009900;border-radius:0;color:white;">SIGUIENTE ENTABLADO</div>
                </span>
            <span class="right" style="float:right;  margin-right: 2%;">
                  <div id="cambiarEntablado"  class="btn btn-default btn-lg" style="background:#009900;border-radius:0;color:white;">CAMBIAR ENTABLADO</div>
                </span>
        </h5>
    </div>
</div>
<!-- mostrar dialogo seleccion entablado -->
<!--Diagolo tipo entablado -->
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
<div id="esperarañadirMaterial" class="modal fade"  role="dialog" data-backdrop="static" data-keyboard="false"role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title">Añadiendo material , por favor espere...</h4>
            </div>
            <div class="modal-body"> <strong>Instrucciones:</strong>
                <p/>
                <p>1- Espere a que se acabe de añadir el material</p>
                <p>2- La lanzadera se liberará para su uso remoto</p>
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
                <button type="button" class="btn btn-primary" style="float: right;background:#009900;color: white;" data-dismiss="modal">CERRAR</button>
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
                <button type="button" class="btn btn-primary" data-dismiss="modal">CERRAR</button>
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
                <h4 class="modal-title">Servicio Wen NAVision</h4>
            </div>
            <div class="modal-body">
                <p id="Errormsg"></p>
            </div>
            <div class="modal-footer"> <a class="btn btn-primary" href="#errorNav" style="margin-right: auto; margin-left: auto; width: 300px;background:#009900" data-dismiss="modal">Cerrar</a> </div>
        </div>
    </div>
</div>
<!--Diagolo tipo entablado -->
<div id="dialogoSeleccionEntablado" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Seleccionar entablado</h4>
            </div>
            <div class="modal-body">
                <form class="text-left">
                    <h3>Seleccionar Entablado&nbsp;&nbsp;&nbsp;
                        <input id="text-basic" type="number" style="font-size:25px;width:150px;text-align:right; " name="fname"> </h3>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-lg outline px-3 mx-3" style="float: right;background:#009900;color: white;" data-dismiss="modal">CERRAR</button>
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
                <button type="button" class="btn btn-primary btn-lg outline px-3 mx-3" style="float: right;background:#009900;color: white;" data-dismiss="modal">
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
<script src="js/jquery.numpad.js"></script>
<script  type="text/javascript">
    // Set NumPad defaults for jQuery mobile.
    // These defaults will be applied to all NumPads within this document!
    $.fn.numpad.defaults.gridTpl = '<table class="table modal-content"></table>';
    $.fn.numpad.defaults.backgroundTpl = '<div class="modal-backdrop in"></div>';
    $.fn.numpad.defaults.displayTpl = '<input type="text" class="form-control" />';
    $.fn.numpad.defaults.buttonNumberTpl =  '<button type="button" class="btn btn-default " style="width: 100%;"></button>';
    $.fn.numpad.defaults.buttonFunctionTpl = '<button type="button" class="btn" style="width: 100%;"></button>';
    $.fn.numpad.defaults.onKeypadCreate = function(){$(this).find('.done').addClass('btn-primary').css('background','#626262');};

    function Posicion () { // constructor function
        this.fila=0;
        this.columna=0;
        this.xCoord=0.0;
        this.yCoord=0.0;
        this.subdivision=false;
        this.insertarSubdivision=false;
        this.msg="${entabladoCorrecto}";

        this.privilegedMethod = function () {  // Public Method
            alert(privateVariable);
        };
    }
    var Crear = new Posicion();
    $(document).ready(function() {

        if(${empty lanzadera}){
            $('#dialogoPermisosLanzadera').modal('toggle');
        }

        $('#text-basic').numpad();
        if(${cerrar==1}){
            $('.acessosHome').each(function(i, obj) {
                $(this).hide();
            });
        }



        $("#traerEntablado").click(function() {

            if(${empty lanzadera}){
                $('#dialogoPermisosLanzadera').modal('toggle');
            }else{
                $("#traerEntablado").css("background-color","#626262");
                Crear.msg="Correct";
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
                        else if (data['RESULT '] == 'DENEGADO') {
                            $('#traerEntablado').addClass('hidden');
                            $('#dialogoAcessoRemotoDenegado').modal('toggle');
                            alert("Acceso denegado");
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
            }
        });

        $("#siguienteEntablado").click(function() {
            window.location.href = "EntradaSeleccionNuevaUbicacionFinal.html?articulo=${articulo.no}&cantidad=" +parseInt(${cantidad}) + "&caja="
                +  ${caja.id_caja} +"&entablado=PLNZ."+("00" + ${entablado.lanzadera.id_lanzadera}).slice(-2)+"."+("0000" + (parseInt('${entablado.codigo}'.split(".")[2])+1)).slice(-4)+"&origen=${origen}";
        });

        $(document).on('click', '.done', function () {
            window.location.href = "EntradaSeleccionNuevaUbicacionFinal.html?articulo=${articulo.no}&cantidad=" +parseInt(${cantidad}) + "&caja="+
                ${caja.id_caja} +"&entablado=PLNZ."+("00" + ${entablado.lanzadera.id_lanzadera}).slice(-2)+"."+("0000" + $('#text-basic').val()).slice(-4)+"&origen=${origen}";
        });

        $("#cambiarEntablado").click(function(){
            $('#dialogoSeleccionEntablado').modal('toggle');
            // window.location.href = "EntradaEntablado.html?articulo=" + 550030003 + "&cantidad=" +27 + "&caja="+  tipoUbicacion.tipoCaja;
        });

        $(".backwindow").click(function(){
            if(${cerrar==1})
            {
                open(location, '_self').close();
            }else{
                window.location.href="/OscaArmarios/Home.html";
            }
        });
        $("table tr td").click(function() {

            var id = this.id;
            if(id == 'huecolibre'){
                $("table tr td").each(function() {
                    if(this.id=='huecolibre')$(this).css('backgroundColor', 'gray');

                });

                if(Crear.msg=="Traer"){
                    $('#traerEntabladoError').modal({
                        show: 'true'
                    });
                }
                else {
                    $(this).css('backgroundColor', '#06A90B');
                    Crear.fila=parseInt($(this).attr("x-pos"));
                    Crear.columna=parseInt($(this).attr("y-pos"));
                    Crear.msg="Correct";
                }
            }
        });
        //peticion añadir material
        $("#addMaterial").click(function() {
            if(Crear.msg=="Correct"){
                var TipoCaja=${caja.id_caja};
                //insertar caja 1x2
                if(TipoCaja==10 && Crear.insertarSubdivision)
                    TipoCaja=2;
                else if(TipoCaja==11 && Crear.insertarSubdivision)
                    TipoCaja=1;
                $.ajax({
                    type: 'GET',
                    contentType : 'application/json; charset=utf-8',
                    url: '/OscaArmarios/Operacion/NuevaUbicacion',
                    //lanzadera entablado x y articulo cantidad
                    data: {entablado:'${entablado.codigo}' ,
                        xPos:Crear.columna , yPos: Crear.fila , articulo:'${articulo.no}' , cantidad:parseFloat(${cantidad}),
                        caja:TipoCaja ,xCoord:Crear.xCoord , yCoord:Crear.yCoord  , origen:'${origen}'},
                    dataType: 'json',
                    async : true,
                    beforeSend: function()
                    {
                        $('#esperarañadirMaterial').modal({
                            show: 'true'
                        });

                    },
                    success: function(data){
                        $('#esperarañadirMaterial').modal("toggle");441
                        //dibujar posicion como introducida
                        $("div[id=nuevaCaja]").remove();
                        switch(TipoCaja){
                            case 1:
                                $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+  Crear.yCoord+"%;left:"+ Crear.xCoord+"%;width:6.1%;height:11.5%;border:8px solid #00af00;background:#00af00'><h2 class='desc'></h2></div>");
                                break;
                            case 2:
                                $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+  Crear.yCoord+"%;left:"+ Crear.xCoord+"%;width:6.1%;height:23%;border:8px solid #00af00;background:#00af00'><h2 class='desc'></h2></div>");
                                break;
                            case 3:
                                //2x2
                                $("#contenidoEntablado").after("<div class='wrap' style='margin-left:0.2%;top:"+(83-(11.4*(Crear.columna-1)))+"%;left:"+(1.1+(6.125*(Crear.fila-1)))+"%;width:12.2%;height:23%;border:2px solid black;background:#00af00'><h2 class='desc'><font color='#fdfcfc'>${cantidad}</font></h2></div>");
                                break;
                            case 4:
                                //2x4
                                $("#contenidoEntablado").after("<div class='wrap' style='margin-left:0.2%;top:"+(83-(11.4*(Crear.columna-1)))+"%;left:"+(1.1+(6.125*(Crear.fila-1)))+"%;width:12.2%;height:46%;border:2px solid black;background:#00af00'><h2 class='desc'>" +
                                    "<font color='#fdfcfc'>${cantidad}</font></h2></div>");
                                break;
                            case 5:
                                //2x4 A
                                $("#contenidoEntablado").after("<div class='wrap' style='margin-left:0.2%;top:"+(83-(11.4*(Crear.columna-1)))+"%;left:"+(1.1+(6.125*(Crear.fila-1)))+"%;width:12.2%;height:46%;border:2px solid black;background:#00af00'><h2 class='desc'>" +
                                    "<font color='#fdfcfc'>${cantidad}</font></h2></div>");
                                break;
                            case 6:
                                //4x4
                                $("#contenidoEntablado").after("<div class='wrap' style='margin-left:0.2%;top:"+(83-(11.4*(Crear.columna-1)))+"%;left:"+(1.1+(6.125*(Crear.fila-1)))+"%;width:24.4%;height:46%;border:2px solid black;background:#00af00'><h2 class='desc'>" +
                                    "<font color='#fdfcfc'>${cantidad}</font></h2></div>");
                                break;
                            case 7:
                                //4x8
                                $("#contenidoEntablado").after("<div class='wrap' style='margin-left:0.2%;top:"+(83-(11.4*(Crear.columna-1)))+"%;left:"+(1.1+(6.125*(Crear.fila-1)))+"%;width:24.4%;height:92%;border:2px solid black;background:#00af00'><h2 class='desc'>" +
                                    "<font color='#fdfcfc'>${cantidad}</font></h2></div>");
                                break;
                            //medio entablado
                            case 8:
                                $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+ Crear.yCoord+"%;left:"+Crear.xCoord+"%;width:48.8%;height:92%;border:8px solid #00af00;background:#00af00'><h2 class='desc'></h2></div>");
                                break;
                            //entablado completo
                            case 9:
                                $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+ Crear.yCoord+"%;left:"+Crear.xCoord+"%;width:97.6%;height:92%;border:8px solid #00af00;background:#00af00'><h2 class='desc'></h2></div>");
                                break;
                            case 10:
                                $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+Crear.yCoord+"%;left:"+ Crear.xCoord+"%;width:12.2%;height:46%;border:8px solid #00af00;'><h2 class='desc'></h2></div>" +
                                    "<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+((Crear.yCoord)+23.1)+"%;left:"+ Crear.xCoord+"%;width:6.1%;height:23%;border:8px solid #00af00;background:#00af00'><h2 class='desc'></h2></div>");
                                break;
                            case 11:
                                $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+Crear.yCoord+"%;left:"+ Crear.xCoord+"%;width:12.2%;height:46%;border:8px solid #00af00;'><h2 class='desc'></h2></div>" +
                                    "<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+((Crear.yCoord)+34.6)+"%;left:"+ Crear.xCoord+"%;width:6.1%;height:11.5%;border:8px solid #00af00;background:#00af00'><h2 class='desc'></h2></div>");
                                break;
                        }
                        Crear.msg="fin";
                        //mostrar unformuki sobre la entrada
                        $( "#entradaManual" ).replaceWith(" <h4  class='text-left'>ENTRADA MANUAL - UBICACIÓN CONFIRMADA</h4>");

                        $("#entradaNoConfirmada").replaceWith("<h5><span class='right' style='float:right;'>" +
//                            "<div class='btn btn-default btn-lg' style='background:#009900;border-radius:0;color:white'><a class='nav-link' href='/OscaArmarios/Home.html' style='color:white'>Volver</a></div>" +
                            "<div class='btn btn-default btn-lg' style='background:#009900;border-radius:0;color:white'><a class='nav-link' href='/OscaArmarios/Home.html' style='color:white'>Volver</a></div>" +                           "</span>" +
                            "<span class='left'  style='float:left;'>" +
                            "ENTRADA CONFIRMADA DE ${cantidad} UDS EN LA UBICACION "+ Crear.fila+" , "+ Crear.columna+"</span></h5>");
                    },
                    error: function(data)
                    {
                        $("#Errormsg").text(data['responseText']);
                        $('#esperarañadirMaterial').modal('toggle');
                        $('#errorNav').modal('toggle');

                    }
                });
            }else{
                $('#localizacionaddError').modal({
                    show: 'true'
                });
            }
        });



        function getXY(evt, element) {
            var element = document.getElementById("entablado");
            var rect = element.getBoundingClientRect();
            var scrollTop = document.documentElement.scrollTop?
                document.documentElement.scrollTop:document.body.scrollTop;
            var scrollLeft = document.documentElement.scrollLeft?
                document.documentElement.scrollLeft:document.body.scrollLeft;
            var elementLeft = rect.left+scrollLeft;
            var elementTop = rect.top+scrollTop;

            x = evt.pageX-elementLeft;
            y = evt.pageY-elementTop;

            return {x:x, y:y};
        }

        $('div[id=subdivision2x1]').click(function(e){
            if(Crear.msg=="fin"){
                return;
            }
            if(Crear.msg!="Correct"){
                $('#traerEntabladoError').modal({
                    show: 'true'
                });
                return;
            }
            if(${caja.id_caja==10}){
                var m=getXY(e, $('#entablado'));
                var xp=(m.x/$('#entablado').width())*100;
                var yp=(m.y/$('#entablado').height())*100; //11.5
                var x=(parseInt((xp-1.1)/6.125)+1);
                var y=(8-parseInt((yp-3)/11.5));
                if(y%2==0) {

                    $("div[id=nuevaCaja]").remove();
                    Crear.yCoord=(83-(11.4*(y-1)));
                    Crear.xCoord=(1.1+(6.125*(x-1)));
                    Crear.fila=x;
                    Crear.columna=y;
                }else{
                    $("div[id=nuevaCaja]").remove();
                    Crear.yCoord=(83-(11.4*(y)));
                    Crear.xCoord=(1.1+(6.125*(x-1)));
                    Crear.fila=x;
                    Crear.columna=y+1;
                }
                Crear.subdivision=true;
                Crear.insertarSubdivision=true;
                $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+  Crear.yCoord+"%;left:"+ Crear.xCoord+"%;width:6.1%;height:23%;border:8px solid #00af00;'><h5 class='desc'></h5></div>");
            }
            else{
                alert("la subdivision contiene cajas de 2x1");
            }
        });


        $('div[id=subdivision1x1]').click(function(e){
            if(Crear.msg=="fin"){
                return;
            }
            if(Crear.msg!="Correct"){
                $('#traerEntabladoError').modal({
                    show: 'true'
                });
                return;
            }

            if(${caja.id_caja==11}){
                var m=getXY(e, $('#entablado'));
                var xp=(m.x/$('#entablado').width())*100;
                var yp=(m.y/$('#entablado').height())*100; //11.5
                var x=(parseInt((xp-1.1)/6.125)+1);
                var y=(8-parseInt((yp-3)/11.5));
                $("div[id=nuevaCaja]").remove();
                Crear.yCoord=(83-(11.4*(y-1)));
                Crear.xCoord=(1.1+(6.125*(x-1)));
                Crear.fila=x;
                Crear.columna=y;
                Crear.subdivision=true;
                Crear.insertarSubdivision=true;
                $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:"+  Crear.yCoord+"%;left:"+ Crear.xCoord+"%;width:6.1%;height:11.5%;border:8px solid #00af00;'><h5 class='desc'></h5></div>");
            }
            else{
                alert("la subdivision contiene cajas de 1x1");
            }
        });

        //introduce una caja en el entablado
        $('#entablado').click(function(e){
            if(Crear.msg=="fin"){
                return;
            }
            if(Crear.msg!="Correct"){
                $('#traerEntabladoError').modal({
                    show: 'true'
                });
                return;
            }
            var m=getXY(e, this);
            var xp=(m.x/$('#entablado').width())*100;
            var yp=(m.y/$('#entablado').height())*100; //11.5
            if(xp>1.1 && xp < 98.5 && yp>2.8 && yp < 94.94 &&   !Crear.subdivision){
                Crear.insertarSubdivision=false;
                var x=(parseInt((xp-1.1)/6.125)+1);
                var y=(8-parseInt((yp-3)/11.5));
                var esLibre=true;
                switch(${caja.id_caja}){
                    // 2 x 4
                    case 4:
                        if(x%2!=0){
                            if(y%4==0){
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y-1)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y;
                            }else if(y%2==0){
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y+1)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y+2;
                            }
                            else if(y%3==0 || y%7==0){
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y+1;
                            }else{
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y+2)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y+3;
                            }

                            $('.cajaOcupada').each(function(){
                                if(Math.max($(this).attr('columna'),Crear.fila) < Math.min($(this).attr('columna2'),(Crear.fila + 1)) &&
                                    Math.max($(this).attr('fila2'),(Crear.columna - 3) ) < Math.min($(this).attr('fila'),Crear.columna))
                                    esLibre=false;
                            });
                            if(esLibre) {
                                $('#addMaterial').css('background','#009900');
                                $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:" + Crear.yCoord + "%;left:" + Crear.xCoord + "%;width:12.2%;height:46%;border:8px solid #00af00;><h5 class='desc'></h5></div>");
                            }
                        }else
                            alert("No se puede poner una caja 2x4 en una posicion par");
                        break;
                    // 2 x 4 A
                    case 5:
                        if(x%2!=0){
                            if(y%4==0){
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y-1)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y;
                            }else if(y%2==0){
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y+1)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y+2;

                            }
                            else if(y%3==0 || y%7==0){
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y+1;
                            }else{
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y+2)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y+3;
                            }
                            $('.cajaOcupada').each(function(){
                                if(Math.max($(this).attr('columna'),Crear.fila) < Math.min($(this).attr('columna2'),(Crear.fila + 1)) &&
                                    Math.max($(this).attr('fila2'),(Crear.columna - 3) ) < Math.min($(this).attr('fila'),Crear.columna))
                                    esLibre=false;
                            });
                            if(esLibre) {
                                $('#addMaterial').css('background','#009900');
                                $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:" + Crear.yCoord + "%;left:" + Crear.xCoord + "%;width:12.2%;height:46%;border:8px solid #00af00;><h5 class='desc'></h5></div>");
                            }
                        }else
                            alert("No se puede poner una caja 2x4 en una posicion par");
                        break;
                    //2x2
                    case 3:
                        if(x%2!=0){
                            if(y%2!=0) {
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y+1;
                            }
                            else {
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y-1)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y;
                            }
                        }else{
                            alert("No se puede poner una caja 2x2 en una posicion par");
                        }
                        //Insertar caja
                        $('.cajaOcupada').each(function(){
                            if(Math.max($(this).attr('columna'),Crear.fila) < Math.min($(this).attr('columna2'),(Crear.fila + 1)) &&
                                Math.max($(this).attr('fila2'),(Crear.columna - 1) ) < Math.min($(this).attr('fila'),Crear.columna))
                                esLibre=false;
                        });
                        if(esLibre) {
                            $('#addMaterial').css('background','#009900');
                            $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:" + Crear.yCoord + "%;left:" + Crear.xCoord + "%;width:12.2%;height:23%;border:8px solid #00af00;><h5 class='desc'></h5></div>");
                        }
                        break;
                    // 4 x 4
                    case 6:
                        if(x%2!=0 && x <= 13){
                            if(y%4==0){
                                $( "#nuevaCaja" ).remove();
                                Crear.yCoord=(83-(11.4*(y-1)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y;
                            }else if(y%2==0){
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y+1)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y+2;
                            }
                            else if(y%3==0 || y%7==0){
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y+1;
                            }else{
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y+2)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y+3;
                            }
                        }
                        else if(x > 13){
                            alert("La caja 4x4 no cabe en el entablado.");
                        }else{
                            alert("No se puede poner una caja 4x4 en una posicion par.");
                        }
                        //insertar caja
                        $('.cajaOcupada').each(function(){
                            if(Math.max($(this).attr('columna'),Crear.fila) < Math.min($(this).attr('columna2'),(Crear.fila + 3)) &&
                                Math.max($(this).attr('fila2'),(Crear.columna - 3) ) < Math.min($(this).attr('fila'),Crear.columna))
                                esLibre=false;
                        });
                        if(esLibre) {
                            $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:" + Crear.yCoord + "%;left:" + Crear.xCoord + "%;width:24.4%;height:46%;border:8px solid #00af00;><h5 class='desc'></h5></div>");
                            $('#addMaterial').css('background','#009900');
                        }
                        break;
                    // 4 x 8
                    case 7:
                        if(x%2!=0 && x <= 13){
                            if(y==8){
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y-1)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y;
                            }else if(y==7){
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y+1;
                            }else if(y==6){
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y+1)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y+2;
                            }else if(y==5){
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y+2)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y+3;
                            }else if(y==4){
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y+3)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y+4;
                            }else if(y==3){
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y+4)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y+5;
                            }else if(y==2) {
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y+5)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila = x;
                                Crear.columna = y+6;
                            }else{
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y+6)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y+7;
                            }
                        }
                        else if(x > 13){
                            alert("La caja 4x8 no cabe en el entablado.");
                        }else{
                            alert("No se puede poner una caja 4x8 en una posicion par.");
                        }
                        $('.cajaOcupada').each(function(){
                            if(Math.max($(this).attr('columna'),Crear.fila) < Math.min($(this).attr('columna2'),(Crear.fila + 3)) &&
                                Math.max($(this).attr('fila2'),(Crear.columna - 7) ) < Math.min($(this).attr('fila'),Crear.columna))
                                esLibre=false;
                        });
                        if(esLibre) {
                            $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:" + Crear.yCoord + "%;left:" + Crear.xCoord + "%;width:24.4%;height:92%;border:8px solid #00af00;><h5 class='desc'></h5></div>");
                            $('#addMaterial').css('background','#009900');
                        }
                        break;

                    //medio entablado
                    case 8:
                        //mitad izquierda
                        if(x<=8){
                            Crear.yCoord=(83-(11.4*(8-1)));
                            Crear.xCoord=(1.1+(6.125*(0)));
                            Crear.fila=1;
                            Crear.columna=8;
                            $("div[id=nuevaCaja]").remove();
                        }
                        //mitad derecha
                        else{
                            Crear.yCoord=(83-(11.4*(8-1)));
                            Crear.xCoord=(1.1+(6.125*(9-1)));
                            Crear.fila=9;
                            Crear.columna=8;
                            $("div[id=nuevaCaja]").remove();
                        }
                        $('.cajaOcupada').each(function(){
                            if(Math.max($(this).attr('columna'),Crear.fila) < Math.min($(this).attr('columna2'),(Crear.fila + 7)) &&
                                Math.max($(this).attr('fila2'),(Crear.columna - 7) ) < Math.min($(this).attr('fila'),Crear.columna))
                                esLibre=false;
                        });
                        if(esLibre) {
                            $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:" + Crear.yCoord + "%;left:" + Crear.xCoord + "%;width:48.8%;height:92%;border:8px solid #00af00;><h5 class='desc'></h5></div>");
                            $('#addMaterial').css('background','#009900');
                        }
                        break;
                    //entablado completo
                    case 9:
                        Crear.fila=7;
                        Crear.columna=1;
                        $("div[id=nuevaCaja]").remove();
                        Crear.yCoord=(83-(11.4*(Crear.fila)));
                        Crear.xCoord=(1.1+(6.125*(Crear.columna-1)));
                        $('.cajaOcupada').each(function(){
                            esLibre=false;
                        });
                        if(esLibre) {
                            $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:" + Crear.yCoord + "%;left:" + Crear.xCoord + "%;width:97.6%;height:92%;border:8px solid #00af00;><h5 class='desc'></h5></div>");
                            $('#addMaterial').css('background','#009900');
                        }
                        break;
                    //subdivision 4x2 _ 1x2
                    case 10:
                        if(x%2!=0){
                            if(y%4==0){
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y-1)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y-3;
                            }else if(y%2==0){
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y+1)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y-1;

                            }
                            else if(y%3==0 || y%7==0){
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y-2;
                            }else{
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y+2)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y;
                            }
                            $('.cajaOcupada').each(function(){
                                if(Math.max($(this).attr('columna'),Crear.fila) < Math.min($(this).attr('columna2'),(Crear.fila + 1)) &&
                                    Math.max($(this).attr('fila2'),Crear.columna ) < Math.min($(this).attr('fila'),(Crear.columna +3)))
                                    esLibre=false;
                            });
                            if(esLibre) {
                                $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:" + Crear.yCoord + "%;left:" + Crear.xCoord + "%;width:12.2%;height:46%;border:8px solid #00af00;'><h5 class='desc'></h5></div>" +
                                    "<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:" + ((Crear.yCoord) + 23.1) + "%;left:" + Crear.xCoord + "%;width:6.1%;height:23%;border:8px solid #00af00;background:#00af00'><h5 class='desc'></h5></div>");
                                $('#addMaterial').css('background','#009900');
                            }

                        }else
                            alert("No se puede poner una caja 2x4 en una posicion par");


                        break;
                    //subdivision 4x2 _ 1x1
                    case 11:
                        if(x%2!=0){
                            if(y%4==0){
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y-1)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y-3;
                            }else if(y%2==0){
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y+1)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y-1;

                            }
                            else if(y%3==0 || y%7==0){
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y-2;
                            }else{
                                $("div[id=nuevaCaja]").remove();
                                Crear.yCoord=(83-(11.4*(y+2)));
                                Crear.xCoord=(1.1+(6.125*(x-1)));
                                Crear.fila=x;
                                Crear.columna=y;
                            }
                            $('.cajaOcupada').each(function(){
                                if(Math.max($(this).attr('columna'),Crear.fila) < Math.min($(this).attr('columna2'),(Crear.fila + 1)) &&
                                    Math.max($(this).attr('fila2'),Crear.columna ) < Math.min($(this).attr('fila'),(Crear.columna +3)))
                                    esLibre=false;
                            });
                            if(esLibre) {
                                $("#contenidoEntablado").after("<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:" + Crear.yCoord + "%;left:" + Crear.xCoord + "%;width:12.2%;height:46%;border:8px solid #00af00;'><h5 class='desc'></h5></div>" +
                                    "<div id='nuevaCaja' class='wrap' style='margin-left:0.2%;top:" + ((Crear.yCoord) + 34.6) + "%;left:" + Crear.xCoord + "%;width:6.1%;height:11.5%;border:8px solid #00af00;background:#00af00'><h5 class='desc'></h5></div>");
                                $('#addMaterial').css('background','#009900');
                            }

                        }else
                            alert("No se puede poner una caja 2x4 en una posicion par");
                        break;
                };

            }
            else
                Crear.esLibre=true;
            Crear.subdivision=false;

        });
    });
</script>
</body>

</html>