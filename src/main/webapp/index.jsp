<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Proyecto</title>
    <link rel="stylesheet" type="text/css" href="./styles.css">
</head>
<body>

<div class="divMaterias">
    <h1>Materias</h1>
    <table class="custom-table" id="tBodySubjects">
        <thead>
        <tr>
            <th>Nombre</th>
            <th># Actividades</th>
            <th>Nota final</th>
            <th>Opciones</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>


    <table class="custom-table">
        <thead>
        <tr>
            <th class="tituloFormulario">Nueva materia</th>
        </tr>
        </thead>
        <tbody>
        <tr class="espacioForm">
            <td class="titForm">Nombre</td>
            <td><input type="text" id="nameSubject"></td>
        </tr>

        <tr>
            <td colspan="2" align="center"> <button type="button" id="btnCreateSubject">Crear</button></td>
        </tr>
        </tbody>
    </table>
</div>

<div class="divActividades">
    <h1>Actividades de Materia</h1>
    <table class="custom-table" id="tBodyActivities">
        <thead>
        <tr>
            <th>Tipo Actividad</th>
            <th>Ponderado</th>
            <th>Fecha entrega</th>
            <th>Nota</th>
            <th>Estado</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>


    <table class="custom-table">
        <thead>
        <tr>
            <th class="tituloFormulario">Nueva actividad</th>
        </tr>
        </thead>
        <tbody>
        <div class="espacioForm">
            <tr>
                <div class="alineamientoCuerpForm">
                    <td class="cuerpForm">Tipo Actividad</td>
                    <td class="espacioForm">
                        <select id="activityType">
                            <option value="0">Taller</option>
                            <option value="1">Evaluacion</option>
                            <option value="2">Proyecto</option>
                        </select>
                    </td>
                </div>

            </tr>
            <tr>
                <td class="cuerpForm">Ponderado %</td>
                <td class="cuerpForm"><input type="text" id="weighted"></td>
            </tr>
            <tr>
                <td class="cuerpForm">Fecha de entrega</td>
                <td class="cuerpForm"><input type="date" id="deadLine"></td>
            </tr>

            <tr>
                <td colspan="2" align="center"> <button type="button" id="btnCreateActivity">Crear</button></td>
            </tr>
        </div>

        </tbody>
    </table>
</div>

<script src="./scripts.js"></script>

</body>
</html>