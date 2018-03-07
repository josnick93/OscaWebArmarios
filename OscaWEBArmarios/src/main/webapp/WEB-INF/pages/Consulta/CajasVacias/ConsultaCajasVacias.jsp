<%--
  Created by IntelliJ IDEA.
  User: José Ángel Caudevílla Casaús
  Date: 08/05/2017
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fb" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>

<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="css/bootstrapstyle.min.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link rel='stylesheet prefetch' href='css/bootstrap-table.min.css'>
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
<div class="container" style="width: 97%;">
    <div class="form-group form-group-sm">
        <h4>
            <span class="left"  style="float:left;">Cajas Vacias</span>
        </h4>
    </div>
    </br>
    <table id="table"
           data-toggle="table"
           data-search="false"
           data-filter-control="true"
           data-show-export="false"
           data-click-to-select="false"
           data-toolbar="#toolbar" class="table table-striped table-bordered nowrap" cellspacing="0" width="100%">
            <thead bgcolor="#fdfcfc" style="background:#626262">
            <tr>
                <th data-field="LANZADERA" data-filter-control="select" data-sortable="true">
                    <font color="#fdfcfc">LANZADERA</font>
                </th>
                <th data-field="ENTABLADO" data-filter-control="select" data-sortable="true">
                    <font color="#fdfcfc">ENTABLADO</font>
                </th>
                <th data-field="ARTÍCULO" data-filter-control="select" data-sortable="true">
                    <font color="#fdfcfc">ARTÍCULO</font>
                </th>
                <th data-field="ALIAS" data-filter-control="select" data-sortable="true">
                    <font color="#fdfcfc">ALIAS</font>
                </th>
                <th data-field="TIPO_CAJA" data-filter-control="select" data-sortable="true">
                    <font color="#fdfcfc">TIPO CAJA</font>
                </th>
                <th data-field="ACCEDER" data-filter-control="select" data-sortable="false">
                    <font color="#fdfcfc">ACCEDER</font>
                </th>
                <th data-field="BORRAR" data-filter-control="select" data-sortable="false" class="text-center">
                    <font color="#fdfcfc">BORRAR</font>
                </th>
            </tr>
            </thead>
            <c:if test="${!empty ubicaciones}">
                <tbody>
                    <c:forEach items="${ubicaciones}" var="ubicacion">
                        <tr>
                            <td class="m-0">${ubicacion.lanzadera.descripcion}</td>
                            <td class="text-left">${ubicacion.entablado.codigo}</td>
                            <td class="text-left">${ubicacion.articulo}</td>
                            <td class="text-left">${ubicacion.infoArticulo.searchDescription}</td>
                            <td>${ubicacion.tipoCaja.descripcion}</td>
                            <td class="text-center" style="width:5%">
                                <input class='myclass'  onclick="location.href='http://192.168.2.8/OscaArmarios/ConsultaEntabladoCajaVacia.html?entablado=${ubicacion.entablado.codigo}&amp;fila=${ubicacion.fila}&amp;columna=${ubicacion.columna}';" type='button' value='ACCEDER'/>
                            </td>
                            <td class="text-center" style="width:5%">
                                <a id='borrar' class="borrarCaja" lanzadera='${ubicacion.lanzadera.id_lanzadera}'  entablado='${ubicacion.entablado.codigo}' fila='${ubicacion.fila}' columna='${ubicacion.columna}' class="btn btn-primary btn-lg outline px-3 mx-3" data-toggle="modal" style='background:#324891'>
                                    <span class="icon-flipped glyphicon glyphicon-trash" style="vertical-align:middle;font-size: 28px;color: #FFFFFF;"/></a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </c:if>
        </table>
