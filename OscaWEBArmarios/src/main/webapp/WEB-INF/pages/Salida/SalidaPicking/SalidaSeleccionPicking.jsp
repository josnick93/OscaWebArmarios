<%--
  Created by IntelliJ IDEA.
  User: José Ángel Caudevílla Casaús
  Date: 08/05/2017
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        ::-webkit-scrollbar {
            width: 5em;
            height: 2em
        }
        ::-webkit-scrollbar-button {
            background: #ccc
        }
        ::-webkit-scrollbar-track-piece {
            background: #888
        }
        ::-webkit-scrollbar-thumb {
            background: #eee
        }

        table {
            table-layout: fixed;
        }

        .div-table-content {
            height: 400px;
            overflow-y: auto;
            overflow-x: hidden;
        }


    </style>
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
            background-color: #DD0000;
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
                    <li  style="border-right: 2px solid white">
                        <a href="/OscaArmarios/EntradaMaterialHome.html?lanzadera=${lanzadera.id_lanzadera}">
                            <p class="cabecera text-center">&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon glyphicon-save"></span>&nbsp;&nbsp;Entrada&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        </a>
                    </li>
                    <li  style="border-right: 2px solid white" >
                        <a href="/OscaArmarios/ConsultaMaterialHome.html?lanzadera=${lanzadera.id_lanzadera}">
                            <p class="cabecera text-center">&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon glyphicon-search"></span>&nbsp;&nbsp;Consulta&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        </a>
                    </li>
                    <li class="active" style="border-right: 2px solid white">
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
<div class="text-left w-100 h-100 my-2 text-white py-5 text-uppercase">
    <div class="row">
        <div class="col-md-5">
            <div class="container" style="height:85%;text-left: center;margin-top:5%;margin-left:1%">
                <h1 class="my-3">Consulta de Picking</h1>
                <form>
                    <div class="form-group"> <label class="Lead">CODIGO PEDIDO<input id="fomulario-pedido" type="text" class="form-control"></label> </div>
                    <div class="form-group">

                        <label class="Lead">
                            <!--<input id="formulario-localizacion" type="text" class="form-control"> -->
                           </label>
                    </div>
                    <div class="form-group">

                       <label class="Lead">
                           <!--<input id="formulario-descripcion" type="text" class="form-control"> -->
                          </label>
                    </div>
                    <a id='buscar' class="btn btn-primary btn-lg text-center my-5"  style="margin-right: auto; margin-left: auto; width: 300px;background:#DD0000">BUSCAR</a>
                </form>
            </div>
        </div>
        <div class="col-md-7">
            <h1 class="my-3"></h1>
            <div class="div-table-content">
                <table  id="articleTable" class="table table-condensed table-bordered" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Nº Pedido</th>
                        <th>Localizacion</th>
                        <th>Fecha</th>
                    </tr>
                    </thead>
                    <tbody id="forTable">
                    </tbody></table>
            </div>
        </div>
    </div>
</div>
<!--Diagolo espera -->
<div class="modal" id="waitDialog" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <p><img src="https://upload.wikimedia.org/wikipedia/commons/b/b1/Loading_icon.gif" /></p>
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

<script src="js/tether.min.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="js/dataTables.bootstrap.min.js" type="text/javascript"></script>
<script src="js/virtualKeyboard.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $("body").css("overflow", "hidden");
        // $('#articleTable').DataTable();
        $(".clickable-row2").click(function() {
            window.document.location = $(this).data("href");
        });

        $('input#fomulario-pedido').mlKeyboard({layout: 'es_ES'});
        $('input#formulario-localizacion').mlKeyboard({layout: 'es_ES'});
        $('input#formulario-descripcion').mlKeyboard({layout: 'es_ES'});


        $("input").keypress(function(event) {
            if (event.which == 13) {
                event.preventDefault();
                mostrarPedidosEntrada()
            }
        });

        $("#buscar").click(function() {
            mostrarPedidosEntrada();
        });



        function mostrarPedidosEntrada(){
            //read formular data
            var pedido = $('#fomulario-pedido').val();
            var localizacion = $('#formulario-localizacion').val();
            var descripcion = $('#formulario-descripcion').val();
            //ajax call get data
            var tbl_body = document.createElement("tbody");
            var odd_even = false;
            $.ajax({
                type: 'GET',
                contentType : 'application/json;',
                url: '/OscaArmarios/Operacion/ListarPedidosSalida',
                data: { pedido:pedido , localizacion:localizacion , descripcion:descripcion},
                dataType: 'json',
                async : true,
                beforeSend: function()
                {
                    $('#waitDialog').modal('toggle');
                },
                success: function(data,status){
                    $('#waitDialog').modal('hide');
                    //mostrar pedidos en la tabla
                    var eTable = "";
                    for (var i = data.length -1; i > 0;i--) {
                        eTable += "<tr  style=\"cursor: pointer\" onclick=\"location.href='/OscaArmarios/SalidaInfoPedido.html?pedido=" + data[i]['no'] + "'\">";
                        eTable += "<td>" + data[i]['no'] + "</td>";
                        eTable += "<td>" + data[i]['locationCode'] + "</td>";
                        eTable += "<td>" + new Date(data[i]['postingDate']).toLocaleString() + "</td>";
                        eTable += "</tr>";
                    }
                    $('#forTable').html(eTable);
                },
                error: function(data)
                {
                    $("#Errormsg").text(data['responseText']);
                    $('#waitDialog').modal('hide');
                    $('#errorNav').modal('toggle');
                }
            });
        }
    });
</script>
</body>
</html>
