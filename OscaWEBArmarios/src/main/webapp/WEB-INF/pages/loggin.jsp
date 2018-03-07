<%--
  Created by IntelliJ IDEA.
  User: José Ángel Caudevílla Casaús
  Date: 08/05/2017
  Time: 7:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>

<head>
    <title>Salida Seleccion Ubicacion</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="css/bootstrapstyle.min.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.numpad.js"></script>
    <link rel="stylesheet" href="css/virtualKeyboard.css">
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

        .tr table {
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
        }
    </style>
</head>
<body style="background:#fdfcfc">
<!-- Static navbar -->
<nav class="navbar navbar-default">
    <img class="left-block img-fluid d-block mx-4" src="http://www.oscasistemas.com/imagenes/base/logo_head.jpg" style="margin-left:15px">
</nav>
<div class="text-center w-100 h-100 my-3 text-white py-5 text-uppercase">
    <div class="py-2">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="text-center">Control Almacen<br> </h1>
                    <br>
                    <br>
                    <div class="col-md-3 text-center offset-md-3"></div>
                    <div class="col-md-6 text-center offset-md-3">
                        <form class="bg-faded my-1"style="background:#626262">
                            <br>
                            <div  class="form-group m-2 text-center" style="text-align:center"> <label>Usuario<br></label>
                                <input id="userInput" type="text" class="form-control" placeholder="Usuario" style="width:75%;margin-left:12%"> </div>
                            <div  class="form-group m-4"> <label>Contraseña</label>
                                <input id="passInput" type="password" class="form-control" placeholder="Contraseña" style="width:75%;margin-left:12%"> </div>
                            <a type="submit" class="btn btn-primary w-50" href="/OscaArmarios/Home.html" style="background:#324891">ENTRAR</a>
                            <br>
                        </form>
                    </div>
                    <div class="col-md-3 text-center offset-md-3"></div>
                </div>
            </div>
        </div>
    </div>
    <div class="py-5 text-center">
        <div class="container">
            <div class="row"> </div>
        </div>
    </div>
</div>
</body>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="js/tether.min.js" type="text/javascript"></script>
<script src="js/virtualKeyboard.js"></script>
<script src="js/dataTables.bootstrap.min.js" type="text/javascript"></script>
<script>
    $(document).ready(function() {
        $('input#userInput').mlKeyboard({layout: 'es_ES'});
        $('input#passInput').mlKeyboard({layout: 'es_ES'});
    });
</script>
</html>