</div>
<!-- mostrar dialogo seleccion entablado -->
<!--Diagolo tipo entablado -->
<div id="waitDialog" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Bajando entablado</h4>
            </div>
            <div class="modal-body">
                <p><img src="https://upload.wikimedia.org/wikipedia/commons/b/b1/Loading_icon.gif" /></p>
                <p>Bajando entablado , por favor espere...</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-lg outline px-3 mx-3" style="float: right;background:#324891;color: white;" data-dismiss="modal">CERRAR</button>
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
                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
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
<!--Diagolo localizacion añadErrorrror -->
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
<!--dialogo confirmar borrado -->
<div class="modal fade" id="confirmarBorrado" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title">CONFIRMAR Eliminacion de caja</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <fieldset>
                        <!-- Text input-->
                        <h3 id="confBorradoText">¿Deseas borrar la caja vacia? </h3>
                    </fieldset>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success" id="aceptarBorrado" style="background:#324891">ACEPTAR</button>
                <a href="#" class="btn" data-dismiss="modal" style="background:#324891;color:white">CERRAR</a>
            </div>
        </div>
    </div>
</div>
<div id="eliminarCajaVacia" class="modal fade"  role="dialog" data-backdrop="static" data-keyboard="false"role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title">Eliminando caja vacia,por favor espere...</h4>
            </div>
            <div class="modal-body"> <strong>Instrucciones:</strong>
                <p>1- Espere a que se acabe de eliminar la ubicacion</p>
            </div>
        </div>
    </div>
</div>
<script src="js/tether.min.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="js/dataTables.bootstrap.min.js" type="text/javascript"></script>


<script type="text/javascript" src='js/bootstrap-table.js'></script>
<script type="text/javascript" src='js/bootstrap-table-editable.js'></script>
<script type="text/javascript" src='js/bootstrap-table-export.js'></script>
<script type="text/javascript" src='js/tableExport.js'></script>
<script type="text/javascript" src='js/bootstrap-table-filter-control.js'></script>
<script>

    //exporte les données sélectionnées
    var $table = $('#table');
    $(function () {
        $('#toolbar').find('select').change(function () {
            $table.bootstrapTable('refreshOptions', {
                exportDataType: $(this).val()
            });
        });
    });

    $(document).ready(function() {
        var entablado="";
        var xPos=-1;
        var yPos=-1;

        $('#table').find('td').each(function() {
            $(this).html($(this).html().split("&gt;").join(">").split("&lt;").join("<"));
        });

        $("#traerEntablado").click(function() {
            $.ajax({
                type: 'GET',
                contentType : 'application/json; charset=utf-8',
                url: '/OscaArmarios/EntradaSeleccionNuevaUbicacionFinal/TraerEntablado',
                data: { lanzadera:parseInt(${lanzadera.id_lanzadera}) , entablado:parseInt(${entablado.codigo})},
                dataType: 'json',
                async : true,
                beforeSend: function()
                {
                    Crear.msg="Correct";
                    $('#waitDialog').modal('toggle');

                    $('#traerEntablado').css('background','#626262');
                    $('#discountMaterial').css('background','#324891');
                },
                success: function(data){
                    $('#waitDialog').modal('hide');
                    Crear.msg="Correct";
                },
                error: function(data)
                {

                }
            });
        });

        var trBoldBlue = $("table");

        $(trBoldBlue).on("click", "tr", function (){
            $(this).toggleClass("bold-blue");
        });

        //peticion añadir material

        $(".borrarCaja").click(function() {
            entablado=$(this).attr('entablado');
            xPos= $(this).attr('fila');
            yPos=$(this).attr('columna');
            $('#confirmarBorrado').modal("toggle");
        });

        $("#aceptarBorrado").click(function () {
            //Aceptar
            $.ajax({
                type: 'GET',
                contentType : 'application/json; charset=utf-8',
                url: '/OscaArmarios/Operacion/removerCajaVacia',
                //lanzadera entablado x y articulo cantidad
                data: { entablado: entablado,
                    xPos: xPos, yPos: yPos ,
                },
                dataType: 'json',
                async : true,
                beforeSend: function()
                {
                    $('#eliminarCajaVacia').modal({
                        show: 'true'
                    });

                },
                success: function(data){
                    $('#eliminarCajaVacia').modal("toggle");
                    window.location.href=window.location.href;
                },
                error: function() {

                }
            });
        });
    });
</script>
</body>

</html>
