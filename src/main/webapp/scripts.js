(()=>{
    const tbodySubjects = document.getElementById("tBodySubjects")

    const xhr = new XMLHttpRequest()

    xhr.open("GET","servlet-subject",true )

    xhr.onreadystatechange = ()=>{

        if( xhr.readyState === 4 && xhr.status === 200 ){
            const subjects = JSON.parse( xhr.responseText )
            subjects.forEach( subject => {
                const row = document.createElement("tr")

                const colName = document.createElement("td")
                colName.appendChild( document.createTextNode( subject.name ) );
                row.appendChild( colName )

                const colNActivities = document.createElement("td")
                colNActivities.appendChild( document.createTextNode(subject.numActivities ))
                row.appendChild( colNActivities )

                const colfinalScore = document.createElement("td")
                colfinalScore.appendChild( document.createTextNode(subject.finalScore))
                row.appendChild( colfinalScore )

                const colOptions = document.createElement("td")
                const buttonSee = document.createElement('button');
                buttonSee.appendChild(document.createTextNode('Ver'))
                buttonSee.addEventListener('click',()=>showActivities(subject.id))
                colOptions.appendChild( buttonSee)
                row.appendChild( colOptions )

                tbodySubjects.appendChild(row)
            })
        }
    }

    xhr.send()
})()

document.getElementById('btnCreateSubject').addEventListener('click',()=>{


    const nameSubject = document.getElementById('nameSubject').value

    const xhr = new XMLHttpRequest()

    xhr.open("POST","add-subject",true)

    xhr.onreadystatechange = ()=>{
        if( xhr.readyState === 4 && xhr.status === 200 ){
            if( xhr.responseText ){
                const subject = JSON.parse(xhr.responseText)
                alert("La materia se inserto satisfactoriamente")

                const tbodySubjects = document.getElementById('tBodySubjects')

                const row = document.createElement("tr")

                const colName = document.createElement("td")
                colName.appendChild( document.createTextNode( subject.name ) );
                row.appendChild( colName )

                const colNActivities = document.createElement("td")
                colNActivities.appendChild( document.createTextNode(subject.numActivities ))
                row.appendChild( colNActivities )

                const colfinalScore = document.createElement("td")
                colfinalScore.appendChild( document.createTextNode(subject.finalScore))
                row.appendChild( colfinalScore )

                const colOptions = document.createElement("td")
                const buttonSee = document.createElement('button');
                buttonSee.appendChild(document.createTextNode('Ver'))
                buttonSee.addEventListener('click',()=>showActivities(subject.id))
                colOptions.appendChild( buttonSee)
                row.appendChild( colOptions )

                tbodySubjects.appendChild(row)
            }else{
                console.error("Error en la solicitud:", xhr.status, xhr.statusText);
                alert("No fue posible Insertar el Registro")
            }
        }
    }

    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
    const data = `nameSubject=${nameSubject}`
    xhr.send(data)
})

// Esta función se encargará de mostrar las actividades de la materia correspondiente en la tabla de actividades.
function showActivities(subjectId) {
    const tbodyActivities = document.getElementById("tBodyActivities");
    //tbodyActivities.innerHTML = "";

    const months = ['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dec']

    const xhr2 = new XMLHttpRequest()

    xhr2.open("GET","servlet-activity",true )

    xhr2.onreadystatechange = ()=>{
        if( xhr2.readyState === 4 && xhr2.status === 200 ){
            const activities = JSON.parse( xhr2.responseText )
            activities.forEach( activity => {
                const row2 = document.createElement("tr")

                const colActivityType = document.createElement("td")
                colActivityType.appendChild( document.createTextNode( activity.activityType ) );
                row2.appendChild( colActivityType )

                const colWeighted = document.createElement("td")
                colWeighted.appendChild( document.createTextNode(activity.weighted ))
                row2.appendChild( colWeighted )

                const dealLine = activity.deadLine
                const colDeadLine = document.createElement("td")
                colDeadLine.appendChild( document.createTextNode(`${dealLine.day}-${months[dealLine.month-1]}-${dealLine.year}`))
                row2.appendChild( colDeadLine )

                const colScore = document.createElement("td")
                colScore.appendChild( document.createTextNode(activity.score))
                colScore.appendChild( colDeadLine )

                const colState = document.createElement("td")
                colState.appendChild( document.createTextNode(activity.state))
                colState.appendChild( colDeadLine )

                tbodyActivities.appendChild(row2)
            })
        }
    }

    xhr2.send()
}



