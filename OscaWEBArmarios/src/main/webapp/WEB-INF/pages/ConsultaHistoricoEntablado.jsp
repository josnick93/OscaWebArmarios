<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head style="background:#fdfcfc">
<title>Bootstrap Example</title>
    <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrapstyle.min.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link rel='stylesheet prefetch' href='css/bootstrap-table.min.css'>
    <link rel="stylesheet" href="css/jquery.mlkeyboard.css">
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
                <li style="border-right: 2px solid white">
                    <a href="/OscaArmarios/EntradaMaterialHome.html">
                        <p class="cabecera text-center">&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon glyphicon-save"></span>&nbsp;&nbsp;Entrada&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                    </a>
                </li>
                <li style="border-right: 2px solid white" class="active">
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
<div class="container" style="width: 100%;">
    <div class="form-group form-group-sm">
        <h4> <span class="right" style="float:right;">${entablado.descripcion}</span> <span class="left" style="float:left;">ENTABLADO ${entablado.id_entablado}</span> </h4>
    </div>
    <br>
    <div class="row">
            <table class="table table-bordered table-responsive" style="margin-left:2%;width:50%">
                <thead bgcolor="#fdfcfc" style="background:#626262">
                <tr>
                    <th>
                        <font color="#fdfcfc">LANZADERA</font>
                    </th>
                    <th>
                        <font color="#fdfcfc">ENTABLADO</font>
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${lanzadera.id_lanzadera}</td>
                    <td>${entablado.id_entablado}</td>
                </tr>
                </tbody>
            </table>
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-3">
                    <div id="ultimoMes"  class="btn btn-default btn-lg" style="background:#324891;border-radius:0;color:white">&Uacute;LTIMO MES</div>
                </div>
                <div class="col-md-3">
                    <div id="ultimo3Meses"  class="btn btn-default btn-lg" style="background:#324891;border-radius:0;color:white">&Uacute;LTIMOS 3 MESES</div>
                </div>
                <div class="col-md-3">
                    <div id="ultimoAño"  class="btn btn-default btn-lg" style="background:#324891;border-radius:0;color:white">&Uacute;LTIMO A&Ntilde;O</div>
                </div>
                <div class="col-md-3">
                    <div id="Todos"  class="btn btn-default btn-lg" style="background:#324891;border-radius:0;color:white">TODOS</div>
                </div>
            </div>
            <table id="table"
                   data-toggle="table"
                   data-search="false"
                   data-filter-control="true"
                   data-show-export="false"
                   data-click-to-select="false"
                   data-toolbar="#toolbar" class="table table-striped table-bordered nowrap" cellspacing="0" width="100%">
                <thead bgcolor="#fdfcfc" style="background:#626262">
                <tr>
                    <th data-field="x" data-filter-control="input" data-sortable="true" class="text-center">
                        <font color="#fdfcfc">X</font>
                    </th>
                    <th data-field="y" data-filter-control="input" data-sortable="true" class="text-center">
                        <font color="#fdfcfc">Y</font>
                    </th>
                    <th id='usuario' data-filter-control="select" data-sortable="true" class="text-center">
                        <font color="#fdfcfc">USUARIO</font>
                    </th>
                    <th data-field="tipo" data-filter-control="select" data-sortable="true" class="text-center">
                        <font color="#fdfcfc">TIPO</font>
                    </th>
                    <th data-field="articulo" data-filter-control="select" data-sortable="true" class="text-center">
                        <font color="#fdfcfc">ART&IacuteULO</font>
                    </th>
                    <th data-field="cantidad" data-filter-control="input" data-sortable="true" class="text-center">
                        <font color="#fdfcfc">CANTIDAD</font>
                    </th>
                    <th data-field="examen" data-filter-control="input" data-sortable="true" class="text-center">
                        <font color="#fdfcfc">FECHA</font>
                    </th>
                </tr>
                </thead>

                <c:if test="${!empty historico}">
                    <tbody>
                        <c:forEach items="${historico}" var="accion">
                            <tr>
                                <td class="text-center">${accion.fila}</td>
                                <td class="text-center">${accion.columna}</td>
                                <td class="text-left">${accion.usuario}</td>
                                <td class="text-center">${accion.tipoMovimiento.descripcion}</td>
                                <td class="text-center">${accion.articulo.articulo}</td>
                                <td class="text-center">${accion.cantidad}</td>
                                <td class="text-center">${accion.fecha}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </c:if>

            </table>
        </div>
        <span class="center" style='float:center'>
              <div id="volverEntablado" onclick="goBack()" class="btn btn-default btn-lg" style="background:#324891;border-radius:0;color:white">VOLVER</div>
        </span>
    </div>
</div>


<script src="js/tether.min.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="js/dataTables.bootstrap.min.js" type="text/javascript"></script>


<script src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.0/bootstrap-table.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.9.1/extensions/editable/bootstrap-table-editable.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.9.1/extensions/export/bootstrap-table-export.js'></script>
<script src='http://rawgit.com/hhurz/tableExport.jquery.plugin/master/tableExport.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.9.1/extensions/filter-control/bootstrap-table-filter-control.js'></script>
<script src="js/jquery.mlkeyboard.js"></script>
<script>

    //exporte les données sélectionnées
    var $table = $('#table');
    $(function () {
        $('#toolbar').find('select').change(function () {
            $table.bootstrapTable('refreshOptions', {
                exportDataType: $(this).val()
            });
        });
    })


    $(document).ready(function() {
        $('#usuario').mlKeyboard({layout: 'es_ES'});
        $('input#formulario-alias').mlKeyboard({layout: 'es_ES'});
        $('input#formulario-descripcion').mlKeyboard({layout: 'es_ES'});

    });

    var trBoldBlue = $("table");

    $(trBoldBlue).on("click", "tr", function (){
        $(this).toggleClass("bold-blue");
    });


    $("#ultimoMes").click(function () {
        window.location.href = "ConsultaHistoricoEntablado.html?lanzadera=" + parseInt(${lanzadera.id_lanzadera}) + "&entablado=" +parseInt(${entablado.id_entablado})
            +"&modo=1";
    });

    $("#ultimo3Meses").click(function () {
        window.location.href = "ConsultaHistoricoEntablado.html?lanzadera=" + parseInt(${lanzadera.id_lanzadera}) + "&entablado=" +parseInt(${entablado.id_entablado})
            +"&modo=2";
    });

    $("#ultimoAño").click(function () {
        window.location.href = "ConsultaHistoricoEntablado.html?lanzadera=" + parseInt(${lanzadera.id_lanzadera}) + "&entablado=" +parseInt(${entablado.id_entablado})
            +"&modo=3";
    });

    $("#Todos").click(function () {
        window.location.href = "ConsultaHistoricoEntablado.html?lanzadera=" + parseInt(${lanzadera.id_lanzadera}) + "&entablado=" +parseInt(${entablado.id_entablado})
            +"&modo=4";
    });

    //historico
    $("#volverEntablado").click(function () {
        window.location.href = "ConsultaEntablado.html?lanzadera=" + parseInt(${lanzadera.id_lanzadera}) + "&entablado=" +parseInt(${entablado.id_entablado})
            +"&modo=4";
    });


</script>


</body>

</html>