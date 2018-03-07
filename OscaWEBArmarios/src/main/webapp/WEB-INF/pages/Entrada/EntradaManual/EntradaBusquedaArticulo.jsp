<%--
  Created by IntelliJ IDEA.
  User: José Ángel Caudevílla Casaús
  Date: 08/05/2017
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Salida Seleccion Ubicacion</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrapstyle.min.css">
    <link rel="stylesheet" href="css/virtualKeyboard.css">
    <link rel="stylesheet" href="css/oscaEntrada.css">
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
<div class="text-left w-100 h-100 my-2 text-white py-5 text-uppercase">
    <div class="row">
        <div class="container" style="height:85%;text-left: center;margin-top:5%;margin-left:1%">
            <div class="col-md-5">
                <h1 class="my-3">Búsqueda de Artículo</h1>
                <form>
                    <div class="form-group">
                        <label class="Lead">Código
                            <input id="fomulario-articulo" type="text" class="form-control">
                        </label>
                    </div>
                    <div class="form-group"> <label class="Lead">Alias <input id="formulario-alias" type="text" class="form-control"></label> </div>
                    <div class="form-group"> <label class="Lead">Descripción <input id="formulario-descripcion" type="text" class="form-control"></label> </div>
                    <a id='buscar' class="btn btn-primary btn-lg text-center my-5"  style="margin-right: auto; margin-left: auto; width: 300px;background:#009900">BUSCAR</a>
                </form>
            </div>
            <div class="col-md-7">
                <h1 class="my-3"></h1>
                <div class="div-table-content">
                    <table  id="articleTable" class="table table-condensed table-bordered" cellspacing="0">
                        <thead>
                        <tr>
                            <th>Articulo</th>
                            <th>Tipo</th>
                            <th>Descripcion</th>
                        </tr>
                        </thead>
                        <tbody id="forTable">
                        </tbody>
                    </table>
                </div>
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
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<!--  -->
<script src="js/tether.min.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="js/dataTables.bootstrap.min.js" type="text/javascript"></script>
<script src="js/virtualKeyboard.js"></script>
<script type="text/javascript">
    $(document).ready(function() {

        $("body").css("overflow", "hidden");
        //go to next page with article
        $(".clickable-row2").click(function() {
            window.document.location = $(this).data("href");
        });

        //show keyboard if is lift
        if(${!empty lanzadera}) {
            $('input#fomulario-articulo').mlKeyboard({layout: 'es_ES'});
            $('input#formulario-alias').mlKeyboard({layout: 'es_ES'});
            $('input#formulario-descripcion').mlKeyboard({layout: 'es_ES'});
        }

        //enter ket pressed
        $("input").keypress(function(event) {
            if (event.which == 13) {
                event.preventDefault();
                //read formular data
                var articulo = $('#fomulario-articulo').val();
                var alias = $('#formulario-alias').val();
                var descripcion = $('#formulario-descripcion').val();
                //ajax call get data
                var tbl_body = document.createElement("tbody");
                var odd_even = false;
                $.ajax({
                    type: 'GET',
                    contentType : 'application/json; charset=utf-8',
                    url: '/OscaArmarios/Operacion/ListarArticulosEntrada',
                    data: { articulo:articulo , alias:alias , descripcion:descripcion},
                    dataType: 'json',
                    async : true,
                    beforeSend: function()
                    {
                        $('#waitDialog').modal('toggle');
                    },
                    success: function(data,status){
                        $('#waitDialog').modal('hide');
                        var eTable="";
                        for(var i=0; i<data.length;i++){
                            eTable += "<tr  style=\"cursor: pointer\" onclick=\"location.href='/OscaArmarios/EntradaSeleccionCantidadArticulo.html" +
                                "?lanzadera=${lanzadera.id_lanzadera}&articulo="+data[i]['no']+"'\">";
                            eTable += "<td>"+data[i]['no']+"</td>";
                            eTable += "<td>"+data[i]['searchDescription']+"</td>";
                            eTable += "<td>"+data[i]['description']+"</td>";
                            eTable += "</tr>";
                        }
                        $('#forTable').html(eTable);
                    },

                    error: function(data) {
                        $("#Errormsg").text(data['responseText']);
                        $('#waitDialog').modal('hide');
                        $('#errorNav').modal('toggle');
                    }
                });
            }
        });

        $("#buscar").click(function() {

            //read formular data
            var articulo = $('#fomulario-articulo').val();
            var alias = $('#formulario-alias').val();
            var descripcion = $('#formulario-descripcion').val();
            //ajax call get data
            var tbl_body = document.createElement("tbody");
            var odd_even = false;
            $.ajax({
                type: 'GET',
                contentType : 'application/json; charset=utf-8',
                url: '/OscaArmarios/Operacion/ListarArticulosEntrada',
                data: { articulo:articulo , alias:alias , descripcion:descripcion},
                dataType: 'json',
                async : true,
                beforeSend: function()
                {
                    $('#waitDialog').modal('toggle');
                },
                success: function(data,status){
                    $('#waitDialog').modal('hide');
                    var eTable="";
                    for(var i=0; i<data.length;i++){
                        eTable += "<tr  style=\"cursor: pointer\" onclick=\"location.href='/OscaArmarios/EntradaSeleccionCantidadArticulo.html" +
                            "?lanzadera=${lanzadera.id_lanzadera}&articulo="+data[i]['no']+"'\">";
                        eTable += "<td>"+data[i]['no']+"</td>";
                        eTable += "<td>"+data[i]['searchDescription']+"</td>";
                        eTable += "<td>"+data[i]['description']+"</td>";
                        eTable += "</tr>";
                    }
                    $('#forTable').html(eTable);

                },error:function(data) {
                    $("#Errormsg").text(data['responseText']);
                    $('#waitDialog').modal('hide');
                    $('#errorNav').modal('toggle');
                }
            });

        });
    });
</script>



</body>

</html>