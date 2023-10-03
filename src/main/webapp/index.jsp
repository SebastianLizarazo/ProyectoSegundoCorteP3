<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>Materias</h1>
<table border="1">
    <thead>
    <tr>
        <th>Nombre</th>
        <th># Actividades</th>
        <th>Nota final</th>
        <th>Opciones</th>
    </tr>
    </thead>
    <tbody id="tBodySubjects">

    </tbody>
</table>
<button type="button" id="btnAddSubject">Agregar materia</button>

<h2>Nueva materia</h2>
<table border="1">
    <thead>
    <tr>
        <th colspan="5">Datos de la materia</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>Nombre</td>
        <td><input type="text" id="nameSubject"></td>
    </tr>

    <tr>
        <td colspan="2" align="center"> <button type="button" id="btnCreateSubject">Crear</button></td>
    </tr>
    </tbody>
</table>

<h1>Actividades de Materia</h1>
<table border="1">
    <thead>
    <tr>
        <th>Tipo Actividad</th>
        <th>Ponderado</th>
        <th>Fecha entrega</th>
        <th>Nota</th>
        <th>Estado</th>
    </tr>
    </thead>
    <tbody id="tBodyActivities">

    </tbody>
</table>
<button type="button" id="btnAddActivity">Agregar actividad</button>

<h2>Nueva actividad</h2>
<table border="1">
    <thead>
    <tr>
        <th colspan="5">Datos de la actividad</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>Tipo Actividad</td>
        <td>
            <select id="activityType">
                <option value="0">Taller</option>
                <option value="1">Evaluación</option>
                <option value="2">Proyecto</option>
            </select>
        </td>
    </tr>
    <tr>
        <td>Ponderado %</td>
        <td><input type="text" id="weighted"></td>
    </tr>
    <tr>
        <td>Fecha de entrega</td>
        <td><input type="date" id="deadLine"></td>
    </tr>

    <tr>
        <td colspan="2" align="center"> <button type="button" id="btnCreateActivity">Crear</button></td>
    </tr>
    </tbody>
</table>


<script src="./scripts.js"></script>

</body>
</html>