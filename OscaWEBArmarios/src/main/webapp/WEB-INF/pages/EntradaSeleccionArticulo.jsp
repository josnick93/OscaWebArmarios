<%--
  Created by IntelliJ IDEA.
  User: Portátil1
  Date: 17/05/2017
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="es">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Angular-scrollable-table directive demo</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../scrollable-table.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="css/oscaEntrada.css">

    <script type="text/javascript" src="http://codeorigin.jquery.com/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="http://code.angularjs.org/1.3.9/angular.js"></script>
    <script type="text/javascript" src="../angular-scrollable-table.js"></script>
    <script type="text/javascript" src="app.js"></script>

</head>

<body ng-app="myApp" ng-init="rootWidth=100%;">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Seleccion ubiacion</title>
<link href="css/scrollable-table.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://pingendo.com/assets/bootstrap/bootstrap-4.0.0-alpha.6.css" type="text/css">
<script type="text/javascript" src="http://codeorigin.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="http://code.angularjs.org/1.3.9/angular.js"></script>
<script type="text/javascript" src="js/angular-scrollable-table.js"></script>
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
<div class="py-5">
    <div class="container">
        <div class="row">
            <h1 class="my-3">SELECCIONAR ARTÍCULO DE PEDIDO</h1>
            <table class="table table-striped custab">
                <thead>
                <tr>
                    <th>Código Pedido</th>
                    <th>Proveedor</th>
                    <th>Fecha</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>4064</td>
                    <td>Seaside Steel</td>
                    <td>27-02-2008</td>
                </tr>
                </tbody>
            </table>
            <h2 class="my-4"> Ubicación</h2>
            <div ng-controller="MyCtrl" class="test-container w-100" ng-style="{'width': rootWidth+'px'; }">
                <!-- tabla informacion articulos -->
                <scrollable-table watch="visibleProjects" resizable="">
                    <table class="table table-striped table-bordered w-100">
                        <thead>
                        <tr>
                            <th sortable-header="" col="code" title="The code for the unit">Código</th>
                            <th sortable-header="" col="code" title="The code for the unit" class="w-75">Descripción</th>
                            <th col="cost" sortable-header="" class="">Cantidad</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr ng-repeat="response in visibleProjects" row-id="{{ response.facility }}" ng-class="{info: selected == response.facility}">
                            <td>{{ response.facility }}</td>
                            <td class="w-75">{{ response.code }}</td>
                            <td>{{ response.cost }}</td>
                        </tr>
                        </tbody>
                    </table>
                </scrollable-table>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/table/compareTable.js"></script>
<script>
    jQuery(document).ready(function($) {
        $(".clickable-row").click(function() {
            window.document.location = $(this).data("href");
        });
    });
</script>
</body>

</html>