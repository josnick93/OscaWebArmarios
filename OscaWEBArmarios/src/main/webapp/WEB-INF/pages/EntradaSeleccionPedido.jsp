<%--
  Created by IntelliJ IDEA.
  User: Portátil1
  Date: 08/05/2017
  Time: 10:59
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


    <link rel="stylesheet" href="css/jquery.mlkeyboard.css">
    <link rel="stylesheet" href="css/oscaEntrada.css">
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
            <h1 class="my-3">seleccionar pedido</h1>
            <form>
                <div class="form-group"> <label class="Lead">Código Pedido<input id="fomulario-pedido" type="text" class="form-control"></label> </div>
                <div class="form-group"> <label class="Lead">ALIAS <input id="formulario-localizacion" type="text" class="form-control"></label> </div>
                <div class="form-group"> <label class="Lead">PROVEEDOR <input id="formulario-descripcion" type="text" class="form-control"></label> </div>
                <a id='buscar' class="btn btn-primary btn-lg text-center my-5"  style="margin-right: auto; margin-left: auto; width: 300px;background:#009900">BUSCAR</a>
            </form>
        </div>
    </div>
</div>
<!--Diagolo muestra todos los articulos -->
<div class="modal" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="label">Selección pedido</h4>
            </div>
            <div class="modal-body">
                <table  id="articleTable" class="table table-striped table-bordered nowrap" cellspacing="0">
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
            <div class="modal-footer"> <a class="btn btn-primary" href="#myModal" style="margin-right: auto; margin-left: auto; width: 300px;background:#009900" data-dismiss="modal">Cerrar</a> </div>
        </div>
    </div>
</div>
<!--Diagolo espera -->
<div class="modal" id="waitDialog" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <p><img src="https://upload.wikimedia.org/wikipedia/commons/b/b1/Loading_icon.gif" /></p>
    </div>
</div>


<script src="js/tether.min.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="js/dataTables.bootstrap.min.js" type="text/javascript"></script>
<script src="js/jquery.mlkeyboard.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
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
                contentType : 'application/json; charset=utf-8',
                url: '/OscaArmarios/Operacion/ListarPedidosEntrada',
                data: { pedido:pedido , localizacion:localizacion , descripcion:descripcion},
                dataType: 'json',
                async : true,
                beforeSend: function()
                {
                    $('#waitDialog').modal('toggle');
                },
                success: function(data,status){
                    $('#waitDialog').modal('hide');
                    $('#myModal').modal('toggle');
                    //mostrar pedidos en la tabla
                    var eTable="";
                    for(var i=0; i<data.length;i++)
                    {
                        eTable += "<tr  style=\"cursor: pointer\" onclick=\"location.href='/OscaArmarios/EntradaSeleccionArticuloPedido.html?pedido="+data[i]['no']+"'\">";
                        eTable += "<td>"+data[i]['no']+"</td>";
                        eTable += "<td>"+data[i]['locationCode']+"</td>";
                        eTable += "<td>"+new Date(data[i]['postingDate']).toLocaleString()+"</td>";
                        eTable += "</tr>";
                    }
                    $('#forTable').html(eTable);
                },
                error: function()
                {

                }
            });
        }
    });
</script>



</body>

</html>
