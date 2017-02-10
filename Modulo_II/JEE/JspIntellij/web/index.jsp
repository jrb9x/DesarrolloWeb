<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<jsp:useBean id="persona" class="beans.Persona" scope="request"/>
<jsp:setProperty name="persona" property="nombre" param="paco"/>
<main>
    <header>
        <table>
            <tr>
                <td><div id="titulo">TU AGENDA</div></td>
            </tr>
        </table>
    </header>
    <section class="cuadro" id="login">
        <h2>LOGIN</h2>
        <form action="ServletCalcularEdad" method="post">
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" id="nombre" value="<jsp:getProperty name="persona" property="nombre"/>"><br>
            <label for="fecha">Fecha de Nacimiento:</label><br>
            <input type="date" name="fecha" id="fecha"><br>
            <button onclick="submit(this)">Login</button>
        </form><br>
    </section>

</main>
</body>
</html>