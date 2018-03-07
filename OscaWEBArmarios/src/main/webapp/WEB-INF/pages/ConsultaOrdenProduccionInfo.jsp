<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Portátil1
  Date: 22/09/2017
  Time: 12:04
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
            height: 5px;
            /* Just for the demo          */
            overflow-y: auto;
            /* Trigger vertical scroll    */
            width: 45px;
            /* Just for the demo          */
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
            height: 450px;
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
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"><span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span></button>
            <a class="navbar-brand" href="#">
                <p class="cabecera">${lanzadera.descripcion}</p>
            </a>
        </div>
        <div class="navbar-collapse collapse" id="navbar">
            <ul class="nav navbar-nav navbar-right" style="border-left: 2px solid white">
                <li style="border-right: 2px solid white" >
                    <a href="/OscaArmarios/EntradaMaterialHome.html?lanzadera=${lanzadera.id_lanzadera}">
                        <p class="cabecera text-center">&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon glyphicon-save"></span>&nbsp;&nbsp;Entrada&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </p>
                    </a>
                </li>
                <li style="border-right: 2px solid white" class="active">
                    <a href="/OscaArmarios/ConsultaMaterialHome.html">
                        <p class="cabecera text-center">&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon glyphicon-search"></span>&nbsp;&nbsp;Consulta&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </p>
                    </a>
                </li>
                <li style="border-right: 2px solid white">
                    <a href="/OscaArmarios/SalidaMaterialHome.html?lanzadera=${lanzadera.id_lanzadera}">
                        <p class="cabecera text-center ">&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon glyphicon-open"></span>&nbsp;&nbsp;Salida&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </p>
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
                        <p class="text-center "><span class="icon-flipped glyphicon glyphicon-share-alt" style="vertical-align:middle;font-size: 28px;"></span></p>
                    </button>
                </li>
                <li class="text-center">
                    <button class="btn btn-default" onclick="goHome()" style="margin:5px;margin-left:5px;height:60px">
                        <script>
                            function goHome() {
                                window.location.href = "/OscaArmarios/Home.html";
                            }
                        </script>
                        <a href="/OscaArmarios/Home.html" style="color:black">
                            <p class="text-center "> <span class="icon-flipped glyphicon glyphicon-home" style="vertical-align:middle;font-size: 28px;">
                                    </span> </p>
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
    <h3 class="text-left" style="margin-left: 20px;">ENTRADA MATERIAL</h3>
    <div class="row">
        <div class="col-sm-2">
            <img class="d-block img-fluid float-left" src="http://s2.subirimagenes.com/imagen/previo/thump_9752997pieza.png" height="150" width="170"> </div>
        <div class="col-sm-10">
            <table class="table table-bordered table-responsive">
                <thead bgcolor="#fdfcfc" style="background:#626262">
                <tr>
                    <th>
                        <font color="#fdfcfc">ORDEN PRODUCCIÓN</font>
                    </th>
                    <th>
                        <font color="#fdfcfc">DESCRIPCIÓN</font>
                    </th>
                    <th>
                        <font color="#fdfcfc">VENDEDOR</font>
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="m-0">${Orden.no}</td>
                    <td>${Orden.description}</td>
                    <td>${Orden.customerName}</td>
                </tr>
                </tbody>
            </table>
            <h4 class="text-left">INFORMACIÓN DE LA ORDEN DE PRODUCCIÓN</h4>
        </div>
    </div>
    <div class="col-md-12 panel panel-default" style="margin-top:-50px">
        <h4 class="text-left">LISTADO ARTÍCULOS ORDEN PRODUCCIÓN</h4>
        <div class="col-md-4 pull-right"> </div>
        <table class="table  table-condensed  table-responsive ">
            <thead style="background:#626262">
            <tr>
                <th class="text-center">
                    <font color="#fdfcfc">Nº PEDIDO</font>
                </th>
                <th class="text-center">
                    <font color="#fdfcfc">Nª LINEA</font>
                </th>
                <th class="text-center">
                    <font color="#fdfcfc">LOCALIZACIÓN</font>
                </th>
                <th class="text-center">
                    <font color="#fdfcfc">ORIGEN</font>
                </th>
                <th class="text-center">
                    <font color="#fdfcfc">DESCRIPCIÓN ARTÍCULO</font>
                </th>
                <th class="text-center">
                    <font color="#fdfcfc">CANTIDAD</font>
                </th>
                <th class="text-center">
                    <font color="#fdfcfc">CANTIDAD NECESARIA</font>
                </th>
            </tr>
            </thead>
        </table>
        <div class="div-table-content">
                    <table class="table table-condensed table-bordered">
                        <tbody>
                        <c:if test="${!empty Componentes}">
                            <c:forEach items="${Componentes}" var="componente">
                            <tr>
                                <td class="text-center">${componente.itemNo}</td>
                                <td class="text-center">${componente.prodOrderLineNo}</td>
                                <td class="text-center">${componente.binCode}</td>
                                <td class="text-center">${componente.status}</td>
                                <td class="text-center">${componente.description}</td>
                                <td class="text-center">${componente.remainingQuantity}</td>
                                <td class="text-center">${componente.quantity}</td>
                            </tr>
                            </c:forEach>
                         </c:if>
                        </tbody>
                    </table>
        </div>
    </div>
</div>
<script>
    // Set NumPad defaults for jQuery mobile.
    // These defaults will be applied to all NumPads within this document!
    $(document).ready(function () {
        $('#text-basic').numpad();

        $("a[id=salida]").click(function () {
            window.location.href = $(this).attr('url');
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
    }
</style>
</body>

</html>