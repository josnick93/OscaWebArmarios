<%--
  Created by IntelliJ IDEA.
  User: Portátil1
  Date: 22/05/2017
  Time: 8:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Seleccion ubiacion</title>
    <link href="css/scrollable-table.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://pingendo.com/assets/bootstrap/bootstrap-4.0.0-alpha.6.css" type="text/css">
    <script type="text/javascript" src="http://codeorigin.jquery.com/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="http://code.angularjs.org/1.3.9/angular.js"></script>
    <script type="text/javascript" src="js/angular-scrollable-table.js"></script>
</head>

<body ng-app="myApp" ng-init="rootWidth=100%;">
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
<div class="py-5">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1 class="my-3">Articulo Encontrado</h1>
            </div>
            <table class="table table-striped custab">
                <thead>
                <tr>
                    <th>Código</th>
                    <th>Proveedor</th>
                    <th>Descripción</th>
                    <th class="text-center bg-primary">Cantidad</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>00.000.1671</td>
                    <td>Gecco Steel</td>
                    <td>TAPON 1/2 DIN 910 - 5.8</td>
                    <td class="text-center bg-success">22</td>
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
                            <th sortable-header="" col="code" title="The code for the unit">Lanzadera</th>
                            <th sortable-header="" col="code" title="The code for the unit">Entablado</th>
                            <th col="cost" sortable-header="">X</th>
                            <th sortable-header="" col="conditionRating">Y</th>
                            <th col="extent" ng-show="toggleColumn">Cantidad</th>
                            <th col="planYear" class="text-right" comparator-fn="comparator" sortable-header="">Peso</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr ng-repeat="response in visibleProjects" row-id="{{ response.facility }}" ng-class="{info: selected == response.facility}">
                            <td>{{ response.facility }}</td>
                            <td>{{ response.code }}</td>
                            <td>{{ response.cost }}</td>
                            <td class="cr">{{ response.conditionRating }}</td>
                            <td ng-show="toggleColumn">{{ response.extent }}</td>
                            <td>{{ response.planYear }}</td>
                            <td class="text-right">
                                <a class="btn btn-primary" href="/OscaArmarios/ConsultaEntablado.html" data-toggle="modal">Mostrar</a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </scrollable-table>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-12"> </div>
        </div>
        <div class="row">
            <div class="col-md-12"> </div>
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
