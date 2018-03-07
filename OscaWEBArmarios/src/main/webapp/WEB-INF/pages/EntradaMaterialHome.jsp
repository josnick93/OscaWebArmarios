<%--
  Created by IntelliJ IDEA.
  User: Portátil1
  Date: 08/05/2017
  Time: 10:58
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
    <link rel="stylesheet" href="css/oscaEntrada.css">
</head>

<body style="background:#fdfcfc">
<!-- Static navbar -->
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
            <a class="navbar-brand" href="#">
                <p id='titulo' class="cabecera">${lanzadera.descripcion}</p>
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
<div class="text-center w-100 h-100 my-2 text-white py-5 text-uppercase">
    <div class="container" style="height:75%;text-align: center;margin-top:7%">
        <div class="row">
            <div class="col-md-6" style="height:50%">
                <a id="entradaPedido" href="/OscaArmarios/EntradaSeleccionPedido.html?lanzadera=${lanzadera.id_lanzadera}" class="btn btn-primary btn-lg text-center my-5" style="margin-right: auto; margin-left: auto; width: 300px;background:#009900">ENTRADA MATERIAL</a>
            </div>
            <div class="col-md-6" style="height:50%">
                <a id="entradaManual" href="/OscaArmarios/EntradaBusquedaArticulo.html?lanzadera=${lanzadera.id_lanzadera}" class="btn btn-primary btn-lg text-center my-5"  style="margin-right: auto; margin-left: auto; width: 300px;background:#009900">ENTRADA MANUAL</a>
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
                    $("#entradaPedido").attr("href","/OscaArmarios/EntradaSeleccionPedido.html?lanzadera="+data.id_lanzadera);
                    $("#entradaManual").attr("href","/OscaArmarios/EntradaBusquedaArticulo.html?lanzadera="+data.id_lanzadera);
                    $("#EntradaMaterialHome").attr("href","/OscaArmarios/EntradaMaterialHome.html?lanzadera="+data.id_lanzadera);
                    $("#SalidaMaterialHome").attr("href","/OscaArmarios/EntradaMaterialHome.html?lanzadera="+data.id_lanzadera);
                    $('#titulo').text(data.descripcion);
                }
            },
            error: function()
            {
            }
        });
    });



</script>
</html>
