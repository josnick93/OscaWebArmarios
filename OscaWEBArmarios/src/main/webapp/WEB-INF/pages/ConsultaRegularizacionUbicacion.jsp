<%--
  Created by IntelliJ IDEA.
  User: Portátil1
  Date: 22/05/2017
  Time: 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Seleccion ubiacion</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="https://pingendo.com/assets/bootstrap/bootstrap-4.0.0-alpha.6.css" type="text/css">
    <link href="./css/style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="http://codeorigin.jquery.com/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="http://code.angularjs.org/1.3.9/angular.js"></script>
    <script type="text/javascript" src="../angular-scrollable-table.js"></script>
    <script type="text/javascript" src="app.js"></script>
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
                <h1 class="my-3">Consulta Artículo</h1>
            </div>
            <table class="table table-striped custab">
                <thead>
                <tr>
                    <th>Código</th>
                    <th>Descripción</th>
                    <th class="text-center bg-primary">Cantidad</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>00.000.1671</td>
                    <td>TAPON 1/2 DIN 910 - 5.8</td>
                    <td class="bg-success"> <span id="cantidad" type="number" class="bg-success one input-group-addon w-100 h-100 m-0 text-center" contenteditable="">
					  <h3 class="text-center w-100">6</h3>
				   </span> </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-10">
                        <table class="table table-striped custab w-25 py-1">
                            <thead>
                            <tr>
                                <th class="w-25">Lanzadera</th>
                                <th class="w-25">Entablado</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>3</td>
                                <td>1</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-2">
                        <table class="table table-striped custab w-100 py-1">
                            <thead>
                            <tr>
                                <th class="w-75 text-center">Regularizar</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td class="bg-faded w-75"> <span id="cantidad" type="number" class="one input-group-addon w-100 h-100 m-0 text-center bg-faded" contenteditable="">
					  					<h2 class="text-center w-100">43</h2>
				   					</span> </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <h1 class="mx-4 py-4">Entablado</h1>
            </div>
        </div>
        <div class="row">
            <!--leyenda eje y-->
            <div class="col-md-0.5 py-1">
                <h2 class="my-4">1</h2>
                <h2 class="my-4">2</h2>
                <h2 class="my-4">3</h2>
                <h2 class="my-4">4</h2>
            </div>
            <!--ontenido entablado-->
            <div class="col-md-11">
                <div id="entablado" class="container-fluid w-100">
                    <script>
                        var text = "<div class=\"row\">\n <div class=\"btn-group\">";
                        var i;
                        for (i = 1; i <= (28*4); i++) {

                            text += "<button type=\"button\" class=\"btn btn-default col-md-4 btn-responsive\" style=\"border:1px solid; border-radius: 0; min-height:40px; min-width:40px; max-width:60px;\"></button>";
                            if(i%28==0) text += "</div></div><div class=\"row\">\n <div class=\"btn-group\">";
                        }
                        text += "</div></div><div class=\"row\">\n <div class=\"btn-group\">";
                        for (i = 1; i <= 28; i++){
                            text += "<button type=\"button\" class=\"btn btn-default  text-center btn-responsive \" style=\" border:1px; border-radius: 0; min-height:30px; min-width:39px; max-width:60px;\" disable><h2 class=\"text-center\">"+i+"</h2></button>";
                        }
                        text += "</div></div>";
                        document.getElementById("entablado").innerHTML = text;
                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>
