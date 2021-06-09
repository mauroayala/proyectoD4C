<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Registrarse</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="css/animate.css">

        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">

        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/jquery.timepicker.css">

        <link rel="stylesheet" href="css/flaticon.css">
        <link rel="stylesheet" href="css/style.css">
    </head>

    <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
        <div class="container">
            <a class="navbar-brand" href="index.html">Vida Saludable <span>Registro</span></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="oi oi-menu"></span>
            </button>

            <div class="collapse navbar-collapse" id="ftco-nav">
            </div>
        </div>
    </nav>

    <body>
    <div class = "container">
        <div id="loginbox" style="margin-top:120px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <form:form action="registrar" method="POST" modelAttribute="datosDeRegistro">

        <p> Email: </p> <form:input path="email" name="email" id= "email" class="form-control" type="email"/> <br>
        <p> Clave: </p> <form:input path="password" name="password" id= "password" class="form-control" type="password"/> <br>
        <p> Confirmar clave: </p> <form:input path="confirmaPassword" name="repitepassword" id= "repitepassword" class="form-control" type="password"/> <br>

        <button class="float-left read btn btn-primary" type="submit"/> Registrarse </button>

    </form:form>

            <br>
            <br>

            <c:if test="${not empty error}">
                <h4><span>${error}</span></h4>
                <br>
            </c:if>

        </div>
    </div>

    </body>
</html>
