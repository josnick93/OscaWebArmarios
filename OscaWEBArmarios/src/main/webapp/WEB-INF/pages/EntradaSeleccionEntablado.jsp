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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bootstrap.css" type="text/css">
    <link rel="stylesheet" href="css/oscaEntrada.css">

    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css" type="text/css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/css/dataTables.bootstrap.min.css" rel="stylesheet"/>
</head>

<body>
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
            <div class="col-md-12">
                <h1 class="my-3">Selección de entablado</h1>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-12"> </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
    <script src="js/tether.min.js"></script>
    <script src="https://pingendo.com/assets/bootstrap/bootstrap-4.0.0-alpha.6.min.js"></script>

    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <form>
                    <div class="form-group"> <label class="Lead">Lanzadera<input id="fomulario-lanzadera" idtype="number" class="form-control"></label> </div>
                    <div class="form-group"> <label class="Lead">Entablado <input id="fomulario-entablado" type="number" class="form-control"></label> </div>
                    <div class="form-group"> <label class="Lead">Nombre <input id="fomulario-nombre" type="text" class="form-control"></label> </div>
                    <a class="btn btn-primary" id="buscar">Buscar</a>
                </form>
            </div>
        </div>
    </div>
</div>
<!--Diagolo muestra todos los articulos -->
<div class="modal" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="label">Selección Articulo</h4>
            </div>
            <div class="modal-body">
                <table  id="articleTable" class="table table-striped table-bordered nowrap" cellspacing="0">
                    <thead>
                    <tr>
                        <th colspan='2'>
                        </th>
                    </tr>
                    <tr>
                        <th class="text-center">Entablado</th>
                        <th class="text-center">Descripión</th>
                        <th class="text-center">Armario</th>
                    </tr>
                    </thead>
                    <tbody id="forTable">
                    </tbody></table>
                </table>
            </div>
            <div class="modal-footer"> <a class="btn btn-primary" href="#myModal" data-dismiss="modal">Cerrar</a> </div>
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
<script type="text/javascript">
    $(document).ready(function() {
        // $('#articleTable').DataTable();
        $(".clickable-row2").click(function() {
            window.document.location = $(this).data("href");
        });

        $("#buscar").click(function() {

            //read formular data
            var lanzadera = $('#fomulario-lanzadera').val();
            var entablado = $('#fomulario-entablado').val();
            var descripcion = $('#fomulario-nombre').val();
            //ajax call get data
            var tbl_body = document.createElement("tbody");
            var odd_even = false;
            $.ajax({
                type: 'GET',
                contentType : 'application/json; charset=utf-8',
                url: '/OscaArmarios/ConsultaEntablado/ListarEntablados',
                data: { lanzadera:lanzadera , entablado:entablado , descripcion:descripcion},
                dataType: 'json',
                async : true,
                beforeSend: function()
                {
                    $('#waitDialog').modal('toggle');
                },
                success: function(data,status){
                    $('#waitDialog').modal('hide');
                    $('#myModal').modal('toggle');
                    createTableByForLoop(data);

                },

                error: function()
                {
                    alert('Error');
                }
            });

        });
    });

    function createTableByForLoop(data)
    {
        var eTable="";
        for(var i=0; i<data.length;i++)
        {
            eTable += "<tr  style=\"cursor: pointer\" onclick=\"location.href='/OscaArmarios/EntradaSeleccionNuevaUbicacionFinal.html?lanzadera="+data[i]['num_lanzadera']+"&amp;entablado="+data[i]['Id_entablado']+"&amp;articulo="+${articulo.articulo}+"&amp;cantidad="+${cantidad}+"&amp;caja="+${caja}+"'\">";
            eTable += "<td>"+data[i]['descripcion']+"</td>";
            eTable += "<td> Lanzadera "+data[i]['num_lanzadera']+"</td>";
            eTable += "<td>"+1+"</td>";
            eTable += "</tr>";
        }
        $('#forTable').html(eTable);
    }
</script>
</body>

</html>
