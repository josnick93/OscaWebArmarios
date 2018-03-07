<%--
  Created by IntelliJ IDEA.
  User: José Ángel Caudevílla Casaús
  Date: 19/05/2017
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrapstyle.min.css">
    <link rel="stylesheet" href="css/oscaEntrada.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.numpad.js"></script>
    <link rel="stylesheet" href="css/jquery.numpad.css">

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
                    <a href="/OscaArmarios/EntradaMaterialHome.html?lanzadera=${lanzadera.id_lanzadera}">
                        <p class="cabecera text-center">&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon glyphicon-save"></span>&nbsp;&nbsp;Entrada&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                    </a>
                </li>
                <li class="acessosHome" style="border-right: 2px solid white" >
                    <a href="/OscaArmarios/ConsultaMaterialHome.html">
                        <p class="cabecera text-center">&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon glyphicon-search"></span>&nbsp;&nbsp;Consulta&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                    </a>
                </li>
                <li class="acessosHome" style="border-right: 2px solid white">
                    <a href="/OscaArmarios/SalidaMaterialHome.html?lanzadera=${lanzadera.id_lanzadera}">
                        <p class="cabecera text-center ">&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon glyphicon-open"></span>&nbsp;&nbsp;Salida&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                    </a>
                </li>
                <li class="text-center"> </li>
                <li class="text-center">
                    <button class="btn btn-default" onclick="goBack()" style="margin:5px;margin-left:5px;height:60px">
                        <script>
                            function goBack() {
                                if(${cerrar==1})
                                {
                                    open(location, '_self').close();
                                }else{
                                    window.location.href="/OscaArmarios/EntradaSeleccionCantidadArticulo.html?lanzadera=${lanzadera.id_lanzadera}&articulo=${articulo.no}";
                                }
                            }
                        </script>
                        <p class="text-center "> <span class="icon-flipped glyphicon glyphicon-share-alt" style="vertical-align:middle;font-size: 28px;"></span> </p>
                    </button>
                </li>
                <li class="text-center">
                    <button class="btn btn-default acessosHome" onclick="goHome()" style="margin:5px;margin-left:5px;height:60px">
                        <script>
                            function goHome() {
                                if(${cerrar==1})
                                {
                                    window.top.close();
                                }else {
                                    window.location.href = "/OscaArmarios/Home.html";
                                }
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
    <h3 class="text-left" style="margin-left: 20px;">ARTÍCULO SELECCIONADO - SUGERIR UBICACIÓN</h3>
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
                    <td>${articulo.description} ${articulo.description2}</td>
                    <td class="text-center">${lineaPedido.qtyOutstanding}</td>
                </tr>
                </tbody>
            </table>
            <h4 class="text-left">SELECCIONAR CAJA</h4>
            <!--Introducir cantidad-->
        </div>
    </div>
</div>
<div class="row pi-draggable" draggable="true">
    <div class="col-sm-3">
        <a href="#" style="margin-right:10px;">
            <img id="tipoCaja" tipoCaja="8" tipo="medio" src="http://s2.subirimagenes.com/imagen/previo/thump_9754393medioentablado.png" width="300" height="100" target="_blank" style="border:3px solid black"> </a>
        <br>
        <br>
        <br>
        <a href="#" style="margin-right:10px;">
            <img id="tipoCaja"  tipoCaja="9" src="http://s2.subirimagenes.com/imagen/previo/thump_9754401entabladocometo.png" width="300" height="100" target="_blank" style="border:3px solid black"> </a>
        <br>
        <br>
        <br>
        <img id='medida' src="http://s2.subirimagenes.com/imagen/previo/thump_9754402a-medida.png" height="64" width="300" target="_blank" style="border:3px solid black">
    </div>
    <div class="col-sm-9" style="column-gap: 100px;">
        <div class='product-holder'>
            <img id='a' src="cajas/entabladoCompleto.png " style='width:100%;height:47%;' class='product-image img-responsive'>
            <img id='tipoCaja' tipoCaja="7" src="cajas/4x8.png"  style='width:24.5%;height:92%;top:3%;' class='plus-image img-responsive'>
            <img id='tipoCaja' tipoCaja="6" src="cajas/44.png"  style='width:24.5%;height:45.5%;top:49%;left: 24.5%' class='plus-image img-responsive'>
            <img id='tipoCaja' tipoCaja="5" src="cajas/2x4 H.png"  style='width:12.5%;height:46%;top:49%;left: 49%' class='plus-image img-responsive'>
            <img id='tipoCaja' tipoCaja="4" src="cajas/2x4.png"  style='width:12.5%;height:46%;top:49%;left: 61.3%' class='plus-image img-responsive'>
            <img id='tipoCaja' tipoCaja="10" src="cajas/1x2_2x4.png"  style='width:12.5%;height:46.5%;top:49%;left: 73.4%' class='plus-image img-responsive'>
            <img id='tipoCaja' tipoCaja="11" src="cajas/1x1_2x4.png"  style='width:12.5%;height:46.5%;top:49%;left: 85.4%' class='plus-image img-responsive'>
            <img id='tipoCaja' tipoCaja="3" src="cajas/2x2.png"  style='width:12.5%;height:23.25%;top:3%;left: 85.4%' class='plus-image img-responsive'>



        </div>

        <!--<img id="tipoEntablado" class="btn btn-primary-outline img-responsive" src="http://s2.subirimagenes.com/imagen/previo/thump_9754423entalado-vacio.png" height="72" width="2000" target="_blank">-->
        </br>
    </div>
</div>

<!-- mostrar dialogo seleccion entablado -->
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
<!--Diagolo tipo de caja -->
<div id="dialogoSeleccionCaja" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content" >
            <div class="modal-header modal-header-danger">
                <h4 class="modal-title">Seleccionar tipo caja</h4>
            </div>
            <div class="modal-body">
                <p>Debes seleccionar un tipo de caja</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-lg outline px-3 mx-3" style="float: right;background:#009900;color: white;" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>

<div id="dimensionCajaMedida" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Caja a medida</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label>filas de la caja</label>
                    <input id='nfilas' type="number" class="form-control">
                </div>
                <div class="form-group">
                    <label>columnas de la caja</label>
                    <input id='ncolumnas' type="number" class="form-control">
                </div>
            </div>
            <div class="modal-footer">
                <button id='botonUbicarMedida' type="button" class="btn btn-primary" data-dismiss="modal" style="background:#009900;color: white;" >Ubicar</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" style="background:#009900;color: white;">Cerrar</button>
            </div>
        </div>
    </div>
</div>

<!--Diagolo tipo de caja -->
<div id="dialogodimensionIncorrecta" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content" >
            <div class="modal-header modal-header-danger">
                <h4 class="modal-title">Error caja a medida</h4>
            </div>
            <div class="modal-body">
                <p>Las dimensiones superan el entablado</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-lg outline px-3 mx-3" style="float: right;background:#009900;color: white;" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>
<!--container-->
<!--fin nav-->
<script>
    // Set NumPad defaults for jQuery mobile.
    // These defaults will be applied to all NumPads within this document!
    $.fn.numpad.defaults.gridTpl = '<table class="table modal-content"></table>';
    $.fn.numpad.defaults.backgroundTpl = '<div class="modal-backdrop in"></div>';
    $.fn.numpad.defaults.displayTpl = '<input type="text" class="form-control" />';
    $.fn.numpad.defaults.buttonNumberTpl =  '<button type="button" class="btn btn-default " style="width: 100%;"></button>';
    $.fn.numpad.defaults.buttonFunctionTpl = '<button type="button" class="btn" style="width: 100%;"></button>';
    $.fn.numpad.defaults.onKeypadCreate = function(){$(this).find('.done').addClass('btn-primary').css('background','#626262');};

    $('#nfilas').numpad();
    $('#ncolumnas').numpad();
    $('#medidaEntablado').numpad();

    $('#text-basic').numpad();
    $('#text-basic1').numpad();

    $(document).ready(function() {

        if(${cerrar==1}){
            $('.acessosHome').each(function(i, obj) {
                $(this).hide();
            });
        }
        function Tipo() { // clase tipo entablado y caja
            this.tipoEntablado="";
            this.tipoCaja=-1;

            this.privilegedMethod = function () {  // Public Method
            };
        }
        var tipoUbicacion = new Tipo();

        $(function () {
            //medidaEntablado
            $("img[id=tipoCaja]").click(function() {
                $('img').each(function() {
                    if(this.id=="tipoCaja"){
                        $(this).css('border', "3px solid black");
                        $(this).css('outline-offset', "none");
                    }
                });

                $(this).css('border', "solid 6px #009900");
                $(this).css('outline-offset', "-16px;");
                tipoUbicacion.tipoCaja=parseInt($(this).attr("tipoCaja"));
                if(${cerrar==1}){
                    window.location.href = "EntradaPedidoAgrupadoSugerirUbicacion.html?articulo=${articulo.no}&caja="+  tipoUbicacion.tipoCaja +"&pedido=${pedido.no}&entablado=${codigoEntablado}";
                }else{
                    window.location.href = "EntradaPedidoAgrupadoSugerirUbicacion.html?articulo=${articulo.no}&caja="+  tipoUbicacion.tipoCaja +"&pedido=${pedido.no}&entablado=${codigoEntablado}";
                }
            });
        });
        $("#medida").click(function(){
            $('#dimensionCajaMedida').modal({
                show: 'true'
            });

        });

        //ubicarCajaMedida
        $("#botonUbicarMedida").click(function(){
            //comprobar dimensiones
            if($('#nfilas').val() <= 0 || $('#nfilas').val() >8 || $('#nfilas').val == 7
                || $('#ncolumnas').val() <= 0 || $('#ncolumnas').val() >=16 || $('#ncolumnas').val()== 15){
                $('#dialogodimensionIncorrecta').modal({
                    show: 'true'
                });

            }else{
                window.location.href = "EntradaPedidoAgrupadoSugerirUbicacionMedida.html?${articulo.no}&caja="+  tipoUbicacion.tipoCaja +"&cerrar=0&pedido=${pedido.no}&entablado=${codigoEntablado}&nFila="
                    +parseInt($('#nfilas').val())+"&columna="+parseInt($('#ncolumnas').val());
            }

        });
    });




</script>
<style type="text/css">
    .nmpd-grid {border: none; width:50%;height:35%; padding: 40px;}
    .nmpd-grid>tbody>tr>td {border: none;}

    /* Some custom styling for Bootstrap */
    .qtyInput {display: block;
        width: 100%;
        padding: 6px 12px;
        color: #555;
        background-color: white;
        border: 1px solid #ccc;
        border-radius: 4px;
        -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
        box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
        -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
        -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
        transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
    }
</style>
</body>

</html>

