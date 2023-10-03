(()=>{
    const tbodySubjects = document.getElementById("tBodySubjects")

    const months = ['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dec']

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
                colOptions.appendChild( document.createTextNode("----"))
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
                colOptions.appendChild( document.createTextNode("----"))
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
