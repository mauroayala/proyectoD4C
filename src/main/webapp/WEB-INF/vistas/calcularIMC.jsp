<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Calcular IMC</title>
    </head>
    <body>
    <form:form action= "/calcularIMC" method="GET" modelAttribute="datos">

        <p> Altura en metros: </p> <form:input path="altura" name="altura" id= "altura" class="form-control"/> <br>
        <p> Peso en kilos: </p> <form:input path="peso" name="peso" id= "peso" class="form-control"/> <br>

    </form:form>

    <button type="submit"/> Calcular </button>

    ${error}
    </body>
</html>
