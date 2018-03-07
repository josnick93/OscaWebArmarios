<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Portátil1
  Date: 19/05/2017
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Administrador</title>
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
            top: 81.5%;
            position: absolute;
            margin-top: 0.5%;
            margin-left: 1%;
            border: 3px solid black;
            display: inline-block;
        }

        .plus-image p {
            font-family: 'Dancing Script', cursive;
            color: #ffffff;
            font-size: 2em;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
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

        .wrap {
            /* force the div to properly contain the floated images: */
            position: absolute;
            float: left;
            clear: none;
            overflow: hidden;
        }

        .wrap img {
            position: relative;
            z-index: 1;
        }

        .wrap .desc {
            display: block;
            position: absolute;
            width: 100%;
            top: 5%;
            left: 0;
            z-index: 2;
            text-align: center;
        }
    </style>
</head>

<body style="background:#fdfcfc">
<!-- Static navbar -->
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button class="navbar-toggle collapsed" aria-controls="navbar" aria-expanded="false" data-target="#navbar" data-toggle="collapse" type="button"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
            <a class="navbar-brand" href="#">
                <p class="cabecera">${administrador.nombre}</p>
            </a>
        </div>
        <div class="navbar-collapse collapse" id="navbar">
            <ul class="nav navbar-nav navbar-right" style="border-left: 2px solid white">
                <li style="border-right: 2px solid white">
                    <a href="/OscaArmarios/EntradaMaterialHome.html">
                        <p class="cabecera text-center">&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon glyphicon-save"></span>&nbsp;&nbsp;Entrada&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                    </a>
                </li>
                <li style="border-right: 2px solid white">
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
<div class="container" style="width: 97%;">
    <div class="form-group form-group-sm">
        <h4> <span class="left" style="float:left;">LANZADERAS</span> </h4>
    </div>
    <br>
    <div class="row">
        <button class="btn btn-success" id="crearLanzadera" style="background:#FFD700;margin-left:10px;margin-top:10px;margin-bottom:10px">CREAR LANZADERA</button>


        <table class="table table-bordered table-responsive">
            <thead bgcolor="#fdfcfc" style="background:#626262">
            <tr>
                <th>
                    <font color="#fdfcfc">ALIAS LANZADERA</font>
                </th>
                <th>
                    <font color="#fdfcfc">DESRIPCION</font>
                </th>
                <th>
                    <font color="#fdfcfc">DIRECCION IP</font>
                </th>
                <th>
                    <font color="#fdfcfc">PUNTO ACESSO</font>
                </th>
                <th>
                    <font color="#fdfcfc">PESO MAXIMO (KG.)</font>
                </th>
                <th>
                    <font color="#fdfcfc">NUM ENTABLADOS</font>
                </th>
                <th>
                    <font color="#fdfcfc">MODIFICAR</font>
                </th>
                <th class="text-center">
                    <font color="#fdfcfc">BORRAR</font>
                </th>
            </tr>
            </thead>
            <c:if test="${!empty lanzaderas}">
            <tbody>
            <c:forEach items="${lanzaderas}" var="lanzadera">
                <tr>
                    <td class="m-0">${lanzadera.alias_lanzadera}</td>
                    <td class="text-left">${lanzadera.descripcion}</td>
                    <td class="text-left">${lanzadera.direccion_ip}</td>
                    <td class="text-left">${lanzadera.punto_acesso}</td>
                    <td>${lanzadera.peso_max}</td>
                    <td>${lanzadera.num_entablados}</td>
                    <td class="text-center" style="width:5%">
                        <a id="modificar" idLanzadera="${lanzadera.id_lanzadera}" alias="${lanzadera.alias_lanzadera}" descripcion="${lanzadera.descripcion}" direccionip="${lanzadera.direccion_ip}" puntoacesso="${lanzadera.punto_acesso}" pesomax="${lanzadera.peso_max}" numentablado="${lanzadera.num_entablados}"
                           class="btn btn-primary btn-lg outline px-3 mx-3" data-toggle="modal" style="background:#FFD700"> <span class="icon-flipped glyphicon glyphicon-pencil" style="vertical-align:middle;font-size: 28px;color: #FFFFFF;">
                                </span></a>
                    </td>
                    <td class="text-center" style="width:5%">
                        <a id="borrar" idLanzadera="${lanzadera.id_lanzadera}" descripcion="${lanzadera.descripcion}" class="btn btn-primary btn-lg outline px-3 mx-3" data-toggle="modal" style="background:#FFD700"> <span class="icon-flipped glyphicon glyphicon-trash" style="vertical-align:middle;font-size: 28px;color: #FFFFFF;">
                                </span></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
            </c:if>
        </table>
    </div>
</div>
<!-- model content -->
<div id="modificarLanzadera" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title">MODIFICAR LANZADERA</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <fieldset>
                        <!-- Text input-->
                        <div class="form-group"> <label class="col-sm-4 control-label" for="textinput">Alias</label>
                            <div class="col-sm-8">
                                <input type="text" placeholder="" class="form-control" id="aliasInput"> </div>
                        </div>
                        <!-- Text input-->
                        <div class="form-group"> <label class="col-sm-4 control-label" for="textinput">Desripción</label>
                            <div class="col-sm-8">
                                <input type="text" placeholder="" class="form-control" id="descripcionInput"> </div>
                        </div>
                        <!-- Text input-->
                        <div class="form-group"> <label class="col-sm-4 control-label" for="textinput">Ip</label>
                            <div class="col-sm-8">
                                <input type="text" placeholder="" class="form-control" id="ipInput"> </div>
                        </div>
                        <!-- Text input-->
                        <div class="form-group"> <label class="col-sm-4 control-label" for="textinput">Punto acesso</label>
                            <div class="col-sm-8">
                                <input id="pAcessoInput" type="text" placeholder="" class="form-control"> </div>
                        </div>
                        <div class="form-group"> <label class="col-sm-4 control-label" for="textinput">Peso Max</label>
                            <div class="col-sm-8">
                                <input id="pMaxInput" type="text" placeholder="" class="form-control"> </div>
                        </div>
                        <div class="form-group"> <label class="col-sm-4 control-label" for="textinput">Mum entablados</label>
                            <div class="col-sm-8">
                                <input id="nEntabladosInput" type="text" placeholder="" class="form-control"> </div>
                        </div>
                    </fieldset>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success" id="submit">ACEPTAR</button>
                <a href="#" class="btn" data-dismiss="modal">CERRAR</a>
            </div>
        </div>
    </div>
</div>

<!-- model content -->
<div id="crearLanzaderaForm" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title">CREAR LANZADERA</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <fieldset>
                        <!-- Text input-->
                        <div class="form-group"> <label  class="col-sm-4 control-label">Alias</label>
                            <div class="col-sm-8">
                                <input id='aliasCrear' type="text" placeholder="" class="form-control" id="aliasInputCrear"> </div>
                        </div>
                        <!-- Text input-->
                        <div class="form-group"> <label class="col-sm-4 control-label" >Desripción</label>
                            <div class="col-sm-8">
                                <input type="text" placeholder="" class="form-control" id="descripcionInputCrear"> </div>
                        </div>
                        <!-- Text input-->
                        <div class="form-group"> <label class="col-sm-4 control-label">Ip</label>
                            <div class="col-sm-8">
                                <input type="text" placeholder="" class="form-control" id="ipInputCrear"> </div>
                        </div>
                        <!-- Text input-->
                        <div class="form-group"> <label class="col-sm-4 control-label" >Punto acesso</label>
                            <div class="col-sm-8">
                                <input id="pAcessoInputCrear" type="text" placeholder="" class="form-control"> </div>
                        </div>
                        <div class="form-group"> <label class="col-sm-4 control-label" >Peso Max</label>
                            <div class="col-sm-8">
                                <input id="pMaxInputCrear" type="text" placeholder="" class="form-control"> </div>
                        </div>
                        <div class="form-group"> <label class="col-sm-4 control-label" >Mum entablados</label>
                            <div class="col-sm-8">
                                <input id="nEntabladosInputCrear" type="text" placeholder="" class="form-control"> </div>
                        </div>
                    </fieldset>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success"  idLanzadera="" id="crearLanzaderaSubmit">ACEPTAR</button>
                <a href="#" class="btn" data-dismiss="modal">CERRAR</a>
            </div>
        </div>
    </div>
</div>



<div class="modal fade" id="borrarLanzadera" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-danger">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title">CONFIRMAR BORRADO LANZADERA</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <fieldset>
                        <!-- Text input-->
                        <h3 id="confBorradoText"> Seguro que desea borrar la </h3>
                    </fieldset>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success" idLanzadera="" id="Borrarsubmit">ACEPTAR</button>
                <a href="#" class="btn" data-dismiss="modal">CERRAR</a>
            </div>
        </div>
    </div>
</div>


<script src="js/tether.min.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="js/dataTables.bootstrap.min.js" type="text/javascript"></script>
<script>
    $(document).ready(function() {
        $("a[id=modificar]").click(function () {
            $('#modificarLanzadera').modal({
                show: 'true'
            });
            //add fields
            $('#aliasInput').attr('placeholder',$(this).attr('alias'));
            $('#descripcionInput').attr('placeholder',$(this).attr('descripcion'));
            $('#ipInput').attr('placeholder',$(this).attr('direccionIp'));
            $('#pAcessoInput').attr('placeholder',$(this).attr('puntoAcesso'));
            $('#pMaxInput').attr('placeholder',$(this).attr('pesoMax'));
            $('#nEntabladosInput').attr('placeholder',$(this).attr('numEntablado'));
            $("#submit").attr('idLanzadera',$(this).attr('idLanzadera'));
        });

        $("a[id=borrar]").click(function () {
            $('#borrarLanzadera').modal({
                show: 'true'
            });
            $("#confBorradoText").text("Seguro que desea borrar "+ $(this).attr('descripcion'));
            //idLanzadera
            $("#Borrarsubmit").attr('idLanzadera',$(this).attr('idLanzadera'))
        });

        $("#crearLanzadera").click(function () {
            $('#crearLanzaderaForm').modal({
                show: 'true'
            });
        });


        $('#crearLanzaderaSubmit').click(function () {
            var valido=true;
            if(!$('#aliasCrear').val()){
                valido=false;
                alert("Debes introducir un alias");
            }
            if(!$('#descripcionInputCrear').val()){
                alert("Debes introducir una descripcion");
            }
            if(!/^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$/
                    .test($('#ipInputCrear').val())){
                valido=false;
                alert("La direccion ip no es valida");
            }
            if(!$('#pAcessoInputCrear').val()){
                valido=false;
                alert("Debes introducir un punto de acesso");
            }
            if(!$('#pMaxInputCrear').val()){
                valido=false;
                alert("Debes introducir un peso maximo");
            }
            if(!$('#nEntabladosInputCrear').val()){
                valido=false;
                alert("Debes introducir un numero de entablados");
            }
            //si es correcto crear lanzadera
            if(valido){
                //Consultar si es una lanzadera
                $.ajax({
                    type: 'GET',
                    contentType : 'application/json; charset=utf-8',
                    url: '/OscaArmarios/Operacion/CrearLanzadera',
                    data: { alias: $('#aliasCrear').val() , descripcion: $('#descripcionInputCrear').val() , direccionIp: $('#ipInputCrear').val()
                    ,pesoMax: $('#pMaxInputCrear').val() , nMaxEntablado: $('#nEntabladosInputCrear').val() , pAcesso: $('#pAcessoInputCrear').val()},
                    //
                    dataType: 'json',
                    async : true,
                    success: function(data){
                        window.location.reload(true);
                    }
                });
            }
        });

        $('#Borrarsubmit').click(function () {
            $.ajax({
                type: 'GET',
                contentType : 'application/json; charset=utf-8',
                url: '/OscaArmarios/Operacion/BorrarLanzadera',
                data: { idLanzadera: parseInt($("#Borrarsubmit").attr('idLanzadera'))},
                dataType: 'json',
                async : true,
                success: function(data){
                    window.location.reload(true);
                }
            });
        });

        //modificarLanzadera submit
        $('#submit').click(function () {
            $.ajax({
                type: 'GET',
                contentType : 'application/json; charset=utf-8',
                url: '/OscaArmarios/Operacion/ModificarLanzadera',
                data: { idLanzadera: parseInt($("#submit").attr('idLanzadera')),alias: $('#aliasInput').val() ,
                    descripcion: $('#descripcionInput').val() , direccionIp: $('#ipInput').val(),
                    pesoMax: $('#pMaxInput').val() , nMaxEntablado: $('#nEntabladosInput').val() , pAcesso: $('#pAcessoInput').val()
                },
                dataType: 'json',
                async : true,
                success: function(data){
                    window.location.reload(true);
                }
            });
        });
    });
</script>
</body>

</html>
