<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Calcular IMC</title>
    </head>
    <body>
    <form:form action="/calcular" method="GET" modelAtributte="datos">
        <p> Altura en metros: </p> <form:input path="altura" name="al" class="form-control"/><br>
        <p> Peso en kilos: </p> <form:input path="peso" name="pe" class="form-control"/><br>

        <button type="submit"/> Calcular </button>
    </form:form>

    ${error}

    </body>
</html>
